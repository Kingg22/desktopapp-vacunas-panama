package InterfazDesktop;

import Logica.Validations.*;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class PantallaDoctor extends javax.swing.JFrame {

    public PantallaDoctor(JFrame parent) {
        PantallaDoctor.parentFrame = parent;
        initComponents();

        this.jPanel_filtrar1 = new JTableFiltrar(jTable_Content);
        this.jPanel_filtrar2 = new JTableFiltrar(jTable_Content1);
        this.jPanel_filtrar3 = new JTableFiltrar(jTable_Content5);

        JButton[] botones = {button_opcion1, button_opcion2, button_opcion3,
                button_opcion4, button_opcion5, button_opcion6, button_opcion7, button_opcion8,
                button_soporte, button_modificarDatos, button_modificarCred, button_preferencias,
                jButton_savePreferences};
        for (JButton boton : botones) {
            boton.setUI(new BasicButtonUI());
            boton.setBackground(new Color(86, 86, 86));
        }
        button_logOut.setUI(new BasicButtonUI());
        layout = (CardLayout) jPanel_derecho.getLayout();

        this.setExtendedState(MAXIMIZED_BOTH);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        jPanel_mostrarTabla = new javax.swing.JPanel();
        titulo_contenido = new javax.swing.JLabel();
        jScrollPane_Table = new javax.swing.JScrollPane();
        jTable_Content = new javax.swing.JTable();
        opcionesTabla = new javax.swing.JPanel();
        jTextField_buscarTabla = new javax.swing.JTextField();
        jButton_buscar = new javax.swing.JButton();
        jButton_acercar = new javax.swing.JButton();
        jButton_alejar = new javax.swing.JButton();
        jButton_ordenar = new javax.swing.JButton();
        jButton_filtros = new javax.swing.JButton();
        jButton_fuente = new javax.swing.JButton();
        jButton_exportar = new javax.swing.JButton();
        jPanel_agendarCita = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel_buscarPaciente = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        titulo_contenido1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane_Table1 = new javax.swing.JScrollPane();
        jTable_Content1 = new javax.swing.JTable();
        opcionesTabla1 = new javax.swing.JPanel();
        jTextField_buscarTabla1 = new javax.swing.JTextField();
        jButton_buscar1 = new javax.swing.JButton();
        jButton_acercar1 = new javax.swing.JButton();
        jButton_alejar1 = new javax.swing.JButton();
        jButton_ordenar1 = new javax.swing.JButton();
        jButton_filtros1 = new javax.swing.JButton();
        jButton_fuente1 = new javax.swing.JButton();
        jButton_exportar1 = new javax.swing.JButton();
        jPanel_manipularPaciente = new javax.swing.JPanel();
        titulo1 = new javax.swing.JLabel();
        jTextArea1 = new javax.swing.JTextArea();
        cedula2 = new javax.swing.JLabel();
        jTextField_cedula2 = new javax.swing.JTextField();
        jSeparator20 = new javax.swing.JSeparator();
        jButton3 = new javax.swing.JButton();
        nombre1 = new javax.swing.JLabel();
        jTextField_nombre1 = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        apellido1 = new javax.swing.JLabel();
        jTextField_apellido1 = new javax.swing.JTextField();
        jSeparator14 = new javax.swing.JSeparator();
        cedula1 = new javax.swing.JLabel();
        jTextField_cedula1 = new javax.swing.JTextField();
        jSeparator15 = new javax.swing.JSeparator();
        fecha_nacimiento1 = new javax.swing.JLabel();
        jTextField_fechaNacimiento1 = new javax.swing.JTextField();
        jSeparator16 = new javax.swing.JSeparator();
        sexo1 = new javax.swing.JLabel();
        jComboBox_sexo1 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        distrito1 = new javax.swing.JLabel();
        jComboBox_distrito1 = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        direccion1 = new javax.swing.JLabel();
        jTextField_direccion1 = new javax.swing.JTextField();
        jSeparator17 = new javax.swing.JSeparator();
        correo1 = new javax.swing.JLabel();
        jTextField_correo1 = new javax.swing.JTextField();
        jSeparator18 = new javax.swing.JSeparator();
        telefono1 = new javax.swing.JLabel();
        jTextField_telefono1 = new javax.swing.JTextField();
        jSeparator19 = new javax.swing.JSeparator();
        errorMessage1 = new javax.swing.JLabel();
        jButton_modificar1 = new javax.swing.JButton();
        jDialog_modificarDatos = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        background_dialog1 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        indicaciones = new javax.swing.JTextArea();
        nombre = new javax.swing.JLabel();
        jTextField_nombre = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        apellido = new javax.swing.JLabel();
        jTextField_apellido = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        cedula = new javax.swing.JLabel();
        jTextField_cedula = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        fecha_nacimiento = new javax.swing.JLabel();
        jTextField_fechaNacimiento = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        sexo = new javax.swing.JLabel();
        jComboBox_sexo = new javax.swing.JComboBox<>();
        direccion = new javax.swing.JLabel();
        jTextField_direccion = new javax.swing.JTextField();
        distrito = new javax.swing.JLabel();
        jComboBox_distrito = new javax.swing.JComboBox<>();
        jSeparator10 = new javax.swing.JSeparator();
        correo = new javax.swing.JLabel();
        jTextField_correo = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jTextField_telefono = new javax.swing.JTextField();
        telefono = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        errorMessage = new javax.swing.JLabel();
        jButton_cancelar = new javax.swing.JButton();
        jButton_modificar = new javax.swing.JButton();
        jPanel_inventario = new javax.swing.JPanel();
        titulo_contenido3 = new javax.swing.JLabel();
        jScrollPane_Table3 = new javax.swing.JScrollPane();
        jTable_Content3 = new javax.swing.JTable();
        opcionesTabla3 = new javax.swing.JPanel();
        jTextField_buscarTabla3 = new javax.swing.JTextField();
        jButton_buscar3 = new javax.swing.JButton();
        jButton_acercar3 = new javax.swing.JButton();
        jButton_alejar3 = new javax.swing.JButton();
        jButton_ordenar3 = new javax.swing.JButton();
        jButton_filtros3 = new javax.swing.JButton();
        jButton_fuente3 = new javax.swing.JButton();
        jButton_exportar3 = new javax.swing.JButton();
        jPanel_estadisticas = new javax.swing.JPanel();
        titulo_contenido4 = new javax.swing.JLabel();
        jScrollPane_Table4 = new javax.swing.JScrollPane();
        jTable_Content4 = new javax.swing.JTable();
        opcionesTabla4 = new javax.swing.JPanel();
        jTextField_buscarTabla4 = new javax.swing.JTextField();
        jButton_buscar4 = new javax.swing.JButton();
        jButton_acercar4 = new javax.swing.JButton();
        jButton_alejar4 = new javax.swing.JButton();
        jButton_ordenar4 = new javax.swing.JButton();
        jButton_filtros4 = new javax.swing.JButton();
        jButton_fuente4 = new javax.swing.JButton();
        jButton_exportar4 = new javax.swing.JButton();
        jPanel_filtrarEstadistica = new javax.swing.JPanel();
        jSeparator22 = new javax.swing.JSeparator();
        jSeparator23 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jComboBox_filterColumn1 = new javax.swing.JComboBox<>();
        jPanel_soporte = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel_filtrarInventario = new javax.swing.JPanel();
        jSeparator24 = new javax.swing.JSeparator();
        jSeparator25 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jComboBox_filterColumn2 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jComboBox_filterColumn3 = new javax.swing.JComboBox<>();
        jPanel_buscarDosis = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        titulo_contenido5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jScrollPane_Table5 = new javax.swing.JScrollPane();
        jTable_Content5 = new javax.swing.JTable();
        opcionesTabla5 = new javax.swing.JPanel();
        jTextField_buscarTabla5 = new javax.swing.JTextField();
        jButton_buscar5 = new javax.swing.JButton();
        jButton_acercar5 = new javax.swing.JButton();
        jButton_alejar5 = new javax.swing.JButton();
        jButton_ordenar5 = new javax.swing.JButton();
        jButton_filtros5 = new javax.swing.JButton();
        jButton_fuente5 = new javax.swing.JButton();
        jButton_exportar5 = new javax.swing.JButton();
        jPanel_preferencias = new javax.swing.JPanel();
        icon_preferencias = new javax.swing.JLabel();
        titulo3 = new javax.swing.JLabel();
        jPanel_separador1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel_separador2 = new javax.swing.JPanel();
        jPanel_fontChooser = new javax.swing.JPanel();
        jPanel_separador3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox_exportarType = new javax.swing.JComboBox<>();
        jPanel_separador4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox_exportarType1 = new javax.swing.JComboBox<>();
        jPanel_separador5 = new javax.swing.JPanel();
        jButton_savePreferences = new javax.swing.JButton();
        jDialog_modificarCred1 = new javax.swing.JDialog();
        jScrollPane4 = new javax.swing.JScrollPane();
        background_dialog3 = new javax.swing.JPanel();
        titulo4 = new javax.swing.JLabel();
        jTextArea4 = new javax.swing.JTextArea();
        usuario1 = new javax.swing.JLabel();
        jTextField_usuario1 = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        usuario_nuevo = new javax.swing.JLabel();
        jTextField_usuarioNuevo = new javax.swing.JTextField();
        jSeparator21 = new javax.swing.JSeparator();
        contrasena = new javax.swing.JLabel();
        jPasswordField_nueva1 = new javax.swing.JPasswordField();
        jSeparator11 = new javax.swing.JSeparator();
        repetir_contrasena = new javax.swing.JLabel();
        jPasswordField_nueva2 = new javax.swing.JPasswordField();
        jSeparator7 = new javax.swing.JSeparator();
        errorMessage2 = new javax.swing.JLabel();
        jButton_modificar2 = new javax.swing.JButton();
        jButton_cancelar2 = new javax.swing.JButton();
        contrasena_anterior = new javax.swing.JLabel();
        jPasswordField_vieja = new javax.swing.JPasswordField();
        jSeparator26 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        background = new javax.swing.JPanel();
        jPanel_menuOpciones = new javax.swing.JPanel();
        separador1 = new javax.swing.JPanel();
        icon_project = new javax.swing.JLabel();
        rolName = new javax.swing.JLabel();
        nombreBienvenida = new javax.swing.JLabel();
        button_opcion1 = new javax.swing.JButton();
        button_opcion2 = new javax.swing.JButton();
        button_opcion3 = new javax.swing.JButton();
        button_opcion4 = new javax.swing.JButton();
        button_opcion5 = new javax.swing.JButton();
        button_opcion6 = new javax.swing.JButton();
        button_opcion7 = new javax.swing.JButton();
        button_opcion8 = new javax.swing.JButton();
        separador2 = new javax.swing.JPanel();
        button_modificarDatos = new javax.swing.JButton();
        button_modificarCred = new javax.swing.JButton();
        button_preferencias = new javax.swing.JButton();
        button_soporte = new javax.swing.JButton();
        button_logOut = new javax.swing.JButton();
        jPanel_derecho = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        jPanel_mostrarTabla.setBackground(new java.awt.Color(227, 218, 201));
        jPanel_mostrarTabla.setForeground(new java.awt.Color(227, 218, 201));
        jPanel_mostrarTabla.setPreferredSize(new java.awt.Dimension(794, 794));
        jPanel_mostrarTabla.setLayout(new java.awt.BorderLayout());

        titulo_contenido.setBackground(new java.awt.Color(255, 255, 255));
        titulo_contenido.setFont(new java.awt.Font("Roboto", 3, 14));
        titulo_contenido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo_contenido.setText("Resultados Obtenidos de mis pacientes");
        titulo_contenido.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titulo_contenido.setOpaque(true);
        titulo_contenido.setPreferredSize(new java.awt.Dimension(794, 17));
        jPanel_mostrarTabla.add(titulo_contenido, java.awt.BorderLayout.NORTH);

        jScrollPane_Table.setBackground(new java.awt.Color(227, 218, 201));
        jScrollPane_Table.setForeground(new java.awt.Color(227, 218, 201));
        jScrollPane_Table.setOpaque(true);
        jScrollPane_Table.setPreferredSize(new java.awt.Dimension(794, 727));
        jScrollPane_Table.setViewportView(null);

        jTable_Content.setBackground(new java.awt.Color(227, 218, 201));
        jTable_Content.setFont(new java.awt.Font("Roboto", 0, 12));
        jTable_Content.setForeground(new java.awt.Color(227, 218, 201));
        jTable_Content.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable_Content.setMinimumSize(new java.awt.Dimension(50, 50));
        jTable_Content.setPreferredSize(new java.awt.Dimension(788, 721));
        jTable_Content.setShowGrid(true);
        jScrollPane_Table.setViewportView(jTable_Content);
        jTable_Content.getAccessibleContext().setAccessibleName("tabla de resultados");

        jPanel_mostrarTabla.add(jScrollPane_Table, java.awt.BorderLayout.CENTER);

        opcionesTabla.setBackground(new java.awt.Color(0, 153, 204));
        opcionesTabla.setMinimumSize(new java.awt.Dimension(794, 47));
        opcionesTabla.setPreferredSize(new java.awt.Dimension(794, 50));
        opcionesTabla.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 10));

        jTextField_buscarTabla.setDocument(new LimitarCamposSeguro(25, "Buscar...")
        );
        jTextField_buscarTabla.setText("Buscar...");
        jTextField_buscarTabla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField_buscarTabla.setPreferredSize(new java.awt.Dimension(125, 26));
        jTextField_buscarTabla.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_buscarTablaFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_buscarTablaFocusLost(evt);
            }
        });
        jTextField_buscarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_buscarTablaActionPerformed(evt);
            }
        });
        opcionesTabla.add(jTextField_buscarTabla);

        jButton_buscar.setBackground(new java.awt.Color(204, 204, 204));
        jButton_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa_icon.png")));
        jButton_buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_buscarMouseClicked(evt);
            }
        });
        opcionesTabla.add(jButton_buscar);

        jButton_acercar.setText("Acercar");
        jButton_acercar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_acercarMouseClicked(evt);
            }
        });
        opcionesTabla.add(jButton_acercar);

        jButton_alejar.setText("Alejar");
        jButton_alejar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_alejarMouseClicked(evt);
            }
        });
        opcionesTabla.add(jButton_alejar);

        jButton_ordenar.setText("Ordenar");
        jButton_ordenar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_ordenarMouseClicked(evt);
            }
        });
        opcionesTabla.add(jButton_ordenar);

        jButton_filtros.setText("Filtros");
        jButton_filtros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_filtrosMouseClicked(evt);
            }
        });
        opcionesTabla.add(jButton_filtros);

        jButton_fuente.setText("Fuente y tamaño");
        jButton_fuente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_fuenteMouseClicked(evt);
            }
        });
        opcionesTabla.add(jButton_fuente);

        jButton_exportar.setText("Exportar tabla");
        jButton_exportar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_exportarMouseClicked(evt);
            }
        });
        opcionesTabla.add(jButton_exportar);

        jPanel_mostrarTabla.add(opcionesTabla, java.awt.BorderLayout.SOUTH);

        jPanel_agendarCita.setBackground(new java.awt.Color(227, 218, 201));
        jPanel_agendarCita.setPreferredSize(new java.awt.Dimension(794, 794));
        jPanel_agendarCita.setRequestFocusEnabled(false);
        jPanel_agendarCita.setLayout(new java.awt.BorderLayout());

        jLabel9.setFont(new java.awt.Font("Microsoft YaHei", 3, 24));
        jLabel9.setForeground(new java.awt.Color(0, 204, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Módulo en construcción...");
        jPanel_agendarCita.add(jLabel9, java.awt.BorderLayout.CENTER);

        jPanel_buscarPaciente.setBackground(new java.awt.Color(227, 218, 201));
        jPanel_buscarPaciente.setForeground(new java.awt.Color(227, 218, 201));
        jPanel_buscarPaciente.setPreferredSize(new java.awt.Dimension(794, 794));
        jPanel_buscarPaciente.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel_buscarPacienteAncestorAdded(evt);
            }

            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }

            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel_buscarPaciente.setLayout(new javax.swing.BoxLayout(jPanel_buscarPaciente, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setBackground(new java.awt.Color(227, 218, 201));
        jPanel2.setMaximumSize(new java.awt.Dimension(2147483647, 100));
        jPanel2.setPreferredSize(new java.awt.Dimension(794, 45));
        jPanel2.setLayout(new java.awt.BorderLayout());

        titulo_contenido1.setBackground(new java.awt.Color(255, 255, 255));
        titulo_contenido1.setFont(new java.awt.Font("Roboto", 3, 14));
        titulo_contenido1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo_contenido1.setText("Resultados Obtenidos de Pacientes");
        titulo_contenido1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titulo_contenido1.setOpaque(true);
        titulo_contenido1.setPreferredSize(new java.awt.Dimension(550, 17));
        jPanel2.add(titulo_contenido1, java.awt.BorderLayout.NORTH);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Cédula", "Nombre completo", "Fecha de nacimiento"}));
        jComboBox1.setPreferredSize(new java.awt.Dimension(150, 26));
        jPanel2.add(jComboBox1, java.awt.BorderLayout.WEST);

        jTextField1.setDocument(new LimitarCamposSeguro(50, "Buscar paciente..."));
        jTextField1.setText("Buscar paciente...");
        RegistrarUser.handleFocusGain(jTextField1, "Buscar paciente...");
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1, java.awt.BorderLayout.CENTER);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa_icon.png")));
        jButton1.setPreferredSize(new java.awt.Dimension(30, 30));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel2.add(jButton1, java.awt.BorderLayout.EAST);

        jPanel_buscarPaciente.add(jPanel2);

        jScrollPane_Table1.setBackground(new java.awt.Color(227, 218, 201));
        jScrollPane_Table1.setForeground(new java.awt.Color(227, 218, 201));
        jScrollPane_Table1.setOpaque(true);
        jScrollPane_Table1.setPreferredSize(new java.awt.Dimension(794, 705));
        jScrollPane_Table1.setViewportView(null);

        jTable_Content1.setBackground(new java.awt.Color(227, 218, 201));
        jTable_Content1.setFont(new java.awt.Font("Roboto", 0, 12));
        jTable_Content1.setForeground(new java.awt.Color(227, 218, 201));
        jTable_Content1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable_Content1.setMinimumSize(new java.awt.Dimension(50, 50));
        jTable_Content1.setPreferredSize(new java.awt.Dimension(788, 699));
        jTable_Content1.setShowGrid(true);
        jScrollPane_Table1.setViewportView(jTable_Content1);

        jPanel_buscarPaciente.add(jScrollPane_Table1);

        opcionesTabla1.setBackground(new java.awt.Color(0, 153, 204));
        opcionesTabla1.setMaximumSize(new java.awt.Dimension(32767, 100));
        opcionesTabla1.setPreferredSize(new java.awt.Dimension(794, 44));
        opcionesTabla1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 10));

        jTextField_buscarTabla1.setDocument(new LimitarCamposSeguro(25, "Buscar...")
        );
        jTextField_buscarTabla1.setText("Buscar...");
        jTextField_buscarTabla1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField_buscarTabla1.setPreferredSize(new java.awt.Dimension(125, 26));
        jTextField_buscarTabla1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_buscarTabla1FocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_buscarTabla1FocusLost(evt);
            }
        });
        jTextField_buscarTabla1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_buscarTabla1ActionPerformed(evt);
            }
        });
        opcionesTabla1.add(jTextField_buscarTabla1);

        jButton_buscar1.setBackground(new java.awt.Color(204, 204, 204));
        jButton_buscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa_icon.png")));
        jButton_buscar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_buscar1MouseClicked(evt);
            }
        });
        opcionesTabla1.add(jButton_buscar1);

        jButton_acercar1.setText("Acercar");
        jButton_acercar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_acercar1MouseClicked(evt);
            }
        });
        opcionesTabla1.add(jButton_acercar1);

        jButton_alejar1.setText("Alejar");
        jButton_alejar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_alejar1MouseClicked(evt);
            }
        });
        opcionesTabla1.add(jButton_alejar1);

        jButton_ordenar1.setText("Ordenar");
        jButton_ordenar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_ordenar1MouseClicked(evt);
            }
        });
        opcionesTabla1.add(jButton_ordenar1);

        jButton_filtros1.setText("Filtros");
        jButton_filtros1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_filtros1MouseClicked(evt);
            }
        });
        opcionesTabla1.add(jButton_filtros1);

        jButton_fuente1.setText("Fuente y tamaño");
        jButton_fuente1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_fuente1MouseClicked(evt);
            }
        });
        opcionesTabla1.add(jButton_fuente1);

        jButton_exportar1.setText("Exportar tabla");
        jButton_exportar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_exportar1MouseClicked(evt);
            }
        });
        opcionesTabla1.add(jButton_exportar1);

        jPanel_buscarPaciente.add(opcionesTabla1);

        jPanel_manipularPaciente.setBackground(new java.awt.Color(227, 218, 201));
        jPanel_manipularPaciente.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 100, 20, 100));
        jPanel_manipularPaciente.setPreferredSize(new java.awt.Dimension(794, 794));
        jPanel_manipularPaciente.setLayout(new java.awt.GridLayout(35, 1));

        titulo1.setFont(new java.awt.Font("Microsoft YaHei", 1, 14));
        titulo1.setForeground(new java.awt.Color(0, 0, 0));
        titulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo1.setText("Crear o Editar paciente");
        jPanel_manipularPaciente.add(titulo1);

        jTextArea1.setBackground(new java.awt.Color(227, 218, 201));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Microsoft YaHei", 2, 11));
        jTextArea1.setForeground(new java.awt.Color(102, 102, 102));
        jTextArea1.setRows(5);
        jTextArea1.setText("Indicaciones: Si desea editar paciente utilizar el campo 'Buscar cédula a editar' , dar click en el botón buscar, si no desea modificar todo, puede dejarlo como esta. Si desea crear paciente. Utilizar directamente los campos debajo del botón 'Buscar paciente a editar...', los campos con * son obligatorios.\n");
        jTextArea1.setBorder(null);
        jTextArea1.setMinimumSize(new java.awt.Dimension(616, 55));
        jTextArea1.setPreferredSize(new java.awt.Dimension(628, 55));
        jTextArea1.setLineWrap(true);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setEditable(false);
        jPanel_manipularPaciente.add(jTextArea1);

        cedula2.setBackground(new java.awt.Color(0, 0, 0));
        cedula2.setFont(new java.awt.Font("Roboto", 0, 12));
        cedula2.setForeground(new java.awt.Color(0, 0, 0));
        cedula2.setText("Buscar cédula a editar*");
        jPanel_manipularPaciente.add(cedula2);

        jTextField_cedula2.setBackground(new java.awt.Color(227, 218, 201));
        jTextField_cedula2.setDocument(new LimitarCamposCedula(15, "Ingrese cédula a buscar"));
        jTextField_cedula2.setFont(new java.awt.Font("Roboto", 0, 14));
        jTextField_cedula2.setForeground(java.awt.Color.gray);
        jTextField_cedula2.setText("Ingrese cédula a buscar");
        jTextField_cedula2.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_cedula2, "Ingrese cédula a buscar");
        jTextField_cedula2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_cedula2FocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_cedula2FocusLost(evt);
            }
        });
        jTextField_cedula2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_cedula2ActionPerformed(evt);
            }
        });
        jPanel_manipularPaciente.add(jTextField_cedula2);

        jSeparator20.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator20.setForeground(new java.awt.Color(30, 30, 30));
        jPanel_manipularPaciente.add(jSeparator20);

        jButton3.setText("Buscar paciente a editar...");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel_manipularPaciente.add(jButton3);

        nombre1.setBackground(new java.awt.Color(0, 0, 0));
        nombre1.setFont(new java.awt.Font("Roboto", 0, 12));
        nombre1.setForeground(new java.awt.Color(0, 0, 0));
        nombre1.setText("Nombre *");
        jPanel_manipularPaciente.add(nombre1);

        jTextField_nombre1.setBackground(new java.awt.Color(227, 218, 201));
        jTextField_nombre1.setDocument(new LimitarCamposString(50, "Ingrese el nombre"));
        jTextField_nombre1.setFont(new java.awt.Font("Roboto", 0, 14));
        jTextField_nombre1.setForeground(java.awt.Color.gray);
        jTextField_nombre1.setText("Ingrese el nombre");
        jTextField_nombre1.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_nombre1, "Ingrese el nombre");
        jTextField_nombre1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_nombre1FocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_nombre1FocusLost(evt);
            }
        });
        jTextField_nombre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nombre1ActionPerformed(evt);
            }
        });
        jPanel_manipularPaciente.add(jTextField_nombre1);

        jSeparator13.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator13.setForeground(new java.awt.Color(30, 30, 30));
        jPanel_manipularPaciente.add(jSeparator13);

        apellido1.setBackground(new java.awt.Color(0, 0, 0));
        apellido1.setFont(new java.awt.Font("Roboto", 0, 12));
        apellido1.setForeground(new java.awt.Color(0, 0, 0));
        apellido1.setText("Apellido *");
        jPanel_manipularPaciente.add(apellido1);

        jTextField_apellido1.setBackground(new java.awt.Color(227, 218, 201));
        jTextField_apellido1.setDocument(new LimitarCamposString(50, "Ingrese el apellido"));
        jTextField_apellido1.setFont(new java.awt.Font("Roboto", 0, 14));
        jTextField_apellido1.setForeground(java.awt.Color.gray);
        jTextField_apellido1.setText("Ingrese el apellido");
        jTextField_apellido1.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_apellido1, "Ingrese el apellido");
        jTextField_apellido1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_apellido1FocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_apellido1FocusLost(evt);
            }
        });
        jTextField_apellido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_apellido1ActionPerformed(evt);
            }
        });
        jPanel_manipularPaciente.add(jTextField_apellido1);

        jSeparator14.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator14.setForeground(new java.awt.Color(30, 30, 30));
        jPanel_manipularPaciente.add(jSeparator14);

        cedula1.setBackground(new java.awt.Color(0, 0, 0));
        cedula1.setFont(new java.awt.Font("Roboto", 0, 12));
        cedula1.setForeground(new java.awt.Color(0, 0, 0));
        cedula1.setText("Cédula de identidad personal *");
        jPanel_manipularPaciente.add(cedula1);

        jTextField_cedula1.setBackground(new java.awt.Color(227, 218, 201));
        jTextField_cedula1.setDocument(new LimitarCamposCedula(15, "Ingrese la cédula"));
        jTextField_cedula1.setFont(new java.awt.Font("Roboto", 0, 14));
        jTextField_cedula1.setForeground(java.awt.Color.gray);
        jTextField_cedula1.setText("Ingrese la cédula");
        jTextField_cedula1.setBorder(null);
        jTextField_cedula1.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_cedula1, "Ingrese la cédula");
        jTextField_cedula1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_cedula1FocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_cedula1FocusLost(evt);
            }
        });
        jTextField_cedula1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_cedula1ActionPerformed(evt);
            }
        });
        jPanel_manipularPaciente.add(jTextField_cedula1);

        jSeparator15.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator15.setForeground(new java.awt.Color(30, 30, 30));
        jPanel_manipularPaciente.add(jSeparator15);

        fecha_nacimiento1.setBackground(new java.awt.Color(0, 0, 0));
        fecha_nacimiento1.setFont(new java.awt.Font("Roboto", 0, 12));
        fecha_nacimiento1.setForeground(new java.awt.Color(0, 0, 0));
        fecha_nacimiento1.setText("Fecha de nacimiento *");
        jPanel_manipularPaciente.add(fecha_nacimiento1);

        jTextField_fechaNacimiento1.setBackground(new java.awt.Color(227, 218, 201));
        jTextField_fechaNacimiento1.setDocument(new LimitarCamposFecha(19, "Ingrese la fecha de nacimiento YYYY-MM-DD* hh:mm:ss"));
        jTextField_fechaNacimiento1.setFont(new java.awt.Font("Roboto", 0, 14));
        jTextField_fechaNacimiento1.setForeground(java.awt.Color.gray);
        jTextField_fechaNacimiento1.setText("Ingrese la fecha de nacimiento YYYY-MM-DD* hh:mm:ss");
        jTextField_fechaNacimiento1.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_fechaNacimiento1, "Ingrese la fecha de nacimiento YYYY-MM-DD* hh:mm:ss");
        jTextField_fechaNacimiento1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_fechaNacimiento1FocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_fechaNacimiento1FocusLost(evt);
            }
        });
        jTextField_fechaNacimiento1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_fechaNacimiento1ActionPerformed(evt);
            }
        });
        jPanel_manipularPaciente.add(jTextField_fechaNacimiento1);

        jSeparator16.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator16.setForeground(new java.awt.Color(30, 30, 30));
        jPanel_manipularPaciente.add(jSeparator16);

        sexo1.setBackground(new java.awt.Color(0, 0, 0));
        sexo1.setFont(new java.awt.Font("Roboto", 0, 12));
        sexo1.setForeground(new java.awt.Color(0, 0, 0));
        sexo1.setText("sexo *");
        jPanel_manipularPaciente.add(sexo1);

        jComboBox_sexo1.setBackground(java.awt.Color.gray);
        jComboBox_sexo1.setFont(new java.awt.Font("Roboto", 0, 14));
        jComboBox_sexo1.setForeground(java.awt.Color.black);
        jComboBox_sexo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Elegir", "Masculino", "Feminino"}));
        jPanel_manipularPaciente.add(jComboBox_sexo1);

        jPanel3.setBackground(new java.awt.Color(227, 218, 201));
        jPanel3.setPreferredSize(new java.awt.Dimension(0, 3));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 616, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 55, Short.MAX_VALUE)
        );

        jPanel_manipularPaciente.add(jPanel3);

        distrito1.setBackground(new java.awt.Color(0, 0, 0));
        distrito1.setFont(new java.awt.Font("Roboto", 0, 12));
        distrito1.setForeground(new java.awt.Color(0, 0, 0));
        distrito1.setText("Distrito de residencia actual");
        jPanel_manipularPaciente.add(distrito1);

        jComboBox_distrito1.setBackground(java.awt.Color.gray);
        jComboBox_distrito1.setFont(new java.awt.Font("Roboto", 0, 14));
        jComboBox_distrito1.setForeground(java.awt.Color.black);
        jComboBox_distrito1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Elegir", "Distrito por registrar"}));
        jPanel_manipularPaciente.add(jComboBox_distrito1);

        jPanel4.setBackground(new java.awt.Color(227, 218, 201));
        jPanel4.setPreferredSize(new java.awt.Dimension(0, 3));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 616, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 55, Short.MAX_VALUE)
        );

        jPanel_manipularPaciente.add(jPanel4);

        direccion1.setBackground(new java.awt.Color(0, 0, 0));
        direccion1.setFont(new java.awt.Font("Roboto", 0, 12));
        direccion1.setForeground(new java.awt.Color(0, 0, 0));
        direccion1.setText("Dirección residencia actual");
        jPanel_manipularPaciente.add(direccion1);

        jTextField_direccion1.setBackground(new java.awt.Color(227, 218, 201));
        jTextField_direccion1.setDocument(new LimitarCamposAlpha(100, "Ingrese la dirección"));
        jTextField_direccion1.setFont(new java.awt.Font("Roboto", 0, 14));
        jTextField_direccion1.setForeground(java.awt.Color.gray);
        jTextField_direccion1.setText("Ingrese la dirección");
        jTextField_direccion1.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        jTextField_direccion1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_direccion1FocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_direccion1FocusLost(evt);
            }
        });
        jTextField_direccion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_direccion1ActionPerformed(evt);
            }
        });
        jPanel_manipularPaciente.add(jTextField_direccion1);

        jSeparator17.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator17.setForeground(new java.awt.Color(30, 30, 30));
        jPanel_manipularPaciente.add(jSeparator17);

        correo1.setBackground(new java.awt.Color(0, 0, 0));
        correo1.setFont(new java.awt.Font("Roboto", 0, 12));
        correo1.setForeground(new java.awt.Color(0, 0, 0));
        correo1.setText("Correo electrónico");
        jPanel_manipularPaciente.add(correo1);

        jTextField_correo1.setBackground(new java.awt.Color(227, 218, 201));
        jTextField_correo1.setDocument(new LimitarCamposEmail(50, "Ingrese el correo electrónico"));
        jTextField_correo1.setFont(new java.awt.Font("Roboto", 0, 14));
        jTextField_correo1.setForeground(java.awt.Color.gray);
        jTextField_correo1.setText("Ingrese el correo electrónico");
        jTextField_correo1.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_correo1, "Ingrese el correo electrónico");
        jTextField_correo1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_correo1FocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_correo1FocusLost(evt);
            }
        });
        jTextField_correo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_correo1ActionPerformed(evt);
            }
        });
        jPanel_manipularPaciente.add(jTextField_correo1);

        jSeparator18.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator18.setForeground(new java.awt.Color(30, 30, 30));
        jPanel_manipularPaciente.add(jSeparator18);

        telefono1.setBackground(new java.awt.Color(0, 0, 0));
        telefono1.setFont(new java.awt.Font("Roboto", 0, 12));
        telefono1.setForeground(new java.awt.Color(0, 0, 0));
        telefono1.setText("Teléfono ");
        jPanel_manipularPaciente.add(telefono1);

        jTextField_telefono1.setBackground(new java.awt.Color(227, 218, 201));
        jTextField_telefono1.setDocument(new LimitarCamposNumeric(15, "Ingrese el teléfono"));
        jTextField_telefono1.setFont(new java.awt.Font("Roboto", 0, 14));
        jTextField_telefono1.setForeground(java.awt.Color.gray);
        jTextField_telefono1.setText("Ingrese el teléfono");
        jTextField_telefono1.setBorder(null);
        jTextField_telefono1.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_telefono1, "Ingrese el teléfono");
        jTextField_telefono1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_telefono1FocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_telefono1FocusLost(evt);
            }
        });
        jTextField_telefono1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_telefono1ActionPerformed(evt);
            }
        });
        jPanel_manipularPaciente.add(jTextField_telefono1);

        jSeparator19.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator19.setForeground(new java.awt.Color(30, 30, 30));
        jPanel_manipularPaciente.add(jSeparator19);

        errorMessage1.setFont(new java.awt.Font("Roboto", 1, 14));
        errorMessage1.setForeground(java.awt.Color.red);
        errorMessage1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorMessage1.setText("ERROR.");
        errorMessage1.setVisible(false);
        jPanel_manipularPaciente.add(errorMessage1);

        jButton_modificar1.setBackground(new java.awt.Color(0, 204, 0));
        jButton_modificar1.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jButton_modificar1.setForeground(new java.awt.Color(0, 0, 0));
        jButton_modificar1.setText("Modificar");
        jButton_modificar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_modificar1MouseClicked(evt);
            }
        });
        jPanel_manipularPaciente.add(jButton_modificar1);

        jDialog_modificarDatos.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog_modificarDatos.setTitle("Programa Vacunas Panamá - Modificar datos personales");
        jDialog_modificarDatos.setModal(true);
        jDialog_modificarDatos.setResizable(false);
        jDialog_modificarDatos.setSize(new java.awt.Dimension(450, 600));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        background_dialog1.setBackground(new java.awt.Color(255, 255, 255));
        background_dialog1.setPreferredSize(new java.awt.Dimension(444, 544));
        background_dialog1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setFont(new java.awt.Font("Microsoft YaHei", 1, 14));
        titulo.setForeground(new java.awt.Color(0, 0, 0));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Modificar datos personales");
        background_dialog1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 269, -1));

        indicaciones.setEditable(false);
        indicaciones.setBackground(new java.awt.Color(255, 255, 255));
        indicaciones.setFont(new java.awt.Font("Microsoft YaHei", 2, 11));
        indicaciones.setForeground(new java.awt.Color(102, 102, 102));
        indicaciones.setLineWrap(true);
        indicaciones.setRows(5);
        indicaciones.setText("Indicaciones: Si no desea modificar todo, puede dejarlo en blanco o como esta. Si su cédula o fecha de nacimiento esta errónea, solicita ayuda a su doctor.\n\n");
        indicaciones.setWrapStyleWord(true);
        indicaciones.setBorder(null);
        indicaciones.setFocusable(false);
        indicaciones.setRequestFocusEnabled(false);
        background_dialog1.add(indicaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 390, 50));

        nombre.setBackground(new java.awt.Color(0, 0, 0));
        nombre.setFont(new java.awt.Font("Roboto", 0, 12));
        nombre.setForeground(new java.awt.Color(0, 0, 0));
        nombre.setText("Nombre *");
        background_dialog1.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jTextField_nombre.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_nombre.setDocument(new LimitarCamposString(50, "Ingrese su nombre"));
        jTextField_nombre.setFont(new java.awt.Font("Roboto", 0, 14));
        jTextField_nombre.setForeground(java.awt.Color.gray);
        jTextField_nombre.setText("Ingrese su nombre");
        jTextField_nombre.setBorder(null);
        jTextField_nombre.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_nombre, "Ingrese su nombre");
        jTextField_nombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_nombreFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_nombreFocusLost(evt);
            }
        });
        jTextField_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nombreActionPerformed(evt);
            }
        });
        background_dialog1.add(jTextField_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 390, -1));

        jSeparator3.setForeground(new java.awt.Color(30, 30, 30));
        background_dialog1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 390, 21));

        apellido.setBackground(new java.awt.Color(0, 0, 0));
        apellido.setFont(new java.awt.Font("Roboto", 0, 12));
        apellido.setForeground(new java.awt.Color(0, 0, 0));
        apellido.setText("Apellido *");
        background_dialog1.add(apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jTextField_apellido.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_apellido.setDocument(new LimitarCamposString(50, "Ingrese su apellido"));
        jTextField_apellido.setFont(new java.awt.Font("Roboto", 0, 14));
        jTextField_apellido.setForeground(java.awt.Color.gray);
        jTextField_apellido.setText("Ingrese su apellido");
        jTextField_apellido.setBorder(null);
        jTextField_apellido.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_apellido, "Ingrese su apellido");
        jTextField_apellido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_apellidoFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_apellidoFocusLost(evt);
            }
        });
        jTextField_apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_apellidoActionPerformed(evt);
            }
        });
        background_dialog1.add(jTextField_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 390, -1));

        jSeparator4.setForeground(new java.awt.Color(30, 30, 30));
        background_dialog1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 390, 21));

        cedula.setBackground(new java.awt.Color(0, 0, 0));
        cedula.setFont(new java.awt.Font("Roboto", 0, 12));
        cedula.setForeground(new java.awt.Color(0, 0, 0));
        cedula.setText("Cédula *");
        background_dialog1.add(cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jTextField_cedula.setEditable(false);
        jTextField_cedula.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_cedula.setFont(new java.awt.Font("Roboto", 0, 14));
        jTextField_cedula.setForeground(java.awt.Color.gray);
        jTextField_cedula.setText("Ingrese su cédula");
        jTextField_cedula.setBorder(null);
        jTextField_cedula.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        jTextField_cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_cedulaActionPerformed(evt);
            }
        });
        background_dialog1.add(jTextField_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 390, -1));

        jSeparator5.setForeground(new java.awt.Color(30, 30, 30));
        background_dialog1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 390, 21));

        fecha_nacimiento.setBackground(new java.awt.Color(0, 0, 0));
        fecha_nacimiento.setFont(new java.awt.Font("Roboto", 0, 12));
        fecha_nacimiento.setForeground(new java.awt.Color(0, 0, 0));
        fecha_nacimiento.setText("Fecha de nacimiento *");
        background_dialog1.add(fecha_nacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jTextField_fechaNacimiento.setEditable(false);
        jTextField_fechaNacimiento.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_fechaNacimiento.setFont(new java.awt.Font("Roboto", 0, 14));
        jTextField_fechaNacimiento.setForeground(java.awt.Color.gray);
        jTextField_fechaNacimiento.setText("Ingrese su fecha de nacimiento YYYY-MM-DD hh:mm:ss");
        jTextField_fechaNacimiento.setBorder(null);
        jTextField_fechaNacimiento.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        jTextField_fechaNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_fechaNacimientoActionPerformed(evt);
            }
        });
        background_dialog1.add(jTextField_fechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 390, -1));

        jSeparator9.setForeground(new java.awt.Color(30, 30, 30));
        background_dialog1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 390, 21));

        sexo.setBackground(new java.awt.Color(0, 0, 0));
        sexo.setFont(new java.awt.Font("Roboto", 0, 12));
        sexo.setForeground(new java.awt.Color(0, 0, 0));
        sexo.setText("sexo *");
        background_dialog1.add(sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        jComboBox_sexo.setBackground(java.awt.Color.gray);
        jComboBox_sexo.setFont(new java.awt.Font("Roboto", 0, 14));
        jComboBox_sexo.setForeground(java.awt.Color.black);
        jComboBox_sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Elegir", "Masculino", "Feminino"}));
        background_dialog1.add(jComboBox_sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 308, 170, -1));

        direccion.setBackground(new java.awt.Color(0, 0, 0));
        direccion.setFont(new java.awt.Font("Roboto", 0, 12));
        direccion.setForeground(new java.awt.Color(0, 0, 0));
        direccion.setText("Dirección");
        background_dialog1.add(direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        jTextField_direccion.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_direccion.setDocument(new LimitarCamposAlpha(100, "Ingrese su dirección"));
        jTextField_direccion.setFont(new java.awt.Font("Roboto", 0, 14));
        jTextField_direccion.setForeground(java.awt.Color.gray);
        jTextField_direccion.setText("Ingrese su dirección");
        jTextField_direccion.setBorder(null);
        jTextField_direccion.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        jTextField_direccion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_direccionFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_direccionFocusLost(evt);
            }
        });
        jTextField_direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_direccionActionPerformed(evt);
            }
        });
        background_dialog1.add(jTextField_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 190, -1));

        distrito.setBackground(new java.awt.Color(0, 0, 0));
        distrito.setFont(new java.awt.Font("Roboto", 0, 12));
        distrito.setForeground(new java.awt.Color(0, 0, 0));
        distrito.setText("Distrito");
        background_dialog1.add(distrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 50, -1));

        jComboBox_distrito.setBackground(java.awt.Color.gray);
        jComboBox_distrito.setFont(new java.awt.Font("Roboto", 0, 14));
        jComboBox_distrito.setForeground(java.awt.Color.black);
        jComboBox_distrito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Elegir", "Distrito por registrar"}));
        background_dialog1.add(jComboBox_distrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 356, 190, -1));

        jSeparator10.setForeground(new java.awt.Color(30, 30, 30));
        background_dialog1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 190, 21));

        correo.setBackground(new java.awt.Color(0, 0, 0));
        correo.setFont(new java.awt.Font("Roboto", 0, 12));
        correo.setForeground(new java.awt.Color(0, 0, 0));
        correo.setText("Correo electrónico");
        background_dialog1.add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        jTextField_correo.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_correo.setDocument(new LimitarCamposEmail(50, "Ingrese su correo electrónico"));
        jTextField_correo.setFont(new java.awt.Font("Roboto", 0, 14));
        jTextField_correo.setForeground(java.awt.Color.gray);
        jTextField_correo.setText("Ingrese su correo electrónico");
        jTextField_correo.setBorder(null);
        jTextField_correo.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_correo, "Ingrese su correo electrónico");
        jTextField_correo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_correoFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_correoFocusLost(evt);
            }
        });
        jTextField_correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_correoActionPerformed(evt);
            }
        });
        background_dialog1.add(jTextField_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 390, -1));

        jSeparator6.setForeground(new java.awt.Color(30, 30, 30));
        background_dialog1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 390, 21));

        jTextField_telefono.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_telefono.setDocument(new LimitarCamposNumeric(15, "Ingrese su teléfono"));
        jTextField_telefono.setFont(new java.awt.Font("Roboto", 0, 14));
        jTextField_telefono.setForeground(java.awt.Color.gray);
        jTextField_telefono.setText("Ingrese su teléfono");
        jTextField_telefono.setBorder(null);
        jTextField_telefono.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_telefono, "Ingrese su teléfono");
        jTextField_telefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_telefonoFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_telefonoFocusLost(evt);
            }
        });
        jTextField_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_telefonoActionPerformed(evt);
            }
        });
        background_dialog1.add(jTextField_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 390, -1));

        telefono.setBackground(new java.awt.Color(0, 0, 0));
        telefono.setFont(new java.awt.Font("Roboto", 0, 12));
        telefono.setForeground(new java.awt.Color(0, 0, 0));
        telefono.setText("Teléfono ");
        background_dialog1.add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        jSeparator12.setForeground(new java.awt.Color(30, 30, 30));
        background_dialog1.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 390, 21));

        errorMessage.setFont(new java.awt.Font("Roboto", 1, 14));
        errorMessage.setForeground(java.awt.Color.red);
        errorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorMessage.setText("ERROR.");
        errorMessage.setVisible(false);
        background_dialog1.add(errorMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 390, -1));

        jButton_cancelar.setBackground(new java.awt.Color(153, 153, 153));
        jButton_cancelar.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jButton_cancelar.setForeground(new java.awt.Color(0, 0, 0));
        jButton_cancelar.setText("Cancelar");
        jButton_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_cancelarMouseClicked(evt);
            }
        });
        background_dialog1.add(jButton_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 510, -1, -1));

        jButton_modificar.setBackground(new java.awt.Color(0, 204, 0));
        jButton_modificar.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jButton_modificar.setForeground(new java.awt.Color(0, 0, 0));
        jButton_modificar.setText("Modificar");
        jButton_modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_modificarMouseClicked(evt);
            }
        });
        background_dialog1.add(jButton_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 510, -1, -1));

        jScrollPane1.setViewportView(background_dialog1);

        javax.swing.GroupLayout jDialog_modificarDatosLayout = new javax.swing.GroupLayout(jDialog_modificarDatos.getContentPane());
        jDialog_modificarDatos.getContentPane().setLayout(jDialog_modificarDatosLayout);
        jDialog_modificarDatosLayout.setHorizontalGroup(
                jDialog_modificarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jDialog_modificarDatosLayout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDialog_modificarDatosLayout.setVerticalGroup(
                jDialog_modificarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
        );

        jPanel_inventario.setBackground(new java.awt.Color(227, 218, 201));
        jPanel_inventario.setForeground(new java.awt.Color(227, 218, 201));
        jPanel_inventario.setLayout(new java.awt.BorderLayout());

        titulo_contenido3.setBackground(new java.awt.Color(255, 255, 255));
        titulo_contenido3.setFont(new java.awt.Font("Roboto", 3, 14));
        titulo_contenido3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo_contenido3.setText("Resultados Obtenidos de inventario de sede");
        titulo_contenido3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titulo_contenido3.setOpaque(true);
        titulo_contenido3.setPreferredSize(new java.awt.Dimension(794, 17));
        jPanel_inventario.add(titulo_contenido3, java.awt.BorderLayout.NORTH);

        jScrollPane_Table3.setBackground(new java.awt.Color(227, 218, 201));
        jScrollPane_Table3.setForeground(new java.awt.Color(227, 218, 201));
        jScrollPane_Table3.setOpaque(true);
        jScrollPane_Table3.setPreferredSize(new java.awt.Dimension(794, 727));
        jScrollPane_Table3.setViewportView(null);

        jTable_Content3.setBackground(new java.awt.Color(227, 218, 201));
        jTable_Content3.setFont(new java.awt.Font("Roboto", 0, 12));
        jTable_Content3.setForeground(new java.awt.Color(227, 218, 201));
        jTable_Content3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable_Content3.setMinimumSize(new java.awt.Dimension(50, 50));
        jTable_Content3.setPreferredSize(new java.awt.Dimension(788, 721));
        jTable_Content3.setShowGrid(true);
        jScrollPane_Table3.setViewportView(jTable_Content3);

        jPanel_inventario.add(jScrollPane_Table3, java.awt.BorderLayout.CENTER);

        opcionesTabla3.setBackground(new java.awt.Color(0, 153, 204));
        opcionesTabla3.setPreferredSize(new java.awt.Dimension(794, 50));
        opcionesTabla3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 10));

        jTextField_buscarTabla3.setDocument(new LimitarCamposSeguro(25, "Buscar...")
        );
        jTextField_buscarTabla3.setText("Buscar...");
        jTextField_buscarTabla3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField_buscarTabla3.setPreferredSize(new java.awt.Dimension(125, 26));
        jTextField_buscarTabla3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_buscarTabla3FocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_buscarTabla3FocusLost(evt);
            }
        });
        jTextField_buscarTabla3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_buscarTabla3ActionPerformed(evt);
            }
        });
        opcionesTabla3.add(jTextField_buscarTabla3);

        jButton_buscar3.setBackground(new java.awt.Color(204, 204, 204));
        jButton_buscar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa_icon.png")));
        jButton_buscar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_buscar3MouseClicked(evt);
            }
        });
        opcionesTabla3.add(jButton_buscar3);

        jButton_acercar3.setText("Acercar");
        jButton_acercar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_acercar3MouseClicked(evt);
            }
        });
        opcionesTabla3.add(jButton_acercar3);

        jButton_alejar3.setText("Alejar");
        jButton_alejar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_alejar3MouseClicked(evt);
            }
        });
        opcionesTabla3.add(jButton_alejar3);

        jButton_ordenar3.setText("Ordenar");
        jButton_ordenar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_ordenar3MouseClicked(evt);
            }
        });
        opcionesTabla3.add(jButton_ordenar3);

        jButton_filtros3.setText("Filtros");
        jButton_filtros3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_filtros3MouseClicked(evt);
            }
        });
        opcionesTabla3.add(jButton_filtros3);

        jButton_fuente3.setText("Fuente y tamaño");
        jButton_fuente3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_fuente3MouseClicked(evt);
            }
        });
        opcionesTabla3.add(jButton_fuente3);

        jButton_exportar3.setText("Exportar tabla");
        jButton_exportar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_exportar3MouseClicked(evt);
            }
        });
        opcionesTabla3.add(jButton_exportar3);

        jPanel_inventario.add(opcionesTabla3, java.awt.BorderLayout.SOUTH);

        jPanel_estadisticas.setBackground(new java.awt.Color(227, 218, 201));
        jPanel_estadisticas.setForeground(new java.awt.Color(227, 218, 201));
        jPanel_estadisticas.setLayout(new java.awt.BorderLayout());

        titulo_contenido4.setBackground(new java.awt.Color(255, 255, 255));
        titulo_contenido4.setFont(new java.awt.Font("Roboto", 3, 14));
        titulo_contenido4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo_contenido4.setText("Resultados Obtenidos de reporte y estadísticas");
        titulo_contenido4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titulo_contenido4.setOpaque(true);
        titulo_contenido4.setPreferredSize(new java.awt.Dimension(794, 17));
        jPanel_estadisticas.add(titulo_contenido4, java.awt.BorderLayout.NORTH);

        jScrollPane_Table4.setBackground(new java.awt.Color(227, 218, 201));
        jScrollPane_Table4.setForeground(new java.awt.Color(227, 218, 201));
        jScrollPane_Table4.setOpaque(true);
        jScrollPane_Table4.setPreferredSize(new java.awt.Dimension(794, 727));
        jScrollPane_Table4.setViewportView(null);

        jTable_Content4.setBackground(new java.awt.Color(227, 218, 201));
        jTable_Content4.setFont(new java.awt.Font("Roboto", 0, 12));
        jTable_Content4.setForeground(new java.awt.Color(227, 218, 201));
        jTable_Content4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable_Content4.setMinimumSize(new java.awt.Dimension(50, 50));
        jTable_Content4.setPreferredSize(new java.awt.Dimension(788, 721));
        jTable_Content4.setShowGrid(true);
        jScrollPane_Table4.setViewportView(jTable_Content4);

        jPanel_estadisticas.add(jScrollPane_Table4, java.awt.BorderLayout.CENTER);

        opcionesTabla4.setBackground(new java.awt.Color(0, 153, 204));
        opcionesTabla4.setPreferredSize(new java.awt.Dimension(794, 50));
        opcionesTabla4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 10));

        jTextField_buscarTabla4.setDocument(new LimitarCamposSeguro(25, "Buscar...")
        );
        jTextField_buscarTabla4.setText("Buscar...");
        jTextField_buscarTabla4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField_buscarTabla4.setPreferredSize(new java.awt.Dimension(125, 26));
        RegistrarUser.handleFocusGain(jTextField_buscarTabla4, "Buscar...");
        jTextField_buscarTabla4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_buscarTabla4FocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_buscarTabla4FocusLost(evt);
            }
        });
        jTextField_buscarTabla4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_buscarTabla4ActionPerformed(evt);
            }
        });
        opcionesTabla4.add(jTextField_buscarTabla4);

        jButton_buscar4.setBackground(new java.awt.Color(204, 204, 204));
        jButton_buscar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa_icon.png")));
        jButton_buscar4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_buscar4MouseClicked(evt);
            }
        });
        opcionesTabla4.add(jButton_buscar4);

        jButton_acercar4.setText("Acercar");
        jButton_acercar4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_acercar4MouseClicked(evt);
            }
        });
        opcionesTabla4.add(jButton_acercar4);

        jButton_alejar4.setText("Alejar");
        jButton_alejar4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_alejar4MouseClicked(evt);
            }
        });
        opcionesTabla4.add(jButton_alejar4);

        jButton_ordenar4.setText("Ordenar");
        jButton_ordenar4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_ordenar4MouseClicked(evt);
            }
        });
        opcionesTabla4.add(jButton_ordenar4);

        jButton_filtros4.setText("Filtros");
        jButton_filtros4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_filtros4MouseClicked(evt);
            }
        });
        opcionesTabla4.add(jButton_filtros4);

        jButton_fuente4.setText("Fuente y tamaño");
        jButton_fuente4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_fuente4MouseClicked(evt);
            }
        });
        opcionesTabla4.add(jButton_fuente4);

        jButton_exportar4.setText("Exportar tabla");
        jButton_exportar4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_exportar4MouseClicked(evt);
            }
        });
        opcionesTabla4.add(jButton_exportar4);

        jPanel_estadisticas.add(opcionesTabla4, java.awt.BorderLayout.SOUTH);

        jPanel_filtrarEstadistica.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel_filtrarEstadistica.setPreferredSize(new java.awt.Dimension(220, 70));
        jPanel_filtrarEstadistica.setLayout(new java.awt.GridLayout(2, 2));

        jSeparator22.setPreferredSize(new java.awt.Dimension(100, 10));
        jPanel_filtrarEstadistica.add(jSeparator22);
        jPanel_filtrarEstadistica.add(jSeparator23);

        jLabel7.setText("Filtro por fecha");
        jPanel_filtrarEstadistica.add(jLabel7);

        jComboBox_filterColumn1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Elegir...", "Día", "Mes", "Año", "Sede"}));
        jComboBox_filterColumn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_filterColumn1ActionPerformed(evt);
            }
        });
        jPanel_filtrarEstadistica.add(jComboBox_filterColumn1);

        jPanel_soporte.setBackground(new java.awt.Color(227, 218, 201));
        jPanel_soporte.setPreferredSize(new java.awt.Dimension(794, 794));
        jPanel_soporte.setLayout(new java.awt.BorderLayout());

        jLabel10.setFont(new java.awt.Font("Microsoft YaHei", 1, 18));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Preguntas frecuentes ");
        jPanel_soporte.add(jLabel10, java.awt.BorderLayout.NORTH);

        jPanel5.setBackground(new java.awt.Color(227, 218, 201));
        jPanel5.setLayout(new java.awt.GridLayout(3, 10));
        jPanel_soporte.add(jPanel5, java.awt.BorderLayout.CENTER);
        jPanel5.add(PantallaBase.createQuestionPanel("¿Cómo creo el paciente a vacunar?",
                "1. Dar click al botón \'Crear/Editar paciente\' \n"
                        + "2. Llene el formulario con los datos personales del paciente\n"
                        + "3. Si el paciente tiene cartilla de vacunación física, dar click en \'Sí\' y debe registrar cada vacuna\n"
                        + "En este paso puede añadir la vacuna que se va aplicar el paciente.\n"
                        + "4. Espere el mensaje de confirmación de registro."));
        jPanel5.add(PantallaBase.createQuestionPanel("¿Cómo registro una dosis de vacuna a un paciente?",
                "1. Dar click en el botón \'Buscar paciente\' y buscamos con los datos al paciente a vacunar\n"
                        + "2. Rellenar el formulario de la dosis, editar los campos que tienen autocompletado si es necesario\n"
                        + "3. Dar click en \'Registrar\' y esperar el mensaje de confirmación\n"
                        + "El paciente tendrá registrada su dosis de vacuna y si es necesario, puede programar una cita para la siguiente dosis."));
        jPanel5.add(PantallaBase.createQuestionPanel("¿Cómo buscar una dosis de vacuna del paciente o al paciente completo?",
                "1. Dar click en el botón \'Buscar dosis de vacuna\' y buscar con los datos del paciente y vacuna\n"
                        + "2. Si la consulta no da resultados, buscar al paciente completo: \n"
                        + "2.1 Dar click en el botón \'Buscar paciente\' y buscamos con los datos del paciente\n"
                        + "2.2 Si aún no hay resultados esto significa que el paciente no esta registrado en el programa de vacunas y debe crearlo.\n"
                        + "    Refiérase a la pregunta 1 ¿Cómo creo al paciente a vacuna?"));
        jPanel5.add(PantallaBase.createQuestionPanel("¿Cómo actualizo una dosis de vacuna?",
                "1. Similar a registrar una vacuna. \n"
                        + "Dar click en el botón \'Actualizar dosis\' y buscamos al paciente a vacunar y la vacuna\n"
                        + "Si existe la dosis, podrás editar la fecha de aplicación, el número de dosis, el proveedor, sede aplicada.\n"
                        + "La vacuna no se puede modificar, para hacerlo debe eliminar el registro y crear un nuevo registro de vacuna.\n"
                        + "Refiérase a la pregunta 2 ¿Cómo registro una dosis de vacuna a un paciente?"));
        jPanel5.add(PantallaBase.createQuestionPanel("No veo el nombre de vacuna para aplicar ¿Cómo creo una vacuna nueva?",
                "1. Si el nombre de la vacuna para aplicar no lo encuentra, primero verifique con otros nombres como el comercial o de laboratorio o acrónimos\n"
                        + "Si aún no la encuentra, solicite al personal administrativo o informática crear la vacuna nueva\n"
                        + "Por mientras puede utilizar la vacuna de nombre \'NONE - Por Registrar\' para completar la jornada.\n"
                        + "Recuerde actualizar la dosis del paciente con el nombre de la vacuna correcto. Ninguna dosis debe quedar con la vacuna NONE."));
        jPanel5.add(PantallaBase.createQuestionPanel("¿Cómo programo una cita de vacunación a un paciente?",
                "Dar click en \'Agendar cita de vacuna\' y rellenar el formulario basado tanto en los tiempos recomendados de la vacuna y la cómodida del paciente. Esto genera una notificación para el doctor y sede escogido."));
        jPanel5.add(PantallaBase.createQuestionPanel("¿Cómo observo el inventario de vacunas?",
                "1. Dar click en el botón \'Inventario de vacunas\' y podremos ver todas las vacunas con inventario en la sede preferida\n"
                        + "Si la sede no es la que deseamos, buscar la sede en la barra de búsqueda o cambiar la preferencia del usuario. "
                        + "Refiérase a la siguiente pregunta \'¿Cómo cambiar mis preferencias?\'"));
        jPanel5.add(PantallaBase.createQuestionPanel("No veo ningún dato al consultar",
                "Esto significa que usted puede o no estar registrado y/o no tiene ninguna vacuna aplicada.\n"
                        + "Para verificar que este registrado con sus datos correctamente:\n"
                        + "1. De click en el botón \'Modificar datos personales\' y observe si algún dato como su cédula de identidad personal esta mal escrito, si es así, debe modificar para corregir.\n"
                        + "Si a pesar de esto, no ve ningún dato, significa que no tiene ninguna vacuna registrada en el sistema. Puede acudir a su médico para registrar su cartilla de vacunación."));
        jPanel5.add(PantallaBase.createQuestionPanel("¿Cómo cambiar mis preferencias de usuario?",
                "1. Dar click en el botón \'Preferencias\' y actualizamos las preferencias, de manera inicial, el sistema define la sede y el distrito en la primera.\n"
                        + "Para el distrito no puede definir una preferencia.\n"
                        + "Si selecciona que las campos de insertar algún dato sean en una ventana emergente siempre será así, excepto en Modificar datos personales y Modificar credenciales que son ventanas emergentes y no se puede cambiar.\n"
                        + "Si tiene activada editar directo en tabla podrá editar las dosis de vacuna, datos del paciente y agregar datos en las opciones de consulta sin necesidad de usar el otro botón.\n"
                        + "Si desea modificar sus datos personales o su credencial de acceso (usuario y contraseña)\n"
                        + "Refiérase a la siguiente pregunta \'¿Cómo cambio mis datos personales o credenciales de acceso?\'"));
        jPanel5.add(PantallaBase.createQuestionPanel("¿Cómo cambio mis datos personales o credenciales de acceso?",
                "Nota: Se cambia sus datos personales, no los del paciente\n"
                        + "1. Dar click en el botón \'Modificar datos personales\' o \'Modificar credenciales\' y editar solamente los datos que deseamos modificar.\n"
                        + "Consejos: La cédula de identidad personal debe estar escrito tal cual su documento.\n"
                        + "La fecha de nacimiento debe estar en el formato año - mes - día hora : minutos (la hora y minutos es opcional).\n"
                        + "Si su distrito no se encuentra, puede significar que es nuevo y debe utilizar \'Distrito por registrar\'. Debe informar su distrito y provincia correcta a su médico o sede para corregir.\n"
                        + "El teléfono puede ser celular o fijo y debe estar los números pegados. Si es extranjero o diferente de 507 debe colocar su prefijo y códigos necesarios al inicio.\n"
                        + "Al dar click en el botón \'Actualizar\' se cerrará su sesión y debe ingresar nuevamente con sus credenciales correctas.\n"
                        + "Si olvido su contraseña, deberá cerrar sesión y dar click en \'¿Olvidó su contraseña?\'"));
        jPanel5.revalidate();
        jPanel5.repaint();

        jLabel11.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Si su duda no fue resuelta. Contacte al soporte técnico de una sede hospitalaria pública o pregunte a su doctor.");
        jPanel_soporte.add(jLabel11, java.awt.BorderLayout.SOUTH);

        jPanel_filtrarInventario.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel_filtrarInventario.setLayout(new java.awt.GridLayout(3, 2));
        jPanel_filtrarInventario.add(jSeparator24);
        jPanel_filtrarInventario.add(jSeparator25);

        jLabel8.setText("Filtrar por sede");
        jPanel_filtrarInventario.add(jLabel8);

        jComboBox_filterColumn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_filterColumn2ActionPerformed(evt);
            }
        });
        jPanel_filtrarInventario.add(jComboBox_filterColumn2);

        jLabel12.setText("Filtrar por vacuna");
        jPanel_filtrarInventario.add(jLabel12);

        jComboBox_filterColumn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_filterColumn3ActionPerformed(evt);
            }
        });
        jPanel_filtrarInventario.add(jComboBox_filterColumn3);

        jPanel_buscarDosis.setBackground(new java.awt.Color(227, 218, 201));
        jPanel_buscarDosis.setForeground(new java.awt.Color(227, 218, 201));
        jPanel_buscarDosis.setPreferredSize(new java.awt.Dimension(794, 794));
        jPanel_buscarDosis.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel_buscarDosisAncestorAdded(evt);
            }

            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }

            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel_buscarDosis.setLayout(new javax.swing.BoxLayout(jPanel_buscarDosis, javax.swing.BoxLayout.Y_AXIS));

        jPanel7.setBackground(new java.awt.Color(227, 218, 201));
        jPanel7.setMaximumSize(new java.awt.Dimension(2147483647, 500));
        jPanel7.setMinimumSize(new java.awt.Dimension(293, 107));
        jPanel7.setPreferredSize(new java.awt.Dimension(694, 125));
        jPanel7.setLayout(new java.awt.BorderLayout());

        titulo_contenido5.setBackground(new java.awt.Color(255, 255, 255));
        titulo_contenido5.setFont(new java.awt.Font("Roboto", 3, 14));
        titulo_contenido5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo_contenido5.setText("Resultados Obtenidos de Dosis");
        titulo_contenido5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titulo_contenido5.setOpaque(true);
        titulo_contenido5.setPreferredSize(new java.awt.Dimension(794, 17));
        jPanel7.add(titulo_contenido5, java.awt.BorderLayout.NORTH);

        jPanel6.setPreferredSize(new java.awt.Dimension(794, 75));
        jPanel6.setLayout(new java.awt.GridLayout(5, 2, 20, 0));

        jLabel13.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Sede");
        jPanel6.add(jLabel13);

        jTextField3.setDocument(new LimitarCamposSeguro(50, "Buscar por sede..."));
        jTextField3.setText("Buscar por sede...");
        jTextField3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        RegistrarUser.handleFocusGain(jTextField3, "Buscar por sede...");
        jTextField3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField3FocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField3FocusLost(evt);
            }
        });
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel6.add(jTextField3);

        jLabel14.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Desde");
        jPanel6.add(jLabel14);

        jTextField4.setDocument(new LimitarCamposSeguro(50, "Buscar desde la fecha AAAA-MM-DD..."));
        jTextField4.setText("Buscar desde la fecha AAAA-MM-DD...");
        jTextField4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        RegistrarUser.handleFocusGain(jTextField4, "Buscar desde la fecha AAAA-MM-DD...");
        jTextField4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField4FocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField4FocusLost(evt);
            }
        });
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel6.add(jTextField4);

        jLabel15.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Hasta");
        jPanel6.add(jLabel15);

        jTextField5.setDocument(new LimitarCamposSeguro(50, "Buscar hasta la fecha AAAA-MM-DD..."));
        jTextField5.setText("Buscar hasta la fecha AAAA-MM-DD...");
        jTextField5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        RegistrarUser.handleFocusGain(jTextField5, "Buscar hasta la fecha AAAA-MM-DD...");
        jTextField5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField5FocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField5FocusLost(evt);
            }
        });
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jPanel6.add(jTextField5);

        jLabel16.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Vacuna");
        jPanel6.add(jLabel16);

        jComboBox3.setPreferredSize(new java.awt.Dimension(150, 26));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jPanel6.add(jComboBox3);

        jLabel17.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Número de Dosis");
        jPanel6.add(jLabel17);

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Elegir...", "Primera dosis", "Segunda dosis", "Tercera dosis", "Refuerzo", "Primer refuerzo", "Segundo refuerzo", "Dosis previa"}));
        jComboBox4.setPreferredSize(new java.awt.Dimension(150, 26));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });
        jPanel6.add(jComboBox4);

        jPanel7.add(jPanel6, java.awt.BorderLayout.CENTER);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa_icon.png")));
        jButton2.setPreferredSize(new java.awt.Dimension(70, 27));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel7.add(jButton2, java.awt.BorderLayout.EAST);

        jPanel_buscarDosis.add(jPanel7);

        jScrollPane_Table5.setBackground(new java.awt.Color(227, 218, 201));
        jScrollPane_Table5.setForeground(new java.awt.Color(227, 218, 201));
        jScrollPane_Table5.setOpaque(true);
        jScrollPane_Table5.setPreferredSize(new java.awt.Dimension(794, 625));
        jScrollPane_Table5.setViewportView(null);

        jTable_Content5.setBackground(new java.awt.Color(227, 218, 201));
        jTable_Content5.setFont(new java.awt.Font("Roboto", 0, 12));
        jTable_Content5.setForeground(new java.awt.Color(227, 218, 201));
        jTable_Content5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable_Content5.setMinimumSize(new java.awt.Dimension(50, 50));
        jTable_Content5.setPreferredSize(new java.awt.Dimension(788, 619));
        jTable_Content5.setShowGrid(true);
        jScrollPane_Table5.setViewportView(jTable_Content5);

        jPanel_buscarDosis.add(jScrollPane_Table5);

        opcionesTabla5.setBackground(new java.awt.Color(0, 153, 204));
        opcionesTabla5.setMaximumSize(new java.awt.Dimension(32767, 100));
        opcionesTabla5.setMinimumSize(new java.awt.Dimension(594, 24));
        opcionesTabla5.setPreferredSize(new java.awt.Dimension(794, 44));
        opcionesTabla5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 10));

        jTextField_buscarTabla5.setDocument(new LimitarCamposSeguro(25, "Buscar...")
        );
        jTextField_buscarTabla5.setText("Buscar...");
        jTextField_buscarTabla5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField_buscarTabla5.setPreferredSize(new java.awt.Dimension(125, 26));
        RegistrarUser.handleFocusGain(jTextField_buscarTabla5, "Buscar...");
        jTextField_buscarTabla5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_buscarTabla5FocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_buscarTabla5FocusLost(evt);
            }
        });
        jTextField_buscarTabla5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_buscarTabla5ActionPerformed(evt);
            }
        });
        opcionesTabla5.add(jTextField_buscarTabla5);

        jButton_buscar5.setBackground(new java.awt.Color(204, 204, 204));
        jButton_buscar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa_icon.png")));
        jButton_buscar5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_buscar5MouseClicked(evt);
            }
        });
        opcionesTabla5.add(jButton_buscar5);

        jButton_acercar5.setText("Acercar");
        jButton_acercar5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_acercar5MouseClicked(evt);
            }
        });
        opcionesTabla5.add(jButton_acercar5);

        jButton_alejar5.setText("Alejar");
        jButton_alejar5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_alejar5MouseClicked(evt);
            }
        });
        opcionesTabla5.add(jButton_alejar5);

        jButton_ordenar5.setText("Ordenar");
        jButton_ordenar5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_ordenar5MouseClicked(evt);
            }
        });
        opcionesTabla5.add(jButton_ordenar5);

        jButton_filtros5.setText("Filtros");
        jButton_filtros5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_filtros5MouseClicked(evt);
            }
        });
        opcionesTabla5.add(jButton_filtros5);

        jButton_fuente5.setText("Fuente y tamaño");
        jButton_fuente5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_fuente5MouseClicked(evt);
            }
        });
        opcionesTabla5.add(jButton_fuente5);

        jButton_exportar5.setText("Exportar tabla");
        jButton_exportar5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_exportar5MouseClicked(evt);
            }
        });
        opcionesTabla5.add(jButton_exportar5);

        jPanel_buscarDosis.add(opcionesTabla5);

        jPanel_preferencias.setBackground(new java.awt.Color(227, 218, 201));
        jPanel_preferencias.setPreferredSize(new java.awt.Dimension(794, 794));
        jPanel_preferencias.setLayout(new javax.swing.BoxLayout(jPanel_preferencias, javax.swing.BoxLayout.Y_AXIS));

        icon_preferencias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ajuetes3.png")));
        icon_preferencias.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        icon_preferencias.setPreferredSize(new java.awt.Dimension(130, 120));
        jPanel_preferencias.add(icon_preferencias);

        titulo3.setFont(new java.awt.Font("Microsoft YaHei", 1, 24));
        titulo3.setForeground(new java.awt.Color(0, 0, 0));
        titulo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo3.setText("Preferencias");
        titulo3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel_preferencias.add(titulo3);

        jPanel_separador1.setBackground(new java.awt.Color(227, 218, 201));
        jPanel_separador1.setMaximumSize(new java.awt.Dimension(32767, 25));

        javax.swing.GroupLayout jPanel_separador1Layout = new javax.swing.GroupLayout(jPanel_separador1);
        jPanel_separador1.setLayout(jPanel_separador1Layout);
        jPanel_separador1Layout.setHorizontalGroup(
                jPanel_separador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 977, Short.MAX_VALUE)
        );
        jPanel_separador1Layout.setVerticalGroup(
                jPanel_separador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel_preferencias.add(jPanel_separador1);

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 14));
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Tamaño y Fuente preferida");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel_preferencias.add(jLabel4);

        jPanel_separador2.setBackground(new java.awt.Color(227, 218, 201));
        jPanel_separador2.setMaximumSize(new java.awt.Dimension(32767, 15));

        javax.swing.GroupLayout jPanel_separador2Layout = new javax.swing.GroupLayout(jPanel_separador2);
        jPanel_separador2.setLayout(jPanel_separador2Layout);
        jPanel_separador2Layout.setHorizontalGroup(
                jPanel_separador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 977, Short.MAX_VALUE)
        );
        jPanel_separador2Layout.setVerticalGroup(
                jPanel_separador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 15, Short.MAX_VALUE)
        );

        jPanel_preferencias.add(jPanel_separador2);

        jPanel_fontChooser.setBackground(new java.awt.Color(227, 218, 201));
        jPanel_fontChooser.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel_fontChooser.setMaximumSize(new java.awt.Dimension(700, 250));
        jPanel_fontChooser.setPreferredSize(new java.awt.Dimension(460, 250));
        jPanel_fontChooser.setLayout(new java.awt.GridLayout(3, 2, 10, 10));
        jPanel_preferencias.add(jPanel_fontChooser);
        // Familia de la fuente
        JLabel familyLabel = new JLabel("Familia:");
        familyLabel.setFont(new Font("Roboto", 0, 14));
        JComboBox<String> familyComboBox = new JComboBox<>(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
        familyComboBox.setFont(new Font("Roboto", 0, 14));
        jPanel_fontChooser.add(familyLabel);
        jPanel_fontChooser.add(familyComboBox);

        // Estilo de la fuente
        JLabel styleLabel = new JLabel("Estilo:");
        styleLabel.setFont(new Font("Roboto", 0, 14));
        String[] styles = {"Regular", "Negrita", "Cursiva", "Negrita Cursiva"};
        JComboBox<String> styleComboBox = new JComboBox<>(styles);
        styleComboBox.setFont(new Font("Roboto", 0, 14));
        jPanel_fontChooser.add(styleLabel);
        jPanel_fontChooser.add(styleComboBox);

        // Tamaño de la fuente
        JLabel sizeLabel = new JLabel("Tamaño:");
        sizeLabel.setFont(new Font("Roboto", 0, 14));
        JSpinner sizeSpinner = new JSpinner(new SpinnerNumberModel(12, 1, 100, 1));
        sizeSpinner.setFont(new Font("Roboto", 0, 14));
        jPanel_fontChooser.add(sizeLabel);
        jPanel_fontChooser.add(sizeSpinner);

        jPanel_separador3.setBackground(new java.awt.Color(227, 218, 201));
        jPanel_separador3.setMaximumSize(new java.awt.Dimension(32767, 25));

        javax.swing.GroupLayout jPanel_separador3Layout = new javax.swing.GroupLayout(jPanel_separador3);
        jPanel_separador3.setLayout(jPanel_separador3Layout);
        jPanel_separador3Layout.setHorizontalGroup(
                jPanel_separador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 977, Short.MAX_VALUE)
        );
        jPanel_separador3Layout.setVerticalGroup(
                jPanel_separador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel_preferencias.add(jPanel_separador3);

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 14));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Tipo de archivo exportar preferido");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel_preferencias.add(jLabel1);

        jComboBox_exportarType.setFont(new java.awt.Font("Roboto", 0, 14));
        jComboBox_exportarType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Elegir...", "CSV", "TXT", "PDF", "Excel"}));
        jComboBox_exportarType.setMaximumSize(new java.awt.Dimension(367, 40));
        jComboBox_exportarType.setPreferredSize(new java.awt.Dimension(190, 37));
        jPanel_preferencias.add(jComboBox_exportarType);

        jPanel_separador4.setBackground(new java.awt.Color(227, 218, 201));
        jPanel_separador4.setMaximumSize(new java.awt.Dimension(32767, 25));

        javax.swing.GroupLayout jPanel_separador4Layout = new javax.swing.GroupLayout(jPanel_separador4);
        jPanel_separador4.setLayout(jPanel_separador4Layout);
        jPanel_separador4Layout.setHorizontalGroup(
                jPanel_separador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 977, Short.MAX_VALUE)
        );
        jPanel_separador4Layout.setVerticalGroup(
                jPanel_separador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel_preferencias.add(jPanel_separador4);

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 14));
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Sede de salud preferida");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel_preferencias.add(jLabel5);

        jComboBox_exportarType1.setFont(new java.awt.Font("Roboto", 0, 14));
        jComboBox_exportarType1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Elegir..."}));
        jComboBox_exportarType1.setMaximumSize(new java.awt.Dimension(567, 40));
        jComboBox_exportarType1.setPreferredSize(new java.awt.Dimension(450, 37));
        jPanel_preferencias.add(jComboBox_exportarType1);

        jPanel_separador5.setBackground(new java.awt.Color(227, 218, 201));
        jPanel_separador5.setMaximumSize(new java.awt.Dimension(32767, 25));

        javax.swing.GroupLayout jPanel_separador5Layout = new javax.swing.GroupLayout(jPanel_separador5);
        jPanel_separador5.setLayout(jPanel_separador5Layout);
        jPanel_separador5Layout.setHorizontalGroup(
                jPanel_separador5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 977, Short.MAX_VALUE)
        );
        jPanel_separador5Layout.setVerticalGroup(
                jPanel_separador5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel_preferencias.add(jPanel_separador5);

        jButton_savePreferences.setFont(new java.awt.Font("Roboto", 0, 14));
        jButton_savePreferences.setForeground(new java.awt.Color(255, 255, 255));
        jButton_savePreferences.setText("Guardar preferencias");
        jButton_savePreferences.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_savePreferences.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_savePreferences.setMaximumSize(new java.awt.Dimension(166, 48));
        jButton_savePreferences.setPreferredSize(new java.awt.Dimension(166, 48));
        jButton_savePreferences.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_savePreferencesMouseClicked(evt);
            }
        });
        jPanel_preferencias.add(jButton_savePreferences);

        jDialog_modificarCred1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog_modificarCred1.setTitle("Programa Vacunas Panamá - Modificar credenciales");
        jDialog_modificarCred.setModal(true);
        jDialog_modificarCred1.setResizable(false);
        jDialog_modificarCred1.setSize(new java.awt.Dimension(450, 550));

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        background_dialog3.setBackground(new java.awt.Color(255, 255, 255));
        background_dialog3.setPreferredSize(new java.awt.Dimension(444, 494));
        background_dialog3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo4.setFont(new java.awt.Font("Microsoft YaHei", 1, 14));
        titulo4.setForeground(new java.awt.Color(0, 0, 0));
        titulo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo4.setText("Modificar credenciales de acceso");
        background_dialog3.add(titulo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 25, 269, -1));

        jTextArea4.setEditable(false);
        jTextArea4.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea4.setFont(new java.awt.Font("Microsoft YaHei", 2, 11));
        jTextArea4.setForeground(new java.awt.Color(102, 102, 102));
        jTextArea4.setLineWrap(true);
        jTextArea4.setRows(5);
        jTextArea4.setText("Indicaciones: Para modificar las credenciales debe ingresar su usuario y contraseña anterior, si solo desea cambiar el usuario debe dejar en blanco los campos de nueva contraseña.\nDebe repetir la contraseña nueva si desea modificarla, sino no se cambiará la misma.\nSi desea modificar otro dato personal, utilice el otro botón.");
        jTextArea4.setWrapStyleWord(true);
        jTextArea4.setBorder(null);
        jTextArea4.setFocusable(false);
        background_dialog3.add(jTextArea4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 380, 100));

        usuario1.setBackground(new java.awt.Color(0, 0, 0));
        usuario1.setFont(new java.awt.Font("Roboto", 0, 12));
        usuario1.setForeground(new java.awt.Color(0, 0, 0));
        usuario1.setText("Usuario anterior *");
        background_dialog3.add(usuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jTextField_usuario1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_usuario1.setDocument(new LimitarCamposSeguro(50, "Ingrese su usuario"));
        jTextField_usuario1.setFont(new java.awt.Font("Roboto", 0, 14));
        jTextField_usuario1.setForeground(java.awt.Color.gray);
        jTextField_usuario1.setText("Ingrese su usuario");
        jTextField_usuario1.setActionCommand("<Not Set>");
        jTextField_usuario1.setBorder(null);
        jTextField_usuario1.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_usuario1, "Ingrese su usuario");
        jTextField_usuario1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_usuario1FocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_usuario1FocusLost(evt);
            }
        });
        jTextField_usuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_usuario1ActionPerformed(evt);
            }
        });
        background_dialog3.add(jTextField_usuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 380, -1));

        jSeparator8.setForeground(new java.awt.Color(30, 30, 30));
        background_dialog3.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 380, 21));

        usuario_nuevo.setBackground(new java.awt.Color(0, 0, 0));
        usuario_nuevo.setFont(new java.awt.Font("Roboto", 0, 12));
        usuario_nuevo.setForeground(new java.awt.Color(0, 0, 0));
        usuario_nuevo.setText("Usuario nuevo");
        background_dialog3.add(usuario_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jTextField_usuarioNuevo.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_usuarioNuevo.setDocument(new LimitarCamposSeguro(50, "Ingrese un usuario nuevo"));
        jTextField_usuarioNuevo.setFont(new java.awt.Font("Roboto", 0, 14));
        jTextField_usuarioNuevo.setForeground(java.awt.Color.gray);
        jTextField_usuarioNuevo.setText("Ingrese un usuario nuevo");
        jTextField_usuarioNuevo.setActionCommand("<Not Set>");
        jTextField_usuarioNuevo.setBorder(null);
        jTextField_usuarioNuevo.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_usuarioNuevo, "Ingrese un usuario nuevo");
        jTextField_usuarioNuevo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_usuarioNuevoFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_usuarioNuevoFocusLost(evt);
            }
        });
        jTextField_usuarioNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_usuarioNuevoActionPerformed(evt);
            }
        });
        background_dialog3.add(jTextField_usuarioNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 380, -1));

        jSeparator21.setForeground(new java.awt.Color(30, 30, 30));
        background_dialog3.add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 380, 21));

        contrasena.setBackground(new java.awt.Color(0, 0, 0));
        contrasena.setFont(new java.awt.Font("Roboto", 0, 12));
        contrasena.setForeground(new java.awt.Color(0, 0, 0));
        contrasena.setText("Contraseña nueva");
        background_dialog3.add(contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        jPasswordField_nueva1.setBackground(new java.awt.Color(255, 255, 255));
        jPasswordField_nueva1.setDocument(new LimitarCamposSeguro(20, "Ingrese su contraseña"));
        jPasswordField_nueva1.setFont(new java.awt.Font("Roboto", 0, 14));
        jPasswordField_nueva1.setForeground(java.awt.Color.gray);
        jPasswordField_nueva1.setText("Ingrese su contraseña");
        jPasswordField_nueva1.setBorder(null);
        jPasswordField_nueva1.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jPasswordField_nueva1, "Ingrese su contraseña");
        jPasswordField_nueva1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordField_nueva1FocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordField_nueva1FocusLost(evt);
            }
        });
        jPasswordField_nueva1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField_nueva1ActionPerformed(evt);
            }
        });
        background_dialog3.add(jPasswordField_nueva1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 380, -1));

        jSeparator11.setForeground(new java.awt.Color(30, 30, 30));
        background_dialog3.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 380, 21));

        repetir_contrasena.setBackground(new java.awt.Color(0, 0, 0));
        repetir_contrasena.setFont(new java.awt.Font("Roboto", 0, 12));
        repetir_contrasena.setForeground(new java.awt.Color(0, 0, 0));
        repetir_contrasena.setText("Repetir contraseña nueva *");
        background_dialog3.add(repetir_contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        jPasswordField_nueva2.setBackground(new java.awt.Color(255, 255, 255));
        jPasswordField_nueva2.setDocument(new LimitarCamposSeguro(20, "Repita su contraseña"));
        jPasswordField_nueva2.setFont(new java.awt.Font("Roboto", 0, 14));
        jPasswordField_nueva2.setForeground(java.awt.Color.gray);
        jPasswordField_nueva2.setText("Repita su contraseña");
        jPasswordField_nueva2.setBorder(null);
        jPasswordField_nueva2.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jPasswordField_nueva2, "Repita su contraseña");
        jPasswordField_nueva2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordField_nueva2FocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordField_nueva2FocusLost(evt);
            }
        });
        jPasswordField_nueva2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField_nueva2ActionPerformed(evt);
            }
        });
        background_dialog3.add(jPasswordField_nueva2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 380, -1));

        jSeparator7.setForeground(new java.awt.Color(30, 30, 30));
        background_dialog3.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 380, 21));

        errorMessage2.setFont(new java.awt.Font("Roboto", 1, 14));
        errorMessage2.setForeground(java.awt.Color.red);
        errorMessage2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorMessage2.setText("Error. ");
        errorMessage2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        errorMessage2.setVisible(false);
        background_dialog3.add(errorMessage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 430, 440, -1));

        jButton_modificar2.setBackground(new java.awt.Color(0, 204, 0));
        jButton_modificar2.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jButton_modificar2.setForeground(new java.awt.Color(0, 0, 0));
        jButton_modificar2.setText("Modificar");
        jButton_modificar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_modificar2MouseClicked(evt);
            }
        });
        background_dialog3.add(jButton_modificar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 450, -1, -1));

        jButton_cancelar2.setBackground(new java.awt.Color(153, 153, 153));
        jButton_cancelar2.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jButton_cancelar2.setForeground(new java.awt.Color(0, 0, 0));
        jButton_cancelar2.setText("Cancelar");
        jButton_cancelar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_cancelar2MouseClicked(evt);
            }
        });
        background_dialog3.add(jButton_cancelar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, -1, -1));

        contrasena_anterior.setBackground(new java.awt.Color(0, 0, 0));
        contrasena_anterior.setFont(new java.awt.Font("Roboto", 0, 12));
        contrasena_anterior.setForeground(new java.awt.Color(0, 0, 0));
        contrasena_anterior.setText("Contraseña anterior *");
        background_dialog3.add(contrasena_anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        jPasswordField_vieja.setBackground(new java.awt.Color(255, 255, 255));
        jPasswordField_vieja.setDocument(new LimitarCamposSeguro(20, "Ingrese su contraseña"));
        jPasswordField_vieja.setFont(new java.awt.Font("Roboto", 0, 14));
        jPasswordField_vieja.setForeground(java.awt.Color.gray);
        jPasswordField_vieja.setText("Ingrese su contraseña");
        jPasswordField_vieja.setBorder(null);
        jPasswordField_vieja.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jPasswordField_vieja, "Ingrese su contraseña");
        jPasswordField_vieja.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordField_viejaFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordField_viejaFocusLost(evt);
            }
        });
        jPasswordField_vieja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField_viejaActionPerformed(evt);
            }
        });
        background_dialog3.add(jPasswordField_vieja, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 380, -1));

        jSeparator26.setForeground(new java.awt.Color(30, 30, 30));
        background_dialog3.add(jSeparator26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 380, 21));

        jScrollPane4.setViewportView(background_dialog3);

        javax.swing.GroupLayout jDialog_modificarCred1Layout = new javax.swing.GroupLayout(jDialog_modificarCred1.getContentPane());
        jDialog_modificarCred1.getContentPane().setLayout(jDialog_modificarCred1Layout);
        jDialog_modificarCred1Layout.setHorizontalGroup(
                jDialog_modificarCred1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4)
        );
        jDialog_modificarCred1Layout.setVerticalGroup(
                jDialog_modificarCred1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Programa Vacunas Panamá - Doctor / Enfermera");
        setSize(new java.awt.Dimension(1000, 800));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jScrollPane3.setPreferredSize(getSize());

        background.setBackground(new java.awt.Color(227, 218, 201));
        background.setForeground(new java.awt.Color(227, 218, 201));
        background.setMinimumSize(new java.awt.Dimension(994, 794));
        background.setPreferredSize(new java.awt.Dimension(994, 794));
        background.setLayout(new java.awt.BorderLayout());

        jPanel_menuOpciones.setBackground(new java.awt.Color(39, 104, 165));
        jPanel_menuOpciones.setForeground(new java.awt.Color(48, 48, 46));
        jPanel_menuOpciones.setAutoscrolls(true);
        jPanel_menuOpciones.setMaximumSize(getSize());
        jPanel_menuOpciones.setPreferredSize(new java.awt.Dimension(200, 0));
        jPanel_menuOpciones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 5));

        separador1.setBackground(new java.awt.Color(39, 104, 165));
        separador1.setForeground(new java.awt.Color(48, 48, 46));
        separador1.setPreferredSize(new java.awt.Dimension(150, 35));

        javax.swing.GroupLayout separador1Layout = new javax.swing.GroupLayout(separador1);
        separador1.setLayout(separador1Layout);
        separador1Layout.setHorizontalGroup(
                separador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        separador1Layout.setVerticalGroup(
                separador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel_menuOpciones.add(separador1);

        icon_project.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon_project.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/operacionVacunas_logo.png")));
        icon_project.setAlignmentX(0.5F);
        icon_project.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        icon_project.setMaximumSize(new java.awt.Dimension(200, 200));
        icon_project.setMinimumSize(new java.awt.Dimension(50, 50));
        icon_project.setName("");
        icon_project.setPreferredSize(new java.awt.Dimension(135, 135));
        jPanel_menuOpciones.add(icon_project);
        icon_project.getAccessibleContext().setAccessibleName("logo");

        rolName.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        rolName.setForeground(new java.awt.Color(255, 255, 255));
        rolName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rolName.setText("¡ Hola Doctor / Enfermera !");
        rolName.setAlignmentX(1.0F);
        rolName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rolName.setPreferredSize(new java.awt.Dimension(170, 30));
        jPanel_menuOpciones.add(rolName);

        nombreBienvenida.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        nombreBienvenida.setForeground(new java.awt.Color(255, 255, 255));
        nombreBienvenida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreBienvenida.setText("Nombre");
        nombreBienvenida.setAlignmentX(1.0F);
        nombreBienvenida.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nombreBienvenida.setPreferredSize(new java.awt.Dimension(150, 30));
        jPanel_menuOpciones.add(nombreBienvenida);

        button_opcion1.setForeground(new java.awt.Color(255, 255, 255));
        button_opcion1.setText("Mis pacientes");
        button_opcion1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_opcion1.setPreferredSize(new java.awt.Dimension(160, 30));
        button_opcion1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_opcion1MouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_opcion1);

        button_opcion2.setForeground(new java.awt.Color(255, 255, 255));
        button_opcion2.setText("Buscar paciente");
        button_opcion2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_opcion2.setPreferredSize(new java.awt.Dimension(160, 30));
        button_opcion2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_opcion2MouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_opcion2);

        button_opcion3.setForeground(new java.awt.Color(255, 255, 255));
        button_opcion3.setText("Buscar dosis de vacuna");
        button_opcion3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_opcion3.setPreferredSize(new java.awt.Dimension(160, 30));
        button_opcion3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_opcion3MouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_opcion3);

        button_opcion4.setForeground(new java.awt.Color(255, 255, 255));
        button_opcion4.setText("Actualizar dosis");
        button_opcion4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_opcion4.setPreferredSize(new java.awt.Dimension(160, 30));
        button_opcion4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_opcion4MouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_opcion4);

        button_opcion5.setForeground(new java.awt.Color(255, 255, 255));
        button_opcion5.setText("Agendar cita de vacuna");
        button_opcion5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_opcion5.setPreferredSize(new java.awt.Dimension(160, 30));
        button_opcion5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_opcion5MouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_opcion5);

        button_opcion6.setForeground(new java.awt.Color(255, 255, 255));
        button_opcion6.setText("Crear / Editar paciente");
        button_opcion6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_opcion6.setPreferredSize(new java.awt.Dimension(160, 30));
        button_opcion6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_opcion6MouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_opcion6);

        button_opcion7.setForeground(new java.awt.Color(255, 255, 255));
        button_opcion7.setText("Inventario de vacunas");
        button_opcion7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_opcion7.setPreferredSize(new java.awt.Dimension(160, 30));
        button_opcion7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_opcion7MouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_opcion7);

        button_opcion8.setForeground(new java.awt.Color(255, 255, 255));
        button_opcion8.setText("Reporte y estadísticas");
        button_opcion8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_opcion8.setPreferredSize(new java.awt.Dimension(160, 30));
        button_opcion8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_opcion8MouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_opcion8);

        separador2.setBackground(new java.awt.Color(39, 104, 165));
        separador2.setForeground(new java.awt.Color(48, 48, 46));
        separador2.setPreferredSize(new java.awt.Dimension(150, 17));

        javax.swing.GroupLayout separador2Layout = new javax.swing.GroupLayout(separador2);
        separador2.setLayout(separador2Layout);
        separador2Layout.setHorizontalGroup(
                separador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        separador2Layout.setVerticalGroup(
                separador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel_menuOpciones.add(separador2);

        button_modificarDatos.setForeground(new java.awt.Color(255, 255, 255));
        button_modificarDatos.setText("Modificar datos personales");
        button_modificarDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_modificarDatos.setPreferredSize(new java.awt.Dimension(160, 30));
        button_modificarDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_modificarDatosMouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_modificarDatos);

        button_modificarCred.setForeground(new java.awt.Color(255, 255, 255));
        button_modificarCred.setText("Modificar credenciales");
        button_modificarCred.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_modificarCred.setPreferredSize(new java.awt.Dimension(160, 30));
        button_modificarCred.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_modificarCredMouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_modificarCred);

        button_preferencias.setForeground(new java.awt.Color(255, 255, 255));
        button_preferencias.setText("Preferencias");
        button_preferencias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_preferencias.setPreferredSize(new java.awt.Dimension(160, 30));
        button_preferencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_preferenciasMouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_preferencias);

        button_soporte.setForeground(new java.awt.Color(255, 255, 255));
        button_soporte.setText("Soporte");
        button_soporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_soporte.setPreferredSize(new java.awt.Dimension(160, 30));
        button_soporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_soporteMouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_soporte);

        button_logOut.setBackground(new java.awt.Color(255, 85, 73));
        button_logOut.setForeground(new java.awt.Color(255, 255, 255));
        button_logOut.setText("Salir");
        button_logOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_logOut.setPreferredSize(new java.awt.Dimension(160, 30));
        button_logOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_logOutMouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_logOut);

        background.add(jPanel_menuOpciones, java.awt.BorderLayout.WEST);

        jPanel_derecho.setBackground(new java.awt.Color(227, 218, 201));
        jPanel_derecho.setPreferredSize(new java.awt.Dimension(794, 0));
        jPanel_derecho.setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(227, 218, 201));
        jPanel1.setPreferredSize(new java.awt.Dimension(794, 0));
        mostrando = jPanel1;

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei", 1, 20));
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Bienvenido al Programa Vacunas Panamá");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_derecho.add(jPanel1, "vacio");

        background.add(jPanel_derecho, java.awt.BorderLayout.CENTER);

        jScrollPane3.setViewportView(background);

        getContentPane().add(jScrollPane3, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void jButton_acercarMouseClicked(java.awt.event.MouseEvent evt) {
        Font currentFont = jTable_Content.getFont();
        jTable_Content.setFont(currentFont.deriveFont(currentFont.getSize() + 2f));
        /* TODO por mover eventos de jPanel mostrarTabla en doctor es Mis Pacientes */
    }

    private void jButton_alejarMouseClicked(java.awt.event.MouseEvent evt) {
        Font currentFont = jTable_Content.getFont();
        jTable_Content.setFont(currentFont.deriveFont(currentFont.getSize() - 2f));
        /* TODO por mover eventos de jPanel mostrarTabla en doctor es Mis Pacientes */
    }

    private void jButton_fuenteMouseClicked(java.awt.event.MouseEvent evt) {
        JFontChooser fontChooser = new JFontChooser(this);
        boolean result = fontChooser.showDialog(this);
        if (result) {
            Font font = fontChooser.getSelectedFont();
            jTable_Content.setFont(font);
            jTable_Content.repaint();
        }
        /* TODO por mover eventos de jPanel mostrarTabla en doctor es Mis Pacientes */
    }

    private void jButton_exportarMouseClicked(java.awt.event.MouseEvent evt) {
        /* TODO llamada al método exportar en csv o excel o pdf */
        /* TODO por mover eventos de jPanel mostrarTabla en doctor es Mis Pacientes */
    }

    private void formComponentShown(java.awt.event.ComponentEvent evt) {
        Login.setImageLabal(icon_project, "src/images/operacionVacunas_Logo.png");
        /* TODO por mover */
    }

    /* eventos de jPanel mostrarTabla en doctor es Mis Pacientes */
    private void jButton_buscarMouseClicked(java.awt.event.MouseEvent evt) {
        jTextField_buscarTabla.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jTextField_buscarTabla.setForeground(Color.BLACK);

        String patronBuscado = jTextField_buscarTabla.getText();
        if (!patronBuscado.isBlank() || !patronBuscado.equals("Buscar...")) {
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTable_Content.getModel());
            jTable_Content.setRowSorter(sorter);
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + patronBuscado));
        } else {
            jTextField_buscarTabla.setBorder(BorderFactory.createLineBorder(Color.red));
            jTextField_buscarTabla.setForeground(Color.red);
        }
    }

    private void jTextField_buscarTablaActionPerformed(java.awt.event.ActionEvent evt) {
        jButton_buscarMouseClicked(null);
    }

    private void jTextField_buscarTablaFocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_buscarTabla, "Buscar...");
    }

    private void jTextField_buscarTablaFocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_buscarTabla, "Buscar...");
    }

    private void jButton_filtrosMouseClicked(java.awt.event.MouseEvent evt) {
        if (!jPanel_mostrarTabla.isAncestorOf(jPanel_filtrar1)) {
            jPanel_mostrarTabla.add(jPanel_filtrar1, BorderLayout.NORTH);
        } else {
            jPanel_mostrarTabla.remove(jPanel_filtrar1);
        }
        jPanel_mostrarTabla.revalidate();
        jPanel_mostrarTabla.repaint();
    }

    private void jButton_ordenarMouseClicked(java.awt.event.MouseEvent evt) {
        jTable_Content.setAutoCreateRowSorter(true);
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        int confirm = JOptionPane.showConfirmDialog(null, "¿Esta seguro de cerrar sesión?", "Cerrando sesión y ventana...", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (confirm == 0) {
            parentFrame = new Login();
            parentFrame.setVisible(true);
            parentFrame.requestFocus();
            this.dispose();
        }
        /* TODO por mover */
    }

    /* eventos de jPanel manipular paciente */
    private void jButton_modificar1MouseClicked(java.awt.event.MouseEvent evt) {
        boolean modificado = false;
        String nombreM = jTextField_nombre1.getText();
        String apellidoM = jTextField_apellido1.getText();
        String cedulaM = jTextField_cedula1.getText();
        String fechaNacimientoM = jTextField_fechaNacimiento1.getText();
        char sexoM = jComboBox_sexo1.getSelectedItem().toString().charAt(0);
        String distritoM = jComboBox_distrito1.getSelectedItem().toString();
        String direccionM = jTextField_direccion1.getText();
        String correoM = jTextField_correo1.getText();
        String telefonoM = jTextField_telefono1.getText();

        boolean condicion1 = nombreM.isBlank() || nombreM.equals("Ingrese el nombre");
        boolean condicion2 = apellidoM.isBlank() || apellidoM.equals("Ingrese el apellido");
        boolean condicion3 = cedulaM.isBlank() || cedulaM.equals("Ingrese la cédula");
        boolean condicion4 = fechaNacimientoM.isBlank() || fechaNacimientoM.equals("Ingrese la fecha de nacimiento YYYY-MM-DD hh:mm:ss");
        boolean condicion5 = sexoM == 'E';
        boolean condicionesObligatorias = !condicion1 && !condicion2 && !condicion3 && !condicion4 && !condicion5;
        boolean condicionOp2 = distritoM.equals("Elegir");
        boolean condicionOp3 = direccionM.isBlank() || direccionM.equals("Ingrese la dirección");
        boolean condicionOp4 = correoM.isBlank() || correoM.equals("Ingrese el correo electrónico");
        boolean condicionOp5 = telefonoM.isBlank() || telefonoM.equals("Ingrese el teléfono");

        boolean verificacion1 = !cedulaM.matches("^(PE|E|N|[23456789](?:AV|PI)?|1[0123]?(?:AV|PI)?)-(\\d{1,4})-(\\d{1,6})$");
        boolean verificacion2 = !fechaNacimientoM.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\\\d|3[01])$");
        boolean verificacion3 = !correoM.isBlank() && !correoM.equals("Ingrese el correo electrónico") && !correoM.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
        boolean verificacion4 = !condicionOp2 && !condicionOp3;

        errorMessage1.setVisible(false);

        if (condicionesObligatorias) {
            errorMessage1.setText("Error. Algunos campos son obligatorios*. Revisar");
            errorMessage1.setVisible(true);
            return;
        } else {
            if (verificacion1) {
                errorMessage1.setText("Error. La cédula no tiene el formato correcto.");
                errorMessage1.setVisible(true);
                return;
            } else if (verificacion2) {
                errorMessage1.setText("Error. La fecha de nacimiento no tiene el formato correcto. La fecha sin hora es obligatorio.");
                errorMessage1.setVisible(true);
                return;
            } else if (verificacion3) {
                errorMessage1.setText("Error. El correo electrónico no tiene el formato correcto.");
                errorMessage1.setVisible(true);
                return;
            } else if (verificacion4) {
                errorMessage1.setText("Error. La dirección o el distrito estan incompletos. Debe llenar ambos o ninguno.");
                errorMessage1.setVisible(true);
                return;
            } else {
                if (!condicionOp2 && !condicionOp3) {
                    if (!condicionOp4 && !condicionOp5) {
                        /* manipular todos los datos */
                    } else if (!condicionOp4) {
                        /* manipular todos los datos MENOS el teléfono */
                    } else {
                        /* manipular todos los datos y la dirección con su distrito */
                    }
                } else if (!condicionOp4) {
                    if (!condicionOp5) {
                        /* manipular todos los datos menos la dirección */
                    } else {
                        /* manipular todos los datos, adicional el correo */
                    }
                } else if (!condicionOp5) {
                    /* manipular los datos obligatorios y el teléfono */
                } else {
                    /* manipular solo los datos obligatorios */
                }
            }
        }

        if (modificado) {
            JOptionPane.showMessageDialog(null, "Esta información se procesará y puede tardar unos segyndos para mostrar en otras pestañas.", "Modificando datos de paciente...", JOptionPane.INFORMATION_MESSAGE);
        } else {
            errorMessage.setText("Error al modificar los datos del paciente.");
            errorMessage.setVisible(true);
        }
    }

    private void jTextField_telefono1ActionPerformed(java.awt.event.ActionEvent evt) {
        jButton_modificar1MouseClicked(null);
    }

    private void jTextField_telefono1FocusLost(java.awt.event.FocusEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField_telefono1FocusGained(java.awt.event.FocusEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField_correo1ActionPerformed(java.awt.event.ActionEvent evt) {
        jTextField_telefono1.requestFocus();
    }

    private void jTextField_correo1FocusLost(java.awt.event.FocusEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField_correo1FocusGained(java.awt.event.FocusEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField_direccion1ActionPerformed(java.awt.event.ActionEvent evt) {
        jTextField_correo1.requestFocus();
    }

    private void jTextField_direccion1FocusLost(java.awt.event.FocusEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField_direccion1FocusGained(java.awt.event.FocusEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField_fechaNacimiento1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jComboBox_sexo1.getSelectedIndex() <= 0) {
            jComboBox_sexo1.setSelectedIndex(3);
        }
        if (jComboBox_distrito1.getSelectedIndex() <= 0) {
            jComboBox_distrito1.setSelectedIndex(1);
        }
        jTextField_direccion.requestFocus();
    }

    private void jTextField_fechaNacimiento1FocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_fechaNacimiento1, "Ingrese la fecha de nacimiento YYYY-MM-DD* hh:mm:ss");
    }

    private void jTextField_fechaNacimiento1FocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_fechaNacimiento1, "Ingrese la fecha de nacimiento YYYY-MM-DD* hh:mm:ss");
    }

    private void jTextField_cedula1ActionPerformed(java.awt.event.ActionEvent evt) {
        jTextField_fechaNacimiento1.requestFocus();
    }

    private void jTextField_cedula1FocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_cedula1, "Ingrese la cédula");
    }

    private void jTextField_cedula1FocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_cedula1, "Ingrese la cédula");
    }

    private void jTextField_apellido1ActionPerformed(java.awt.event.ActionEvent evt) {
        jTextField_cedula1.requestFocus();
    }

    private void jTextField_apellido1FocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_apellido1, "Ingrese el apellido");
    }

    private void jTextField_apellido1FocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_apellido1, "Ingrese el apellido");
    }

    private void jTextField_nombre1ActionPerformed(java.awt.event.ActionEvent evt) {
        jTextField_apellido1.requestFocus();
    }

    private void jTextField_nombre1FocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_nombre1, "Ingrese el nombre");
    }

    private void jTextField_nombre1FocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_nombre1, "Ingrese el nombre");
    }

    private void jTextField_cedula2ActionPerformed(java.awt.event.ActionEvent evt) {
        jButton3MouseClicked(null);
    }

    private void jTextField_cedula2FocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_cedula2, "Ingrese cédula a buscar");
    }

    private void jTextField_cedula2FocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_cedula2, "Ingrese cédula a buscar");
    }

    /* eventos del menú lateral */
    private void button_logOutMouseClicked(java.awt.event.MouseEvent evt) {
        formWindowClosing(null);
    }

    private void button_soporteMouseClicked(java.awt.event.MouseEvent evt) {
        if (!jPanel_derecho.isAncestorOf(jPanel_soporte)) {
            jPanel_derecho.add(jPanel_soporte, "option 9");
        }
        if (mostrando == jPanel_soporte) {
            layout.show(jPanel_derecho, "vacio");
            mostrando = jPanel1;
        } else {
            layout.show(jPanel_derecho, "option 9");
            mostrando = jPanel_soporte;
        }
        jPanel_derecho.revalidate();
        jPanel_derecho.repaint();
    }

    private void button_preferenciasMouseClicked(java.awt.event.MouseEvent evt) {
        if (!jPanel_derecho.isAncestorOf(jPanel_preferencias)) {
            jPanel_derecho.add(jPanel_preferencias, "preferences");
        }
        if (mostrando == jPanel_preferencias) {
            layout.show(jPanel_derecho, "vacio");
            mostrando = jPanel1;
        } else {
            layout.show(jPanel_derecho, "preferences");
            mostrando = jPanel_preferencias;
        }
        jPanel_derecho.revalidate();
        jPanel_derecho.repaint();
    }

    private void button_modificarCredMouseClicked(java.awt.event.MouseEvent evt) {
        jDialog_modificarCred.setLocationRelativeTo(this);
        jDialog_modificarCred.setVisible(true);
    }

    private void button_modificarDatosMouseClicked(java.awt.event.MouseEvent evt) {
        jDialog_modificarDatos.setLocationRelativeTo(this);
        jDialog_modificarDatos.setVisible(true);
    }

    private void button_opcion8MouseClicked(java.awt.event.MouseEvent evt) {
        /* TODO impletar lógica de ver reporte y estadísticas por defecto en sede y día */
        if (!jPanel_derecho.isAncestorOf(jPanel_estadisticas)) {
            jPanel_derecho.add(jPanel_estadisticas, "option 8");
        }
        if (mostrando == jPanel_estadisticas) {
            layout.show(jPanel_derecho, "vacio");
            mostrando = jPanel1;
        } else {
            layout.show(jPanel_derecho, "option 8");
            mostrando = jPanel_estadisticas;
        }
        jPanel_derecho.revalidate();
        jPanel_derecho.repaint();
    }

    private void button_opcion7MouseClicked(java.awt.event.MouseEvent evt) {
        /* TODO implementar lógica de ver inventario sede preferida */
        if (!jPanel_derecho.isAncestorOf(jPanel_inventario)) {
            jPanel_derecho.add(jPanel_inventario, "option 7");
        }
        if (mostrando == jPanel_inventario) {
            layout.show(jPanel_derecho, "vacio");
            mostrando = jPanel1;
        } else {
            layout.show(jPanel_derecho, "option 7");
            mostrando = jPanel_inventario;
        }
        jPanel_derecho.revalidate();
        jPanel_derecho.repaint();
    }

    private void button_opcion6MouseClicked(java.awt.event.MouseEvent evt) {
        /* TODO implementar lógica de crear o editar a paciente siendo doctor */
        if (!jPanel_derecho.isAncestorOf(jPanel_manipularPaciente)) {
            jPanel_derecho.add(jPanel_manipularPaciente, "option 6");
        }
        if (mostrando == jPanel_manipularPaciente) {
            layout.show(jPanel_derecho, "vacio");
            mostrando = jPanel1;
        } else {
            layout.show(jPanel_derecho, "option 6");
            mostrando = jPanel_manipularPaciente;
        }
        jPanel_derecho.revalidate();
        jPanel_derecho.repaint();
    }

    private void button_opcion5MouseClicked(java.awt.event.MouseEvent evt) {
        /* TODO implementar lógica de pedir cita en una sede o doctor */
        if (!jPanel_derecho.isAncestorOf(jPanel_agendarCita)) {
            jPanel_derecho.add(jPanel_agendarCita, "option 5");
        }
        if (mostrando == jPanel_agendarCita) {
            layout.show(jPanel_derecho, "vacio");
            mostrando = jPanel1;
        } else {
            layout.show(jPanel_derecho, "option 5");
            mostrando = jPanel_agendarCita;
        }
        jPanel_derecho.revalidate();
        jPanel_derecho.repaint();
    }

    private void button_opcion4MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void button_opcion3MouseClicked(java.awt.event.MouseEvent evt) {
        /* TODO implementar el BUSCAR PACIENTE de doctor en sede preferida */
        if (!jPanel_derecho.isAncestorOf(jPanel_buscarDosis)) {
            jPanel_derecho.add(jPanel_buscarDosis, "option 3");
        }
        if (mostrando == jPanel_buscarDosis) {
            layout.show(jPanel_derecho, "vacio");
            mostrando = jPanel1;
        } else {
            layout.show(jPanel_derecho, "option 3");
            mostrando = jPanel_buscarDosis;
        }
        jPanel_derecho.revalidate();
        jPanel_derecho.repaint();
    }

    private void button_opcion2MouseClicked(java.awt.event.MouseEvent evt) {
        if (!jPanel_derecho.isAncestorOf(jPanel_buscarPaciente)) {
            jPanel_derecho.add(jPanel_buscarPaciente, "option 2");
        }
        if (mostrando == jPanel_buscarPaciente) {
            layout.show(jPanel_derecho, "vacio");
            mostrando = jPanel1;
        } else {
            layout.show(jPanel_derecho, "option 2");
            mostrando = jPanel_buscarPaciente;
        }
        jPanel_derecho.revalidate();
        jPanel_derecho.repaint();
    }

    private void button_opcion1MouseClicked(java.awt.event.MouseEvent evt) {
        /* TODO IMPLEMENTAR LÓGICA DE CONSULTAR MIS PACIENTES SEGÚN SEDE PREFERIDA */
        if (!jPanel_derecho.isAncestorOf(jPanel_mostrarTabla)) {
            jPanel_derecho.add(jPanel_mostrarTabla, "option 1");
        }
        if (mostrando == jPanel_mostrarTabla) {
            layout.show(jPanel_derecho, "vacio");
            mostrando = jPanel1;
        } else {
            layout.show(jPanel_derecho, "option 1");
            mostrando = jPanel_mostrarTabla;
        }
        jPanel_derecho.revalidate();
        jPanel_derecho.repaint();
    }

    /* eventos de jDialog modificar datos personales del usuario */
    private void jTextField_nombreFocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_nombre, "Ingrese su nombre");
    }

    private void jTextField_nombreFocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_nombre, "Ingrese su nombre");
    }

    private void jTextField_nombreActionPerformed(java.awt.event.ActionEvent evt) {
        jTextField_apellido.requestFocus();
    }

    private void jTextField_apellidoFocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_apellido, "Ingrese su apellido");
    }

    private void jTextField_apellidoFocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_apellido, "Ingrese su apellido");
    }

    private void jTextField_apellidoActionPerformed(java.awt.event.ActionEvent evt) {
        jTextField_cedula.requestFocus();
    }

    private void jTextField_cedulaActionPerformed(java.awt.event.ActionEvent evt) {
        jTextField_fechaNacimiento.requestFocus();
    }

    private void jTextField_fechaNacimientoActionPerformed(java.awt.event.ActionEvent evt) {
        jTextField_direccion.requestFocus();
    }

    private void jTextField_direccionFocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_direccion, "Ingrese su dirección");
    }

    private void jTextField_direccionFocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_direccion, "Ingrese su dirección");
    }

    private void jTextField_direccionActionPerformed(java.awt.event.ActionEvent evt) {
        if (jComboBox_distrito.getSelectedIndex() == 0) {
            jComboBox_distrito.setSelectedIndex(1);
        }
        jTextField_correo.requestFocus();
    }

    private void jTextField_correoFocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_correo, "Ingrese su correo electrónico");
    }

    private void jTextField_correoFocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_correo, "Ingrese su correo electrónico");
    }

    private void jTextField_correoActionPerformed(java.awt.event.ActionEvent evt) {
        jTextField_telefono.requestFocus();
    }

    private void jTextField_telefonoFocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_telefono, "Ingrese su teléfono");
    }

    private void jTextField_telefonoFocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_telefono, "Ingrese su teléfono");
    }

    private void jTextField_telefonoActionPerformed(java.awt.event.ActionEvent evt) {
        jButton_modificarMouseClicked(null);
    }

    private void jButton_cancelarMouseClicked(java.awt.event.MouseEvent evt) {
        jDialog_modificarDatos.dispose();
    }

    private void jButton_modificarMouseClicked(java.awt.event.MouseEvent evt) {
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
        boolean condicion4 = fechaNacimientoM.isBlank() || fechaNacimientoM.equals("Ingrese la fecha de nacimiento YYYY-MM-DD hh:mm:ss");
        boolean condicion5 = sexoM == 'E';
        boolean condicionesObligatorias = !condicion1 && !condicion2 && !condicion3 && !condicion4 && !condicion5;

        boolean condicionOp2 = distritoM.equals("Elegir");
        boolean condicionOp3 = direccionM.isBlank() || direccionM.equals("Ingrese la dirección");
        boolean condicionOp4 = correoM.isBlank() || correoM.equals("Ingrese el correo electrónico");
        boolean condicionOp5 = telefonoM.isBlank() || telefonoM.equals("Ingrese el teléfono");

        boolean verificacion1 = !cedulaM.matches("^(PE|E|N|[23456789](?:AV|PI)?|1[0123]?(?:AV|PI)?)-(\\d{1,4})-(\\d{1,6})$");
        boolean verificacion2 = !fechaNacimientoM.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\\\d|3[01])$");
        boolean verificacion3 = !correoM.isBlank() && !correoM.equals("Ingrese el correo electrónico") && !correoM.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
        boolean verificacion4 = !condicionOp2 && !condicionOp3;

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
                errorMessage.setText("Error. La fecha de nacimiento no tiene el formato correcto. La fecha sin hora es obligatorio.");
                errorMessage.setVisible(true);
                return;
            } else if (verificacion3) {
                errorMessage.setText("Error. El correo electrónico no tiene el formato correcto.");
                errorMessage.setVisible(true);
                return;
            } else if (verificacion4) {
                errorMessage.setText("Error. La dirección o el distrito estan incompletos. Debe llenar ambos o ninguno.");
                errorMessage.setVisible(true);
                return;
            } else {
                if (!condicionOp2 && !condicionOp3) {
                    if (!condicionOp4 && !condicionOp5) {
                        /* manipular todos los datos */
                    } else if (!condicionOp4) {
                        /* manipular todos los datos MENOS el teléfono */
                    } else {
                        /* manipular todos los datos y la dirección con su distrito */
                    }
                } else if (!condicionOp4) {
                    if (!condicionOp5) {
                        /* manipular todos los datos menos la dirección */
                    } else {
                        /* manipular todos los datos, adicional el correo */
                    }
                } else if (!condicionOp5) {
                    /* manipular los datos obligatorios y el teléfono */
                } else {
                    /* manipular solo los datos obligatorios */
                }
            }
        }

        if (modificado) {
            JOptionPane.showMessageDialog(null, "Esta información se procesará y puede tardar unos segyndos para mostrar en otras pestañas.", "Modificando datos de paciente...", JOptionPane.INFORMATION_MESSAGE);
        } else {
            errorMessage.setText("Error al modificar los datos del paciente.");
            errorMessage.setVisible(true);
        }
    }

    /* eventos de jPanel inventario */
    private void jTextField_buscarTabla3FocusGained(java.awt.event.FocusEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField_buscarTabla3FocusLost(java.awt.event.FocusEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField_buscarTabla3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton_buscar3MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton_acercar3MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton_alejar3MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton_ordenar3MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton_filtros3MouseClicked(java.awt.event.MouseEvent evt) {
        if (!jPanel_estadisticas.isAncestorOf(jPanel_filtrarEstadistica)) {
            jPanel_estadisticas.add(jPanel_filtrarEstadistica, BorderLayout.NORTH);
        } else {
            jPanel_estadisticas.remove(jPanel_filtrarEstadistica);
        }
        jPanel_estadisticas.revalidate();
        jPanel_estadisticas.repaint();
    }

    private void jButton_fuente3MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton_exportar3MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    /* eventos de jPanel reporte y estadísticas */
    private void jTextField_buscarTabla4FocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_buscarTabla4, "Buscar...");
    }

    private void jTextField_buscarTabla4FocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_buscarTabla4, "Buscar...");
    }

    private void jTextField_buscarTabla4ActionPerformed(java.awt.event.ActionEvent evt) {
        jButton_buscar4MouseClicked(null);
    }

    private void jButton_buscar4MouseClicked(java.awt.event.MouseEvent evt) {
        String patronBuscado = jTextField_buscarTabla4.getText();
        if (!patronBuscado.isBlank() || !patronBuscado.equals("Buscar...")) {
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTable_Content4.getModel());
            jTable_Content4.setRowSorter(sorter);
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + patronBuscado));
        } else {
            jTextField_buscarTabla4.setBorder(BorderFactory.createLineBorder(Color.red));
            jTextField_buscarTabla4.setForeground(Color.red);
        }
    }

    private void jButton_acercar4MouseClicked(java.awt.event.MouseEvent evt) {
        Font currentFont = jTable_Content4.getFont();
        jTable_Content4.setFont(currentFont.deriveFont(currentFont.getSize() + 2f));
    }

    private void jButton_alejar4MouseClicked(java.awt.event.MouseEvent evt) {
        Font currentFont = jTable_Content4.getFont();
        jTable_Content4.setFont(currentFont.deriveFont(currentFont.getSize() - 2f));
    }

    private void jButton_ordenar4MouseClicked(java.awt.event.MouseEvent evt) {
        jTable_Content4.setAutoCreateRowSorter(true);
    }

    private void jButton_filtros4MouseClicked(java.awt.event.MouseEvent evt) {
        if (!jPanel_estadisticas.isAncestorOf(jPanel_filtrarEstadistica)) {
            jPanel_estadisticas.add(jPanel_filtrarEstadistica, BorderLayout.NORTH);
        } else {
            jPanel_estadisticas.remove(jPanel_filtrarEstadistica);
        }
        jPanel_estadisticas.revalidate();
        jPanel_estadisticas.repaint();
    }

    private void jButton_fuente4MouseClicked(java.awt.event.MouseEvent evt) {
        JFontChooser fontChooser = new JFontChooser(this);
        boolean result = fontChooser.showDialog(this);
        if (result) {
            Font font = fontChooser.getSelectedFont();
            jTable_Content4.setFont(font);
            jTable_Content4.repaint();
        }
    }

    private void jButton_exportar4MouseClicked(java.awt.event.MouseEvent evt) {
        /* TODO llamada al método exportar en csv o excel o pdf del jPanel estadísticas */
    }

    /* eventos de jPanels filtrar. Guiarse de método filterActionPerformed(); */
    private void jComboBox_filterColumn1ActionPerformed(java.awt.event.ActionEvent evt) {
        /* TODO filtrar por fecha los reportes y estadísticas. opciones ya definidas */
    }

    private void jComboBox_filterColumn2ActionPerformed(java.awt.event.ActionEvent evt) {
        /* TODO filtrar por sede el inventario */
    }

    private void jComboBox_filterColumn3ActionPerformed(java.awt.event.ActionEvent evt) {
        /* TODO filtrar por vacuna el inventario */
    }

    /* eventos de jPanel buscar paciente */
    private void jButton_exportar1MouseClicked(java.awt.event.MouseEvent evt) {
        /* TODO llamada al método exportar en csv o excel o pdf del jPanel buscar Paciente */
    }

    private void jButton_fuente1MouseClicked(java.awt.event.MouseEvent evt) {
        JFontChooser fontChooser = new JFontChooser(this);
        boolean result = fontChooser.showDialog(this);
        if (result) {
            Font font = fontChooser.getSelectedFont();
            jTable_Content1.setFont(font);
            jTable_Content1.repaint();
        }
    }

    private void jButton_filtros1MouseClicked(java.awt.event.MouseEvent evt) {
        if (!jPanel_buscarPaciente.isAncestorOf(jPanel_filtrar2)) {
            jPanel_buscarPaciente.add(jPanel_filtrar2);
        } else {
            jPanel_buscarPaciente.remove(jPanel_filtrar2);
        }
        jPanel_buscarPaciente.revalidate();
        jPanel_buscarPaciente.repaint();
    }

    private void jButton_ordenar1MouseClicked(java.awt.event.MouseEvent evt) {
        jTable_Content1.setAutoCreateRowSorter(true);
    }

    private void jButton_alejar1MouseClicked(java.awt.event.MouseEvent evt) {
        Font currentFont = jTable_Content1.getFont();
        jTable_Content1.setFont(currentFont.deriveFont(currentFont.getSize() - 2f));
    }

    private void jButton_acercar1MouseClicked(java.awt.event.MouseEvent evt) {
        Font currentFont = jTable_Content1.getFont();
        jTable_Content1.setFont(currentFont.deriveFont(currentFont.getSize() + 2f));
    }

    private void jButton_buscar1MouseClicked(java.awt.event.MouseEvent evt) {
        String patronBuscado = jTextField_buscarTabla1.getText();
        if (!patronBuscado.isBlank() || !patronBuscado.equals("Buscar...")) {
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTable_Content1.getModel());
            jTable_Content1.setRowSorter(sorter);
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + patronBuscado));
        } else {
            jTextField_buscarTabla1.setBorder(BorderFactory.createLineBorder(Color.red));
            jTextField_buscarTabla1.setForeground(Color.red);
        }
    }

    private void jTextField_buscarTabla1ActionPerformed(java.awt.event.ActionEvent evt) {
        jButton_buscar1MouseClicked(null);
    }

    private void jTextField_buscarTabla1FocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_buscarTabla1, "Buscar...");
    }

    private void jTextField_buscarTabla1FocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_buscarTabla1, "Buscar...");
    }

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
        /* TODO implementar el BUSCAR PACIENTE para vacunar según el criterio del jComboBox1*/
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        jButton1MouseClicked(null);
    }

    private void jPanel_buscarPacienteAncestorAdded(javax.swing.event.AncestorEvent evt) {
        jTextField1.requestFocus();
    }

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField1, "Buscar paciente...");
    }

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField1, "Buscar paciente...");
    }

    /* eventos de jPanel buscar dosis de vacuna */
    private void jTextField3FocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField3, "Buscar por sede...");
    }

    private void jTextField3FocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField3, "Buscar por sede...");
    }

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {
        jTextField4.requestFocus();
    }

    private void jTextField_buscarTabla5FocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_buscarTabla5, "Buscar...");
    }

    private void jTextField_buscarTabla5FocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_buscarTabla5, "Buscar...");
    }

    private void jTextField_buscarTabla5ActionPerformed(java.awt.event.ActionEvent evt) {
        jButton_buscar5MouseClicked(null);
    }

    private void jButton_buscar5MouseClicked(java.awt.event.MouseEvent evt) {
        String patronBuscado = jTextField_buscarTabla5.getText();
        if (!patronBuscado.isBlank() || !patronBuscado.equals("Buscar...")) {
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTable_Content5.getModel());
            jTable_Content5.setRowSorter(sorter);
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + patronBuscado));
        } else {
            jTextField_buscarTabla5.setBorder(BorderFactory.createLineBorder(Color.red));
            jTextField_buscarTabla5.setForeground(Color.red);
        }
    }

    private void jButton_acercar5MouseClicked(java.awt.event.MouseEvent evt) {
        Font currentFont = jTable_Content5.getFont();
        jTable_Content5.setFont(currentFont.deriveFont(currentFont.getSize() + 2f));
    }

    private void jButton_alejar5MouseClicked(java.awt.event.MouseEvent evt) {
        Font currentFont = jTable_Content5.getFont();
        jTable_Content5.setFont(currentFont.deriveFont(currentFont.getSize() - 2f));
    }

    private void jButton_ordenar5MouseClicked(java.awt.event.MouseEvent evt) {
        jTable_Content5.setAutoCreateRowSorter(true);
    }

    private void jButton_filtros5MouseClicked(java.awt.event.MouseEvent evt) {
        if (!jPanel_buscarDosis.isAncestorOf(jPanel_filtrar3)) {
            jPanel_buscarDosis.add(jPanel_filtrar3);
        } else {
            jPanel_buscarDosis.remove(jPanel_filtrar3);
        }
        jPanel_buscarDosis.revalidate();
        jPanel_buscarDosis.repaint();
    }

    private void jButton_fuente5MouseClicked(java.awt.event.MouseEvent evt) {
        JFontChooser fontChooser = new JFontChooser(this);
        boolean result = fontChooser.showDialog(this);
        if (result) {
            Font font = fontChooser.getSelectedFont();
            jTable_Content5.setFont(font);
            jTable_Content5.repaint();
        }
    }

    private void jButton_exportar5MouseClicked(java.awt.event.MouseEvent evt) {
        /* TODO llamada al método exportar en csv o excel o pdf del jPanel buscar dosis */
    }

    private void jPanel_buscarDosisAncestorAdded(javax.swing.event.AncestorEvent evt) {
        jTextField3.requestFocus();
        /* evaluar si hacer focus al abrir el buscar dosis hacia sede u otro campo */
    }

    private void jTextField4FocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField4, "Buscar desde la fecha AAAA-MM-DD...");
    }

    private void jTextField4FocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField4, "Buscar desde la fecha AAAA-MM-DD...");
    }

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {
        jTextField5.requestFocus();
    }

    private void jTextField5FocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField5, "Buscar hasta la fecha AAAA-MM-DD...");
    }

    private void jTextField5FocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField5, "Buscar hasta la fecha AAAA-MM-DD...");
    }

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {
        jComboBox3.requestFocus();
    }

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {
        jButton2MouseClicked(null);
    }

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {
        /* TODO buscar dosis según varios criterios */
        String textField3 = jTextField3.getText();
        String textField4 = jTextField4.getText();
        String textField5 = jTextField5.getText();
        int comboBox3Index = jComboBox3.getSelectedIndex();
        int comboBox4Index = jComboBox4.getSelectedIndex();

        boolean condicion1 = textField3.isBlank() || textField3.equals("Buscar por sede...");
        boolean condicion2 = textField4.isBlank() || textField4.equals("Buscar desde la fecha AAAA-MM-DD...");
        boolean condicion3 = textField5.isBlank() || textField5.equals("Buscar hasta la fecha AAAA-MM-DD...");
        boolean condicion4 = comboBox3Index <= 0;
        boolean condicion5 = comboBox4Index <= 0;

        if (condicion1 && condicion2 && condicion3 && condicion4 && condicion5) {
            JOptionPane.showMessageDialog(null, "Error. Debe ingresar algún patrón de búsqueda para obtener resultados.", "Error al buscar dosis...", JOptionPane.ERROR_MESSAGE);
        } else {
            if (condicion2 && !condicion3) {
                JOptionPane.showMessageDialog(null, "Error: Falta la fecha de inicio.", "Error al buscar dosis...", JOptionPane.ERROR_MESSAGE);
            }
            if (!condicion2 && condicion3) {
                JOptionPane.showMessageDialog(null, "Error: Falta la fecha de fin.", "Error al buscar dosis...", JOptionPane.ERROR_MESSAGE);
            }
            if (!condicion1) {
                if (!condicion2 && !condicion3 && !condicion4 && !condicion5) {
                    /* buscar según todos los criterios */
                } else if (!condicion2 && !condicion3 && !condicion4) {
                    /* buscar según sede, fechas y vacuna */
                } else if (!condicion2 && !condicion3) {
                    /* buscar según sede y fechas */
                } else if (!condicion4 && !condicion5) {
                    /* buscar según sede, vacuna, número de dosis */
                } else if (!condicion4) {
                    /* buscar según sede y vacuna */
                } else if (!condicion5) {
                    /* buscar según sede y número de dosis */
                }
            } else if (!condicion2 && !condicion3) {
                if (!condicion4 && !condicion5) {
                    /* buscar según fechas, vacuna y número de dosis  */
                } else if (!condicion4) {
                    /* buscar según fechas y vacuna */
                } else if (!condicion5) {
                    /* buscar según fechas y número de dosis */
                }
            } else if (!condicion4) {
                if (!condicion5) {
                    /* buscar según vacuna y número de dosis */
                }
            } else if (!condicion5) {
                /* buscar según número de dosis */
            }
        }
    }

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {
        jComboBox4.requestFocus();
    }

    private void jButton_savePreferencesMouseClicked(java.awt.event.MouseEvent evt) {
        /* TODO implementar lógica de guardar preferencias del usuario*/
    }

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {
        /* TODO por mover a panel manipular usuarios */
        String cedulaB = jTextField_cedula2.getText();
        if (cedulaB.isBlank() || cedulaB.equals("Ingrese cédula a buscar")) {
            JOptionPane.showMessageDialog(null, "Error. Debe introducir la cédula del paciente para buscar y editar.", "Error al buscar un paciente...", JOptionPane.ERROR_MESSAGE);
        } else if (!cedulaB.matches("^(PE|E|N|[23456789](?:AV|PI)?|1[0123]?(?:AV|PI)?)-(\\d{1,4})-(\\d{1,6})$")) {
            JOptionPane.showMessageDialog(null, "Error. La cédula no tiene el formato correcto.", "Error al buscar un paciente...", JOptionPane.ERROR_MESSAGE);
        } else {
            /* TODO buscar paciente con sus credenciales */
            if (false) {
                /* mostrar información del usuario en los campos */
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron resultados de pacientes con dicha cédula. Debe crearlo o si es un error, puede buscar al paciente con otros parámetros en \'Buscar paciente\'.", "Error al buscar un paciente...", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void jTextField_usuario1FocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_usuario, "Ingrese su usuario");
    }

    private void jTextField_usuario1FocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_usuario, "Ingrese su usuario");
    }

    private void jTextField_usuario1ActionPerformed(java.awt.event.ActionEvent evt) {
        jTextField_usuarioNuevo.requestFocus();
    }

    private void jTextField_usuarioNuevoFocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_usuarioNuevo, "Ingrese un usuario nuevo");
    }

    private void jTextField_usuarioNuevoFocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_usuarioNuevo, "Ingrese un usuario nuevo");
    }

    private void jTextField_usuarioNuevoActionPerformed(java.awt.event.ActionEvent evt) {
        jPasswordField_vieja.requestFocus();
    }

    private void jPasswordField_nueva1FocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusPassword(jPasswordField_nueva1, "Ingrese su contraseña");
    }

    private void jPasswordField_nueva1FocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusPassword(jPasswordField_nueva1, "Ingrese su contraseña");
    }

    private void jPasswordField_nueva1ActionPerformed(java.awt.event.ActionEvent evt) {
        jPasswordField_nueva2.requestFocus();
    }

    private void jPasswordField_nueva2FocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusPassword(jPasswordField_nueva2, "Repita su contraseña");
    }

    private void jPasswordField_nueva2FocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusPassword(jPasswordField_nueva2, "Repita su contraseña");
    }

    private void jPasswordField_nueva2ActionPerformed(java.awt.event.ActionEvent evt) {
        jButton_modificar2MouseClicked(null);
    }

    private void jButton_modificar2MouseClicked(java.awt.event.MouseEvent evt) {
        boolean cambiado = false;
        String usuario = jTextField_usuario.getText();
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
        } else if (!InicioSesion.autentificar(usuario, String.valueOf(jPasswordField_vieja.getPassword()), "Paciente")) {
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
                        cambiado = InicioSesion.modificarCredenciales(cedulaUsuarioActual, usuarioNuevo, String.valueOf(jPasswordField_nueva1.getPassword()), "Paciente");
                    }
                } else {
                    cambiado = InicioSesion.modificarCredenciales(cedulaUsuarioActual, usuarioNuevo, String.valueOf(jPasswordField_vieja.getPassword()), "Paciente");
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
                    cambiado = InicioSesion.modificarCredenciales(cedulaUsuarioActual, usuario, String.valueOf(jPasswordField_nueva1.getPassword()), "Paciente");
                }
            } else {
                errorMessage2.setText("Error: ninguna credencial fue cambiada, debe modificar el usuario o la contraseña");
                errorMessage2.setVisible(true);
                return;
            }
        }

        if (cambiado) {
            JOptionPane.showMessageDialog(null, "Para confirmar los cambios de credenciales se cerrará el programa y debe iniciar sesión nuevamente.",
                    "Modificando datos...", JOptionPane.INFORMATION_MESSAGE);
            parentFrame.setVisible(true);
            parentFrame.requestFocus();
            this.dispose();
            jDialog_modificarCred.dispose();
            System.gc();
        } else {
            errorMessage2.setText("Error al modificar los datos personales. Intente nuevamente o cierre esta ventana.");
            errorMessage2.setVisible(true);
        }
    }

    private void jButton_cancelar2MouseClicked(java.awt.event.MouseEvent evt) {
        jDialog_modificarCred.dispose();
    }

    private void jPasswordField_viejaFocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusPassword(jPasswordField_vieja, "Ingrese su contraseña");
        /* TODO por mover al jDialog modificar credenciales del usuario */
    }

    private void jPasswordField_viejaFocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusPassword(jPasswordField_vieja, "Ingrese su contraseña");
        /* TODO por mover al jDialog modificar credenciales del usuario */
    }

    private void jPasswordField_viejaActionPerformed(java.awt.event.ActionEvent evt) {
        jPasswordField_nueva1.requestFocus();
        /* TODO por mover al jDialog modificar credenciales del usuario */
    }

    /* método para colocar el nombre al iniciar sesión */
    public void setBienvenida(String nombre, String cedula) {
        this.nombreBienvenida.setText(nombre);
        cedulaUsuarioActual = cedula;
    }

    /* método main para pruebas unitarias */
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PantallaDoctor(new Login()).setVisible(true);
            }
        });
    }

    /* variables propias */
    private static JFrame parentFrame;
    private static CardLayout layout = null;
    private Component mostrando = null;
    private JTableFiltrar jPanel_filtrar1;
    private JTableFiltrar jPanel_filtrar2;
    private JTableFiltrar jPanel_filtrar3;
    private String cedulaUsuarioActual;

    // Variables declaration - do not modify
    private javax.swing.JLabel apellido;
    private javax.swing.JLabel apellido1;
    private javax.swing.JPanel background;
    private javax.swing.JPanel background_dialog1;
    private javax.swing.JPanel background_dialog2;
    private javax.swing.JPanel background_dialog3;
    private javax.swing.JButton button_logOut;
    private javax.swing.JButton button_modificarCred;
    private javax.swing.JButton button_modificarDatos;
    private javax.swing.JButton button_opcion1;
    private javax.swing.JButton button_opcion2;
    private javax.swing.JButton button_opcion3;
    private javax.swing.JButton button_opcion4;
    private javax.swing.JButton button_opcion5;
    private javax.swing.JButton button_opcion6;
    private javax.swing.JButton button_opcion7;
    private javax.swing.JButton button_opcion8;
    private javax.swing.JButton button_preferencias;
    private javax.swing.JButton button_soporte;
    private javax.swing.JLabel cedula;
    private javax.swing.JLabel cedula1;
    private javax.swing.JLabel cedula2;
    private javax.swing.JLabel contrasena;
    private javax.swing.JLabel contrasena_anterior;
    private javax.swing.JLabel correo;
    private javax.swing.JLabel correo1;
    private javax.swing.JLabel direccion;
    private javax.swing.JLabel direccion1;
    private javax.swing.JLabel distrito;
    private javax.swing.JLabel distrito1;
    private javax.swing.JLabel errorMessage;
    private javax.swing.JLabel errorMessage1;
    private javax.swing.JLabel errorMessage2;
    private javax.swing.JLabel fecha_nacimiento;
    private javax.swing.JLabel fecha_nacimiento1;
    private javax.swing.JLabel icon_preferencias;
    private javax.swing.JLabel icon_project;
    private javax.swing.JTextArea indicaciones;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton_acercar;
    private javax.swing.JButton jButton_acercar1;
    private javax.swing.JButton jButton_acercar3;
    private javax.swing.JButton jButton_acercar4;
    private javax.swing.JButton jButton_acercar5;
    private javax.swing.JButton jButton_alejar;
    private javax.swing.JButton jButton_alejar1;
    private javax.swing.JButton jButton_alejar3;
    private javax.swing.JButton jButton_alejar4;
    private javax.swing.JButton jButton_alejar5;
    private javax.swing.JButton jButton_buscar;
    private javax.swing.JButton jButton_buscar1;
    private javax.swing.JButton jButton_buscar3;
    private javax.swing.JButton jButton_buscar4;
    private javax.swing.JButton jButton_buscar5;
    private javax.swing.JButton jButton_cancelar;
    private javax.swing.JButton jButton_cancelar2;
    private javax.swing.JButton jButton_exportar;
    private javax.swing.JButton jButton_exportar1;
    private javax.swing.JButton jButton_exportar3;
    private javax.swing.JButton jButton_exportar4;
    private javax.swing.JButton jButton_exportar5;
    private javax.swing.JButton jButton_filtros;
    private javax.swing.JButton jButton_filtros1;
    private javax.swing.JButton jButton_filtros3;
    private javax.swing.JButton jButton_filtros4;
    private javax.swing.JButton jButton_filtros5;
    private javax.swing.JButton jButton_fuente;
    private javax.swing.JButton jButton_fuente1;
    private javax.swing.JButton jButton_fuente3;
    private javax.swing.JButton jButton_fuente4;
    private javax.swing.JButton jButton_fuente5;
    private javax.swing.JButton jButton_modificar;
    private javax.swing.JButton jButton_modificar1;
    private javax.swing.JButton jButton_modificar2;
    private javax.swing.JButton jButton_ordenar;
    private javax.swing.JButton jButton_ordenar1;
    private javax.swing.JButton jButton_ordenar3;
    private javax.swing.JButton jButton_ordenar4;
    private javax.swing.JButton jButton_ordenar5;
    private javax.swing.JButton jButton_savePreferences;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox_distrito;
    private javax.swing.JComboBox<String> jComboBox_distrito1;
    private javax.swing.JComboBox<String> jComboBox_exportarType;
    private javax.swing.JComboBox<String> jComboBox_exportarType1;
    private javax.swing.JComboBox<String> jComboBox_filterColumn1;
    private javax.swing.JComboBox<String> jComboBox_filterColumn2;
    private javax.swing.JComboBox<String> jComboBox_filterColumn3;
    private javax.swing.JComboBox<String> jComboBox_sexo;
    private javax.swing.JComboBox<String> jComboBox_sexo1;
    private javax.swing.JDialog jDialog_modificarCred;
    private javax.swing.JDialog jDialog_modificarCred1;
    private javax.swing.JDialog jDialog_modificarDatos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel_agendarCita;
    private javax.swing.JPanel jPanel_buscarDosis;
    private javax.swing.JPanel jPanel_buscarPaciente;
    private javax.swing.JPanel jPanel_derecho;
    private javax.swing.JPanel jPanel_estadisticas;
    private javax.swing.JPanel jPanel_filtrarEstadistica;
    private javax.swing.JPanel jPanel_filtrarInventario;
    private javax.swing.JPanel jPanel_fontChooser;
    private javax.swing.JPanel jPanel_inventario;
    private javax.swing.JPanel jPanel_manipularPaciente;
    private javax.swing.JPanel jPanel_menuOpciones;
    private javax.swing.JPanel jPanel_mostrarTabla;
    private javax.swing.JPanel jPanel_preferencias;
    private javax.swing.JPanel jPanel_separador1;
    private javax.swing.JPanel jPanel_separador2;
    private javax.swing.JPanel jPanel_separador3;
    private javax.swing.JPanel jPanel_separador4;
    private javax.swing.JPanel jPanel_separador5;
    private javax.swing.JPanel jPanel_soporte;
    private javax.swing.JPasswordField jPasswordField_nueva1;
    private javax.swing.JPasswordField jPasswordField_nueva2;
    private javax.swing.JPasswordField jPasswordField_vieja;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane_Table;
    private javax.swing.JScrollPane jScrollPane_Table1;
    private javax.swing.JScrollPane jScrollPane_Table3;
    private javax.swing.JScrollPane jScrollPane_Table4;
    private javax.swing.JScrollPane jScrollPane_Table5;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator26;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable_Content;
    private javax.swing.JTable jTable_Content1;
    private javax.swing.JTable jTable_Content3;
    private javax.swing.JTable jTable_Content4;
    private javax.swing.JTable jTable_Content5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField_apellido;
    private javax.swing.JTextField jTextField_apellido1;
    private javax.swing.JTextField jTextField_buscarTabla;
    private javax.swing.JTextField jTextField_buscarTabla1;
    private javax.swing.JTextField jTextField_buscarTabla3;
    private javax.swing.JTextField jTextField_buscarTabla4;
    private javax.swing.JTextField jTextField_buscarTabla5;
    private javax.swing.JTextField jTextField_cedula;
    private javax.swing.JTextField jTextField_cedula1;
    private javax.swing.JTextField jTextField_cedula2;
    private javax.swing.JTextField jTextField_correo;
    private javax.swing.JTextField jTextField_correo1;
    private javax.swing.JTextField jTextField_direccion;
    private javax.swing.JTextField jTextField_direccion1;
    private javax.swing.JTextField jTextField_fechaNacimiento;
    private javax.swing.JTextField jTextField_fechaNacimiento1;
    private javax.swing.JTextField jTextField_nombre;
    private javax.swing.JTextField jTextField_nombre1;
    private javax.swing.JTextField jTextField_telefono;
    private javax.swing.JTextField jTextField_telefono1;
    private javax.swing.JTextField jTextField_usuario;
    private javax.swing.JTextField jTextField_usuario1;
    private javax.swing.JTextField jTextField_usuarioNuevo;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel nombre1;
    private javax.swing.JLabel nombreBienvenida;
    private javax.swing.JPanel opcionesTabla;
    private javax.swing.JPanel opcionesTabla1;
    private javax.swing.JPanel opcionesTabla3;
    private javax.swing.JPanel opcionesTabla4;
    private javax.swing.JPanel opcionesTabla5;
    private javax.swing.JLabel repetir_contrasena;
    private javax.swing.JLabel rolName;
    private javax.swing.JPanel separador1;
    private javax.swing.JPanel separador2;
    private javax.swing.JLabel sexo;
    private javax.swing.JLabel sexo1;
    private javax.swing.JLabel telefono;
    private javax.swing.JLabel telefono1;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel titulo1;
    private javax.swing.JLabel titulo2;
    private javax.swing.JLabel titulo3;
    private javax.swing.JLabel titulo4;
    private javax.swing.JLabel titulo_contenido;
    private javax.swing.JLabel titulo_contenido1;
    private javax.swing.JLabel titulo_contenido3;
    private javax.swing.JLabel titulo_contenido4;
    private javax.swing.JLabel titulo_contenido5;
    private javax.swing.JLabel usuario;
    private javax.swing.JLabel usuario1;
    private javax.swing.JLabel usuario_nuevo;
    // End of variables declaration
}
