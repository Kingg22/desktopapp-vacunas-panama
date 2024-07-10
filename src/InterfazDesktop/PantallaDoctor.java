package InterfazDesktop;

import Logica.Validations.*;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class PantallaDoctor extends JFrame {

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
        jPanel_mostrarTabla = new JPanel();
        titulo_contenido = new JLabel();
        jScrollPane_Table = new JScrollPane();
        jTable_Content = new JTable();
        opcionesTabla = new JPanel();
        jTextField_buscarTabla = new JTextField();
        jButton_buscar = new JButton();
        jButton_acercar = new JButton();
        jButton_alejar = new JButton();
        jButton_ordenar = new JButton();
        jButton_filtros = new JButton();
        jButton_fuente = new JButton();
        jButton_exportar = new JButton();
        jPanel_agendarCita = new JPanel();
        jLabel9 = new JLabel();
        jPanel_buscarPaciente = new JPanel();
        jPanel2 = new JPanel();
        titulo_contenido1 = new JLabel();
        jComboBox1 = new JComboBox<>();
        jTextField1 = new JTextField();
        jButton1 = new JButton();
        jScrollPane_Table1 = new JScrollPane();
        jTable_Content1 = new JTable();
        opcionesTabla1 = new JPanel();
        jTextField_buscarTabla1 = new JTextField();
        jButton_buscar1 = new JButton();
        jButton_acercar1 = new JButton();
        jButton_alejar1 = new JButton();
        jButton_ordenar1 = new JButton();
        jButton_filtros1 = new JButton();
        jButton_fuente1 = new JButton();
        jButton_exportar1 = new JButton();
        jPanel_manipularPaciente = new JPanel();
        titulo1 = new JLabel();
        jTextArea1 = new JTextArea();
        cedula2 = new JLabel();
        jTextField_cedula2 = new JTextField();
        jSeparator20 = new JSeparator();
        jButton3 = new JButton();
        nombre1 = new JLabel();
        jTextField_nombre1 = new JTextField();
        jSeparator13 = new JSeparator();
        apellido1 = new JLabel();
        jTextField_apellido1 = new JTextField();
        jSeparator14 = new JSeparator();
        cedula1 = new JLabel();
        jTextField_cedula1 = new JTextField();
        jSeparator15 = new JSeparator();
        fecha_nacimiento1 = new JLabel();
        jTextField_fechaNacimiento1 = new JTextField();
        jSeparator16 = new JSeparator();
        sexo1 = new JLabel();
        jComboBox_sexo1 = new JComboBox<>();
        jPanel3 = new JPanel();
        distrito1 = new JLabel();
        jComboBox_distrito1 = new JComboBox<>();
        jPanel4 = new JPanel();
        direccion1 = new JLabel();
        jTextField_direccion1 = new JTextField();
        jSeparator17 = new JSeparator();
        correo1 = new JLabel();
        jTextField_correo1 = new JTextField();
        jSeparator18 = new JSeparator();
        telefono1 = new JLabel();
        jTextField_telefono1 = new JTextField();
        jSeparator19 = new JSeparator();
        errorMessage1 = new JLabel();
        jButton_modificar1 = new JButton();
        jDialog_modificarDatos = new JDialog();
        jScrollPane1 = new JScrollPane();
        background_dialog1 = new JPanel();
        titulo = new JLabel();
        indicaciones = new JTextArea();
        nombre = new JLabel();
        jTextField_nombre = new JTextField();
        jSeparator3 = new JSeparator();
        apellido = new JLabel();
        jTextField_apellido = new JTextField();
        jSeparator4 = new JSeparator();
        cedula = new JLabel();
        jTextField_cedula = new JTextField();
        jSeparator5 = new JSeparator();
        fecha_nacimiento = new JLabel();
        jTextField_fechaNacimiento = new JTextField();
        jSeparator9 = new JSeparator();
        sexo = new JLabel();
        jComboBox_sexo = new JComboBox<>();
        direccion = new JLabel();
        jTextField_direccion = new JTextField();
        distrito = new JLabel();
        jComboBox_distrito = new JComboBox<>();
        jSeparator10 = new JSeparator();
        correo = new JLabel();
        jTextField_correo = new JTextField();
        jSeparator6 = new JSeparator();
        jTextField_telefono = new JTextField();
        telefono = new JLabel();
        jSeparator12 = new JSeparator();
        errorMessage = new JLabel();
        jButton_cancelar = new JButton();
        jButton_modificar = new JButton();
        jPanel_inventario = new JPanel();
        titulo_contenido3 = new JLabel();
        jScrollPane_Table3 = new JScrollPane();
        jTable_Content3 = new JTable();
        opcionesTabla3 = new JPanel();
        jTextField_buscarTabla3 = new JTextField();
        jButton_buscar3 = new JButton();
        jButton_acercar3 = new JButton();
        jButton_alejar3 = new JButton();
        jButton_ordenar3 = new JButton();
        jButton_filtros3 = new JButton();
        jButton_fuente3 = new JButton();
        jButton_exportar3 = new JButton();
        jPanel_estadisticas = new JPanel();
        titulo_contenido4 = new JLabel();
        jScrollPane_Table4 = new JScrollPane();
        jTable_Content4 = new JTable();
        opcionesTabla4 = new JPanel();
        jTextField_buscarTabla4 = new JTextField();
        jButton_buscar4 = new JButton();
        jButton_acercar4 = new JButton();
        jButton_alejar4 = new JButton();
        jButton_ordenar4 = new JButton();
        jButton_filtros4 = new JButton();
        jButton_fuente4 = new JButton();
        jButton_exportar4 = new JButton();
        jPanel_filtrarEstadistica = new JPanel();
        jSeparator22 = new JSeparator();
        jSeparator23 = new JSeparator();
        jLabel7 = new JLabel();
        jComboBox_filterColumn1 = new JComboBox<>();
        jPanel_soporte = new JPanel();
        jLabel10 = new JLabel();
        jPanel5 = new JPanel();
        jLabel11 = new JLabel();
        jPanel_filtrarInventario = new JPanel();
        jSeparator24 = new JSeparator();
        jSeparator25 = new JSeparator();
        jLabel8 = new JLabel();
        jComboBox_filterColumn2 = new JComboBox<>();
        jLabel12 = new JLabel();
        jComboBox_filterColumn3 = new JComboBox<>();
        jPanel_buscarDosis = new JPanel();
        jPanel7 = new JPanel();
        titulo_contenido5 = new JLabel();
        jPanel6 = new JPanel();
        jLabel13 = new JLabel();
        jTextField3 = new JTextField();
        jLabel14 = new JLabel();
        jTextField4 = new JTextField();
        jLabel15 = new JLabel();
        jTextField5 = new JTextField();
        jLabel16 = new JLabel();
        jComboBox3 = new JComboBox<>();
        jLabel17 = new JLabel();
        jComboBox4 = new JComboBox<>();
        jButton2 = new JButton();
        jScrollPane_Table5 = new JScrollPane();
        jTable_Content5 = new JTable();
        opcionesTabla5 = new JPanel();
        jTextField_buscarTabla5 = new JTextField();
        jButton_buscar5 = new JButton();
        jButton_acercar5 = new JButton();
        jButton_alejar5 = new JButton();
        jButton_ordenar5 = new JButton();
        jButton_filtros5 = new JButton();
        jButton_fuente5 = new JButton();
        jButton_exportar5 = new JButton();
        jPanel_preferencias = new JPanel();
        icon_preferencias = new JLabel();
        titulo3 = new JLabel();
        jPanel_separador1 = new JPanel();
        jLabel4 = new JLabel();
        jPanel_separador2 = new JPanel();
        jPanel_fontChooser = new JPanel();
        jPanel_separador3 = new JPanel();
        jLabel1 = new JLabel();
        jComboBox_exportarType = new JComboBox<>();
        jPanel_separador4 = new JPanel();
        jLabel5 = new JLabel();
        jComboBox_exportarType1 = new JComboBox<>();
        jPanel_separador5 = new JPanel();
        jButton_savePreferences = new JButton();
        jDialog_modificarCred = new JDialog();
        jScrollPane4 = new JScrollPane();
        background_dialog3 = new JPanel();
        titulo4 = new JLabel();
        jTextArea4 = new JTextArea();
        usuario1 = new JLabel();
        jTextField_usuario1 = new JTextField();
        jSeparator8 = new JSeparator();
        usuario_nuevo = new JLabel();
        jTextField_usuarioNuevo = new JTextField();
        jSeparator21 = new JSeparator();
        contrasena = new JLabel();
        jPasswordField_nueva1 = new JPasswordField();
        jSeparator11 = new JSeparator();
        repetir_contrasena = new JLabel();
        jPasswordField_nueva2 = new JPasswordField();
        jSeparator7 = new JSeparator();
        errorMessage2 = new JLabel();
        jButton_modificar2 = new JButton();
        jButton_cancelar2 = new JButton();
        contrasena_anterior = new JLabel();
        jPasswordField_vieja = new JPasswordField();
        jSeparator26 = new JSeparator();
        jScrollPane3 = new JScrollPane();
        background = new JPanel();
        jPanel_menuOpciones = new JPanel();
        separador1 = new JPanel();
        icon_project = new JLabel();
        rolName = new JLabel();
        nombreBienvenida = new JLabel();
        button_opcion1 = new JButton();
        button_opcion2 = new JButton();
        button_opcion3 = new JButton();
        button_opcion4 = new JButton();
        button_opcion5 = new JButton();
        button_opcion6 = new JButton();
        button_opcion7 = new JButton();
        button_opcion8 = new JButton();
        separador2 = new JPanel();
        button_modificarDatos = new JButton();
        button_modificarCred = new JButton();
        button_preferencias = new JButton();
        button_soporte = new JButton();
        button_logOut = new JButton();
        jPanel_derecho = new JPanel();
        jPanel1 = new JPanel();
        jLabel6 = new JLabel();

        jPanel_mostrarTabla.setBackground(new Color(227, 218, 201));
        jPanel_mostrarTabla.setForeground(new Color(227, 218, 201));
        jPanel_mostrarTabla.setPreferredSize(new Dimension(794, 794));
        jPanel_mostrarTabla.setLayout(new BorderLayout());

        titulo_contenido.setBackground(new Color(255, 255, 255));
        titulo_contenido.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 14));
        titulo_contenido.setHorizontalAlignment(SwingConstants.CENTER);
        titulo_contenido.setText("Resultados Obtenidos de mis pacientes");
        titulo_contenido.setHorizontalTextPosition(SwingConstants.CENTER);
        titulo_contenido.setOpaque(true);
        titulo_contenido.setPreferredSize(new Dimension(794, 17));
        jPanel_mostrarTabla.add(titulo_contenido, BorderLayout.NORTH);

        jScrollPane_Table.setBackground(new Color(227, 218, 201));
        jScrollPane_Table.setForeground(new Color(227, 218, 201));
        jScrollPane_Table.setOpaque(true);
        jScrollPane_Table.setPreferredSize(new Dimension(794, 727));
        jScrollPane_Table.setViewportView(null);

        jTable_Content.setBackground(new Color(227, 218, 201));
        jTable_Content.setFont(new Font("Roboto", Font.PLAIN, 12));
        jTable_Content.setForeground(new Color(227, 218, 201));
        jTable_Content.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        jTable_Content.setMinimumSize(new Dimension(50, 50));
        jTable_Content.setPreferredSize(new Dimension(788, 721));
        jTable_Content.setShowGrid(true);
        jScrollPane_Table.setViewportView(jTable_Content);
        jTable_Content.getAccessibleContext().setAccessibleName("tabla de resultados");

        jPanel_mostrarTabla.add(jScrollPane_Table, BorderLayout.CENTER);

        opcionesTabla.setBackground(new Color(0, 153, 204));
        opcionesTabla.setMinimumSize(new Dimension(794, 47));
        opcionesTabla.setPreferredSize(new Dimension(794, 50));
        opcionesTabla.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        jTextField_buscarTabla.setDocument(new LimitarCamposSeguro(25, "Buscar...")
        );
        jTextField_buscarTabla.setText("Buscar...");
        jTextField_buscarTabla.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jTextField_buscarTabla.setPreferredSize(new Dimension(125, 26));
        jTextField_buscarTabla.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                jTextField_buscarTablaFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                jTextField_buscarTablaFocusLost(evt);
            }
        });
        jTextField_buscarTabla.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField_buscarTablaActionPerformed(evt);
            }
        });
        opcionesTabla.add(jTextField_buscarTabla);

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

        jPanel_mostrarTabla.add(opcionesTabla, BorderLayout.SOUTH);

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

        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[]{"Cédula", "Nombre completo", "Fecha de nacimiento"}));
        jComboBox1.setPreferredSize(new Dimension(150, 26));
        jPanel2.add(jComboBox1, BorderLayout.WEST);

        jTextField1.setDocument(new LimitarCamposSeguro(50, "Buscar paciente..."));
        jTextField1.setText("Buscar paciente...");
        RegistrarUser.handleFocusGain(jTextField1, "Buscar paciente...");
        jTextField1.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                jTextField1FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1, BorderLayout.CENTER);

        jButton1.setIcon(new ImageIcon(getClass().getResource("/images/lupa_icon.png")));
        jButton1.setPreferredSize(new Dimension(30, 30));
        jButton1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel2.add(jButton1, BorderLayout.EAST);

        jPanel_buscarPaciente.add(jPanel2);

        jScrollPane_Table1.setBackground(new Color(227, 218, 201));
        jScrollPane_Table1.setForeground(new Color(227, 218, 201));
        jScrollPane_Table1.setOpaque(true);
        jScrollPane_Table1.setPreferredSize(new Dimension(794, 705));
        jScrollPane_Table1.setViewportView(null);

        jTable_Content1.setBackground(new Color(227, 218, 201));
        jTable_Content1.setFont(new Font("Roboto", Font.PLAIN, 12));
        jTable_Content1.setForeground(new Color(227, 218, 201));
        jTable_Content1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        jTable_Content1.setMinimumSize(new Dimension(50, 50));
        jTable_Content1.setPreferredSize(new Dimension(788, 699));
        jTable_Content1.setShowGrid(true);
        jScrollPane_Table1.setViewportView(jTable_Content1);

        jPanel_buscarPaciente.add(jScrollPane_Table1);

        opcionesTabla1.setBackground(new Color(0, 153, 204));
        opcionesTabla1.setMaximumSize(new Dimension(32767, 100));
        opcionesTabla1.setPreferredSize(new Dimension(794, 44));
        opcionesTabla1.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        jTextField_buscarTabla1.setDocument(new LimitarCamposSeguro(25, "Buscar...")
        );
        jTextField_buscarTabla1.setText("Buscar...");
        jTextField_buscarTabla1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jTextField_buscarTabla1.setPreferredSize(new Dimension(125, 26));
        jTextField_buscarTabla1.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                jTextField_buscarTabla1FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                jTextField_buscarTabla1FocusLost(evt);
            }
        });
        jTextField_buscarTabla1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField_buscarTabla1ActionPerformed(evt);
            }
        });
        opcionesTabla1.add(jTextField_buscarTabla1);

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
        jPanel_manipularPaciente.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 100));
        jPanel_manipularPaciente.setPreferredSize(new Dimension(794, 794));
        jPanel_manipularPaciente.setLayout(new GridLayout(35, 1));

        titulo1.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
        titulo1.setForeground(new Color(0, 0, 0));
        titulo1.setHorizontalAlignment(SwingConstants.CENTER);
        titulo1.setText("Crear o Editar paciente");
        jPanel_manipularPaciente.add(titulo1);

        jTextArea1.setBackground(new Color(227, 218, 201));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new Font("Microsoft YaHei", Font.ITALIC, 11));
        jTextArea1.setForeground(new Color(102, 102, 102));
        jTextArea1.setRows(5);
        jTextArea1.setText("Indicaciones: Si desea editar paciente utilizar el campo 'Buscar cédula a editar' , dar click en el botón buscar, si no desea modificar todo, puede dejarlo como esta. Si desea crear paciente. Utilizar directamente los campos debajo del botón 'Buscar paciente a editar...', los campos con * son obligatorios.\n");
        jTextArea1.setBorder(null);
        jTextArea1.setMinimumSize(new Dimension(616, 55));
        jTextArea1.setPreferredSize(new Dimension(628, 55));
        jTextArea1.setLineWrap(true);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setEditable(false);
        jPanel_manipularPaciente.add(jTextArea1);

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
        jTextField_cedula2.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                jTextField_cedula2FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                jTextField_cedula2FocusLost(evt);
            }
        });
        jTextField_cedula2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField_cedula2ActionPerformed(evt);
            }
        });
        jPanel_manipularPaciente.add(jTextField_cedula2);

        jSeparator20.setBackground(new Color(0, 0, 0));
        jSeparator20.setForeground(new Color(30, 30, 30));
        jPanel_manipularPaciente.add(jSeparator20);

        jButton3.setText("Buscar paciente a editar...");
        jButton3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel_manipularPaciente.add(jButton3);

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
        jTextField_nombre1.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                jTextField_nombre1FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                jTextField_nombre1FocusLost(evt);
            }
        });
        jTextField_nombre1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField_nombre1ActionPerformed(evt);
            }
        });
        jPanel_manipularPaciente.add(jTextField_nombre1);

        jSeparator13.setBackground(new Color(0, 0, 0));
        jSeparator13.setForeground(new Color(30, 30, 30));
        jPanel_manipularPaciente.add(jSeparator13);

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
        jTextField_apellido1.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                jTextField_apellido1FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                jTextField_apellido1FocusLost(evt);
            }
        });
        jTextField_apellido1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField_apellido1ActionPerformed(evt);
            }
        });
        jPanel_manipularPaciente.add(jTextField_apellido1);

        jSeparator14.setBackground(new Color(0, 0, 0));
        jSeparator14.setForeground(new Color(30, 30, 30));
        jPanel_manipularPaciente.add(jSeparator14);

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
        jTextField_cedula1.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                jTextField_cedula1FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                jTextField_cedula1FocusLost(evt);
            }
        });
        jTextField_cedula1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField_cedula1ActionPerformed(evt);
            }
        });
        jPanel_manipularPaciente.add(jTextField_cedula1);

        jSeparator15.setBackground(new Color(0, 0, 0));
        jSeparator15.setForeground(new Color(30, 30, 30));
        jPanel_manipularPaciente.add(jSeparator15);

        fecha_nacimiento1.setBackground(new Color(0, 0, 0));
        fecha_nacimiento1.setFont(new Font("Roboto", Font.PLAIN, 12));
        fecha_nacimiento1.setForeground(new Color(0, 0, 0));
        fecha_nacimiento1.setText("Fecha de nacimiento *");
        jPanel_manipularPaciente.add(fecha_nacimiento1);

        jTextField_fechaNacimiento1.setBackground(new Color(227, 218, 201));
        jTextField_fechaNacimiento1.setDocument(new LimitarCamposFecha(19, "Ingrese la fecha de nacimiento YYYY-MM-DD* hh:mm:ss"));
        jTextField_fechaNacimiento1.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_fechaNacimiento1.setForeground(Color.gray);
        jTextField_fechaNacimiento1.setBorder(null);
        jTextField_fechaNacimiento1.setText("Ingrese la fecha de nacimiento YYYY-MM-DD* hh:mm:ss");
        jTextField_fechaNacimiento1.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_fechaNacimiento1, "Ingrese la fecha de nacimiento YYYY-MM-DD* hh:mm:ss");
        jTextField_fechaNacimiento1.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                jTextField_fechaNacimiento1FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                jTextField_fechaNacimiento1FocusLost(evt);
            }
        });
        jTextField_fechaNacimiento1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField_fechaNacimiento1ActionPerformed(evt);
            }
        });
        jPanel_manipularPaciente.add(jTextField_fechaNacimiento1);

        jSeparator16.setBackground(new Color(0, 0, 0));
        jSeparator16.setForeground(new Color(30, 30, 30));
        jPanel_manipularPaciente.add(jSeparator16);

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

        jPanel3.setBackground(new Color(227, 218, 201));
        jPanel3.setPreferredSize(new Dimension(0, 3));

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 616, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 55, Short.MAX_VALUE)
        );

        jPanel_manipularPaciente.add(jPanel3);

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

        jPanel4.setBackground(new Color(227, 218, 201));
        jPanel4.setPreferredSize(new Dimension(0, 3));

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 616, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 55, Short.MAX_VALUE)
        );

        jPanel_manipularPaciente.add(jPanel4);

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
        jTextField_direccion1.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                jTextField_direccion1FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                jTextField_direccion1FocusLost(evt);
            }
        });
        jTextField_direccion1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField_direccion1ActionPerformed(evt);
            }
        });
        jPanel_manipularPaciente.add(jTextField_direccion1);

        jSeparator17.setBackground(new Color(0, 0, 0));
        jSeparator17.setForeground(new Color(30, 30, 30));
        jPanel_manipularPaciente.add(jSeparator17);

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
        jTextField_correo1.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                jTextField_correo1FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                jTextField_correo1FocusLost(evt);
            }
        });
        jTextField_correo1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField_correo1ActionPerformed(evt);
            }
        });
        jPanel_manipularPaciente.add(jTextField_correo1);

        jSeparator18.setBackground(new Color(0, 0, 0));
        jSeparator18.setForeground(new Color(30, 30, 30));
        jPanel_manipularPaciente.add(jSeparator18);

        telefono1.setBackground(new Color(0, 0, 0));
        telefono1.setFont(new Font("Roboto", Font.PLAIN, 12));
        telefono1.setForeground(new Color(0, 0, 0));
        telefono1.setText("Teléfono ");
        jPanel_manipularPaciente.add(telefono1);

        jTextField_telefono1.setBackground(new Color(227, 218, 201));
        jTextField_telefono1.setDocument(new LimitarCamposPhone(15, "Ingrese su teléfono (código de país, el código de ciudad y el número de teléfono local) no se acepta + al principio"));
        jTextField_telefono1.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_telefono1.setForeground(Color.gray);
        jTextField_telefono1.setText("Ingrese su teléfono (código de país, el código de ciudad y el número de teléfono local) no se acepta + al principio");
        jTextField_telefono1.setBorder(null);
        jTextField_telefono1.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_telefono1, "Ingrese su teléfono (código de país, el código de ciudad y el número de teléfono local) no se acepta + al principio");
        jTextField_telefono1.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                jTextField_telefono1FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                jTextField_telefono1FocusLost(evt);
            }
        });
        jTextField_telefono1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField_telefono1ActionPerformed(evt);
            }
        });
        jPanel_manipularPaciente.add(jTextField_telefono1);

        jSeparator19.setBackground(new Color(0, 0, 0));
        jSeparator19.setForeground(new Color(30, 30, 30));
        jPanel_manipularPaciente.add(jSeparator19);

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
        jDialog_modificarDatos.setSize(new Dimension(450, 600));

        jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        background_dialog1.setBackground(new Color(255, 255, 255));
        background_dialog1.setPreferredSize(new Dimension(444, 544));
        background_dialog1.setLayout(new AbsoluteLayout());

        titulo.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
        titulo.setForeground(new Color(0, 0, 0));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setText("Modificar datos personales");
        background_dialog1.add(titulo, new AbsoluteConstraints(90, 20, 269, -1));

        indicaciones.setEditable(false);
        indicaciones.setBackground(new Color(255, 255, 255));
        indicaciones.setFont(new Font("Microsoft YaHei", Font.ITALIC, 11));
        indicaciones.setForeground(new Color(102, 102, 102));
        indicaciones.setLineWrap(true);
        indicaciones.setRows(5);
        indicaciones.setText("Indicaciones: Si no desea modificar todo, puede dejarlo en blanco o como esta. Si su cédula o fecha de nacimiento esta errónea, solicita ayuda a su doctor.\n\n");
        indicaciones.setWrapStyleWord(true);
        indicaciones.setBorder(null);
        indicaciones.setFocusable(false);
        indicaciones.setRequestFocusEnabled(false);
        background_dialog1.add(indicaciones, new AbsoluteConstraints(30, 40, 390, 50));

        nombre.setBackground(new Color(0, 0, 0));
        nombre.setFont(new Font("Roboto", Font.PLAIN, 12));
        nombre.setForeground(new Color(0, 0, 0));
        nombre.setText("Nombre *");
        background_dialog1.add(nombre, new AbsoluteConstraints(30, 90, -1, -1));

        jTextField_nombre.setBackground(new Color(255, 255, 255));
        jTextField_nombre.setDocument(new LimitarCamposString(50, "Ingrese su nombre"));
        jTextField_nombre.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_nombre.setForeground(Color.gray);
        jTextField_nombre.setText("Ingrese su nombre");
        jTextField_nombre.setBorder(null);
        jTextField_nombre.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_nombre, "Ingrese su nombre");
        jTextField_nombre.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                jTextField_nombreFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                jTextField_nombreFocusLost(evt);
            }
        });
        jTextField_nombre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField_nombreActionPerformed(evt);
            }
        });
        background_dialog1.add(jTextField_nombre, new AbsoluteConstraints(30, 110, 390, -1));

        jSeparator3.setForeground(new Color(30, 30, 30));
        background_dialog1.add(jSeparator3, new AbsoluteConstraints(30, 130, 390, 21));

        apellido.setBackground(new Color(0, 0, 0));
        apellido.setFont(new Font("Roboto", Font.PLAIN, 12));
        apellido.setForeground(new Color(0, 0, 0));
        apellido.setText("Apellido *");
        background_dialog1.add(apellido, new AbsoluteConstraints(30, 140, -1, -1));

        jTextField_apellido.setBackground(new Color(255, 255, 255));
        jTextField_apellido.setDocument(new LimitarCamposString(50, "Ingrese su apellido"));
        jTextField_apellido.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_apellido.setForeground(Color.gray);
        jTextField_apellido.setText("Ingrese su apellido");
        jTextField_apellido.setBorder(null);
        jTextField_apellido.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_apellido, "Ingrese su apellido");
        jTextField_apellido.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                jTextField_apellidoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                jTextField_apellidoFocusLost(evt);
            }
        });
        jTextField_apellido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField_apellidoActionPerformed(evt);
            }
        });
        background_dialog1.add(jTextField_apellido, new AbsoluteConstraints(30, 160, 390, -1));

        jSeparator4.setForeground(new Color(30, 30, 30));
        background_dialog1.add(jSeparator4, new AbsoluteConstraints(30, 180, 390, 21));

        cedula.setBackground(new Color(0, 0, 0));
        cedula.setFont(new Font("Roboto", Font.PLAIN, 12));
        cedula.setForeground(new Color(0, 0, 0));
        cedula.setText("Cédula *");
        background_dialog1.add(cedula, new AbsoluteConstraints(30, 190, -1, -1));

        jTextField_cedula.setEditable(false);
        jTextField_cedula.setBackground(new Color(255, 255, 255));
        jTextField_cedula.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_cedula.setForeground(Color.gray);
        jTextField_cedula.setText("Ingrese su cédula");
        jTextField_cedula.setBorder(null);
        jTextField_cedula.setMaximumSize(new Dimension(2147483647, 50));
        jTextField_cedula.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField_cedulaActionPerformed(evt);
            }
        });
        background_dialog1.add(jTextField_cedula, new AbsoluteConstraints(30, 210, 390, -1));

        jSeparator5.setForeground(new Color(30, 30, 30));
        background_dialog1.add(jSeparator5, new AbsoluteConstraints(30, 230, 390, 21));

        fecha_nacimiento.setBackground(new Color(0, 0, 0));
        fecha_nacimiento.setFont(new Font("Roboto", Font.PLAIN, 12));
        fecha_nacimiento.setForeground(new Color(0, 0, 0));
        fecha_nacimiento.setText("Fecha de nacimiento *");
        background_dialog1.add(fecha_nacimiento, new AbsoluteConstraints(30, 240, -1, -1));

        jTextField_fechaNacimiento.setEditable(false);
        jTextField_fechaNacimiento.setBackground(new Color(255, 255, 255));
        jTextField_fechaNacimiento.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_fechaNacimiento.setForeground(Color.gray);
        jTextField_fechaNacimiento.setText("Ingrese su fecha de nacimiento YYYY-MM-DD* hh:mm:ss");
        jTextField_fechaNacimiento.setBorder(null);
        jTextField_fechaNacimiento.setMaximumSize(new Dimension(2147483647, 50));
        jTextField_fechaNacimiento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField_fechaNacimientoActionPerformed(evt);
            }
        });
        background_dialog1.add(jTextField_fechaNacimiento, new AbsoluteConstraints(30, 260, 390, -1));

        jSeparator9.setForeground(new Color(30, 30, 30));
        background_dialog1.add(jSeparator9, new AbsoluteConstraints(30, 280, 390, 21));

        sexo.setBackground(new Color(0, 0, 0));
        sexo.setFont(new Font("Roboto", Font.PLAIN, 12));
        sexo.setForeground(new Color(0, 0, 0));
        sexo.setText("Sexo *");
        background_dialog1.add(sexo, new AbsoluteConstraints(30, 290, -1, -1));

        jComboBox_sexo.setBackground(Color.gray);
        jComboBox_sexo.setFont(new Font("Roboto", Font.PLAIN, 14));
        jComboBox_sexo.setForeground(Color.black);
        jComboBox_sexo.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir", "Masculino", "Feminino"}));
        background_dialog1.add(jComboBox_sexo, new AbsoluteConstraints(30, 308, 170, -1));

        direccion.setBackground(new Color(0, 0, 0));
        direccion.setFont(new Font("Roboto", Font.PLAIN, 12));
        direccion.setForeground(new Color(0, 0, 0));
        direccion.setText("Dirección");
        background_dialog1.add(direccion, new AbsoluteConstraints(30, 340, -1, -1));

        jTextField_direccion.setBackground(new Color(255, 255, 255));
        jTextField_direccion.setDocument(new LimitarCamposAlpha(100, "Ingrese su dirección"));
        jTextField_direccion.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_direccion.setForeground(Color.gray);
        jTextField_direccion.setText("Ingrese su dirección");
        jTextField_direccion.setBorder(null);
        jTextField_direccion.setMaximumSize(new Dimension(2147483647, 50));
        jTextField_direccion.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                jTextField_direccionFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                jTextField_direccionFocusLost(evt);
            }
        });
        jTextField_direccion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField_direccionActionPerformed(evt);
            }
        });
        background_dialog1.add(jTextField_direccion, new AbsoluteConstraints(30, 360, 190, -1));

        distrito.setBackground(new Color(0, 0, 0));
        distrito.setFont(new Font("Roboto", Font.PLAIN, 12));
        distrito.setForeground(new Color(0, 0, 0));
        distrito.setText("Distrito");
        background_dialog1.add(distrito, new AbsoluteConstraints(230, 340, 50, -1));

        jComboBox_distrito.setBackground(Color.gray);
        jComboBox_distrito.setFont(new Font("Roboto", Font.PLAIN, 14));
        jComboBox_distrito.setForeground(Color.black);
        jComboBox_distrito.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir", "Distrito por registrar"}));
        background_dialog1.add(jComboBox_distrito, new AbsoluteConstraints(230, 356, 190, -1));

        jSeparator10.setForeground(new Color(30, 30, 30));
        background_dialog1.add(jSeparator10, new AbsoluteConstraints(30, 380, 190, 21));

        correo.setBackground(new Color(0, 0, 0));
        correo.setFont(new Font("Roboto", Font.PLAIN, 12));
        correo.setForeground(new Color(0, 0, 0));
        correo.setText("Correo electrónico");
        background_dialog1.add(correo, new AbsoluteConstraints(30, 390, -1, -1));

        jTextField_correo.setBackground(new Color(255, 255, 255));
        jTextField_correo.setDocument(new LimitarCamposEmail(50, "Ingrese su correo electrónico"));
        jTextField_correo.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_correo.setForeground(Color.gray);
        jTextField_correo.setText("Ingrese su correo electrónico");
        jTextField_correo.setBorder(null);
        jTextField_correo.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_correo, "Ingrese su correo electrónico");
        jTextField_correo.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                jTextField_correoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                jTextField_correoFocusLost(evt);
            }
        });
        jTextField_correo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField_correoActionPerformed(evt);
            }
        });
        background_dialog1.add(jTextField_correo, new AbsoluteConstraints(30, 410, 390, -1));

        jSeparator6.setForeground(new Color(30, 30, 30));
        background_dialog1.add(jSeparator6, new AbsoluteConstraints(30, 430, 390, 21));

        jTextField_telefono.setBackground(new Color(255, 255, 255));
        jTextField_telefono.setDocument(new LimitarCamposPhone(15, "Ingrese su teléfono (código de país, el código de ciudad y el número de teléfono local) no se acepta + al principio"));
        jTextField_telefono.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_telefono.setForeground(Color.gray);
        jTextField_telefono.setText("Ingrese su teléfono (código de país, el código de ciudad y el número de teléfono local) no se acepta + al principio");
        jTextField_telefono.setBorder(null);
        jTextField_telefono.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_telefono, "Ingrese su teléfono (código de país, el código de ciudad y el número de teléfono local) no se acepta + al principio");
        jTextField_telefono.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                jTextField_telefonoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                jTextField_telefonoFocusLost(evt);
            }
        });
        jTextField_telefono.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField_telefonoActionPerformed(evt);
            }
        });
        background_dialog1.add(jTextField_telefono, new AbsoluteConstraints(30, 460, 390, -1));

        telefono.setBackground(new Color(0, 0, 0));
        telefono.setFont(new Font("Roboto", Font.PLAIN, 12));
        telefono.setForeground(new Color(0, 0, 0));
        telefono.setText("Teléfono ");
        background_dialog1.add(telefono, new AbsoluteConstraints(30, 440, -1, -1));

        jSeparator12.setForeground(new Color(30, 30, 30));
        background_dialog1.add(jSeparator12, new AbsoluteConstraints(30, 480, 390, 21));

        errorMessage.setFont(new Font("Roboto", Font.BOLD, 14));
        errorMessage.setForeground(Color.red);
        errorMessage.setHorizontalAlignment(SwingConstants.CENTER);
        errorMessage.setText("ERROR.");
        errorMessage.setVisible(false);
        background_dialog1.add(errorMessage, new AbsoluteConstraints(30, 490, 390, -1));

        jButton_cancelar.setBackground(new Color(153, 153, 153));
        jButton_cancelar.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jButton_cancelar.setForeground(new Color(0, 0, 0));
        jButton_cancelar.setText("Cancelar");
        jButton_cancelar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_cancelarMouseClicked(evt);
            }
        });
        background_dialog1.add(jButton_cancelar, new AbsoluteConstraints(240, 510, -1, -1));

        jButton_modificar.setBackground(new Color(0, 204, 0));
        jButton_modificar.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jButton_modificar.setForeground(new Color(0, 0, 0));
        jButton_modificar.setText("Modificar");
        jButton_modificar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_modificarMouseClicked(evt);
            }
        });
        background_dialog1.add(jButton_modificar, new AbsoluteConstraints(330, 510, -1, -1));

        jScrollPane1.setViewportView(background_dialog1);

        GroupLayout jDialog_modificarDatosLayout = new GroupLayout(jDialog_modificarDatos.getContentPane());
        jDialog_modificarDatos.getContentPane().setLayout(jDialog_modificarDatosLayout);
        jDialog_modificarDatosLayout.setHorizontalGroup(
                jDialog_modificarDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jDialog_modificarDatosLayout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDialog_modificarDatosLayout.setVerticalGroup(
                jDialog_modificarDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
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

        jScrollPane_Table3.setBackground(new Color(227, 218, 201));
        jScrollPane_Table3.setForeground(new Color(227, 218, 201));
        jScrollPane_Table3.setOpaque(true);
        jScrollPane_Table3.setPreferredSize(new Dimension(794, 727));
        jScrollPane_Table3.setViewportView(null);

        jTable_Content3.setBackground(new Color(227, 218, 201));
        jTable_Content3.setFont(new Font("Roboto", Font.PLAIN, 12));
        jTable_Content3.setForeground(new Color(227, 218, 201));
        jTable_Content3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        jTable_Content3.setMinimumSize(new Dimension(50, 50));
        jTable_Content3.setPreferredSize(new Dimension(788, 721));
        jTable_Content3.setShowGrid(true);
        jScrollPane_Table3.setViewportView(jTable_Content3);

        jPanel_inventario.add(jScrollPane_Table3, BorderLayout.CENTER);

        opcionesTabla3.setBackground(new Color(0, 153, 204));
        opcionesTabla3.setPreferredSize(new Dimension(794, 50));
        opcionesTabla3.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        jTextField_buscarTabla3.setDocument(new LimitarCamposSeguro(25, "Buscar...")
        );
        jTextField_buscarTabla3.setText("Buscar...");
        jTextField_buscarTabla3.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jTextField_buscarTabla3.setPreferredSize(new Dimension(125, 26));
        jTextField_buscarTabla3.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                jTextField_buscarTabla3FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                jTextField_buscarTabla3FocusLost(evt);
            }
        });
        jTextField_buscarTabla3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField_buscarTabla3ActionPerformed(evt);
            }
        });
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
        titulo_contenido4.setText("Resultados Obtenidos de reporte y estadísticas");
        titulo_contenido4.setHorizontalTextPosition(SwingConstants.CENTER);
        titulo_contenido4.setOpaque(true);
        titulo_contenido4.setPreferredSize(new Dimension(794, 17));
        jPanel_estadisticas.add(titulo_contenido4, BorderLayout.NORTH);

        jScrollPane_Table4.setBackground(new Color(227, 218, 201));
        jScrollPane_Table4.setForeground(new Color(227, 218, 201));
        jScrollPane_Table4.setOpaque(true);
        jScrollPane_Table4.setPreferredSize(new Dimension(794, 727));
        jScrollPane_Table4.setViewportView(null);

        jTable_Content4.setBackground(new Color(227, 218, 201));
        jTable_Content4.setFont(new Font("Roboto", Font.PLAIN, 12));
        jTable_Content4.setForeground(new Color(227, 218, 201));
        jTable_Content4.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        jTable_Content4.setMinimumSize(new Dimension(50, 50));
        jTable_Content4.setPreferredSize(new Dimension(788, 721));
        jTable_Content4.setShowGrid(true);
        jScrollPane_Table4.setViewportView(jTable_Content4);

        jPanel_estadisticas.add(jScrollPane_Table4, BorderLayout.CENTER);

        opcionesTabla4.setBackground(new Color(0, 153, 204));
        opcionesTabla4.setPreferredSize(new Dimension(794, 50));
        opcionesTabla4.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        jTextField_buscarTabla4.setDocument(new LimitarCamposSeguro(25, "Buscar...")
        );
        jTextField_buscarTabla4.setText("Buscar...");
        jTextField_buscarTabla4.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jTextField_buscarTabla4.setPreferredSize(new Dimension(125, 26));
        RegistrarUser.handleFocusGain(jTextField_buscarTabla4, "Buscar...");
        jTextField_buscarTabla4.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                jTextField_buscarTabla4FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                jTextField_buscarTabla4FocusLost(evt);
            }
        });
        jTextField_buscarTabla4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField_buscarTabla4ActionPerformed(evt);
            }
        });
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

        jSeparator22.setPreferredSize(new Dimension(100, 10));
        jPanel_filtrarEstadistica.add(jSeparator22);
        jPanel_filtrarEstadistica.add(jSeparator23);

        jLabel7.setText("Filtro por fecha");
        jPanel_filtrarEstadistica.add(jLabel7);

        jComboBox_filterColumn1.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir...", "Día", "Mes", "Año", "Sede"}));
        jComboBox_filterColumn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jComboBox_filterColumn1ActionPerformed(evt);
            }
        });
        jPanel_filtrarEstadistica.add(jComboBox_filterColumn1);

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
        jPanel5.add(PantallaBase.createQuestionPanel("¿Cómo actualizo una dosis de vacuna?",
                """
                        1. Similar a registrar una vacunas.
                        Dar click en el botón 'Actualizar dosis' y buscamos al paciente a vacunar y la vacuna
                        Si existe la dosis, podrás editar la fecha de aplicación, el número de dosis, el fabricante, sede aplicada.
                        La vacuna no se puede modificar, para hacerlo debe eliminar el registro y crear un nuevo registro de vacuna.
                        Refiérase a la pregunta 2 ¿Cómo registro una dosis de vacuna a un paciente?"""));
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
                        El teléfono puede ser celular o fijo y debe estar los números pegados. Si es extranjero o diferente de 507 debe colocar su prefijo y códigos necesarios al inicio.
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
        jPanel_filtrarInventario.add(jSeparator24);
        jPanel_filtrarInventario.add(jSeparator25);

        jLabel8.setText("Filtrar por sede");
        jPanel_filtrarInventario.add(jLabel8);

        jComboBox_filterColumn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jComboBox_filterColumn2ActionPerformed(evt);
            }
        });
        jPanel_filtrarInventario.add(jComboBox_filterColumn2);

        jLabel12.setText("Filtrar por vacuna");
        jPanel_filtrarInventario.add(jLabel12);

        jComboBox_filterColumn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jComboBox_filterColumn3ActionPerformed(evt);
            }
        });
        jPanel_filtrarInventario.add(jComboBox_filterColumn3);

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

        jTextField3.setDocument(new LimitarCamposSeguro(50, "Buscar por sede..."));
        jTextField3.setText("Buscar por sede...");
        jTextField3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        RegistrarUser.handleFocusGain(jTextField3, "Buscar por sede...");
        jTextField3.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                jTextField3FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                jTextField3FocusLost(evt);
            }
        });
        jTextField3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel6.add(jTextField3);

        jLabel14.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jLabel14.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel14.setText("Desde");
        jPanel6.add(jLabel14);

        jTextField4.setDocument(new LimitarCamposSeguro(50, "Buscar desde la fecha AAAA-MM-DD..."));
        jTextField4.setText("Buscar desde la fecha AAAA-MM-DD...");
        jTextField4.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        RegistrarUser.handleFocusGain(jTextField4, "Buscar desde la fecha AAAA-MM-DD...");
        jTextField4.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                jTextField4FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                jTextField4FocusLost(evt);
            }
        });
        jTextField4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel6.add(jTextField4);

        jLabel15.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jLabel15.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel15.setText("Hasta");
        jPanel6.add(jLabel15);

        jTextField5.setDocument(new LimitarCamposSeguro(50, "Buscar hasta la fecha AAAA-MM-DD..."));
        jTextField5.setText("Buscar hasta la fecha AAAA-MM-DD...");
        jTextField5.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        RegistrarUser.handleFocusGain(jTextField5, "Buscar hasta la fecha AAAA-MM-DD...");
        jTextField5.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                jTextField5FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                jTextField5FocusLost(evt);
            }
        });
        jTextField5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jPanel6.add(jTextField5);

        jLabel16.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jLabel16.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel16.setText("Vacuna");
        jPanel6.add(jLabel16);

        jComboBox3.setPreferredSize(new Dimension(150, 26));
        jComboBox3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jPanel6.add(jComboBox3);

        jLabel17.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jLabel17.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel17.setText("Número de Dosis");
        jPanel6.add(jLabel17);

        jComboBox4.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir...", "Primera dosis", "Segunda dosis", "Tercera dosis", "Refuerzo", "Primer refuerzo", "Segundo refuerzo", "Dosis previa"}));
        jComboBox4.setPreferredSize(new Dimension(150, 26));
        jComboBox4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });
        jPanel6.add(jComboBox4);

        jPanel7.add(jPanel6, BorderLayout.CENTER);

        jButton2.setIcon(new ImageIcon(getClass().getResource("/images/lupa_icon.png")));
        jButton2.setPreferredSize(new Dimension(70, 27));
        jButton2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel7.add(jButton2, BorderLayout.EAST);

        jPanel_buscarDosis.add(jPanel7);

        jScrollPane_Table5.setBackground(new Color(227, 218, 201));
        jScrollPane_Table5.setForeground(new Color(227, 218, 201));
        jScrollPane_Table5.setOpaque(true);
        jScrollPane_Table5.setPreferredSize(new Dimension(794, 625));
        jScrollPane_Table5.setViewportView(null);

        jTable_Content5.setBackground(new Color(227, 218, 201));
        jTable_Content5.setFont(new Font("Roboto", Font.PLAIN, 12));
        jTable_Content5.setForeground(new Color(227, 218, 201));
        jTable_Content5.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        jTable_Content5.setMinimumSize(new Dimension(50, 50));
        jTable_Content5.setPreferredSize(new Dimension(788, 619));
        jTable_Content5.setShowGrid(true);
        jScrollPane_Table5.setViewportView(jTable_Content5);

        jPanel_buscarDosis.add(jScrollPane_Table5);

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
        jTextField_buscarTabla5.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                jTextField_buscarTabla5FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                jTextField_buscarTabla5FocusLost(evt);
            }
        });
        jTextField_buscarTabla5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField_buscarTabla5ActionPerformed(evt);
            }
        });
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

        jPanel_preferencias.setBackground(new Color(227, 218, 201));
        jPanel_preferencias.setPreferredSize(new Dimension(794, 794));
        jPanel_preferencias.setLayout(new BoxLayout(jPanel_preferencias, BoxLayout.Y_AXIS));

        icon_preferencias.setIcon(new ImageIcon(getClass().getResource("/images/ajuetes3.png")));
        icon_preferencias.setHorizontalTextPosition(SwingConstants.CENTER);
        icon_preferencias.setPreferredSize(new Dimension(130, 120));
        jPanel_preferencias.add(icon_preferencias);

        titulo3.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));
        titulo3.setForeground(new Color(0, 0, 0));
        titulo3.setHorizontalAlignment(SwingConstants.CENTER);
        titulo3.setText("Preferencias");
        titulo3.setHorizontalTextPosition(SwingConstants.CENTER);
        jPanel_preferencias.add(titulo3);

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
        JComboBox<String> familyComboBox = new JComboBox<>(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
        familyComboBox.setFont(new Font("Roboto", Font.PLAIN, 14));
        jPanel_fontChooser.add(familyLabel);
        jPanel_fontChooser.add(familyComboBox);

        // Estilo de la fuente
        JLabel styleLabel = new JLabel("Estilo:");
        styleLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
        String[] styles = {"Regular", "Negrita", "Cursiva", "Negrita Cursiva"};
        JComboBox<String> styleComboBox = new JComboBox<>(styles);
        styleComboBox.setFont(new Font("Roboto", Font.PLAIN, 14));
        jPanel_fontChooser.add(styleLabel);
        jPanel_fontChooser.add(styleComboBox);

        // Tamaño de la fuente
        JLabel sizeLabel = new JLabel("Tamaño:");
        sizeLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
        JSpinner sizeSpinner = new JSpinner(new SpinnerNumberModel(12, 1, 100, 1));
        sizeSpinner.setFont(new Font("Roboto", Font.PLAIN, 14));
        jPanel_fontChooser.add(sizeLabel);
        jPanel_fontChooser.add(sizeSpinner);

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

        jComboBox_exportarType.setFont(new Font("Roboto", Font.PLAIN, 14));
        jComboBox_exportarType.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir...", "CSV", "TXT", "PDF", "Excel"}));
        jComboBox_exportarType.setMaximumSize(new Dimension(367, 40));
        jComboBox_exportarType.setPreferredSize(new Dimension(190, 37));
        jPanel_preferencias.add(jComboBox_exportarType);

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

        jComboBox_exportarType1.setFont(new Font("Roboto", Font.PLAIN, 14));
        jComboBox_exportarType1.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir..."}));
        jComboBox_exportarType1.setMaximumSize(new Dimension(567, 40));
        jComboBox_exportarType1.setPreferredSize(new Dimension(450, 37));
        jPanel_preferencias.add(jComboBox_exportarType1);

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
        jDialog_modificarCred.setSize(new Dimension(450, 550));

        jScrollPane4.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        background_dialog3.setBackground(new Color(255, 255, 255));
        background_dialog3.setPreferredSize(new Dimension(444, 494));
        background_dialog3.setLayout(new AbsoluteLayout());

        titulo4.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
        titulo4.setForeground(new Color(0, 0, 0));
        titulo4.setHorizontalAlignment(SwingConstants.CENTER);
        titulo4.setText("Modificar credenciales de acceso");
        background_dialog3.add(titulo4, new AbsoluteConstraints(88, 25, 269, -1));

        jTextArea4.setEditable(false);
        jTextArea4.setBackground(new Color(255, 255, 255));
        jTextArea4.setFont(new Font("Microsoft YaHei", Font.ITALIC, 11));
        jTextArea4.setForeground(new Color(102, 102, 102));
        jTextArea4.setLineWrap(true);
        jTextArea4.setRows(5);
        jTextArea4.setText("Indicaciones: Para modificar las credenciales debe ingresar su usuario y contraseña anterior, si solo desea cambiar el usuario debe dejar en blanco los campos de nueva contraseña.\nDebe repetir la contraseña nueva si desea modificarla, sino no se cambiará la misma.\nSi desea modificar otro dato personal, utilice el otro botón.");
        jTextArea4.setWrapStyleWord(true);
        jTextArea4.setBorder(null);
        jTextArea4.setFocusable(false);
        background_dialog3.add(jTextArea4, new AbsoluteConstraints(30, 60, 380, 100));

        usuario1.setBackground(new Color(0, 0, 0));
        usuario1.setFont(new Font("Roboto", Font.PLAIN, 12));
        usuario1.setForeground(new Color(0, 0, 0));
        usuario1.setText("Usuario anterior *");
        background_dialog3.add(usuario1, new AbsoluteConstraints(30, 170, -1, -1));

        jTextField_usuario1.setBackground(new Color(255, 255, 255));
        jTextField_usuario1.setDocument(new LimitarCamposSeguro(50, "Ingrese su usuario"));
        jTextField_usuario1.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_usuario1.setForeground(Color.gray);
        jTextField_usuario1.setText("Ingrese su usuario");
        jTextField_usuario1.setActionCommand("<Not Set>");
        jTextField_usuario1.setBorder(null);
        jTextField_usuario1.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_usuario1, "Ingrese su usuario");
        jTextField_usuario1.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                jTextField_usuario1FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                jTextField_usuario1FocusLost(evt);
            }
        });
        jTextField_usuario1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField_usuario1ActionPerformed(evt);
            }
        });
        background_dialog3.add(jTextField_usuario1, new AbsoluteConstraints(30, 190, 380, -1));

        jSeparator8.setForeground(new Color(30, 30, 30));
        background_dialog3.add(jSeparator8, new AbsoluteConstraints(30, 210, 380, 21));

        usuario_nuevo.setBackground(new Color(0, 0, 0));
        usuario_nuevo.setFont(new Font("Roboto", Font.PLAIN, 12));
        usuario_nuevo.setForeground(new Color(0, 0, 0));
        usuario_nuevo.setText("Usuario nuevo");
        background_dialog3.add(usuario_nuevo, new AbsoluteConstraints(30, 220, -1, -1));

        jTextField_usuarioNuevo.setBackground(new Color(255, 255, 255));
        jTextField_usuarioNuevo.setDocument(new LimitarCamposSeguro(50, "Ingrese un usuario nuevo"));
        jTextField_usuarioNuevo.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_usuarioNuevo.setForeground(Color.gray);
        jTextField_usuarioNuevo.setText("Ingrese un usuario nuevo");
        jTextField_usuarioNuevo.setActionCommand("<Not Set>");
        jTextField_usuarioNuevo.setBorder(null);
        jTextField_usuarioNuevo.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_usuarioNuevo, "Ingrese un usuario nuevo");
        jTextField_usuarioNuevo.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                jTextField_usuarioNuevoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                jTextField_usuarioNuevoFocusLost(evt);
            }
        });
        jTextField_usuarioNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField_usuarioNuevoActionPerformed(evt);
            }
        });
        background_dialog3.add(jTextField_usuarioNuevo, new AbsoluteConstraints(30, 240, 380, -1));

        jSeparator21.setForeground(new Color(30, 30, 30));
        background_dialog3.add(jSeparator21, new AbsoluteConstraints(30, 260, 380, 21));

        contrasena.setBackground(new Color(0, 0, 0));
        contrasena.setFont(new Font("Roboto", Font.PLAIN, 12));
        contrasena.setForeground(new Color(0, 0, 0));
        contrasena.setText("Contraseña nueva");
        background_dialog3.add(contrasena, new AbsoluteConstraints(30, 320, -1, -1));

        jPasswordField_nueva1.setBackground(new Color(255, 255, 255));
        jPasswordField_nueva1.setDocument(new LimitarCamposSeguro(20, "Ingrese su contraseña"));
        jPasswordField_nueva1.setFont(new Font("Roboto", Font.PLAIN, 14));
        jPasswordField_nueva1.setForeground(Color.gray);
        jPasswordField_nueva1.setText("Ingrese su contraseña");
        jPasswordField_nueva1.setBorder(null);
        jPasswordField_nueva1.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jPasswordField_nueva1, "Ingrese su contraseña");
        jPasswordField_nueva1.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                jPasswordField_nueva1FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                jPasswordField_nueva1FocusLost(evt);
            }
        });
        jPasswordField_nueva1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jPasswordField_nueva1ActionPerformed(evt);
            }
        });
        background_dialog3.add(jPasswordField_nueva1, new AbsoluteConstraints(30, 340, 380, -1));

        jSeparator11.setForeground(new Color(30, 30, 30));
        background_dialog3.add(jSeparator11, new AbsoluteConstraints(30, 360, 380, 21));

        repetir_contrasena.setBackground(new Color(0, 0, 0));
        repetir_contrasena.setFont(new Font("Roboto", Font.PLAIN, 12));
        repetir_contrasena.setForeground(new Color(0, 0, 0));
        repetir_contrasena.setText("Repetir contraseña nueva *");
        background_dialog3.add(repetir_contrasena, new AbsoluteConstraints(30, 370, -1, -1));

        jPasswordField_nueva2.setBackground(new Color(255, 255, 255));
        jPasswordField_nueva2.setDocument(new LimitarCamposSeguro(20, "Repita su contraseña"));
        jPasswordField_nueva2.setFont(new Font("Roboto", Font.PLAIN, 14));
        jPasswordField_nueva2.setForeground(Color.gray);
        jPasswordField_nueva2.setText("Repita su contraseña");
        jPasswordField_nueva2.setBorder(null);
        jPasswordField_nueva2.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jPasswordField_nueva2, "Repita su contraseña");
        jPasswordField_nueva2.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                jPasswordField_nueva2FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                jPasswordField_nueva2FocusLost(evt);
            }
        });
        jPasswordField_nueva2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jPasswordField_nueva2ActionPerformed(evt);
            }
        });
        background_dialog3.add(jPasswordField_nueva2, new AbsoluteConstraints(30, 390, 380, -1));

        jSeparator7.setForeground(new Color(30, 30, 30));
        background_dialog3.add(jSeparator7, new AbsoluteConstraints(30, 410, 380, 21));

        errorMessage2.setFont(new Font("Roboto", Font.BOLD, 14));
        errorMessage2.setForeground(Color.red);
        errorMessage2.setHorizontalAlignment(SwingConstants.CENTER);
        errorMessage2.setText("Error. ");
        errorMessage2.setHorizontalTextPosition(SwingConstants.CENTER);
        errorMessage2.setVisible(false);
        background_dialog3.add(errorMessage2, new AbsoluteConstraints(2, 430, 440, -1));

        jButton_modificar2.setBackground(new Color(0, 204, 0));
        jButton_modificar2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jButton_modificar2.setForeground(new Color(0, 0, 0));
        jButton_modificar2.setText("Modificar");
        jButton_modificar2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_modificar2MouseClicked(evt);
            }
        });
        background_dialog3.add(jButton_modificar2, new AbsoluteConstraints(320, 450, -1, -1));

        jButton_cancelar2.setBackground(new Color(153, 153, 153));
        jButton_cancelar2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jButton_cancelar2.setForeground(new Color(0, 0, 0));
        jButton_cancelar2.setText("Cancelar");
        jButton_cancelar2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_cancelar2MouseClicked(evt);
            }
        });
        background_dialog3.add(jButton_cancelar2, new AbsoluteConstraints(230, 450, -1, -1));

        contrasena_anterior.setBackground(new Color(0, 0, 0));
        contrasena_anterior.setFont(new Font("Roboto", Font.PLAIN, 12));
        contrasena_anterior.setForeground(new Color(0, 0, 0));
        contrasena_anterior.setText("Contraseña anterior *");
        background_dialog3.add(contrasena_anterior, new AbsoluteConstraints(30, 270, -1, -1));

        jPasswordField_vieja.setBackground(new Color(255, 255, 255));
        jPasswordField_vieja.setDocument(new LimitarCamposSeguro(20, "Ingrese su contraseña"));
        jPasswordField_vieja.setFont(new Font("Roboto", Font.PLAIN, 14));
        jPasswordField_vieja.setForeground(Color.gray);
        jPasswordField_vieja.setText("Ingrese su contraseña");
        jPasswordField_vieja.setBorder(null);
        jPasswordField_vieja.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jPasswordField_vieja, "Ingrese su contraseña");
        jPasswordField_vieja.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                jPasswordField_viejaFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                jPasswordField_viejaFocusLost(evt);
            }
        });
        jPasswordField_vieja.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jPasswordField_viejaActionPerformed(evt);
            }
        });
        background_dialog3.add(jPasswordField_vieja, new AbsoluteConstraints(30, 290, 380, -1));

        jSeparator26.setForeground(new Color(30, 30, 30));
        background_dialog3.add(jSeparator26, new AbsoluteConstraints(30, 310, 380, 21));

        jScrollPane4.setViewportView(background_dialog3);

        GroupLayout jDialog_modificarCredLayout = new GroupLayout(jDialog_modificarCred.getContentPane());
        jDialog_modificarCred.getContentPane().setLayout(jDialog_modificarCredLayout);
        jDialog_modificarCredLayout.setHorizontalGroup(
                jDialog_modificarCredLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4)
        );
        jDialog_modificarCredLayout.setVerticalGroup(
                jDialog_modificarCredLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4)
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

        jScrollPane3.setPreferredSize(getSize());

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

        separador1.setBackground(new Color(39, 104, 165));
        separador1.setForeground(new Color(48, 48, 46));
        separador1.setPreferredSize(new Dimension(150, 35));

        GroupLayout separador1Layout = new GroupLayout(separador1);
        separador1.setLayout(separador1Layout);
        separador1Layout.setHorizontalGroup(
                separador1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        separador1Layout.setVerticalGroup(
                separador1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel_menuOpciones.add(separador1);

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
        button_opcion4.setText("Actualizar dosis");
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

        separador2.setBackground(new Color(39, 104, 165));
        separador2.setForeground(new Color(48, 48, 46));
        separador2.setPreferredSize(new Dimension(150, 17));

        GroupLayout separador2Layout = new GroupLayout(separador2);
        separador2.setLayout(separador2Layout);
        separador2Layout.setHorizontalGroup(
                separador2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        separador2Layout.setVerticalGroup(
                separador2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel_menuOpciones.add(separador2);

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

        jPanel_derecho.setBackground(new Color(227, 218, 201));
        jPanel_derecho.setPreferredSize(new Dimension(794, 0));
        jPanel_derecho.setLayout(new CardLayout());

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

        jPanel_derecho.add(jPanel1, "vacio");

        background.add(jPanel_derecho, BorderLayout.CENTER);

        jScrollPane3.setViewportView(background);

        getContentPane().add(jScrollPane3, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void formWindowClosing(WindowEvent evt) {
        int confirm = JOptionPane.showConfirmDialog(null, "¿Esta seguro de cerrar sesión?", "Cerrando sesión y ventana...", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (confirm == 0) {
            parentFrame.setVisible(true);
            parentFrame.requestFocus();
            this.dispose();
        }
    }

    private void formComponentShown(ComponentEvent evt) {
        Login.setImageLabal(icon_project, "src/images/operacionVacunas_Logo.png");
    }

    private void jButton_acercarMouseClicked(MouseEvent evt) {
        Font currentFont = jTable_Content.getFont();
        jTable_Content.setFont(currentFont.deriveFont(currentFont.getSize() + 2f));
        /* TODO por mover eventos de jPanel mostrarTabla en doctor es Mis Pacientes */
    }

    private void jButton_alejarMouseClicked(MouseEvent evt) {
        Font currentFont = jTable_Content.getFont();
        jTable_Content.setFont(currentFont.deriveFont(currentFont.getSize() - 2f));
        /* TODO por mover eventos de jPanel mostrarTabla en doctor es Mis Pacientes */
    }

    private void jButton_fuenteMouseClicked(MouseEvent evt) {
        JFontChooser fontChooser = new JFontChooser(this);
        boolean result = fontChooser.showDialog(this);
        if (result) {
            Font font = fontChooser.getSelectedFont();
            jTable_Content.setFont(font);
            jTable_Content.repaint();
        }
        /* TODO por mover eventos de jPanel mostrarTabla en doctor es Mis Pacientes */
    }

    private void jButton_exportarMouseClicked(MouseEvent evt) {
        /* TODO llamada al método exportar en csv o excel o pdf */
        /* TODO por mover eventos de jPanel mostrarTabla en doctor es Mis Pacientes */
    }

    /* eventos de jPanel mostrarTabla en doctor es Mis Pacientes */
    private void jButton_buscarMouseClicked(MouseEvent evt) {
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

    private void jTextField_buscarTablaActionPerformed(ActionEvent evt) {
        jButton_buscarMouseClicked(null);
    }

    private void jTextField_buscarTablaFocusGained(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_buscarTabla, "Buscar...");
    }

    private void jTextField_buscarTablaFocusLost(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_buscarTabla, "Buscar...");
    }

    private void jButton_filtrosMouseClicked(MouseEvent evt) {
        if (!jPanel_mostrarTabla.isAncestorOf(jPanel_filtrar1)) {
            jPanel_mostrarTabla.add(jPanel_filtrar1, BorderLayout.NORTH);
        } else {
            jPanel_mostrarTabla.remove(jPanel_filtrar1);
        }
        jPanel_mostrarTabla.revalidate();
        jPanel_mostrarTabla.repaint();
    }

    private void jButton_ordenarMouseClicked(MouseEvent evt) {
        jTable_Content.setAutoCreateRowSorter(true);
    }

    /* eventos de jPanel manipular paciente */
    private void jButton_modificar1MouseClicked(MouseEvent evt) {
        if (!jButton_modificar1.isEnabled()) {
            return;
        }

        jButton_modificar1.setEnabled(false); // deshabilitar el botón

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                jButton_modificar1.setEnabled(true);
            }
        }, manipulatePacienteDisableTime);

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

    private void jTextField_telefono1ActionPerformed(ActionEvent evt) {
        jButton_modificar1MouseClicked(null);
    }

    private void jTextField_telefono1FocusLost(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_telefono1, "Ingrese su teléfono (código de país, el código de ciudad y el número de teléfono local) no se acepta + al principio");
    }

    private void jTextField_telefono1FocusGained(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_telefono1, "Ingrese su teléfono (código de país, el código de ciudad y el número de teléfono local) no se acepta + al principio");
    }

    private void jTextField_correo1ActionPerformed(ActionEvent evt) {
        jTextField_telefono1.requestFocus();
    }

    private void jTextField_correo1FocusLost(FocusEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField_correo1FocusGained(FocusEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField_direccion1ActionPerformed(ActionEvent evt) {
        jTextField_correo1.requestFocus();
    }

    private void jTextField_direccion1FocusLost(FocusEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField_direccion1FocusGained(FocusEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField_fechaNacimiento1ActionPerformed(ActionEvent evt) {
        if (jComboBox_sexo1.getSelectedIndex() <= 0) {
            jComboBox_sexo1.setSelectedIndex(3);
        }
        if (jComboBox_distrito1.getSelectedIndex() <= 0) {
            jComboBox_distrito1.setSelectedIndex(1);
        }
        jTextField_direccion.requestFocus();
    }

    private void jTextField_fechaNacimiento1FocusLost(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_fechaNacimiento1, "Ingrese la fecha de nacimiento YYYY-MM-DD* hh:mm:ss");
    }

    private void jTextField_fechaNacimiento1FocusGained(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_fechaNacimiento1, "Ingrese la fecha de nacimiento YYYY-MM-DD* hh:mm:ss");
    }

    private void jTextField_cedula1ActionPerformed(ActionEvent evt) {
        jTextField_fechaNacimiento1.requestFocus();
    }

    private void jTextField_cedula1FocusLost(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_cedula1, "Ingrese la cédula");
    }

    private void jTextField_cedula1FocusGained(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_cedula1, "Ingrese la cédula");
    }

    private void jTextField_apellido1ActionPerformed(ActionEvent evt) {
        jTextField_cedula1.requestFocus();
    }

    private void jTextField_apellido1FocusLost(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_apellido1, "Ingrese el apellido");
    }

    private void jTextField_apellido1FocusGained(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_apellido1, "Ingrese el apellido");
    }

    private void jTextField_nombre1ActionPerformed(ActionEvent evt) {
        jTextField_apellido1.requestFocus();
    }

    private void jTextField_nombre1FocusLost(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_nombre1, "Ingrese el nombre");
    }

    private void jTextField_nombre1FocusGained(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_nombre1, "Ingrese el nombre");
    }

    private void jTextField_cedula2ActionPerformed(ActionEvent evt) {
        jButton3MouseClicked(null);
    }

    private void jTextField_cedula2FocusLost(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_cedula2, "Ingrese cédula a buscar");
    }

    private void jTextField_cedula2FocusGained(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_cedula2, "Ingrese cédula a buscar");
    }

    /* eventos del menú lateral */
    private void button_logOutMouseClicked(MouseEvent evt) {
        formWindowClosing(null);
    }

    private void button_soporteMouseClicked(MouseEvent evt) {
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

    private void button_preferenciasMouseClicked(MouseEvent evt) {
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

    private void button_modificarCredMouseClicked(MouseEvent evt) {
        jDialog_modificarCred.setLocationRelativeTo(this);
        jDialog_modificarCred.setVisible(true);
    }

    private void button_modificarDatosMouseClicked(MouseEvent evt) {
        jDialog_modificarDatos.setLocationRelativeTo(this);
        jDialog_modificarDatos.setVisible(true);
    }

    private void button_opcion8MouseClicked(MouseEvent evt) {
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

    private void button_opcion7MouseClicked(MouseEvent evt) {
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

    private void button_opcion6MouseClicked(MouseEvent evt) {
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

    private void button_opcion5MouseClicked(MouseEvent evt) {
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

    private void button_opcion4MouseClicked(MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void button_opcion3MouseClicked(MouseEvent evt) {


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

    private void button_opcion2MouseClicked(MouseEvent evt) {
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

    private void button_opcion1MouseClicked(MouseEvent evt) {
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
    private void jTextField_nombreFocusGained(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_nombre, "Ingrese su nombre");
    }

    private void jTextField_nombreFocusLost(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_nombre, "Ingrese su nombre");
    }

    private void jTextField_nombreActionPerformed(ActionEvent evt) {
        jTextField_apellido.requestFocus();
    }

    private void jTextField_apellidoFocusGained(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_apellido, "Ingrese su apellido");
    }

    private void jTextField_apellidoFocusLost(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_apellido, "Ingrese su apellido");
    }

    private void jTextField_apellidoActionPerformed(ActionEvent evt) {
        jTextField_cedula.requestFocus();
    }

    private void jTextField_cedulaActionPerformed(ActionEvent evt) {
        jTextField_fechaNacimiento.requestFocus();
    }

    private void jTextField_fechaNacimientoActionPerformed(ActionEvent evt) {
        jTextField_direccion.requestFocus();
    }

    private void jTextField_direccionFocusGained(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_direccion, "Ingrese su dirección");
    }

    private void jTextField_direccionFocusLost(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_direccion, "Ingrese su dirección");
    }

    private void jTextField_direccionActionPerformed(ActionEvent evt) {
        if (jComboBox_distrito.getSelectedIndex() == 0) {
            jComboBox_distrito.setSelectedIndex(1);
        }
        jTextField_correo.requestFocus();
    }

    private void jTextField_correoFocusGained(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_correo, "Ingrese su correo electrónico");
    }

    private void jTextField_correoFocusLost(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_correo, "Ingrese su correo electrónico");
    }

    private void jTextField_correoActionPerformed(ActionEvent evt) {
        jTextField_telefono.requestFocus();
    }

    private void jTextField_telefonoFocusGained(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_telefono, "Ingrese su teléfono (código de país, el código de ciudad y el número de teléfono local) no se acepta + al principio");
    }

    private void jTextField_telefonoFocusLost(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_telefono, "Ingrese su teléfono (código de país, el código de ciudad y el número de teléfono local) no se acepta + al principio");
    }

    private void jTextField_telefonoActionPerformed(ActionEvent evt) {
        jButton_modificarMouseClicked(null);
    }

    private void jButton_cancelarMouseClicked(MouseEvent evt) {
        jDialog_modificarDatos.dispose();
    }

    private void jButton_modificarMouseClicked(MouseEvent evt) {
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
        boolean condicionOp5 = telefonoM.isBlank() || telefonoM.equals("Ingrese su teléfono (código de país, el código de ciudad y el número de teléfono local) no se acepta + al principio");

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
    private void jTextField_buscarTabla3FocusGained(FocusEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField_buscarTabla3FocusLost(FocusEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField_buscarTabla3ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton_buscar3MouseClicked(MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton_acercar3MouseClicked(MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton_alejar3MouseClicked(MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton_ordenar3MouseClicked(MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton_filtros3MouseClicked(MouseEvent evt) {
        if (!jPanel_estadisticas.isAncestorOf(jPanel_filtrarEstadistica)) {
            jPanel_estadisticas.add(jPanel_filtrarEstadistica, BorderLayout.NORTH);
        } else {
            jPanel_estadisticas.remove(jPanel_filtrarEstadistica);
        }
        jPanel_estadisticas.revalidate();
        jPanel_estadisticas.repaint();
    }

    private void jButton_fuente3MouseClicked(MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton_exportar3MouseClicked(MouseEvent evt) {
        // TODO add your handling code here:
    }

    /* eventos de jPanel reporte y estadísticas */
    private void jTextField_buscarTabla4FocusGained(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_buscarTabla4, "Buscar...");
    }

    private void jTextField_buscarTabla4FocusLost(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_buscarTabla4, "Buscar...");
    }

    private void jTextField_buscarTabla4ActionPerformed(ActionEvent evt) {
        jButton_buscar4MouseClicked(null);
    }

    private void jButton_buscar4MouseClicked(MouseEvent evt) {
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

    private void jButton_acercar4MouseClicked(MouseEvent evt) {
        Font currentFont = jTable_Content4.getFont();
        jTable_Content4.setFont(currentFont.deriveFont(currentFont.getSize() + 2f));
    }

    private void jButton_alejar4MouseClicked(MouseEvent evt) {
        Font currentFont = jTable_Content4.getFont();
        jTable_Content4.setFont(currentFont.deriveFont(currentFont.getSize() - 2f));
    }

    private void jButton_ordenar4MouseClicked(MouseEvent evt) {
        jTable_Content4.setAutoCreateRowSorter(true);
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
        JFontChooser fontChooser = new JFontChooser(this);
        boolean result = fontChooser.showDialog(this);
        if (result) {
            Font font = fontChooser.getSelectedFont();
            jTable_Content4.setFont(font);
            jTable_Content4.repaint();
        }
    }

    private void jButton_exportar4MouseClicked(MouseEvent evt) {
        /* TODO llamada al método exportar en csv o excel o pdf del jPanel estadísticas */
    }

    /* eventos de jPanels filtrar. Guiarse de método filterActionPerformed(); */
    private void jComboBox_filterColumn1ActionPerformed(ActionEvent evt) {
        /* TODO filtrar por fecha los reportes y estadísticas. opciones ya definidas */
    }

    private void jComboBox_filterColumn2ActionPerformed(ActionEvent evt) {
        /* TODO filtrar por sede el inventario */
    }

    private void jComboBox_filterColumn3ActionPerformed(ActionEvent evt) {
        /* TODO filtrar por vacuna el inventario */
    }

    /* eventos de jPanel buscar paciente */
    private void jButton_exportar1MouseClicked(MouseEvent evt) {
        /* TODO llamada al método exportar en csv o excel o pdf del jPanel buscar Paciente */
    }

    private void jButton_fuente1MouseClicked(MouseEvent evt) {
        JFontChooser fontChooser = new JFontChooser(this);
        boolean result = fontChooser.showDialog(this);
        if (result) {
            Font font = fontChooser.getSelectedFont();
            jTable_Content1.setFont(font);
            jTable_Content1.repaint();
        }
    }

    private void jButton_filtros1MouseClicked(MouseEvent evt) {
        if (!jPanel_buscarPaciente.isAncestorOf(jPanel_filtrar2)) {
            jPanel_buscarPaciente.add(jPanel_filtrar2);
        } else {
            jPanel_buscarPaciente.remove(jPanel_filtrar2);
        }
        jPanel_buscarPaciente.revalidate();
        jPanel_buscarPaciente.repaint();
    }

    private void jButton_ordenar1MouseClicked(MouseEvent evt) {
        jTable_Content1.setAutoCreateRowSorter(true);
    }

    private void jButton_alejar1MouseClicked(MouseEvent evt) {
        Font currentFont = jTable_Content1.getFont();
        jTable_Content1.setFont(currentFont.deriveFont(currentFont.getSize() - 2f));
    }

    private void jButton_acercar1MouseClicked(MouseEvent evt) {
        Font currentFont = jTable_Content1.getFont();
        jTable_Content1.setFont(currentFont.deriveFont(currentFont.getSize() + 2f));
    }

    private void jButton_buscar1MouseClicked(MouseEvent evt) {
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

    private void jTextField_buscarTabla1ActionPerformed(ActionEvent evt) {
        jButton_buscar1MouseClicked(null);
    }

    private void jTextField_buscarTabla1FocusLost(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_buscarTabla1, "Buscar...");
    }

    private void jTextField_buscarTabla1FocusGained(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_buscarTabla1, "Buscar...");
    }

    private void jButton1MouseClicked(MouseEvent evt) {
        /* TODO implementar el BUSCAR PACIENTE para vacunar según el criterio del jComboBox1*/
    }

    private void jTextField1ActionPerformed(ActionEvent evt) {
        jButton1MouseClicked(null);
    }

    private void jPanel_buscarPacienteAncestorAdded(AncestorEvent evt) {
        jTextField1.requestFocus();
    }

    private void jTextField1FocusGained(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField1, "Buscar paciente...");
    }

    private void jTextField1FocusLost(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField1, "Buscar paciente...");
    }

    /* eventos de jPanel buscar dosis de vacuna */
    private void jTextField3FocusGained(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField3, "Buscar por sede...");
    }

    private void jTextField3FocusLost(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField3, "Buscar por sede...");
    }

    private void jTextField3ActionPerformed(ActionEvent evt) {
        jTextField4.requestFocus();
    }

    private void jTextField_buscarTabla5FocusGained(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_buscarTabla5, "Buscar...");
    }

    private void jTextField_buscarTabla5FocusLost(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_buscarTabla5, "Buscar...");
    }

    private void jTextField_buscarTabla5ActionPerformed(ActionEvent evt) {
        jButton_buscar5MouseClicked(null);
    }

    private void jButton_buscar5MouseClicked(MouseEvent evt) {
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

    private void jButton_acercar5MouseClicked(MouseEvent evt) {
        Font currentFont = jTable_Content5.getFont();
        jTable_Content5.setFont(currentFont.deriveFont(currentFont.getSize() + 2f));
    }

    private void jButton_alejar5MouseClicked(MouseEvent evt) {
        Font currentFont = jTable_Content5.getFont();
        jTable_Content5.setFont(currentFont.deriveFont(currentFont.getSize() - 2f));
    }

    private void jButton_ordenar5MouseClicked(MouseEvent evt) {
        jTable_Content5.setAutoCreateRowSorter(true);
    }

    private void jButton_filtros5MouseClicked(MouseEvent evt) {
        if (!jPanel_buscarDosis.isAncestorOf(jPanel_filtrar3)) {
            jPanel_buscarDosis.add(jPanel_filtrar3);
        } else {
            jPanel_buscarDosis.remove(jPanel_filtrar3);
        }
        jPanel_buscarDosis.revalidate();
        jPanel_buscarDosis.repaint();
    }

    private void jButton_fuente5MouseClicked(MouseEvent evt) {
        JFontChooser fontChooser = new JFontChooser(this);
        boolean result = fontChooser.showDialog(this);
        if (result) {
            Font font = fontChooser.getSelectedFont();
            jTable_Content5.setFont(font);
            jTable_Content5.repaint();
        }
    }

    private void jButton_exportar5MouseClicked(MouseEvent evt) {
        /* TODO llamada al método exportar en csv o excel o pdf del jPanel buscar dosis */
    }

    private void jPanel_buscarDosisAncestorAdded(AncestorEvent evt) {
        jTextField3.requestFocus();
        /* evaluar si hacer focus al abrir el buscar dosis hacia sede u otro campo */
    }

    private void jTextField4FocusGained(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField4, "Buscar desde la fecha AAAA-MM-DD...");
    }

    private void jTextField4FocusLost(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField4, "Buscar desde la fecha AAAA-MM-DD...");
    }

    private void jTextField4ActionPerformed(ActionEvent evt) {
        jTextField5.requestFocus();
    }

    private void jTextField5FocusGained(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField5, "Buscar hasta la fecha AAAA-MM-DD...");
    }

    private void jTextField5FocusLost(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField5, "Buscar hasta la fecha AAAA-MM-DD...");
    }

    private void jTextField5ActionPerformed(ActionEvent evt) {
        jComboBox3.requestFocus();
    }

    private void jComboBox4ActionPerformed(ActionEvent evt) {
        jButton2MouseClicked(null);
    }

    private void jButton2MouseClicked(MouseEvent evt) {
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

    private void jComboBox3ActionPerformed(ActionEvent evt) {
        jComboBox4.requestFocus();
    }

    private void jButton_savePreferencesMouseClicked(MouseEvent evt) {
        /* TODO implementar lógica de guardar preferencias del usuario*/
    }

    private void jButton3MouseClicked(MouseEvent evt) {
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
                JOptionPane.showMessageDialog(null, "No se encontraron resultados de pacientes con dicha cédula. Debe crearlo o si es un error, puede buscar al paciente con otros parámetros en 'Buscar paciente'.", "Error al buscar un paciente...", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void jTextField_usuario1FocusGained(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_usuario1, "Ingrese su usuario");
    }

    private void jTextField_usuario1FocusLost(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_usuario1, "Ingrese su usuario");
    }

    private void jTextField_usuario1ActionPerformed(ActionEvent evt) {
        jTextField_usuarioNuevo.requestFocus();
    }

    private void jTextField_usuarioNuevoFocusGained(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_usuarioNuevo, "Ingrese un usuario nuevo");
    }

    private void jTextField_usuarioNuevoFocusLost(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_usuarioNuevo, "Ingrese un usuario nuevo");
    }

    private void jTextField_usuarioNuevoActionPerformed(ActionEvent evt) {
        jPasswordField_vieja.requestFocus();
    }

    private void jPasswordField_nueva1FocusGained(FocusEvent evt) {
        RegistrarUser.handleFocusPassword(jPasswordField_nueva1, "Ingrese su contraseña");
    }

    private void jPasswordField_nueva1FocusLost(FocusEvent evt) {
        RegistrarUser.handleFocusPassword(jPasswordField_nueva1, "Ingrese su contraseña");
    }

    private void jPasswordField_nueva1ActionPerformed(ActionEvent evt) {
        jPasswordField_nueva2.requestFocus();
    }

    private void jPasswordField_nueva2FocusGained(FocusEvent evt) {
        RegistrarUser.handleFocusPassword(jPasswordField_nueva2, "Repita su contraseña");
    }

    private void jPasswordField_nueva2FocusLost(FocusEvent evt) {
        RegistrarUser.handleFocusPassword(jPasswordField_nueva2, "Repita su contraseña");
    }

    private void jPasswordField_nueva2ActionPerformed(ActionEvent evt) {
        jButton_modificar2MouseClicked(null);
    }

    private void jButton_modificar2MouseClicked(MouseEvent evt) {
        boolean cambiado;
        String usuario = jTextField_usuario1.getText();
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

    private void jButton_cancelar2MouseClicked(MouseEvent evt) {
        jDialog_modificarCred.dispose();
    }

    private void jPasswordField_viejaFocusGained(FocusEvent evt) {
        RegistrarUser.handleFocusPassword(jPasswordField_vieja, "Ingrese su contraseña");
        /* TODO por mover al jDialog modificar credenciales del usuario */
    }

    private void jPasswordField_viejaFocusLost(FocusEvent evt) {
        RegistrarUser.handleFocusPassword(jPasswordField_vieja, "Ingrese su contraseña");
        /* TODO por mover al jDialog modificar credenciales del usuario */
    }

    private void jPasswordField_viejaActionPerformed(ActionEvent evt) {
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
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
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
    private final JTableFiltrar jPanel_filtrar1;
    private final JTableFiltrar jPanel_filtrar2;
    private final JTableFiltrar jPanel_filtrar3;
    private String cedulaUsuarioActual;
    private final long manipulatePacienteDisableTime = 15000;

    // Variables declaration - do not modify
    private JLabel apellido;
    private JLabel apellido1;
    private JPanel background;
    private JPanel background_dialog1;
    private JPanel background_dialog2;
    private JPanel background_dialog3;
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
    private JLabel cedula;
    private JLabel cedula1;
    private JLabel cedula2;
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
    private JLabel fecha_nacimiento;
    private JLabel fecha_nacimiento1;
    private JLabel icon_preferencias;
    private JLabel icon_project;
    private JTextArea indicaciones;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
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
    private JButton jButton_modificar;
    private JButton jButton_modificar1;
    private JButton jButton_modificar2;
    private JButton jButton_ordenar;
    private JButton jButton_ordenar1;
    private JButton jButton_ordenar3;
    private JButton jButton_ordenar4;
    private JButton jButton_ordenar5;
    private JButton jButton_savePreferences;
    private JComboBox<String> jComboBox1;
    private JComboBox<String> jComboBox3;
    private JComboBox<String> jComboBox4;
    private JComboBox<String> jComboBox_distrito;
    private JComboBox<String> jComboBox_distrito1;
    private JComboBox<String> jComboBox_exportarType;
    private JComboBox<String> jComboBox_exportarType1;
    private JComboBox<String> jComboBox_filterColumn1;
    private JComboBox<String> jComboBox_filterColumn2;
    private JComboBox<String> jComboBox_filterColumn3;
    private JComboBox<String> jComboBox_sexo;
    private JComboBox<String> jComboBox_sexo1;
    private JDialog jDialog_modificarCred;
    private JDialog jDialog_modificarDatos;
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
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel_agendarCita;
    private JPanel jPanel_buscarDosis;
    private JPanel jPanel_buscarPaciente;
    private JPanel jPanel_derecho;
    private JPanel jPanel_estadisticas;
    private JPanel jPanel_filtrarEstadistica;
    private JPanel jPanel_filtrarInventario;
    private JPanel jPanel_fontChooser;
    private JPanel jPanel_inventario;
    private JPanel jPanel_manipularPaciente;
    private JPanel jPanel_menuOpciones;
    private JPanel jPanel_mostrarTabla;
    private JPanel jPanel_preferencias;
    private JPanel jPanel_separador1;
    private JPanel jPanel_separador2;
    private JPanel jPanel_separador3;
    private JPanel jPanel_separador4;
    private JPanel jPanel_separador5;
    private JPanel jPanel_soporte;
    private JPasswordField jPasswordField_nueva1;
    private JPasswordField jPasswordField_nueva2;
    private JPasswordField jPasswordField_vieja;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane_Table;
    private JScrollPane jScrollPane_Table1;
    private JScrollPane jScrollPane_Table3;
    private JScrollPane jScrollPane_Table4;
    private JScrollPane jScrollPane_Table5;
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
    private JTable jTable_Content;
    private JTable jTable_Content1;
    private JTable jTable_Content3;
    private JTable jTable_Content4;
    private JTable jTable_Content5;
    private JTextArea jTextArea1;
    private JTextArea jTextArea3;
    private JTextArea jTextArea4;
    private JTextField jTextField1;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField5;
    private JTextField jTextField_apellido;
    private JTextField jTextField_apellido1;
    private JTextField jTextField_buscarTabla;
    private JTextField jTextField_buscarTabla1;
    private JTextField jTextField_buscarTabla3;
    private JTextField jTextField_buscarTabla4;
    private JTextField jTextField_buscarTabla5;
    private JTextField jTextField_cedula;
    private JTextField jTextField_cedula1;
    private JTextField jTextField_cedula2;
    private JTextField jTextField_correo;
    private JTextField jTextField_correo1;
    private JTextField jTextField_direccion;
    private JTextField jTextField_direccion1;
    private JTextField jTextField_fechaNacimiento;
    private JTextField jTextField_fechaNacimiento1;
    private JTextField jTextField_nombre;
    private JTextField jTextField_nombre1;
    private JTextField jTextField_telefono;
    private JTextField jTextField_telefono1;
    private JTextField jTextField_usuario;
    private JTextField jTextField_usuario1;
    private JTextField jTextField_usuarioNuevo;
    private JLabel nombre;
    private JLabel nombre1;
    private JLabel nombreBienvenida;
    private JPanel opcionesTabla;
    private JPanel opcionesTabla1;
    private JPanel opcionesTabla3;
    private JPanel opcionesTabla4;
    private JPanel opcionesTabla5;
    private JLabel repetir_contrasena;
    private JLabel rolName;
    private JPanel separador1;
    private JPanel separador2;
    private JLabel sexo;
    private JLabel sexo1;
    private JLabel telefono;
    private JLabel telefono1;
    private JLabel titulo;
    private JLabel titulo1;
    private JLabel titulo2;
    private JLabel titulo3;
    private JLabel titulo4;
    private JLabel titulo_contenido;
    private JLabel titulo_contenido1;
    private JLabel titulo_contenido3;
    private JLabel titulo_contenido4;
    private JLabel titulo_contenido5;
    private JLabel usuario;
    private JLabel usuario1;
    private JLabel usuario_nuevo;
    // End of variables declaration
}
