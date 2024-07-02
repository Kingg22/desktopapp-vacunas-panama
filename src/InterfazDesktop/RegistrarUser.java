package InterfazDesktop;

import Logica.Validations.*;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;

public class RegistrarUser extends javax.swing.JFrame {

    public RegistrarUser(JFrame parent) {
        RegistrarUser.parentFrame = parent;
        RegistrarUser.login = new InicioSesion();
        initComponents();

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        background = new javax.swing.JPanel();
        icon_project = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        rol_escogido = new javax.swing.JLabel();
        rol = new javax.swing.JLabel();
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
        telefono = new javax.swing.JLabel();
        jTextField_telefono = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        usuario = new javax.swing.JLabel();
        jTextField_usuario = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        contrasena = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jSeparator7 = new javax.swing.JSeparator();
        acceptTerms = new javax.swing.JCheckBox();
        errorMessage = new javax.swing.JLabel();
        extendTerms = new javax.swing.JTextArea();
        button_registrarse = new javax.swing.JLabel();
        mensaje1 = new javax.swing.JLabel();
        mensaje2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Regitrarse en Programa Vacunas Panamá");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 730));
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setPreferredSize(getSize());

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        background.setForeground(new java.awt.Color(255, 255, 255));
        background.setMaximumSize(new java.awt.Dimension(600, 510));
        background.setPreferredSize(new java.awt.Dimension(594, 724));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon_project.setForeground(new java.awt.Color(0, 0, 0));
        icon_project.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon_project.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/operacionVacunas_logo.png")));
        icon_project.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        icon_project.setMaximumSize(new java.awt.Dimension(500, 500));
        icon_project.setMinimumSize(new java.awt.Dimension(10, 10));
        icon_project.setPreferredSize(new java.awt.Dimension(50, 50));
        background.add(icon_project, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 110, 90));

