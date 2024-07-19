package desktop_interface;

import logic.conexions.DatabaseOperaciones;
import logic.conexions.Resultados;
import logic.validations.*;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PantallaDoctor extends JFrame {

    public PantallaDoctor(JFrame parent, Usuario usuario) {
        initComponents();
        this.JPANEL_FILTRAR1 = new JTableFiltrar(jTable_Content_MisPacientes);
        this.JPANEL_FILTRAR2 = new JTableFiltrar(jTable_Content_BuscarPacientes);
        this.JPANEL_FILTRAR3 = new JTableFiltrar(jTable_Content_BuscarDosis);
        this.FONTCHOOSER_PACIENTE = new JFontChooser(this);
        this.FONTCHOOSER_INVENTARIO = new JFontChooser(this);
        this.FONTCHOOSER_ESTADISTICAS = new JFontChooser(this);
        this.FONTCHOOSER_BUSCAR_PACIENTE = new JFontChooser(this);
        this.FONTCHOOSER_BUSCAR_DOSIS = new JFontChooser(this);
        LAYOUT = (CardLayout) jPanel_contenidos_derecha.getLayout();
        PARENT_FRAME = parent;
        DB_DOCTOR = new DatabaseOperaciones();
        editarPaciente = false;
        editar = false;

        addListeners();

        JButton[] botones = {button_opcion1, button_opcion2, button_opcion3,
                button_opcion4, button_opcion5, button_opcion6, button_opcion7, button_opcion8,
                button_soporte, button_modificarDatos, button_modificarCred, button_preferencias,
                jButton_savePreferences};
        for (JButton boton : botones) {
            boton.setUI(new BasicButtonUI());
            boton.setBackground(new Color(86, 86, 86));
        }
        button_logOut.setUI(new BasicButtonUI());

        personalizarVentana(usuario);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.requestFocusInWindow();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        button_logOut = new JButton();
        button_modificarCred = new JButton();
        button_modificarDatos = new JButton();
        button_opcion1 = new JButton();
        button_opcion2 = new JButton();
        button_opcion3 = new JButton();
        button_opcion4 = new JButton();
        button_opcion5 = new JButton();
        button_opcion6 = new JButton();
        button_opcion7 = new JButton();
        button_opcion8 = new JButton();
        button_preferencias = new JButton();
        button_soporte = new JButton();
        jButton_acercar = new JButton();
        jButton_acercar1 = new JButton();
        jButton_acercar3 = new JButton();
        jButton_acercar4 = new JButton();
        jButton_acercar5 = new JButton();
        jButton_alejar = new JButton();
        jButton_alejar1 = new JButton();
        jButton_alejar3 = new JButton();
        jButton_alejar4 = new JButton();
        jButton_alejar5 = new JButton();
        jButton_buscar = new JButton();
        jButton_buscar1 = new JButton();
        jButton_buscar3 = new JButton();
        jButton_buscar4 = new JButton();
        jButton_buscar5 = new JButton();
        jButton_buscarPacienteEditar = new JButton();
        jButton_cancelar = new JButton();
        jButton_cancelar2 = new JButton();
        jButton_exportar = new JButton();
        jButton_exportar1 = new JButton();
        jButton_exportar3 = new JButton();
        jButton_exportar4 = new JButton();
        jButton_exportar5 = new JButton();
        jButton_filtros = new JButton();
        jButton_filtros1 = new JButton();
        jButton_filtros3 = new JButton();
        jButton_filtros4 = new JButton();
        jButton_filtros5 = new JButton();
        jButton_fuente = new JButton();
        jButton_fuente1 = new JButton();
        jButton_fuente3 = new JButton();
        jButton_fuente4 = new JButton();
        jButton_fuente5 = new JButton();
        jButton_insertarDosis = new JButton();
        jButton_modificar = new JButton();
        jButton_modificar1 = new JButton();
        jButton_modificar2 = new JButton();
        jButton_ordenar = new JButton();
        jButton_ordenar1 = new JButton();
        jButton_ordenar3 = new JButton();
        jButton_ordenar4 = new JButton();
        jButton_ordenar5 = new JButton();
        jButton_savePreferences = new JButton();
        jButton1_lupaIcon = new JButton();
        jButton2_lupaIcon = new JButton();
        jComboBox_buscarPaciente1 = new JComboBox<>();
        jComboBox_distrito = new JComboBox<>();
        jComboBox_distrito1 = new JComboBox<>();
        jComboBox_exportarType_preferido = new JComboBox<>();
        jComboBox_filterColumn_lote_Inventario = new JComboBox<>();
        jComboBox_filterColumn_vacuna_Estadisticas = new JComboBox<>();
        jComboBox_filterColumn_vacuna_Inventario = new JComboBox<>();
        jComboBox_lote = new JComboBox<>();
        jComboBox_num_dosis1 = new JComboBox<>();
        jComboBox_numDosis2 = new JComboBox<>();
        jComboBox_sede_preferida = new JComboBox<>();
        jComboBox_sede1 = new JComboBox<>();
        jComboBox_sede2 = new JComboBox<>();
        jComboBox_sexo = new JComboBox<>();
        jComboBox_sexo1 = new JComboBox<>();
        jComboBox_vacuna1 = new JComboBox<>();
        jComboBox_vacuna2 = new JComboBox<>();
        jDialog_modificarCred = new JDialog();
        jDialog_modificarDatos = new JDialog();
        apellido = new JLabel();
        apellido1 = new JLabel();
        cedula = new JLabel();
        cedula1 = new JLabel();
        cedula2 = new JLabel();
        cedula3 = new JLabel();
        contrasena = new JLabel();
        contrasena_anterior = new JLabel();
        correo = new JLabel();
        correo1 = new JLabel();
        direccion = new JLabel();
        direccion1 = new JLabel();
        distrito = new JLabel();
        distrito1 = new JLabel();
        errorMessage = new JLabel();
        errorMessage1 = new JLabel();
        errorMessage2 = new JLabel();
        fecha_aplicacion1 = new JLabel();
        fecha_nacimiento = new JLabel();
        fecha_nacimiento1 = new JLabel();
        icon_preferencias = new JLabel();
        icon_project = new JLabel();
        jLabel1 = new JLabel();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        jLabel12 = new JLabel();
        jLabel13 = new JLabel();
        jLabel14 = new JLabel();
        jLabel15 = new JLabel();
        jLabel16 = new JLabel();
        jLabel17 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        lote1 = new JLabel();
        nombre = new JLabel();
        nombre1 = new JLabel();
        nombreBienvenida = new JLabel();
        numDosis2 = new JLabel();
        repetir_contrasena = new JLabel();
        rolName = new JLabel();
        sede2 = new JLabel();
        sexo = new JLabel();
        sexo1 = new JLabel();
        telefono = new JLabel();
        telefono1 = new JLabel();
        titulo = new JLabel();
        titulo_contenido = new JLabel();
        titulo_contenido1 = new JLabel();
        titulo_contenido3 = new JLabel();
        titulo_contenido4 = new JLabel();
        titulo_contenido5 = new JLabel();
        titulo1 = new JLabel();
        titulo2 = new JLabel();
        titulo3 = new JLabel();
        titulo6 = new JLabel();
        usuario = new JLabel();
        usuario_nuevo = new JLabel();
        vacuna2 = new JLabel();
        background = new JPanel();
        background_dialog_modificarCred = new JPanel();
        background_dialog_modificarDatos = new JPanel();
        jPanel_agendarCita = new JPanel();
        jPanel_buscarDosis = new JPanel();
        jPanel_buscarPaciente = new JPanel();
        jPanel_contenidos_derecha = new JPanel();
        jPanel_estadisticas = new JPanel();
        jPanel_filtrarEstadistica = new JPanel();
        jPanel_filtrarInventario = new JPanel();
        jPanel_fontChooser = new JPanel();
        jPanel_insertarDosis = new JPanel();
        jPanel_inventario = new JPanel();
        jPanel_manipularPaciente = new JPanel();
        jPanel_menuOpciones = new JPanel();
        jPanel_misPacientes = new JPanel();
        jPanel_preferencias = new JPanel();
        jPanel_separador1 = new JPanel();
        jPanel_separador2 = new JPanel();
        jPanel_separador3 = new JPanel();
        jPanel_separador4 = new JPanel();
        jPanel_separador5 = new JPanel();
        jPanel_separador6 = new JPanel();
        jPanel_separador7 = new JPanel();
        jPanel_soporte = new JPanel();
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel5 = new JPanel();
        jPanel6 = new JPanel();
        jPanel7 = new JPanel();
        opcionesTabla = new JPanel();
        opcionesTabla1 = new JPanel();
        opcionesTabla3 = new JPanel();
        opcionesTabla4 = new JPanel();
        opcionesTabla5 = new JPanel();
        jPasswordField_nueva1 = new JPasswordField();
        jPasswordField_nueva2 = new JPasswordField();
        jPasswordField_vieja = new JPasswordField();
        jScrollPane_Frame = new JScrollPane();
        jScrollPane_Table1_MisPacientes = new JScrollPane();
        jScrollPane_Table2_BuscarPacientes = new JScrollPane();
        jScrollPane_Table3_Inventario = new JScrollPane();
        jScrollPane_Table4_Estadisticas = new JScrollPane();
        jScrollPane_Table5_BuscarDosis = new JScrollPane();
        jScrollPane1_modificarDatos = new JScrollPane();
        jScrollPane2_modificarCred = new JScrollPane();
        jSeparator1 = new JSeparator();
        jSeparator10 = new JSeparator();
        jSeparator11 = new JSeparator();
        jSeparator12 = new JSeparator();
        jSeparator13 = new JSeparator();
        jSeparator14 = new JSeparator();
        jSeparator15 = new JSeparator();
        jSeparator16 = new JSeparator();
        jSeparator17 = new JSeparator();
        jSeparator18 = new JSeparator();
        jSeparator19 = new JSeparator();
        jSeparator2 = new JSeparator();
        jSeparator20 = new JSeparator();
        jSeparator21 = new JSeparator();
        jSeparator22 = new JSeparator();
        jSeparator23 = new JSeparator();
        jSeparator24 = new JSeparator();
        jSeparator25 = new JSeparator();
        jSeparator26 = new JSeparator();
        jSeparator3 = new JSeparator();
        jSeparator4 = new JSeparator();
        jSeparator5 = new JSeparator();
        jSeparator6 = new JSeparator();
        jSeparator7 = new JSeparator();
        jSeparator8 = new JSeparator();
        jSeparator9 = new JSeparator();
        jTable_Content_BuscarDosis = new JTable();
        jTable_Content_BuscarPacientes = new JTable();
        jTable_Content_Estadisticas = new JTable();
        jTable_Content_Inventario = new JTable();
        jTable_Content_MisPacientes = new JTable();
        jTextArea1_indicacionesManipularPaciente = new JTextArea();
        jTextArea2_indicacionesModificarCred = new JTextArea();
        jTextArea3_indicacionesModificarDatos = new JTextArea();
        jTextArea4_indicacionesInsertarDosis = new JTextArea();
        jTextArea5_pacienteVacunar = new JTextArea();
        jTextArea6_lote = new javax.swing.JTextArea();
        jTextField_apellido = new JTextField();
        jTextField_apellido1 = new JTextField();
        jTextField_buscarPaciente = new JTextField();
        jTextField_buscarTabla1 = new JTextField();
        jTextField_buscarTabla2 = new JTextField();
        jTextField_buscarTabla3 = new JTextField();
        jTextField_buscarTabla4 = new JTextField();
        jTextField_buscarTabla5 = new JTextField();
        jTextField_cedula = new JTextField();
        jTextField_cedula1 = new JTextField();
        jTextField_cedula2 = new JTextField();
        jTextField_cedula3 = new JTextField();
        jTextField_correo = new JTextField();
        jTextField_correo1 = new JTextField();
        jTextField_direccion = new JTextField();
        jTextField_direccion1 = new JTextField();
        jTextField_fecha_fin = new JTextField();
        jTextField_fecha_inicio = new JTextField();
        jTextField_fechaAplicacion1 = new JTextField();
        jTextField_fechaNacimiento = new JTextField();
        jTextField_fechaNacimiento1 = new JTextField();
        jTextField_nombre = new JTextField();
        jTextField_nombre1 = new JTextField();
        jTextField_telefono = new JTextField();
        jTextField_telefono1 = new JTextField();
        jTextField_usuario_Viejo = new JTextField();
        jTextField_usuarioNuevo = new JTextField();

        jPanel_misPacientes.setBackground(new Color(227, 218, 201));
        jPanel_misPacientes.setLayout(new BorderLayout());

        titulo_contenido.setBackground(new Color(255, 255, 255));
        titulo_contenido.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 14));
        titulo_contenido.setHorizontalAlignment(SwingConstants.CENTER);
        titulo_contenido.setText("Resultados Obtenidos de mis pacientes");
        titulo_contenido.setHorizontalTextPosition(SwingConstants.CENTER);
        titulo_contenido.setOpaque(true);
        titulo_contenido.setPreferredSize(new Dimension(794, 17));
        jPanel_misPacientes.add(titulo_contenido, BorderLayout.NORTH);

        jScrollPane_Table1_MisPacientes.setBackground(new Color(227, 218, 201));

        jTable_Content_MisPacientes.setBackground(new Color(227, 218, 201));
        jTable_Content_MisPacientes.setFont(new Font("Roboto", Font.PLAIN, 12));
        jTable_Content_MisPacientes.setForeground(Color.black);
        jTable_Content_MisPacientes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable_Content_MisPacientes.setIntercellSpacing(new Dimension(1, 1));
        jTable_Content_MisPacientes.setPreferredSize(new Dimension(2500, 1000));
        jTable_Content_MisPacientes.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        jTable_Content_MisPacientes.setMinimumSize(new Dimension(50, 50));
        jTable_Content_MisPacientes.setRowMargin(1);
        jTable_Content_MisPacientes.setShowGrid(true);
        jTable_Content_MisPacientes.setOpaque(true);
        jTable_Content_MisPacientes.getTableHeader().setReorderingAllowed(true);
        jTable_Content_MisPacientes.setCellSelectionEnabled(true);
        jScrollPane_Table1_MisPacientes.setViewportView(jTable_Content_MisPacientes);
        jTable_Content_MisPacientes.getAccessibleContext().setAccessibleName("tabla de resultados");

        jPanel_misPacientes.add(jScrollPane_Table1_MisPacientes, BorderLayout.CENTER);

        opcionesTabla.setBackground(new Color(0, 153, 204));
        opcionesTabla.setMinimumSize(new Dimension(794, 47));
        opcionesTabla.setPreferredSize(new Dimension(794, 50));
        opcionesTabla.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        jTextField_buscarTabla1.setDocument(new LimitarCamposSeguro(25, "Buscar...")
        );
        jTextField_buscarTabla1.setText("Buscar...");
        jTextField_buscarTabla1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jTextField_buscarTabla1.setPreferredSize(new Dimension(125, 26));
        jTextField_buscarTabla1.addActionListener(this::jTextField_buscarTablaActionPerformed);
        opcionesTabla.add(jTextField_buscarTabla1);

        jButton_buscar.setBackground(new Color(204, 204, 204));
        jButton_buscar.setIcon(new ImageIcon(getClass().getResource("/images/lupa_icon.png")));
        jButton_buscar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_buscarMouseClicked(evt);
            }
        });
        opcionesTabla.add(jButton_buscar);

        jButton_acercar.setText("Acercar");
        jButton_acercar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_acercarMouseClicked(evt);
            }
        });
        opcionesTabla.add(jButton_acercar);

        jButton_alejar.setText("Alejar");
        jButton_alejar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_alejarMouseClicked(evt);
            }
        });
        opcionesTabla.add(jButton_alejar);

        jButton_ordenar.setText("Ordenar");
        jButton_ordenar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_ordenarMouseClicked(evt);
            }
        });
        opcionesTabla.add(jButton_ordenar);

        jButton_filtros.setText("Filtros");
        jButton_filtros.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_filtrosMouseClicked(evt);
            }
        });
        opcionesTabla.add(jButton_filtros);

        jButton_fuente.setText("Fuente y tamaño");
        jButton_fuente.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_fuenteMouseClicked(evt);
            }
        });
        opcionesTabla.add(jButton_fuente);

        jButton_exportar.setText("Exportar tabla");
        jButton_exportar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_exportarMouseClicked(evt);
            }
        });
        opcionesTabla.add(jButton_exportar);

        jPanel_misPacientes.add(opcionesTabla, BorderLayout.SOUTH);

        jPanel_agendarCita.setBackground(new Color(227, 218, 201));
        jPanel_agendarCita.setPreferredSize(new Dimension(794, 794));
        jPanel_agendarCita.setRequestFocusEnabled(false);
        jPanel_agendarCita.setLayout(new BorderLayout());

        jLabel9.setFont(new Font("Microsoft YaHei", Font.BOLD | Font.ITALIC, 24));
        jLabel9.setForeground(new Color(0, 204, 0));
        jLabel9.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel9.setText("Módulo en construcción...");
        jPanel_agendarCita.add(jLabel9, BorderLayout.CENTER);

        jPanel_buscarPaciente.setBackground(new Color(227, 218, 201));
        jPanel_buscarPaciente.setForeground(new Color(227, 218, 201));
        jPanel_buscarPaciente.setPreferredSize(new Dimension(794, 794));
        jPanel_buscarPaciente.addAncestorListener(new AncestorListener() {
            public void ancestorAdded(AncestorEvent evt) {
                jPanel_buscarPacienteAncestorAdded(evt);
            }

            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorRemoved(AncestorEvent evt) {
            }
        });
        jPanel_buscarPaciente.setLayout(new BoxLayout(jPanel_buscarPaciente, BoxLayout.Y_AXIS));

        jPanel2.setBackground(new Color(227, 218, 201));
        jPanel2.setMaximumSize(new Dimension(2147483647, 100));
        jPanel2.setPreferredSize(new Dimension(794, 45));
        jPanel2.setLayout(new BorderLayout());

        titulo_contenido1.setBackground(new Color(255, 255, 255));
        titulo_contenido1.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 14));
        titulo_contenido1.setHorizontalAlignment(SwingConstants.CENTER);
        titulo_contenido1.setText("Resultados Obtenidos de Pacientes");
        titulo_contenido1.setHorizontalTextPosition(SwingConstants.CENTER);
        titulo_contenido1.setOpaque(true);
        titulo_contenido1.setPreferredSize(new Dimension(550, 17));
        jPanel2.add(titulo_contenido1, BorderLayout.NORTH);

        jComboBox_buscarPaciente1.setModel(new DefaultComboBoxModel<>(new String[]{"Cédula", "Nombre completo", "Fecha de nacimiento"}));
        jComboBox_buscarPaciente1.setPreferredSize(new Dimension(150, 26));
        jPanel2.add(jComboBox_buscarPaciente1, BorderLayout.WEST);

        jTextField_buscarPaciente.setDocument(new LimitarCamposAlpha(50, "Buscar paciente..."));
        jTextField_buscarPaciente.setText("Buscar paciente...");
        RegistrarUser.handleFocusGain(jTextField_buscarPaciente, "Buscar paciente...");
        jTextField_buscarPaciente.addActionListener(this::jTextField1ActionPerformed);
        jPanel2.add(jTextField_buscarPaciente, BorderLayout.CENTER);

        jButton1_lupaIcon.setIcon(new ImageIcon(getClass().getResource("/images/lupa_icon.png")));
        jButton1_lupaIcon.setPreferredSize(new Dimension(30, 30));
        jButton1_lupaIcon.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel2.add(jButton1_lupaIcon, BorderLayout.EAST);

        jPanel_buscarPaciente.add(jPanel2);

        jScrollPane_Table2_BuscarPacientes.setBackground(new Color(227, 218, 201));

        jTable_Content_BuscarPacientes.setBackground(new Color(227, 218, 201));
        jTable_Content_BuscarPacientes.setFont(new Font("Roboto", Font.PLAIN, 12));
        jTable_Content_BuscarPacientes.setForeground(Color.black);
        jTable_Content_BuscarPacientes.setPreferredSize(new Dimension(2500, 1000));
        jTable_Content_BuscarPacientes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable_Content_BuscarPacientes.setIntercellSpacing(new Dimension(1, 1));
        jTable_Content_BuscarPacientes.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        jTable_Content_BuscarPacientes.setMinimumSize(new Dimension(50, 50));
        jTable_Content_BuscarPacientes.setRowMargin(1);
        jTable_Content_BuscarPacientes.setShowGrid(true);
        jTable_Content_BuscarPacientes.setOpaque(true);
        jTable_Content_BuscarPacientes.getTableHeader().setReorderingAllowed(true);
        jTable_Content_BuscarPacientes.setCellSelectionEnabled(true);
        jScrollPane_Table2_BuscarPacientes.setViewportView(jTable_Content_BuscarPacientes);
        jTable_Content_BuscarPacientes.getAccessibleContext().setAccessibleName("tabla de resultados");

        jPanel_buscarPaciente.add(jScrollPane_Table2_BuscarPacientes);

        opcionesTabla1.setBackground(new Color(0, 153, 204));
        opcionesTabla1.setMaximumSize(new Dimension(32767, 100));
        opcionesTabla1.setPreferredSize(new Dimension(794, 44));
        opcionesTabla1.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        jTextField_buscarTabla2.setDocument(new LimitarCamposSeguro(25, "Buscar...")
        );
        jTextField_buscarTabla2.setText("Buscar...");
        jTextField_buscarTabla2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jTextField_buscarTabla2.setPreferredSize(new Dimension(125, 26));
        jTextField_buscarTabla2.addActionListener(this::jTextField_buscarTabla1ActionPerformed);
        opcionesTabla1.add(jTextField_buscarTabla2);

        jButton_buscar1.setBackground(new Color(204, 204, 204));
        jButton_buscar1.setIcon(new ImageIcon(getClass().getResource("/images/lupa_icon.png")));
        jButton_buscar1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_buscar1MouseClicked(evt);
            }
        });
        opcionesTabla1.add(jButton_buscar1);

        jButton_acercar1.setText("Acercar");
        jButton_acercar1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_acercar1MouseClicked(evt);
            }
        });
        opcionesTabla1.add(jButton_acercar1);

        jButton_alejar1.setText("Alejar");
        jButton_alejar1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_alejar1MouseClicked(evt);
            }
        });
        opcionesTabla1.add(jButton_alejar1);

        jButton_ordenar1.setText("Ordenar");
        jButton_ordenar1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_ordenar1MouseClicked(evt);
            }
        });
        opcionesTabla1.add(jButton_ordenar1);

        jButton_filtros1.setText("Filtros");
        jButton_filtros1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_filtros1MouseClicked(evt);
            }
        });
        opcionesTabla1.add(jButton_filtros1);

        jButton_fuente1.setText("Fuente y tamaño");
        jButton_fuente1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_fuente1MouseClicked(evt);
            }
        });
        opcionesTabla1.add(jButton_fuente1);

        jButton_exportar1.setText("Exportar tabla");
        jButton_exportar1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_exportar1MouseClicked(evt);
            }
        });
        opcionesTabla1.add(jButton_exportar1);

        jPanel_buscarPaciente.add(opcionesTabla1);

        jPanel_manipularPaciente.setBackground(new Color(227, 218, 201));
        jPanel_manipularPaciente.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 100));
        jPanel_manipularPaciente.setPreferredSize(new Dimension(794, 794));
        jPanel_manipularPaciente.setLayout(new GridLayout(33, 1));

        titulo1.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
        titulo1.setForeground(new Color(0, 0, 0));
        titulo1.setHorizontalAlignment(SwingConstants.CENTER);
        titulo1.setText("Crear o Editar paciente");
        jPanel_manipularPaciente.add(titulo1);

        jTextArea1_indicacionesManipularPaciente.setBackground(new Color(227, 218, 201));
        jTextArea1_indicacionesManipularPaciente.setFont(new Font("Microsoft YaHei", Font.ITALIC, 11));
        jTextArea1_indicacionesManipularPaciente.setForeground(new Color(102, 102, 102));
        jTextArea1_indicacionesManipularPaciente.setText("Indicaciones: Si desea editar paciente utilizar el campo 'Buscar cédula a editar' , dar click en el botón buscar, si no desea modificar todo, puede dejarlo como esta. Si desea crear paciente. Utilizar directamente los campos debajo del botón 'Buscar paciente a editar...', los campos con * son obligatorios.\n");
        jTextArea1_indicacionesManipularPaciente.setBorder(null);
        jTextArea1_indicacionesManipularPaciente.setFocusable(false);
        jTextArea1_indicacionesManipularPaciente.setRequestFocusEnabled(false);
        jTextArea1_indicacionesManipularPaciente.setMinimumSize(new Dimension(616, 55));
        jTextArea1_indicacionesManipularPaciente.setPreferredSize(new Dimension(628, 55));
        jTextArea1_indicacionesManipularPaciente.setLineWrap(true);
        jTextArea1_indicacionesManipularPaciente.setWrapStyleWord(true);
        jTextArea1_indicacionesManipularPaciente.setEditable(false);
        jPanel_manipularPaciente.add(jTextArea1_indicacionesManipularPaciente);

        cedula2.setBackground(new Color(0, 0, 0));
        cedula2.setFont(new Font("Roboto", Font.PLAIN, 12));
        cedula2.setForeground(new Color(0, 0, 0));
        cedula2.setText("Buscar cédula a editar*");
        jPanel_manipularPaciente.add(cedula2);

        jTextField_cedula2.setBackground(new Color(227, 218, 201));
        jTextField_cedula2.setDocument(new LimitarCamposCedula(15, "Ingrese cédula a buscar"));
        jTextField_cedula2.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_cedula2.setForeground(Color.gray);
        jTextField_cedula2.setBorder(null);
        jTextField_cedula2.setText("Ingrese cédula a buscar");
        jTextField_cedula2.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_cedula2, "Ingrese cédula a buscar");
        jTextField_cedula2.addActionListener(this::jTextField_cedula2ActionPerformed);
        jPanel_manipularPaciente.add(jTextField_cedula2);

        jSeparator11.setBackground(new Color(0, 0, 0));
        jSeparator11.setForeground(new Color(30, 30, 30));
        jPanel_manipularPaciente.add(jSeparator11);

        jButton_buscarPacienteEditar.setText("Buscar paciente a editar...");
        jButton_buscarPacienteEditar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_buscarPacienteEditarMouseClicked(evt);
            }
        });
        jPanel_manipularPaciente.add(jButton_buscarPacienteEditar);

        nombre1.setBackground(new Color(0, 0, 0));
        nombre1.setFont(new Font("Roboto", Font.PLAIN, 12));
        nombre1.setForeground(new Color(0, 0, 0));
        nombre1.setText("Nombre *");
        jPanel_manipularPaciente.add(nombre1);

        jTextField_nombre1.setBackground(new Color(227, 218, 201));
        jTextField_nombre1.setDocument(new LimitarCamposString(50, "Ingrese el nombre"));
        jTextField_nombre1.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_nombre1.setForeground(Color.gray);
        jTextField_nombre1.setText("Ingrese el nombre");
        jTextField_nombre1.setBorder(null);
        jTextField_nombre1.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_nombre1, "Ingrese el nombre");
        jPanel_manipularPaciente.add(jTextField_nombre1);

        jSeparator4.setBackground(new Color(0, 0, 0));
        jSeparator4.setForeground(new Color(30, 30, 30));
        jPanel_manipularPaciente.add(jSeparator4);

        apellido1.setBackground(new Color(0, 0, 0));
        apellido1.setFont(new Font("Roboto", Font.PLAIN, 12));
        apellido1.setForeground(new Color(0, 0, 0));
        apellido1.setText("Apellido *");
        jPanel_manipularPaciente.add(apellido1);

        jTextField_apellido1.setBackground(new Color(227, 218, 201));
        jTextField_apellido1.setDocument(new LimitarCamposString(50, "Ingrese el apellido"));
        jTextField_apellido1.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_apellido1.setForeground(Color.gray);
        jTextField_apellido1.setBorder(null);
        jTextField_apellido1.setText("Ingrese el apellido");
        jTextField_apellido1.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_apellido1, "Ingrese el apellido");
        jPanel_manipularPaciente.add(jTextField_apellido1);

        jSeparator5.setBackground(new Color(0, 0, 0));
        jSeparator5.setForeground(new Color(30, 30, 30));
        jPanel_manipularPaciente.add(jSeparator5);

        cedula1.setBackground(new Color(0, 0, 0));
        cedula1.setFont(new Font("Roboto", Font.PLAIN, 12));
        cedula1.setForeground(new Color(0, 0, 0));
        cedula1.setText("Cédula de identidad personal *");
        jPanel_manipularPaciente.add(cedula1);

        jTextField_cedula1.setBackground(new Color(227, 218, 201));
        jTextField_cedula1.setDocument(new LimitarCamposCedula(15, "Ingrese la cédula"));
        jTextField_cedula1.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_cedula1.setForeground(Color.gray);
        jTextField_cedula1.setText("Ingrese la cédula");
        jTextField_cedula1.setBorder(null);
        jTextField_cedula1.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_cedula1, "Ingrese la cédula");
        jPanel_manipularPaciente.add(jTextField_cedula1);

        jSeparator6.setBackground(new Color(0, 0, 0));
        jSeparator6.setForeground(new Color(30, 30, 30));
        jPanel_manipularPaciente.add(jSeparator6);

        fecha_nacimiento1.setBackground(new Color(0, 0, 0));
        fecha_nacimiento1.setFont(new Font("Roboto", Font.PLAIN, 12));
        fecha_nacimiento1.setForeground(new Color(0, 0, 0));
        fecha_nacimiento1.setText("Fecha de nacimiento *");
        jPanel_manipularPaciente.add(fecha_nacimiento1);

        jTextField_fechaNacimiento1.setBackground(new Color(227, 218, 201));
        jTextField_fechaNacimiento1.setDocument(new LimitarCamposFecha(30, "Ingrese la fecha de nacimiento YYYY-MM-DD* hh:mm:ss"));
        jTextField_fechaNacimiento1.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_fechaNacimiento1.setForeground(Color.gray);
        jTextField_fechaNacimiento1.setBorder(null);
        jTextField_fechaNacimiento1.setText("Ingrese la fecha de nacimiento YYYY-MM-DD* hh:mm:ss");
        jTextField_fechaNacimiento1.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_fechaNacimiento1, "Ingrese la fecha de nacimiento YYYY-MM-DD* hh:mm:ss");
        jPanel_manipularPaciente.add(jTextField_fechaNacimiento1);

        jSeparator7.setBackground(new Color(0, 0, 0));
        jSeparator7.setForeground(new Color(30, 30, 30));
        jPanel_manipularPaciente.add(jSeparator7);

        sexo1.setBackground(new Color(0, 0, 0));
        sexo1.setFont(new Font("Roboto", Font.PLAIN, 12));
        sexo1.setForeground(new Color(0, 0, 0));
        sexo1.setText("Sexo *");
        jPanel_manipularPaciente.add(sexo1);

        jComboBox_sexo1.setBackground(Color.gray);
        jComboBox_sexo1.setFont(new Font("Roboto", Font.PLAIN, 14));
        jComboBox_sexo1.setForeground(Color.black);
        jComboBox_sexo1.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir", "Masculino", "Feminino"}));
        jPanel_manipularPaciente.add(jComboBox_sexo1);

        distrito1.setBackground(new Color(0, 0, 0));
        distrito1.setFont(new Font("Roboto", Font.PLAIN, 12));
        distrito1.setForeground(new Color(0, 0, 0));
        distrito1.setText("Distrito de residencia actual");
        jPanel_manipularPaciente.add(distrito1);

        jComboBox_distrito1.setBackground(Color.gray);
        jComboBox_distrito1.setFont(new Font("Roboto", Font.PLAIN, 14));
        jComboBox_distrito1.setForeground(Color.black);
        jComboBox_distrito1.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir", "Distrito por registrar"}));
        jPanel_manipularPaciente.add(jComboBox_distrito1);

        direccion1.setBackground(new Color(0, 0, 0));
        direccion1.setFont(new Font("Roboto", Font.PLAIN, 12));
        direccion1.setForeground(new Color(0, 0, 0));
        direccion1.setText("Dirección residencia actual");
        jPanel_manipularPaciente.add(direccion1);

        jTextField_direccion1.setBackground(new Color(227, 218, 201));
        jTextField_direccion1.setDocument(new LimitarCamposAlpha(100, "Ingrese la dirección"));
        jTextField_direccion1.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_direccion1.setForeground(Color.gray);
        jTextField_direccion1.setBorder(null);
        jTextField_direccion1.setText("Ingrese la dirección");
        jTextField_direccion1.setMaximumSize(new Dimension(2147483647, 50));
        jTextField_direccion1.addActionListener(this::jTextField_direccion1ActionPerformed);
        jPanel_manipularPaciente.add(jTextField_direccion1);

        jSeparator8.setBackground(new Color(0, 0, 0));
        jSeparator8.setForeground(new Color(30, 30, 30));
        jPanel_manipularPaciente.add(jSeparator8);

        correo1.setBackground(new Color(0, 0, 0));
        correo1.setFont(new Font("Roboto", Font.PLAIN, 12));
        correo1.setForeground(new Color(0, 0, 0));
        correo1.setText("Correo electrónico");
        jPanel_manipularPaciente.add(correo1);

        jTextField_correo1.setBackground(new Color(227, 218, 201));
        jTextField_correo1.setDocument(new LimitarCamposEmail(50, "Ingrese el correo electrónico"));
        jTextField_correo1.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_correo1.setForeground(Color.gray);
        jTextField_correo1.setBorder(null);
        jTextField_correo1.setText("Ingrese el correo electrónico");
        jTextField_correo1.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_correo1, "Ingrese el correo electrónico");
        jPanel_manipularPaciente.add(jTextField_correo1);

        jSeparator9.setBackground(new Color(0, 0, 0));
        jSeparator9.setForeground(new Color(30, 30, 30));
        jPanel_manipularPaciente.add(jSeparator9);

        telefono1.setBackground(new Color(0, 0, 0));
        telefono1.setFont(new Font("Roboto", Font.PLAIN, 12));
        telefono1.setForeground(new Color(0, 0, 0));
        telefono1.setText("Teléfono ");
        jPanel_manipularPaciente.add(telefono1);

        jTextField_telefono1.setBackground(new Color(227, 218, 201));
        jTextField_telefono1.setDocument(new LimitarCamposPhone(15, "Ingrese el código de país, el código de ciudad y el número de teléfono local"));
        jTextField_telefono1.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_telefono1.setForeground(Color.gray);
        jTextField_telefono1.setText("Ingrese el teléfono (código de país, el código de ciudad y el número de teléfono local)");
        jTextField_telefono1.setBorder(null);
        jTextField_telefono1.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_telefono1, "Ingrese el código de país, el código de ciudad y el número de teléfono local");
        jTextField_telefono1.addActionListener(this::jTextField_telefono1ActionPerformed);
        jPanel_manipularPaciente.add(jTextField_telefono1);

        jSeparator10.setBackground(new Color(0, 0, 0));
        jSeparator10.setForeground(new Color(30, 30, 30));
        jPanel_manipularPaciente.add(jSeparator10);

        errorMessage1.setFont(new Font("Roboto", Font.BOLD, 14));
        errorMessage1.setForeground(Color.red);
        errorMessage1.setHorizontalAlignment(SwingConstants.CENTER);
        errorMessage1.setText("ERROR.");
        errorMessage1.setVisible(false);
        jPanel_manipularPaciente.add(errorMessage1);

        jButton_modificar1.setBackground(new Color(0, 204, 0));
        jButton_modificar1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jButton_modificar1.setForeground(new Color(0, 0, 0));
        jButton_modificar1.setText("Modificar");
        jButton_modificar1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_modificar1MouseClicked(evt);
            }
        });
        jPanel_manipularPaciente.add(jButton_modificar1);

        jDialog_modificarDatos.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jDialog_modificarDatos.setTitle("Programa Vacunas Panamá - Modificar datos personales");
        jDialog_modificarDatos.setModal(true);
        jDialog_modificarDatos.setResizable(false);
        jDialog_modificarDatos.setIconImage(new ImageIcon(getClass().getResource("/images/Icon1.png")).getImage());
        jDialog_modificarDatos.setSize(new Dimension(450, 600));

        jScrollPane1_modificarDatos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        background_dialog_modificarDatos.setBackground(new Color(255, 255, 255));
        background_dialog_modificarDatos.setPreferredSize(new Dimension(444, 544));
        background_dialog_modificarDatos.setLayout(new AbsoluteLayout());

        titulo.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
        titulo.setForeground(new Color(0, 0, 0));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setText("Modificar datos personales");
        background_dialog_modificarDatos.add(titulo, new AbsoluteConstraints(90, 20, 269, -1));

        jTextArea3_indicacionesModificarDatos.setEditable(false);
        jTextArea3_indicacionesModificarDatos.setBackground(new Color(255, 255, 255));
        jTextArea3_indicacionesModificarDatos.setFont(new Font("Microsoft YaHei", Font.ITALIC, 11));
        jTextArea3_indicacionesModificarDatos.setForeground(new Color(102, 102, 102));
        jTextArea3_indicacionesModificarDatos.setLineWrap(true);
        jTextArea3_indicacionesModificarDatos.setText("Indicaciones: Si no desea modificar todo, puede dejarlo en blanco o como esta. Si su cédula o fecha de nacimiento esta errónea, solicita ayuda a su doctor.\n\n");
        jTextArea3_indicacionesModificarDatos.setWrapStyleWord(true);
        jTextArea3_indicacionesModificarDatos.setBorder(null);
        jTextArea3_indicacionesModificarDatos.setFocusable(false);
        jTextArea3_indicacionesModificarDatos.setRequestFocusEnabled(false);
        background_dialog_modificarDatos.add(jTextArea3_indicacionesModificarDatos, new AbsoluteConstraints(30, 40, 390, 50));

        nombre.setBackground(new Color(0, 0, 0));
        nombre.setFont(new Font("Roboto", Font.PLAIN, 12));
        nombre.setForeground(new Color(0, 0, 0));
        nombre.setText("Nombre *");
        background_dialog_modificarDatos.add(nombre, new AbsoluteConstraints(30, 90, -1, -1));

        jTextField_nombre.setBackground(new Color(255, 255, 255));
        jTextField_nombre.setDocument(new LimitarCamposString(50, "Ingrese su nombre"));
        jTextField_nombre.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_nombre.setForeground(Color.gray);
        jTextField_nombre.setText("Ingrese su nombre");
        jTextField_nombre.setBorder(null);
        jTextField_nombre.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_nombre, "Ingrese su nombre");
        background_dialog_modificarDatos.add(jTextField_nombre, new AbsoluteConstraints(30, 110, 390, -1));

        jSeparator18.setForeground(new Color(30, 30, 30));
        background_dialog_modificarDatos.add(jSeparator18, new AbsoluteConstraints(30, 130, 390, 21));

        apellido.setBackground(new Color(0, 0, 0));
        apellido.setFont(new Font("Roboto", Font.PLAIN, 12));
        apellido.setForeground(new Color(0, 0, 0));
        apellido.setText("Apellido *");
        background_dialog_modificarDatos.add(apellido, new AbsoluteConstraints(30, 140, -1, -1));

        jTextField_apellido.setBackground(new Color(255, 255, 255));
        jTextField_apellido.setDocument(new LimitarCamposString(50, "Ingrese su apellido"));
        jTextField_apellido.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_apellido.setForeground(Color.gray);
        jTextField_apellido.setText("Ingrese su apellido");
        jTextField_apellido.setBorder(null);
        jTextField_apellido.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_apellido, "Ingrese su apellido");
        background_dialog_modificarDatos.add(jTextField_apellido, new AbsoluteConstraints(30, 160, 390, -1));

        jSeparator19.setForeground(new Color(30, 30, 30));
        background_dialog_modificarDatos.add(jSeparator19, new AbsoluteConstraints(30, 180, 390, 21));

        cedula.setBackground(new Color(0, 0, 0));
        cedula.setFont(new Font("Roboto", Font.PLAIN, 12));
        cedula.setForeground(new Color(0, 0, 0));
        cedula.setText("Cédula *");
        background_dialog_modificarDatos.add(cedula, new AbsoluteConstraints(30, 190, -1, -1));

        jTextField_cedula.setEditable(false);
        jTextField_cedula.setBackground(new Color(255, 255, 255));
        jTextField_cedula.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_cedula.setForeground(Color.gray);
        jTextField_cedula.setText("Ingrese su cédula");
        jTextField_cedula.setBorder(null);
        jTextField_cedula.setEnabled(false);
        jTextField_cedula.setFocusable(false);
        jTextField_cedula.setRequestFocusEnabled(false);
        jTextField_cedula.setMaximumSize(new Dimension(2147483647, 50));
        background_dialog_modificarDatos.add(jTextField_cedula, new AbsoluteConstraints(30, 210, 390, -1));

        jSeparator20.setForeground(new Color(30, 30, 30));
        background_dialog_modificarDatos.add(jSeparator20, new AbsoluteConstraints(30, 230, 390, 21));

        fecha_nacimiento.setBackground(new Color(0, 0, 0));
        fecha_nacimiento.setFont(new Font("Roboto", Font.PLAIN, 12));
        fecha_nacimiento.setForeground(new Color(0, 0, 0));
        fecha_nacimiento.setText("Fecha de nacimiento *");
        background_dialog_modificarDatos.add(fecha_nacimiento, new AbsoluteConstraints(30, 240, -1, -1));

        jTextField_fechaNacimiento.setEditable(false);
        jTextField_fechaNacimiento.setBackground(new Color(255, 255, 255));
        jTextField_fechaNacimiento.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_fechaNacimiento.setForeground(Color.gray);
        jTextField_fechaNacimiento.setText("Ingrese su fecha de nacimiento YYYY-MM-DD* hh:mm:ss");
        jTextField_fechaNacimiento.setBorder(null);
        jTextField_fechaNacimiento.setEnabled(false);
        jTextField_fechaNacimiento.setFocusable(false);
        jTextField_fechaNacimiento.setRequestFocusEnabled(false);
        jTextField_fechaNacimiento.setMaximumSize(new Dimension(2147483647, 50));
        background_dialog_modificarDatos.add(jTextField_fechaNacimiento, new AbsoluteConstraints(30, 260, 390, -1));

        jSeparator24.setForeground(new Color(30, 30, 30));
        background_dialog_modificarDatos.add(jSeparator24, new AbsoluteConstraints(30, 280, 390, 21));

        sexo.setBackground(new Color(0, 0, 0));
        sexo.setFont(new Font("Roboto", Font.PLAIN, 12));
        sexo.setForeground(new Color(0, 0, 0));
        sexo.setText("Sexo *");
        background_dialog_modificarDatos.add(sexo, new AbsoluteConstraints(30, 290, -1, -1));

        jComboBox_sexo.setBackground(Color.gray);
        jComboBox_sexo.setFont(new Font("Roboto", Font.PLAIN, 14));
        jComboBox_sexo.setForeground(Color.black);
        jComboBox_sexo.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir", "Masculino", "Feminino"}));
        background_dialog_modificarDatos.add(jComboBox_sexo, new AbsoluteConstraints(30, 308, 170, -1));

        direccion.setBackground(new Color(0, 0, 0));
        direccion.setFont(new Font("Roboto", Font.PLAIN, 12));
        direccion.setForeground(new Color(0, 0, 0));
        direccion.setText("Dirección");
        background_dialog_modificarDatos.add(direccion, new AbsoluteConstraints(30, 340, -1, -1));

        jTextField_direccion.setBackground(new Color(255, 255, 255));
        jTextField_direccion.setDocument(new LimitarCamposAlpha(100, "Ingrese su dirección"));
        jTextField_direccion.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_direccion.setForeground(Color.gray);
        jTextField_direccion.setText("Ingrese su dirección");
        jTextField_direccion.setBorder(null);
        jTextField_direccion.setMaximumSize(new Dimension(2147483647, 50));
        jTextField_direccion.addActionListener(this::jTextField_direccionActionPerformed);
        background_dialog_modificarDatos.add(jTextField_direccion, new AbsoluteConstraints(30, 360, 190, -1));

        distrito.setBackground(new Color(0, 0, 0));
        distrito.setFont(new Font("Roboto", Font.PLAIN, 12));
        distrito.setForeground(new Color(0, 0, 0));
        distrito.setText("Distrito");
        background_dialog_modificarDatos.add(distrito, new AbsoluteConstraints(230, 340, 50, -1));

        jComboBox_distrito.setBackground(Color.gray);
        jComboBox_distrito.setFont(new Font("Roboto", Font.PLAIN, 14));
        jComboBox_distrito.setForeground(Color.black);
        jComboBox_distrito.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir", "Distrito por registrar"}));
        background_dialog_modificarDatos.add(jComboBox_distrito, new AbsoluteConstraints(230, 356, 190, -1));

        jSeparator1.setForeground(new Color(30, 30, 30));
        background_dialog_modificarDatos.add(jSeparator1, new AbsoluteConstraints(30, 380, 190, 21));

        correo.setBackground(new Color(0, 0, 0));
        correo.setFont(new Font("Roboto", Font.PLAIN, 12));
        correo.setForeground(new Color(0, 0, 0));
        correo.setText("Correo electrónico");
        background_dialog_modificarDatos.add(correo, new AbsoluteConstraints(30, 390, -1, -1));

        jTextField_correo.setBackground(new Color(255, 255, 255));
        jTextField_correo.setDocument(new LimitarCamposEmail(50, "Ingrese su correo electrónico"));
        jTextField_correo.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_correo.setForeground(Color.gray);
        jTextField_correo.setText("Ingrese su correo electrónico");
        jTextField_correo.setBorder(null);
        jTextField_correo.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_correo, "Ingrese su correo electrónico");
        background_dialog_modificarDatos.add(jTextField_correo, new AbsoluteConstraints(30, 410, 390, -1));

        jSeparator21.setForeground(new Color(30, 30, 30));
        background_dialog_modificarDatos.add(jSeparator21, new AbsoluteConstraints(30, 430, 390, 21));

        jTextField_telefono.setBackground(new Color(255, 255, 255));
        jTextField_telefono.setDocument(new LimitarCamposPhone(15, "Ingrese el código de país, el código de ciudad y el número local"));
        jTextField_telefono.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_telefono.setForeground(Color.gray);
        jTextField_telefono.setText("Ingrese el código de país, el código de ciudad y el número local");
        jTextField_telefono.setBorder(null);
        jTextField_telefono.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_telefono, "Ingrese el código de país, el código de ciudad y el número local");
        jTextField_telefono.addActionListener(this::jTextField_telefonoActionPerformed);
        background_dialog_modificarDatos.add(jTextField_telefono, new AbsoluteConstraints(30, 460, 390, -1));

        telefono.setBackground(new Color(0, 0, 0));
        telefono.setFont(new Font("Roboto", Font.PLAIN, 12));
        telefono.setForeground(new Color(0, 0, 0));
        telefono.setText("Teléfono ");
        background_dialog_modificarDatos.add(telefono, new AbsoluteConstraints(30, 440, -1, -1));

        jSeparator3.setForeground(new Color(30, 30, 30));
        background_dialog_modificarDatos.add(jSeparator3, new AbsoluteConstraints(30, 480, 390, 21));

        errorMessage.setFont(new Font("Roboto", Font.BOLD, 14));
        errorMessage.setForeground(Color.red);
        errorMessage.setHorizontalAlignment(SwingConstants.CENTER);
        errorMessage.setText("ERROR.");
        errorMessage.setVisible(false);
        background_dialog_modificarDatos.add(errorMessage, new AbsoluteConstraints(30, 490, 390, -1));

        jButton_cancelar.setBackground(new Color(153, 153, 153));
        jButton_cancelar.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jButton_cancelar.setForeground(new Color(0, 0, 0));
        jButton_cancelar.setText("Cancelar");
        jButton_cancelar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_cancelarMouseClicked(evt);
            }
        });
        background_dialog_modificarDatos.add(jButton_cancelar, new AbsoluteConstraints(240, 510, -1, -1));

        jButton_modificar.setBackground(new Color(0, 204, 0));
        jButton_modificar.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jButton_modificar.setForeground(new Color(0, 0, 0));
        jButton_modificar.setText("Modificar");
        jButton_modificar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_modificarMouseClicked(evt);
            }
        });
        background_dialog_modificarDatos.add(jButton_modificar, new AbsoluteConstraints(330, 510, -1, -1));

        jScrollPane1_modificarDatos.setViewportView(background_dialog_modificarDatos);

        GroupLayout jDialog_modificarDatosLayout = new GroupLayout(jDialog_modificarDatos.getContentPane());
        jDialog_modificarDatos.getContentPane().setLayout(jDialog_modificarDatosLayout);
        jDialog_modificarDatosLayout.setHorizontalGroup(
                jDialog_modificarDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jDialog_modificarDatosLayout.createSequentialGroup()
                                .addComponent(jScrollPane1_modificarDatos)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDialog_modificarDatosLayout.setVerticalGroup(
                jDialog_modificarDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1_modificarDatos)
        );

        jPanel_inventario.setBackground(new Color(227, 218, 201));
        jPanel_inventario.setForeground(new Color(227, 218, 201));
        jPanel_inventario.setLayout(new BorderLayout());

        titulo_contenido3.setBackground(new Color(255, 255, 255));
        titulo_contenido3.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 14));
        titulo_contenido3.setHorizontalAlignment(SwingConstants.CENTER);
        titulo_contenido3.setText("Resultados Obtenidos de inventario de sede");
        titulo_contenido3.setHorizontalTextPosition(SwingConstants.CENTER);
        titulo_contenido3.setOpaque(true);
        titulo_contenido3.setPreferredSize(new Dimension(794, 17));
        jPanel_inventario.add(titulo_contenido3, BorderLayout.NORTH);

        jScrollPane_Table3_Inventario.setBackground(new Color(227, 218, 201));

        jTable_Content_Inventario.setBackground(new Color(227, 218, 201));
        jTable_Content_Inventario.setFont(new Font("Roboto", Font.PLAIN, 12));
        jTable_Content_Inventario.setForeground(Color.black);
        jTable_Content_Inventario.setPreferredSize(new Dimension(2500, 1000));
        jTable_Content_Inventario.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable_Content_Inventario.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        jTable_Content_Inventario.setMinimumSize(new Dimension(50, 50));
        jTable_Content_Inventario.setShowGrid(true);
        jTable_Content_Inventario.setOpaque(true);
        jTable_Content_Inventario.getTableHeader().setReorderingAllowed(true);
        jTable_Content_Inventario.setIntercellSpacing(new Dimension(1, 1));
        jTable_Content_Inventario.setRowMargin(1);
        jTable_Content_Inventario.setCellSelectionEnabled(true);
        jTable_Content_Inventario.getAccessibleContext().setAccessibleName("tabla de resultados");
        jScrollPane_Table3_Inventario.setViewportView(jTable_Content_Inventario);

        jPanel_inventario.add(jScrollPane_Table3_Inventario, BorderLayout.CENTER);

        opcionesTabla3.setBackground(new Color(0, 153, 204));
        opcionesTabla3.setPreferredSize(new Dimension(794, 50));
        opcionesTabla3.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        jTextField_buscarTabla3.setDocument(new LimitarCamposSeguro(25, "Buscar...")
        );
        jTextField_buscarTabla3.setText("Buscar...");
        jTextField_buscarTabla3.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jTextField_buscarTabla3.setPreferredSize(new Dimension(125, 26));
        jTextField_buscarTabla3.addActionListener(this::jTextField_buscarTabla3ActionPerformed);
        opcionesTabla3.add(jTextField_buscarTabla3);

        jButton_buscar3.setBackground(new Color(204, 204, 204));
        jButton_buscar3.setIcon(new ImageIcon(getClass().getResource("/images/lupa_icon.png")));
        jButton_buscar3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_buscar3MouseClicked(evt);
            }
        });
        opcionesTabla3.add(jButton_buscar3);

        jButton_acercar3.setText("Acercar");
        jButton_acercar3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_acercar3MouseClicked(evt);
            }
        });
        opcionesTabla3.add(jButton_acercar3);

        jButton_alejar3.setText("Alejar");
        jButton_alejar3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_alejar3MouseClicked(evt);
            }
        });
        opcionesTabla3.add(jButton_alejar3);

        jButton_ordenar3.setText("Ordenar");
        jButton_ordenar3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_ordenar3MouseClicked(evt);
            }
        });
        opcionesTabla3.add(jButton_ordenar3);

        jButton_filtros3.setText("Filtros");
        jButton_filtros3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_filtros3MouseClicked(evt);
            }
        });
        opcionesTabla3.add(jButton_filtros3);

        jButton_fuente3.setText("Fuente y tamaño");
        jButton_fuente3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_fuente3MouseClicked(evt);
            }
        });
        opcionesTabla3.add(jButton_fuente3);

        jButton_exportar3.setText("Exportar tabla");
        jButton_exportar3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_exportar3MouseClicked(evt);
            }
        });
        opcionesTabla3.add(jButton_exportar3);

        jPanel_inventario.add(opcionesTabla3, BorderLayout.SOUTH);

        jPanel_estadisticas.setBackground(new Color(227, 218, 201));
        jPanel_estadisticas.setForeground(new Color(227, 218, 201));
        jPanel_estadisticas.setLayout(new BorderLayout());

        titulo_contenido4.setBackground(new Color(255, 255, 255));
        titulo_contenido4.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 14));
        titulo_contenido4.setHorizontalAlignment(SwingConstants.CENTER);
        titulo_contenido4.setText("Resultados Obtenidos de reporte y estadísticas de su sede preferida al día de hoy");
        titulo_contenido4.setHorizontalTextPosition(SwingConstants.CENTER);
        titulo_contenido4.setOpaque(true);
        titulo_contenido4.setPreferredSize(new Dimension(794, 17));
        jPanel_estadisticas.add(titulo_contenido4, BorderLayout.NORTH);

        jScrollPane_Table4_Estadisticas.setBackground(new Color(227, 218, 201));

        jTable_Content_Estadisticas.setBackground(new Color(227, 218, 201));
        jTable_Content_Estadisticas.setFont(new Font("Roboto", Font.PLAIN, 12));
        jTable_Content_Estadisticas.setForeground(Color.black);
        jTable_Content_Estadisticas.setPreferredSize(new Dimension(2500, 1000));
        jTable_Content_Estadisticas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable_Content_Estadisticas.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        jTable_Content_Estadisticas.setMinimumSize(new Dimension(50, 50));
        jTable_Content_Estadisticas.setShowGrid(true);
        jTable_Content_Estadisticas.setOpaque(true);
        jTable_Content_Estadisticas.getTableHeader().setReorderingAllowed(true);
        jTable_Content_Estadisticas.setIntercellSpacing(new Dimension(1, 1));
        jTable_Content_Estadisticas.setRowMargin(1);
        jTable_Content_Estadisticas.setCellSelectionEnabled(true);
        jTable_Content_Estadisticas.getAccessibleContext().setAccessibleName("tabla de resultados");
        jScrollPane_Table4_Estadisticas.setViewportView(jTable_Content_Estadisticas);

        jPanel_estadisticas.add(jScrollPane_Table4_Estadisticas, BorderLayout.CENTER);

        opcionesTabla4.setBackground(new Color(0, 153, 204));
        opcionesTabla4.setPreferredSize(new Dimension(794, 50));
        opcionesTabla4.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        jTextField_buscarTabla4.setDocument(new LimitarCamposSeguro(25, "Buscar...")
        );
        jTextField_buscarTabla4.setText("Buscar...");
        jTextField_buscarTabla4.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jTextField_buscarTabla4.setPreferredSize(new Dimension(125, 26));
        jTextField_buscarTabla4.addActionListener(this::jTextField_buscarTabla4ActionPerformed);
        opcionesTabla4.add(jTextField_buscarTabla4);

        jButton_buscar4.setBackground(new Color(204, 204, 204));
        jButton_buscar4.setIcon(new ImageIcon(getClass().getResource("/images/lupa_icon.png")));
        jButton_buscar4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_buscar4MouseClicked(evt);
            }
        });
        opcionesTabla4.add(jButton_buscar4);

        jButton_acercar4.setText("Acercar");
        jButton_acercar4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_acercar4MouseClicked(evt);
            }
        });
        opcionesTabla4.add(jButton_acercar4);

        jButton_alejar4.setText("Alejar");
        jButton_alejar4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_alejar4MouseClicked(evt);
            }
        });
        opcionesTabla4.add(jButton_alejar4);

        jButton_ordenar4.setText("Ordenar");
        jButton_ordenar4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_ordenar4MouseClicked(evt);
            }
        });
        opcionesTabla4.add(jButton_ordenar4);

        jButton_filtros4.setText("Filtros");
        jButton_filtros4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_filtros4MouseClicked(evt);
            }
        });
        opcionesTabla4.add(jButton_filtros4);

        jButton_fuente4.setText("Fuente y tamaño");
        jButton_fuente4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_fuente4MouseClicked(evt);
            }
        });
        opcionesTabla4.add(jButton_fuente4);

        jButton_exportar4.setText("Exportar tabla");
        jButton_exportar4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_exportar4MouseClicked(evt);
            }
        });
        opcionesTabla4.add(jButton_exportar4);

        jPanel_estadisticas.add(opcionesTabla4, BorderLayout.SOUTH);

        jPanel_filtrarEstadistica.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel_filtrarEstadistica.setPreferredSize(new Dimension(220, 70));
        jPanel_filtrarEstadistica.setLayout(new GridLayout(2, 2));

        jSeparator13.setPreferredSize(new Dimension(100, 10));
        jPanel_filtrarEstadistica.add(jSeparator13);
        jPanel_filtrarEstadistica.add(jSeparator14);

        jLabel7.setText("Filtrar por vacuna");
        jPanel_filtrarEstadistica.add(jLabel7);

        jComboBox_filterColumn_vacuna_Estadisticas.addActionListener(this::jComboBox_filterColumn1ActionPerformed);
        jPanel_filtrarEstadistica.add(jComboBox_filterColumn_vacuna_Estadisticas);

        jPanel_soporte.setBackground(new Color(227, 218, 201));
        jPanel_soporte.setPreferredSize(new Dimension(794, 794));
        jPanel_soporte.setLayout(new BorderLayout());

        jLabel10.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
        jLabel10.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel10.setText("Preguntas frecuentes ");
        jPanel_soporte.add(jLabel10, BorderLayout.NORTH);

        jPanel5.setBackground(new Color(227, 218, 201));
        jPanel5.setLayout(new GridLayout(3, 10));
        jPanel_soporte.add(jPanel5, BorderLayout.CENTER);
        jPanel5.add(PantallaBase.createQuestionPanel("¿Cómo creo el paciente a vacunar?",
                """
                        1. Dar click al botón 'Crear/Editar pacientes'
                        2. Llene el formulario con los datos personales del paciente
                        3. Si el paciente tiene cartilla de vacunación física, dar click en 'Sí' y debe registrar cada vacuna
                        En este paso puede añadir la vacuna que se va aplicar el paciente.
                        4. Espere el mensaje de confirmación de registro."""));
        jPanel5.add(PantallaBase.createQuestionPanel("¿Cómo registro una dosis de vacuna a un paciente?",
                """
                        1. Dar click en el botón 'Buscar paciente' y buscamos con los datos al paciente a vacunar
                        2. Rellenar el formulario de la dosis, editar los campos que tienen autocompletado si es necesario
                        3. Dar click en 'Registrar' y esperar el mensaje de confirmación
                        El paciente tendrá registrada su dosis de vacuna y si es necesario, puede programar una cita para la siguiente dosis."""));
        jPanel5.add(PantallaBase.createQuestionPanel("¿Cómo buscar una dosis de vacuna del paciente o al paciente completo?",
                """
                        1. Dar click en el botón 'Buscar dosis de vacuna' y buscar con los datos del paciente y vacuna
                        2. Si la consulta no da resultados, buscar al paciente completo:s
                        2.1 Dar click en el botón 'Buscar paciente' y buscamos con los datos del paciente
                        2.2 Si aún no hay resultados esto significa que el paciente no esta registrado en el programa de vacunas y debe crearlo.
                            Refiérase a la pregunta 1 ¿Cómo creo al paciente a vacuna?"""));
        jPanel5.add(PantallaBase.createQuestionPanel("No veo el nombre de vacuna para aplicar ¿Cómo creo una vacuna nueva?",
                """
                        1. Si el nombre de la vacuna para aplicar no lo encuentra, primero verifique con otros nombres como el comercial o de laboratorio o acrónimos
                        Si aún no la encuentra, solicite al personal administrativo o informática crear la vacuna nueva
                        Por mientras puede utilizar la vacuna de nombre 'NONE - Por Registrar' para completar la jornada.
                        Recuerde actualizar la dosis del paciente con el nombre de la vacuna correcto. Ninguna dosis debe quedar con la vacuna NONE."""));
        jPanel5.add(PantallaBase.createQuestionPanel("¿Cómo programo una cita de vacunación a un paciente?",
                "Dar click en 'Agendar cita de vacuna' y rellenar el formulario basado tanto en los tiempos recomendados de la vacuna y la cómodida del paciente. Esto genera una notificación para el doctor y sede escogido."));
        jPanel5.add(PantallaBase.createQuestionPanel("¿Cómo observo el inventario de vacunas?",
                "1. Dar click en el botón 'Inventario de vacunas' y podremos ver todas las vacunas con inventario en la sede preferida\n"
                        + "Si la sede no es la que deseamos, buscar la sede en la barra de búsqueda o cambiar la preferencia del usuario. "
                        + "Refiérase a la siguiente pregunta '¿Cómo cambiar mis preferencias?'"));
        jPanel5.add(PantallaBase.createQuestionPanel("No veo ningún dato al consultar",
                """
                        Esto significa que usted puede o no estar registrado y/o no tiene ninguna vacuna aplicada.
                        Para verificar que este registrado con sus datos correctamente:
                        1. De click en el botón 'Modificar datos personales' y observe si algún dato como su cédula de identidad personal esta mal escrito, si es así, debe modificar para corregir.
                        Si a pesar de esto, no ve ningún dato, significa que no tiene ninguna vacuna registrada en el sistema. Puede acudir a su médico para registrar su cartilla de vacunación."""));
        jPanel5.add(PantallaBase.createQuestionPanel("¿Cómo cambiar mis preferencias de usuario?",
                """
                        1. Dar click en el botón 'Preferencias' y actualizamos las preferencias, de manera inicial, el sistema define la sede y el distrito en la primera.
                        Para el distrito no puede definir una preferencia.
                        Si selecciona que las campos de insertar algún dato sean en una ventana emergente siempre será así, excepto en Modificar datos personales y Modificar credenciales que son ventanas emergentes y no se puede cambiar.
                        Si tiene activada editar directo en tabla podrá editar las dosis de vacuna, datos del paciente y agregar datos en las opciones de consulta sin necesidad de usar el otro botón.
                        Si desea modificar sus datos personales o su credencial de acceso (usuario y contraseña)
                        Refiérase a la siguiente pregunta *¿Cómo cambio mis datos personales o credenciales de acceso?*"""));
        jPanel5.add(PantallaBase.createQuestionPanel("¿Cómo cambio mis datos personales o credenciales de acceso?",
                """
                        Nota: Se cambia sus datos personales, no los del paciente
                        1. Dar click en el botón 'Modificar datos personales' o 'Modificar credenciales' y editar solamente los datos que deseamos modificar.
                        Consejos: La cédula de identidad personal debe estar escrito tal cual su documento.
                        La fecha de nacimiento debe estar en el formato año - mes - día hora : minutos (la hora y minutos es opcional).
                        Si su distrito no se encuentra, puede significar que es nuevo y debe utilizar 'Distrito por registrar'. Debe informar su distrito y provincia correcta a su médico o sede para corregir.
                        El teléfono puede ser celular o fijo y debe estar los números pegados. Debe colocar su prefijo y códigos necesarios al inicio sin +.
                        Al dar click en el botón 'Actualizar' se cerrará su sesión y debe ingresar nuevamente con sus credenciales correctas.
                        Si olvido su contraseña, deberá cerrar sesión y dar click en '¿Olvidó su contraseña?'"""));
        jPanel5.revalidate();
        jPanel5.repaint();

        jLabel11.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
        jLabel11.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel11.setText("Si su duda no fue resuelta. Contacte al soporte técnico de una sede hospitalaria pública o pregunte a su doctor.");
        jPanel_soporte.add(jLabel11, BorderLayout.SOUTH);

        jPanel_filtrarInventario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel_filtrarInventario.setLayout(new GridLayout(3, 2));
        jPanel_filtrarInventario.add(jSeparator15);
        jPanel_filtrarInventario.add(jSeparator16);

        jLabel8.setText("Filtrar por lote");
        jPanel_filtrarInventario.add(jLabel8);

        jComboBox_filterColumn_vacuna_Inventario.addActionListener(this::jComboBox_filterColumn2ActionPerformed);
        jPanel_filtrarInventario.add(jComboBox_filterColumn_vacuna_Inventario);

        jLabel12.setText("Filtrar por vacuna");
        jPanel_filtrarInventario.add(jLabel12);

        jComboBox_filterColumn_lote_Inventario.addActionListener(this::jComboBox_filterColumn3ActionPerformed);
        jPanel_filtrarInventario.add(jComboBox_filterColumn_lote_Inventario);

        jPanel_buscarDosis.setBackground(new Color(227, 218, 201));
        jPanel_buscarDosis.setForeground(new Color(227, 218, 201));
        jPanel_buscarDosis.setPreferredSize(new Dimension(794, 794));
        jPanel_buscarDosis.addAncestorListener(new AncestorListener() {
            public void ancestorAdded(AncestorEvent evt) {
                jPanel_buscarDosisAncestorAdded(evt);
            }

            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorRemoved(AncestorEvent evt) {
            }
        });
        jPanel_buscarDosis.setLayout(new BoxLayout(jPanel_buscarDosis, BoxLayout.Y_AXIS));

        jPanel7.setBackground(new Color(227, 218, 201));
        jPanel7.setMaximumSize(new Dimension(2147483647, 500));
        jPanel7.setMinimumSize(new Dimension(293, 107));
        jPanel7.setPreferredSize(new Dimension(694, 125));
        jPanel7.setLayout(new BorderLayout());

        titulo_contenido5.setBackground(new Color(255, 255, 255));
        titulo_contenido5.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 14));
        titulo_contenido5.setHorizontalAlignment(SwingConstants.CENTER);
        titulo_contenido5.setText("Resultados Obtenidos de Dosis");
        titulo_contenido5.setHorizontalTextPosition(SwingConstants.CENTER);
        titulo_contenido5.setOpaque(true);
        titulo_contenido5.setPreferredSize(new Dimension(794, 17));
        jPanel7.add(titulo_contenido5, BorderLayout.NORTH);

        jPanel6.setPreferredSize(new Dimension(794, 75));
        jPanel6.setLayout(new GridLayout(5, 2, 20, 0));

        jLabel13.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jLabel13.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel13.setText("Sede");
        jPanel6.add(jLabel13);

        jComboBox_sede1.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir..."}));
        jPanel6.add(jComboBox_sede1);

        jLabel14.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jLabel14.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel14.setText("Desde");
        jPanel6.add(jLabel14);

        jTextField_fecha_inicio.setDocument(new LimitarCamposSeguro(50, "Buscar desde la fecha AAAA-MM-DD..."));
        jTextField_fecha_inicio.setText("Buscar desde la fecha AAAA-MM-DD...");
        jTextField_fecha_inicio.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        RegistrarUser.handleFocusGain(jTextField_fecha_inicio, "Buscar desde la fecha AAAA-MM-DD...");
        jPanel6.add(jTextField_fecha_inicio);

        jLabel15.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jLabel15.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel15.setText("Hasta");
        jPanel6.add(jLabel15);

        jTextField_fecha_fin.setDocument(new LimitarCamposSeguro(50, "Buscar hasta la fecha AAAA-MM-DD..."));
        jTextField_fecha_fin.setText("Buscar hasta la fecha AAAA-MM-DD...");
        jTextField_fecha_fin.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        RegistrarUser.handleFocusGain(jTextField_fecha_fin, "Buscar hasta la fecha AAAA-MM-DD...");
        jPanel6.add(jTextField_fecha_fin);

        jLabel16.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jLabel16.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel16.setText("Vacuna");
        jPanel6.add(jLabel16);

        jComboBox_vacuna1.setPreferredSize(new Dimension(150, 26));
        jComboBox_vacuna1.addActionListener(this::jComboBox3ActionPerformed);
        jPanel6.add(jComboBox_vacuna1);

        jLabel17.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jLabel17.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel17.setText("Número de Dosis");
        jPanel6.add(jLabel17);

        jComboBox_num_dosis1.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir", "Primera dosis", "Segunda dosis", "Tercera dosis", "Refuerzo", "Primer refuerzo", "Segundo refuerzo", "Dosis previa"}));
        jComboBox_num_dosis1.setPreferredSize(new Dimension(150, 26));
        jComboBox_num_dosis1.addActionListener(this::jComboBox4ActionPerformed);
        jPanel6.add(jComboBox_num_dosis1);

        jPanel7.add(jPanel6, BorderLayout.CENTER);

        jButton2_lupaIcon.setIcon(new ImageIcon(getClass().getResource("/images/lupa_icon.png")));
        jButton2_lupaIcon.setPreferredSize(new Dimension(70, 27));
        jButton2_lupaIcon.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel7.add(jButton2_lupaIcon, BorderLayout.EAST);

        jPanel_buscarDosis.add(jPanel7);

        jScrollPane_Table5_BuscarDosis.setBackground(new Color(227, 218, 201));

        jTable_Content_BuscarDosis.setBackground(new Color(227, 218, 201));
        jTable_Content_BuscarDosis.setFont(new Font("Roboto", Font.PLAIN, 12));
        jTable_Content_BuscarDosis.setForeground(Color.black);
        jTable_Content_BuscarDosis.setIntercellSpacing(new Dimension(1, 1));
        jTable_Content_BuscarDosis.setPreferredSize(new Dimension(2500, 1000));
        jTable_Content_BuscarDosis.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable_Content_BuscarDosis.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        jTable_Content_BuscarDosis.setMinimumSize(new Dimension(50, 50));
        jTable_Content_BuscarDosis.setRowMargin(1);
        jTable_Content_BuscarDosis.setShowGrid(true);
        jTable_Content_BuscarDosis.setOpaque(true);
        jTable_Content_BuscarDosis.getTableHeader().setReorderingAllowed(true);
        jTable_Content_BuscarDosis.setCellSelectionEnabled(true);
        jScrollPane_Table5_BuscarDosis.setViewportView(jTable_Content_BuscarDosis);
        jTable_Content_BuscarDosis.getAccessibleContext().setAccessibleName("tabla de resultados");

        jPanel_buscarDosis.add(jScrollPane_Table5_BuscarDosis);

        opcionesTabla5.setBackground(new Color(0, 153, 204));
        opcionesTabla5.setMaximumSize(new Dimension(32767, 100));
        opcionesTabla5.setMinimumSize(new Dimension(594, 24));
        opcionesTabla5.setPreferredSize(new Dimension(794, 44));
        opcionesTabla5.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        jTextField_buscarTabla5.setDocument(new LimitarCamposSeguro(25, "Buscar...")
        );
        jTextField_buscarTabla5.setText("Buscar...");
        jTextField_buscarTabla5.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jTextField_buscarTabla5.setPreferredSize(new Dimension(125, 26));
        RegistrarUser.handleFocusGain(jTextField_buscarTabla5, "Buscar...");
        jTextField_buscarTabla5.addActionListener(this::jTextField_buscarTabla5ActionPerformed);
        opcionesTabla5.add(jTextField_buscarTabla5);

        jButton_buscar5.setBackground(new Color(204, 204, 204));
        jButton_buscar5.setIcon(new ImageIcon(getClass().getResource("/images/lupa_icon.png")));
        jButton_buscar5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_buscar5MouseClicked(evt);
            }
        });
        opcionesTabla5.add(jButton_buscar5);

        jButton_acercar5.setText("Acercar");
        jButton_acercar5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_acercar5MouseClicked(evt);
            }
        });
        opcionesTabla5.add(jButton_acercar5);

        jButton_alejar5.setText("Alejar");
        jButton_alejar5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_alejar5MouseClicked(evt);
            }
        });
        opcionesTabla5.add(jButton_alejar5);

        jButton_ordenar5.setText("Ordenar");
        jButton_ordenar5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_ordenar5MouseClicked(evt);
            }
        });
        opcionesTabla5.add(jButton_ordenar5);

        jButton_filtros5.setText("Filtros");
        jButton_filtros5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_filtros5MouseClicked(evt);
            }
        });
        opcionesTabla5.add(jButton_filtros5);

        jButton_fuente5.setText("Fuente y tamaño");
        jButton_fuente5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_fuente5MouseClicked(evt);
            }
        });
        opcionesTabla5.add(jButton_fuente5);

        jButton_exportar5.setText("Exportar tabla");
        jButton_exportar5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_exportar5MouseClicked(evt);
            }
        });
        opcionesTabla5.add(jButton_exportar5);

        jPanel_buscarDosis.add(opcionesTabla5);

        jPanel_insertarDosis.setBackground(new Color(227, 218, 201));
        jPanel_insertarDosis.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 100));
        jPanel_insertarDosis.setPreferredSize(new Dimension(794, 794));
        jPanel_insertarDosis.setLayout(new GridLayout(19, 0));

        titulo6.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
        titulo6.setForeground(new Color(0, 0, 0));
        titulo6.setHorizontalAlignment(SwingConstants.CENTER);
        titulo6.setText("Insertar una dosis aplicada");
        jPanel_insertarDosis.add(titulo6);

        jTextArea4_indicacionesInsertarDosis.setEditable(false);
        jTextArea4_indicacionesInsertarDosis.setBackground(new Color(227, 218, 201));
        jTextArea4_indicacionesInsertarDosis.setFont(new Font("Microsoft YaHei", Font.ITALIC, 11));
        jTextArea4_indicacionesInsertarDosis.setForeground(new Color(102, 102, 102));
        jTextArea4_indicacionesInsertarDosis.setLineWrap(true);
        jTextArea4_indicacionesInsertarDosis.setText("Indicaciones: Si desea editar una dosis debe ser máximo 24 horas después de su creación y solo podrá editar datos los datos de la vacuna y dosis mas no del paciente, si desea editar este último, tendrá que eliminarse y crearse una nueva dosis en el sistema. El lote de la vacuna será cargado de forma automática con la sede y la vacuna desea. La fecha de aplicación por defecto es la hora del sistema, pero podrá cambiarla. Los campos con * son obligatorios. Si no encuentra la sede o vacuna o paciente, deberá registrarlo previo a insertar una dosis.");
        jTextArea4_indicacionesInsertarDosis.setWrapStyleWord(true);
        jTextArea4_indicacionesInsertarDosis.setBorder(null);
        jTextArea4_indicacionesInsertarDosis.setFocusable(false);
        jTextArea4_indicacionesInsertarDosis.setRequestFocusEnabled(false);
        jTextArea4_indicacionesInsertarDosis.setMinimumSize(new Dimension(616, 55));
        jTextArea4_indicacionesInsertarDosis.setPreferredSize(new Dimension(628, 55));
        jPanel_insertarDosis.add(jTextArea4_indicacionesInsertarDosis);

        cedula3.setBackground(new Color(0, 0, 0));
        cedula3.setFont(new Font("Roboto", Font.PLAIN, 12));
        cedula3.setForeground(new Color(0, 0, 0));
        cedula3.setText("Cédula *");
        jPanel_insertarDosis.add(cedula3);

        jTextField_cedula3.setBackground(new Color(227, 218, 201));
        jTextField_cedula3.setDocument(new LimitarCamposCedula(15, "Ingrese la cédula del paciente"));
        jTextField_cedula3.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_cedula3.setForeground(Color.gray);
        jTextField_cedula3.setText("Ingrese la cédula del paciente");
        jTextField_cedula3.setBorder(null);
        jTextField_cedula3.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_cedula3, "Ingrese la cédula del paciente");
        jTextField_cedula3.addActionListener(this::jTextField_cedula3ActionPerformed);
        jPanel_insertarDosis.add(jTextField_cedula3);

        jSeparator25.setBackground(new Color(0, 0, 0));
        jSeparator25.setForeground(new Color(30, 30, 30));
        jPanel_insertarDosis.add(jSeparator25);

        jTextArea5_pacienteVacunar.setVisible(false);
        jTextArea5_pacienteVacunar.setEditable(false);
        jTextArea5_pacienteVacunar.setBackground(new Color(227, 218, 201));
        jTextArea5_pacienteVacunar.setFont(new Font("Roboto", Font.PLAIN | Font.ITALIC, 12));
        jTextArea5_pacienteVacunar.setForeground(new Color(0, 0, 0));
        jTextArea5_pacienteVacunar.setLineWrap(true);
        jTextArea5_pacienteVacunar.setText("Confirmar datos del paciente a vacunar");
        jTextArea5_pacienteVacunar.setWrapStyleWord(true);
        jTextArea5_pacienteVacunar.setBorder(null);
        jTextArea5_pacienteVacunar.setFocusable(false);
        jTextArea5_pacienteVacunar.setRequestFocusEnabled(false);
        jPanel_insertarDosis.add(jTextArea5_pacienteVacunar);

        fecha_aplicacion1.setBackground(new Color(0, 0, 0));
        fecha_aplicacion1.setFont(new Font("Roboto", Font.PLAIN, 12));
        fecha_aplicacion1.setForeground(new Color(0, 0, 0));
        fecha_aplicacion1.setText("Fecha de aplicación *");
        jPanel_insertarDosis.add(fecha_aplicacion1);

        jTextField_fechaAplicacion1.setBackground(new Color(227, 218, 201));
        jTextField_fechaAplicacion1.setDocument(new LimitarCamposFecha(30, "Ingrese la fecha de aplicación YYYY-MM-DD hh:mm:ss*"));
        jTextField_fechaAplicacion1.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_fechaAplicacion1.setForeground(Color.gray);
        jTextField_fechaAplicacion1.setText("Ingrese la fecha de aplicación YYYY-MM-DD hh:mm:ss*");
        jTextField_fechaAplicacion1.setBorder(null);
        jTextField_fechaAplicacion1.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_fechaAplicacion1, "Ingrese la fecha de aplicación YYYY-MM-DD hh:mm:ss*");
        jPanel_insertarDosis.add(jTextField_fechaAplicacion1);

        jSeparator26.setBackground(new Color(0, 0, 0));
        jSeparator26.setForeground(new Color(30, 30, 30));
        jPanel_insertarDosis.add(jSeparator26);

        sede2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        sede2.setForeground(new Color(0, 0, 0));
        sede2.setHorizontalAlignment(SwingConstants.LEFT);
        sede2.setText("Sede *");
        jPanel_insertarDosis.add(sede2);

        jComboBox_sede2.setFont(new Font("Roboto", Font.PLAIN, 14));
        jComboBox_sede2.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir...", " "}));
        jPanel_insertarDosis.add(jComboBox_sede2);

        vacuna2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        vacuna2.setForeground(new Color(0, 0, 0));
        vacuna2.setHorizontalAlignment(SwingConstants.LEFT);
        vacuna2.setText("Vacuna *");
        jPanel_insertarDosis.add(vacuna2);

        jComboBox_vacuna2.setFont(new Font("Roboto", Font.PLAIN, 14));
        jComboBox_vacuna2.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir"}));
        jComboBox_vacuna2.setPreferredSize(new Dimension(150, 26));
        jComboBox_vacuna2.addActionListener(this::jComboBox_vacuna2ActionPerformed);
        jPanel_insertarDosis.add(jComboBox_vacuna2);

        numDosis2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        numDosis2.setForeground(new Color(0, 0, 0));
        numDosis2.setHorizontalAlignment(SwingConstants.LEFT);
        numDosis2.setText("Número de Dosis *");
        jPanel_insertarDosis.add(numDosis2);

        jComboBox_numDosis2.setFont(new Font("Roboto", Font.PLAIN, 14));
        jComboBox_numDosis2.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir", "Primera dosis", "Segunda dosis", "Tercera dosis", "Refuerzo", "Primer refuerzo", "Segundo refuerzo", "Dosis previa"}));
        jComboBox_numDosis2.setPreferredSize(new Dimension(150, 26));
        jPanel_insertarDosis.add(jComboBox_numDosis2);

        lote1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        lote1.setForeground(new Color(0, 0, 0));
        lote1.setHorizontalAlignment(SwingConstants.LEFT);
        lote1.setText("Lote");
        jPanel_insertarDosis.add(lote1);

        jComboBox_lote.setFont(new Font("Roboto", Font.PLAIN, 14));
        jComboBox_lote.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir"}));
        jComboBox_lote.setPreferredSize(new Dimension(150, 26));
        jComboBox_lote.addActionListener(this::jComboBox_loteActionPerformed);
        jPanel_insertarDosis.add(jComboBox_lote);

        jTextArea6_lote.setVisible(false);
        jTextArea6_lote.setEditable(false);
        jTextArea6_lote.setBackground(new Color(227, 218, 201));
        jTextArea6_lote.setFont(new Font("Roboto", Font.PLAIN, 12));
        jTextArea6_lote.setForeground(new Color(0, 0, 0));
        jTextArea6_lote.setLineWrap(true);
        jTextArea6_lote.setText("Confirmar datos del lote.");
        jTextArea6_lote.setWrapStyleWord(true);
        jTextArea6_lote.setBorder(null);
        jTextArea6_lote.setFocusable(false);
        jTextArea6_lote.setRequestFocusEnabled(false);
        jPanel_insertarDosis.add(jTextArea6_lote);

        jButton_insertarDosis.setBackground(new Color(0, 204, 0));
        jButton_insertarDosis.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jButton_insertarDosis.setForeground(new Color(0, 0, 0));
        jButton_insertarDosis.setText("Crear dosis");
        jButton_insertarDosis.setPreferredSize(new Dimension(70, 27));
        jButton_insertarDosis.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_insertarDosisMouseClicked(evt);
            }
        });
        jPanel_insertarDosis.add(jButton_insertarDosis);

        jPanel_preferencias.setBackground(new Color(227, 218, 201));
        jPanel_preferencias.setPreferredSize(new Dimension(794, 794));
        jPanel_preferencias.setLayout(new BoxLayout(jPanel_preferencias, BoxLayout.Y_AXIS));

        icon_preferencias.setIcon(new ImageIcon(getClass().getResource("/images/ajuetes3.png")));
        icon_preferencias.setHorizontalTextPosition(SwingConstants.CENTER);
        icon_preferencias.setPreferredSize(new Dimension(130, 120));
        jPanel_preferencias.add(icon_preferencias);

        titulo2.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));
        titulo2.setForeground(new Color(0, 0, 0));
        titulo2.setHorizontalAlignment(SwingConstants.CENTER);
        titulo2.setText("Preferencias");
        titulo2.setHorizontalTextPosition(SwingConstants.CENTER);
        jPanel_preferencias.add(titulo2);

        jPanel_separador1.setBackground(new Color(227, 218, 201));
        jPanel_separador1.setMaximumSize(new Dimension(32767, 25));

        GroupLayout jPanel_separador1Layout = new GroupLayout(jPanel_separador1);
        jPanel_separador1.setLayout(jPanel_separador1Layout);
        jPanel_separador1Layout.setHorizontalGroup(
                jPanel_separador1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 977, Short.MAX_VALUE)
        );
        jPanel_separador1Layout.setVerticalGroup(
                jPanel_separador1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel_preferencias.add(jPanel_separador1);

        jLabel4.setFont(new Font("Roboto", Font.PLAIN, 14));
        jLabel4.setForeground(new Color(0, 0, 0));
        jLabel4.setText("Tamaño y Fuente preferida");
        jLabel4.setHorizontalTextPosition(SwingConstants.CENTER);
        jPanel_preferencias.add(jLabel4);

        jPanel_separador2.setBackground(new Color(227, 218, 201));
        jPanel_separador2.setMaximumSize(new Dimension(32767, 15));

        GroupLayout jPanel_separador2Layout = new GroupLayout(jPanel_separador2);
        jPanel_separador2.setLayout(jPanel_separador2Layout);
        jPanel_separador2Layout.setHorizontalGroup(
                jPanel_separador2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 977, Short.MAX_VALUE)
        );
        jPanel_separador2Layout.setVerticalGroup(
                jPanel_separador2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 15, Short.MAX_VALUE)
        );

        jPanel_preferencias.add(jPanel_separador2);

        jPanel_fontChooser.setBackground(new Color(227, 218, 201));
        jPanel_fontChooser.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel_fontChooser.setMaximumSize(new Dimension(700, 250));
        jPanel_fontChooser.setPreferredSize(new Dimension(460, 250));
        jPanel_fontChooser.setLayout(new GridLayout(3, 2, 10, 10));
        jPanel_preferencias.add(jPanel_fontChooser);
        // Familia de la fuente
        JLabel familyLabel = new JLabel("Familia:");
        familyLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
        familyComboBox = new JComboBox<>(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
        familyComboBox.setFont(new Font("Roboto", Font.PLAIN, 14));
        jPanel_fontChooser.add(familyLabel);
        jPanel_fontChooser.add(familyComboBox);

        // Estilo de la fuente
        JLabel styleLabel = new JLabel("Estilo:");
        styleLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
        styleComboBox = new JComboBox<>(new String[]{"Regular", "Negrita", "Cursiva", "Negrita Cursiva"});
        styleComboBox.setFont(new Font("Roboto", Font.PLAIN, 14));
        jPanel_fontChooser.add(styleLabel);
        jPanel_fontChooser.add(styleComboBox);

        // Tamaño de la fuente
        JLabel sizeLabel = new JLabel("Tamaño:");
        sizeLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
        fontSizeSpinner = new JSpinner(new SpinnerNumberModel(12, 1, 100, 1));
        fontSizeSpinner.setFont(new Font("Roboto", Font.PLAIN, 14));
        jPanel_fontChooser.add(sizeLabel);
        jPanel_fontChooser.add(fontSizeSpinner);

        jPanel_separador3.setBackground(new Color(227, 218, 201));
        jPanel_separador3.setMaximumSize(new Dimension(32767, 25));

        GroupLayout jPanel_separador3Layout = new GroupLayout(jPanel_separador3);
        jPanel_separador3.setLayout(jPanel_separador3Layout);
        jPanel_separador3Layout.setHorizontalGroup(
                jPanel_separador3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 977, Short.MAX_VALUE)
        );
        jPanel_separador3Layout.setVerticalGroup(
                jPanel_separador3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel_preferencias.add(jPanel_separador3);

        jLabel1.setFont(new Font("Roboto", Font.PLAIN, 14));
        jLabel1.setForeground(new Color(0, 0, 0));
        jLabel1.setText("Tipo de archivo exportar preferido");
        jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
        jPanel_preferencias.add(jLabel1);

        jComboBox_exportarType_preferido.setFont(new Font("Roboto", Font.PLAIN, 14));
        jComboBox_exportarType_preferido.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir...", "CSV", "TXT", "PDF", "Excel"}));
        jComboBox_exportarType_preferido.setMaximumSize(new Dimension(367, 40));
        jComboBox_exportarType_preferido.setPreferredSize(new Dimension(190, 37));
        jPanel_preferencias.add(jComboBox_exportarType_preferido);

        jPanel_separador4.setBackground(new Color(227, 218, 201));
        jPanel_separador4.setMaximumSize(new Dimension(32767, 25));

        GroupLayout jPanel_separador4Layout = new GroupLayout(jPanel_separador4);
        jPanel_separador4.setLayout(jPanel_separador4Layout);
        jPanel_separador4Layout.setHorizontalGroup(
                jPanel_separador4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 977, Short.MAX_VALUE)
        );
        jPanel_separador4Layout.setVerticalGroup(
                jPanel_separador4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel_preferencias.add(jPanel_separador4);

        jLabel5.setFont(new Font("Roboto", Font.PLAIN, 14));
        jLabel5.setForeground(new Color(0, 0, 0));
        jLabel5.setText("Sede de salud preferida");
        jLabel5.setHorizontalTextPosition(SwingConstants.CENTER);
        jPanel_preferencias.add(jLabel5);

        jComboBox_sede_preferida.setFont(new Font("Roboto", Font.PLAIN, 14));
        jComboBox_sede_preferida.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir..."}));
        jComboBox_sede_preferida.setMaximumSize(new Dimension(567, 40));
        jComboBox_sede_preferida.setPreferredSize(new Dimension(450, 37));
        jPanel_preferencias.add(jComboBox_sede_preferida);

        jPanel_separador5.setBackground(new Color(227, 218, 201));
        jPanel_separador5.setMaximumSize(new Dimension(32767, 25));

        GroupLayout jPanel_separador5Layout = new GroupLayout(jPanel_separador5);
        jPanel_separador5.setLayout(jPanel_separador5Layout);
        jPanel_separador5Layout.setHorizontalGroup(
                jPanel_separador5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 977, Short.MAX_VALUE)
        );
        jPanel_separador5Layout.setVerticalGroup(
                jPanel_separador5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel_preferencias.add(jPanel_separador5);

        jButton_savePreferences.setFont(new Font("Roboto", Font.PLAIN, 14));
        jButton_savePreferences.setForeground(new Color(255, 255, 255));
        jButton_savePreferences.setText("Guardar preferencias");
        jButton_savePreferences.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton_savePreferences.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton_savePreferences.setMaximumSize(new Dimension(166, 48));
        jButton_savePreferences.setPreferredSize(new Dimension(166, 48));
        jButton_savePreferences.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_savePreferencesMouseClicked(evt);
            }
        });
        jPanel_preferencias.add(jButton_savePreferences);

        jDialog_modificarCred.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jDialog_modificarCred.setTitle("Programa Vacunas Panamá - Modificar credenciales");
        jDialog_modificarCred.setModal(true);
        jDialog_modificarCred.setResizable(false);
        jDialog_modificarCred.setIconImage(new ImageIcon(getClass().getResource("/images/Icon1.png")).getImage());
        jDialog_modificarCred.setSize(new Dimension(450, 550));

        jScrollPane2_modificarCred.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        background_dialog_modificarCred.setBackground(new Color(255, 255, 255));
        background_dialog_modificarCred.setPreferredSize(new Dimension(444, 494));
        background_dialog_modificarCred.setLayout(new AbsoluteLayout());

        titulo3.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
        titulo3.setForeground(new Color(0, 0, 0));
        titulo3.setHorizontalAlignment(SwingConstants.CENTER);
        titulo3.setText("Modificar credenciales de acceso");
        background_dialog_modificarCred.add(titulo3, new AbsoluteConstraints(88, 25, 269, -1));

        jTextArea2_indicacionesModificarCred.setEditable(false);
        jTextArea2_indicacionesModificarCred.setBackground(new Color(255, 255, 255));
        jTextArea2_indicacionesModificarCred.setFont(new Font("Microsoft YaHei", Font.ITALIC, 11));
        jTextArea2_indicacionesModificarCred.setForeground(new Color(102, 102, 102));
        jTextArea2_indicacionesModificarCred.setLineWrap(true);
        jTextArea2_indicacionesModificarCred.setText("Indicaciones: Para modificar las credenciales debe ingresar su usuario y contraseña anterior, si solo desea cambiar el usuario debe dejar en blanco los campos de nueva contraseña.\nDebe repetir la contraseña nueva si desea modificarla, sino no se cambiará la misma.\nSi desea modificar otro dato personal, utilice el otro botón.");
        jTextArea2_indicacionesModificarCred.setWrapStyleWord(true);
        jTextArea2_indicacionesModificarCred.setBorder(null);
        jTextArea2_indicacionesModificarCred.setFocusable(false);
        jTextArea2_indicacionesModificarCred.setRequestFocusEnabled(false);
        background_dialog_modificarCred.add(jTextArea2_indicacionesModificarCred, new AbsoluteConstraints(30, 60, 380, 100));

        usuario.setBackground(new Color(0, 0, 0));
        usuario.setFont(new Font("Roboto", Font.PLAIN, 12));
        usuario.setForeground(new Color(0, 0, 0));
        usuario.setText("Usuario anterior *");
        background_dialog_modificarCred.add(usuario, new AbsoluteConstraints(30, 170, -1, -1));

        jTextField_usuario_Viejo.setBackground(new Color(255, 255, 255));
        jTextField_usuario_Viejo.setDocument(new LimitarCamposSeguro(50, "Ingrese su usuario"));
        jTextField_usuario_Viejo.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_usuario_Viejo.setForeground(Color.gray);
        jTextField_usuario_Viejo.setText("Ingrese su usuario");
        jTextField_usuario_Viejo.setActionCommand("<Not Set>");
        jTextField_usuario_Viejo.setBorder(null);
        jTextField_usuario_Viejo.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_usuario_Viejo, "Ingrese su usuario");
        background_dialog_modificarCred.add(jTextField_usuario_Viejo, new AbsoluteConstraints(30, 190, 380, -1));

        jSeparator23.setForeground(new Color(30, 30, 30));
        background_dialog_modificarCred.add(jSeparator23, new AbsoluteConstraints(30, 210, 380, 21));

        usuario_nuevo.setBackground(new Color(0, 0, 0));
        usuario_nuevo.setFont(new Font("Roboto", Font.PLAIN, 12));
        usuario_nuevo.setForeground(new Color(0, 0, 0));
        usuario_nuevo.setText("Usuario nuevo");
        background_dialog_modificarCred.add(usuario_nuevo, new AbsoluteConstraints(30, 220, -1, -1));

        jTextField_usuarioNuevo.setBackground(new Color(255, 255, 255));
        jTextField_usuarioNuevo.setDocument(new LimitarCamposSeguro(50, "Ingrese un usuario nuevo"));
        jTextField_usuarioNuevo.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_usuarioNuevo.setForeground(Color.gray);
        jTextField_usuarioNuevo.setText("Ingrese un usuario nuevo");
        jTextField_usuarioNuevo.setActionCommand("<Not Set>");
        jTextField_usuarioNuevo.setBorder(null);
        jTextField_usuarioNuevo.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_usuarioNuevo, "Ingrese un usuario nuevo");
        background_dialog_modificarCred.add(jTextField_usuarioNuevo, new AbsoluteConstraints(30, 240, 380, -1));

        jSeparator12.setForeground(new Color(30, 30, 30));
        background_dialog_modificarCred.add(jSeparator12, new AbsoluteConstraints(30, 260, 380, 21));

        contrasena.setBackground(new Color(0, 0, 0));
        contrasena.setFont(new Font("Roboto", Font.PLAIN, 12));
        contrasena.setForeground(new Color(0, 0, 0));
        contrasena.setText("Contraseña nueva");
        background_dialog_modificarCred.add(contrasena, new AbsoluteConstraints(30, 320, -1, -1));

        jPasswordField_nueva1.setBackground(new Color(255, 255, 255));
        jPasswordField_nueva1.setDocument(new LimitarCamposSeguro(20, "Ingrese una contraseña nueva"));
        jPasswordField_nueva1.setFont(new Font("Roboto", Font.PLAIN, 14));
        jPasswordField_nueva1.setForeground(Color.gray);
        jPasswordField_nueva1.setText("Ingrese una contraseña nueva");
        jPasswordField_nueva1.setBorder(null);
        jPasswordField_nueva1.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jPasswordField_nueva1, "Ingrese una contraseña nueva");
        background_dialog_modificarCred.add(jPasswordField_nueva1, new AbsoluteConstraints(30, 340, 380, -1));

        jSeparator2.setForeground(new Color(30, 30, 30));
        background_dialog_modificarCred.add(jSeparator2, new AbsoluteConstraints(30, 360, 380, 21));

        repetir_contrasena.setBackground(new Color(0, 0, 0));
        repetir_contrasena.setFont(new Font("Roboto", Font.PLAIN, 12));
        repetir_contrasena.setForeground(new Color(0, 0, 0));
        repetir_contrasena.setText("Repetir contraseña nueva *");
        background_dialog_modificarCred.add(repetir_contrasena, new AbsoluteConstraints(30, 370, -1, -1));

        jPasswordField_nueva2.setBackground(new Color(255, 255, 255));
        jPasswordField_nueva2.setDocument(new LimitarCamposSeguro(20, "Repita su contraseña nueva"));
        jPasswordField_nueva2.setFont(new Font("Roboto", Font.PLAIN, 14));
        jPasswordField_nueva2.setForeground(Color.gray);
        jPasswordField_nueva2.setText("Repita su contraseña nueva");
        jPasswordField_nueva2.setBorder(null);
        jPasswordField_nueva2.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jPasswordField_nueva2, "Repita su contraseña nueva");
        jPasswordField_nueva2.addActionListener(this::jPasswordField_nueva2ActionPerformed);
        background_dialog_modificarCred.add(jPasswordField_nueva2, new AbsoluteConstraints(30, 390, 380, -1));

        jSeparator22.setForeground(new Color(30, 30, 30));
        background_dialog_modificarCred.add(jSeparator22, new AbsoluteConstraints(30, 410, 380, 21));

        errorMessage2.setFont(new Font("Roboto", Font.BOLD, 14));
        errorMessage2.setForeground(Color.red);
        errorMessage2.setHorizontalAlignment(SwingConstants.CENTER);
        errorMessage2.setText("Error. ");
        errorMessage2.setHorizontalTextPosition(SwingConstants.CENTER);
        errorMessage2.setVisible(false);
        background_dialog_modificarCred.add(errorMessage2, new AbsoluteConstraints(2, 430, 440, -1));

        jButton_modificar2.setBackground(new Color(0, 204, 0));
        jButton_modificar2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jButton_modificar2.setForeground(new Color(0, 0, 0));
        jButton_modificar2.setText("Modificar");
        jButton_modificar2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_modificar2MouseClicked(evt);
            }
        });
        background_dialog_modificarCred.add(jButton_modificar2, new AbsoluteConstraints(320, 450, -1, -1));

        jButton_cancelar2.setBackground(new Color(153, 153, 153));
        jButton_cancelar2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jButton_cancelar2.setForeground(new Color(0, 0, 0));
        jButton_cancelar2.setText("Cancelar");
        jButton_cancelar2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_cancelar2MouseClicked(evt);
            }
        });
        background_dialog_modificarCred.add(jButton_cancelar2, new AbsoluteConstraints(230, 450, -1, -1));

        contrasena_anterior.setBackground(new Color(0, 0, 0));
        contrasena_anterior.setFont(new Font("Roboto", Font.PLAIN, 12));
        contrasena_anterior.setForeground(new Color(0, 0, 0));
        contrasena_anterior.setText("Contraseña anterior *");
        background_dialog_modificarCred.add(contrasena_anterior, new AbsoluteConstraints(30, 270, -1, -1));

        jPasswordField_vieja.setBackground(new Color(255, 255, 255));
        jPasswordField_vieja.setDocument(new LimitarCamposSeguro(20, "Ingrese su contraseña"));
        jPasswordField_vieja.setFont(new Font("Roboto", Font.PLAIN, 14));
        jPasswordField_vieja.setForeground(Color.gray);
        jPasswordField_vieja.setText("Ingrese su contraseña");
        jPasswordField_vieja.setBorder(null);
        jPasswordField_vieja.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jPasswordField_vieja, "Ingrese su contraseña");
        background_dialog_modificarCred.add(jPasswordField_vieja, new AbsoluteConstraints(30, 290, 380, -1));

        jSeparator17.setForeground(new Color(30, 30, 30));
        background_dialog_modificarCred.add(jSeparator17, new AbsoluteConstraints(30, 310, 380, 21));

        jScrollPane2_modificarCred.setViewportView(background_dialog_modificarCred);

        GroupLayout jDialog_modificarCredLayout = new GroupLayout(jDialog_modificarCred.getContentPane());
        jDialog_modificarCred.getContentPane().setLayout(jDialog_modificarCredLayout);
        jDialog_modificarCredLayout.setHorizontalGroup(
                jDialog_modificarCredLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2_modificarCred)
        );
        jDialog_modificarCredLayout.setVerticalGroup(
                jDialog_modificarCredLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2_modificarCred)
        );

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Programa Vacunas Panamá - Doctor / Enfermera");
        setSize(new Dimension(1000, 800));
        addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jScrollPane_Frame.setPreferredSize(getSize());

        background.setBackground(new Color(227, 218, 201));
        background.setForeground(new Color(227, 218, 201));
        background.setMinimumSize(new Dimension(994, 794));
        background.setPreferredSize(new Dimension(994, 794));
        background.setLayout(new BorderLayout());

        jPanel_menuOpciones.setBackground(new Color(39, 104, 165));
        jPanel_menuOpciones.setForeground(new Color(48, 48, 46));
        jPanel_menuOpciones.setAutoscrolls(true);
        jPanel_menuOpciones.setMaximumSize(getSize());
        jPanel_menuOpciones.setPreferredSize(new Dimension(200, 0));
        jPanel_menuOpciones.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));

        jPanel_separador6.setBackground(new Color(39, 104, 165));
        jPanel_separador6.setForeground(new Color(48, 48, 46));
        jPanel_separador6.setPreferredSize(new Dimension(150, 35));

        GroupLayout separador1Layout = new GroupLayout(jPanel_separador6);
        jPanel_separador6.setLayout(separador1Layout);
        separador1Layout.setHorizontalGroup(
                separador1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        separador1Layout.setVerticalGroup(
                separador1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel_menuOpciones.add(jPanel_separador6);

        icon_project.setHorizontalAlignment(SwingConstants.CENTER);
        icon_project.setIcon(new ImageIcon(getClass().getResource("/images/operacionVacunas_logo.png")));
        icon_project.setAlignmentX(0.5F);
        icon_project.setHorizontalTextPosition(SwingConstants.CENTER);
        icon_project.setMaximumSize(new Dimension(200, 200));
        icon_project.setMinimumSize(new Dimension(50, 50));
        icon_project.setName("");
        icon_project.setPreferredSize(new Dimension(135, 135));
        jPanel_menuOpciones.add(icon_project);
        icon_project.getAccessibleContext().setAccessibleName("logo");

        rolName.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        rolName.setForeground(new Color(255, 255, 255));
        rolName.setHorizontalAlignment(SwingConstants.CENTER);
        rolName.setText("¡ Hola Doctor / Enfermera !");
        rolName.setAlignmentX(1.0F);
        rolName.setHorizontalTextPosition(SwingConstants.CENTER);
        rolName.setPreferredSize(new Dimension(170, 30));
        jPanel_menuOpciones.add(rolName);

        nombreBienvenida.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        nombreBienvenida.setForeground(new Color(255, 255, 255));
        nombreBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
        nombreBienvenida.setText("Nombre");
        nombreBienvenida.setAlignmentX(1.0F);
        nombreBienvenida.setHorizontalTextPosition(SwingConstants.CENTER);
        nombreBienvenida.setPreferredSize(new Dimension(150, 30));
        jPanel_menuOpciones.add(nombreBienvenida);

        button_opcion1.setForeground(new Color(255, 255, 255));
        button_opcion1.setText("Mis pacientes");
        button_opcion1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button_opcion1.setPreferredSize(new Dimension(160, 30));
        button_opcion1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                button_opcion1MouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_opcion1);

        button_opcion2.setForeground(new Color(255, 255, 255));
        button_opcion2.setText("Buscar paciente");
        button_opcion2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button_opcion2.setPreferredSize(new Dimension(160, 30));
        button_opcion2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                button_opcion2MouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_opcion2);

        button_opcion3.setForeground(new Color(255, 255, 255));
        button_opcion3.setText("Buscar dosis de vacuna");
        button_opcion3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button_opcion3.setPreferredSize(new Dimension(160, 30));
        button_opcion3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                button_opcion3MouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_opcion3);

        button_opcion4.setForeground(new Color(255, 255, 255));
        button_opcion4.setText("Insertar dosis");
        button_opcion4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button_opcion4.setPreferredSize(new Dimension(160, 30));
        button_opcion4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                button_opcion4MouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_opcion4);

        button_opcion5.setForeground(new Color(255, 255, 255));
        button_opcion5.setText("Agendar cita de vacuna");
        button_opcion5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button_opcion5.setPreferredSize(new Dimension(160, 30));
        button_opcion5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                button_opcion5MouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_opcion5);

        button_opcion6.setForeground(new Color(255, 255, 255));
        button_opcion6.setText("Crear / Editar paciente");
        button_opcion6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button_opcion6.setPreferredSize(new Dimension(160, 30));
        button_opcion6.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                button_opcion6MouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_opcion6);

        button_opcion7.setForeground(new Color(255, 255, 255));
        button_opcion7.setText("Inventario de vacunas");
        button_opcion7.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button_opcion7.setPreferredSize(new Dimension(160, 30));
        button_opcion7.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                button_opcion7MouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_opcion7);

        button_opcion8.setForeground(new Color(255, 255, 255));
        button_opcion8.setText("Reporte y estadísticas");
        button_opcion8.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button_opcion8.setPreferredSize(new Dimension(160, 30));
        button_opcion8.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                button_opcion8MouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_opcion8);

        jPanel_separador7.setBackground(new Color(39, 104, 165));
        jPanel_separador7.setForeground(new Color(48, 48, 46));
        jPanel_separador7.setPreferredSize(new Dimension(150, 17));

        GroupLayout separador2Layout = new GroupLayout(jPanel_separador7);
        jPanel_separador7.setLayout(separador2Layout);
        separador2Layout.setHorizontalGroup(
                separador2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        separador2Layout.setVerticalGroup(
                separador2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel_menuOpciones.add(jPanel_separador7);

        button_modificarDatos.setForeground(new Color(255, 255, 255));
        button_modificarDatos.setText("Modificar datos personales");
        button_modificarDatos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button_modificarDatos.setPreferredSize(new Dimension(160, 30));
        button_modificarDatos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                button_modificarDatosMouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_modificarDatos);

        button_modificarCred.setForeground(new Color(255, 255, 255));
        button_modificarCred.setText("Modificar credenciales");
        button_modificarCred.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button_modificarCred.setPreferredSize(new Dimension(160, 30));
        button_modificarCred.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                button_modificarCredMouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_modificarCred);

        button_preferencias.setForeground(new Color(255, 255, 255));
        button_preferencias.setText("Preferencias");
        button_preferencias.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button_preferencias.setPreferredSize(new Dimension(160, 30));
        button_preferencias.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                button_preferenciasMouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_preferencias);

        button_soporte.setForeground(new Color(255, 255, 255));
        button_soporte.setText("Soporte");
        button_soporte.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button_soporte.setPreferredSize(new Dimension(160, 30));
        button_soporte.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                button_soporteMouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_soporte);

        button_logOut.setBackground(new Color(255, 85, 73));
        button_logOut.setForeground(new Color(255, 255, 255));
        button_logOut.setText("Salir");
        button_logOut.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button_logOut.setPreferredSize(new Dimension(160, 30));
        button_logOut.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                button_logOutMouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_logOut);

        background.add(jPanel_menuOpciones, BorderLayout.WEST);

        jPanel_contenidos_derecha.setBackground(new Color(227, 218, 201));
        jPanel_contenidos_derecha.setPreferredSize(new Dimension(794, 0));
        jPanel_contenidos_derecha.setLayout(new CardLayout());

        jPanel1.setBackground(new Color(227, 218, 201));
        jPanel1.setPreferredSize(new Dimension(794, 0));
        mostrando = jPanel1;

        jLabel6.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
        jLabel6.setForeground(new Color(102, 102, 102));
        jLabel6.setText("Bienvenido al Programa Vacunas Panamá");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 566, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_contenidos_derecha.add(jPanel1, "vacio");

        background.add(jPanel_contenidos_derecha, BorderLayout.CENTER);

        jScrollPane_Frame.setViewportView(background);

        getContentPane().add(jScrollPane_Frame, BorderLayout.CENTER);
        setIconImage(new ImageIcon(getClass().getResource("/images/Icon1.png")).getImage());

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void formComponentShown(ComponentEvent evt) {
        Login.setImageLabel(icon_project, "src/images/operacionVacunas_Logo.png");
        try {
            if (DB_DOCTOR.refreshAgePaciente("admin", "admin1234", "Administrador"))
                System.out.println("Se actualizó la edad de los pacientes en la base de datos.");
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Ha ocurrido un problema actualizando las edades de los pacientes. Reinicie la aplicación o contacte a soporte");
        }
    }

    private void formWindowClosing(WindowEvent evt) {
        int confirm = JOptionPane.showConfirmDialog(this, "¿Esta seguro de cerrar sesión?", "Cerrando sesión y ventana...", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (confirm == 0) {
            PARENT_FRAME.setVisible(true);
            PARENT_FRAME.requestFocus();
            this.dispose();
        }
    }

    /* eventos del menú lateral */
    private void button_opcion1MouseClicked(MouseEvent evt) {
        if (!button_opcion1.isEnabled()) {
            return;
        }

        button_opcion1.setEnabled(false);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                button_opcion1.setEnabled(true);
            }
        }, OPTIONS_DISABLE_TIME);

        if (!jPanel_contenidos_derecha.isAncestorOf(jPanel_misPacientes)) {
            jPanel_contenidos_derecha.add(jPanel_misPacientes, "option 1");
        }
        if (mostrando == jPanel_misPacientes) {
            LAYOUT.show(jPanel_contenidos_derecha, "vacio");
            mostrando = jPanel1;
        } else {
            LAYOUT.show(jPanel_contenidos_derecha, "option 1");
            mostrando = jPanel_misPacientes;

            try {
                Resultados r = DB_DOCTOR.showVistaDoctor("admin", "admin1234", "Administrador", userActual.getPrefs().getSede() - 1);
                jTable_Content_MisPacientes.setModel(new DefaultTableModel(r.getDatos(), r.getColumnas()) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                });
                JPANEL_FILTRAR1.setColumns(r.getColumnas());
                PantallaBase.adjustColumnWidths(jTable_Content_MisPacientes);
                // Ajustar automáticamente el ancho de las columnas cuando se redimensiona el JFrame
                jScrollPane_Table1_MisPacientes.addComponentListener(new ComponentAdapter() {
                    @Override
                    public void componentResized(ComponentEvent e) {
                        PantallaBase.adjustColumnWidths(jTable_Content_MisPacientes);
                    }
                });
                jTable_Content_MisPacientes.repaint();
                jTable_Content_MisPacientes.revalidate();
                jScrollPane_Table1_MisPacientes.revalidate();
                jScrollPane_Table1_MisPacientes.repaint();
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(this, "Ha ocurrido un problema encontrando el inventario de la sede preferida. Reinicie la aplicación o contacte a soporte");
            }
        }
        jPanel_contenidos_derecha.revalidate();
        jPanel_contenidos_derecha.repaint();
    }

    private void button_opcion2MouseClicked(MouseEvent evt) {
        if (!jPanel_contenidos_derecha.isAncestorOf(jPanel_buscarPaciente)) {
            jPanel_contenidos_derecha.add(jPanel_buscarPaciente, "option 2");
        }
        if (mostrando == jPanel_buscarPaciente) {
            LAYOUT.show(jPanel_contenidos_derecha, "vacio");
            mostrando = jPanel1;
        } else {
            LAYOUT.show(jPanel_contenidos_derecha, "option 2");
            mostrando = jPanel_buscarPaciente;
        }
        jPanel_contenidos_derecha.revalidate();
        jPanel_contenidos_derecha.repaint();
    }

    private void button_opcion3MouseClicked(MouseEvent evt) {
        if (!jPanel_contenidos_derecha.isAncestorOf(jPanel_buscarDosis)) {
            jPanel_contenidos_derecha.add(jPanel_buscarDosis, "option 3");
            try {
                jComboBox_sede1.setModel(new DefaultComboBoxModel<>(PantallaBase.transformMatrizToArray(DB_DOCTOR.getSedes("admin", "admin1234", "Administrador"), 0)));
                jComboBox_vacuna1.setModel(new DefaultComboBoxModel<>(PantallaBase.transformMatrizToArray(DB_DOCTOR.getVacunas("admin", "admin1234", "Administrador"), 0)));
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(this, "Ha ocurrido un problema encontrando información de la base de datos necesaria. Reinicie la aplicación o contacte a soporte");
            }
        }
        if (mostrando == jPanel_buscarDosis) {
            LAYOUT.show(jPanel_contenidos_derecha, "vacio");
            mostrando = jPanel1;
        } else {
            LAYOUT.show(jPanel_contenidos_derecha, "option 3");
            mostrando = jPanel_buscarDosis;
        }
        jPanel_contenidos_derecha.revalidate();
        jPanel_contenidos_derecha.repaint();
    }

    private void button_opcion4MouseClicked(MouseEvent evt) {
        if (!jPanel_contenidos_derecha.isAncestorOf(jPanel_insertarDosis)) {
            jPanel_contenidos_derecha.add(jPanel_insertarDosis, "option 4");
            try {
                jComboBox_sede2.setModel(new DefaultComboBoxModel<>(PantallaBase.transformMatrizToArray(DB_DOCTOR.getSedes("admin", "admin1234", "Administrador"), 0)));
                jComboBox_vacuna2.setModel(new DefaultComboBoxModel<>(PantallaBase.transformMatrizToArray(DB_DOCTOR.getVacunas("admin", "admin1234", "Administrador"), 0)));
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(this, "Ha ocurrido un problema encontrando información de la base de datos necesaria. Reinicie la aplicación o contacte a soporte");
            }
        }
        if (mostrando == jPanel_insertarDosis) {
            LAYOUT.show(jPanel_contenidos_derecha, "vacio");
            mostrando = jPanel1;
        } else {
            LAYOUT.show(jPanel_contenidos_derecha, "option 4");
            mostrando = jPanel_insertarDosis;
            jTextField_fechaAplicacion1.setText(Timestamp.valueOf(LocalDateTime.now().withNano(0)).toString());
            jTextField_fechaAplicacion1.setForeground(Color.black);
        }
        jPanel_contenidos_derecha.revalidate();
        jPanel_contenidos_derecha.repaint();
    }

    private void button_opcion5MouseClicked(MouseEvent evt) {
        /* TODO implementar lógica de pedir cita en una sede o doctor */
        if (!jPanel_contenidos_derecha.isAncestorOf(jPanel_agendarCita)) {
            jPanel_contenidos_derecha.add(jPanel_agendarCita, "option 5");
        }
        if (mostrando == jPanel_agendarCita) {
            LAYOUT.show(jPanel_contenidos_derecha, "vacio");
            mostrando = jPanel1;
        } else {
            LAYOUT.show(jPanel_contenidos_derecha, "option 5");
            mostrando = jPanel_agendarCita;
        }
        jPanel_contenidos_derecha.revalidate();
        jPanel_contenidos_derecha.repaint();
    }

    private void button_opcion6MouseClicked(MouseEvent evt) {
        if (!jPanel_contenidos_derecha.isAncestorOf(jPanel_manipularPaciente)) {
            jPanel_contenidos_derecha.add(jPanel_manipularPaciente, "option 6");
            try {
                jComboBox_distrito1.setModel(new DefaultComboBoxModel<>(PantallaBase.transformMatrizToArray(DB_DOCTOR.getDistritos("admin", "admin1234", "Administrador"), 0)));
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(this, "Ha ocurrido un problema encontrando las distritos. Reinicie la aplicación o contacte a soporte");
            }
        }
        if (mostrando == jPanel_manipularPaciente) {
            LAYOUT.show(jPanel_contenidos_derecha, "vacio");
            mostrando = jPanel1;
        } else {
            LAYOUT.show(jPanel_contenidos_derecha, "option 6");
            mostrando = jPanel_manipularPaciente;
        }
        jPanel_contenidos_derecha.revalidate();
        jPanel_contenidos_derecha.repaint();
    }

    private void button_opcion7MouseClicked(MouseEvent evt) {
        if (!button_opcion7.isEnabled()) {
            return;
        }

        button_opcion7.setEnabled(false);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                button_opcion7.setEnabled(true);
            }
        }, OPTIONS_DISABLE_TIME);

        if (!jPanel_contenidos_derecha.isAncestorOf(jPanel_inventario)) {
            jPanel_contenidos_derecha.add(jPanel_inventario, "option 7");

        }
        if (mostrando == jPanel_inventario) {
            LAYOUT.show(jPanel_contenidos_derecha, "vacio");
            mostrando = jPanel1;
        } else {
            LAYOUT.show(jPanel_contenidos_derecha, "option 7");
            mostrando = jPanel_inventario;
            try {
                Resultados r = DB_DOCTOR.showSedeInventario("admin", "admin1234", "Administrador", userActual.getPrefs().getSede() - 1);
                jTable_Content_Inventario.setModel(new DefaultTableModel(r.getDatos(), r.getColumnas()) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                });
                jComboBox_filterColumn_vacuna_Inventario.setModel(new DefaultComboBoxModel<>(PantallaBase.transformMatrizToArray(r.getDatos(), 2)));
                jComboBox_filterColumn_lote_Inventario.setModel(new DefaultComboBoxModel<>(PantallaBase.transformMatrizToArray(r.getDatos(), 0)));
                PantallaBase.adjustColumnWidths(jTable_Content_Inventario);
                // Ajustar automáticamente el ancho de las columnas cuando se redimensiona el JFrame
                jScrollPane_Table3_Inventario.addComponentListener(new ComponentAdapter() {
                    @Override
                    public void componentResized(ComponentEvent e) {
                        PantallaBase.adjustColumnWidths(jTable_Content_Inventario);
                    }
                });
                jTable_Content_Inventario.repaint();
                jTable_Content_Inventario.revalidate();
                jScrollPane_Table3_Inventario.revalidate();
                jScrollPane_Table3_Inventario.repaint();
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(this, "Ha ocurrido un problema encontrando el inventario de la sede preferida. Reinicie la aplicación o contacte a soporte");
            }
        }
        jPanel_contenidos_derecha.revalidate();
        jPanel_contenidos_derecha.repaint();
    }

    private void button_opcion8MouseClicked(MouseEvent evt) {
        if (!button_opcion8.isEnabled()) {
            return;
        }

        button_opcion8.setEnabled(false);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                button_opcion8.setEnabled(true);
            }
        }, OPTIONS_DISABLE_TIME);

        if (!jPanel_contenidos_derecha.isAncestorOf(jPanel_estadisticas)) {
            jPanel_contenidos_derecha.add(jPanel_estadisticas, "option 8");
        }
        if (mostrando == jPanel_estadisticas) {
            LAYOUT.show(jPanel_contenidos_derecha, "vacio");
            mostrando = jPanel1;
        } else {
            LAYOUT.show(jPanel_contenidos_derecha, "option 8");
            mostrando = jPanel_estadisticas;

            try {
                Resultados r = DB_DOCTOR.showReporteVacunacionFiltrado("admin", "admin1234", "Administrador", userActual.getPrefs().getSede() - 1);
                jTable_Content_Estadisticas.setModel(new DefaultTableModel(r.getDatos(), r.getColumnas()) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                });
                jComboBox_filterColumn_vacuna_Inventario.setModel(new DefaultComboBoxModel<>(PantallaBase.transformMatrizToArray(r.getDatos(), 5)));
                PantallaBase.adjustColumnWidths(jTable_Content_Estadisticas);
                // Ajustar automáticamente el ancho de las columnas cuando se redimensiona el JFrame
                jScrollPane_Table4_Estadisticas.addComponentListener(new ComponentAdapter() {
                    @Override
                    public void componentResized(ComponentEvent e) {
                        PantallaBase.adjustColumnWidths(jTable_Content_Estadisticas);
                    }
                });
                jTable_Content_Estadisticas.repaint();
                jTable_Content_Estadisticas.revalidate();
                jScrollPane_Table4_Estadisticas.revalidate();
                jScrollPane_Table4_Estadisticas.repaint();
                jButton_buscar1MouseClicked(null);
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(this, "Ha ocurrido un problema encontrando el inventario de la sede preferida. Reinicie la aplicación o contacte a soporte");
            }
        }
        jPanel_contenidos_derecha.revalidate();
        jPanel_contenidos_derecha.repaint();
    }

    private void button_modificarCredMouseClicked(MouseEvent evt) {
        if (!button_modificarCred.isEnabled()) {
            return;
        }

        button_modificarCred.setEnabled(false);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                button_modificarCred.setEnabled(true);
            }
        }, MODIFY_USER_DISABLE_TIME);

        try {
            Resultados rUser = DB_DOCTOR.searchUsuario("admin", "admin1234", "Administrador", userActual.getCedula(), "Doctor - Enfermera");
            if (rUser != null && rUser.getDatos().length > 0) {
                datosEncontrados = rUser.getDatos();
                jTextField_usuario_Viejo.setText((String) datosEncontrados[0][1]);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el usuario anterior en la base de datos.");
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Ha ocurrido un problema encontrando su usuario. Reinicie la aplicación o contacte a soporte");
        }
        jDialog_modificarCred.setLocationRelativeTo(this);
        jDialog_modificarCred.setVisible(true);
        jDialog_modificarCred.requestFocusInWindow();
        datosEncontrados = null;
    }

    private void button_modificarDatosMouseClicked(MouseEvent evt) {
        if (!button_modificarDatos.isEnabled()) {
            return;
        }

        button_modificarDatos.setEnabled(false);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                button_modificarDatos.setEnabled(true);
            }
        }, MODIFY_USER_DISABLE_TIME);

        try {
            jComboBox_distrito.setModel(new DefaultComboBoxModel<>(PantallaBase.transformMatrizToArray(DB_DOCTOR.getDistritos("admin", "admin1234", "Administrador"), 0)));
            datosEncontrados = new String[1][];
            datosEncontrados[0] = userActual.toArray();
            jTextField_nombre.setText((String) datosEncontrados[0][0]);
            jTextField_apellido.setText((String) datosEncontrados[0][1]);
            jTextField_cedula.setText((String) datosEncontrados[0][2]);
            jTextField_fechaNacimiento.setText((String) datosEncontrados[0][3]);
            jTextField_correo.setText((String) datosEncontrados[0][4]);
            jTextField_telefono.setText((String) datosEncontrados[0][5]);
            jTextField_direccion.setText((String) datosEncontrados[0][6]);
            jComboBox_distrito.setSelectedItem(datosEncontrados[0][6]);
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Ha ocurrido un problema encontrando su usuario. Reinicie la aplicación o contacte a soporte");
        }
        jDialog_modificarDatos.setLocationRelativeTo(this);
        jDialog_modificarDatos.setVisible(true);
        jDialog_modificarDatos.requestFocusInWindow();
        editar = true;
    }

    private void button_soporteMouseClicked(MouseEvent evt) {
        if (!jPanel_contenidos_derecha.isAncestorOf(jPanel_soporte)) {
            jPanel_contenidos_derecha.add(jPanel_soporte, "option 9");
        }
        if (mostrando == jPanel_soporte) {
            LAYOUT.show(jPanel_contenidos_derecha, "vacio");
            mostrando = jPanel1;
        } else {
            LAYOUT.show(jPanel_contenidos_derecha, "option 9");
            mostrando = jPanel_soporte;
        }
        jPanel_contenidos_derecha.revalidate();
        jPanel_contenidos_derecha.repaint();
    }

    private void button_preferenciasMouseClicked(MouseEvent evt) {
        if (!jPanel_contenidos_derecha.isAncestorOf(jPanel_preferencias)) {
            jPanel_contenidos_derecha.add(jPanel_preferencias, "preferences");
        }
        if (mostrando == jPanel_preferencias) {
            LAYOUT.show(jPanel_contenidos_derecha, "vacio");
            mostrando = jPanel1;
        } else {
            LAYOUT.show(jPanel_contenidos_derecha, "preferences");
            mostrando = jPanel_preferencias;
        }
        jPanel_contenidos_derecha.revalidate();
        jPanel_contenidos_derecha.repaint();
    }

    private void button_logOutMouseClicked(MouseEvent evt) {
        formWindowClosing(null);
    }

    /* eventos de jPanel mostrarTabla en doctor es Mis Pacientes */
    private void jButton_buscarMouseClicked(MouseEvent evt) {
        jTextField_buscarTabla1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jTextField_buscarTabla1.setForeground(Color.BLACK);

        String patronBuscado = jTextField_buscarTabla1.getText();
        if (!patronBuscado.isBlank() || !patronBuscado.equals("Buscar...")) {
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTable_Content_MisPacientes.getModel());
            jTable_Content_MisPacientes.setRowSorter(sorter);
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + patronBuscado));
        } else {
            jTextField_buscarTabla1.setBorder(BorderFactory.createLineBorder(Color.red));
            jTextField_buscarTabla1.setForeground(Color.red);
        }
    }

    private void jTextField_buscarTablaActionPerformed(ActionEvent evt) {
        jButton_buscarMouseClicked(null);
    }

    private void jButton_filtrosMouseClicked(MouseEvent evt) {
        if (!jPanel_misPacientes.isAncestorOf(JPANEL_FILTRAR1)) {
            jPanel_misPacientes.add(JPANEL_FILTRAR1, BorderLayout.NORTH);
            JPANEL_FILTRAR1.setVisible(true);
        } else {
            jPanel_misPacientes.remove(JPANEL_FILTRAR1);
        }
        jPanel_misPacientes.revalidate();
        jPanel_misPacientes.repaint();
    }

    private void jButton_ordenarMouseClicked(MouseEvent evt) {
        jTable_Content_MisPacientes.setAutoCreateRowSorter(true);
    }

    private void jButton_acercarMouseClicked(MouseEvent evt) {
        Font currentFont = jTable_Content_MisPacientes.getFont();
        jTable_Content_MisPacientes.setFont(currentFont.deriveFont(currentFont.getSize() + 2f));
    }

    private void jButton_alejarMouseClicked(MouseEvent evt) {
        Font currentFont = jTable_Content_MisPacientes.getFont();
        jTable_Content_MisPacientes.setFont(currentFont.deriveFont(currentFont.getSize() - 2f));
    }

    private void jButton_fuenteMouseClicked(MouseEvent evt) {
        boolean result = FONTCHOOSER_PACIENTE.showDialog(this);
        if (result) {
            Font font = FONTCHOOSER_PACIENTE.getSelectedFont();
            jTable_Content_MisPacientes.setFont(font);
            jTable_Content_MisPacientes.repaint();
        }
    }

    private void jButton_exportarMouseClicked(MouseEvent evt) {
        /* TODO llamada al método exportar en csv o excel o pdf del jPanel Mis Paciente doctor */
    }

    /* eventos de jPanel manipular paciente */
    private void jButton_buscarPacienteEditarMouseClicked(MouseEvent evt) {
        if (!jButton_buscarPacienteEditar.isEnabled()) {
            return;
        }

        jButton_buscarPacienteEditar.setEnabled(false);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                jButton_buscarPacienteEditar.setEnabled(true);
            }
        }, SEARCH_PACIENTE_DISABLE_TIME);

        String cedulaB = jTextField_cedula2.getText();
        if (cedulaB.isBlank() || cedulaB.equals("Ingrese cédula a buscar")) {
            JOptionPane.showMessageDialog(this, "Error. Debe introducir la cédula del paciente para buscar y editar.", "Error al buscar un paciente...", JOptionPane.ERROR_MESSAGE);
        } else if (!cedulaB.matches("^(PE|E|N|[23456789](?:AV|PI)?|1[0123]?(?:AV|PI)?)-(\\d{1,4})-(\\d{1,6})$")) {
            JOptionPane.showMessageDialog(this, "Error. La cédula no tiene el formato correcto.", "Error al buscar un paciente...", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                Resultados rPaciente = DB_DOCTOR.searchTablePaciente("admin", "admin1234", "Administrador", cedulaB, null, null);
                if (rPaciente != null && rPaciente.getDatos().length > 0) {
                    datosEncontrados = rPaciente.getDatos();
                    jTextField_cedula1.setText((String) datosEncontrados[0][0]);
                    jTextField_nombre1.setText((String) datosEncontrados[0][1]);
                    jTextField_apellido1.setText((String) datosEncontrados[0][2]);
                    jTextField_fechaNacimiento1.setText(datosEncontrados[0][3].toString());
                    if (datosEncontrados[0][5].equals("M")) {
                        jComboBox_sexo1.setSelectedItem("Masculino");
                    } else if (datosEncontrados[0][5].equals("F")) {
                        jComboBox_sexo1.setSelectedItem("Femenino");
                    } else {
                        jComboBox_sexo1.setSelectedItem(null);
                    }
                    jTextField_telefono1.setText((String) datosEncontrados[0][6]);
                    jTextField_correo1.setText((String) datosEncontrados[0][7]);
                    jTextField_direccion1.setText((String) datosEncontrados[0][8]);
                    jComboBox_distrito1.setSelectedItem(datosEncontrados[0][9]);

                    jTextField_cedula1.setForeground(Color.black);
                    jTextField_nombre1.setForeground(Color.black);
                    jTextField_apellido1.setForeground(Color.black);
                    jTextField_fechaNacimiento1.setForeground(Color.black);
                    jComboBox_sexo1.setForeground(Color.black);
                    jTextField_telefono1.setForeground(Color.black);
                    jTextField_correo1.setForeground(Color.black);
                    jTextField_direccion1.setForeground(Color.black);
                    jComboBox_distrito1.setForeground(Color.black);
                    JOptionPane.showMessageDialog(this, "¡Datos de paciente encontrado! Puede editar");
                    editarPaciente = true;
                }
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(this, "Ha ocurrido un problema encontrando el paciente con dicha cédula. Reinicie la aplicación o contacte a soporte");
            }
        }
    }

    private void jButton_modificar1MouseClicked(MouseEvent evt) {
        if (!jButton_modificar1.isEnabled()) {
            return;
        }

        jButton_modificar1.setEnabled(false);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                jButton_modificar1.setEnabled(true);
            }
        }, MANIPULATE_PACIENTE_DISABLE_TIME);

        boolean modificado = false;
        String nombreM = jTextField_nombre1.getText();
        String apellidoM = jTextField_apellido1.getText();
        String cedulaM = jTextField_cedula1.getText();
        String fechaNacimientoM = jTextField_fechaNacimiento1.getText();
        char sexoM = jComboBox_sexo1.getSelectedItem().toString().charAt(0);
        String distritoM = (String) jComboBox_distrito1.getSelectedItem();
        String direccionM = jTextField_direccion1.getText();
        String correoM = jTextField_correo1.getText();
        String telefonoM = jTextField_telefono1.getText();

        boolean condicion1 = nombreM.isBlank() || nombreM.equals("Ingrese el nombre");
        boolean condicion2 = apellidoM.isBlank() || apellidoM.equals("Ingrese el apellido");
        boolean condicion3 = cedulaM.isBlank() || cedulaM.equals("Ingrese la cédula");
        boolean condicion4 = fechaNacimientoM.isBlank() || fechaNacimientoM.equals("Ingrese la fecha de nacimiento YYYY-MM-DD* hh:mm:ss");
        boolean condicion5 = sexoM == 'E';
        boolean condicionesObligatorias = !condicion1 && !condicion2 && !condicion3 && !condicion4 && !condicion5;
        boolean condicionOp1 = distritoM == null || distritoM.equals("Elegir");
        boolean condicionOp2 = direccionM.isBlank() || direccionM.equals("Ingrese la dirección");
        boolean condicionOp3 = correoM.isBlank() || correoM.equals("Ingrese el correo electrónico");
        boolean condicionOp4 = telefonoM.isBlank() || telefonoM.equals("Ingrese el código de país, el código de ciudad y el número de teléfono local");

        if (editarPaciente) {
            boolean campoModificado =
                    !nombreM.equals(datosEncontrados[0][1]) ||
                            !apellidoM.equals(datosEncontrados[0][2]) ||
                            !cedulaM.equals(datosEncontrados[0][0]) ||
                            !fechaNacimientoM.equals(datosEncontrados[0][4]) ||
                            sexoM != datosEncontrados[0][6].toString().charAt(0) ||
                            (distritoM != null && !distritoM.equals(datosEncontrados[0][10])) ||
                            !direccionM.equals(datosEncontrados[0][9]) ||
                            !correoM.equals(datosEncontrados[0][8]) ||
                            !telefonoM.equals(datosEncontrados[0][7]);

            condicionesObligatorias = condicionesObligatorias && campoModificado;
        }

        boolean verificacion1 = !cedulaM.matches("^(PE|E|N|[23456789](?:AV|PI)?|1[0123]?(?:AV|PI)?)-(\\d{1,4})-(\\d{1,6})$");
        boolean verificacion2 = (!fechaNacimientoM.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$") && !fechaNacimientoM.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]) (0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9](\\.\\d{1,9})?$"));
        boolean verificacion3 = !correoM.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
        boolean verificacion4 = (condicionOp1 && !condicionOp2) || (!condicionOp1 && condicionOp2);

        errorMessage1.setVisible(false);

        if (!condicionesObligatorias) {
            errorMessage1.setText("Error. Algunos campos son obligatorios*. Revisar");
            errorMessage1.setVisible(true);
            return;
        } else {
            if (verificacion1) {
                errorMessage1.setText("Error. La cédula no tiene el formato correcto.");
                errorMessage1.setVisible(true);
                return;
            } else if (verificacion2) {
                errorMessage1.setText("Error. La fecha de nacimiento no tiene el formato correcto. La fecha sin hora es obligatorio. YYYY-MM-DD");
                errorMessage1.setVisible(true);
                return;
            } else if (!condicionOp3 && verificacion3) {
                errorMessage1.setText("Error. El correo electrónico no tiene el formato correcto.");
                errorMessage1.setVisible(true);
                return;
            } else if (verificacion4) {
                errorMessage1.setText("Error. La dirección o el distrito están incompletos. Debe llenar ambos campos o ninguno.");
                errorMessage1.setVisible(true);
                return;
            } else {
                try {
                    Timestamp fechaNacimientoTimestamp;
                    if (fechaNacimientoM.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$")) {
                        fechaNacimientoTimestamp = Timestamp.valueOf(LocalDate.parse(fechaNacimientoM).atStartOfDay());
                    } else {
                        fechaNacimientoTimestamp = Timestamp.valueOf(fechaNacimientoM);
                    }

                    if (!condicionOp1 && !condicionOp2) {
                        if (!condicionOp3 && !condicionOp4) {
                            if (DB_DOCTOR.manipulatePaciente("admin", "admin1234", "Administrador", cedulaM, nombreM, apellidoM, fechaNacimientoTimestamp, sexoM, telefonoM, correoM, direccionM, distritoM) > 0) {
                                modificado = true;
                            }
                        } else if (!condicionOp3) {
                            if (DB_DOCTOR.manipulatePaciente("admin", "admin1234", "Administrador", cedulaM, nombreM, apellidoM, fechaNacimientoTimestamp, sexoM, null, correoM, direccionM, distritoM) > 0) {
                                modificado = true;
                            }
                        } else {
                            if (DB_DOCTOR.manipulatePaciente("admin", "admin1234", "Administrador", cedulaM, nombreM, apellidoM, fechaNacimientoTimestamp, sexoM, null, null, direccionM, distritoM) > 0) {
                                modificado = true;
                            }
                        }
                    } else if (!condicionOp3) {
                        if (!condicionOp4) {
                            if (DB_DOCTOR.manipulatePaciente("admin", "admin1234", "Administrador", cedulaM, nombreM, apellidoM, fechaNacimientoTimestamp, sexoM, telefonoM, correoM, null, null) > 0) {
                                modificado = true;
                            }
                        } else {
                            if (DB_DOCTOR.manipulatePaciente("admin", "admin1234", "Administrador", cedulaM, nombreM, apellidoM, fechaNacimientoTimestamp, sexoM, null, correoM, null, null) > 0) {
                                modificado = true;
                            }
                        }
                    } else if (!condicionOp4) {
                        if (DB_DOCTOR.manipulatePaciente("admin", "admin1234", "Administrador", cedulaM, nombreM, apellidoM, fechaNacimientoTimestamp, sexoM, telefonoM, null, null, null) > 0) {
                            modificado = true;
                        }
                    } else {
                        if (DB_DOCTOR.manipulatePaciente("admin", "admin1234", "Administrador", cedulaM, nombreM, apellidoM, fechaNacimientoTimestamp, sexoM, null, null, null, null) > 0) {
                            modificado = true;
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(this,
                            "Ha ocurrido un problema manipulando el paciente. No hay certeza si los datos fueron manipulados. " +
                                    "\nGuarde los datos para futuro registro. Reinicie la aplicación o contacte a soporte");
                }
            }
        }

        if (modificado) {
            JOptionPane.showMessageDialog(this,
                    "Esta información se procesará y puede tardar unos segundos para mostrar en otras pestañas. " +
                            "\nEl paciente podrá crearse sus credenciales con sus datos personales correctos.",
                    "Modificando datos de paciente...", JOptionPane.INFORMATION_MESSAGE);
            datosEncontrados = null;
            editarPaciente = false;
            // TODO limpiar los campos
        } else {
            errorMessage.setText("Error al modificar los datos del paciente.");
            errorMessage.setVisible(true);
        }
    }

    private void jTextField_direccion1ActionPerformed(ActionEvent evt) {
        if (jComboBox_distrito1.getSelectedIndex() == 0) {
            jComboBox_distrito1.setSelectedIndex(1);
        }
        jTextField_correo1.requestFocus();
    }

    private void jTextField_telefono1ActionPerformed(ActionEvent evt) {
        jButton_modificar1MouseClicked(null);
    }

    private void jTextField_cedula2ActionPerformed(ActionEvent evt) {
        jButton_buscarPacienteEditarMouseClicked(null);
    }

    /* eventos de jDialog modificar datos personales del usuario doctor */
    private void jTextField_direccionActionPerformed(ActionEvent evt) {
        if (jComboBox_distrito.getSelectedIndex() == 0) {
            jComboBox_distrito.setSelectedIndex(1);
        }
        jTextField_correo.requestFocus();
    }
    private void jTextField_telefonoActionPerformed(ActionEvent evt) {
        jButton_modificarMouseClicked(null);
    }

    private void jButton_cancelarMouseClicked(MouseEvent evt) {
        jDialog_modificarDatos.dispose();
    }

    private void jButton_modificarMouseClicked(MouseEvent evt) {
        if (!jButton_modificar.isEnabled()) {
            return;
        }

        jButton_modificar.setEnabled(false);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                jButton_modificar.setEnabled(true);
            }
        }, MODIFY_USER_DISABLE_TIME);


        boolean modificado = false;
        String nombreM = jTextField_nombre.getText();
        String apellidoM = jTextField_apellido.getText();
        String cedulaM = jTextField_cedula.getText();
        String fechaNacimientoM = jTextField_fechaNacimiento.getText();
        char sexoM = jComboBox_sexo.getSelectedItem().toString().charAt(0);
        String distritoM = jComboBox_distrito.getSelectedItem().toString();
        String direccionM = jTextField_direccion.getText();
        String correoM = jTextField_correo.getText();
        String telefonoM = jTextField_telefono.getText();

        boolean condicion1 = nombreM.isBlank() || nombreM.equals("Ingrese el nombre");
        boolean condicion2 = apellidoM.isBlank() || apellidoM.equals("Ingrese el apellido");
        boolean condicion3 = cedulaM.isBlank() || cedulaM.equals("Ingrese la cédula");
        boolean condicion4 = fechaNacimientoM.isBlank() || fechaNacimientoM.equals("Ingrese la fecha de nacimiento YYYY-MM-DD* hh:mm:ss");
        boolean condicion5 = sexoM == 'E';
        boolean condicionesObligatorias = !condicion1 && !condicion2 && !condicion3 && !condicion4 && !condicion5;

        boolean condicionOp1 = distritoM.equals("Elegir");
        boolean condicionOp2 = direccionM.isBlank() || direccionM.equals("Ingrese la dirección");
        boolean condicionOp3 = correoM.isBlank() || correoM.equals("Ingrese el correo electrónico");
        boolean condicionOp4 = telefonoM.isBlank() || telefonoM.equals("Ingrese el código de país, el código de ciudad y el número de teléfono local");

        if (editar) {
            boolean campoModificado =
                    !nombreM.equals(datosEncontrados[0][1]) ||
                            !apellidoM.equals(datosEncontrados[0][2]) ||
                            !cedulaM.equals(datosEncontrados[0][0]) ||
                            !fechaNacimientoM.equals(datosEncontrados[0][4]) ||
                            sexoM != datosEncontrados[0][6].toString().charAt(0) ||
                            (distritoM != null && !distritoM.equals(datosEncontrados[0][10])) ||
                            !direccionM.equals(datosEncontrados[0][9]) ||
                            !correoM.equals(datosEncontrados[0][8]) ||
                            !telefonoM.equals(datosEncontrados[0][7]);

            condicionesObligatorias = condicionesObligatorias && campoModificado;
        }

        boolean verificacion1 = !cedulaM.matches("^(PE|E|N|[23456789](?:AV|PI)?|1[0123]?(?:AV|PI)?)-(\\d{1,4})-(\\d{1,6})$");
        boolean verificacion2 = (!fechaNacimientoM.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$") && !fechaNacimientoM.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]) (0[0-9]|1[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$"));
        boolean verificacion3 = !correoM.isBlank() && !correoM.equals("Ingrese el correo electrónico") && !correoM.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
        boolean verificacion4 = (condicionOp1 && !condicionOp2) || (!condicionOp1 && condicionOp2);

        errorMessage.setVisible(false);

        if (!condicionesObligatorias) {
            errorMessage.setText("Error. Algunos campos son obligatorios*. Revisar");
            errorMessage.setVisible(true);
            return;
        } else {
            if (verificacion1) {
                errorMessage.setText("Error. La cédula no tiene el formato correcto.");
                errorMessage.setVisible(true);
                return;
            } else if (verificacion2) {
                errorMessage.setText("Error. La fecha de nacimiento no tiene el formato correcto. La fecha sin hora es obligatorio. YYYY-MM-DD");
                errorMessage.setVisible(true);
                return;
            } else if (verificacion3) {
                errorMessage.setText("Error. El correo electrónico no tiene el formato correcto.");
                errorMessage.setVisible(true);
                return;
            } else if (verificacion4) {
                errorMessage.setText("Error. La dirección o el distrito están incompletos. Debe llenar ambos o ninguno.");
                errorMessage.setVisible(true);
                return;
            } else {
                try {
                    Timestamp fechaNacimientoTimestamp;
                    if (fechaNacimientoM.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$")) {
                        fechaNacimientoTimestamp = Timestamp.valueOf(LocalDate.parse(fechaNacimientoM).atStartOfDay());
                    } else {
                        fechaNacimientoTimestamp = Timestamp.valueOf(fechaNacimientoM);
                    }

                    if (!condicionOp1 && !condicionOp2) {
                        if (!condicionOp3 && !condicionOp4) {
                            if (DB_DOCTOR.manipulatePaciente("admin", "admin1234", "Administrador", cedulaM, nombreM, apellidoM, fechaNacimientoTimestamp, sexoM, telefonoM, correoM, direccionM, distritoM) > 0) {
                                modificado = true;
                            }
                        } else if (!condicionOp3) {
                            if (DB_DOCTOR.manipulatePaciente("admin", "admin1234", "Administrador", cedulaM, nombreM, apellidoM, fechaNacimientoTimestamp, sexoM, null, correoM, direccionM, distritoM) > 0) {
                                modificado = true;
                            }
                        } else {
                            if (DB_DOCTOR.manipulatePaciente("admin", "admin1234", "Administrador", cedulaM, nombreM, apellidoM, fechaNacimientoTimestamp, sexoM, null, null, direccionM, distritoM) > 0) {
                                modificado = true;
                            }
                        }
                    } else if (!condicionOp3) {
                        if (!condicionOp4) {
                            if (DB_DOCTOR.manipulatePaciente("admin", "admin1234", "Administrador", cedulaM, nombreM, apellidoM, fechaNacimientoTimestamp, sexoM, telefonoM, correoM, null, null) > 0) {
                                modificado = true;
                            }
                        } else {
                            if (DB_DOCTOR.manipulatePaciente("admin", "admin1234", "Administrador", cedulaM, nombreM, apellidoM, fechaNacimientoTimestamp, sexoM, null, correoM, null, null) > 0) {
                                modificado = true;
                            }
                        }
                    } else if (!condicionOp4) {
                        if (DB_DOCTOR.manipulatePaciente("admin", "admin1234", "Administrador", cedulaM, nombreM, apellidoM, fechaNacimientoTimestamp, sexoM, telefonoM, null, null, null) > 0) {
                            modificado = true;
                        }
                    } else {
                        if (DB_DOCTOR.manipulatePaciente("admin", "admin1234", "Administrador", cedulaM, nombreM, apellidoM, fechaNacimientoTimestamp, sexoM, null, null, null, null) > 0) {
                            modificado = true;
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(this,
                            "Ha ocurrido un problema manipulando el paciente. No hay certeza si los datos fueron manipulados. " +
                                    "\nGuarde los datos para futuro registro. Reinicie la aplicación o contacte a soporte");
                }
            }
        }

        if (modificado) {
            JOptionPane.showMessageDialog(this, "Para confirmar los cambios de credenciales se cerrará el programa y debe iniciar sesión nuevamente.",
                    "Modificando datos...", JOptionPane.INFORMATION_MESSAGE);
            PARENT_FRAME.setVisible(true);
            PARENT_FRAME.requestFocus();
            this.dispose();
            jDialog_modificarCred.dispose();
            System.gc();
        } else {
            errorMessage.setText("Error al modificar los datos personales. Intente nuevamente o cierre esta ventana.");
            errorMessage.setVisible(true);
        }
    }

    /* eventos de jPanel inventario */
    private void jTextField_buscarTabla3ActionPerformed(ActionEvent evt) {
        jButton_buscar3MouseClicked(null);
    }

    private void jButton_buscar3MouseClicked(MouseEvent evt) {
        jTextField_buscarTabla3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jTextField_buscarTabla3.setForeground(Color.BLACK);

        String patronBuscado = jTextField_buscarTabla3.getText();
        if (!patronBuscado.isBlank() || !patronBuscado.equals("Buscar...")) {
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTable_Content_Inventario.getModel());
            jTable_Content_Inventario.setRowSorter(sorter);
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + patronBuscado));
        } else {
            jTextField_buscarTabla3.setBorder(BorderFactory.createLineBorder(Color.red));
            jTextField_buscarTabla3.setForeground(Color.red);
        }
    }

    private void jButton_acercar3MouseClicked(MouseEvent evt) {
        Font currentFont = jTable_Content_Inventario.getFont();
        jTable_Content_Inventario.setFont(currentFont.deriveFont(currentFont.getSize() + 2f));
    }

    private void jButton_alejar3MouseClicked(MouseEvent evt) {
        Font currentFont = jTable_Content_Inventario.getFont();
        jTable_Content_Inventario.setFont(currentFont.deriveFont(currentFont.getSize() - 2f));
    }

    private void jButton_ordenar3MouseClicked(MouseEvent evt) {
        jTable_Content_Inventario.setAutoCreateRowSorter(true);
    }

    private void jButton_filtros3MouseClicked(MouseEvent evt) {
        if (!jPanel_inventario.isAncestorOf(jPanel_filtrarInventario)) {
            jPanel_inventario.add(jPanel_filtrarInventario, BorderLayout.NORTH);
        } else {
            jPanel_inventario.remove(jPanel_filtrarInventario);
        }
        jPanel_inventario.revalidate();
        jPanel_inventario.repaint();
    }

    private void jButton_fuente3MouseClicked(MouseEvent evt) {
        boolean result = FONTCHOOSER_INVENTARIO.showDialog(this);
        if (result) {
            Font font = FONTCHOOSER_INVENTARIO.getSelectedFont();
            jTable_Content_Inventario.setFont(font);
            jTable_Content_Inventario.repaint();
        }
    }

    private void jButton_exportar3MouseClicked(MouseEvent evt) {
        /* TODO llamada al método exportar en csv o excel o pdf del jPanel inventario */
    }

    /* eventos de jPanel reporte y estadísticas */
    private void jTextField_buscarTabla4ActionPerformed(ActionEvent evt) {
        jButton_buscar4MouseClicked(null);
    }

    private void jButton_buscar4MouseClicked(MouseEvent evt) {
        String patronBuscado = jTextField_buscarTabla4.getText();
        if (!patronBuscado.isBlank() || !patronBuscado.equals("Buscar...")) {
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTable_Content_Estadisticas.getModel());
            jTable_Content_Estadisticas.setRowSorter(sorter);
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + patronBuscado));
        } else {
            jTextField_buscarTabla4.setBorder(BorderFactory.createLineBorder(Color.red));
            jTextField_buscarTabla4.setForeground(Color.red);
        }
    }

    private void jButton_acercar4MouseClicked(MouseEvent evt) {
        Font currentFont = jTable_Content_Estadisticas.getFont();
        jTable_Content_Estadisticas.setFont(currentFont.deriveFont(currentFont.getSize() + 2f));
    }

    private void jButton_alejar4MouseClicked(MouseEvent evt) {
        Font currentFont = jTable_Content_Estadisticas.getFont();
        jTable_Content_Estadisticas.setFont(currentFont.deriveFont(currentFont.getSize() - 2f));
    }

    private void jButton_ordenar4MouseClicked(MouseEvent evt) {
        jTable_Content_Estadisticas.setAutoCreateRowSorter(true);
    }

    private void jButton_filtros4MouseClicked(MouseEvent evt) {
        if (!jPanel_estadisticas.isAncestorOf(jPanel_filtrarEstadistica)) {
            jPanel_estadisticas.add(jPanel_filtrarEstadistica, BorderLayout.NORTH);
        } else {
            jPanel_estadisticas.remove(jPanel_filtrarEstadistica);
        }
        jPanel_estadisticas.revalidate();
        jPanel_estadisticas.repaint();
    }

    private void jButton_fuente4MouseClicked(MouseEvent evt) {
        boolean result = FONTCHOOSER_ESTADISTICAS.showDialog(this);
        if (result) {
            Font font = FONTCHOOSER_ESTADISTICAS.getSelectedFont();
            jTable_Content_Estadisticas.setFont(font);
            jTable_Content_Estadisticas.repaint();
        }
    }

    private void jButton_exportar4MouseClicked(MouseEvent evt) {
        /* TODO llamada al método exportar en csv o excel o pdf del jPanel estadísticas */
    }

    /* eventos de jPanels filtrar. Guiarse de método filterActionPerformed(); */
    private void jComboBox_filterColumn1ActionPerformed(ActionEvent evt) {
        String vacunaBuscarEstadistica = (String) jComboBox_filterColumn_vacuna_Estadisticas.getSelectedItem();

        TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTable_Content_Estadisticas.getModel());
        if (vacunaBuscarEstadistica == null || vacunaBuscarEstadistica.isBlank() || vacunaBuscarEstadistica.equals("Elegir")) {
            sorter.setRowFilter(RowFilter.regexFilter(".*", 5));
        } else {
            sorter.setRowFilter(new RowFilter<TableModel, Object>() {
                @Override
                public boolean include(RowFilter.Entry<? extends TableModel, ?> entry) {
                    return entry.getStringValue(5).contains(vacunaBuscarEstadistica.trim());
                }
            });
        }
        jTable_Content_Estadisticas.setRowSorter(sorter);
    }

    private void jComboBox_filterColumn2ActionPerformed(ActionEvent evt) {
        String vacunaBuscarInventario = (String) jComboBox_filterColumn_vacuna_Inventario.getSelectedItem();

        TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTable_Content_Inventario.getModel());
        if (vacunaBuscarInventario == null || vacunaBuscarInventario.isBlank() || vacunaBuscarInventario.equals("Elegir")) {
            sorter.setRowFilter(RowFilter.regexFilter(".*", 0));
        } else {
            sorter.setRowFilter(new RowFilter<TableModel, Object>() {
                @Override
                public boolean include(RowFilter.Entry<? extends TableModel, ?> entry) {
                    return entry.getStringValue(1).contains(vacunaBuscarInventario.trim());
                }
            });
        }
        jTable_Content_Inventario.setRowSorter(sorter);
    }

    private void jComboBox_filterColumn3ActionPerformed(ActionEvent evt) {
        String loteBuscarInventario = (String) jComboBox_filterColumn_lote_Inventario.getSelectedItem();

        TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTable_Content_Inventario.getModel());
        if (loteBuscarInventario == null || loteBuscarInventario.isBlank() || loteBuscarInventario.equals("Elegir")) {
            sorter.setRowFilter(RowFilter.regexFilter(".*", 2));
        } else {
            sorter.setRowFilter(new RowFilter<TableModel, Object>() {
                @Override
                public boolean include(RowFilter.Entry<? extends TableModel, ?> entry) {
                    return entry.getStringValue(3).contains(loteBuscarInventario.trim());
                }
            });
        }
        jTable_Content_Inventario.setRowSorter(sorter);
    }

    /* eventos de jPanel buscar paciente */
    private void jButton_exportar1MouseClicked(MouseEvent evt) {
        /* TODO llamada al método exportar en csv o excel o pdf del jPanel buscar Paciente */
    }

    private void jButton_fuente1MouseClicked(MouseEvent evt) {
        boolean result = FONTCHOOSER_BUSCAR_PACIENTE.showDialog(this);
        if (result) {
            Font font = FONTCHOOSER_BUSCAR_PACIENTE.getSelectedFont();
            jTable_Content_BuscarPacientes.setFont(font);
            jTable_Content_BuscarPacientes.repaint();
        }
    }

    private void jButton_filtros1MouseClicked(MouseEvent evt) {
        if (!jPanel_buscarPaciente.isAncestorOf(JPANEL_FILTRAR2)) {
            jPanel_buscarPaciente.add(JPANEL_FILTRAR2);
        } else {
            jPanel_buscarPaciente.remove(JPANEL_FILTRAR2);
        }
        jPanel_buscarPaciente.revalidate();
        jPanel_buscarPaciente.repaint();
    }

    private void jButton_ordenar1MouseClicked(MouseEvent evt) {
        jTable_Content_BuscarPacientes.setAutoCreateRowSorter(true);
    }

    private void jButton_alejar1MouseClicked(MouseEvent evt) {
        Font currentFont = jTable_Content_BuscarPacientes.getFont();
        jTable_Content_BuscarPacientes.setFont(currentFont.deriveFont(currentFont.getSize() - 2f));
    }

    private void jButton_acercar1MouseClicked(MouseEvent evt) {
        Font currentFont = jTable_Content_BuscarPacientes.getFont();
        jTable_Content_BuscarPacientes.setFont(currentFont.deriveFont(currentFont.getSize() + 2f));
    }

    private void jButton_buscar1MouseClicked(MouseEvent evt) {
        String patronBuscado = jTextField_buscarTabla2.getText();
        if (!patronBuscado.isBlank() || !patronBuscado.equals("Buscar...")) {
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTable_Content_BuscarPacientes.getModel());
            jTable_Content_BuscarPacientes.setRowSorter(sorter);
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + patronBuscado));
        } else {
            jTextField_buscarTabla2.setBorder(BorderFactory.createLineBorder(Color.red));
            jTextField_buscarTabla2.setForeground(Color.red);
        }
    }

    private void jTextField_buscarTabla1ActionPerformed(ActionEvent evt) {
        jButton_buscar1MouseClicked(null);
    }

    private void jButton1MouseClicked(MouseEvent evt) {
        String patron = jTextField_buscarPaciente.getText();
        Resultados r = null;
        try {
            switch ((String) jComboBox_buscarPaciente1.getSelectedItem()) {
                case "Cédula" -> {
                    if (!patron.matches("^(PE|E|N|[23456789](?:AV|PI)?|1[0123]?(?:AV|PI)?)-(\\d{1,4})-(\\d{1,6})$")) {
                        JOptionPane.showMessageDialog(this, "La cédula del paciente a buscar no tiene el formato correcto.");
                        return;
                    }
                    r = DB_DOCTOR.searchPaciente("admin", "admin1234", "Administrador", patron, null, null);
                    if (r == null || r.getDatos().length == 0) {
                        r = DB_DOCTOR.searchTablePaciente("admin", "admin1234", "Administrador", patron, null, null);
                    }
                }
                case "Nombre completo" -> {
                    r = DB_DOCTOR.searchPaciente("admin", "admin1234", "Administrador", null, patron, null);
                    if (r == null || r.getDatos().length == 0) {
                        r = DB_DOCTOR.searchTablePaciente("admin", "admin1234", "Administrador", null, patron, null);
                    }
                }
                case "Fecha de nacimiento" -> {
                    if (!patron.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$") &&
                            !jTextField_buscarPaciente.getText().matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]) (0[0-9]|1[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$")) {
                        JOptionPane.showMessageDialog(this, "La fecha de nacimiento del paciente a buscar no tiene el formato correcto. Mínimo YYYY-MM-DD");
                        return;
                    }
                    r = DB_DOCTOR.searchPaciente("admin", "admin1234", "Administrador", null, null, patron);
                    if (r == null || r.getDatos().length == 0) {
                        r = DB_DOCTOR.searchPaciente("admin", "admin1234", "Administrador", null, null, patron);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Ha ocurrido un problema buscando los datos del paciente. Reinicie la aplicación o contacte a soporte");
        }

        if (r != null) {
            jTable_Content_BuscarPacientes.setModel(new DefaultTableModel(r.getDatos(), r.getColumnas()) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            });
            JPANEL_FILTRAR2.setColumns(r.getColumnas());
            PantallaBase.adjustColumnWidths(jTable_Content_BuscarPacientes);
            // Ajustar automáticamente el ancho de las columnas cuando se redimensiona el JFrame
            jScrollPane_Table2_BuscarPacientes.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    PantallaBase.adjustColumnWidths(jTable_Content_BuscarPacientes);
                }
            });
            jTable_Content_BuscarPacientes.repaint();
            jTable_Content_BuscarPacientes.revalidate();
            jScrollPane_Table2_BuscarPacientes.revalidate();
            jScrollPane_Table2_BuscarPacientes.repaint();
        } else {
            JOptionPane.showMessageDialog(this, "No se encontraron pacientes con los datos suministrados. Registre al paciente.");
        }
    }

    private void jTextField1ActionPerformed(ActionEvent evt) {
        jButton1MouseClicked(null);
    }

    private void jPanel_buscarPacienteAncestorAdded(AncestorEvent evt) {
        jTextField_buscarPaciente.requestFocus();
    }

    /* eventos de jPanel buscar dosis de vacuna */
    private void jTextField_buscarTabla5ActionPerformed(ActionEvent evt) {
        jButton_buscar5MouseClicked(null);
    }

    private void jButton_buscar5MouseClicked(MouseEvent evt) {
        String patronBuscado = jTextField_buscarTabla5.getText();
        if (!patronBuscado.isBlank() || !patronBuscado.equals("Buscar...")) {
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTable_Content_BuscarDosis.getModel());
            jTable_Content_BuscarDosis.setRowSorter(sorter);
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + patronBuscado));
        } else {
            jTextField_buscarTabla5.setBorder(BorderFactory.createLineBorder(Color.red));
            jTextField_buscarTabla5.setForeground(Color.red);
        }
    }

    private void jButton_acercar5MouseClicked(MouseEvent evt) {
        Font currentFont = jTable_Content_BuscarDosis.getFont();
        jTable_Content_BuscarDosis.setFont(currentFont.deriveFont(currentFont.getSize() + 2f));
    }

    private void jButton_alejar5MouseClicked(MouseEvent evt) {
        Font currentFont = jTable_Content_BuscarDosis.getFont();
        jTable_Content_BuscarDosis.setFont(currentFont.deriveFont(currentFont.getSize() - 2f));
    }

    private void jButton_ordenar5MouseClicked(MouseEvent evt) {
        jTable_Content_BuscarDosis.setAutoCreateRowSorter(true);
    }

    private void jButton_filtros5MouseClicked(MouseEvent evt) {
        if (!jPanel_buscarDosis.isAncestorOf(JPANEL_FILTRAR3)) {
            jPanel_buscarDosis.add(JPANEL_FILTRAR3);
        } else {
            jPanel_buscarDosis.remove(JPANEL_FILTRAR3);
        }
        jPanel_buscarDosis.revalidate();
        jPanel_buscarDosis.repaint();
    }

    private void jButton_fuente5MouseClicked(MouseEvent evt) {
        boolean result = FONTCHOOSER_BUSCAR_DOSIS.showDialog(this);
        if (result) {
            Font font = FONTCHOOSER_BUSCAR_DOSIS.getSelectedFont();
            jTable_Content_BuscarDosis.setFont(font);
            jTable_Content_BuscarDosis.repaint();
        }
    }

    private void jButton_exportar5MouseClicked(MouseEvent evt) {
        /* TODO llamada al método exportar en csv o excel o pdf del jPanel buscar dosis */
    }

    private void jPanel_buscarDosisAncestorAdded(AncestorEvent evt) {
        jTextField_fecha_inicio.requestFocus();
    }

    private void jComboBox4ActionPerformed(ActionEvent evt) {
        jButton2MouseClicked(null);
    }

    private void jButton2MouseClicked(MouseEvent evt) {
        String fecha_inicio = jTextField_fecha_inicio.getText();
        String fecha_fin = jTextField_fecha_fin.getText();
        int sede = jComboBox_sede1.getSelectedIndex() - 1;
        int vacuna = jComboBox_vacuna1.getSelectedIndex() - 1;
        String num_dosis = (String) jComboBox_num_dosis1.getSelectedItem();
        Resultados r = null;

        boolean condicion1 = sede == -1;
        boolean condicion2 = fecha_inicio.isBlank() || fecha_inicio.equals("Buscar desde la fecha AAAA-MM-DD...");
        boolean condicion3 = fecha_fin.isBlank() || fecha_fin.equals("Buscar hasta la fecha AAAA-MM-DD...");
        boolean condicion4 = vacuna == -1;
        boolean condicion5 = num_dosis == null || num_dosis.isBlank() || num_dosis.equals("Elegir");
        /* verificar formato de fechas si se usaron */
        boolean verificacion1 = (!fecha_inicio.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$") && !fecha_inicio.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]) (0[0-9]|1[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$"));
        boolean verificacion2 = (!fecha_fin.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$") && !fecha_fin.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]) (0[0-9]|1[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$"));

        /* Mostrar errores de formato de fecha */
        if (!condicion2 && verificacion1) {
            JOptionPane.showMessageDialog(this, "Error: Formato de fecha incorrecto en el campo 'Desde la fecha'. Debe ser AAAA-MM-DD.", "Error al buscar dosis...", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!condicion3 && verificacion2) {
            JOptionPane.showMessageDialog(this, "Error: Formato de fecha incorrecto en el campo 'Hasta la fecha'. Debe ser AAAA-MM-DD.", "Error al buscar dosis...", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (condicion1 && condicion2 && condicion3 && condicion4 && condicion5) {
            JOptionPane.showMessageDialog(this, "Error. Debe ingresar algún patrón de búsqueda para obtener resultados.", "Error al buscar dosis...", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                if (!condicion1) {
                    if (!condicion2 && !condicion3 && !condicion4 && !condicion5) {
                        r = DB_DOCTOR.buscarDosis("admin", "admin1234", "Administrador", fecha_inicio, fecha_fin, sede, vacuna, DatabaseOperaciones.getNumDosis(num_dosis));
                    } else if (!condicion2 && !condicion3 && !condicion4) {
                        r = DB_DOCTOR.buscarDosis("admin", "admin1234", "Administrador", fecha_inicio, fecha_fin, sede, vacuna, null);
                    } else if (!condicion2 && !condicion3) {
                        r = DB_DOCTOR.buscarDosis("admin", "admin1234", "Administrador", fecha_inicio, fecha_fin, sede, -1, null);
                    } else if (!condicion4 && !condicion5) {
                        r = DB_DOCTOR.buscarDosis("admin", "admin1234", "Administrador", null, null, sede, vacuna, DatabaseOperaciones.getNumDosis(num_dosis));
                    } else if (!condicion4) {
                        r = DB_DOCTOR.buscarDosis("admin", "admin1234", "Administrador", null, null, sede, vacuna, null);
                    } else if (!condicion5) {
                        r = DB_DOCTOR.buscarDosis("admin", "admin1234", "Administrador", null, null, sede, -1, DatabaseOperaciones.getNumDosis(num_dosis));
                    } else {
                        r = DB_DOCTOR.buscarDosis("admin", "admin1234", "Administrador", null, null, sede, -1, null);
                    }
                } else if (!condicion2 && !condicion3) {
                    if (!condicion4 && !condicion5) {
                        r = DB_DOCTOR.buscarDosis("admin", "admin1234", "Administrador", fecha_inicio, fecha_fin, -1, vacuna, DatabaseOperaciones.getNumDosis(num_dosis));
                    } else if (!condicion4) {
                        r = DB_DOCTOR.buscarDosis("admin", "admin1234", "Administrador", fecha_inicio, fecha_fin, -1, vacuna, null);
                    } else if (!condicion5) {
                        r = DB_DOCTOR.buscarDosis("admin", "admin1234", "Administrador", fecha_inicio, fecha_fin, -1, -1, DatabaseOperaciones.getNumDosis(num_dosis));
                    } else {
                        r = DB_DOCTOR.buscarDosis("admin", "admin1234", "Administrador", fecha_inicio, fecha_fin, -1, -1, null);
                    }
                } else if (!condicion4) {
                    if (!condicion5) {
                        r = DB_DOCTOR.buscarDosis("admin", "admin1234", "Administrador", null, null, -1, vacuna, DatabaseOperaciones.getNumDosis(num_dosis));
                    } else {
                        r = DB_DOCTOR.buscarDosis("admin", "admin1234", "Administrador", null, null, -1, vacuna, null);
                    }
                } else if (!condicion5) {
                    r = DB_DOCTOR.buscarDosis("admin", "admin1234", "Administrador", null, null, -1, -1, DatabaseOperaciones.getNumDosis(num_dosis));
                }
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(this, "Ha ocurrido un problema buscando la dosis. Reinicie la aplicación o contacte a soporte");
            }
        }

        if (r != null) {
            jTable_Content_BuscarDosis.setModel(new DefaultTableModel(r.getDatos(), r.getColumnas()) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            });
            JPANEL_FILTRAR3.setColumns(r.getColumnas());
            PantallaBase.adjustColumnWidths(jTable_Content_BuscarDosis);
            // Ajustar automáticamente el ancho de las columnas cuando se redimensiona el JFrame
            jScrollPane_Table5_BuscarDosis.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    PantallaBase.adjustColumnWidths(jTable_Content_BuscarDosis);
                }
            });
            jTable_Content_BuscarDosis.repaint();
            jTable_Content_BuscarDosis.revalidate();
            jScrollPane_Table5_BuscarDosis.revalidate();
            jScrollPane_Table5_BuscarDosis.repaint();
        }
    }

    private void jComboBox3ActionPerformed(ActionEvent evt) {
        jComboBox_num_dosis1.requestFocus();
    }

    /* eventos del jPanel insertar dosis */
    private void jTextField_cedula3ActionPerformed(ActionEvent evt) {
        try {
            Resultados rPaciente = DB_DOCTOR.searchTablePaciente("admin", "admin1234", "Administrador", jTextField_cedula3.getText(), null, null);
            if (rPaciente != null && rPaciente.getDatos().length > 0) {
                jTextArea5_pacienteVacunar.setVisible(true);
                jTextArea5_pacienteVacunar.setText("Cédula | Nombre | Apellido | Fecha de nacimiento | Edad | Sexo | Teléfono | Correo electrónico | ID Dirección |\n" + rPaciente);
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo obtener la información del paciente. Debe registrarlo antes de insertar una dosis");
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Ha ocurrido un problema buscando los datos del paciente a vacunar. Reinicie la aplicación o contacte a soporte");
        }
        jTextField_fechaAplicacion1.requestFocus();
    }

    private void jComboBox_vacuna2ActionPerformed(ActionEvent evt) {
        int sede = jComboBox_sede2.getSelectedIndex();
        int vacuna = jComboBox_sede2.getSelectedIndex();

        if (sede != 0 && sede != 1 && vacuna != 0 && vacuna != 1) {
            try {
                Resultados rLotes = DB_DOCTOR.showSedeInventarioVacuna("admin", "admin1234", "Administrador", sede - 1, vacuna - 1);
                if (rLotes != null && rLotes.getDatos().length > 0) {
                    jComboBox_lote.setModel(new DefaultComboBoxModel<>(PantallaBase.transformMatrizToArray(rLotes.getDatos(), 6)));
                } else {
                    jTextArea6_lote.setVisible(true);
                    jTextArea6_lote.setText("No se pudo obtener la información de los lotes. Recomendamos tener un inventario de la sede. " +
                            "\nPuede seguir registrando, si ocurre un error se le avisará.");
                }
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(this, "Ha ocurrido un problema buscando los lotes del inventario de la sede. Reinicie la aplicación o contacte a soporte");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Consejo: Debe registrar la sede y luego la vacuna para buscar los lotes en el inventario si existen. Puede seguir registrando.");
        }
    }

    private void jComboBox_loteActionPerformed(ActionEvent evt) {
        try {
            Resultados rLotes = DB_DOCTOR.showLoteSedeVacuna("admin", "admin1234", "Administrador", (String) jComboBox_lote.getSelectedItem());
            if (rLotes != null && rLotes.getDatos().length > 0) {
                jTextArea6_lote.setVisible(true);
                jTextArea6_lote.setText("Sede | Dependencia sede | Vacuna | Cantidad disponible | Lote | Fecha lote |\n" + rLotes);
            } else {
                jTextArea6_lote.setVisible(true);
                jTextArea6_lote.setText("No se pudo obtener la información de los lotes. Recomendamos tener un inventario de la sede. " +
                        "\nPuede seguir registrando, si ocurre un error se le avisará.");
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Ha ocurrido un problema buscando los lotes del inventario de la sede. Reinicie la aplicación o contacte a soporte");
        }
    }

    private void jButton_insertarDosisMouseClicked(MouseEvent evt) {
        if (!jButton_insertarDosis.isEnabled()) {
            return;
        }

        jButton_insertarDosis.setEnabled(false);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                jButton_insertarDosis.setEnabled(true);
            }
        }, INSERTAR_DOSIS_DISABLE_TIME);

        boolean modificado = false;
        String cedulaM = jTextField_cedula3.getText();
        String fechaAplicacionM = jTextField_fechaAplicacion1.getText();
        String numero_dosis = (String) jComboBox_numDosis2.getSelectedItem();
        int idVacuna = jComboBox_vacuna2.getSelectedIndex() - 1;
        int idSede = jComboBox_sede2.getSelectedIndex() - 1;
        String lote = (String) jComboBox_lote.getSelectedItem();

        boolean condicion1 = cedulaM.isBlank() || cedulaM.equals("Ingrese la cédula del paciente");
        boolean condicion2 = fechaAplicacionM.isBlank() || fechaAplicacionM.equals("Ingrese la fecha de aplicación YYYY-MM-DD hh:mm:ss*");
        boolean condicion3 = numero_dosis == null || numero_dosis.isBlank() || numero_dosis.equals("Elegir");
        boolean condicion4 = idVacuna == -1;
        boolean condicion5 = idSede == -1;
        boolean condicionesObligatorias = !condicion1 && !condicion2 && !condicion3 && !condicion4 && !condicion5;
        boolean condicionOp1 = lote == null || lote.equals("Elegir");

        boolean verificacion1 = !cedulaM.matches("^(PE|E|N|[23456789](?:AV|PI)?|1[0123]?(?:AV|PI)?)-(\\d{1,4})-(\\d{1,6})$");
        boolean verificacion2 = (!fechaAplicacionM.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$") && !fechaAplicacionM.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]) (0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9](\\.\\d{1,9})?$"));

        errorMessage1.setVisible(false);

        if (!condicionesObligatorias) {
            errorMessage1.setText("Error. Algunos campos son obligatorios*. Revisar");
            errorMessage1.setVisible(true);
            return;
        } else {
            if (verificacion1) {
                errorMessage1.setText("Error. La cédula no tiene el formato correcto.");
                errorMessage1.setVisible(true);
                return;
            } else if (verificacion2) {
                errorMessage1.setText("Error. La fecha de nacimiento no tiene el formato correcto. La fecha sin hora es obligatorio. YYYY-MM-DD");
                errorMessage1.setVisible(true);
                return;
            } else {
                try {
                    Timestamp fechaAplicacionTimestamp;
                    if (fechaAplicacionM.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$")) {
                        fechaAplicacionTimestamp = Timestamp.valueOf(LocalDate.parse(fechaAplicacionM).atStartOfDay());
                        jTextArea6_lote.setVisible(true);
                        jTextArea6_lote.setText("Recomendación: Debe ingresar las fechas con hora, se registrará de todas formas.");
                    } else {
                        fechaAplicacionTimestamp = Timestamp.valueOf(fechaAplicacionM);
                    }

                    if (!condicionOp1) {
                        if (DB_DOCTOR.insertarDosis("admin", "admin1234", "Administrador", cedulaM, fechaAplicacionTimestamp, numero_dosis, idVacuna, idSede, lote) > 0) {
                            modificado = true;
                        }
                    } else {
                        jTextArea6_lote.setVisible(true);
                        jTextArea6_lote.setText("No se pudo obtener la información de los lotes. Recomendamos tener un inventario de la sede. " +
                                "\nPuede seguir registrando, si ocurre un error se le avisará.");
                        if (DB_DOCTOR.insertarDosis("admin", "admin1234", "Administrador", cedulaM, fechaAplicacionTimestamp, numero_dosis, idVacuna, idSede, null) > 0) {
                            modificado = true;
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(this,
                            "Ha ocurrido un problema insertando una dosis. No hay certeza si los datos fueron manipulados. " +
                                    "\nGuarde los datos para futuro registro. " +
                                    "\nEl error fue: " + e.getMessage() +
                                    "\nSi no puede corregir usted el error contacte a soporte o reinicie la aplicación.");
                }
            }
        }

        if (modificado) {
            JOptionPane.showMessageDialog(this,
                    "Esta información se procesará y puede tardar unos segundos para mostrar en otras pestañas. " +
                            "\nEl paciente podrá ver su dosis ingresando con sus credenciales.",
                    "Insertando dosis paciente vacunado...", JOptionPane.INFORMATION_MESSAGE);
            // TODO limpiar los campos
        } else {
            errorMessage.setText("Error al modificar los datos del paciente.");
            errorMessage.setVisible(true);
        }
    }

    /* evento único de jPanel preferencias */
    private void jButton_savePreferencesMouseClicked(MouseEvent evt) {
        int size = (int) fontSizeSpinner.getValue();
        String font = (String) familyComboBox.getSelectedItem();
        int style = styleComboBox.getSelectedIndex();
        int sede = jComboBox_sede_preferida.getSelectedIndex();
        String filetype = (String) jComboBox_exportarType_preferido.getSelectedItem();
        Preferencias p = userActual.getPrefs();
        p.setPrefs(font, style, size, sede, filetype);
        actualizarPreferencias(p);
        JOptionPane.showMessageDialog(this, "¡Se han guardado sus preferencias!");
    }

    /* eventos del jDialog modificar credenciales del usuario doctor */
    private void jButton_modificar2MouseClicked(MouseEvent evt) {
        if (!jButton_modificar2.isEnabled()) {
            return;
        }

        jButton_modificar2.setEnabled(false);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                jButton_modificar2.setEnabled(true);
            }
        }, MODIFY_USER_DISABLE_TIME);


        boolean cambiado;
        String usuario = jTextField_usuario_Viejo.getText();
        String usuarioNuevo = jTextField_usuarioNuevo.getText();
        boolean condicion1 = usuario.isBlank() || usuario.equals("Ingrese su usuario");
        boolean condicion2 = usuarioNuevo.isBlank() || usuarioNuevo.equals("Ingrese un usuario nuevo");
        boolean condicion3 = String.valueOf(jPasswordField_vieja.getPassword()).isBlank() || String.valueOf(jPasswordField_vieja.getPassword()).equals("Ingrese su contraseña");
        boolean condicion4 = String.valueOf(jPasswordField_nueva1.getPassword()).isBlank() || String.valueOf(jPasswordField_nueva1.getPassword()).equals("Ingrese una contraseña nueva");
        boolean condicion5 = String.valueOf(jPasswordField_nueva2.getPassword()).isBlank() || String.valueOf(jPasswordField_nueva2.getPassword()).equals("Ingrese una contraseña nueva");

        errorMessage2.setVisible(false);
        repetir_contrasena.setForeground(Color.black);
        jPasswordField_nueva2.setForeground(Color.gray);
        contrasena.setForeground(Color.black);
        jPasswordField_nueva1.setForeground(Color.gray);
        contrasena_anterior.setForeground(Color.black);
        jPasswordField_vieja.setForeground(Color.gray);
        if (condicion1 || condicion3) {
            errorMessage2.setText("Error. Los campos usuario y contraseña anterior son obligatorios.");
            errorMessage2.setVisible(true);
            return;
        } else if (!InicioSesion.autentificar(usuario, String.valueOf(jPasswordField_vieja.getPassword()), "Doctor - Enfermera")) {
            contrasena_anterior.setForeground(Color.red);
            jPasswordField_vieja.setForeground(Color.red);
            errorMessage2.setText("Error. La contraseña anterior no coincide. Cambios cancelado");
            errorMessage2.setVisible(true);
            return;
        } else {
            if (!condicion2) {
                if (!condicion4 && !condicion5) {
                    if (!String.valueOf(jPasswordField_nueva1.getPassword()).equals(String.valueOf(jPasswordField_nueva2.getPassword()))) {
                        repetir_contrasena.setForeground(Color.red);
                        jPasswordField_nueva2.setForeground(Color.red);
                        contrasena.setForeground(Color.red);
                        jPasswordField_nueva1.setForeground(Color.red);
                        errorMessage2.setText("Error. Las contraseñas nuevas no son iguales.");
                        errorMessage2.setVisible(true);
                        return;
                    } else {
                        cambiado = InicioSesion.modificarCredenciales(cedulaUsuarioActual, usuarioNuevo, String.valueOf(jPasswordField_nueva1.getPassword()), "Doctor - Enfermera");
                    }
                } else {
                    cambiado = InicioSesion.modificarCredenciales(cedulaUsuarioActual, usuarioNuevo, String.valueOf(jPasswordField_vieja.getPassword()), "Doctor - Enfermera");
                }
            } else if (!condicion4 && !condicion5) {
                if (!String.valueOf(jPasswordField_nueva1.getPassword()).equals(String.valueOf(jPasswordField_nueva2.getPassword()))) {
                    repetir_contrasena.setForeground(Color.red);
                    jPasswordField_nueva2.setForeground(Color.red);
                    contrasena.setForeground(Color.red);
                    jPasswordField_nueva1.setForeground(Color.red);
                    errorMessage2.setText("Error. Las contraseñas nuevas no son iguales.");
                    errorMessage2.setVisible(true);
                    return;
                } else {
                    cambiado = InicioSesion.modificarCredenciales(cedulaUsuarioActual, usuario, String.valueOf(jPasswordField_nueva1.getPassword()), "Doctor - Enfermera");
                }
            } else {
                errorMessage2.setText("Error: ninguna credencial fue cambiada, debe modificar el usuario o la contraseña");
                errorMessage2.setVisible(true);
                return;
            }
        }

        if (cambiado) {
            JOptionPane.showMessageDialog(this, "Para confirmar los cambios de credenciales se cerrará el programa y debe iniciar sesión nuevamente.",
                    "Modificando datos...", JOptionPane.INFORMATION_MESSAGE);
            PARENT_FRAME.setVisible(true);
            PARENT_FRAME.requestFocus();
            this.dispose();
            jDialog_modificarCred.dispose();
            System.gc();
        } else {
            errorMessage2.setText("Error al modificar los credenciales del usuario. Intente nuevamente o cierre esta ventana.");
            errorMessage2.setVisible(true);
        }
    }

    private void jPasswordField_nueva2ActionPerformed(ActionEvent evt) {
        jButton_modificar2MouseClicked(null);
    }

    private void jButton_cancelar2MouseClicked(MouseEvent evt) {
        jDialog_modificarCred.dispose();
    }

    /* método para colocar el nombre al iniciar sesión */
    private void personalizarVentana(Usuario userActual) {
        this.userActual = userActual;
        cedulaUsuarioActual = this.userActual.getCedula();
        this.nombreBienvenida.setText(this.userActual.getNombre() + " " + this.userActual.getApellido());
        actualizarPreferencias(userActual.getPrefs());
    }

    /* método para actualizar las preferencias del doctor actual */
    private void actualizarPreferencias(Preferencias pref) {
        String font = pref.getFontName();
        int style = pref.getFontStyle(), size = pref.getFontSize();
        Font f = new Font(font, style, size);
        jTable_Content_MisPacientes.setFont(f);
        jTable_Content_BuscarPacientes.setFont(f);
        jTable_Content_Inventario.setFont(f);
        jTable_Content_Estadisticas.setFont(f);
        jTable_Content_BuscarDosis.setFont(f);
        fontSizeSpinner.setValue(size);
        familyComboBox.setSelectedItem(font);
        styleComboBox.setSelectedIndex(style);
        jComboBox_exportarType_preferido.setSelectedItem(pref.getExportFileType());

        try {
            jComboBox_sede_preferida.setModel(new DefaultComboBoxModel<>(PantallaBase.transformMatrizToArray(DB_DOCTOR.getSedes("admin", "admin1234", "Administrador"), 0)));
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Ha ocurrido un problema encontrando las sedes. Reinicie la aplicación o contacte a soporte");
        }
        jComboBox_sede_preferida.setSelectedIndex(pref.getSede());
        FONTCHOOSER_PACIENTE.setPreferences(font, style, size);
        FONTCHOOSER_INVENTARIO.setPreferences(font, style, size);
        FONTCHOOSER_BUSCAR_PACIENTE.setPreferences(font, style, size);
        FONTCHOOSER_BUSCAR_DOSIS.setPreferences(font, style, size);
        FONTCHOOSER_ESTADISTICAS.setPreferences(font, style, size);
    }

    /* método para añadir los listeners */
    private void addListeners() {
        JTextField[] fieldsBuscar = {jTextField_buscarTabla1, jTextField_buscarTabla2, jTextField_buscarTabla3, jTextField_buscarTabla4, jTextField_buscarTabla5};
        for (JTextField field : fieldsBuscar) {
            PantallaBase.addFocusListeners(field, "Buscar...");
        }
        // manipular paciente
        PantallaBase.addFocusListeners(jTextField_cedula2, "Ingrese cédula a buscar");
        PantallaBase.addFocusListeners(jTextField_nombre1, "Ingrese el nombre");
        PantallaBase.addFocusListeners(jTextField_apellido1, "Ingrese el apellido");
        PantallaBase.addFocusListeners(jTextField_cedula1, "Ingrese la cédula");
        PantallaBase.addFocusListeners(jTextField_fechaNacimiento1, "Ingrese la fecha de nacimiento YYYY-MM-DD* hh:mm:ss");
        PantallaBase.addFocusListeners(jTextField_direccion1, "Ingrese la dirección");
        PantallaBase.addFocusListeners(jTextField_correo1, "Ingrese el correo electrónico");
        PantallaBase.addFocusListeners(jTextField_telefono1, "Ingrese el código de país, el código de ciudad y el número de teléfono local");

        // modificar datos usuario doctor
        PantallaBase.addFocusListeners(jTextField_nombre, "Ingrese su nombre");
        PantallaBase.addFocusListeners(jTextField_apellido, "Ingrese su apellido");
        PantallaBase.addFocusListeners(jTextField_direccion, "Ingrese su dirección");
        PantallaBase.addFocusListeners(jTextField_correo, "Ingrese su correo electrónico");
        PantallaBase.addFocusListeners(jTextField_telefono, "Ingrese el código de país, el código de ciudad y el número local");

        // modificar credenciales
        PantallaBase.addFocusListeners(jTextField_usuario_Viejo, "Ingrese su usuario");
        PantallaBase.addFocusListeners(jTextField_usuarioNuevo, "Ingrese un usuario nuevo");
        PantallaBase.addFocusListeners(jPasswordField_vieja, "Ingrese su contraseña");
        PantallaBase.addFocusListeners(jPasswordField_nueva1, "Ingrese una contraseña nueva");
        PantallaBase.addFocusListeners(jPasswordField_nueva2, "Repita su contraseña nueva");

        // buscar paciente
        PantallaBase.addFocusListeners(jTextField_buscarPaciente, "Buscar paciente...");
        // buscar dosis
        PantallaBase.addFocusListeners(jTextField_fecha_inicio, "Buscar desde la fecha AAAA-MM-DD...");
        PantallaBase.addFocusListeners(jTextField_fecha_fin, "Buscar hasta la fecha AAAA-MM-DD...");
        // insertar dosis
        PantallaBase.addFocusListeners(jTextField_cedula3, "Ingrese la cédula del paciente");
        PantallaBase.addFocusListeners(jTextField_fechaAplicacion1, "Ingrese la fecha de aplicación YYYY-MM-DD hh:mm:ss*");

        // Action Listener
        // buscar dosis
        PantallaBase.addActionListeners(jTextField_fecha_inicio, jTextField_fecha_fin);
        PantallaBase.addActionListeners(jTextField_fecha_fin, jComboBox_vacuna1);
        PantallaBase.addActionListeners(jTextField_fechaAplicacion1, jComboBox_sede2);

        // modificar datos usuario doctor
        PantallaBase.addActionListeners(jTextField_nombre, jTextField_apellido);
        PantallaBase.addActionListeners(jTextField_apellido, jTextField_cedula);
        PantallaBase.addActionListeners(jTextField_cedula, jTextField_fechaNacimiento);
        PantallaBase.addActionListeners(jTextField_fechaNacimiento, jTextField_direccion);
        PantallaBase.addActionListeners(jTextField_correo, jTextField_telefono);

        // modificar credenciales
        PantallaBase.addActionListeners(jTextField_usuario_Viejo, jTextField_usuarioNuevo);
        PantallaBase.addActionListeners(jTextField_usuarioNuevo, jPasswordField_vieja);
        PantallaBase.addActionListeners(jPasswordField_vieja, jPasswordField_nueva1);
        PantallaBase.addActionListeners(jPasswordField_nueva1, jPasswordField_nueva2);

        // manipular pacientes
        PantallaBase.addActionListeners(jTextField_nombre1, jTextField_apellido1);
        PantallaBase.addActionListeners(jTextField_apellido1, jTextField_cedula1);
        PantallaBase.addActionListeners(jTextField_cedula1, jTextField_fechaNacimiento1);
        PantallaBase.addActionListeners(jTextField_fechaNacimiento1, jTextField_direccion1);
        PantallaBase.addActionListeners(jTextField_correo1, jTextField_telefono1);
    }

    /* método main para pruebas unitarias */
    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PantallaDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }

        SwingUtilities.invokeLater(() -> new PantallaDoctor(
                new Login(),
                new Usuario(null, null, "8-1024-1653", Timestamp.valueOf("2005-12-12 00:00:00"), null, null, null, null, "admin", "admin1234")).setVisible(true));
    }

    /* variables propias */
    private final CardLayout LAYOUT;
    private final DatabaseOperaciones DB_DOCTOR;
    private final JFontChooser FONTCHOOSER_PACIENTE;
    private final JFontChooser FONTCHOOSER_INVENTARIO;
    private final JFontChooser FONTCHOOSER_BUSCAR_PACIENTE;
    private final JFontChooser FONTCHOOSER_BUSCAR_DOSIS;
    private final JFontChooser FONTCHOOSER_ESTADISTICAS;
    private final JFrame PARENT_FRAME;
    private final JTableFiltrar JPANEL_FILTRAR1;
    private final JTableFiltrar JPANEL_FILTRAR2;
    private final JTableFiltrar JPANEL_FILTRAR3;
    private final long INSERTAR_DOSIS_DISABLE_TIME = 5000;
    private final long MANIPULATE_PACIENTE_DISABLE_TIME = 15000;
    private final long MODIFY_USER_DISABLE_TIME = 100000;
    private final long OPTIONS_DISABLE_TIME = 10000;
    private final long SEARCH_PACIENTE_DISABLE_TIME = 5000;
    private boolean editar;
    private boolean editarPaciente;
    private Component mostrando = null;
    private Object[][] datosEncontrados;
    private String cedulaUsuarioActual;
    private Usuario userActual;

    // Variables declaration - do not modify
    private JButton button_logOut;
    private JButton button_modificarCred;
    private JButton button_modificarDatos;
    private JButton button_opcion1;
    private JButton button_opcion2;
    private JButton button_opcion3;
    private JButton button_opcion4;
    private JButton button_opcion5;
    private JButton button_opcion6;
    private JButton button_opcion7;
    private JButton button_opcion8;
    private JButton button_preferencias;
    private JButton button_soporte;
    private JButton jButton_acercar;
    private JButton jButton_acercar1;
    private JButton jButton_acercar3;
    private JButton jButton_acercar4;
    private JButton jButton_acercar5;
    private JButton jButton_alejar;
    private JButton jButton_alejar1;
    private JButton jButton_alejar3;
    private JButton jButton_alejar4;
    private JButton jButton_alejar5;
    private JButton jButton_buscar;
    private JButton jButton_buscar1;
    private JButton jButton_buscar3;
    private JButton jButton_buscar4;
    private JButton jButton_buscar5;
    private JButton jButton_buscarPacienteEditar;
    private JButton jButton_cancelar;
    private JButton jButton_cancelar2;
    private JButton jButton_exportar;
    private JButton jButton_exportar1;
    private JButton jButton_exportar3;
    private JButton jButton_exportar4;
    private JButton jButton_exportar5;
    private JButton jButton_filtros;
    private JButton jButton_filtros1;
    private JButton jButton_filtros3;
    private JButton jButton_filtros4;
    private JButton jButton_filtros5;
    private JButton jButton_fuente;
    private JButton jButton_fuente1;
    private JButton jButton_fuente3;
    private JButton jButton_fuente4;
    private JButton jButton_fuente5;
    private JButton jButton_insertarDosis;
    private JButton jButton_modificar;
    private JButton jButton_modificar1;
    private JButton jButton_modificar2;
    private JButton jButton_ordenar;
    private JButton jButton_ordenar1;
    private JButton jButton_ordenar3;
    private JButton jButton_ordenar4;
    private JButton jButton_ordenar5;
    private JButton jButton_savePreferences;
    private JButton jButton1_lupaIcon;
    private JButton jButton2_lupaIcon;
    private JComboBox<String> familyComboBox;
    private JComboBox<String> jComboBox_buscarPaciente1;
    private JComboBox<String> jComboBox_distrito;
    private JComboBox<String> jComboBox_distrito1;
    private JComboBox<String> jComboBox_exportarType_preferido;
    private JComboBox<String> jComboBox_filterColumn_lote_Inventario;
    private JComboBox<String> jComboBox_filterColumn_vacuna_Estadisticas;
    private JComboBox<String> jComboBox_filterColumn_vacuna_Inventario;
    private JComboBox<String> jComboBox_lote;
    private JComboBox<String> jComboBox_num_dosis1;
    private JComboBox<String> jComboBox_numDosis2;
    private JComboBox<String> jComboBox_sede_preferida;
    private JComboBox<String> jComboBox_sede1;
    private JComboBox<String> jComboBox_sede2;
    private JComboBox<String> jComboBox_sexo;
    private JComboBox<String> jComboBox_sexo1;
    private JComboBox<String> jComboBox_vacuna1;
    private JComboBox<String> jComboBox_vacuna2;
    private JComboBox<String> styleComboBox;
    private JDialog jDialog_modificarCred;
    private JDialog jDialog_modificarDatos;
    private JLabel apellido;
    private JLabel apellido1;
    private JLabel cedula;
    private JLabel cedula1;
    private JLabel cedula2;
    private JLabel cedula3;
    private JLabel contrasena;
    private JLabel contrasena_anterior;
    private JLabel correo;
    private JLabel correo1;
    private JLabel direccion;
    private JLabel direccion1;
    private JLabel distrito;
    private JLabel distrito1;
    private JLabel errorMessage;
    private JLabel errorMessage1;
    private JLabel errorMessage2;
    private JLabel fecha_aplicacion1;
    private JLabel fecha_nacimiento;
    private JLabel fecha_nacimiento1;
    private JLabel icon_preferencias;
    private JLabel icon_project;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JLabel lote1;
    private JLabel nombre;
    private JLabel nombre1;
    private JLabel nombreBienvenida;
    private JLabel numDosis2;
    private JLabel repetir_contrasena;
    private JLabel rolName;
    private JLabel sede2;
    private JLabel sexo;
    private JLabel sexo1;
    private JLabel telefono;
    private JLabel telefono1;
    private JLabel titulo;
    private JLabel titulo_contenido;
    private JLabel titulo_contenido1;
    private JLabel titulo_contenido3;
    private JLabel titulo_contenido4;
    private JLabel titulo_contenido5;
    private JLabel titulo1;
    private JLabel titulo2;
    private JLabel titulo3;
    private JLabel titulo6;
    private JLabel usuario;
    private JLabel usuario_nuevo;
    private JLabel vacuna2;
    private JPanel background;
    private JPanel background_dialog_modificarCred;
    private JPanel background_dialog_modificarDatos;
    private JPanel jPanel_agendarCita;
    private JPanel jPanel_buscarDosis;
    private JPanel jPanel_buscarPaciente;
    private JPanel jPanel_contenidos_derecha;
    private JPanel jPanel_estadisticas;
    private JPanel jPanel_filtrarEstadistica;
    private JPanel jPanel_filtrarInventario;
    private JPanel jPanel_fontChooser;
    private JPanel jPanel_insertarDosis;
    private JPanel jPanel_inventario;
    private JPanel jPanel_manipularPaciente;
    private JPanel jPanel_menuOpciones;
    private JPanel jPanel_misPacientes;
    private JPanel jPanel_preferencias;
    private JPanel jPanel_separador1;
    private JPanel jPanel_separador2;
    private JPanel jPanel_separador3;
    private JPanel jPanel_separador4;
    private JPanel jPanel_separador5;
    private JPanel jPanel_separador6;
    private JPanel jPanel_separador7;
    private JPanel jPanel_soporte;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel opcionesTabla;
    private JPanel opcionesTabla1;
    private JPanel opcionesTabla3;
    private JPanel opcionesTabla4;
    private JPanel opcionesTabla5;
    private JPasswordField jPasswordField_nueva1;
    private JPasswordField jPasswordField_nueva2;
    private JPasswordField jPasswordField_vieja;
    private JScrollPane jScrollPane_Frame;
    private JScrollPane jScrollPane_Table1_MisPacientes;
    private JScrollPane jScrollPane_Table2_BuscarPacientes;
    private JScrollPane jScrollPane_Table3_Inventario;
    private JScrollPane jScrollPane_Table4_Estadisticas;
    private JScrollPane jScrollPane_Table5_BuscarDosis;
    private JScrollPane jScrollPane1_modificarDatos;
    private JScrollPane jScrollPane2_modificarCred;
    private JSeparator jSeparator1;
    private JSeparator jSeparator10;
    private JSeparator jSeparator11;
    private JSeparator jSeparator12;
    private JSeparator jSeparator13;
    private JSeparator jSeparator14;
    private JSeparator jSeparator15;
    private JSeparator jSeparator16;
    private JSeparator jSeparator17;
    private JSeparator jSeparator18;
    private JSeparator jSeparator19;
    private JSeparator jSeparator2;
    private JSeparator jSeparator20;
    private JSeparator jSeparator21;
    private JSeparator jSeparator22;
    private JSeparator jSeparator23;
    private JSeparator jSeparator24;
    private JSeparator jSeparator25;
    private JSeparator jSeparator26;
    private JSeparator jSeparator3;
    private JSeparator jSeparator4;
    private JSeparator jSeparator5;
    private JSeparator jSeparator6;
    private JSeparator jSeparator7;
    private JSeparator jSeparator8;
    private JSeparator jSeparator9;
    private JSpinner fontSizeSpinner;
    private JTable jTable_Content_BuscarDosis;
    private JTable jTable_Content_BuscarPacientes;
    private JTable jTable_Content_Estadisticas;
    private JTable jTable_Content_Inventario;
    private JTable jTable_Content_MisPacientes;
    private JTextArea jTextArea1_indicacionesManipularPaciente;
    private JTextArea jTextArea2_indicacionesModificarCred;
    private JTextArea jTextArea3_indicacionesModificarDatos;
    private JTextArea jTextArea4_indicacionesInsertarDosis;
    private JTextArea jTextArea5_pacienteVacunar;
    private JTextArea jTextArea6_lote;
    private JTextField jTextField_apellido;
    private JTextField jTextField_apellido1;
    private JTextField jTextField_buscarPaciente;
    private JTextField jTextField_buscarTabla1;
    private JTextField jTextField_buscarTabla2;
    private JTextField jTextField_buscarTabla3;
    private JTextField jTextField_buscarTabla4;
    private JTextField jTextField_buscarTabla5;
    private JTextField jTextField_cedula;
    private JTextField jTextField_cedula1;
    private JTextField jTextField_cedula2;
    private JTextField jTextField_cedula3;
    private JTextField jTextField_correo;
    private JTextField jTextField_correo1;
    private JTextField jTextField_direccion;
    private JTextField jTextField_direccion1;
    private JTextField jTextField_fecha_fin;
    private JTextField jTextField_fecha_inicio;
    private JTextField jTextField_fechaAplicacion1;
    private JTextField jTextField_fechaNacimiento;
    private JTextField jTextField_fechaNacimiento1;
    private JTextField jTextField_nombre;
    private JTextField jTextField_nombre1;
    private JTextField jTextField_telefono;
    private JTextField jTextField_telefono1;
    private JTextField jTextField_usuario_Viejo;
    private JTextField jTextField_usuarioNuevo;
    // End of variables declaration
}