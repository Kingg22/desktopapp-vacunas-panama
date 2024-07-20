package desktop_interface;

import logic.user_management.InicioSesion;
import logic.user_management.Usuario;
import logic.validations.LimitarCamposCedula;
import logic.validations.LimitarCamposFecha;
import logic.validations.LimitarCamposSeguro;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;

public class Login extends JFrame {

    public Login() {
        initComponents();

        addListeners();

        // Mostrar el JDialog en el EDT
        SwingUtilities.invokeLater(() -> {
            dialogCargar.setLocationRelativeTo(null);
            dialogCargar.setVisible(true);
            dialogCargar.requestFocusInWindow();
        });
        // Ejecutar tarea en segundo plano con SwingWorker
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                InicioSesion.buscar("1-1-1", "a");
                return null;
            }

            @Override
            protected void done() {
                dialogCargar.dispose();
                requestFocusInWindow();
            }
        }.execute();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        jFrame_restaurarAcceso = new JFrame();
        jScrollPane2 = new JScrollPane();
        background1 = new JPanel();
        titulo = new JLabel();
        icon_project1 = new JLabel();
        mensaje_validar = new JLabel();
        rolRestaurar = new JLabel();
        jComboBox_rol = new JComboBox<>();
        jTextField_cedula = new JTextField();
        cedula = new JLabel();
        jSeparator1 = new JSeparator();
        fecha_nacimiento = new JLabel();
        jTextField_fechaNacimiento = new JTextField();
        jSeparator4 = new JSeparator();
        acceptTerms = new JCheckBox();
        button_validar = new JLabel();
        mensaje_hola = new JLabel();
        respuesta = new JLabel();
        usuario = new JLabel();
        jTextField_usuario = new JTextField();
        jSeparator3 = new JSeparator();
        contrasena = new JLabel();
        jPasswordField = new JPasswordField();
        jSeparator2 = new JSeparator();
        errorMessage = new JLabel();
        mensaje3 = new JLabel();
        mensaje4 = new JLabel();
        jScrollPane1 = new JScrollPane();
        background = new JPanel();
        icon_project = new JLabel();
        jPanel_background_loginForm = new JPanel();
        bienvenido = new JLabel();
        elija_su_rol = new JLabel();
        jTextField_usuario_login = new JTextField();
        jPasswordField_login = new JPasswordField();
        jPanel_pacienteBotton = new JPanel();
        paciente = new JLabel();
        paciente_icon = new JLabel();
        jPanel_doctorBotton = new JPanel();
        doctor = new JLabel();
        doctor_icon = new JLabel();
        jPanel_proveedorBotton = new JPanel();
        fabricante = new JLabel();
        fabricante_icon = new JLabel();
        jPanel_administrativoBotton = new JPanel();
        administrativo = new JLabel();
        administrativo_icon = new JLabel();
        jPanel_autoridadBotton = new JPanel();
        autoridad = new JLabel();
        autoridad_icon = new JLabel();
        mensaje_error = new JPanel();
        mensaje = new JLabel();
        mensaje_restaurar = new JLabel();
        mensaje2 = new JLabel();
        mensaje1 = new JLabel();
        jPanelOculto = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jButton_restaurar = new JButton();
        jButton_cancelar5 = new JButton();
        jButton_login = new javax.swing.JButton();
        dialogCargar = new JDialog();
        JLabel label = new JLabel();

        dialogCargar.setTitle("Inicio Sesión");
        dialogCargar.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialogCargar.setModal(true);
        dialogCargar.setBackground(Color.white);
        dialogCargar.setResizable(false);
        dialogCargar.setSize(new Dimension(350, 100));


        label.setText("Cargando información de los usuarios. Por favor, espere...");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.black);
        dialogCargar.getContentPane().add(label, BorderLayout.CENTER);

        jFrame_restaurarAcceso.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        jFrame_restaurarAcceso.setTitle("Programa Vacunas Panamá - Restaurar acceso");
        jFrame_restaurarAcceso.setResizable(false);
        jFrame_restaurarAcceso.setSize(new Dimension(600, 650));
        jFrame_restaurarAcceso.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                jFrame_restaurarAccesoWindowClosing(evt);
            }
        });
        jFrame_restaurarAcceso.getContentPane().setLayout(new AbsoluteLayout());

        jScrollPane2.setPreferredSize(new Dimension(600, 600));

        background1.setBackground(new Color(255, 255, 255));
        background1.setPreferredSize(new Dimension(594, 594));
        background1.setLayout(new AbsoluteLayout());

        titulo.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
        titulo.setForeground(new Color(0, 0, 0));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setText("Restaurar acceso al Programa Vacunas Panamá");
        background1.add(titulo, new AbsoluteConstraints(0, 30, 510, -1));

        icon_project1.setIcon(new ImageIcon(getClass().getResource("/images/operacionVacunas_logo.png")));
        icon_project1.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent evt) {
                icon_project1AncestorAdded(evt);
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {

            }

            @Override
            public void ancestorMoved(AncestorEvent event) {

            }
        });
        background1.add(icon_project1, new AbsoluteConstraints(460, 10, 110, 80));

        mensaje_validar.setFont(new Font("Roboto", Font.ITALIC, 14));
        mensaje_validar.setForeground(new Color(0, 0, 0));
        mensaje_validar.setText("Validar sus datos personales");
        background1.add(mensaje_validar, new AbsoluteConstraints(30, 70, 180, -1));

        rolRestaurar.setFont(new Font("Roboto", Font.PLAIN, 12));
        rolRestaurar.setForeground(Color.black);
        rolRestaurar.setHorizontalAlignment(SwingConstants.LEFT);
        rolRestaurar.setText("Rol en el programa*");
        background1.add(rolRestaurar, new AbsoluteConstraints(30, 100, 120, -1));

        jComboBox_rol.setBackground(Color.gray);
        jComboBox_rol.setFont(new Font("Roboto", Font.PLAIN, 14));
        jComboBox_rol.setForeground(Color.black);
        jComboBox_rol.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir", "Paciente", "Doctor - Enfermera", "Fabricante", "Administrativo", "Autoridad"}));
        background1.add(jComboBox_rol, new AbsoluteConstraints(30, 120, 170, -1));

        jTextField_cedula.setBackground(new Color(255, 255, 255));
        jTextField_cedula.setDocument(new LimitarCamposCedula(15, "Ingrese su cédula"));
        jTextField_cedula.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_cedula.setForeground(Color.gray);
        jTextField_cedula.setText("Ingrese su cédula");
        jTextField_cedula.setBorder(null);
        jTextField_cedula.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_cedula, "Ingrese su cédula");
        background1.add(jTextField_cedula, new AbsoluteConstraints(30, 180, 540, -1));

        cedula.setBackground(new Color(0, 0, 0));
        cedula.setFont(new Font("Roboto", Font.PLAIN, 12));
        cedula.setForeground(new Color(0, 0, 0));
        cedula.setText("Cédula *");
        background1.add(cedula, new AbsoluteConstraints(30, 160, -1, -1));

        jSeparator1.setForeground(new Color(30, 30, 30));
        background1.add(jSeparator1, new AbsoluteConstraints(30, 200, 540, 21));

        fecha_nacimiento.setBackground(new Color(0, 0, 0));
        fecha_nacimiento.setFont(new Font("Roboto", Font.PLAIN, 12));
        fecha_nacimiento.setForeground(new Color(0, 0, 0));
        fecha_nacimiento.setText("Fecha de nacimiento *");
        background1.add(fecha_nacimiento, new AbsoluteConstraints(30, 220, -1, -1));

        jTextField_fechaNacimiento.setBackground(new Color(255, 255, 255));
        jTextField_fechaNacimiento.setDocument(new LimitarCamposFecha(19, "Ingrese su fecha de nacimiento YYYY-MM-DD* hh:mm:ss"));
        jTextField_fechaNacimiento.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_fechaNacimiento.setForeground(Color.gray);
        jTextField_fechaNacimiento.setText("Ingrese su fecha de nacimiento YYYY-MM-DD* hh:mm:ss");
        jTextField_fechaNacimiento.setBorder(null);
        jTextField_fechaNacimiento.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_fechaNacimiento, "Ingrese su fecha de nacimiento YYYY-MM-DD* hh:mm:ss");
        jTextField_fechaNacimiento.addActionListener(this::jTextField_fechaNacimientoActionPerformed);
        background1.add(jTextField_fechaNacimiento, new AbsoluteConstraints(30, 240, 540, -1));

        jSeparator4.setForeground(new Color(30, 30, 30));
        background1.add(jSeparator4, new AbsoluteConstraints(30, 260, 540, 21));

        acceptTerms.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 12));
        acceptTerms.setForeground(new Color(102, 102, 102));
        acceptTerms.setText("Al usar este formulario usted declara estar autorizado y da su consentimiento para validar.");
        acceptTerms.setToolTipText("Aceptar términos y condiciones");
        acceptTerms.setBorder(null);
        acceptTerms.setCursor(new Cursor(Cursor.HAND_CURSOR));
        acceptTerms.setHorizontalAlignment(SwingConstants.LEFT);
        acceptTerms.setMaximumSize(new Dimension(600, 20));
        background1.add(acceptTerms, new AbsoluteConstraints(30, 270, 540, 20));

        button_validar.setBackground(new Color(0, 204, 51));
        button_validar.setFont(new Font("Roboto", Font.PLAIN, 12));
        button_validar.setForeground(new Color(0, 0, 0));
        button_validar.setHorizontalAlignment(SwingConstants.CENTER);
        button_validar.setText("Validar sus datos");
        button_validar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button_validar.setHorizontalTextPosition(SwingConstants.CENTER);
        button_validar.setMaximumSize(new Dimension(600, 30));
        button_validar.setOpaque(true);
        button_validar.setPreferredSize(new Dimension(94, 20));
        button_validar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                button_validarMouseClicked(evt);
            }
        });
        background1.add(button_validar, new AbsoluteConstraints(140, 300, 300, -1));

        mensaje_hola.setFont(new Font("Roboto", Font.ITALIC, 14));
        mensaje_hola.setForeground(new Color(0, 0, 0));
        mensaje_hola.setText("Hola!");
        mensaje_hola.setVisible(false);
        background1.add(mensaje_hola, new AbsoluteConstraints(30, 330, 140, -1));

        respuesta.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
        respuesta.setForeground(new Color(0, 0, 0));
        respuesta.setText("Respuesta nombre - rol");
        respuesta.setVisible(false);
        background1.add(respuesta, new AbsoluteConstraints(30, 350, 540, -1));

        usuario.setBackground(new Color(0, 0, 0));
        usuario.setFont(new Font("Roboto", Font.PLAIN, 12));
        usuario.setForeground(new Color(0, 0, 0));
        usuario.setText("Usuario *");
        usuario.setVisible(false);
        background1.add(usuario, new AbsoluteConstraints(30, 390, -1, -1));

        jTextField_usuario.setBackground(new Color(255, 255, 255));
        jTextField_usuario.setDocument(new LimitarCamposSeguro(50, "Ingrese un usuario"));
        jTextField_usuario.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_usuario.setForeground(Color.gray);
        jTextField_usuario.setText("Ingrese un usuario");
        jTextField_usuario.setActionCommand("<Not Set>");
        jTextField_usuario.setBorder(null);
        jTextField_usuario.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_usuario, "Ingrese un usuario");
        jTextField_usuario.setVisible(false);
        background1.add(jTextField_usuario, new AbsoluteConstraints(30, 410, 540, -1));

        jSeparator3.setForeground(new Color(30, 30, 30));
        jSeparator3.setVisible(false);
        background1.add(jSeparator3, new AbsoluteConstraints(30, 430, 540, 21));

        contrasena.setBackground(new Color(0, 0, 0));
        contrasena.setFont(new Font("Roboto", Font.PLAIN, 12));
        contrasena.setForeground(new Color(0, 0, 0));
        contrasena.setText("contraseña *");
        contrasena.setVisible(false);
        background1.add(contrasena, new AbsoluteConstraints(30, 440, -1, -1));

        jPasswordField.setBackground(new Color(255, 255, 255));
        jPasswordField.setDocument(new LimitarCamposSeguro(20, "Ingrese una contraseña"));
        jPasswordField.setFont(new Font("Roboto", Font.PLAIN, 14));
        jPasswordField.setForeground(Color.gray);
        jPasswordField.setText("Ingrese una contraseña");
        jPasswordField.setBorder(null);
        jPasswordField.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jPasswordField, "Ingrese una contraseña");
        jPasswordField.setVisible(false);
        jPasswordField.addActionListener(this::jPasswordFieldActionPerformed);
        background1.add(jPasswordField, new AbsoluteConstraints(30, 460, 540, -1));

        jSeparator2.setForeground(new Color(30, 30, 30));
        jSeparator2.setVisible(false);
        background1.add(jSeparator2, new AbsoluteConstraints(30, 480, 540, 21));

        errorMessage.setFont(new Font("Roboto", Font.BOLD, 14));
        errorMessage.setForeground(Color.red);
        errorMessage.setHorizontalAlignment(SwingConstants.CENTER);
        errorMessage.setHorizontalTextPosition(SwingConstants.CENTER);
        errorMessage.setText("Error. ");
        errorMessage.setVisible(false);
        background1.add(errorMessage, new AbsoluteConstraints(2, 370, 590, -1));

        mensaje3.setBackground(Color.white);
        mensaje3.setFont(new Font("Roboto", Font.BOLD, 14));
        mensaje3.setForeground(new Color(0, 0, 102));
        mensaje3.setHorizontalAlignment(SwingConstants.LEFT);
        mensaje3.setText("Iniciar sesión");
        mensaje3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mensaje3.setHorizontalTextPosition(SwingConstants.CENTER);
        mensaje3.setOpaque(true);
        mensaje3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                mensaje3iniciarSesionMouseClicked(evt);
            }
        });
        background1.add(mensaje3, new AbsoluteConstraints(210, 560, 110, 20));

        mensaje4.setBackground(Color.white);
        mensaje4.setFont(new Font("Roboto", Font.BOLD, 14));
        mensaje4.setForeground(new Color(0, 0, 0));
        mensaje4.setHorizontalAlignment(SwingConstants.LEFT);
        mensaje4.setText("¿Ya estás registrado?");
        mensaje4.setHorizontalTextPosition(SwingConstants.CENTER);
        mensaje4.setOpaque(true);
        background1.add(mensaje4, new AbsoluteConstraints(50, 560, 150, 20));

        jButton_cancelar5.setBackground(new Color(153, 153, 153));
        jButton_cancelar5.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12)); // NOI18N
        jButton_cancelar5.setForeground(new Color(0, 0, 0));
        jButton_cancelar5.setText("Cancelar");
        jButton_cancelar5.setVisible(false);
        jButton_cancelar5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_cancelar5MouseClicked(evt);
            }
        });
        background1.add(jButton_cancelar5, new AbsoluteConstraints(320, 510, -1, -1));

        jButton_restaurar.setBackground(new Color(0, 204, 0));
        jButton_restaurar.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12)); // NOI18N
        jButton_restaurar.setForeground(new Color(0, 0, 0));
        jButton_restaurar.setText("Restaurar credenciales");
        jButton_restaurar.setVisible(false);
        jButton_restaurar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_restaurarMouseClicked(evt);
            }
        });
        background1.add(jButton_restaurar, new AbsoluteConstraints(410, 510, -1, -1));

        jScrollPane2.setViewportView(background1);

        jFrame_restaurarAcceso.getContentPane().add(jScrollPane2, new AbsoluteConstraints(0, 0, -1, -1));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login - MINSA");
        setLocationByPlatform(true);
        setSize(new Dimension(900, 620));
        addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jScrollPane1.setPreferredSize(getSize());

        background.setBackground(new Color(255, 255, 255));
        background.setMinimumSize(new Dimension(900, 600));
        background.setPreferredSize(new Dimension(894, 614));
        background.setLayout(new BorderLayout());

        icon_project.setHorizontalAlignment(SwingConstants.CENTER);
        icon_project.setIcon(new ImageIcon(getClass().getResource("/images/operacionVacunas_logo.png")));
        icon_project.setHorizontalTextPosition(SwingConstants.CENTER);
        icon_project.setPreferredSize(new Dimension(400, 600));
        background.add(icon_project, BorderLayout.CENTER);

        jPanel_background_loginForm.setBackground(new Color(153, 204, 255));
        jPanel_background_loginForm.setPreferredSize(new Dimension(400, 600));
        jPanel_background_loginForm.setLayout(new AbsoluteLayout());

        bienvenido.setBackground(new Color(0, 0, 0));
        bienvenido.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));
        bienvenido.setForeground(new Color(0, 0, 0));
        bienvenido.setText("!Bienvenido!");
        jPanel_background_loginForm.add(bienvenido, new AbsoluteConstraints(130, 20, -1, -1));

        elija_su_rol.setBackground(new Color(153, 153, 153));
        elija_su_rol.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
        elija_su_rol.setForeground(new Color(102, 102, 102));
        elija_su_rol.setText("Elija su rol");
        jPanel_background_loginForm.add(elija_su_rol, new AbsoluteConstraints(170, 70, -1, -1));

        jTextField_usuario_login.setDocument(new LimitarCamposSeguro(50, "Ingrese su usuario"));
        jTextField_usuario_login.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jTextField_usuario_login.setForeground(Color.gray);
        jTextField_usuario_login.setText("Ingrese su usuario");
        jPanel_background_loginForm.add(jTextField_usuario_login, new AbsoluteConstraints(80, 360, 240, -1));
        RegistrarUser.handleFocusGain(jTextField_usuario_login, "Ingrese su usuario");
        jTextField_usuario_login.setVisible(false);

        jPasswordField_login.setDocument(new LimitarCamposSeguro(20, "Ingrese su contraseña"));
        jPasswordField_login.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jPasswordField_login.setForeground(Color.gray);
        jPasswordField_login.setText("Ingrese su contraseña");
        jPasswordField_login.setToolTipText("Ingrese su contraseña");
        jPasswordField_login.addActionListener(this::passwordInputActionPerformed);
        jPanel_background_loginForm.add(jPasswordField_login, new AbsoluteConstraints(80, 400, 240, -1));
        RegistrarUser.handleFocusGain(jPasswordField_login, "Ingrese su contraseña");
        jPasswordField_login.setVisible(false);

        jPanel_pacienteBotton.setBackground(new Color(255, 255, 255));
        jPanel_pacienteBotton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jPanel_pacienteBotton.setPreferredSize(new Dimension(130, 40));

        paciente.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        paciente.setHorizontalAlignment(SwingConstants.LEFT);
        paciente.setText("Paciente");
        paciente.setHorizontalTextPosition(SwingConstants.RIGHT);
        paciente.setPreferredSize(new Dimension(83, 17));

        paciente_icon.setIcon(new ImageIcon(getClass().getResource("/images/patient_icon.png")));

        GroupLayout jPanel_pacienteBottonLayout = new GroupLayout(jPanel_pacienteBotton);
        jPanel_pacienteBotton.setLayout(jPanel_pacienteBottonLayout);
        jPanel_pacienteBottonLayout.setHorizontalGroup(
                jPanel_pacienteBottonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel_pacienteBottonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(paciente_icon, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(paciente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_pacienteBottonLayout.setVerticalGroup(
                jPanel_pacienteBottonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_pacienteBottonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel_pacienteBottonLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(paciente_icon, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(paciente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_background_loginForm.add(jPanel_pacienteBotton, new AbsoluteConstraints(110, 110, 170, -1));

        jPanel_doctorBotton.setBackground(new Color(255, 255, 255));
        jPanel_doctorBotton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jPanel_doctorBotton.setPreferredSize(new Dimension(130, 40));

        doctor.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        doctor.setHorizontalAlignment(SwingConstants.LEFT);
        doctor.setText("Doctor - Enfermera");
        doctor.setHorizontalTextPosition(SwingConstants.RIGHT);
        doctor.setPreferredSize(new Dimension(83, 17));

        doctor_icon.setIcon(new ImageIcon(getClass().getResource("/images/patient_icon.png")));

        GroupLayout jPanel_doctorBottonLayout = new GroupLayout(jPanel_doctorBotton);
        jPanel_doctorBotton.setLayout(jPanel_doctorBottonLayout);
        jPanel_doctorBottonLayout.setHorizontalGroup(
                jPanel_doctorBottonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_doctorBottonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(doctor_icon, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(doctor, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_doctorBottonLayout.setVerticalGroup(
                jPanel_doctorBottonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_doctorBottonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel_doctorBottonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(doctor, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(doctor_icon, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14))
        );

        jPanel_background_loginForm.add(jPanel_doctorBotton, new AbsoluteConstraints(110, 160, 170, -1));

        jPanel_proveedorBotton.setBackground(new Color(255, 255, 255));
        jPanel_proveedorBotton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jPanel_proveedorBotton.setPreferredSize(new Dimension(130, 40));

        fabricante.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        fabricante.setHorizontalAlignment(SwingConstants.LEFT);
        fabricante.setText("Fabricante");
        fabricante.setHorizontalTextPosition(SwingConstants.RIGHT);
        fabricante.setPreferredSize(new Dimension(83, 17));

        fabricante_icon.setIcon(new ImageIcon(getClass().getResource("/images/patient_icon.png")));

        GroupLayout jPanel_proveedorBottonLayout = new GroupLayout(jPanel_proveedorBotton);
        jPanel_proveedorBotton.setLayout(jPanel_proveedorBottonLayout);
        jPanel_proveedorBottonLayout.setHorizontalGroup(
                jPanel_proveedorBottonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel_proveedorBottonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(fabricante_icon, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(fabricante, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_proveedorBottonLayout.setVerticalGroup(
                jPanel_proveedorBottonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_proveedorBottonLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel_proveedorBottonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel_proveedorBottonLayout.createSequentialGroup()
                                                .addComponent(fabricante_icon, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(jPanel_proveedorBottonLayout.createSequentialGroup()
                                                .addComponent(fabricante, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap())))
        );

        jPanel_background_loginForm.add(jPanel_proveedorBotton, new AbsoluteConstraints(110, 210, 170, -1));

        jPanel_administrativoBotton.setBackground(new Color(255, 255, 255));
        jPanel_administrativoBotton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jPanel_administrativoBotton.setPreferredSize(new Dimension(130, 40));

        administrativo.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        administrativo.setHorizontalAlignment(SwingConstants.LEFT);
        administrativo.setText("Administrativo");
        administrativo.setHorizontalTextPosition(SwingConstants.RIGHT);

        administrativo_icon.setIcon(new ImageIcon(getClass().getResource("/images/patient_icon.png")));

        GroupLayout jPanel_administrativoBottonLayout = new GroupLayout(jPanel_administrativoBotton);
        jPanel_administrativoBotton.setLayout(jPanel_administrativoBottonLayout);
        jPanel_administrativoBottonLayout.setHorizontalGroup(
                jPanel_administrativoBottonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel_administrativoBottonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(administrativo_icon, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(administrativo)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_administrativoBottonLayout.setVerticalGroup(
                jPanel_administrativoBottonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_administrativoBottonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel_administrativoBottonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(administrativo_icon, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(administrativo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        jPanel_background_loginForm.add(jPanel_administrativoBotton, new AbsoluteConstraints(110, 260, 170, -1));

        jPanel_autoridadBotton.setBackground(new Color(255, 255, 255));
        jPanel_autoridadBotton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jPanel_autoridadBotton.setPreferredSize(new Dimension(130, 40));

        autoridad.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        autoridad.setHorizontalAlignment(SwingConstants.LEFT);
        autoridad.setText("Autoridad");
        autoridad.setHorizontalTextPosition(SwingConstants.RIGHT);
        autoridad.setPreferredSize(new Dimension(83, 17));

        autoridad_icon.setIcon(new ImageIcon(getClass().getResource("/images/patient_icon.png")));

        GroupLayout jPanel_autoridadBottonLayout = new GroupLayout(jPanel_autoridadBotton);
        jPanel_autoridadBotton.setLayout(jPanel_autoridadBottonLayout);
        jPanel_autoridadBottonLayout.setHorizontalGroup(
                jPanel_autoridadBottonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel_autoridadBottonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(autoridad_icon, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(autoridad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_autoridadBottonLayout.setVerticalGroup(
                jPanel_autoridadBottonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_autoridadBottonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel_autoridadBottonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel_autoridadBottonLayout.createSequentialGroup()
                                                .addComponent(autoridad_icon, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(autoridad, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        jPanel_background_loginForm.add(jPanel_autoridadBotton, new AbsoluteConstraints(110, 310, 170, -1));

        mensaje_error.setBackground(Color.red);
        mensaje_error.setBorder(new LineBorder(Color.red, 10, true));
        mensaje_error.setOpaque(false);
        mensaje_error.setVisible(false);
        mensaje_error.setLayout(new AbsoluteLayout());

        mensaje.setBackground(Color.red);
        mensaje.setFont(new Font("Roboto", Font.BOLD, 14));
        mensaje.setForeground(new Color(57, 0, 0));
        mensaje.setHorizontalAlignment(SwingConstants.CENTER);
        mensaje.setText("Acceso inválido. Intente nuevamente");
        mensaje.setHorizontalTextPosition(SwingConstants.LEFT);
        mensaje.setOpaque(true);
        mensaje_error.add(mensaje, new AbsoluteConstraints(5, 5, 270, 20));

        jPanel_background_loginForm.add(mensaje_error, new AbsoluteConstraints(60, 380, 280, 30));

        jButton_login.setBackground(new Color(38, 70, 147));
        jButton_login.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jButton_login.setForeground(new Color(255, 255, 255));
        jButton_login.setText("Iniciar sesión");
        jButton_login.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_login.setUI(new BasicButtonUI());
        jButton_login.setVisible(false);
        jButton_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_loginMouseClicked(evt);
            }
        });

        jPanel_background_loginForm.add(jButton_login, new AbsoluteConstraints(140, 440, 120, 30));

        mensaje_restaurar.setBackground(new Color(153, 204, 255));
        mensaje_restaurar.setFont(new Font("Roboto", Font.BOLD, 14));
        mensaje_restaurar.setForeground(new Color(0, 0, 204));
        mensaje_restaurar.setHorizontalAlignment(SwingConstants.CENTER);
        mensaje_restaurar.setText("¿Ha olvidado sus credenciales?");
        mensaje_restaurar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mensaje_restaurar.setHorizontalTextPosition(SwingConstants.CENTER);
        mensaje_restaurar.setVisible(false);
        mensaje_restaurar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                mensaje_restaurarMouseClicked(evt);
            }
        });
        jPanel_background_loginForm.add(mensaje_restaurar, new AbsoluteConstraints(90, 510, -1, 40));

        mensaje2.setBackground(new Color(153, 204, 255));
        mensaje2.setFont(new Font("Roboto", Font.BOLD, 14));
        mensaje2.setForeground(new Color(0, 0, 0));
        mensaje2.setHorizontalAlignment(SwingConstants.LEFT);
        mensaje2.setText("¿No está registrado?");
        mensaje2.setHorizontalTextPosition(SwingConstants.CENTER);
        mensaje2.setVisible(false);
        jPanel_background_loginForm.add(mensaje2, new AbsoluteConstraints(85, 480, -1, 40));

        mensaje1.setBackground(new Color(153, 204, 255));
        mensaje1.setFont(new Font("Roboto", Font.BOLD, 14));
        mensaje1.setForeground(new Color(0, 0, 204));
        mensaje1.setHorizontalAlignment(SwingConstants.LEFT);
        mensaje1.setText("Registrarse");
        mensaje1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mensaje1.setHorizontalTextPosition(SwingConstants.CENTER);
        mensaje1.setVisible(false);
        mensaje1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                mensaje1MouseClicked(evt);
            }
        });
        jPanel_background_loginForm.add(mensaje1, new AbsoluteConstraints(230, 480, 190, 40));

        jPanelOculto.setBackground(new Color(153, 204, 255));

        jLabel1.setBackground(new Color(153, 204, 255));
        jLabel1.setIcon(new ImageIcon(getClass().getResource("/images/lupa_icon.png")));
        jLabel1.setPreferredSize(new Dimension(1, 1));

        jLabel2.setText("Administrador");
        jLabel2.setForeground(new Color(153, 204, 255));
        jLabel2.setBackground(new Color(153, 204, 255));

        GroupLayout jPanelOcultoLayout = new GroupLayout(jPanelOculto);
        jPanelOculto.setLayout(jPanelOcultoLayout);
        jPanelOcultoLayout.setHorizontalGroup(
                jPanelOcultoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 10, Short.MAX_VALUE)
                        .addGroup(jPanelOcultoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelOcultoLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jPanelOcultoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelOcultoLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel2)
                                        .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanelOcultoLayout.setVerticalGroup(
                jPanelOcultoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 10, Short.MAX_VALUE)
                        .addGroup(jPanelOcultoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelOcultoLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jPanelOcultoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelOcultoLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel2)
                                        .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel_background_loginForm.add(jPanelOculto, new AbsoluteConstraints(180, 351, 10, 10));

        background.add(jPanel_background_loginForm, BorderLayout.WEST);

        jScrollPane1.setViewportView(background);

        getContentPane().add(jScrollPane1, BorderLayout.CENTER);
        setIconImage(new ImageIcon(getClass().getResource("/images/Icon1.png")).getImage());

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    /* eventos */
    private void formComponentShown(ComponentEvent evt) {
        Login.setImageLabel(paciente_icon, "src/images/patient_icon.png");
        Login.setImageLabel(doctor_icon, "src/images/doctor_icon.png");
        Login.setImageLabel(fabricante_icon, "src/images/supplier_icon.png");
        Login.setImageLabel(administrativo_icon, "src/images/administrative_icon.png");
        Login.setImageLabel(autoridad_icon, "src/images/authority_icon.png");
        Login.setImageLabel(icon_project, "src/images/operacionVacunas_Logo.png");
    }

    /* eventos del jFrame login */
    private void jButton_loginMouseClicked(MouseEvent evt) {
        if (!jButton_login.isEnabled()) {
            return; // Si el botón está deshabilitado, no hacer nada.
        }

        jButton_login.setEnabled(false);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                jButton_login.setEnabled(true);
            }
        }, LOGIN_DISABLE_TIME);

        String user = jTextField_usuario_login.getText();
        JLabel rol = (JLabel) selectedButton.getComponent(1);
        String rolText = rol.getText();

        mensaje_error.setVisible(false);
        if (user.isBlank()
                || user.equals("Ingrese su usuario")
                || String.valueOf(jPasswordField_login.getPassword()).equals("Ingrese su contraseña")
                || String.valueOf(jPasswordField_login.getPassword()).isBlank()) {
            this.roleButtonMouseClicked(selectedButton);
            toggleLogin(false);
            mensaje.setText("Error. Todos los campos son obligatorios.");
            mensaje_error.setVisible(true);
        } else {
            if (InicioSesion.autentificar(user, String.valueOf(jPasswordField_login.getPassword()), rolText)) {
                Usuario usuario1 = InicioSesion.obtener(user, rolText);
                String nombreC = usuario1.getNombre() + " " + usuario1.getApellido();
                switch (rolText) {
                    case ("Paciente"): {
                        //PantallaPaciente pac = new PantallaPaciente(this);
                        SwingUtilities.invokeLater(() -> this.setVisible(false));

                        SwingWorker<Void, String> worker = new SwingWorker<>() {
                            @Override
                            protected Void doInBackground() throws Exception {
                                try {
                                    ProcessBuilder builder = new ProcessBuilder("python", "src\\desktop_interface\\Paciente.py", usuario1.getCedula(), nombreC);
                                    Process process = builder.start();

                                    System.out.println("Ha empezado el script Python. Esperando...");

                                    // Capturar la salida estándar (stdout)
                                    BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
                                    // Capturar la salida de error (stderr)
                                    BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

                                    String s;
                                    System.out.println("Salida estándar del script Python:\n");
                                    while ((s = stdInput.readLine()) != null) {
                                        publish(s);
                                    }

                                    System.out.println("Salida de error del script Python:\n");
                                    while ((s = stdError.readLine()) != null) {
                                        publish("ERROR: " + s);
                                    }

                                    // Esperar a que el proceso termine
                                    int exitCode = process.waitFor();
                                    // Verificar si el proceso terminó exitosamente
                                    if (exitCode == 0) {
                                        System.out.println("El script Python ha terminado correctamente.");
                                    } else {
                                        System.err.println("El script Python ha terminado con error. Código de salida: " + exitCode);
                                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ejecutar el archivo Python. \n" +
                                                "Contacte a soporte para solucionar el problema.");
                                    }
                                } catch (IOException | InterruptedException e) {
                                    System.err.println(e);
                                    JOptionPane.showMessageDialog(null, "Error al abrir la ventana Paciente. Disculpe, contacte a soporte", "FATAL ERROR Paciente", JOptionPane.ERROR_MESSAGE);
                                }
                                return null;
                            }

                            @Override
                            protected void process(java.util.List<String> chunks) {
                                for (String line : chunks) {
                                    System.out.println(line);
                                }
                            }

                            @Override
                            protected void done() {
                                SwingUtilities.invokeLater(() -> setVisible(true));
                            }
                        };
                        worker.execute();
                        /*
                        PantallaPaciente pac = new PantallaPaciente(this, usuario1);
                        pac.setVisible(true); */
                        this.setVisible(true);
                        break;
                    }
                    case ("Doctor - Enfermera"): {
                        PantallaDoctor doc = new PantallaDoctor(this, usuario1);
                        doc.setVisible(true);
                        this.setVisible(false);
                        break;
                    }
                    case ("Fabricante"):
                    case ("Administrativo"):
                    case ("Autoridad"): {
                        PantallaBlock construccion = new PantallaBlock(this);
                        construccion.setBienvenida(nombreC);
                        construccion.setVisible(true);
                        this.setVisible(false);
                        break;
                    }
                    case ("Administrador"): {
                        PantallaAdmin admin = new PantallaAdmin(usuario1);
                        admin.setVisible(true);
                        this.setVisible(false);
                        break;
                    }
                    default: {
                        /*
                        base = new PantallaBase(this);
                        base.setBienvenida(nombreC, usuario1.getCedula());
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

    private void passwordInputActionPerformed(ActionEvent evt) {
        jButton_loginMouseClicked(null);
    }

    private void mensaje_restaurarMouseClicked(MouseEvent evt) {
        if (!mensaje_restaurar.isEnabled()) {
            return; // Si el botón está deshabilitado, no hacer nada.
        }

        mensaje_restaurar.setEnabled(false); // deshabilitar el botón

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                mensaje_restaurar.setEnabled(true);
            }
        }, RESTORE_DISABLE_TIME);
        jFrame_restaurarAcceso.setVisible(true);
        jFrame_restaurarAcceso.setLocationRelativeTo(this);
        this.setVisible(false);
    }

    private void mensaje1MouseClicked(MouseEvent evt) {
        if (!mensaje1.isEnabled()) {
            return; // Si el botón está deshabilitado, no hacer nada.
        }

        mensaje1.setEnabled(false); // deshabilitar el botón

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                mensaje1.setEnabled(true);
            }
        }, REGISTER_DISABLE_TIME);

        RegistrarUser register = new RegistrarUser(this);
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
    private void jTextField_fechaNacimientoActionPerformed(ActionEvent evt) {
        acceptTerms.setSelected(true);
        acceptTerms.requestFocus();
        button_validarMouseClicked(null);
    }

    private void button_validarMouseClicked(MouseEvent evt) {
        if (!button_validar.isEnabled()) {
            return;
        }

        button_validar.setEnabled(false); // deshabilitar el botón

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                button_validar.setEnabled(true);
            }
        }, VALIDATE_DISABLE_TIME);

        String rolM = jComboBox_rol.getSelectedItem().toString();
        String cedulaM = jTextField_cedula.getText();
        String fechaNacimientoM = jTextField_fechaNacimiento.getText();

        errorMessage.setVisible(false);
        if (rolM.equals("Elegir")) {
            errorMessage.setText("Error. Todos los campos son obligatorios. Debe elegir su rol.");
            errorMessage.setVisible(true);
        } else if (acceptTerms.getSelectedObjects() == null) {
            acceptTerms.setForeground(Color.red);
        } else if (cedulaM.isBlank() || fechaNacimientoM.isBlank() || cedulaM.equals("Ingrese su cédula") || fechaNacimientoM.equals("Ingrese su fecha de nacimiento YYYY-MM-DD* hh:mm:ss")) {
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
                jButton_cancelar5.setVisible(true);
                jButton_restaurar.setVisible(true);
                jSeparator2.setVisible(true);
                jPasswordField.setVisible(true);
                contrasena.setVisible(true);
                jSeparator3.setVisible(true);
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

    private void jPasswordFieldActionPerformed(ActionEvent evt) {
        jButton_restaurarMouseClicked(null);
    }

    private void mensaje3iniciarSesionMouseClicked(MouseEvent evt) {
        this.setVisible(true);
        jFrame_restaurarAcceso.setVisible(false);
    }

    private void jFrame_restaurarAccesoWindowClosing(WindowEvent evt) {
        if (jTextField_cedula.getText().isBlank() || jTextField_fechaNacimiento.getText().isBlank()
                || !jTextField_cedula.getText().equals("Ingrese su cédula") || !jTextField_fechaNacimiento.getText().equals("Ingrese su fecha de nacimiento YYYY-MM-DD* hh:mm:ss")
                || jTextField_usuario.getText().isBlank() || String.valueOf(jPasswordField.getPassword()).isBlank()
                || !jTextField_usuario.getText().equals("Ingrese un usuario") || !String.valueOf(jPasswordField.getPassword()).equals("Ingrese una contraseña")) {
            int confirm = JOptionPane.showConfirmDialog(null, "¿Esta seguro de cerra esta ventana? Se perderán los datos que ingresó.", "Cerrando ventana...", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (confirm == 1) {
                return;
            }
        }
        jFrame_restaurarAcceso.setVisible(false);
        // TODO limpiar campos
        this.setVisible(true);
    }

    private void icon_project1AncestorAdded(AncestorEvent evt) {
        Login.setImageLabel(icon_project1, "src/images/operacionVacunas_logo.png");
    }

    private void jButton_cancelar5MouseClicked(MouseEvent evt) {
        // TODO limpiar los campos
        jFrame_restaurarAcceso.setVisible(false);
    }

    private void jButton_restaurarMouseClicked(MouseEvent evt) {
        if (!jButton_restaurar.isEnabled()) {
            return;
        }

        jButton_restaurar.setEnabled(false); // deshabilitar el botón

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                jButton_restaurar.setEnabled(true);
            }
        }, RESTORE_DISABLE_TIME);

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
            if (InicioSesion.modificarCredenciales(cedulaB, user, String.valueOf(jPasswordField.getPassword()), rolB)) {
                this.setVisible(true);
                jFrame_restaurarAcceso.dispose();
            } else {
                errorMessage.setText("Error. No se pudo restaurar sus credenciales. Intente nuevamente o inicie sesión.");
                errorMessage.setVisible(true);
            }
        }
    }

    /* métodos propios */
    private void toggleLogin(boolean show) {
        jTextField_usuario_login.setVisible(show);
        jPasswordField_login.setVisible(show);
        jButton_login.setVisible(show);
        mensaje_restaurar.setVisible(show);
        mensaje1.setVisible(show);
        mensaje2.setVisible(show);
    }

    private void addListeners() {
        addRoleButtonListener(jPanel_pacienteBotton);
        addRoleButtonListener(jPanel_doctorBotton);
        addRoleButtonListener(jPanel_administrativoBotton);
        addRoleButtonListener(jPanel_autoridadBotton);
        addRoleButtonListener(jPanel_proveedorBotton);
        addRoleButtonListener(jPanelOculto);

        // focus listener
        PantallaBase.addFocusListeners(jTextField_cedula, "Ingrese su cédula");
        PantallaBase.addFocusListeners(jTextField_fechaNacimiento, "Ingrese su fecha de nacimiento YYYY-MM-DD* hh:mm:ss");
        PantallaBase.addFocusListeners(jTextField_usuario, "Ingrese un usuario");
        PantallaBase.addFocusListeners(jPasswordField, "Ingrese una contraseña");
        PantallaBase.addFocusListeners(jTextField_usuario_login, "Ingrese su usuario");
        PantallaBase.addFocusListeners(jPasswordField_login, "Ingrese su contraseña");

        // Action Listener
        PantallaBase.addActionListeners(jTextField_usuario_login, jPasswordField_login);
        PantallaBase.addActionListeners(jTextField_cedula, jTextField_fechaNacimiento);
        PantallaBase.addActionListeners(jTextField_usuario, jPasswordField);
    }

    private void addRoleButtonListener(JPanel roleButton) {
        roleButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
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

    public static void setImageLabel(JLabel label, String imagen) {
        ImageIcon image = new ImageIcon(imagen);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
        label.setIcon(icon);
        label.repaint();
    }

    /* método main principal del proyecto */
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        SwingUtilities.invokeLater(() -> new Login().setVisible(true));
    }

    /* mis variables */
    private final long LOGIN_DISABLE_TIME = 30000;
    private final long REGISTER_DISABLE_TIME = 120000;
    private final long RESTORE_DISABLE_TIME = 300000;
    private final long VALIDATE_DISABLE_TIME = 30000;
    private JPanel selectedButton = null;

    // Variables declaration
    private JCheckBox acceptTerms;
    private JLabel administrativo;
    private JLabel administrativo_icon;
    private JLabel autoridad;
    private JLabel autoridad_icon;
    private JPanel background;
    private JPanel background1;
    private JLabel bienvenido;
    private JLabel button_validar;
    private JLabel cedula;
    private JLabel contrasena;
    private JLabel doctor;
    private JLabel doctor_icon;
    private JLabel elija_su_rol;
    private JLabel errorMessage;
    private JLabel fecha_nacimiento;
    private JLabel icon_project;
    private JLabel icon_project1;
    private JComboBox<String> jComboBox_rol;
    private JFrame jFrame_restaurarAcceso;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanelOculto;
    private JPanel jPanel_administrativoBotton;
    private JPanel jPanel_autoridadBotton;
    private JPanel jPanel_background_loginForm;
    private JPanel jPanel_doctorBotton;
    private JPanel jPanel_pacienteBotton;
    private JPanel jPanel_proveedorBotton;
    private JPasswordField jPasswordField;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JSeparator jSeparator3;
    private JSeparator jSeparator4;
    private JTextField jTextField_cedula;
    private JTextField jTextField_fechaNacimiento;
    private JTextField jTextField_usuario;
    private JLabel mensaje;
    private JLabel mensaje1;
    private JLabel mensaje2;
    private JLabel mensaje3;
    private JLabel mensaje4;
    private JPanel mensaje_error;
    private JLabel mensaje_hola;
    private JLabel mensaje_restaurar;
    private JLabel mensaje_validar;
    private JLabel paciente;
    private JLabel paciente_icon;
    private JPasswordField jPasswordField_login;
    private JLabel fabricante;
    private JLabel fabricante_icon;
    private JLabel respuesta;
    private JLabel rolRestaurar;
    private JLabel titulo;
    private JTextField jTextField_usuario_login;
    private JLabel usuario;
    private JButton jButton_restaurar;
    private JButton jButton_cancelar5;
    private JButton jButton_login;
    private JDialog dialogCargar;
    // End of variables declaration
}
