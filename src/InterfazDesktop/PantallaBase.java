package InterfazDesktop;

import Logica.Validations.*;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;

public class PantallaBase extends JFrame {

    public PantallaBase(JFrame parent) {
        PantallaBase.parentFrame = parent;
        initComponents();

        this.jPanel_filtrar = new JTableFiltrar(jTable_Content);

        JButton[] botones = {button_opcion1, button_opcion2, button_opcion3,
                button_opcion4, button_opcion5, button_modificarDatos,
                button_modificarCred, button_preferencias, jButton_savePreferences,
                button_soporte};
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
        jDialog_modificarCred = new JDialog();
        jScrollPane2 = new JScrollPane();
        background_dialog2 = new JPanel();
        titulo2 = new JLabel();
        jTextArea1 = new JTextArea();
        usuario = new JLabel();
        jTextField_usuario = new JTextField();
        jSeparator8 = new JSeparator();
        usuario_nuevo = new JLabel();
        jTextField_usuarioNuevo = new JTextField();
        jSeparator14 = new JSeparator();
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
        jSeparator13 = new JSeparator();
        jPanel_mostrarTabla = new JPanel();
        jPanel2 = new JPanel();
        titulo_contenido1 = new JLabel();
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
        jPanel_soporte = new JPanel();
        jLabel10 = new JLabel();
        jPanel5 = new JPanel();
        jLabel11 = new JLabel();
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
        jScrollPane3 = new JScrollPane();
        background = new JPanel();
        jPanel_menuOpciones = new JPanel();
        separador1 = new JPanel();
        icon_project = new JLabel();
        separador3 = new JPanel();
        rolName = new JLabel();
        nombreBienvenida = new JLabel();
        separador2 = new JPanel();
        button_opcion1 = new JButton();
        button_opcion2 = new JButton();
        button_opcion3 = new JButton();
        button_opcion4 = new JButton();
        button_opcion5 = new JButton();
        separador4 = new JPanel();
        button_modificarDatos = new JButton();
        button_modificarCred = new JButton();
        button_preferencias = new JButton();
        button_soporte = new JButton();
        button_logOut = new JButton();
        jPanel_derecho = new JPanel();
        jPanel1 = new JPanel();
        jLabel6 = new JLabel();

        jDialog_modificarCred.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jDialog_modificarCred.setTitle("Programa Vacunas Panamá - Modificar credenciales");
        jDialog_modificarCred.setModal(true);
        jDialog_modificarCred.setResizable(false);
        jDialog_modificarCred.setSize(new Dimension(450, 550));

        jScrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        background_dialog2.setBackground(new Color(255, 255, 255));
        background_dialog2.setPreferredSize(new Dimension(444, 494));
        background_dialog2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo2.setFont(new Font("Microsoft YaHei", 1, 14));
        titulo2.setForeground(new Color(0, 0, 0));
        titulo2.setHorizontalAlignment(SwingConstants.CENTER);
        titulo2.setText("Modificar credenciales de acceso");
        background_dialog2.add(titulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 25, 269, -1));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new Color(255, 255, 255));
        jTextArea1.setFont(new Font("Microsoft YaHei", 2, 11));
        jTextArea1.setForeground(new Color(102, 102, 102));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Indicaciones: Para modificar las credenciales debe ingresar su usuario y contraseña anterior, si solo desea cambiar el usuario debe dejar en blanco los campos de nueva contraseña.\nDebe repetir la contraseña nueva si desea modificarla, sino no se cambiará la misma.\nSi desea modificar otro dato personal, utilice el otro botón.");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(null);
        jTextArea1.setFocusable(false);
        background_dialog2.add(jTextArea1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 380, 100));

        usuario.setBackground(new Color(0, 0, 0));
        usuario.setFont(new Font("Roboto", 0, 12));
        usuario.setForeground(new Color(0, 0, 0));
        usuario.setText("Usuario anterior *");
        background_dialog2.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jTextField_usuario.setBackground(new Color(255, 255, 255));
        jTextField_usuario.setDocument(new LimitarCamposSeguro(50, "Ingrese su usuario"));
        jTextField_usuario.setFont(new Font("Roboto", 0, 14));
        jTextField_usuario.setForeground(Color.gray);
        jTextField_usuario.setText("Ingrese su usuario");
        jTextField_usuario.setActionCommand("<Not Set>");
        jTextField_usuario.setBorder(null);
        jTextField_usuario.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_usuario, "Ingrese su usuario");
        jTextField_usuario.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                jTextField_usuarioFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                jTextField_usuarioFocusLost(evt);
            }
        });
        jTextField_usuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField_usuarioActionPerformed(evt);
            }
        });
        background_dialog2.add(jTextField_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 380, -1));

        jSeparator8.setForeground(new Color(30, 30, 30));
        background_dialog2.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 380, 21));

        usuario_nuevo.setBackground(new Color(0, 0, 0));
        usuario_nuevo.setFont(new Font("Roboto", 0, 12));
        usuario_nuevo.setForeground(new Color(0, 0, 0));
        usuario_nuevo.setText("Usuario nuevo");
        background_dialog2.add(usuario_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jTextField_usuarioNuevo.setBackground(new Color(255, 255, 255));
        jTextField_usuarioNuevo.setDocument(new LimitarCamposSeguro(50, "Ingrese un usuario nuevo"));
        jTextField_usuarioNuevo.setFont(new Font("Roboto", 0, 14));
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
        background_dialog2.add(jTextField_usuarioNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 380, -1));

        jSeparator14.setForeground(new Color(30, 30, 30));
        background_dialog2.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 380, 21));

        contrasena.setBackground(new Color(0, 0, 0));
        contrasena.setFont(new Font("Roboto", 0, 12));
        contrasena.setForeground(new Color(0, 0, 0));
        contrasena.setText("Contraseña nueva");
        background_dialog2.add(contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        jPasswordField_nueva1.setBackground(new Color(255, 255, 255));
        jPasswordField_nueva1.setDocument(new LimitarCamposSeguro(20, "Ingrese su contraseña"));
        jPasswordField_nueva1.setFont(new Font("Roboto", 0, 14));
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
        background_dialog2.add(jPasswordField_nueva1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 380, -1));

        jSeparator11.setForeground(new Color(30, 30, 30));
        background_dialog2.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 380, 21));

        repetir_contrasena.setBackground(new Color(0, 0, 0));
        repetir_contrasena.setFont(new Font("Roboto", 0, 12));
        repetir_contrasena.setForeground(new Color(0, 0, 0));
        repetir_contrasena.setText("Repetir contraseña nueva *");
        background_dialog2.add(repetir_contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        jPasswordField_nueva2.setBackground(new Color(255, 255, 255));
        jPasswordField_nueva2.setDocument(new LimitarCamposSeguro(20, "Repita su contraseña"));
        jPasswordField_nueva2.setFont(new Font("Roboto", 0, 14));
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
        background_dialog2.add(jPasswordField_nueva2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 380, -1));

        jSeparator7.setForeground(new Color(30, 30, 30));
        background_dialog2.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 380, 21));

        errorMessage2.setFont(new Font("Roboto", 1, 14));
        errorMessage2.setForeground(Color.red);
        errorMessage2.setHorizontalAlignment(SwingConstants.CENTER);
        errorMessage2.setText("Error. ");
        errorMessage2.setHorizontalTextPosition(SwingConstants.CENTER);
        errorMessage2.setVisible(false);
        background_dialog2.add(errorMessage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 430, 440, -1));

        jButton_modificar2.setBackground(new Color(0, 204, 0));
        jButton_modificar2.setFont(new Font("Microsoft YaHei", 0, 12));
        jButton_modificar2.setForeground(new Color(0, 0, 0));
        jButton_modificar2.setText("Modificar");
        jButton_modificar2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_modificar2MouseClicked(evt);
            }
        });
        background_dialog2.add(jButton_modificar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 450, -1, -1));

        jButton_cancelar2.setBackground(new Color(153, 153, 153));
        jButton_cancelar2.setFont(new Font("Microsoft YaHei", 0, 12));
        jButton_cancelar2.setForeground(new Color(0, 0, 0));
        jButton_cancelar2.setText("Cancelar");
        jButton_cancelar2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_cancelar2MouseClicked(evt);
            }
        });
        background_dialog2.add(jButton_cancelar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, -1, -1));

        contrasena_anterior.setBackground(new Color(0, 0, 0));
        contrasena_anterior.setFont(new Font("Roboto", 0, 12));
        contrasena_anterior.setForeground(new Color(0, 0, 0));
        contrasena_anterior.setText("Contraseña anterior *");
        background_dialog2.add(contrasena_anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        jPasswordField_vieja.setBackground(new Color(255, 255, 255));
        jPasswordField_vieja.setDocument(new LimitarCamposSeguro(20, "Ingrese su contraseña"));
        jPasswordField_vieja.setFont(new Font("Roboto", 0, 14));
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
        background_dialog2.add(jPasswordField_vieja, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 380, -1));

        jSeparator13.setForeground(new Color(30, 30, 30));
        background_dialog2.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 380, 21));

        jScrollPane2.setViewportView(background_dialog2);

        GroupLayout jDialog_modificarCredLayout = new GroupLayout(jDialog_modificarCred.getContentPane());
        jDialog_modificarCred.getContentPane().setLayout(jDialog_modificarCredLayout);
        jDialog_modificarCredLayout.setHorizontalGroup(
                jDialog_modificarCredLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2)
        );
        jDialog_modificarCredLayout.setVerticalGroup(
                jDialog_modificarCredLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2)
        );

        jPanel_mostrarTabla.setBackground(new Color(227, 218, 201));
        jPanel_mostrarTabla.setForeground(new Color(227, 218, 201));
        jPanel_mostrarTabla.setPreferredSize(new Dimension(794, 794));
        jPanel_mostrarTabla.setLayout(new BoxLayout(jPanel_mostrarTabla, BoxLayout.Y_AXIS));

        jPanel2.setBackground(new Color(227, 218, 201));
        jPanel2.setMaximumSize(new Dimension(2147483647, 100));
        jPanel2.setPreferredSize(new Dimension(794, 17));
        jPanel2.setLayout(new BorderLayout());

        titulo_contenido1.setBackground(new Color(255, 255, 255));
        titulo_contenido1.setFont(new Font("Roboto", 3, 14));
        titulo_contenido1.setHorizontalAlignment(SwingConstants.CENTER);
        titulo_contenido1.setText("Resultados Obtenidos");
        titulo_contenido1.setHorizontalTextPosition(SwingConstants.CENTER);
        titulo_contenido1.setOpaque(true);
        titulo_contenido1.setPreferredSize(new Dimension(550, 17));
        jPanel2.add(titulo_contenido1, BorderLayout.NORTH);

        jPanel_mostrarTabla.add(jPanel2);

        jScrollPane_Table.setBackground(new Color(227, 218, 201));
        jScrollPane_Table.setForeground(new Color(227, 218, 201));
        jScrollPane_Table.setOpaque(true);
        jScrollPane_Table.setPreferredSize(new Dimension(794, 727));
        jScrollPane_Table.setViewportView(null);

        jTable_Content.setBackground(new Color(227, 218, 201));
        jTable_Content.setFont(new Font("Roboto", 0, 12));
        jTable_Content.setForeground(new Color(0, 0, 0));
        jTable_Content.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        jTable_Content.setMinimumSize(new Dimension(50, 50));
        jTable_Content.setPreferredSize(new Dimension(788, 721));
        jTable_Content.setShowGrid(true);
        jScrollPane_Table.setViewportView(jTable_Content);
        jTable_Content.getAccessibleContext().setAccessibleName("tabla de resultados");

        jPanel_mostrarTabla.add(jScrollPane_Table);

        opcionesTabla.setBackground(new Color(0, 153, 204));
        opcionesTabla.setMaximumSize(new Dimension(32767, 100));
        opcionesTabla.setMinimumSize(new Dimension(780, 44));
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

        jPanel_mostrarTabla.add(opcionesTabla);

        jPanel_preferencias.setBackground(new Color(227, 218, 201));
        jPanel_preferencias.setPreferredSize(new Dimension(794, 794));
        jPanel_preferencias.setLayout(new BoxLayout(jPanel_preferencias, BoxLayout.Y_AXIS));

        icon_preferencias.setIcon(new ImageIcon(getClass().getResource("/images/ajuetes3.png")));
        icon_preferencias.setHorizontalTextPosition(SwingConstants.CENTER);
        icon_preferencias.setPreferredSize(new Dimension(130, 120));
        jPanel_preferencias.add(icon_preferencias);

        titulo3.setFont(new Font("Microsoft YaHei", 1, 24));
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

        jLabel4.setFont(new Font("Roboto", 0, 14));
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

        jLabel1.setFont(new Font("Roboto", 0, 14));
        jLabel1.setForeground(new Color(0, 0, 0));
        jLabel1.setText("Tipo de archivo exportar preferido");
        jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
        jPanel_preferencias.add(jLabel1);

        jComboBox_exportarType.setFont(new Font("Roboto", 0, 14));
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

        jLabel5.setFont(new Font("Roboto", 0, 14));
        jLabel5.setForeground(new Color(0, 0, 0));
        jLabel5.setText("Sede de salud preferida");
        jLabel5.setHorizontalTextPosition(SwingConstants.CENTER);
        jPanel_preferencias.add(jLabel5);

        jComboBox_exportarType1.setFont(new Font("Roboto", 0, 14));
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

        jButton_savePreferences.setFont(new Font("Roboto", 0, 14));
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

        jPanel_soporte.setBackground(new Color(227, 218, 201));
        jPanel_soporte.setPreferredSize(new Dimension(794, 794));
        jPanel_soporte.setLayout(new BorderLayout());

        jLabel10.setFont(new Font("Microsoft YaHei", 1, 18));
        jLabel10.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel10.setText("Preguntas frecuentes ");
        jPanel_soporte.add(jLabel10, BorderLayout.NORTH);

        jPanel5.setBackground(new Color(227, 218, 201));
        jPanel5.setLayout(new GridLayout(3, 10));
        jPanel_soporte.add(jPanel5, BorderLayout.CENTER);
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
                "1. Dar click en el botón \'Modificar datos personales\' o \'Modificar credenciales\' y editar solamente los datos que deseamos modificar.\n"
                        + "Consejos: La cédula de identidad personal debe estar escrito tal cual su documento.\n"
                        + "La fecha de nacimiento debe estar en el formato año - mes - día hora : minutos (la hora y minutos es opcional).\n"
                        + "Si su distrito no se encuentra, puede significar que es nuevo y debe utilizar \'Distrito por registrar\'. Debe informar su distrito y provincia correcta a su médico o sede para corregir.\n"
                        + "El teléfono puede ser celular o fijo y debe estar los números pegados. Si es extranjero o diferente de 507 debe colocar su prefijo y códigos necesarios al inicio.\n"
                        + "Al dar click en el botón \'Actualizar\' se cerrará su sesión y debe ingresar nuevamente con sus credenciales correctas.\n"
                        + "Si olvido su contraseña, deberá cerrar sesión y dar click en \'¿Olvidó su contraseña?\'"));
        jPanel5.revalidate();
        jPanel5.repaint();

        jLabel11.setFont(new Font("Microsoft YaHei", 0, 14));
        jLabel11.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel11.setText("Si su duda no fue resuelta. Contacte al soporte técnico de una sede hospitalaria pública o pregunte a su doctor.");
        jPanel_soporte.add(jLabel11, BorderLayout.SOUTH);

        jDialog_modificarDatos.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jDialog_modificarDatos.setTitle("Programa Vacunas Panamá - Modificar datos personales");
        jDialog_modificarDatos.setModal(true);
        jDialog_modificarDatos.setResizable(false);
        jDialog_modificarDatos.setSize(new Dimension(450, 600));

        jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        background_dialog1.setBackground(new Color(255, 255, 255));
        background_dialog1.setPreferredSize(new Dimension(444, 544));
        background_dialog1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setFont(new Font("Microsoft YaHei", 1, 14));
        titulo.setForeground(new Color(0, 0, 0));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setText("Modificar datos personales");
        background_dialog1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 269, -1));

        indicaciones.setEditable(false);
        indicaciones.setBackground(new Color(255, 255, 255));
        indicaciones.setFont(new Font("Microsoft YaHei", 2, 11));
        indicaciones.setForeground(new Color(102, 102, 102));
        indicaciones.setLineWrap(true);
        indicaciones.setRows(5);
        indicaciones.setText("Indicaciones: Si no desea modificar todo, puede dejarlo en blanco o como esta. Si su cédula o fecha de nacimiento esta errónea, solicita ayuda a su doctor.\n\n");
        indicaciones.setWrapStyleWord(true);
        indicaciones.setBorder(null);
        indicaciones.setFocusable(false);
        indicaciones.setRequestFocusEnabled(false);
        background_dialog1.add(indicaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 390, 50));

        nombre.setBackground(new Color(0, 0, 0));
        nombre.setFont(new Font("Roboto", 0, 12));
        nombre.setForeground(new Color(0, 0, 0));
        nombre.setText("Nombre *");
        background_dialog1.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jTextField_nombre.setBackground(new Color(255, 255, 255));
        jTextField_nombre.setDocument(new LimitarCamposString(50, "Ingrese su nombre"));
        jTextField_nombre.setFont(new Font("Roboto", 0, 14));
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
        background_dialog1.add(jTextField_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 390, -1));

        jSeparator3.setForeground(new Color(30, 30, 30));
        background_dialog1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 390, 21));

        apellido.setBackground(new Color(0, 0, 0));
        apellido.setFont(new Font("Roboto", 0, 12));
        apellido.setForeground(new Color(0, 0, 0));
        apellido.setText("Apellido *");
        background_dialog1.add(apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jTextField_apellido.setBackground(new Color(255, 255, 255));
        jTextField_apellido.setDocument(new LimitarCamposString(50, "Ingrese su apellido"));
        jTextField_apellido.setFont(new Font("Roboto", 0, 14));
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
        background_dialog1.add(jTextField_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 390, -1));

        jSeparator4.setForeground(new Color(30, 30, 30));
        background_dialog1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 390, 21));

        cedula.setBackground(new Color(0, 0, 0));
        cedula.setFont(new Font("Roboto", 0, 12));
        cedula.setForeground(new Color(0, 0, 0));
        cedula.setText("Cédula *");
        background_dialog1.add(cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jTextField_cedula.setEditable(false);
        jTextField_cedula.setBackground(new Color(255, 255, 255));
        jTextField_cedula.setFont(new Font("Roboto", 0, 14));
        jTextField_cedula.setForeground(Color.gray);
        jTextField_cedula.setText("Ingrese su cédula");
        jTextField_cedula.setBorder(null);
        jTextField_cedula.setMaximumSize(new Dimension(2147483647, 50));
        jTextField_cedula.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField_cedulaActionPerformed(evt);
            }
        });
        background_dialog1.add(jTextField_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 390, -1));

        jSeparator5.setForeground(new Color(30, 30, 30));
        background_dialog1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 390, 21));

        fecha_nacimiento.setBackground(new Color(0, 0, 0));
        fecha_nacimiento.setFont(new Font("Roboto", 0, 12));
        fecha_nacimiento.setForeground(new Color(0, 0, 0));
        fecha_nacimiento.setText("Fecha de nacimiento *");
        background_dialog1.add(fecha_nacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jTextField_fechaNacimiento.setEditable(false);
        jTextField_fechaNacimiento.setBackground(new Color(255, 255, 255));
        jTextField_fechaNacimiento.setFont(new Font("Roboto", 0, 14));
        jTextField_fechaNacimiento.setForeground(Color.gray);
        jTextField_fechaNacimiento.setText("Ingrese su fecha de nacimiento YYYY-MM-DD hh:mm:ss");
        jTextField_fechaNacimiento.setBorder(null);
        jTextField_fechaNacimiento.setMaximumSize(new Dimension(2147483647, 50));
        jTextField_fechaNacimiento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField_fechaNacimientoActionPerformed(evt);
            }
        });
        background_dialog1.add(jTextField_fechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 390, -1));

        jSeparator9.setForeground(new Color(30, 30, 30));
        background_dialog1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 390, 21));

        sexo.setBackground(new Color(0, 0, 0));
        sexo.setFont(new Font("Roboto", 0, 12));
        sexo.setForeground(new Color(0, 0, 0));
        sexo.setText("sexo *");
        background_dialog1.add(sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        jComboBox_sexo.setBackground(Color.gray);
        jComboBox_sexo.setFont(new Font("Roboto", 0, 14));
        jComboBox_sexo.setForeground(Color.black);
        jComboBox_sexo.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir", "Masculino", "Feminino"}));
        background_dialog1.add(jComboBox_sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 308, 170, -1));

        direccion.setBackground(new Color(0, 0, 0));
        direccion.setFont(new Font("Roboto", 0, 12));
        direccion.setForeground(new Color(0, 0, 0));
        direccion.setText("Dirección");
        background_dialog1.add(direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        jTextField_direccion.setBackground(new Color(255, 255, 255));
        jTextField_direccion.setDocument(new LimitarCamposAlpha(100, "Ingrese su dirección"));
        jTextField_direccion.setFont(new Font("Roboto", 0, 14));
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
        background_dialog1.add(jTextField_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 190, -1));

        distrito.setBackground(new Color(0, 0, 0));
        distrito.setFont(new Font("Roboto", 0, 12));
        distrito.setForeground(new Color(0, 0, 0));
        distrito.setText("Distrito");
        background_dialog1.add(distrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 50, -1));

        jComboBox_distrito.setBackground(Color.gray);
        jComboBox_distrito.setFont(new Font("Roboto", 0, 14));
        jComboBox_distrito.setForeground(Color.black);
        jComboBox_distrito.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir", "Distrito por registrar"}));
        background_dialog1.add(jComboBox_distrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 356, 190, -1));

        jSeparator10.setForeground(new Color(30, 30, 30));
        background_dialog1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 190, 21));

        correo.setBackground(new Color(0, 0, 0));
        correo.setFont(new Font("Roboto", 0, 12));
        correo.setForeground(new Color(0, 0, 0));
        correo.setText("Correo electrónico");
        background_dialog1.add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        jTextField_correo.setBackground(new Color(255, 255, 255));
        jTextField_correo.setDocument(new LimitarCamposEmail(50, "Ingrese su correo electrónico"));
        jTextField_correo.setFont(new Font("Roboto", 0, 14));
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
        background_dialog1.add(jTextField_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 390, -1));

        jSeparator6.setForeground(new Color(30, 30, 30));
        background_dialog1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 390, 21));

        jTextField_telefono.setBackground(new Color(255, 255, 255));
        jTextField_telefono.setDocument(new LimitarCamposNumeric(15, "Ingrese su teléfono"));
        jTextField_telefono.setFont(new Font("Roboto", 0, 14));
        jTextField_telefono.setForeground(Color.gray);
        jTextField_telefono.setText("Ingrese su teléfono");
        jTextField_telefono.setBorder(null);
        jTextField_telefono.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_telefono, "Ingrese su teléfono");
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
        background_dialog1.add(jTextField_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 390, -1));

        telefono.setBackground(new Color(0, 0, 0));
        telefono.setFont(new Font("Roboto", 0, 12));
        telefono.setForeground(new Color(0, 0, 0));
        telefono.setText("Teléfono ");
        background_dialog1.add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        jSeparator12.setForeground(new Color(30, 30, 30));
        background_dialog1.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 390, 21));

        errorMessage.setFont(new Font("Roboto", 1, 14));
        errorMessage.setForeground(Color.red);
        errorMessage.setHorizontalAlignment(SwingConstants.CENTER);
        errorMessage.setText("ERROR.");
        errorMessage.setVisible(false);
        background_dialog1.add(errorMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 390, -1));

        jButton_cancelar.setBackground(new Color(153, 153, 153));
        jButton_cancelar.setFont(new Font("Microsoft YaHei", 0, 12));
        jButton_cancelar.setForeground(new Color(0, 0, 0));
        jButton_cancelar.setText("Cancelar");
        jButton_cancelar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_cancelarMouseClicked(evt);
            }
        });
        background_dialog1.add(jButton_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 510, -1, -1));

        jButton_modificar.setBackground(new Color(0, 204, 0));
        jButton_modificar.setFont(new Font("Microsoft YaHei", 0, 12));
        jButton_modificar.setForeground(new Color(0, 0, 0));
        jButton_modificar.setText("Modificar");
        jButton_modificar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_modificarMouseClicked(evt);
            }
        });
        background_dialog1.add(jButton_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 510, -1, -1));

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

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Programa Vacunas Panamá");
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
        jPanel_menuOpciones.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));

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

        separador3.setBackground(new Color(39, 104, 165));
        separador3.setForeground(new Color(48, 48, 46));
        separador3.setPreferredSize(new Dimension(150, 20));

        GroupLayout separador3Layout = new GroupLayout(separador3);
        separador3.setLayout(separador3Layout);
        separador3Layout.setHorizontalGroup(
                separador3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        separador3Layout.setVerticalGroup(
                separador3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel_menuOpciones.add(separador3);

        rolName.setFont(new Font("Microsoft YaHei", 0, 12));
        rolName.setForeground(new Color(255, 255, 255));
        rolName.setHorizontalAlignment(SwingConstants.CENTER);
        rolName.setText("¡ Hola Rol !");
        rolName.setAlignmentX(1.0F);
        rolName.setHorizontalTextPosition(SwingConstants.CENTER);
        rolName.setPreferredSize(new Dimension(170, 30));
        jPanel_menuOpciones.add(rolName);

        nombreBienvenida.setFont(new Font("Microsoft YaHei", 0, 12));
        nombreBienvenida.setForeground(new Color(255, 255, 255));
        nombreBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
        nombreBienvenida.setText("Nombre");
        nombreBienvenida.setAlignmentX(1.0F);
        nombreBienvenida.setHorizontalTextPosition(SwingConstants.CENTER);
        nombreBienvenida.setPreferredSize(new Dimension(150, 30));
        jPanel_menuOpciones.add(nombreBienvenida);

        separador2.setBackground(new Color(39, 104, 165));
        separador2.setForeground(new Color(48, 48, 46));
        separador2.setPreferredSize(new Dimension(150, 20));

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

        button_opcion1.setForeground(new Color(255, 255, 255));
        button_opcion1.setText("Opción 1 Tabla");
        button_opcion1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button_opcion1.setPreferredSize(new Dimension(160, 30));
        button_opcion1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                button_opcion1MouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_opcion1);

        button_opcion2.setForeground(new Color(255, 255, 255));
        button_opcion2.setText("Opción 2");
        button_opcion2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button_opcion2.setPreferredSize(new Dimension(160, 30));
        jPanel_menuOpciones.add(button_opcion2);

        button_opcion3.setForeground(new Color(255, 255, 255));
        button_opcion3.setText("Opción 3");
        button_opcion3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button_opcion3.setPreferredSize(new Dimension(160, 30));
        jPanel_menuOpciones.add(button_opcion3);

        button_opcion4.setForeground(new Color(255, 255, 255));
        button_opcion4.setText("Opción 4");
        button_opcion4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button_opcion4.setPreferredSize(new Dimension(160, 30));
        jPanel_menuOpciones.add(button_opcion4);

        button_opcion5.setForeground(new Color(255, 255, 255));
        button_opcion5.setText("Opción 5");
        button_opcion5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button_opcion5.setPreferredSize(new Dimension(160, 30));
        jPanel_menuOpciones.add(button_opcion5);

        separador4.setBackground(new Color(39, 104, 165));
        separador4.setForeground(new Color(48, 48, 46));
        separador4.setPreferredSize(new Dimension(150, 20));

        GroupLayout separador4Layout = new GroupLayout(separador4);
        separador4.setLayout(separador4Layout);
        separador4Layout.setHorizontalGroup(
                separador4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        separador4Layout.setVerticalGroup(
                separador4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel_menuOpciones.add(separador4);

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

        jLabel6.setFont(new Font("Microsoft YaHei", 1, 20));
        jLabel6.setForeground(new Color(102, 102, 102));
        jLabel6.setText("Bienvenido al Programa Vacunas Panamá");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 566, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(227, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(752, Short.MAX_VALUE))
        );

        jPanel_derecho.add(jPanel1, "vacio");

        background.add(jPanel_derecho, BorderLayout.CENTER);

        jScrollPane3.setViewportView(background);

        getContentPane().add(jScrollPane3, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void formComponentShown(ComponentEvent evt) {
        Login.setImageLabal(icon_project, "src/images/operacionVacunas_Logo.png");
    }

    private void formWindowClosing(WindowEvent evt) {
        int confirm = JOptionPane.showConfirmDialog(null, "¿Esta seguro de cerrar sesión?", "Cerrando sesión y ventana...", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (confirm == 0) {
            parentFrame = new Login();
            parentFrame.setVisible(true);
            parentFrame.requestFocus();
            this.dispose();
        }
    }

    /* eventos del menú lateral */
    private void button_logOutMouseClicked(MouseEvent evt) {
        formWindowClosing(null);
    }

    private void button_modificarDatosMouseClicked(MouseEvent evt) {
        jDialog_modificarDatos.setLocationRelativeTo(this);
        jDialog_modificarDatos.setVisible(true);
    }

    private void button_modificarCredMouseClicked(MouseEvent evt) {
        jDialog_modificarCred.setLocationRelativeTo(this);
        jDialog_modificarCred.setVisible(true);
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

    private void button_opcion1MouseClicked(MouseEvent evt) {
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

    private void button_soporteMouseClicked(MouseEvent evt) {
        if (!jPanel_derecho.isAncestorOf(jPanel_soporte)) {
            jPanel_derecho.add(jPanel_soporte, "soporte");
        }
        if (mostrando == jPanel_soporte) {
            layout.show(jPanel_derecho, "vacio");
            mostrando = jPanel1;
        } else {
            layout.show(jPanel_derecho, "soporte");
            mostrando = jPanel_soporte;
        }
        jPanel_derecho.revalidate();
        jPanel_derecho.repaint();
    }

    /* eventos del jPanel mostrar tabla option 1*/
    private void jButton_acercarMouseClicked(MouseEvent evt) {
        Font currentFont = jTable_Content.getFont();
        jTable_Content.setFont(currentFont.deriveFont(currentFont.getSize() + 2f));
    }

    private void jButton_alejarMouseClicked(MouseEvent evt) {
        Font currentFont = jTable_Content.getFont();
        jTable_Content.setFont(currentFont.deriveFont(currentFont.getSize() - 2f));
    }

    private void jButton_fuenteMouseClicked(MouseEvent evt) {
        JFontChooser fontChooser = new JFontChooser(this);
        boolean result = fontChooser.showDialog(this);
        if (result) {
            Font font = fontChooser.getSelectedFont();
            jTable_Content.setFont(font);
            jTable_Content.repaint();
        }
    }

    private void jButton_exportarMouseClicked(MouseEvent evt) {
        /* TODO llamada al método exportar en csv o excel o pdf de option 1 */
    }

    /* eventos jDialog modificar credenciales del usuario */
    private void jTextField_usuarioFocusGained(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_usuario, "Ingrese su usuario");
    }

    private void jTextField_usuarioFocusLost(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_usuario, "Ingrese su usuario");
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

    private void jButton_cancelar2MouseClicked(MouseEvent evt) {
        jDialog_modificarCred.dispose();
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

    private void jTextField_usuarioActionPerformed(ActionEvent evt) {
        jTextField_usuarioNuevo.requestFocus();
    }

    private void jPasswordField_viejaFocusGained(FocusEvent evt) {
        RegistrarUser.handleFocusPassword(jPasswordField_vieja, "Ingrese su contraseña");
    }

    private void jPasswordField_viejaFocusLost(FocusEvent evt) {
        RegistrarUser.handleFocusPassword(jPasswordField_vieja, "Ingrese su contraseña");
    }

    private void jPasswordField_viejaActionPerformed(ActionEvent evt) {
        jPasswordField_nueva1.requestFocus();
    }

    /* eventos de tabla option 1 */
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
        if (!jPanel_mostrarTabla.isAncestorOf(jPanel_filtrar)) {
            jPanel_mostrarTabla.add(jPanel_filtrar, BorderLayout.NORTH);
        } else {
            jPanel_mostrarTabla.remove(jPanel_filtrar);
        }
        jPanel_mostrarTabla.revalidate();
        jPanel_mostrarTabla.repaint();
    }

    private void jButton_ordenarMouseClicked(MouseEvent evt) {
        jTable_Content.setAutoCreateRowSorter(true);
    }

    private void jButton_savePreferencesMouseClicked(MouseEvent evt) {
        /* TODO implementar lógica de guardar preferencias del usuario*/
    }

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
        RegistrarUser.handleFocusGain(jTextField_telefono, "Ingrese su teléfono");
    }

    private void jTextField_telefonoFocusLost(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_telefono, "Ingrese su teléfono");
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
                errorMessage.setText("Error. La dirección o el distrito están incompletos. Debe llenar ambos o ninguno.");
                errorMessage.setVisible(true);
                return;
            } else {
                if (!condicionOp2 && !condicionOp3) {
                    if (!condicionOp4) {
                        /* manipular todos los datos MENOS el teléfono y el sexo*/
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

    private void jTextField_usuarioNuevoFocusGained(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_usuarioNuevo, "Ingrese un usuario nuevo");
    }

    private void jTextField_usuarioNuevoFocusLost(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_usuarioNuevo, "Ingrese un usuario nuevo");
    }

    private void jTextField_usuarioNuevoActionPerformed(ActionEvent evt) {
        jPasswordField_vieja.requestFocus();
    }

    /* método para colocar el nombre al iniciar sesión */
    public void setBienvenida(String nombre, String cedula) {
        this.nombreBienvenida.setText(nombre);
        cedulaUsuarioActual = cedula;
    }

    public static void agregarDatosATabla(JTable tabla, String[] columnas, Object[][] data) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();

        model.setColumnIdentifiers(columnas);

        for (Object[] row : data) {
            model.addRow(row);
        }
    }

    /* método static para crear FAQ con estilo moderno */
    public static JPanel createQuestionPanel(String question, String answer) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(new Color(227, 218, 201));

        JButton questionButton = new JButton(question);
        questionButton.setUI(new BasicButtonUI());
        questionButton.setBackground(Color.LIGHT_GRAY);
        JTextArea answerArea = new JTextArea(answer, 5, 30);
        answerArea.setLineWrap(true);
        answerArea.setWrapStyleWord(true);
        answerArea.setEditable(false);
        answerArea.setVisible(false);

        questionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerArea.setVisible(!answerArea.isVisible());
                panel.revalidate();
            }
        });

        panel.add(questionButton, BorderLayout.NORTH);
        panel.add(answerArea, BorderLayout.CENTER);

        return panel;
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
            java.util.logging.Logger.getLogger(PantallaBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PantallaBase(new Login()).setVisible(true);
            }
        });
    }

    /* variables propias */
    private static JFrame parentFrame;
    private static CardLayout layout = null;
    private Component mostrando = null;
    private final JTableFiltrar jPanel_filtrar;
    private String cedulaUsuarioActual;

    // Variables declaration - do not modify
    private JLabel apellido;
    private JPanel background;
    private JPanel background_dialog1;
    private JPanel background_dialog2;
    private JButton button_logOut;
    private JButton button_modificarCred;
    private JButton button_modificarDatos;
    private JButton button_opcion1;
    private JButton button_opcion2;
    private JButton button_opcion3;
    private JButton button_opcion4;
    private JButton button_opcion5;
    private JButton button_preferencias;
    private JButton button_soporte;
    private JLabel cedula;
    private JLabel contrasena;
    private JLabel contrasena_anterior;
    private JLabel correo;
    private JLabel direccion;
    private JLabel distrito;
    private JLabel errorMessage;
    private JLabel errorMessage2;
    private JLabel fecha_nacimiento;
    private JLabel icon_preferencias;
    private JLabel icon_project;
    private JTextArea indicaciones;
    private JButton jButton_acercar;
    private JButton jButton_alejar;
    private JButton jButton_buscar;
    private JButton jButton_cancelar;
    private JButton jButton_cancelar2;
    private JButton jButton_exportar;
    private JButton jButton_filtros;
    private JButton jButton_fuente;
    private JButton jButton_modificar;
    private JButton jButton_modificar2;
    private JButton jButton_ordenar;
    private JButton jButton_savePreferences;
    private JComboBox<String> jComboBox_distrito;
    private JComboBox<String> jComboBox_exportarType;
    private JComboBox<String> jComboBox_exportarType1;
    private JComboBox<String> jComboBox_sexo;
    private JDialog jDialog_modificarCred;
    private JDialog jDialog_modificarDatos;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel5;
    private JPanel jPanel_derecho;
    private JPanel jPanel_fontChooser;
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
    private JScrollPane jScrollPane_Table;
    private JSeparator jSeparator10;
    private JSeparator jSeparator11;
    private JSeparator jSeparator12;
    private JSeparator jSeparator13;
    private JSeparator jSeparator14;
    private JSeparator jSeparator3;
    private JSeparator jSeparator4;
    private JSeparator jSeparator5;
    private JSeparator jSeparator6;
    private JSeparator jSeparator7;
    private JSeparator jSeparator8;
    private JSeparator jSeparator9;
    private JTable jTable_Content;
    private JTextArea jTextArea1;
    private JTextField jTextField_apellido;
    private JTextField jTextField_buscarTabla;
    private JTextField jTextField_cedula;
    private JTextField jTextField_correo;
    private JTextField jTextField_direccion;
    private JTextField jTextField_fechaNacimiento;
    private JTextField jTextField_nombre;
    private JTextField jTextField_telefono;
    private JTextField jTextField_usuario;
    private JTextField jTextField_usuarioNuevo;
    private JLabel nombre;
    private JLabel nombreBienvenida;
    private JPanel opcionesTabla;
    private JLabel repetir_contrasena;
    private JLabel rolName;
    private JPanel separador1;
    private JPanel separador2;
    private JPanel separador3;
    private JPanel separador4;
    private JLabel sexo;
    private JLabel telefono;
    private JLabel titulo;
    private JLabel titulo2;
    private JLabel titulo3;
    private JLabel titulo_contenido1;
    private JLabel usuario;
    private JLabel usuario_nuevo;
    // End of variables declaration
}