        titulo.setFont(new java.awt.Font("Microsoft YaHei", 1, 14));
        titulo.setForeground(new java.awt.Color(0, 0, 0));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Registrarse en Vacunas Panamá");
        titulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titulo.setMaximumSize(new java.awt.Dimension(600, 20));
        background.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 560, -1));

        rol_escogido.setFont(new java.awt.Font("Roboto", 0, 12));
        rol_escogido.setForeground(new java.awt.Color(0, 0, 0));
        rol_escogido.setText("Rol escogido");
        background.add(rol_escogido, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, -1, -1));

        rol.setFont(new java.awt.Font("Microsoft YaHei", 1, 12));
        rol.setForeground(java.awt.Color.red);
        rol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rol.setText("rol");
        rol.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        background.add(rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 130, -1));

        nombre.setBackground(new java.awt.Color(0, 0, 0));
        nombre.setFont(new java.awt.Font("Roboto", 0, 12));
        nombre.setForeground(new java.awt.Color(0, 0, 0));
        nombre.setText("Nombre *");
        background.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jTextField_nombre.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_nombre.setDocument(new LimitarCamposString(50, "Ingrese su nombre"));
        jTextField_nombre.setFont(new java.awt.Font("Roboto", 0, 14));
        jTextField_nombre.setForeground(java.awt.Color.gray);
        jTextField_nombre.setText("Ingrese su nombre");
        jTextField_nombre.setBorder(null);
        jTextField_nombre.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        handleFocusGain(jTextField_nombre, "Ingrese su nombre");
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
        background.add(jTextField_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 550, -1));

        jSeparator3.setForeground(new java.awt.Color(30, 30, 30));
        background.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 550, 21));

        apellido.setBackground(new java.awt.Color(0, 0, 0));
        apellido.setFont(new java.awt.Font("Roboto", 0, 12));
        apellido.setForeground(new java.awt.Color(0, 0, 0));
        apellido.setText("Apellido *");
        background.add(apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jTextField_apellido.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_apellido.setDocument(new LimitarCamposString(50, "Ingrese su apellido"));
        jTextField_apellido.setFont(new java.awt.Font("Roboto", 0, 14));
        jTextField_apellido.setForeground(java.awt.Color.gray);
        jTextField_apellido.setText("Ingrese su apellido");
        jTextField_apellido.setBorder(null);
        jTextField_apellido.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        handleFocusGain(jTextField_apellido, "Ingrese su apellido");
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
        background.add(jTextField_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 550, -1));

        jSeparator4.setForeground(new java.awt.Color(30, 30, 30));
        background.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 550, 21));

        cedula.setBackground(new java.awt.Color(0, 0, 0));
        cedula.setFont(new java.awt.Font("Roboto", 0, 12));
        cedula.setForeground(new java.awt.Color(0, 0, 0));
        cedula.setText("Cédula *");
        background.add(cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jTextField_cedula.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_cedula.setDocument(new LimitarCamposCedula(15, "Ingrese su cédula"));
        jTextField_cedula.setFont(new java.awt.Font("Roboto", 0, 14));
        jTextField_cedula.setForeground(java.awt.Color.gray);
        jTextField_cedula.setText("Ingrese su cédula");
        jTextField_cedula.setBorder(null);
        jTextField_cedula.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        handleFocusGain(jTextField_cedula, "Ingrese su cédula");
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
        background.add(jTextField_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 550, -1));

        jSeparator5.setForeground(new java.awt.Color(30, 30, 30));
        background.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 550, 21));

        fecha_nacimiento.setBackground(new java.awt.Color(0, 0, 0));
        fecha_nacimiento.setFont(new java.awt.Font("Roboto", 0, 12));
        fecha_nacimiento.setForeground(new java.awt.Color(0, 0, 0));
        fecha_nacimiento.setText("Fecha de nacimiento *");
        background.add(fecha_nacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jTextField_fechaNacimiento.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_fechaNacimiento.setDocument(new LimitarCamposFecha(19, "Ingrese su fecha de nacimiento YYYY-MM-DD hh:mm:ss"));
        jTextField_fechaNacimiento.setFont(new java.awt.Font("Roboto", 0, 14));
        jTextField_fechaNacimiento.setForeground(java.awt.Color.gray);
        jTextField_fechaNacimiento.setText("Ingrese su fecha de nacimiento YYYY-MM-DD hh:mm:ss");
        jTextField_fechaNacimiento.setBorder(null);
        jTextField_fechaNacimiento.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        handleFocusGain(jTextField_fechaNacimiento, "Ingrese su fecha de nacimiento YYYY-MM-DD hh:mm:ss");
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
        background.add(jTextField_fechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 550, -1));

        jSeparator9.setForeground(new java.awt.Color(30, 30, 30));
        background.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 550, 21));

        sexo.setBackground(new java.awt.Color(0, 0, 0));
        sexo.setFont(new java.awt.Font("Roboto", 0, 12));
        sexo.setForeground(new java.awt.Color(0, 0, 0));
        sexo.setText("sexo *");
        background.add(sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        jComboBox_sexo.setBackground(java.awt.Color.gray);
        jComboBox_sexo.setFont(new java.awt.Font("Roboto", 0, 14));
        jComboBox_sexo.setForeground(java.awt.Color.black);
        jComboBox_sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Elegir", "Masculino", "Feminino"}));
        background.add(jComboBox_sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 170, -1));

        direccion.setBackground(new java.awt.Color(0, 0, 0));
        direccion.setFont(new java.awt.Font("Roboto", 0, 12));
        direccion.setForeground(new java.awt.Color(0, 0, 0));
        direccion.setText("Dirección");
        background.add(direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

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
        background.add(jTextField_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 250, -1));

        distrito.setBackground(new java.awt.Color(0, 0, 0));
        distrito.setFont(new java.awt.Font("Roboto", 0, 12));
        distrito.setForeground(new java.awt.Color(0, 0, 0));
        distrito.setText("Distrito");
        background.add(distrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, -1, -1));

        jComboBox_distrito.setBackground(java.awt.Color.gray);
        jComboBox_distrito.setFont(new java.awt.Font("Roboto", 0, 14));
        jComboBox_distrito.setForeground(java.awt.Color.black);
        jComboBox_distrito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Elegir", "Distrito por registrar"}));
        background.add(jComboBox_distrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 345, 290, -1));

        jSeparator10.setForeground(new java.awt.Color(30, 30, 30));
        background.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 250, 21));

        correo.setBackground(new java.awt.Color(0, 0, 0));
        correo.setFont(new java.awt.Font("Roboto", 0, 12));
        correo.setForeground(new java.awt.Color(0, 0, 0));
        correo.setText("Correo electrónico");
        background.add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        jTextField_correo.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_correo.setDocument(new LimitarCamposEmail(50, "Ingrese su correo electrónico"));
        jTextField_correo.setFont(new java.awt.Font("Roboto", 0, 14));
        jTextField_correo.setForeground(java.awt.Color.gray);
        jTextField_correo.setText("Ingrese su correo electrónico");
        jTextField_correo.setBorder(null);
        jTextField_correo.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        handleFocusGain(jTextField_correo, "Ingrese su correo electrónico");
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
        background.add(jTextField_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 550, -1));

        jSeparator6.setForeground(new java.awt.Color(30, 30, 30));
        background.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 550, 21));

        telefono.setBackground(new java.awt.Color(0, 0, 0));
        telefono.setFont(new java.awt.Font("Roboto", 0, 12));
        telefono.setForeground(new java.awt.Color(0, 0, 0));
        telefono.setText("Teléfono");
        background.add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, -1, -1));

        jTextField_telefono.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_telefono.setDocument(new LimitarCamposNumeric(15, "Ingrese su teléfono"));
        jTextField_telefono.setFont(new java.awt.Font("Roboto", 0, 14));
        jTextField_telefono.setForeground(java.awt.Color.gray);
        jTextField_telefono.setText("Ingrese su teléfono");
        jTextField_telefono.setBorder(null);
        jTextField_telefono.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        handleFocusGain(jTextField_telefono, "Ingrese su teléfono");
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
        background.add(jTextField_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 550, -1));

        jSeparator12.setForeground(new java.awt.Color(30, 30, 30));
        background.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 550, 21));

        usuario.setBackground(new java.awt.Color(0, 0, 0));
        usuario.setFont(new java.awt.Font("Roboto", 0, 12));
        usuario.setForeground(new java.awt.Color(0, 0, 0));
        usuario.setText("Usuario *");
        background.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, -1, -1));

        jTextField_usuario.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_usuario.setDocument(new LimitarCamposSeguro(50, "Ingrese un usuario"));
        jTextField_usuario.setFont(new java.awt.Font("Roboto", 0, 14));
        jTextField_usuario.setForeground(java.awt.Color.gray);
        jTextField_usuario.setText("Ingrese un usuario");
        jTextField_usuario.setActionCommand("<Not Set>");
        jTextField_usuario.setBorder(null);
        jTextField_usuario.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_usuario, "Ingrese un usuario");
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
        background.add(jTextField_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 550, -1));

        jSeparator8.setForeground(new java.awt.Color(30, 30, 30));
        background.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 550, 21));

        contrasena.setBackground(new java.awt.Color(0, 0, 0));
        contrasena.setFont(new java.awt.Font("Roboto", 0, 12));
        contrasena.setForeground(new java.awt.Color(0, 0, 0));
        contrasena.setText("Contraseña *");
        background.add(contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, -1, -1));

        jPasswordField.setBackground(new java.awt.Color(255, 255, 255));
        jPasswordField.setDocument(new LimitarCamposSeguro(20, "Ingrese una contraseña"));
        jPasswordField.setFont(new java.awt.Font("Roboto", 0, 14));
        jPasswordField.setForeground(java.awt.Color.gray);
        jPasswordField.setText("Ingrese una contraseña");
        jPasswordField.setBorder(null);
        jPasswordField.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jPasswordField, "Ingrese una contraseña");
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
        background.add(jPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, 550, -1));

        jSeparator7.setForeground(new java.awt.Color(30, 30, 30));
        background.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, 550, 21));

        acceptTerms.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12));
        acceptTerms.setForeground(new java.awt.Color(102, 102, 102));
        acceptTerms.setText("Al registrarse, usted acepta los términos y condiciones del servicio, y la política de privacidad. ");
        acceptTerms.setToolTipText("Aceptar términos y condiciones");
        acceptTerms.setBorder(null);
        acceptTerms.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        acceptTerms.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        acceptTerms.setMaximumSize(new java.awt.Dimension(600, 20));
        background.add(acceptTerms, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 550, 20));

        errorMessage.setFont(new java.awt.Font("Roboto", Font.BOLD, 14));
        errorMessage.setForeground(java.awt.Color.red);
        errorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorMessage.setText("Error. ");
        errorMessage.setVisible(false);
        background.add(errorMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, 590, -1));

        extendTerms.setEditable(false);
        extendTerms.setBackground(new java.awt.Color(255, 255, 255));
        extendTerms.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12));
        extendTerms.setForeground(new java.awt.Color(102, 102, 102));
        extendTerms.setLineWrap(true);
        extendTerms.setRows(5);
        extendTerms.setText("Adicional si no esta registrado, se le creará un perfil. Su cédula debe coincidir para ver resultados, además no podrá corregirla al igual que su fecha de nacimiento. Los datos suministrados se consideran verdaderos, estrictamente personal, información confidencial y sensible.");
        extendTerms.setWrapStyleWord(true);
        extendTerms.setBorder(null);
        extendTerms.setFocusable(false);
        extendTerms.setPreferredSize(new java.awt.Dimension(1576, 80));
        extendTerms.setRequestFocusEnabled(false);
        background.add(extendTerms, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 600, 520, 50));

        button_registrarse.setBackground(new java.awt.Color(0, 204, 51));
        button_registrarse.setFont(new java.awt.Font("Roboto", 0, 12));
        button_registrarse.setForeground(new java.awt.Color(0, 0, 0));
        button_registrarse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button_registrarse.setText("Registrarse");
        button_registrarse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_registrarse.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        button_registrarse.setMaximumSize(new java.awt.Dimension(600, 30));
        button_registrarse.setOpaque(true);
        button_registrarse.setPreferredSize(new java.awt.Dimension(94, 20));
        button_registrarse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_registrarseMouseClicked(evt);
            }
        });
        background.add(button_registrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 670, 300, -1));

        mensaje1.setBackground(java.awt.Color.white);
        mensaje1.setFont(new java.awt.Font("Roboto", 1, 14));
        mensaje1.setForeground(new java.awt.Color(0, 0, 102));
        mensaje1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mensaje1.setText("Iniciar sesión");
        mensaje1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mensaje1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mensaje1.setOpaque(true);
        mensaje1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iniciarSesionMouseClicked(evt);
            }
        });
        background.add(mensaje1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 700, 110, 20));

        mensaje2.setBackground(java.awt.Color.white);
        mensaje2.setFont(new java.awt.Font("Roboto", 1, 14));
        mensaje2.setForeground(new java.awt.Color(0, 0, 0));
        mensaje2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mensaje2.setText("¿Ya estás registrado?");
        mensaje2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mensaje2.setOpaque(true);
        background.add(mensaje2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 700, 150, 20));

        jScrollPane1.setViewportView(background);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(616, 738));
        setLocationRelativeTo(null);
    }// </editor-fold>

    /* eventos */
    private void formComponentShown(java.awt.event.ComponentEvent evt) {
        Login.setImageLabal(icon_project, "src/images/operacionVacunas_Logo.png");
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        if (!isAnyFieldEmpty() || !isPlaceHolder()) {
            int confirm = JOptionPane.showConfirmDialog(null, "¿Esta seguro de cerra esta ventana? Se perderán los datos que ingresó.", "Cerrando ventana...", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (confirm == 0) {
                iniciarSesionMouseClicked(null);
            }
        } else {
            iniciarSesionMouseClicked(null);
        }
    }

    private void iniciarSesionMouseClicked(java.awt.event.MouseEvent evt) {
        parentFrame.setVisible(true);
        this.dispose();
    }

    private void button_registrarseMouseClicked(java.awt.event.MouseEvent evt) {
        errorMessage.setVisible(false);
        acceptTerms.setForeground(new Color(102, 102, 102));
        extendTerms.setForeground(new Color(102, 102, 102));

        if (acceptTerms.getSelectedObjects() == null) {
            acceptTerms.setForeground(Color.red);
            extendTerms.setForeground(Color.red);
        } else if (isAnyFieldEmpty() || isPlaceHolder()) {
            errorMessage.setText("Error. Algunos campos son obligatorios*. Revisar");
            errorMessage.setVisible(true);
        } else if (!jTextField_cedula.getText().matches("^(PE|E|N|[23456789](?:AV|PI)?|1[0123]?(?:AV|PI)?)-(\\d{1,4})-(\\d{1,6})$")) {
            errorMessage.setText("Error. La cédula no tiene el formato correcto.");
            errorMessage.setVisible(true);
        } else if (!jTextField_fechaNacimiento.getText().matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\\\d|3[01])$")) {
            errorMessage.setText("Error. La fecha de nacimiento no tiene el formato correcto. Mínimo fecha sin hora");
            errorMessage.setVisible(true);
        } else if (!jTextField_correo.getText().isBlank() && !jTextField_correo.getText().equals("Ingrese su correo electrónico")) {
            if (!jTextField_correo.getText().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
                errorMessage.setText("Error. El correo electrónico no tiene el formato correcto.");
                errorMessage.setVisible(true);
            }
        } else {
            /* TODO IMPLEMEMNTAR LOGICA DE CREACIÓN DE USUARIO Y/O CREACIÓN DE PACIENTE EN BD */
            if (InicioSesion.buscar(jTextField_cedula.getText(), rol.getText()) != null) {
                System.out.println("Creando un usuario local");
                boolean insertadoLocal = login.insertar(jTextField_nombre.getText(), jTextField_apellido.getText(), jTextField_cedula.getText(), jTextField_correo.getText(), jTextField_usuario.getText(), String.valueOf(jPasswordField.getPassword()), rol.getText());

            } else {
                errorMessage.setText("Error. Esta cédula ya está registrada para este rol. Acceda para modificar.");
                errorMessage.getParent().revalidate();
                errorMessage.getParent().repaint();
                errorMessage.setVisible(true);
            }
            parentFrame.setVisible(true);
            this.dispose();
        }
    }

    private void jTextField_nombreActionPerformed(java.awt.event.ActionEvent evt) {
        jTextField_apellido.requestFocus();
    }

    private void jTextField_apellidoActionPerformed(java.awt.event.ActionEvent evt) {
        jTextField_cedula.requestFocus();
    }

    private void jTextField_cedulaActionPerformed(java.awt.event.ActionEvent evt) {
        jTextField_fechaNacimiento.requestFocus();
    }

    private void jTextField_correoActionPerformed(java.awt.event.ActionEvent evt) {
        jTextField_telefono.requestFocus();
    }

    private void jTextField_usuarioActionPerformed(java.awt.event.ActionEvent evt) {
        jPasswordField.requestFocus();
    }

    private void jPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {
        acceptTerms.setSelected(true);
        acceptTerms.requestFocus();
        button_registrarseMouseClicked(null);
    }

    private void jTextField_telefonoActionPerformed(java.awt.event.ActionEvent evt) {
        jTextField_usuario.requestFocus();
    }

    private void jTextField_fechaNacimientoActionPerformed(java.awt.event.ActionEvent evt) {
        jTextField_direccion.requestFocus();
    }

    private void jTextField_direccionActionPerformed(java.awt.event.ActionEvent evt) {
        if (jComboBox_distrito.getSelectedIndex() == 0) {
            jComboBox_distrito.setSelectedIndex(1);
        }
        jTextField_correo.requestFocus();
    }

    private void jTextField_nombreFocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_nombre, "Ingrese su nombre");
    }

    private void jTextField_nombreFocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_nombre, "Ingrese su nombre");
    }

    private void jTextField_apellidoFocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_apellido, "Ingrese su apellido");
    }

    private void jTextField_apellidoFocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_apellido, "Ingrese su apellido");
    }

    private void jTextField_cedulaFocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_cedula, "Ingrese su cédula");
    }

    private void jTextField_cedulaFocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_cedula, "Ingrese su cédula");
    }

    private void jTextField_fechaNacimientoFocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_fechaNacimiento, "Ingrese su fecha de nacimiento YYYY-MM-DD hh:mm:ss");
    }

    private void jTextField_fechaNacimientoFocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_fechaNacimiento, "Ingrese su fecha de nacimiento YYYY-MM-DD hh:mm:ss");
    }

    private void jTextField_direccionFocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_direccion, "Ingrese su dirección");
    }

    private void jTextField_direccionFocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_direccion, "Ingrese su dirección");
    }

    private void jTextField_correoFocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_correo, "Ingrese su correo electrónico");
    }

    private void jTextField_correoFocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_correo, "Ingrese su correo electrónico");
    }

    private void jTextField_telefonoFocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_telefono, "Ingrese su teléfono");
    }

    private void jTextField_telefonoFocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_telefono, "Ingrese su teléfono");
    }

    private void jTextField_usuarioFocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_usuario, "Ingrese un usuario");
    }

    private void jTextField_usuarioFocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_usuario, "Ingrese un usuario");
    }

    private void jPasswordFieldFocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusPassword(jPasswordField, "Ingrese una contraseña");
    }

    private void jPasswordFieldFocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusPassword(jPasswordField, "Ingrese una contraseña");
    }

    /* métodos propios */
    private boolean isAnyFieldEmpty() {
        return jTextField_nombre.getText().isBlank()
                || jTextField_apellido.getText().isBlank()
                || jTextField_cedula.getText().isBlank()
                || jTextField_fechaNacimiento.getText().isBlank()
                || jTextField_usuario.getText().isBlank()
                || String.valueOf(jPasswordField.getPassword()).isBlank()
                || acceptTerms.getSelectedObjects() == null;
    }

    private boolean isPlaceHolder() {
        return jTextField_nombre.getText().equals("Ingrese su nombre")
                || jTextField_apellido.getText().equals("Ingrese su apellido")
                || jTextField_cedula.getText().equals("Ingrese su cédula")
                || jTextField_fechaNacimiento.getText().equals("Ingrese su fecha de nacimiento YYYY-MM-DD hh:mm:ss")
                || jTextField_usuario.getText().equals("Ingrese un usuario")
                || String.valueOf(jPasswordField.getPassword()).equals("Ingrese una contraseña");
    }

    public void setRol(String rol) {
        this.rol.setText(rol);
    }

    public void setButtonSubmit(String estado) {
        this.button_registrarse.setText(estado);
    }

    public static void handleFocusPassword(JPasswordField password, String placeholder) {
        Document document = password.getDocument();
        if (String.valueOf(password.getPassword()).equals(placeholder)) {
            if (document instanceof LimitarCampos doc) {
                try {
                    doc.remove(0, doc.getLength());
                } catch (BadLocationException e) {
                    System.err.println(e);
                }
            } else {
                password.setText("");
            }
            password.setForeground(Color.BLACK);
        } else if (String.valueOf(password.getPassword()).isBlank()) {
            if (document instanceof LimitarCampos doc) {
                try {
                    doc.remove(0, doc.getLength());
                } catch (BadLocationException e) {
                    System.err.println(e);
                }
            } else {
                password.setText(placeholder);
            }
            password.setForeground(Color.gray);
        }
    }

    public static void handleFocusGain(JTextField field, String defaultText) {
        Document document = field.getDocument();
        String text = field.getText();

        if (text.isBlank()) {
            if (document instanceof LimitarCampos) {
                try {
                    document.remove(0, document.getLength());
                } catch (BadLocationException e) {
                    System.err.println(e);
                }
            } else {
                field.setText(defaultText);
            }
            field.setForeground(Color.gray);
        } else if (text.equals(defaultText)) {
            if (document instanceof LimitarCampos) {
                try {
                    document.remove(0, document.getLength());
                } catch (BadLocationException e) {
                    System.err.println(e);
                }
            } else {
                field.setText("");
            }
            field.setForeground(Color.BLACK);
        }
    }

    /* Main de prueba individual */
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
            java.util.logging.Logger.getLogger(RegistrarUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarUser(new Login()).setVisible(true);
            }
        });
    }

    /* variables propias */
    private static JFrame parentFrame;
    private static InicioSesion login;

    // Variables declaration - do not modify
    private javax.swing.JCheckBox acceptTerms;
    private javax.swing.JLabel apellido;
    private javax.swing.JPanel background;
    private javax.swing.JLabel button_registrarse;
    private javax.swing.JLabel cedula;
    private javax.swing.JLabel contrasena;
    private javax.swing.JLabel correo;
    private javax.swing.JLabel direccion;
    private javax.swing.JLabel distrito;
    private javax.swing.JLabel errorMessage;
    private javax.swing.JTextArea extendTerms;
    private javax.swing.JLabel fecha_nacimiento;
    private javax.swing.JLabel icon_project;
    private javax.swing.JComboBox<String> jComboBox_distrito;
    private javax.swing.JComboBox<String> jComboBox_sexo;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jTextField_apellido;
    private javax.swing.JTextField jTextField_cedula;
    private javax.swing.JTextField jTextField_correo;
    private javax.swing.JTextField jTextField_direccion;
    private javax.swing.JTextField jTextField_fechaNacimiento;
    private javax.swing.JTextField jTextField_nombre;
    private javax.swing.JTextField jTextField_telefono;
    private javax.swing.JTextField jTextField_usuario;
    private javax.swing.JLabel mensaje1;
    private javax.swing.JLabel mensaje2;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel rol;
    private javax.swing.JLabel rol_escogido;
    private javax.swing.JLabel sexo;
    private javax.swing.JLabel telefono;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel usuario;
    // End of variables declaration
}
