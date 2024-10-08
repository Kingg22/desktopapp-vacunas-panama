package desktop_interface;

import desktop_interface.util.StaticMethods;
import logic.connexions.DatabaseOperaciones;
import logic.user_management.UserManager;
import desktop_interface.util.validations.*;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Timer;
import java.util.TimerTask;

public class RegistrarUser extends JFrame {

    public RegistrarUser(JFrame parent) {
        initComponents();
        addListeners();
        PARENT_FRAME = parent;

        try {
            jComboBox_distrito.setModel(new DefaultComboBoxModel<>(StaticMethods.transformMatrizToArray(
                    new DatabaseOperaciones().getDistritos(UserManager.getToken(9223372036854774807L)), 0)));
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null,
                    "Ha ocurrido un problema encontrando las distritos. Reinicie la aplicación o contacte a soporte");
        }

        this.requestFocusInWindow();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        jScrollPane1 = new JScrollPane();
        background = new JPanel();
        icon_project = new JLabel();
        titulo = new JLabel();
        rol_escogido = new JLabel();
        rol = new JLabel();
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
        telefono = new JLabel();
        jTextField_telefono = new JTextField();
        jSeparator12 = new JSeparator();
        usuario = new JLabel();
        jTextField_usuario = new JTextField();
        jSeparator8 = new JSeparator();
        contrasena = new JLabel();
        jPasswordField = new JPasswordField();
        jSeparator7 = new JSeparator();
        acceptTerms = new JCheckBox();
        errorMessage = new JLabel();
        extendTerms = new JTextArea();
        button_registrarse = new JLabel();
        mensaje1 = new JLabel();
        mensaje2 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Regitrarse en Programa Vacunas Panamá");
        setBackground(new Color(255, 255, 255));
        setResizable(false);
        setSize(new Dimension(600, 730));
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
        getContentPane().setLayout(new AbsoluteLayout());

        jScrollPane1.setPreferredSize(getSize());

        background.setBackground(new Color(255, 255, 255));
        background.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        background.setForeground(new Color(255, 255, 255));
        background.setMaximumSize(new Dimension(600, 510));
        background.setPreferredSize(new Dimension(594, 724));
        background.setLayout(new AbsoluteLayout());

        icon_project.setForeground(new Color(0, 0, 0));
        icon_project.setHorizontalAlignment(SwingConstants.CENTER);
        icon_project.setIcon(new ImageIcon(getClass().getResource("/images/operacionVacunas_logo.png")));
        icon_project.setHorizontalTextPosition(SwingConstants.CENTER);
        icon_project.setMaximumSize(new Dimension(500, 500));
        icon_project.setMinimumSize(new Dimension(10, 10));
        icon_project.setPreferredSize(new Dimension(50, 50));
        background.add(icon_project, new AbsoluteConstraints(450, 10, 110, 90));

        titulo.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
        titulo.setForeground(new Color(0, 0, 0));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setText("Registrarse en Vacunas Panamá");
        titulo.setHorizontalTextPosition(SwingConstants.CENTER);
        titulo.setMaximumSize(new Dimension(600, 20));
        background.add(titulo, new AbsoluteConstraints(20, 10, 560, -1));

        rol_escogido.setFont(new Font("Roboto", Font.PLAIN, 12));
        rol_escogido.setForeground(new Color(0, 0, 0));
        rol_escogido.setText("Rol escogido");
        background.add(rol_escogido, new AbsoluteConstraints(260, 40, -1, -1));

        rol.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
        rol.setForeground(Color.red);
        rol.setHorizontalAlignment(SwingConstants.CENTER);
        rol.setText("rol");
        rol.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        background.add(rol, new AbsoluteConstraints(230, 60, 130, -1));

        nombre.setBackground(new Color(0, 0, 0));
        nombre.setFont(new Font("Roboto", Font.PLAIN, 12));
        nombre.setForeground(new Color(0, 0, 0));
        nombre.setText("Nombre *");
        background.add(nombre, new AbsoluteConstraints(30, 80, -1, -1));

