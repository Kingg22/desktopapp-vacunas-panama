package desktop_interface;

import desktop_interface.util.StaticMethods;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.*;

public class PantallaBlock extends JFrame {

        public PantallaBlock(JFrame parent) {
                initComponents();
                PARENT_FRAME = parent;

                JButton[] botones = { button_opcion1, button_opcion2, button_opcion3, button_opcion4, button_opcion5,
                                button_modificarDatos, button_modificarCred, button_preferencias, button_soporte };
                for (JButton boton : botones) {
                        boton.setUI(new BasicButtonUI());
                        boton.setBackground(new Color(86, 86, 86));
                }
                button_logOut.setUI(new BasicButtonUI());

                this.setExtendedState(MAXIMIZED_BOTH);
                this.requestFocusInWindow();
        }

        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        private void initComponents() {
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
                jLabel9 = new JLabel();

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
                                                .addGap(0, 0, Short.MAX_VALUE));
                separador1Layout.setVerticalGroup(
                                separador1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGap(0, 0, Short.MAX_VALUE));

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
                                                .addGap(0, 0, Short.MAX_VALUE));
                separador3Layout.setVerticalGroup(
                                separador3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGap(0, 0, Short.MAX_VALUE));

                jPanel_menuOpciones.add(separador3);

                rolName.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
                rolName.setForeground(new Color(255, 255, 255));
                rolName.setHorizontalAlignment(SwingConstants.CENTER);
                rolName.setText("¡ Hola Rol !");
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

                separador2.setBackground(new Color(39, 104, 165));
                separador2.setForeground(new Color(48, 48, 46));
                separador2.setPreferredSize(new Dimension(150, 20));

                GroupLayout separador2Layout = new GroupLayout(separador2);
                separador2.setLayout(separador2Layout);
                separador2Layout.setHorizontalGroup(
                                separador2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGap(0, 0, Short.MAX_VALUE));
                separador2Layout.setVerticalGroup(
                                separador2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGap(0, 0, Short.MAX_VALUE));

                jPanel_menuOpciones.add(separador2);

                button_opcion1.setForeground(new Color(255, 255, 255));
                button_opcion1.setText("Opción 1 ");
                button_opcion1.setCursor(new Cursor(Cursor.HAND_CURSOR));
                button_opcion1.setEnabled(false);
                button_opcion1.setFocusable(false);
                button_opcion1.setPreferredSize(new Dimension(160, 30));
                button_opcion1.setRequestFocusEnabled(false);
                jPanel_menuOpciones.add(button_opcion1);

                button_opcion2.setForeground(new Color(255, 255, 255));
                button_opcion2.setText("Opción 2");
                button_opcion2.setCursor(new Cursor(Cursor.HAND_CURSOR));
                button_opcion2.setEnabled(false);
                button_opcion2.setFocusable(false);
                button_opcion2.setPreferredSize(new Dimension(160, 30));
                button_opcion2.setRequestFocusEnabled(false);
                jPanel_menuOpciones.add(button_opcion2);

                button_opcion3.setForeground(new Color(255, 255, 255));
                button_opcion3.setText("Opción 3");
                button_opcion3.setCursor(new Cursor(Cursor.HAND_CURSOR));
                button_opcion3.setEnabled(false);
                button_opcion3.setFocusable(false);
                button_opcion3.setPreferredSize(new Dimension(160, 30));
                button_opcion3.setRequestFocusEnabled(false);
                jPanel_menuOpciones.add(button_opcion3);

                button_opcion4.setForeground(new Color(255, 255, 255));
                button_opcion4.setText("Opción 4");
                button_opcion4.setCursor(new Cursor(Cursor.HAND_CURSOR));
                button_opcion4.setEnabled(false);
                button_opcion4.setFocusable(false);
                button_opcion4.setPreferredSize(new Dimension(160, 30));
                button_opcion4.setRequestFocusEnabled(false);
                jPanel_menuOpciones.add(button_opcion4);

                button_opcion5.setForeground(new Color(255, 255, 255));
                button_opcion5.setText("Opción 5");
                button_opcion5.setCursor(new Cursor(Cursor.HAND_CURSOR));
                button_opcion5.setEnabled(false);
                button_opcion5.setFocusable(false);
                button_opcion5.setPreferredSize(new Dimension(160, 30));
                button_opcion5.setRequestFocusEnabled(false);
                jPanel_menuOpciones.add(button_opcion5);

                separador4.setBackground(new Color(39, 104, 165));
                separador4.setForeground(new Color(48, 48, 46));
                separador4.setPreferredSize(new Dimension(150, 20));

                GroupLayout separador4Layout = new GroupLayout(separador4);
                separador4.setLayout(separador4Layout);
                separador4Layout.setHorizontalGroup(
                                separador4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGap(0, 0, Short.MAX_VALUE));
                separador4Layout.setVerticalGroup(
                                separador4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGap(0, 0, Short.MAX_VALUE));

                jPanel_menuOpciones.add(separador4);

                button_modificarDatos.setForeground(new Color(255, 255, 255));
                button_modificarDatos.setText("Modificar datos personales");
                button_modificarDatos.setCursor(new Cursor(Cursor.HAND_CURSOR));
                button_modificarDatos.setEnabled(false);
                button_modificarDatos.setFocusable(false);
                button_modificarDatos.setPreferredSize(new Dimension(160, 30));
                button_modificarDatos.setRequestFocusEnabled(false);
                jPanel_menuOpciones.add(button_modificarDatos);

                button_modificarCred.setForeground(new Color(255, 255, 255));
                button_modificarCred.setText("Modificar credenciales");
                button_modificarCred.setCursor(new Cursor(Cursor.HAND_CURSOR));
                button_modificarCred.setEnabled(false);
                button_modificarCred.setFocusable(false);
                button_modificarCred.setPreferredSize(new Dimension(160, 30));
                button_modificarCred.setRequestFocusEnabled(false);
                jPanel_menuOpciones.add(button_modificarCred);

                button_preferencias.setForeground(new Color(255, 255, 255));
                button_preferencias.setText("Preferencias");
                button_preferencias.setCursor(new Cursor(Cursor.HAND_CURSOR));
                button_preferencias.setEnabled(false);
                button_preferencias.setFocusable(false);
                button_preferencias.setPreferredSize(new Dimension(160, 30));
                button_preferencias.setRequestFocusEnabled(false);
                jPanel_menuOpciones.add(button_preferencias);

                button_soporte.setForeground(new Color(255, 255, 255));
                button_soporte.setText("Soporte");
                button_soporte.setCursor(new Cursor(Cursor.HAND_CURSOR));
                button_soporte.setEnabled(false);
                button_soporte.setFocusable(false);
                button_soporte.setPreferredSize(new Dimension(160, 30));
                button_soporte.setRequestFocusEnabled(false);
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

                jLabel6.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
                jLabel6.setForeground(new Color(102, 102, 102));
                jLabel6.setText("Bienvenido al Programa Vacunas Panamá");

                jLabel9.setFont(new Font("Microsoft YaHei", Font.BOLD | Font.ITALIC, 24));
                jLabel9.setForeground(new Color(0, 204, 0));
                jLabel9.setHorizontalAlignment(SwingConstants.CENTER);
                jLabel9.setText("Módulo en construcción. Lo sentimos...");

                GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(23, 23, 23)
                                                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 566,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(227, Short.MAX_VALUE))
                                                .addGroup(jPanel1Layout
                                                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                                                .createSequentialGroup()
                                                                                .addContainerGap(11, Short.MAX_VALUE)
                                                                                .addComponent(jLabel9,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                789,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addContainerGap(16,
                                                                                                Short.MAX_VALUE))));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 58,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(752, Short.MAX_VALUE))
                                                .addGroup(jPanel1Layout
                                                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                                                .createSequentialGroup()
                                                                                .addContainerGap(57, Short.MAX_VALUE)
                                                                                .addComponent(jLabel9,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                748,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addContainerGap(11,
                                                                                                Short.MAX_VALUE))));

                jPanel_derecho.add(jPanel1, "vacio");

                background.add(jPanel_derecho, BorderLayout.CENTER);

                jScrollPane3.setViewportView(background);

                getContentPane().add(jScrollPane3, BorderLayout.CENTER);
                setIconImage(new ImageIcon(getClass().getResource("/images/Icon1.png")).getImage());

                pack();
                setLocationRelativeTo(null);
        }// </editor-fold>

        private void formComponentShown(ComponentEvent evt) {
                StaticMethods.setImageLabel(icon_project);
        }

        private void formWindowClosing(WindowEvent evt) {
                int confirm = JOptionPane.showConfirmDialog(null, "¿Esta seguro de cerrar sesión?",
                                "Cerrando sesión y ventana...", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (confirm == 0) {
                        PARENT_FRAME.setVisible(true);
                        PARENT_FRAME.requestFocus();
                        this.dispose();
                }
        }

        /* eventos del menú lateral */
        private void button_logOutMouseClicked(MouseEvent evt) {
                formWindowClosing(null);
        }

        /* método para colocar el nombre al iniciar sesión */
        public void setBienvenida(String nombre) {
                this.nombreBienvenida.setText(nombre);
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
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                                | UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(PantallaBlock.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                }

                SwingUtilities.invokeLater(() -> new PantallaBlock(new Login()).setVisible(true));
        }

        /* variables propias */
        private final JFrame PARENT_FRAME;

        // Variables declaration - do not modify
        private JPanel background;
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
        private JLabel icon_project;
        private JLabel jLabel6;
        private JLabel jLabel9;
        private JPanel jPanel1;
        private JPanel jPanel_derecho;
        private JPanel jPanel_menuOpciones;
        private JScrollPane jScrollPane3;
        private JLabel nombreBienvenida;
        private JLabel rolName;
        private JPanel separador1;
        private JPanel separador2;
        private JPanel separador3;
        private JPanel separador4;
        // End of variables declaration
}
