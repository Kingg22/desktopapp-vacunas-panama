package Trabajo.Ventanas;

import java.awt.*;
import javax.swing.*;

public class Login extends javax.swing.JFrame {

        public Login() {
                initComponents();
                toggleLogin(false);
                addRoleButtonListeners();
                this.setImageLabal(paciente_icon, "src/images/patient_icon.png");
                this.setImageLabal(doctor_icon, "src/images/doctor_icon.png");
                this.setImageLabal(proveedor_icon, "src/images/supplier_icon.png");
                this.setImageLabal(administrativo_icon, "src/images/administrative_icon.png");
                this.setImageLabal(autoridad_icon, "src/images/authority_icon.png");
        }

        private void initComponents() {
                background = new javax.swing.JPanel();
                icon_project = new javax.swing.JLabel();
                jPanel_background_loginInput = new javax.swing.JPanel();
                elija_su_rol = new javax.swing.JLabel();
                bienvenido = new javax.swing.JLabel();
                userInput = new javax.swing.JTextField();
                passwordInput = new javax.swing.JPasswordField();
                jPanel_loginBotton = new javax.swing.JPanel();
                iniciarSesion = new javax.swing.JLabel();
                jPanel_autoridadBotton = new javax.swing.JPanel();
                autoridad = new javax.swing.JLabel();
                autoridad_icon = new javax.swing.JLabel();
                jPanel_AdministrativoBotton = new javax.swing.JPanel();
                administrativo = new javax.swing.JLabel();
                administrativo_icon = new javax.swing.JLabel();
                jPanel_proveedorBotton = new javax.swing.JPanel();
                proveedor = new javax.swing.JLabel();
                proveedor_icon = new javax.swing.JLabel();
                jPanel_doctorBotton = new javax.swing.JPanel();
                doctor = new javax.swing.JLabel();
                doctor_icon = new javax.swing.JLabel();
                jPanel_pacienteBotton = new javax.swing.JPanel();
                paciente = new javax.swing.JLabel();
                paciente_icon = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setTitle("Login - MINSA");
                setLocationByPlatform(true);
                setPreferredSize(new java.awt.Dimension(900, 600));

                background.setBackground(new java.awt.Color(255, 255, 255));
                background.setMinimumSize(new java.awt.Dimension(900, 600));
                background.setPreferredSize(new java.awt.Dimension(800, 600));
                background.setLayout(new java.awt.BorderLayout());

                icon_project.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                icon_project.setIcon(
                                new javax.swing.ImageIcon(getClass().getResource("/images/operacionVacunas_logo.png")));
                icon_project.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                icon_project.setPreferredSize(new java.awt.Dimension(400, 600));
                icon_project.addComponentListener(new java.awt.event.ComponentAdapter() {
                        public void componentResized(java.awt.event.ComponentEvent evt) {
                                labelResized(evt);
                        }
                });

                background.add(icon_project, java.awt.BorderLayout.CENTER);

                jPanel_background_loginInput.setBackground(java.awt.Color.pink);
                jPanel_background_loginInput.setPreferredSize(new java.awt.Dimension(400, 600));
                jPanel_background_loginInput.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                elija_su_rol.setBackground(new java.awt.Color(153, 153, 153));
                elija_su_rol.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
                elija_su_rol.setText("Elija su rol");

                jPanel_background_loginInput.add(elija_su_rol,
                                new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 116, -1, -1));

                bienvenido.setBackground(new java.awt.Color(0, 0, 0));
                bienvenido.setFont(new java.awt.Font("Microsoft YaHei", 1, 24));
                bienvenido.setText("!Bienvenido!");

