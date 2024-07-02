package InterfazDesktop;

import Logica.Validations.InicioSesion;
import Logica.Validations.Usuario;
import Validations.LimitarCamposCedula;
import Validations.LimitarCamposSeguro;
import Validations.LimitarCamposFecha;
import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        InicioSesion is = new InicioSesion();

        addRoleButtonListeners();
    }

    private void initComponents() {
        jFrame_restaurarAcceso = new javax.swing.JFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        background1 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        icon_project1 = new javax.swing.JLabel();
        mensaje_validar = new javax.swing.JLabel();
        rolRestaurar = new javax.swing.JLabel();
        jComboBox_rol = new javax.swing.JComboBox<>();
        jTextField_cedula = new javax.swing.JTextField();
        cedula = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        fecha_nacimiento = new javax.swing.JLabel();
        jTextField_fechaNacimiento = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        acceptTerms = new javax.swing.JCheckBox();
        button_validar = new javax.swing.JLabel();
        mensaje_hola = new javax.swing.JLabel();
        respuesta = new javax.swing.JLabel();
        usuario = new javax.swing.JLabel();
        jTextField_usuario = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        contraseña = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jSeparator7 = new javax.swing.JSeparator();
        errorMessage = new javax.swing.JLabel();
        button_registrarse1 = new javax.swing.JLabel();
        mensaje3 = new javax.swing.JLabel();
        mensaje4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        background = new javax.swing.JPanel();
        icon_project = new javax.swing.JLabel();
        jPanel_background_loginForm = new javax.swing.JPanel();
        bienvenido = new javax.swing.JLabel();
        elija_su_rol = new javax.swing.JLabel();
        userInput = new javax.swing.JTextField();
        passwordInput = new javax.swing.JPasswordField();
        jPanel_pacienteBotton = new javax.swing.JPanel();
        paciente = new javax.swing.JLabel();
        paciente_icon = new javax.swing.JLabel();
        jPanel_doctorBotton = new javax.swing.JPanel();
        doctor = new javax.swing.JLabel();
        doctor_icon = new javax.swing.JLabel();
        jPanel_proveedorBotton = new javax.swing.JPanel();
        proveedor = new javax.swing.JLabel();
        proveedor_icon = new javax.swing.JLabel();
        jPanel_administrativoBotton = new javax.swing.JPanel();
        administrativo = new javax.swing.JLabel();
        administrativo_icon = new javax.swing.JLabel();
        jPanel_autoridadBotton = new javax.swing.JPanel();
        autoridad = new javax.swing.JLabel();
        autoridad_icon = new javax.swing.JLabel();
        mensaje_error = new javax.swing.JPanel();
        mensaje = new javax.swing.JLabel();
        jPanel_loginBotton = new javax.swing.JPanel();
        iniciarSesion = new javax.swing.JLabel();
        mensaje_restaurar = new javax.swing.JLabel();
        mensaje2 = new javax.swing.JLabel();
        mensaje1 = new javax.swing.JLabel();
        jPanelOculto = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jFrame_restaurarAcceso.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        jFrame_restaurarAcceso.setTitle("Programa Vacunas Panamá - Restaurar acceso");
        jFrame_restaurarAcceso.setResizable(false);
        jFrame_restaurarAcceso.setSize(new java.awt.Dimension(600, 650));
        jFrame_restaurarAcceso.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                jFrame_restaurarAccesoWindowClosing(evt);
            }
        });
        jFrame_restaurarAcceso.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setPreferredSize(new java.awt.Dimension(600, 600));

        background1.setBackground(new java.awt.Color(255, 255, 255));
        background1.setPreferredSize(new java.awt.Dimension(594, 594));
        background1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setFont(new java.awt.Font("Microsoft YaHei", 1, 16)); 
        titulo.setForeground(new java.awt.Color(0, 0, 0));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Restaurar acceso al Programa Vacunas Panamá");
        background1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 510, -1));

        icon_project1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/operacionVacunas_logo.png"))); 
        icon_project1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                icon_project1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        background1.add(icon_project1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 110, 80));

        mensaje_validar.setFont(new java.awt.Font("Roboto", 2, 14)); 
        mensaje_validar.setForeground(new java.awt.Color(0, 0, 0));
        mensaje_validar.setText("Validar sus datos personales");
        background1.add(mensaje_validar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 180, -1));

        rolRestaurar.setFont(new java.awt.Font("Roboto", 0, 12)); 
        rolRestaurar.setForeground(java.awt.Color.black);
        rolRestaurar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rolRestaurar.setText("Rol en el programa*");
        background1.add(rolRestaurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 120, -1));

        jComboBox_rol.setBackground(java.awt.Color.gray);
        jComboBox_rol.setFont(new java.awt.Font("Roboto", 0, 14)); 
        jComboBox_rol.setForeground(java.awt.Color.black);
        jComboBox_rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir", "Paciente", "Doctor - Enfermera", "Proveedor", "Administrativo", "Autoridad" }));
        background1.add(jComboBox_rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 170, -1));

        jTextField_cedula.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_cedula.setDocument(new LimitarCamposCedula(15, "Ingrese su cédula"));
        jTextField_cedula.setFont(new java.awt.Font("Roboto", 0, 14)); 
        jTextField_cedula.setForeground(java.awt.Color.gray);
        jTextField_cedula.setText("Ingrese su cédula");
        jTextField_cedula.setBorder(null);
        jTextField_cedula.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_cedula, "Ingrese su cédula");
        jTextField_cedula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_cedulaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_cedulaFocusLost(evt);
            }
        });
        jTextField_cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_cedulaActionPerformed(evt);
            }
        });
        background1.add(jTextField_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 540, -1));

        cedula.setBackground(new java.awt.Color(0, 0, 0));
        cedula.setFont(new java.awt.Font("Roboto", 0, 12)); 
        cedula.setForeground(new java.awt.Color(0, 0, 0));
        cedula.setText("Cédula *");
        background1.add(cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jSeparator5.setForeground(new java.awt.Color(30, 30, 30));
        background1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 540, 21));

        fecha_nacimiento.setBackground(new java.awt.Color(0, 0, 0));
        fecha_nacimiento.setFont(new java.awt.Font("Roboto", 0, 12)); 
        fecha_nacimiento.setForeground(new java.awt.Color(0, 0, 0));
        fecha_nacimiento.setText("Fecha de nacimiento *");
        background1.add(fecha_nacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jTextField_fechaNacimiento.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_fechaNacimiento.setDocument(new LimitarCamposFecha(19, "Ingrese su fecha de nacimiento YYYY-MM-DD hh:mm:ss"));
        jTextField_fechaNacimiento.setFont(new java.awt.Font("Roboto", 0, 14)); 
        jTextField_fechaNacimiento.setForeground(java.awt.Color.gray);
        jTextField_fechaNacimiento.setText("Ingrese su fecha de nacimiento YYYY-MM-DD hh:mm:ss");
        jTextField_fechaNacimiento.setBorder(null);
        jTextField_fechaNacimiento.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_fechaNacimiento, "Ingrese su fecha de nacimiento YYYY-MM-DD hh:mm:ss");
        jTextField_fechaNacimiento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_fechaNacimientoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_fechaNacimientoFocusLost(evt);
            }
        });
        jTextField_fechaNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_fechaNacimientoActionPerformed(evt);
            }
        });
        background1.add(jTextField_fechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 540, -1));

        jSeparator9.setForeground(new java.awt.Color(30, 30, 30));
        background1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 540, 21));

        acceptTerms.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); 
        acceptTerms.setForeground(new java.awt.Color(102, 102, 102));
        acceptTerms.setText("Al usar este formulario usted declara estar autorizado y da su consentimiento para validar.");
        acceptTerms.setToolTipText("Aceptar términos y condiciones");
        acceptTerms.setBorder(null);
        acceptTerms.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        acceptTerms.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        acceptTerms.setMaximumSize(new java.awt.Dimension(600, 20));
        background1.add(acceptTerms, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 540, 20));

        button_validar.setBackground(new java.awt.Color(0, 204, 51));
        button_validar.setFont(new java.awt.Font("Roboto", 0, 12)); 
        button_validar.setForeground(new java.awt.Color(0, 0, 0));
        button_validar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button_validar.setText("Validar sus datos");
        button_validar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_validar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        button_validar.setMaximumSize(new java.awt.Dimension(600, 30));
        button_validar.setOpaque(true);
        button_validar.setPreferredSize(new java.awt.Dimension(94, 20));
        button_validar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_validarMouseClicked(evt);
            }
        });
        background1.add(button_validar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 300, -1));

        mensaje_hola.setFont(new java.awt.Font("Roboto", 2, 14)); 
        mensaje_hola.setForeground(new java.awt.Color(0, 0, 0));
        mensaje_hola.setText("Hola!");
        mensaje_hola.setVisible(false);
        background1.add(mensaje_hola, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 140, -1));

        respuesta.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); 
        respuesta.setForeground(new java.awt.Color(0, 0, 0));
        respuesta.setText("Respuesta nombre - rol");
        respuesta.setVisible(false);
        background1.add(respuesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 540, -1));

        usuario.setBackground(new java.awt.Color(0, 0, 0));
        usuario.setFont(new java.awt.Font("Roboto", 0, 12)); 
        usuario.setForeground(new java.awt.Color(0, 0, 0));
        usuario.setText("Usuario *");
        usuario.setVisible(false);
        background1.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        jTextField_usuario.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_usuario.setDocument(new LimitarCamposSeguro(50, "Ingrese un usuario"));
        jTextField_usuario.setFont(new java.awt.Font("Roboto", 0, 14)); 
        jTextField_usuario.setForeground(java.awt.Color.gray);
        jTextField_usuario.setText("Ingrese un usuario");
        jTextField_usuario.setActionCommand("<Not Set>");
        jTextField_usuario.setBorder(null);
        jTextField_usuario.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_usuario, "Ingrese un usuario");
        jTextField_usuario.setVisible(false);
        jTextField_usuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_usuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_usuarioFocusLost(evt);
            }
        });
        jTextField_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_usuarioActionPerformed(evt);
            }
        });
        background1.add(jTextField_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 540, -1));

        jSeparator8.setForeground(new java.awt.Color(30, 30, 30));
        jSeparator8.setVisible(false);
        background1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 540, 21));

        contraseña.setBackground(new java.awt.Color(0, 0, 0));
        contraseña.setFont(new java.awt.Font("Roboto", 0, 12)); 
        contraseña.setForeground(new java.awt.Color(0, 0, 0));
        contraseña.setText("Contraseña *");
        contraseña.setVisible(false);
        background1.add(contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        jPasswordField.setBackground(new java.awt.Color(255, 255, 255));
        jPasswordField.setDocument(new LimitarCamposSeguro(20, "Ingrese una contraseña"));
        jPasswordField.setFont(new java.awt.Font("Roboto", 0, 14)); 
        jPasswordField.setForeground(java.awt.Color.gray);
        jPasswordField.setText("Ingrese una contraseña");
        jPasswordField.setBorder(null);
        jPasswordField.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jPasswordField, "Ingrese una contraseña");
        jPasswordField.setVisible(false);
        jPasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordFieldFocusLost(evt);
            }
        });
        jPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldActionPerformed(evt);
            }
        });
        background1.add(jPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 540, -1));

        jSeparator7.setForeground(new java.awt.Color(30, 30, 30));
        jSeparator7.setVisible(false);
        background1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 540, 21));

        errorMessage.setFont(new java.awt.Font("Roboto", 1, 14)); 
        errorMessage.setForeground(java.awt.Color.red);
        errorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorMessage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        errorMessage.setText("Error. ");
        errorMessage.setVisible(false);
        background1.add(errorMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 370, 590, -1));

        button_registrarse1.setBackground(new java.awt.Color(0, 204, 51));
        button_registrarse1.setFont(new java.awt.Font("Roboto", 0, 12)); 
        button_registrarse1.setForeground(new java.awt.Color(0, 0, 0));
        button_registrarse1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button_registrarse1.setText("Restaurar credenciales");
        button_registrarse1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_registrarse1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        button_registrarse1.setMaximumSize(new java.awt.Dimension(600, 30));
        button_registrarse1.setOpaque(true);
        button_registrarse1.setPreferredSize(new java.awt.Dimension(94, 20));
        button_registrarse1.setVisible(false);
        button_registrarse1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_registrarse1MouseClicked(evt);
            }
        });
        background1.add(button_registrarse1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 520, 300, -1));

        mensaje3.setBackground(java.awt.Color.white);
        mensaje3.setFont(new java.awt.Font("Roboto", 1, 14)); 
        mensaje3.setForeground(new java.awt.Color(0, 0, 102));
        mensaje3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mensaje3.setText("Iniciar sesión");
        mensaje3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mensaje3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mensaje3.setOpaque(true);
        mensaje3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mensaje3iniciarSesionMouseClicked(evt);
            }
        });
        background1.add(mensaje3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 560, 110, 20));

        mensaje4.setBackground(java.awt.Color.white);
        mensaje4.setFont(new java.awt.Font("Roboto", 1, 14)); 
        mensaje4.setForeground(new java.awt.Color(0, 0, 0));
        mensaje4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mensaje4.setText("¿Ya estás registrado?");
        mensaje4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mensaje4.setOpaque(true);
        background1.add(mensaje4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 150, 20));

        jScrollPane2.setViewportView(background1);

        jFrame_restaurarAcceso.getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login - MINSA");
        setLocationByPlatform(true);
        setSize(new java.awt.Dimension(900, 620));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jScrollPane1.setPreferredSize(getSize());

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setMinimumSize(new java.awt.Dimension(900, 600));
        background.setPreferredSize(new java.awt.Dimension(894, 614));
        background.setLayout(new java.awt.BorderLayout());

        icon_project.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon_project.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/operacionVacunas_logo.png"))); 
        icon_project.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        icon_project.setPreferredSize(new java.awt.Dimension(400, 600));
        background.add(icon_project, java.awt.BorderLayout.CENTER);

        jPanel_background_loginForm.setBackground(new java.awt.Color(153, 204, 255));
        jPanel_background_loginForm.setPreferredSize(new java.awt.Dimension(400, 600));
        jPanel_background_loginForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bienvenido.setBackground(new java.awt.Color(0, 0, 0));
        bienvenido.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); 
        bienvenido.setForeground(new java.awt.Color(0, 0, 0));
        bienvenido.setText("!Bienvenido!");
        jPanel_background_loginForm.add(bienvenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        elija_su_rol.setBackground(new java.awt.Color(153, 153, 153));
        elija_su_rol.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); 
        elija_su_rol.setForeground(new java.awt.Color(102, 102, 102));
        elija_su_rol.setText("Elija su rol");
        jPanel_background_loginForm.add(elija_su_rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));

        userInput.setDocument(new LimitarCamposSeguro(50, "Ingrese su usuario"));
        userInput.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); 
        userInput.setForeground(java.awt.Color.gray);
        userInput.setText("Ingrese su usuario");
        userInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                userInputFocusLost(evt);
            }
        });
        userInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userInputActionPerformed(evt);
            }
        });
        jPanel_background_loginForm.add(userInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 240, -1));
        RegistrarUser.handleFocusGain(userInput, "Ingrese su usuario");  
        userInput.setVisible(false);

        passwordInput.setDocument(new LimitarCamposSeguro(20, "Ingrese su contraseña"));
        passwordInput.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); 
        passwordInput.setForeground(java.awt.Color.gray);
        passwordInput.setText("Ingrese su contraseña");
        passwordInput.setToolTipText("");
        passwordInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordInputFocusLost(evt);
            }
        });
        passwordInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordInputActionPerformed(evt);
            }
        });
        jPanel_background_loginForm.add(passwordInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 240, -1));
        RegistrarUser.handleFocusGain(passwordInput, "Ingrese su contraseña");  
        passwordInput.setVisible(false);

        jPanel_pacienteBotton.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_pacienteBotton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel_pacienteBotton.setPreferredSize(new java.awt.Dimension(130, 40));

        paciente.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); 
        paciente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        paciente.setText("Paciente");
        paciente.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        paciente.setPreferredSize(new java.awt.Dimension(83, 17));

        paciente_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/patient_icon.png"))); 

        javax.swing.GroupLayout jPanel_pacienteBottonLayout = new javax.swing.GroupLayout(jPanel_pacienteBotton);
        jPanel_pacienteBotton.setLayout(jPanel_pacienteBottonLayout);
        jPanel_pacienteBottonLayout.setHorizontalGroup(
            jPanel_pacienteBottonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_pacienteBottonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paciente_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_pacienteBottonLayout.setVerticalGroup(
            jPanel_pacienteBottonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_pacienteBottonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_pacienteBottonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(paciente_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_background_loginForm.add(jPanel_pacienteBotton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 170, -1));

        jPanel_doctorBotton.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_doctorBotton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel_doctorBotton.setPreferredSize(new java.awt.Dimension(130, 40));

        doctor.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); 
        doctor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        doctor.setText("Doctor - Enfermera");
        doctor.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        doctor.setPreferredSize(new java.awt.Dimension(83, 17));

        doctor_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/patient_icon.png"))); 

        javax.swing.GroupLayout jPanel_doctorBottonLayout = new javax.swing.GroupLayout(jPanel_doctorBotton);
        jPanel_doctorBotton.setLayout(jPanel_doctorBottonLayout);
        jPanel_doctorBottonLayout.setHorizontalGroup(
            jPanel_doctorBottonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_doctorBottonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(doctor_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(doctor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_doctorBottonLayout.setVerticalGroup(
            jPanel_doctorBottonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_doctorBottonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_doctorBottonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(doctor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(doctor_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jPanel_background_loginForm.add(jPanel_doctorBotton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 170, -1));

        jPanel_proveedorBotton.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_proveedorBotton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel_proveedorBotton.setPreferredSize(new java.awt.Dimension(130, 40));

        proveedor.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); 
        proveedor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        proveedor.setText("Proveedor");
        proveedor.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        proveedor.setPreferredSize(new java.awt.Dimension(83, 17));

        proveedor_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/patient_icon.png"))); 

        javax.swing.GroupLayout jPanel_proveedorBottonLayout = new javax.swing.GroupLayout(jPanel_proveedorBotton);
        jPanel_proveedorBotton.setLayout(jPanel_proveedorBottonLayout);
        jPanel_proveedorBottonLayout.setHorizontalGroup(
            jPanel_proveedorBottonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_proveedorBottonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(proveedor_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_proveedorBottonLayout.setVerticalGroup(
            jPanel_proveedorBottonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_proveedorBottonLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel_proveedorBottonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_proveedorBottonLayout.createSequentialGroup()
                        .addComponent(proveedor_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel_proveedorBottonLayout.createSequentialGroup()
                        .addComponent(proveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jPanel_background_loginForm.add(jPanel_proveedorBotton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 170, -1));

        jPanel_administrativoBotton.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_administrativoBotton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel_administrativoBotton.setPreferredSize(new java.awt.Dimension(130, 40));

        administrativo.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); 
        administrativo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        administrativo.setText("Administrativo");
        administrativo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        administrativo_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/patient_icon.png"))); 

        javax.swing.GroupLayout jPanel_administrativoBottonLayout = new javax.swing.GroupLayout(jPanel_administrativoBotton);
        jPanel_administrativoBotton.setLayout(jPanel_administrativoBottonLayout);
        jPanel_administrativoBottonLayout.setHorizontalGroup(
            jPanel_administrativoBottonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_administrativoBottonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(administrativo_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(administrativo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_administrativoBottonLayout.setVerticalGroup(
            jPanel_administrativoBottonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_administrativoBottonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_administrativoBottonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(administrativo_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(administrativo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel_background_loginForm.add(jPanel_administrativoBotton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 170, -1));

        jPanel_autoridadBotton.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_autoridadBotton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel_autoridadBotton.setPreferredSize(new java.awt.Dimension(130, 40));

        autoridad.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); 
        autoridad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        autoridad.setText("Autoridad");
        autoridad.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        autoridad.setPreferredSize(new java.awt.Dimension(83, 17));

        autoridad_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/patient_icon.png"))); 

        javax.swing.GroupLayout jPanel_autoridadBottonLayout = new javax.swing.GroupLayout(jPanel_autoridadBotton);
        jPanel_autoridadBotton.setLayout(jPanel_autoridadBottonLayout);
        jPanel_autoridadBottonLayout.setHorizontalGroup(
            jPanel_autoridadBottonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_autoridadBottonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(autoridad_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(autoridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_autoridadBottonLayout.setVerticalGroup(
            jPanel_autoridadBottonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_autoridadBottonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_autoridadBottonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_autoridadBottonLayout.createSequentialGroup()
                        .addComponent(autoridad_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(autoridad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel_background_loginForm.add(jPanel_autoridadBotton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 170, -1));

        mensaje_error.setBackground(Color.red);
        mensaje_error.setBorder(new javax.swing.border.LineBorder(Color.red, 10, true));
        mensaje_error.setOpaque(false);
        mensaje_error.setVisible(false);
        mensaje_error.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mensaje.setBackground(Color.red);
        mensaje.setFont(new java.awt.Font("Roboto", 1, 14)); 
        mensaje.setForeground(new java.awt.Color(57, 0, 0));
        mensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mensaje.setText("Acceso inválido. Intente nuevamente");
        mensaje.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        mensaje.setOpaque(true);
        mensaje_error.add(mensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 270, 20));

        jPanel_background_loginForm.add(mensaje_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 280, 30));

        jPanel_loginBotton.setBackground(new java.awt.Color(38, 70, 147));
        jPanel_loginBotton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel_loginBotton.setVisible(false);
        jPanel_loginBotton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_loginBottonMouseClicked(evt);
            }
        });

        iniciarSesion.setBackground(new java.awt.Color(255, 255, 255));
        iniciarSesion.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); 
        iniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        iniciarSesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iniciarSesion.setText("Iniciar Sesión");

        javax.swing.GroupLayout jPanel_loginBottonLayout = new javax.swing.GroupLayout(jPanel_loginBotton);
        jPanel_loginBotton.setLayout(jPanel_loginBottonLayout);
        jPanel_loginBottonLayout.setHorizontalGroup(
            jPanel_loginBottonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_loginBottonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iniciarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel_loginBottonLayout.setVerticalGroup(
            jPanel_loginBottonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_loginBottonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iniciarSesion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_background_loginForm.add(jPanel_loginBotton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, -1, -1));

        mensaje_restaurar.setBackground(new java.awt.Color(153, 204, 255));
        mensaje_restaurar.setFont(new java.awt.Font("Roboto", 1, 14)); 
        mensaje_restaurar.setForeground(new java.awt.Color(0, 0, 204));
        mensaje_restaurar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mensaje_restaurar.setText("¿Ha olvidado sus credenciales?");
        mensaje_restaurar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mensaje_restaurar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mensaje_restaurar.setVisible(false);
        mensaje_restaurar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mensaje_restaurarMouseClicked(evt);
            }
        });
        jPanel_background_loginForm.add(mensaje_restaurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 510, -1, 40));

        mensaje2.setBackground(new java.awt.Color(153, 204, 255));
        mensaje2.setFont(new java.awt.Font("Roboto", 1, 14)); 
        mensaje2.setForeground(new java.awt.Color(0, 0, 0));
        mensaje2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mensaje2.setText("¿No está registrado?");
        mensaje2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mensaje2.setVisible(false);
        jPanel_background_loginForm.add(mensaje2, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 480, -1, 40));

        mensaje1.setBackground(new java.awt.Color(153, 204, 255));
        mensaje1.setFont(new java.awt.Font("Roboto", 1, 14)); 
        mensaje1.setForeground(new java.awt.Color(0, 0, 204));
        mensaje1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mensaje1.setText("Registrarse");
        mensaje1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mensaje1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mensaje1.setVisible(false);
        mensaje1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mensaje1MouseClicked(evt);
            }
        });
        jPanel_background_loginForm.add(mensaje1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 480, 190, 40));

        jPanelOculto.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setBackground(new java.awt.Color(153, 204, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa_icon.png"))); 
        jLabel1.setPreferredSize(new java.awt.Dimension(1, 1));

        jLabel2.setText("Administrador");
        jLabel2.setForeground(new Color(153,204,255));
        jLabel2.setBackground(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout jPanelOcultoLayout = new javax.swing.GroupLayout(jPanelOculto);
        jPanelOculto.setLayout(jPanelOcultoLayout);
        jPanelOcultoLayout.setHorizontalGroup(
            jPanelOcultoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
            .addGroup(jPanelOcultoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelOcultoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanelOcultoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelOcultoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanelOcultoLayout.setVerticalGroup(
            jPanelOcultoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
            .addGroup(jPanelOcultoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelOcultoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanelOcultoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelOcultoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel_background_loginForm.add(jPanelOculto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 351, 10, 10));

        background.add(jPanel_background_loginForm, java.awt.BorderLayout.WEST);

        jScrollPane1.setViewportView(background);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    /* eventos */
    private void formComponentShown(java.awt.event.ComponentEvent evt) {
        Login.setImageLabal(paciente_icon, "src/images/patient_icon.png");
        Login.setImageLabal(doctor_icon, "src/images/doctor_icon.png");
        Login.setImageLabal(proveedor_icon, "src/images/supplier_icon.png");
        Login.setImageLabal(administrativo_icon, "src/images/administrative_icon.png");
        Login.setImageLabal(autoridad_icon, "src/images/authority_icon.png");
        Login.setImageLabal(icon_project, "src/images/operacionVacunas_Logo.png");
    }

    /* eventos del jFrame login */
    private void jPanel_loginBottonMouseClicked(java.awt.event.MouseEvent evt) {
        String user = userInput.getText();
        JLabel rol = (JLabel) selectedButton.getComponent(1);
        String rolText = rol.getText();

        mensaje_error.setVisible(false);
        if (user.isBlank()
                || user.equals("Ingrese su usuario")
                || String.valueOf(passwordInput.getPassword()).equals("Ingrese su contraseña")
                || String.valueOf(passwordInput.getPassword()).isBlank()) {
            this.roleButtonMouseClicked(selectedButton);
            toggleLogin(false);
            mensaje.setText("Error. Todos los campos son obligatorios.");
            mensaje_error.setVisible(true);
        } else {
            if (InicioSesion.autentificar(user, String.valueOf(passwordInput.getPassword()), rolText)) {
                Usuario usuario1 = InicioSesion.obtener(user, rolText);
                String nombreC = usuario1.getNombre() + " " + usuario1.getApellido();
                switch (rolText) {
                    case ("Paciente"): {
                        pac = new PantallaPaciente(this);
                        pac.setNombreBienvenida(nombreC);
                        pac.setVisible(true);
                        this.dispose();
                        break;
                    }
                    case ("Doctor - Enfermera"): {
                        doc = new PantallaDoctor(this);
                        doc.setNombreBienvenida(nombreC);
                        doc.setVisible(true);
                        this.dispose();
                        break;
                    }
                    case ("Proveedor"):
                    case ("Administrativo"):
                    case ("Autoridad"): {
                        construccion = new PantallaBlock(this);
                        construccion.setNombreBienvenida(nombreC);
                        construccion.setVisible(true);
                        this.dispose();
                        break;
                    }
                    case ("Administrador"): {
                        admin = new PantallaAdmin();
                        admin.setNombreBienvenida(nombreC);
                        admin.setVisible(true);
                        this.dispose();
                        break;
                    }
                    default: {
                        /*
                        base = new PantallaBase(this);
                        base.setNombreBienvenida(nombreC);
                        base.setVisible(true);
                        this.dispose();
                         */
                        JOptionPane.showMessageDialog(null, "Error al crear el nuevo frame según rol. Opción no definida", "Error Login", JOptionPane.ERROR_MESSAGE);
                        toggleLogin(false);
                        this.roleButtonMouseClicked(selectedButton);
                        break;
                    }
                }
            } else {
                this.roleButtonMouseClicked(selectedButton);
                toggleLogin(false);
                mensaje.setText("Acceso inválido. Intente nuevamente.");
                mensaje_error.setVisible(true);
            }
        }
    }

    private void userInputActionPerformed(java.awt.event.ActionEvent evt) {
        passwordInput.requestFocus();
    }

    private void passwordInputActionPerformed(java.awt.event.ActionEvent evt) {
        jPanel_loginBottonMouseClicked(null);
    }

    private void mensaje_restaurarMouseClicked(java.awt.event.MouseEvent evt) {
        jFrame_restaurarAcceso.setVisible(true);
        jFrame_restaurarAcceso.setLocationRelativeTo(this);
        this.setVisible(false);
    }

    private void mensaje1MouseClicked(java.awt.event.MouseEvent evt) {
        register = new RegistrarUser(this);
        JLabel rol = (JLabel) selectedButton.getComponent(1);
        register.setRol(rol.getText());
        if (selectedButton != jPanel_pacienteBotton) {
            register.setButtonSubmit("Enviar solicitud");
        }
        register.setFocusableWindowState(true);
        register.setVisible(true);
        this.setVisible(false);
    }

    /* eventos de jFrame restaurar acceso */
    private void jTextField_cedulaFocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_cedula, "Ingrese su cédula");
    }

    private void jTextField_cedulaFocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_cedula, "Ingrese su cédula");
    }

    private void jTextField_cedulaActionPerformed(java.awt.event.ActionEvent evt) {
        jTextField_fechaNacimiento.requestFocus();
    }

    private void jTextField_fechaNacimientoFocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_fechaNacimiento, "Ingrese su fecha de nacimiento YYYY-MM-DD hh:mm:ss");
    }

    private void jTextField_fechaNacimientoFocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_fechaNacimiento, "Ingrese su fecha de nacimiento YYYY-MM-DD hh:mm:ss");
    }

    private void jTextField_fechaNacimientoActionPerformed(java.awt.event.ActionEvent evt) {
        acceptTerms.setSelected(true);
        acceptTerms.requestFocus();
        button_validarMouseClicked(null);
    }

    private void button_validarMouseClicked(java.awt.event.MouseEvent evt) {
        String rolM = jComboBox_rol.getSelectedItem().toString();
        String cedulaM = jTextField_cedula.getText();
        String fechaNacimientoM = jTextField_fechaNacimiento.getText();

        errorMessage.setVisible(false);
        if (rolM.equals("Elegir")) {
            errorMessage.setText("Error. Todos los campos son obligatorios. Debe elegir su rol.");
            errorMessage.setVisible(true);
        } else if (acceptTerms.getSelectedObjects() == null) {
            acceptTerms.setForeground(Color.red);
        } else if (cedulaM.isBlank() || fechaNacimientoM.isBlank() || cedulaM.equals("Ingrese su cédula") || fechaNacimientoM.equals("Ingrese su fecha de nacimiento YYYY-MM-DD hh:mm:ss")) {
            errorMessage.setText("Error. Todos los campos son obligatorios.");
            errorMessage.setVisible(true);
        } else if (!cedulaM.matches("^(PE|E|N|[23456789](?:AV|PI)?|1[0123]?(?:AV|PI)?)-(\\d{1,4})-(\\d{1,6})$")) {
            errorMessage.setText("Error. La cédula no tiene el formato correcto. XX-XXXX-XXXXX");
            errorMessage.setVisible(true);
        } else if (!fechaNacimientoM.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])(\\s(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9]))?$")) {
            errorMessage.setText("Error. fecha no coincide con el formato. Mínimo fecha AAAA-MM-DD");
            errorMessage.setVisible(true);
        } else {
            if (InicioSesion.restaurar(cedulaM, fechaNacimientoM, rolM)) {
                jComboBox_rol.setEditable(false);
                jComboBox_rol.setEnabled(false);
                jComboBox_rol.setFocusable(false);
                jComboBox_rol.setForeground(Color.lightGray);
                jTextField_cedula.setEditable(false);
                jTextField_cedula.setFocusable(false);
                jTextField_cedula.setForeground(Color.lightGray);
                jTextField_fechaNacimiento.setEditable(false);
                jTextField_fechaNacimiento.setFocusable(false);
                jTextField_fechaNacimiento.setForeground(Color.lightGray);
                acceptTerms.setFocusable(false);
                acceptTerms.setEnabled(false);
                acceptTerms.setForeground(Color.lightGray);
                button_validar.setEnabled(false);
                button_validar.setFocusable(false);
                button_validar.setForeground(Color.lightGray);

                errorMessage.setText("Si usted no es la persona. Cerrar esta ventana e intente nuevamente.");
                errorMessage.setForeground(Color.GRAY);

                errorMessage.setVisible(true);
                mensaje_hola.setVisible(true);
                respuesta.setVisible(true);
                button_registrarse1.setVisible(true);
                jSeparator7.setVisible(true);
                jPasswordField.setVisible(true);
                contraseña.setVisible(true);
                jSeparator8.setVisible(true);
                jTextField_usuario.setVisible(true);
                usuario.setVisible(true);

                jTextField_usuario.requestFocus();
                Usuario usuario1 = InicioSesion.buscar(cedulaM, rolM);
                String nombreCompleto = usuario1.getNombre() + " " + usuario1.getApellido();
                respuesta.setText(nombreCompleto);
            } else {
                errorMessage.setText("Error. Los datos no coinciden. Intente nuevamente, si hay un error, consulte a su médico.");
                errorMessage.setVisible(true);
            }
        }
    }

    private void jTextField_usuarioFocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_usuario, "Ingrese un usuario");
    }

    private void jTextField_usuarioFocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_usuario, "Ingrese un usuario");
    }

    private void jTextField_usuarioActionPerformed(java.awt.event.ActionEvent evt) {
        jPasswordField.requestFocus();
    }

    private void jPasswordFieldFocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusPassword(jPasswordField, "Ingrese una contraseña");
    }

    private void jPasswordFieldFocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusPassword(jPasswordField, "Ingrese una contraseña");
    }

    private void jPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {
        button_registrarse1MouseClicked(null);
    }

    private void button_registrarse1MouseClicked(java.awt.event.MouseEvent evt) {
        String user = jTextField_usuario.getText();

        errorMessage.setVisible(false);
        errorMessage.setForeground(Color.red);
        errorMessage.setHorizontalAlignment(0);
        if (user.isBlank() || String.valueOf(jPasswordField.getPassword()).isBlank()
                || user.equals("Ingrese un usuario") || String.valueOf(jPasswordField.getPassword()).equals("Ingrese una contraseña")) {
            errorMessage.setText("Error. Todos los campos son obligatorios.");
            errorMessage.setVisible(true);
        } else {
            String cedulaB = jTextField_cedula.getText();
            String rolB = jComboBox_rol.getSelectedItem().toString();
            if (InicioSesion.restaurar(user, cedulaB, rolB)) {
                this.setVisible(true);
                jFrame_restaurarAcceso.dispose();
            } else {
                errorMessage.setText("Error. No se pudo restaurar sus credenciales. Intente nuevamente o inicie sesión.");
                errorMessage.setVisible(true);
            }
        }
    }

    private void mensaje3iniciarSesionMouseClicked(java.awt.event.MouseEvent evt) {

        this.setVisible(true);
        jFrame_restaurarAcceso.dispose();
    }

    private void jFrame_restaurarAccesoWindowClosing(java.awt.event.WindowEvent evt) {
        if (jTextField_cedula.getText().isBlank() || jTextField_fechaNacimiento.getText().isBlank()
                || !jTextField_cedula.getText().equals("Ingrese su cédula") || !jTextField_fechaNacimiento.getText().equals("Ingrese su fecha de nacimiento YYYY-MM-DD hh:mm:ss")
                || jTextField_usuario.getText().isBlank() || String.valueOf(jPasswordField.getPassword()).isBlank()
                || !jTextField_usuario.getText().equals("Ingrese un usuario") || !String.valueOf(jPasswordField.getPassword()).equals("Ingrese una contraseña")) {
            int confirm = JOptionPane.showConfirmDialog(null, "¿Esta seguro de cerra esta ventana? Se perderán los datos que ingresó.", "Cerrando ventana...", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (confirm == 0) {
                this.setVisible(true);
                jFrame_restaurarAcceso.dispose();
            }
        } else {
            this.setVisible(true);
            jFrame_restaurarAcceso.dispose();
        }
    }

    private void icon_project1AncestorAdded(javax.swing.event.AncestorEvent evt) {
        Login.setImageLabal(icon_project1, "src/images/operacionVacunas_logo.png");
    }

    private void userInputFocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(userInput, "Ingrese su usuario");
    }

    private void userInputFocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(userInput, "Ingrese su usuario");
    }

    private void passwordInputFocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusPassword(passwordInput, "Ingrese su contraseña");
    }

    private void passwordInputFocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusPassword(passwordInput, "Ingrese su contraseña");
    }

    /* métodos propios */
    private void toggleLogin(boolean show) {
        userInput.setVisible(show);
        passwordInput.setVisible(show);
        jPanel_loginBotton.setVisible(show);
        mensaje_restaurar.setVisible(show);
        mensaje1.setVisible(show);
        mensaje2.setVisible(show);
        /*if (show == false) {
            clearFieldsLogin();
        }*/
    }

    private void addRoleButtonListeners() {
        addRoleButtonListener(jPanel_pacienteBotton);
        addRoleButtonListener(jPanel_doctorBotton);
        addRoleButtonListener(jPanel_administrativoBotton);
        addRoleButtonListener(jPanel_autoridadBotton);
        addRoleButtonListener(jPanel_proveedorBotton);
        addRoleButtonListener(jPanelOculto);
    }

    private void addRoleButtonListener(JPanel roleButton) {
        roleButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roleButtonMouseClicked(roleButton);
            }
        });
    }

    private void roleButtonMouseClicked(JPanel roleButton) {
        mensaje_restaurar.setVisible(false);
        mensaje_error.setVisible(false);
        mensaje2.setVisible(false);
        mensaje1.setVisible(false);
        mensaje1.setText("Registrarse");
        toggleLogin(false);
        if (selectedButton != null && selectedButton == roleButton) {
            /* Unselect current button */
            if (selectedButton == jPanelOculto) {
                selectedButton.setBackground(new Color(153, 204, 255));
            } else {
                selectedButton.setBackground(Color.white);
            }
            selectedButton = null;
        } else {
            if (selectedButton != null) {
                selectedButton.setBackground(Color.white);
                if (selectedButton == jPanelOculto) {
                    selectedButton.setBackground(new Color(153, 204, 255));
                }
            }
            /* Select new button */
            toggleLogin(true);
            selectedButton = roleButton;
            selectedButton.setBackground(new Color(204, 0, 0));
            if (roleButton != jPanel_pacienteBotton) {
                mensaje1.setText("Solicitar acceso");
            }
        }
    }

    public static void setImageLabal(JLabel label, String imagen) {
        ImageIcon image = new ImageIcon(imagen);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
        label.setIcon(icon);
        label.repaint();
    }

    /* método main principal del proyecto */
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    /* mis variables */
    private JPanel selectedButton = null;
    private static PantallaPaciente pac;
    private static PantallaDoctor doc;
    private static PantallaBlock construccion;
    private static RegistrarUser register;
    private static PantallaAdmin admin;

    // Variables declaration
    private javax.swing.JCheckBox acceptTerms;
    private javax.swing.JLabel administrativo;
    private javax.swing.JLabel administrativo_icon;
    private javax.swing.JLabel autoridad;
    private javax.swing.JLabel autoridad_icon;
    private javax.swing.JPanel background;
    private javax.swing.JPanel background1;
    private javax.swing.JLabel bienvenido;
    private javax.swing.JLabel button_registrarse1;
    private javax.swing.JLabel button_validar;
    private javax.swing.JLabel cedula;
    private javax.swing.JLabel contraseña;
    private javax.swing.JLabel doctor;
    private javax.swing.JLabel doctor_icon;
    private javax.swing.JLabel elija_su_rol;
    private javax.swing.JLabel errorMessage;
    private javax.swing.JLabel fecha_nacimiento;
    private javax.swing.JLabel icon_project;
    private javax.swing.JLabel icon_project1;
    private javax.swing.JLabel iniciarSesion;
    private javax.swing.JComboBox<String> jComboBox_rol;
    private javax.swing.JFrame jFrame_restaurarAcceso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelOculto;
    private javax.swing.JPanel jPanel_administrativoBotton;
    private javax.swing.JPanel jPanel_autoridadBotton;
    private javax.swing.JPanel jPanel_background_loginForm;
    private javax.swing.JPanel jPanel_doctorBotton;
    private javax.swing.JPanel jPanel_loginBotton;
    private javax.swing.JPanel jPanel_pacienteBotton;
    private javax.swing.JPanel jPanel_proveedorBotton;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jTextField_cedula;
    private javax.swing.JTextField jTextField_fechaNacimiento;
    private javax.swing.JTextField jTextField_usuario;
    private javax.swing.JLabel mensaje;
    private javax.swing.JLabel mensaje1;
    private javax.swing.JLabel mensaje2;
    private javax.swing.JLabel mensaje3;
    private javax.swing.JLabel mensaje4;
    private javax.swing.JPanel mensaje_error;
    private javax.swing.JLabel mensaje_hola;
    private javax.swing.JLabel mensaje_restaurar;
    private javax.swing.JLabel mensaje_validar;
    private javax.swing.JLabel paciente;
    private javax.swing.JLabel paciente_icon;
    private javax.swing.JPasswordField passwordInput;
    private javax.swing.JLabel proveedor;
    private javax.swing.JLabel proveedor_icon;
    private javax.swing.JLabel respuesta;
    private javax.swing.JLabel rolRestaurar;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField userInput;
    private javax.swing.JLabel usuario;
    // End of variables declaration
}
