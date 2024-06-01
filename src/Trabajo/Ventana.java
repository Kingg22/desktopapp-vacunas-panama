package Trabajo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class Ventana extends JFrame implements ActionListener {
    private JLabel labelTitulo;
    private JButton buttonPaciente;
    private JButton buttonDoctor;
    private JButton buttonProveedor;
    private JButton buttonAdmin;

    public Ventana() {
        setSize(500, 500);
        setTitle("MINSA 2.0 - App Java by Kingg");
        setLocationRelativeTo(null);
        setResizable(true);
        setLayout(new BorderLayout());

        // Título centrado
        labelTitulo = new JLabel("Vistas de datos", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(labelTitulo, BorderLayout.NORTH);

        // Panel con los botones principales
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 4));

        buttonPaciente = new JButton("Paciente");
        buttonDoctor = new JButton("Doctor");
        buttonProveedor = new JButton("Proveedor");
        buttonAdmin = new JButton("ADMIN");

        buttonPaciente.addActionListener(this);
        buttonDoctor.addActionListener(this);
        buttonProveedor.addActionListener(this);
        buttonAdmin.addActionListener(this);

        panelBotones.add(buttonPaciente);
        panelBotones.add(buttonDoctor);
        panelBotones.add(buttonProveedor);
        panelBotones.add(buttonAdmin);

        add(panelBotones, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void mostrarFrame(String titulo, String vista) {
        try {
            JFrame frame = new JFrame(titulo);
            frame.setSize(500, 500);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new BorderLayout());

            // Crear el modelo de la tabla
            MiModeloTabla modelo = new MiModeloTabla(vista);
            JTable table = new JTable(modelo);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            JScrollPane scroll = new JScrollPane(table);

            // Calcular la altura del scroll para mostrar 20 filas y el botón
            int filaHeight = table.getRowHeight();
            int scrollHeight = Math.min(20 * filaHeight + 25, 500); // Tamaño máximo de 500px
            scroll.setPreferredSize(new Dimension(scroll.getPreferredSize().width, scrollHeight));

            // Agregar la tabla al frame
            frame.add(scroll, BorderLayout.CENTER);

            // Agregar botón "Actualizar"
            JButton buttonActualizar = new JButton("Actualizar");
            buttonActualizar.addActionListener(e -> {
                try {
                    modelo.actualizarDatos(vista);
                    modelo.fireTableDataChanged();
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"Error al actualizar tabla: " + ex.getMessage());;
                }
            });
            frame.add(buttonActualizar, BorderLayout.SOUTH);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e);
                    // Cerrar recursos
                    if (modelo != null) {
                        try {
                            MiModeloTabla.getDb().closeConnection();
                        } catch (Exception ex){
                            JOptionPane.showMessageDialog(null,"Error al cerrar la conexión: " + ex.getMessage());;
                        }
                    }
                }
            });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en frame interno: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonPaciente) {
            mostrarFrame("Vista Paciente", "pac");
        } else if (e.getSource() == buttonDoctor) {
            mostrarFrame("Vista Doctor", "doc");
        } else if (e.getSource() == buttonProveedor) {
            mostrarFrame("Vista Proveedor", "prov");
        } else if (e.getSource() == buttonAdmin) {
            mostrarFrame("Vista ADMIN", "admin");
        }
    }
}