                jPanel_background_loginInput.add(bienvenido,
                                new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 65, -1, -1));

                userInput.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
                userInput.setForeground(java.awt.Color.gray);
                userInput.setText("usuario");
                userInput.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mousePressed(java.awt.event.MouseEvent evt) {
                                userInputMousePressed(evt);
                        }
                });
                userInput.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                userInputActionPerformed(evt);
                        }
                });

                jPanel_background_loginInput.add(userInput,
                                new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 406, 240, -1));

                passwordInput.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
                passwordInput.setForeground(java.awt.Color.gray);
                passwordInput.setText("contraseña");
                passwordInput.setToolTipText("");
                passwordInput.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mousePressed(java.awt.event.MouseEvent evt) {
                                passwordInputMousePressed(evt);
                        }
                });
                passwordInput.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                passwordInputActionPerformed(evt);
                        }
                });

                jPanel_background_loginInput.add(passwordInput,
                                new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 446, 240, -1));
                jPanel_loginBotton.setBackground(new java.awt.Color(38, 70, 147));
                jPanel_loginBotton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                jPanel_loginBotton.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                jPanel_loginBottonMouseClicked(evt);
                        }
                });

                iniciarSesion.setBackground(new java.awt.Color(255, 255, 255));
                iniciarSesion.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
                iniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
                iniciarSesion.setText("Iniciar Sesión");

                javax.swing.GroupLayout jPanel_loginBottonLayout = new javax.swing.GroupLayout(jPanel_loginBotton);
                jPanel_loginBotton.setLayout(jPanel_loginBottonLayout);
                jPanel_loginBottonLayout.setHorizontalGroup(
                                jPanel_loginBottonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel_loginBottonLayout.createSequentialGroup()
                                                                .addGap(19, 19, 19)
                                                                .addComponent(iniciarSesion)
                                                                .addContainerGap(14, Short.MAX_VALUE)));
                jPanel_loginBottonLayout.setVerticalGroup(
                                jPanel_loginBottonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel_loginBottonLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(iniciarSesion,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                28, Short.MAX_VALUE)
                                                                .addContainerGap()));

                jPanel_background_loginInput.add(jPanel_loginBotton,
                                new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 486, -1, -1));
                jPanel_autoridadBotton.setBackground(new java.awt.Color(255, 255, 255));
                jPanel_autoridadBotton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                jPanel_autoridadBotton.setPreferredSize(new java.awt.Dimension(130, 40));

                autoridad.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
                autoridad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                autoridad.setText("Autoridad");
                autoridad.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
                autoridad.setPreferredSize(new java.awt.Dimension(83, 17));
                autoridad_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/patient_icon.png")));

                javax.swing.GroupLayout jPanel_autoridadBottonLayout = new javax.swing.GroupLayout(
                                jPanel_autoridadBotton);
                jPanel_autoridadBotton.setLayout(jPanel_autoridadBottonLayout);
                jPanel_autoridadBottonLayout.setHorizontalGroup(
                                jPanel_autoridadBottonLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(
                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                jPanel_autoridadBottonLayout.createSequentialGroup()
                                                                                .addContainerGap()
                                                                                .addComponent(autoridad_icon,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                25,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(autoridad,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addContainerGap()));
                jPanel_autoridadBottonLayout.setVerticalGroup(jPanel_autoridadBottonLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel_autoridadBottonLayout.createSequentialGroup().addContainerGap()
                                                .addGroup(jPanel_autoridadBottonLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(autoridad,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(autoridad_icon,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                28,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));

                jPanel_background_loginInput.add(jPanel_autoridadBotton,
                                new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 353, -1, -1));

                jPanel_AdministrativoBotton.setBackground(new java.awt.Color(255, 255, 255));
                jPanel_AdministrativoBotton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                jPanel_AdministrativoBotton.setPreferredSize(new java.awt.Dimension(130, 40));
                administrativo.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
                administrativo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                administrativo.setText("Administrativo");
                administrativo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
                administrativo_icon
                                .setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/patient_icon.png")));

                javax.swing.GroupLayout jPanel_AdministrativoBottonLayout = new javax.swing.GroupLayout(
                                jPanel_AdministrativoBotton);
                jPanel_AdministrativoBotton.setLayout(jPanel_AdministrativoBottonLayout);
                jPanel_AdministrativoBottonLayout.setHorizontalGroup(
                                jPanel_AdministrativoBottonLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                jPanel_AdministrativoBottonLayout
                                                                                .createSequentialGroup()
                                                                                .addGap(0, 8, Short.MAX_VALUE)
                                                                                .addComponent(administrativo_icon,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                25,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(administrativo)
                                                                                .addContainerGap()));
                jPanel_AdministrativoBottonLayout
                                .setVerticalGroup(
                                                jPanel_AdministrativoBottonLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel_AdministrativoBottonLayout
                                                                                .createSequentialGroup()
                                                                                .addContainerGap()
                                                                                .addGroup(jPanel_AdministrativoBottonLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                .addComponent(administrativo_icon,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                28,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(administrativo))
                                                                                .addContainerGap()));

                jPanel_background_loginInput.add(jPanel_AdministrativoBotton,
                                new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 303, -1, -1));

                jPanel_proveedorBotton.setBackground(new java.awt.Color(255, 255, 255));
                jPanel_proveedorBotton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                jPanel_proveedorBotton.setPreferredSize(new java.awt.Dimension(130, 40));
                proveedor.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
                proveedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                proveedor.setText("Proveedor");
                proveedor.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
                proveedor.setPreferredSize(new java.awt.Dimension(83, 17));
                proveedor_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/patient_icon.png")));

                javax.swing.GroupLayout jPanel_proveedorBottonLayout = new javax.swing.GroupLayout(
                                jPanel_proveedorBotton);
                jPanel_proveedorBotton.setLayout(jPanel_proveedorBottonLayout);
                jPanel_proveedorBottonLayout.setHorizontalGroup(
                                jPanel_proveedorBottonLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(
                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                jPanel_proveedorBottonLayout.createSequentialGroup()
                                                                                .addContainerGap()
                                                                                .addComponent(proveedor_icon,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                25,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(proveedor,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addContainerGap(
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)));
                jPanel_proveedorBottonLayout.setVerticalGroup(jPanel_proveedorBottonLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel_proveedorBottonLayout.createSequentialGroup().addGap(5, 5, 5)
                                                .addGroup(jPanel_proveedorBottonLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(proveedor,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(proveedor_icon,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                28,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 7, Short.MAX_VALUE)));
                jPanel_background_loginInput.add(jPanel_proveedorBotton,
                                new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 253, -1, -1));

                jPanel_doctorBotton.setBackground(new java.awt.Color(255, 255, 255));
                jPanel_doctorBotton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                jPanel_doctorBotton.setPreferredSize(new java.awt.Dimension(130, 40));
                doctor.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
                doctor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                doctor.setText("Doctor");
                doctor.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
                doctor.setPreferredSize(new java.awt.Dimension(83, 17));
                doctor_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/patient_icon.png")));

                javax.swing.GroupLayout jPanel_doctorBottonLayout = new javax.swing.GroupLayout(jPanel_doctorBotton);
                jPanel_doctorBotton.setLayout(jPanel_doctorBottonLayout);
                jPanel_doctorBottonLayout.setHorizontalGroup(
                                jPanel_doctorBottonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel_doctorBottonLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(doctor_icon,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                25,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(doctor,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap()));
                jPanel_doctorBottonLayout.setVerticalGroup(jPanel_doctorBottonLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel_doctorBottonLayout.createSequentialGroup().addContainerGap()
                                                .addGroup(jPanel_doctorBottonLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(doctor,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(doctor_icon,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                28,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(14, 14, 14)));
                jPanel_background_loginInput.add(jPanel_doctorBotton,
                                new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 203, -1, -1));
                jPanel_pacienteBotton.setBackground(new java.awt.Color(255, 255, 255));
                jPanel_pacienteBotton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                jPanel_pacienteBotton.setPreferredSize(new java.awt.Dimension(130, 40));
                paciente.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
                paciente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                paciente.setText("Paciente");
                paciente.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
                paciente.setPreferredSize(new java.awt.Dimension(83, 17));
                paciente_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/patient_icon.png")));

                javax.swing.GroupLayout jPanel_pacienteBottonLayout = new javax.swing.GroupLayout(
                                jPanel_pacienteBotton);
                jPanel_pacienteBotton.setLayout(jPanel_pacienteBottonLayout);
                jPanel_pacienteBottonLayout.setHorizontalGroup(
                                jPanel_pacienteBottonLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(
                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                jPanel_pacienteBottonLayout.createSequentialGroup()
                                                                                .addContainerGap()
                                                                                .addComponent(paciente_icon,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                25,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(paciente,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addContainerGap(10, Short.MAX_VALUE)));
                jPanel_pacienteBottonLayout.setVerticalGroup(jPanel_pacienteBottonLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel_pacienteBottonLayout.createSequentialGroup().addContainerGap()
                                                .addGroup(jPanel_pacienteBottonLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(paciente,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(paciente_icon,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                28,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));

                jPanel_background_loginInput.add(jPanel_pacienteBotton,
                                new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 153, -1, -1));
                background.add(jPanel_background_loginInput, java.awt.BorderLayout.WEST);

                getContentPane().add(background, java.awt.BorderLayout.CENTER);
                pack();
                setLocationRelativeTo(null);
        }

        public void setImageLabal(JLabel label, String imagen) {
                ImageIcon image = new ImageIcon(imagen);
                Icon icon = new ImageIcon(
                                image.getImage().getScaledInstance(label.getWidth(), label.getHeight(),
                                                Image.SCALE_DEFAULT));
                label.setIcon(icon);
                this.repaint();
        }

        private void labelResized(java.awt.event.ComponentEvent evt) {
                this.setImageLabal(icon_project, "src/images/operacionVacunas_Logo.png");
        }

        // eventos
        private void jPanel_loginBottonMouseClicked(java.awt.event.MouseEvent evt) {
                if (userInput.getText().isBlank() || userInput.getText().equals("usuario")
                                || String.valueOf(passwordInput.getPassword()).equals("contraseña")
                                || String.valueOf(passwordInput.getPassword()).isBlank()) {
                        JOptionPane.showMessageDialog(null, "Por favor completar ambos campos de inicio de sesión",
                                        "Error campos incompletos", JOptionPane.ERROR_MESSAGE);
                        toggleLogin(false);
                        this.roleButtonMouseClicked(selectedButton);
                        userInput.setText("usuario");
                        userInput.setForeground(Color.GRAY);
                        passwordInput.setText("contraseña");
                        passwordInput.setForeground(Color.GRAY);
                } else {
                        JLabel rol = (JLabel) selectedButton.getComponent(1);
                        String rolText = rol.getText();
                        if (true) {
                                // IMPLEMENTAR VALIDACION DE INICIO DE SESION
                                switch (rolText) {
                                        /*
                                         * case ("Paciente") -> {
                                         * base = new PantallaPaciente();
                                         * base.setVisible(true);
                                         * // Establecer el tamaño del JFrame a las dimensiones de la pantalla
                                         * base.setVisible(true);
                                         * base.setExtendedState(JFrame.MAXIMIZED_BOTH);
                                         * this.dispose();
                                         * }
                                         * case ("Doctor") -> {
                                         * base = new DOCTOR();
                                         * base.setVisible(true);
                                         * // Establecer el tamaño del JFrame a las dimensiones de la pantalla
                                         * Dimension screenSize = base.getVisibleScreenSize();
                                         * base.setSize(screenSize.width, screenSize.height);
                                         * base.setVisible(true);
                                         * base.setExtendedState(JFrame.MAXIMIZED_BOTH);
                                         * this.dispose();
                                         * }
                                         * case ("Administrativo") -> {
                                         * base = new ADMINISTRATIVO);
                                         * base.setVisible(true);
                                         * // Establecer el tamaño del JFrame a las dimensiones de la pantalla
                                         * Dimension screenSize = base.getVisibleScreenSize();
                                         * base.setSize(screenSize.width, screenSize.height);
                                         * base.setVisible(true);
                                         * base.setExtendedState(JFrame.MAXIMIZED_BOTH);
                                         * this.dispose();
                                         * }
                                         * case ("Autoridad") -> {
                                         * base = new AUTORIDADES();
                                         * base.setVisible(true);
                                         * // Establecer el tamaño del JFrame a las dimensiones de la pantalla
                                         * Dimension screenSize = base.getVisibleScreenSize();
                                         * base.setSize(screenSize.width, screenSize.height);
                                         * base.setVisible(true);
                                         * base.setExtendedState(JFrame.MAXIMIZED_BOTH);
                                         * this.dispose();
                                         * }
                                         * case ("Proveedor") -> {
                                         * base = new PROVEEDOR();
                                         * base.setVisible(true);
                                         * // Establecer el tamaño del JFrame a las dimensiones de la pantalla
                                         * Dimension screenSize = base.getVisibleScreenSize();
                                         * base.setSize(screenSize.width, screenSize.height);
                                         * base.setVisible(true);
                                         * base.setExtendedState(JFrame.MAXIMIZED_BOTH);
                                         * this.dispose();
                                         * }
                                         */
                                        default -> {
                                                JOptionPane.showMessageDialog(null,
                                                                "Error al crear el nuevo frame según rol ",
                                                                "Error switch rol", JOptionPane.ERROR_MESSAGE);
                                                toggleLogin(false);
                                                this.roleButtonMouseClicked(selectedButton);
                                                userInput.setText("usuario");
                                                userInput.setForeground(Color.GRAY);
                                                passwordInput.setText("contraseña");
                                                passwordInput.setForeground(Color.GRAY);
                                        }
                                }
                        } else {
                                this.roleButtonMouseClicked(selectedButton);
                                toggleLogin(false);
                                JOptionPane.showMessageDialog(null,
                                                "Error al iniciar sesión. Intente nuevamente. Revise su rol y credenciales ",
                                                "Error Pantalla Login", JOptionPane.ERROR_MESSAGE);
                                userInput.setText("usuario");
                                userInput.setForeground(Color.GRAY);
                                passwordInput.setText("contraseña");
                                passwordInput.setForeground(Color.GRAY);
                        }
                }
        }

        private void userInputMousePressed(java.awt.event.MouseEvent evt) {
                if (userInput.getText().equals("usuario")) {
                        userInput.setText("");
                        userInput.setForeground(Color.BLACK);
                }
                if (String.valueOf(passwordInput.getPassword()).isEmpty()
                                || String.valueOf(passwordInput.getPassword()).isBlank()) {
                        passwordInput.setText("contraseña");
                        passwordInput.setForeground(Color.GRAY);
                }
        }

        private void passwordInputMousePressed(java.awt.event.MouseEvent evt) {
                if (String.valueOf(passwordInput.getPassword()).equals("contraseña")) {
                        passwordInput.setText("");
                        passwordInput.setForeground(Color.BLACK);
                }
                if (userInput.getText().isEmpty() || userInput.getText().isBlank()) {
                        userInput.setText("usuario");
                        userInput.setForeground(Color.GRAY);
                }
        }

        private void userInputActionPerformed(java.awt.event.ActionEvent evt) {
                if (userInput.getText().isBlank()) {
                        userInput.setText("usuario");
                        userInput.setForeground(Color.GRAY);
                }
                passwordInput.setText("");
                passwordInput.setForeground(Color.BLACK);
                passwordInput.requestFocus();
        }

        private void passwordInputActionPerformed(java.awt.event.ActionEvent evt) {
                if (String.valueOf(passwordInput.getPassword()).isBlank()) {
                        passwordInput.setText("contraseña");
                        passwordInput.setForeground(Color.GRAY);
                }
                jPanel_loginBottonMouseClicked(null);
        }

        private void toggleLogin(boolean show) {
                userInput.setVisible(show);
                passwordInput.setVisible(show);
                jPanel_loginBotton.setVisible(show);
                if (!show) {
                    userInput.setText("usuario");
                    userInput.setForeground(Color.GRAY);
                    passwordInput.setText("contraseña");
                    passwordInput.setForeground(Color.GRAY);
                }
        }

        private void addRoleButtonListeners() {
                addRoleButtonListener(jPanel_pacienteBotton);
                addRoleButtonListener(jPanel_doctorBotton);
                addRoleButtonListener(jPanel_AdministrativoBotton);
                addRoleButtonListener(jPanel_autoridadBotton);
                addRoleButtonListener(jPanel_proveedorBotton);
        }

        private void addRoleButtonListener(JPanel roleButton) {
                roleButton.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                roleButtonMouseClicked(roleButton);
                        }
                });
        }

        private void roleButtonMouseClicked(JPanel roleButton) {
                if (selectedButton != null && selectedButton == roleButton) {
                        // Unselect current button
                        toggleLogin(false);
                        selectedButton = null;
                        roleButton.setBackground(Color.white);
                } else {
                        if (selectedButton != null) {
                                toggleLogin(false);
                                selectedButton.setBackground(Color.white);
                        }
                        // Select new button
                        toggleLogin(true);
                        selectedButton = roleButton;
                        selectedButton.setBackground(new Color(194, 43, 33));
                }
        }

        public static void main(String[] args) {
                try {
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                                        .getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                                | UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                }
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new Login().setVisible(true);
                        }
                });
        }

        // mi variable
        private JPanel selectedButton = null;
        // private PantallaPrincipalBase base = null;

        // Variables declaration
        private javax.swing.JLabel administrativo;
        private javax.swing.JLabel administrativo_icon;
        private javax.swing.JLabel autoridad;
        private javax.swing.JLabel autoridad_icon;
        private javax.swing.JPanel background;
        private javax.swing.JLabel bienvenido;
        private javax.swing.JLabel doctor;
        private javax.swing.JLabel doctor_icon;
        private javax.swing.JLabel elija_su_rol;
        private javax.swing.JLabel icon_project;
        private javax.swing.JLabel iniciarSesion;
        private javax.swing.JPanel jPanel_AdministrativoBotton;
        private javax.swing.JPanel jPanel_autoridadBotton;
        private javax.swing.JPanel jPanel_background_loginInput;
        private javax.swing.JPanel jPanel_doctorBotton;
        private javax.swing.JPanel jPanel_loginBotton;
        private javax.swing.JPanel jPanel_pacienteBotton;
        private javax.swing.JPanel jPanel_proveedorBotton;
        private javax.swing.JLabel paciente;
        private javax.swing.JLabel paciente_icon;
        private javax.swing.JPasswordField passwordInput;
        private javax.swing.JLabel proveedor;
        private javax.swing.JLabel proveedor_icon;
        private javax.swing.JTextField userInput;
        // End of variables declaration
}