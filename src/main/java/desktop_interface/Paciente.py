import os
import random
import threading
import time

import flet as ft
import pyodbc
from dotenv import load_dotenv
from flet import *

load_dotenv()
DB_URL=os.getenv("DB_URL_PY")


# Conexión con la bade de datos, cambia los valores para conectarse de forma local
def conexion():
    print("Estableciendo conexión a la base de datos...")
    try:
        connection = pyodbc.connect(DB_URL)
        print("Conexión exitosa")
        return connection
    except Exception as ex:
        print(ex)
        return None


locked = False
remaining_time = 30
timers = []


def main(page: Page, cedula, nombre):
    page.title = 'Programa Vacunas Panamá - Paciente'
    page.window.maximized = True
    page.window.center()
    page.bgcolor = ft.colors.BLACK
    page.padding = 0
    page.vertical_alignment = ft.MainAxisAlignment.CENTER
    page.horizontal_alignment = ft.CrossAxisAlignment.CENTER
    page.window.prevent_close = True
    page.update()

    result_container = ft.Column(
        alignment=ft.alignment.center,
        expand=True
    )

    def on_window_close(e):
        if e.data == "close":
            page.overlay.append(confirm_dialog)
            confirm_dialog.open = True
            page.update()

    page.window.on_event = on_window_close

    def yes_click(e):
        # Detener y eliminar todos los temporizadores si existen
        for timer in timers:
            timer.cancel()
        timers.clear()
        conexion().close()

        page.window.destroy()

    def no_click(e):
        confirm_dialog.open = False
        page.update()

    confirm_dialog = ft.AlertDialog(
        modal=True,
        title=ft.Text("Cerrando sesión..."),
        content=ft.Text("¿Está seguro de cerrar sesión?"),
        actions=[
            ft.ElevatedButton("Sí", on_click=yes_click),
            ft.OutlinedButton("No", on_click=no_click),
        ],
        actions_alignment=ft.MainAxisAlignment.END,
    )

    loading_ring = ft.ProgressRing(
        visible=False,
        width=50,
        height=50
    )

    remaining_time_label = ft.Text(
        f"Tiempo restante para actualizar: {remaining_time} segundos",
        size=12,
        color=ft.colors.GREY,
        visible=False
    )

    def fetch_data():  # Método para recibir la data de la vista, de forma filtrada
        conn = conexion()
        if conn is not None:
            try:
                cursor = conn.cursor()
                cursor.execute(
                    "SELECT [Nombre vacuna], [Número de dosis], [Enfermedad previene], [Fecha de aplicación], Sede, Dependencia "
                    "FROM [Vista Paciente] WHERE Cédula=?", cedula)
                data = cursor.fetchall()
                cursor.close()
                return data
            except pyodbc.Error as e:
                print(f"Error al ejecutar la consulta: {e}")
            finally:
                conn.close()
        else:
            print("No se pudo establecer la conexión a la base de datos.")
        return None

    def search_user():  # Método para crear la tabla de vacunas
        global locked, remaining_time
        if not locked:
            result_container.controls.clear()
            loading_ring.visible = True
            locked = True
            page.update()

            delay_seconds = random.uniform(2, 7)
            time.sleep(delay_seconds)

            data = fetch_data()
            table = build_table(data)
            result_container.controls.clear()
            result_container.controls.append(table)
            loading_ring.visible = False
            page.update()

            # Contador regresivo para mostrar el tiempo restante
            update_remaining_time()
            remaining_time_label.visible = True
            result_container.controls.append(remaining_time_label)
            page.update()

    def unlock_button():
        global locked, remaining_time
        locked = False
        remaining_time = 30
        remaining_time_label.visible = False
        page.update()

    def update_remaining_time():
        global remaining_time
        if remaining_time > 0:
            remaining_time -= 1
            remaining_time_label.value = f"Tiempo restante para actualizar: {remaining_time} segundos"
            page.update()
            timer = threading.Timer(1.0, update_remaining_time)
            timers.append(timer)
            timer.start()
        else:
            unlock_button()
            for timer in timers:
                timer.cancel()
            timers.clear()

    def show_message():  # Mensaje modal
        contact_dialog = ft.AlertDialog(
            modal=True,
            title=ft.Text("Contactos"),
            content=ft.Text("Ministerio de Salud (512-9100)\n" +
                            "Caja del Seguro Social (199)"),
            actions=[
                ft.TextButton("Cerrar", on_click=close_dialog)
            ],
        )
        page.overlay.append(contact_dialog)
        contact_dialog.open = True
        page.update()

    def close_dialog(e):  # Cerrar modal
        page.overlay[0].open = False
        page.update()

    def build_table(data):  # Construcción de la tabla
        if not data:
            return ft.Text("No se encontraron vacunas colocadas para este paciente.", color=ft.colors.RED, size=20)

        rows = [ft.DataRow(cells=[
            ft.DataCell(ft.Text(row[0], color="black")),
            ft.DataCell(ft.Text(row[1], color="black")),
            ft.DataCell(ft.Text(row[2], color="black")),
            ft.DataCell(ft.Text(row[3], color="black")),
            ft.DataCell(ft.Text(row[4], color="black")),
            ft.DataCell(ft.Text(row[5], color="black"))
        ]) for row in data]

        return ft.DataTable(
            width=1050,
            bgcolor=ft.colors.WHITE70,
            border=ft.border.all(2, "blue"),
            border_radius=10,
            vertical_lines=ft.BorderSide(3, "blue"),
            horizontal_lines=ft.BorderSide(1, "blue"),
            sort_column_index=0,
            sort_ascending=True,
            heading_row_color=ft.colors.BLACK12,
            heading_row_height=50,
            data_row_color={"hovered": "0x30FF0000"},
            divider_thickness=0,

            columns=[
                ft.DataColumn(ft.Text("Vacuna", text_align=ft.alignment.center, color=ft.colors.BLUE)),
                ft.DataColumn(
                    ft.Text("Número Dosis", width=53, text_align=ft.alignment.center_left, color=ft.colors.BLUE)),
                ft.DataColumn(
                    ft.Text("Enfermedad previene", width=90, text_align=ft.alignment.center, color=ft.colors.BLUE)),
                ft.DataColumn(
                    ft.Text("Fecha de aplicación año-mes-día hora:minutos:segundos", width=215,
                            text_align=ft.alignment.center, color=ft.colors.BLUE)),
                ft.DataColumn(ft.Text("Sede vacunado", text_align=ft.alignment.center, color=ft.colors.BLUE)),
                ft.DataColumn(
                    ft.Text("Dependencia Sede", width=85, text_align=ft.alignment.center, color=ft.colors.BLUE)),
            ],
            rows=rows
        )

    # Construcción de la columna de bienvenida
    body2 = ft.Container(
        ft.Column(
            controls=[
                ft.Row(height=15),
                ft.Row(controls=[
                    ft.Text("Mis Vacunas", size=30, weight=ft.FontWeight.BOLD, text_align=ft.alignment.top_center,
                            color=colors.BLUE)], alignment=ft.MainAxisAlignment.CENTER,
                    vertical_alignment=ft.CrossAxisAlignment.END),

                ft.Row([ft.ElevatedButton("Actualizar", width=120, height=50, on_click=lambda e: search_user(),
                                          color=colors.BLACK, bgcolor=colors.BLUE_200)],
                       spacing=10, alignment=ft.MainAxisAlignment.CENTER,
                       vertical_alignment=ft.CrossAxisAlignment.END),

                ft.Container(loading_ring, alignment=ft.alignment.center),
                ft.Container(result_container, alignment=ft.alignment.center, padding=ft.padding.symmetric(100)),
            ],
            expand=True
        ),
        alignment=ft.alignment.center,
        margin=ft.margin.all(0),
        bgcolor=ft.colors.WHITE,
        expand=True
    )

    # Construcción de la columna con la tabla y botón de búsqueda
    body3 = ft.Container(
        ft.Column(
            controls=[
                ft.Row(
                    controls=[
                        ft.Column(
                            controls=[
                                ft.Container(
                                    ft.Image(
                                        src='src/main/resources/images/icon1.png',
                                        width=100,
                                        height=100
                                    ),
                                    alignment=ft.alignment.center
                                ),
                                ft.Text(
                                    'Bienvenido Paciente \n' + nombre,
                                    width=200,
                                    size=30,
                                    weight='300',
                                    text_align=ft.TextAlign.CENTER,
                                ),
                            ],
                            horizontal_alignment=ft.CrossAxisAlignment.CENTER
                        )
                    ]
                ),
                ft.Row(
                    controls=[
                        ft.Column(
                            controls=[
                                ft.Container(
                                    ft.ElevatedButton(content=ft.Text("Contactanos", color=ft.colors.BLUE),
                                                      width=170, height=40, bgcolor='white',
                                                      on_click=lambda e: show_message()),
                                ),
                            ],
                            horizontal_alignment=ft.CrossAxisAlignment.CENTER
                        ),
                    ],
                    alignment=ft.MainAxisAlignment.CENTER

                ),

                ft.Row(
                    height=100
                ),
            ],
            alignment=ft.MainAxisAlignment.SPACE_EVENLY,
            horizontal_alignment=ft.CrossAxisAlignment.CENTER,
            expand=True
        ),
        bgcolor=ft.colors.BLUE,
        width=200
    )

    # Se añade los bodys al frame principal
    page.add(ft.Row([
        body3,
        body2
    ], expand=True))
    page.update()

    if cedula is None:
        def close_program():
            print("Programa terminado con error fatal")
            page.window.destroy()

        close_timer = threading.Timer(5.0, close_program)
        close_timer.start()

        error_dialog = ft.AlertDialog(
            modal=True,
            title=ft.Text("FATAL ERROR"),
            content=ft.Text("No se pudo recibir su cédula de la base de datos al momento de iniciar sesión. \n"
                            "Se procederá a cerrar esta ventana, intente nuevamente."),
            bgcolor=colors.RED_500
        )
        page.overlay.append(error_dialog)
        error_dialog.open = True
        page.update()
    else:
        threading.Thread(target=search_user).start()


# Ejemplo de uso
if __name__ == '__main__':
    import sys

    if len(sys.argv) > 1:
        cedulaP = sys.argv[1]  # Obtener la cédula desde Java como argumento de línea de comandos
        nombreP = sys.argv[2]
    else:
        cedulaP = None
        nombreP = ''

    ft.app(target=lambda page: main(page, cedulaP, nombreP))