        jTextField_nombre.setBackground(new Color(255, 255, 255));
        jTextField_nombre.setDocument(new LimitarCamposString(50, "Ingrese su nombre"));
        jTextField_nombre.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_nombre.setForeground(Color.gray);
        jTextField_nombre.setText("Ingrese su nombre");
        jTextField_nombre.setBorder(null);
        jTextField_nombre.setMaximumSize(new Dimension(2147483647, 50));
        StaticMethods.handleFocusGain(jTextField_nombre, "Ingrese su nombre");
        background.add(jTextField_nombre, new AbsoluteConstraints(30, 100, 550, -1));

        jSeparator3.setForeground(new Color(30, 30, 30));
        background.add(jSeparator3, new AbsoluteConstraints(30, 120, 550, 21));

        apellido.setBackground(new Color(0, 0, 0));
        apellido.setFont(new Font("Roboto", Font.PLAIN, 12));
        apellido.setForeground(new Color(0, 0, 0));
        apellido.setText("Apellido *");
        background.add(apellido, new AbsoluteConstraints(30, 130, -1, -1));

        jTextField_apellido.setBackground(new Color(255, 255, 255));
        jTextField_apellido.setDocument(new LimitarCamposString(50, "Ingrese su apellido"));
        jTextField_apellido.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_apellido.setForeground(Color.gray);
        jTextField_apellido.setText("Ingrese su apellido");
        jTextField_apellido.setBorder(null);
        jTextField_apellido.setMaximumSize(new Dimension(2147483647, 50));
        StaticMethods.handleFocusGain(jTextField_apellido, "Ingrese su apellido");
        background.add(jTextField_apellido, new AbsoluteConstraints(30, 150, 550, -1));

        jSeparator4.setForeground(new Color(30, 30, 30));
        background.add(jSeparator4, new AbsoluteConstraints(30, 170, 550, 21));

        cedula.setBackground(new Color(0, 0, 0));
        cedula.setFont(new Font("Roboto", Font.PLAIN, 12));
        cedula.setForeground(new Color(0, 0, 0));
        cedula.setText("Cédula *");
        background.add(cedula, new AbsoluteConstraints(30, 180, -1, -1));

        jTextField_cedula.setBackground(new Color(255, 255, 255));
        jTextField_cedula.setDocument(new LimitarCamposCedula(15, "Ingrese su cédula"));
        jTextField_cedula.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_cedula.setForeground(Color.gray);
        jTextField_cedula.setText("Ingrese su cédula");
        jTextField_cedula.setBorder(null);
        jTextField_cedula.setMaximumSize(new Dimension(2147483647, 50));
        StaticMethods.handleFocusGain(jTextField_cedula, "Ingrese su cédula");
        background.add(jTextField_cedula, new AbsoluteConstraints(30, 200, 550, -1));

        jSeparator5.setForeground(new Color(30, 30, 30));
        background.add(jSeparator5, new AbsoluteConstraints(30, 220, 550, 21));

        fecha_nacimiento.setBackground(new Color(0, 0, 0));
        fecha_nacimiento.setFont(new Font("Roboto", Font.PLAIN, 12));
        fecha_nacimiento.setForeground(new Color(0, 0, 0));
        fecha_nacimiento.setText("Fecha de nacimiento *");
        background.add(fecha_nacimiento, new AbsoluteConstraints(30, 230, -1, -1));

        jTextField_fechaNacimiento.setBackground(new Color(255, 255, 255));
        jTextField_fechaNacimiento
                .setDocument(new LimitarCamposFecha(30, "Ingrese su fecha de nacimiento YYYY-MM-DD* hh:mm:ss"));
        jTextField_fechaNacimiento.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_fechaNacimiento.setForeground(Color.gray);
        jTextField_fechaNacimiento.setText("Ingrese su fecha de nacimiento YYYY-MM-DD* hh:mm:ss");
        jTextField_fechaNacimiento.setBorder(null);
        jTextField_fechaNacimiento.setMaximumSize(new Dimension(2147483647, 50));
        StaticMethods.handleFocusGain(jTextField_fechaNacimiento,
                "Ingrese su fecha de nacimiento YYYY-MM-DD* hh:mm:ss");
        background.add(jTextField_fechaNacimiento, new AbsoluteConstraints(30, 250, 550, -1));

        jSeparator9.setForeground(new Color(30, 30, 30));
        background.add(jSeparator9, new AbsoluteConstraints(30, 270, 550, 21));

