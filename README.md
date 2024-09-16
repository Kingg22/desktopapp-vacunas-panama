# :syringe: Proyecto de Gestión de Información sobre Vacunación en Panamá

![Imagen logo del proyecto](https://github.com/Kingg22/desktopapp-vacunas-panama/blob/8a9c61eaada5e77ada158bd032a3814ea4402b22/src/main/resources/images/operacionVacunas_logo_pequeno.png)

## Descripción

Este proyecto tiene como objetivo mejorar el control y la gestión de la información sobre vacunación en las distintas
sedes sanitarias de Panamá, tanto públicas como privadas. La implementación de este sistema permitirá optimizar el
seguimiento de las vacunaciones, mejorar la precisión de los datos y apoyar en la toma de decisiones para el control
sanitario del país. A continuación, se detallan los aspectos clave del proyecto, sus objetivos, alcance y
recomendaciones para su implementación.
Este proyecto consiste en el desarrollo de una aplicación que gestiona la información sobre vacunación en Panamá. La
solución está diseñada utilizando tecnologías como Java, Python y SQL Server, y se enfoca en varios aspectos clave,
incluyendo la precisión de los datos, la seguridad, la interoperabilidad y la facilidad de uso. Es un proyecto
universitario y solo realizamos la interfaz de usuario para pacientes, doctores y administradores por temas de tiempo.

:white_check_mark: Proyecto terminado para la universidad :white_check_mark:

:rotating_light: Proyecto deprecado. Cambiado a una [API REST Full](https://github.com/Kingg22/desktopapp-vacunas-panama/tree/refactor/api) :rotating_light:

### :pushpin: Objetivo del Proyecto

El objetivo principal del proyecto es llevar un mejor control sobre la vacunación en las distintas sedes sanitarias del
país, brindando datos precisos para combatir y tomar medidas necesarias en casos de epidemias y pandemias. Este sistema
contribuirá al Plan Nacional de Salud 2016-2025, específicamente en la Política 2, que se enfoca en ejercer el liderazgo
en salud a nivel nacional y en la integración del sistema de información de salud en las entidades públicas y privadas.

### :dart: Alcance del Proyecto

Cobertura Nacional:
La base de datos será utilizada a nivel nacional por centros médicos estatales y centros privados que deseen participar.

### :warning: Limitaciones del Proyecto

- Nuestras UI están creadas para Escritorio.
- Preferencias del usuario local de Java.
- Cifrado de datos por agregar.
- Tener algunas respuestas en caché para disminuir la carga de la base de datos.
- El proyecto fue pensando como proyecto universitario y la conexión con la base de datos no es segura.
- Las tablas en Java Swing tienen algún problema de renderizado donde los títulos y las columnas derechas se
  desfasan. Estamos investigando si fue error de implementación o del lenguaje.
- Si del proyecto creamos un ejecutable para los usuarios, este tendría que ser para escritorio y límitado a instalarlo
  incluso para el paciente consultar sus dosis 1 sola vez.
- De las reglas de vacunación en el proyecto solo implementamos: la edad mínima, intervalo entre primera y segunda
  dosis.
- El listado de vacunas (por lo tanto, enfermedades, síntomas y 1 fabricante por vacuna) fue
  del [esquema de vacunación de Panamá 2023 abril](https://www.spp.com.pa/publicaciones/documentos-interes/vacunacion/ESQUEMA-DE-VACUNACION_2023_3Abril.pdf).

### Características del proyecto
1. Recolección de Datos:
   
    Capturar información detallada sobre las vacunas, eventos supuestamente atribuibles a la vacunación e inmunización
   (ESAVI), y datos demográficos de los pacientes.
2. Gestión de Información:

   Permitir la entrada, actualización y eliminación de datos sobre vacunaciones.
3. Seguridad:

    Implementar mecanismos de seguridad para proteger la información sensible de los pacientes.
4. Interoperabilidad:

    Asegurar que la base de datos pueda integrarse con otros sistemas de información de salud.

## :rocket: Recomendaciones para la Implementación

1. Precisión en la Edad de los Pacientes:
    
   Utilizar eventos programados o jobs de SQL Server Agent para actualizar la edad de los pacientes anualmente en su cumpleaños.
2. Autocompletado de Direcciones:
   
   Implementar un sistema de autocompletado para evitar duplicidades y mejorar la precisión en la base de datos.
3. Expediente Digital:
   
   Integrar reacciones a vacunas, efectos secundarios y contraindicaciones en el expediente digital del paciente.
4. Esquemas Especiales de Vacunación:
   
    Implementar reglas de negocio para manejar esquemas especiales de vacunación para niños rezagados, mujeres embarazadas y
   otras poblaciones específicas.
5. Mejora en la Validación de Datos:
   
    Fortalecer la validación de datos en la entrada para asegurar la calidad de la información y seguridad.
6. Generación de Certificados de Vacunas:
   
   Implementar la generación de certificados de vacunas en formatos PDF, Excel.
7. Autenticación de 2 Factores:

   Añadir autenticación de dos factores vía correo electrónico para mejorar la seguridad del sistema.
8. Seguridad de la Base de Datos:
   
   Implementar timeout para consultas a la base de datos y manipulación de información, y cifrar los datos sensibles.
9. Gestión de Usuarios y Roles:
   
   Cambiar el enfoque de usuarios específicos a roles con permisos específicos, y utilizar usuarios individuales para cada
      paciente.
10. Interfaz de Usuario Portable:
    
    Desarrollar la aplicación como una solución web o de microservicios para facilitar el acceso sin necesidad de instalar
        una aplicación de escritorio.
11. Preferencias de Interfaz:
    
    Permitir personalización de la interfaz de usuario, como tamaño y tipo de letra, independiente de la plataforma y
        arquitectura.
12. Auditoría y Logs:
    
    Mantener logs de todos los eventos en la base de datos para realizar auditorías.

## :hammer_and_wrench:Tecnologías Utilizadas
- [Java](https://www.java.com/es/) - Para el desarrollo de la interfaz de usuario principal.
- [Python](https://www.python.org/) - Para el desarrollo de la interfaz de usuario de pacientes.
- [SQL Server](https://www.microsoft.com/es-mx/sql-server) - Para la gestión de la base de datos.
- [Absolute Layout](https://www.cs.brandeis.edu/~hosang/BiVoSite/API/org/netbeans/lib/awtextra/AbsoluteLayout.html) -
  Layout para posiciones fijas del GUI Building by Netbeans.
- [Bcrypt](https://docs.spring.io/spring-security/reference/features/integrations/cryptography.html) - Librería de
  Spring Security Crypto Java para el hash de contraseñas.
- [Java JWT (JSON Web Token)](https://github.com/auth0/java-jwt) - Librería de Java para utilizar tokens de JWT (method
  for representing claims securely between two parties).
- [Dotenv-Java](https://github.com/cdimascio/dotenv-java) - Librería de Java para cargar las variables de entornos .env
- [Dotenv-Python](https://github.com/theskumar/python-dotenv) - Librería de Python para cargar las variables de entorno
  .env
- [JDBC SQL Driver](https://learn.microsoft.com/en-us/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server?view=sql-server-ver16) -
  Driver para conectar con la base de datos SQL Server en Java.
- [ODBC Driver](https://github.com/mkleehammer/pyodbc) - Driver para conectar bases de datos en Python.

## :pencil: Autores

- **Rey Acosta** - _Java_ - [kingg22](https://github.com/Kingg22)
- **Patrick Villarroel** - _Python_ - [patrickvillarroel](https://github.com/patrickvillarroel)

## Conclusión

Este proyecto representa un paso significativo hacia la modernización y mejora del control de la vacunación en Panamá. A
través de la implementación de tecnologías modernas y prácticas de desarrollo robustas, se espera mejorar la eficiencia
y efectividad del sistema de salud en el manejo de la información sobre vacunación.

## :wrench: Clonación y configuración del repositorio
> [!NOTE]
> Para disfrutar de un buen ambiente para programar, necesitas [Maven](https://maven.apache.org/download.cgi), Java JDK 21, Python y pip ya instalado.

Sigue estos pasos para clonar el repositorio, configurar el entorno en tu IDE y preparar el entorno virtual de Python: 

Abre una terminal y ejecuta los siguientes comandos:
### 1. Clonar el repositorio
```bash
git clone https://github.com/Kingg22/desktopapp-vacunas-panama.git
```
### 2. Abrir el proyecto donde fue clonado el repositorio
### 3. Configurar el Entorno Virtual de Python:
```bash 
python -m venv venv
venv\Scripts\activate
```
En el segundo comando debe cambiar su terminal a (venv) o env lo que significa un entorno virtual activado.
Recomendamos el uso de un entorno virtual para evitar conflictos de librerías de python y un entorno limpio para el proyecto.
### 4. Instalar dependencias de python
```bash
pip install pyodbc flet python-dotenv
```
### 5. Personalizar su entorno
1. Crear la base de datos en sql server con el script dado, en este debe escribir las contraseñas para cada login.
2. Crear su .env incluyendo las credenciales anteriores. Debe respetar el formato para java y para python.
### 6. Verificación
Para verificar que todo ha sido configurado correctamente seguir los siguientes pasos:
1. Crear el package con Maven
  Utilizando el IDE integrado con Maven o el siguiente comando:
    ```bash
    mvn package -f ".\pom.xml"
    ```
2. Ejecutar en su consola:
    ```bash
    java -jar .\target\Programa_Vacunas_Panama-0.1-jar-with-dependencies.jar
    ```
   Cualquier error verificar la versión del Java JDK, el python venv y las rutas relativas o absolutas de los archivos.
### Configuración específica para IntelliJ IDEA
> [!NOTE]
> Para utilizar IntelliJ IDEA necesitas una licencia de [Jetbrains](https://www.jetbrains.com/idea/) posterior a los 30 días de prueba.

Posterior a los pasos anteriores:
- Configurar en Project Structure module Python:
  1. En la ventana emergente, sección SDK debe aparecer su Python venv ya configurado. Si no lo observa, cerrar IntelliJ, invalidar la caché y reiniciar.
  2. Con este SDK de Python ya listo con los pasos anteriores, en Modules estará las carpetas de Java Maven.
  3. Le damos a add Module y escogemos Python, le cargará automático el Python venv ya configurado y guardamos los cambios.
  
  Se necesita esto para que el IDE IntelliJ cargue todas las dependencias y pueda analizar el archivo .py del proyecto.