        sexo.setBackground(new Color(0, 0, 0));
        sexo.setFont(new Font("Roboto", Font.PLAIN, 12));
        sexo.setForeground(new Color(0, 0, 0));
        sexo.setText("Sexo *");
        background.add(sexo, new AbsoluteConstraints(30, 280, -1, -1));

        jComboBox_sexo.setBackground(Color.gray);
        jComboBox_sexo.setFont(new Font("Roboto", Font.PLAIN, 14));
        jComboBox_sexo.setForeground(Color.black);
        jComboBox_sexo.setModel(new DefaultComboBoxModel<>(new String[] { "Elegir", "Masculino", "Femenino" }));
        background.add(jComboBox_sexo, new AbsoluteConstraints(30, 300, 170, -1));

        direccion.setBackground(new Color(0, 0, 0));
        direccion.setFont(new Font("Roboto", Font.PLAIN, 12));
        direccion.setForeground(new Color(0, 0, 0));
        direccion.setText("Dirección");
        background.add(direccion, new AbsoluteConstraints(30, 330, -1, -1));

        jTextField_direccion.setBackground(new Color(255, 255, 255));
        jTextField_direccion.setDocument(new LimitarCamposAlpha(100, "Ingrese su dirección"));
        jTextField_direccion.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_direccion.setForeground(Color.gray);
        jTextField_direccion.setText("Ingrese su dirección");
        jTextField_direccion.setBorder(null);
        jTextField_direccion.setMaximumSize(new Dimension(2147483647, 50));
        jTextField_direccion.addActionListener(this::jTextField_direccionActionPerformed);
        background.add(jTextField_direccion, new AbsoluteConstraints(30, 350, 250, -1));

        distrito.setBackground(new Color(0, 0, 0));
        distrito.setFont(new Font("Roboto", Font.PLAIN, 12));
        distrito.setForeground(new Color(0, 0, 0));
        distrito.setText("Distrito");
        background.add(distrito, new AbsoluteConstraints(290, 330, -1, -1));

        jComboBox_distrito.setBackground(Color.gray);
        jComboBox_distrito.setFont(new Font("Roboto", Font.PLAIN, 14));
        jComboBox_distrito.setForeground(Color.black);
        jComboBox_distrito.setModel(new DefaultComboBoxModel<>(new String[] { "Elegir", "Distrito por registrar" }));
        background.add(jComboBox_distrito, new AbsoluteConstraints(290, 345, 290, -1));

        jSeparator10.setForeground(new Color(30, 30, 30));
        background.add(jSeparator10, new AbsoluteConstraints(30, 370, 250, 21));

        correo.setBackground(new Color(0, 0, 0));
        correo.setFont(new Font("Roboto", Font.PLAIN, 12));
        correo.setForeground(new Color(0, 0, 0));
        correo.setText("Correo electrónico");
        background.add(correo, new AbsoluteConstraints(30, 380, -1, -1));

        jTextField_correo.setBackground(new Color(255, 255, 255));
        jTextField_correo.setDocument(new LimitarCamposEmail(50, "Ingrese su correo electrónico"));
        jTextField_correo.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_correo.setForeground(Color.gray);
        jTextField_correo.setText("Ingrese su correo electrónico");
        jTextField_correo.setBorder(null);
        jTextField_correo.setMaximumSize(new Dimension(2147483647, 50));
        StaticMethods.handleFocusGain(jTextField_correo, "Ingrese su correo electrónico");
        background.add(jTextField_correo, new AbsoluteConstraints(30, 400, 550, -1));

        jSeparator6.setForeground(new Color(30, 30, 30));
        background.add(jSeparator6, new AbsoluteConstraints(30, 420, 550, 21));

        telefono.setBackground(new Color(0, 0, 0));
        telefono.setFont(new Font("Roboto", Font.PLAIN, 12));
        telefono.setForeground(new Color(0, 0, 0));
        telefono.setText("Teléfono");
        background.add(telefono, new AbsoluteConstraints(30, 430, -1, -1));

        jTextField_telefono.setBackground(new Color(255, 255, 255));
        jTextField_telefono.setDocument(new LimitarCamposPhone(15,
                "Ingrese su teléfono (código de país, el código de ciudad y el número de teléfono local)"));
        jTextField_telefono.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_telefono.setForeground(Color.gray);
        jTextField_telefono
                .setText("Ingrese su teléfono (código de país, el código de ciudad y el número de teléfono local)");
        jTextField_telefono.setBorder(null);
        jTextField_telefono.setMaximumSize(new Dimension(2147483647, 50));
        StaticMethods.handleFocusGain(jTextField_telefono,
                "Ingrese su teléfono (código de país, el código de ciudad y el número de teléfono local)");
        background.add(jTextField_telefono, new AbsoluteConstraints(30, 450, 550, -1));

        jSeparator12.setForeground(new Color(30, 30, 30));
        background.add(jSeparator12, new AbsoluteConstraints(30, 470, 550, 21));

        usuario.setBackground(new Color(0, 0, 0));
        usuario.setFont(new Font("Roboto", Font.PLAIN, 12));
        usuario.setForeground(new Color(0, 0, 0));
        usuario.setText("Usuario *");
        background.add(usuario, new AbsoluteConstraints(30, 480, -1, -1));

        jTextField_usuario.setBackground(new Color(255, 255, 255));
        jTextField_usuario.setDocument(new LimitarCamposSeguro(50, "Ingrese un usuario"));
        jTextField_usuario.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_usuario.setForeground(Color.gray);
        jTextField_usuario.setText("Ingrese un usuario");
        jTextField_usuario.setActionCommand("<Not Set>");
        jTextField_usuario.setBorder(null);
        jTextField_usuario.setMaximumSize(new Dimension(2147483647, 50));
        StaticMethods.handleFocusGain(jTextField_usuario, "Ingrese un usuario");
        background.add(jTextField_usuario, new AbsoluteConstraints(30, 500, 550, -1));

        jSeparator8.setForeground(new Color(30, 30, 30));
        background.add(jSeparator8, new AbsoluteConstraints(30, 520, 550, 21));

        contrasena.setBackground(new Color(0, 0, 0));
        contrasena.setFont(new Font("Roboto", Font.PLAIN, 12));
        contrasena.setForeground(new Color(0, 0, 0));
        contrasena.setText("Contraseña *");
        background.add(contrasena, new AbsoluteConstraints(30, 530, -1, -1));

        jPasswordField.setBackground(new Color(255, 255, 255));
        jPasswordField.setDocument(new LimitarCamposSeguro(20, "Ingrese una contraseña"));
        jPasswordField.setFont(new Font("Roboto", Font.PLAIN, 14));
        jPasswordField.setForeground(Color.gray);
        jPasswordField.setText("Ingrese una contraseña");
        jPasswordField.setBorder(null);
        jPasswordField.setMaximumSize(new Dimension(2147483647, 50));
        StaticMethods.handleFocusGain(jPasswordField, "Ingrese una contraseña");
        jPasswordField.addActionListener(this::jPasswordFieldActionPerformed);
        background.add(jPasswordField, new AbsoluteConstraints(30, 550, 550, -1));

        jSeparator7.setForeground(new Color(30, 30, 30));
        background.add(jSeparator7, new AbsoluteConstraints(30, 570, 550, 21));

        acceptTerms.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 12));
        acceptTerms.setForeground(new Color(102, 102, 102));
        acceptTerms.setText(
                "Al registrarse, usted acepta los términos y condiciones del servicio, y la política de privacidad. ");
        acceptTerms.setToolTipText("Aceptar términos y condiciones");
        acceptTerms.setBorder(null);
        acceptTerms.setCursor(new Cursor(Cursor.HAND_CURSOR));
        acceptTerms.setHorizontalAlignment(SwingConstants.LEFT);
        acceptTerms.setMaximumSize(new Dimension(600, 20));
        background.add(acceptTerms, new AbsoluteConstraints(30, 580, 550, 20));

        errorMessage.setFont(new Font("Roboto", Font.BOLD, 14));
        errorMessage.setForeground(Color.red);
        errorMessage.setHorizontalAlignment(SwingConstants.CENTER);
        errorMessage.setText("Error. ");
        errorMessage.setVisible(false);
        background.add(errorMessage, new AbsoluteConstraints(0, 650, 590, -1));

        extendTerms.setEditable(false);
        extendTerms.setBackground(new Color(255, 255, 255));
        extendTerms.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 12));
        extendTerms.setForeground(new Color(102, 102, 102));
        extendTerms.setLineWrap(true);
        extendTerms.setRows(5);
        extendTerms.setText(
                "Adicional si no esta registrado, se le creará un perfil. Su cédula debe coincidir para ver resultados, además no podrá corregirla al igual que su fecha de nacimiento. Los datos suministrados se consideran verdaderos, estrictamente personal, información confidencial y sensible.");
        extendTerms.setWrapStyleWord(true);
        extendTerms.setBorder(null);
        extendTerms.setFocusable(false);
        extendTerms.setPreferredSize(new Dimension(1576, 80));
        extendTerms.setRequestFocusEnabled(false);
        background.add(extendTerms, new AbsoluteConstraints(53, 600, 520, 50));

        button_registrarse.setBackground(new Color(0, 204, 51));
        button_registrarse.setFont(new Font("Roboto", Font.PLAIN, 12));
        button_registrarse.setForeground(new Color(0, 0, 0));
        button_registrarse.setHorizontalAlignment(SwingConstants.CENTER);
        button_registrarse.setText("Registrarse");
        button_registrarse.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button_registrarse.setHorizontalTextPosition(SwingConstants.CENTER);
        button_registrarse.setMaximumSize(new Dimension(600, 30));
        button_registrarse.setOpaque(true);
        button_registrarse.setPreferredSize(new Dimension(94, 20));
        button_registrarse.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                button_registrarseMouseClicked(evt);
            }
        });
        background.add(button_registrarse, new AbsoluteConstraints(150, 670, 300, -1));

        mensaje1.setBackground(Color.white);
        mensaje1.setFont(new Font("Roboto", Font.BOLD, 14));
        mensaje1.setForeground(new Color(0, 0, 102));
        mensaje1.setHorizontalAlignment(SwingConstants.LEFT);
        mensaje1.setText("Iniciar sesión");
        mensaje1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mensaje1.setHorizontalTextPosition(SwingConstants.CENTER);
        mensaje1.setOpaque(true);
        mensaje1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                iniciarSesionMouseClicked(evt);
            }
        });
        background.add(mensaje1, new AbsoluteConstraints(210, 700, 110, 20));

        mensaje2.setBackground(Color.white);
        mensaje2.setFont(new Font("Roboto", Font.BOLD, 14));
        mensaje2.setForeground(new Color(0, 0, 0));
        mensaje2.setHorizontalAlignment(SwingConstants.LEFT);
        mensaje2.setText("¿Ya estás registrado?");
        mensaje2.setHorizontalTextPosition(SwingConstants.CENTER);
        mensaje2.setOpaque(true);
        background.add(mensaje2, new AbsoluteConstraints(60, 700, 150, 20));

        jScrollPane1.setViewportView(background);

        getContentPane().add(jScrollPane1, new AbsoluteConstraints(0, 0, -1, -1));
        setIconImage(new ImageIcon(getClass().getResource("/images/Icon1.png")).getImage());

        setSize(new Dimension(616, 738));
        setLocationRelativeTo(PARENT_FRAME);
    }// </editor-fold>

    /* eventos */
    private void formComponentShown(ComponentEvent evt) {
        StaticMethods.setImageLabel(icon_project, "src/main/resources/images/operacionVacunas_Logo.png");
    }

    private void formWindowClosing(WindowEvent evt) {
        if (!isAnyFieldEmpty() || !isPlaceHolder()) {
            int confirm = JOptionPane.showConfirmDialog(null,
                    "¿Esta seguro de cerra esta ventana? Se perderán los datos que ingresó.", "Cerrando ventana...",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (confirm == 0) {
                iniciarSesionMouseClicked(null);
            }
        } else {
            iniciarSesionMouseClicked(null);
        }
    }

    private void iniciarSesionMouseClicked(MouseEvent evt) {
        PARENT_FRAME.setVisible(true);
        this.dispose();
    }

    /*
     * evento para insertar un usuario comprobando los campos y su previa existencia
     */
    private void button_registrarseMouseClicked(MouseEvent evt) {
        if (!button_registrarse.isEnabled()) {
            return;
        }

        button_registrarse.setEnabled(false); // deshabilitar el botón

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                button_registrarse.setEnabled(true);
            }
        }, REGISTER_DISABLE_TIME);

        boolean insertado = false;
        String nombreM = jTextField_nombre.getText();
        String apellidoM = jTextField_apellido.getText();
        String cedulaM = jTextField_cedula.getText();
        String fechaNacimientoM = jTextField_fechaNacimiento.getText();
        char sexoM = jComboBox_sexo.getSelectedItem().toString().charAt(0);
        String distritoM = jComboBox_distrito.getSelectedItem().toString();
        String direccionM = jTextField_direccion.getText();
        String correoM = jTextField_correo.getText();
        String telefonoM = jTextField_telefono.getText();
        String usuarioM = jTextField_usuario.getText();
        String rolM = rol.getText();
        errorMessage.setVisible(false);
        acceptTerms.setForeground(new Color(102, 102, 102));
        extendTerms.setForeground(new Color(102, 102, 102));

        if (!rolM.equals("Paciente")) {
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    JOptionPane.showMessageDialog(null,
                            "Registrarse con otro rol diferente a paciente no implementando. Lo sentimos. Se cerrará esta ventana.");
                    PARENT_FRAME.setVisible(true);
                    dispose();
                }
            }, 5);
        }

        boolean condicion1 = nombreM.isBlank() || nombreM.equals("Ingrese su nombre");
        boolean condicion2 = apellidoM.isBlank() || apellidoM.equals("Ingrese su apellido");
        boolean condicion3 = cedulaM.isBlank() || cedulaM.equals("Ingrese su cédula");
        boolean condicion4 = fechaNacimientoM.isBlank()
                || fechaNacimientoM.equals("Ingrese su fecha de nacimiento YYYY-MM-DD* hh:mm:ss");
        boolean condicion5 = sexoM == 'E';
        boolean condicion6 = usuarioM.isBlank() || usuarioM.equals("Ingrese un usuario");
        boolean condicion7 = String.valueOf(jPasswordField.getPassword()).isBlank()
                || String.valueOf(jPasswordField.getPassword()).equals("Ingrese una contraseña");
        boolean condicionesObligatorias = !condicion1 && !condicion2 && !condicion3 && !condicion4 && !condicion5
                && !condicion6 && !condicion7;

        boolean condicionOp1 = distritoM == null || distritoM.equals("Elegir");
        boolean condicionOp2 = direccionM.isBlank() || direccionM.equals("Ingrese su dirección");
        boolean condicionOp3 = correoM.isBlank() || correoM.equals("Ingrese su correo electrónico");
        boolean condicionOp4 = telefonoM.isBlank() || telefonoM
                .equals("Ingrese su teléfono (código de país, el código de ciudad y el número de teléfono local)");

        boolean verificacion1 = !cedulaM
                .matches("^(PE|E|N|[23456789](?:AV|PI)?|1[0123]?(?:AV|PI)?)-(\\d{1,4})-(\\d{1,6})$");
        boolean verificacion2 = (!fechaNacimientoM.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$")
                && !fechaNacimientoM.matches(
                        "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]) (0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9](\\.\\d{1,9})?$"));
        boolean verificacion3 = !correoM.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
        boolean verificacion4 = (condicionOp1 && !condicionOp2) || (!condicionOp1 && condicionOp2);

        errorMessage.setVisible(false);
        errorMessage.setForeground(Color.gray);

        if (acceptTerms.getSelectedObjects() == null) {
            acceptTerms.setForeground(Color.red);
            extendTerms.setForeground(Color.red);
        } else if (!condicionesObligatorias) {
            errorMessage.setText("Error. Algunos campos son obligatorios*. Revisar");
            errorMessage.setVisible(true);
            errorMessage.setForeground(Color.red);
            button_registrarse.setEnabled(true);
            return;
        } else {
            if (verificacion1) {
                errorMessage.setText("Error. La cédula no tiene el formato correcto.");
                errorMessage.setForeground(Color.red);
                errorMessage.setVisible(true);
                return;
            } else if (verificacion2) {
                errorMessage.setText(
                        "Error. La fecha de nacimiento no tiene el formato correcto. La fecha sin hora es obligatorio. YYYY-MM-DD");
                errorMessage.setForeground(Color.red);
                errorMessage.setVisible(true);
                return;
            } else if (!condicionOp3 && verificacion3) {
                errorMessage.setText("Error. El correo electrónico no tiene el formato correcto.");
                errorMessage.setForeground(Color.red);
                errorMessage.setVisible(true);
                return;
            } else if (verificacion4) {
                errorMessage.setText(
                        "Error. La dirección o el distrito están incompletos. Debe llenar ambos campos o ninguno.");
                errorMessage.setForeground(Color.red);
                errorMessage.setVisible(true);
                return;
            } else {
                if (UserManager.buscar(cedulaM, rolM) == null) {
                    try {
                        Timestamp fechaNacimientoTimestamp;
                        if (fechaNacimientoM.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$")) {
                            fechaNacimientoTimestamp = Timestamp
                                    .valueOf(LocalDate.parse(fechaNacimientoM).atStartOfDay());
                        } else {
                            fechaNacimientoTimestamp = Timestamp.valueOf(fechaNacimientoM);

                        }

                        if (!condicionOp1 && !condicionOp2) {
                            if (!condicionOp3 && !condicionOp4) {
                                insertado = UserManager.insertar(nombreM, apellidoM, cedulaM, fechaNacimientoTimestamp,
                                        sexoM, distritoM, direccionM, correoM, telefonoM, usuarioM,
                                        String.valueOf(jPasswordField.getPassword()), rolM);
                            } else if (!condicionOp3) {
                                insertado = UserManager.insertar(nombreM, apellidoM, cedulaM, fechaNacimientoTimestamp,
                                        sexoM, distritoM, direccionM, correoM, null, usuarioM,
                                        String.valueOf(jPasswordField.getPassword()), rolM);
                            } else {
                                insertado = UserManager.insertar(nombreM, apellidoM, cedulaM, fechaNacimientoTimestamp,
                                        sexoM, distritoM, direccionM, null, null, usuarioM,
                                        String.valueOf(jPasswordField.getPassword()), rolM);
                            }
                        } else if (!condicionOp3) {
                            if (!condicionOp4) {
                                insertado = UserManager.insertar(nombreM, apellidoM, cedulaM, fechaNacimientoTimestamp,
                                        sexoM, null, null, correoM, telefonoM, usuarioM,
                                        String.valueOf(jPasswordField.getPassword()), rolM);
                            } else {
                                insertado = UserManager.insertar(nombreM, apellidoM, cedulaM, fechaNacimientoTimestamp,
                                        sexoM, null, null, correoM, null, usuarioM,
                                        String.valueOf(jPasswordField.getPassword()), rolM);
                            }
                        } else if (!condicionOp4) {
                            insertado = UserManager.insertar(nombreM, apellidoM, cedulaM, fechaNacimientoTimestamp,
                                    sexoM, null, null, null, telefonoM, usuarioM,
                                    String.valueOf(jPasswordField.getPassword()), rolM);
                        } else {
                            insertado = UserManager.insertar(nombreM, apellidoM, cedulaM, fechaNacimientoTimestamp,
                                    sexoM, null, null, null, null, usuarioM,
                                    String.valueOf(jPasswordField.getPassword()), rolM);
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                        JOptionPane.showMessageDialog(this,
                                "Ha ocurrido un problema registrando al paciente y su usuario. No hay certeza si los datos fueron manipulados. "
                                        +
                                        "\nGuarde los datos para futuro registro. Reinicie la aplicación o contacte a soporte");
                    }
                } else {
                    errorMessage.setText(
                            "La cédula ya está registrada para este rol. Acceda para modificar sus datos o click olvidó su contraseña.");
                    errorMessage.setForeground(Color.red);
                    errorMessage.setVisible(true);
                    return;
                }
            }
        }

        if (insertado) {
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    JOptionPane.showMessageDialog(null,
                            "Se ha registrado con éxito. En unos momentos se cerrará esta ventana y podrá iniciar sesión.");
                    PARENT_FRAME.setVisible(true);
                    dispose();
                }
            }, 5);
        } else
            JOptionPane.showMessageDialog(null,
                    "Ha ocurrido error al registrarse. Intentar más tarde o contacte a soporte", "ERROR REGISTRAR",
                    JOptionPane.ERROR_MESSAGE);
    }

    private void jPasswordFieldActionPerformed(ActionEvent evt) {
        acceptTerms.setSelected(true);
        acceptTerms.requestFocus();
        button_registrarseMouseClicked(null);
    }

    private void jTextField_direccionActionPerformed(ActionEvent evt) {
        if (jComboBox_distrito.getSelectedIndex() == 0) {
            jComboBox_distrito.setSelectedIndex(1);
        }
        jTextField_correo.requestFocus();
    }

    /* método para personalizar al iniciar clase */
    public void setRol(String rol) {
        this.rol.setText(rol);
    }

    public void setButtonSubmit(String estado) {
        this.button_registrarse.setText(estado);
    }

    /* métodos para comprobar llenado de campos */
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
                || jTextField_fechaNacimiento.getText().equals("Ingrese su fecha de nacimiento YYYY-MM-DD* hh:mm:ss")
                || jTextField_usuario.getText().equals("Ingrese un usuario")
                || String.valueOf(jPasswordField.getPassword()).equals("Ingrese una contraseña")
                || jComboBox_sexo.getSelectedIndex() == 0;
    }

    /* método para añadir los listeners de esta clase */
    private void addListeners() {
        StaticMethods.addFocusListeners(jTextField_nombre, "Ingrese su nombre");
        StaticMethods.addFocusListeners(jTextField_apellido, "Ingrese su apellido");
        StaticMethods.addFocusListeners(jTextField_cedula, "Ingrese su cédula");
        StaticMethods.addFocusListeners(jTextField_fechaNacimiento,
                "Ingrese su fecha de nacimiento YYYY-MM-DD* hh:mm:ss");
        StaticMethods.addFocusListeners(jTextField_direccion, "Ingrese su dirección");
        StaticMethods.addFocusListeners(jTextField_correo, "Ingrese su correo electrónico");
        StaticMethods.addFocusListeners(jTextField_telefono,
                "Ingrese su teléfono (código de país, el código de ciudad y el número de teléfono local)");
        StaticMethods.addFocusListeners(jTextField_usuario, "Ingrese un usuario");
        StaticMethods.addFocusListeners(jPasswordField, "Ingrese una contraseña");

        // Action Listener
        StaticMethods.addActionListeners(jTextField_nombre, jTextField_apellido);
        StaticMethods.addActionListeners(jTextField_apellido, jTextField_cedula);
        StaticMethods.addActionListeners(jTextField_cedula, jTextField_fechaNacimiento);
        StaticMethods.addActionListeners(jTextField_fechaNacimiento, jTextField_direccion);
        StaticMethods.addActionListeners(jTextField_correo, jTextField_telefono);
        StaticMethods.addActionListeners(jTextField_telefono, jTextField_usuario);
        StaticMethods.addActionListeners(jTextField_usuario, jPasswordField);
    }

    /* Main de prueba individual */
    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarUser.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }

        SwingUtilities.invokeLater(() -> {
            RegistrarUser r = new RegistrarUser(new Login());
            r.setVisible(true);
            r.requestFocusInWindow();
        });
    }

    /* variables propias */
    private final JFrame PARENT_FRAME;
    private final long REGISTER_DISABLE_TIME = 30000;

    // Variables declaration - do not modify
    private JCheckBox acceptTerms;
    private JLabel apellido;
    private JPanel background;
    private JLabel button_registrarse;
    private JLabel cedula;
    private JLabel contrasena;
    private JLabel correo;
    private JLabel direccion;
    private JLabel distrito;
    private JLabel errorMessage;
    private JTextArea extendTerms;
    private JLabel fecha_nacimiento;
    private JLabel icon_project;
    private JComboBox<String> jComboBox_distrito;
    private JComboBox<String> jComboBox_sexo;
    private JPasswordField jPasswordField;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator10;
    private JSeparator jSeparator12;
    private JSeparator jSeparator3;
    private JSeparator jSeparator4;
    private JSeparator jSeparator5;
    private JSeparator jSeparator6;
    private JSeparator jSeparator7;
    private JSeparator jSeparator8;
    private JSeparator jSeparator9;
    private JTextField jTextField_apellido;
    private JTextField jTextField_cedula;
    private JTextField jTextField_correo;
    private JTextField jTextField_direccion;
    private JTextField jTextField_fechaNacimiento;
    private JTextField jTextField_nombre;
    private JTextField jTextField_telefono;
    private JTextField jTextField_usuario;
    private JLabel mensaje1;
    private JLabel mensaje2;
    private JLabel nombre;
    private JLabel rol;
    private JLabel rol_escogido;
    private JLabel sexo;
    private JLabel telefono;
    private JLabel titulo;
    private JLabel usuario;
    // End of variables declaration
}
