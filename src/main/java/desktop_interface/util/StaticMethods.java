package desktop_interface.util;

import desktop_interface.util.validations.LimitarCampos;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.net.URL;

public class StaticMethods {
    /* métodos static para manejar los focus de los campos según el tipo */
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
            } else if (document instanceof PlainDocument) {
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
            } else if (document instanceof PlainDocument) {
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

    /* método static para añadir los focus listeners */
    public static void addFocusListeners(JTextField field, String placeholder) {
        field.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent evt) {
                if (field instanceof JPasswordField) {
                    handleFocusPassword((JPasswordField) field, placeholder);
                } else
                    handleFocusGain(field, placeholder);
            }

            @Override
            public void focusLost(FocusEvent evt) {
                if (field instanceof JPasswordField) {
                    handleFocusPassword((JPasswordField) field, placeholder);
                } else
                    handleFocusGain(field, placeholder);
            }
        });
    }

    /* método static para añadir los action listeners */
    public static void addActionListeners(JTextField field, Component destino) {
        field.addActionListener(e -> destino.requestFocus());
    }

    /* método static para crear FAQ con estilo "moderno" */
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

        questionButton.addActionListener(e -> {
            answerArea.setVisible(!answerArea.isVisible());
            panel.revalidate();
        });

        panel.add(questionButton, BorderLayout.NORTH);
        panel.add(answerArea, BorderLayout.CENTER);

        return panel;
    }

    /* TODO método static para exportar según el tipo de archivo requerido */
    public static boolean exportar(JComboBox<String> comboBox) {
        String typePreferences = (String) comboBox.getSelectedItem();
        if (typePreferences == null || typePreferences.trim().isBlank()) {
            return false;
        }
        switch (typePreferences) {
            case "PDF":
            case "Excel":
            case "CSV":
            case "TXT":
            default:
                break;
        }
        return false;
    }

    /* método static para ajustar los tamaños de una tabla de forma dinámica */
    public static void adjustColumnWidths(JTable table) {
        // No olvidar que se debe ajustar el tamaño de la tabla a un máximo de 1500 x 1000 (u otro) para que se vea bien

        // Obtener el ancho total disponible
        int totalWidth = table.getParent() instanceof JViewport ?
                table.getParent().getWidth() : table.getWidth();

        // Ajustar el ancho de las columnas basado en el JScrollPane
        TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            TableColumn tableColumn = columnModel.getColumn(column);

            // Obtener el ancho del encabezado de la columna
            TableCellRenderer headerRenderer = table.getTableHeader().getDefaultRenderer();
            Object headerValue = tableColumn.getHeaderValue();
            Component headerComponent = headerRenderer.getTableCellRendererComponent(table, headerValue, false, false, -1, column);
            int headerWidth = headerComponent.getPreferredSize().width;

            int preferredWidth = Math.max(tableColumn.getMinWidth(), headerWidth);

            // Calcular el ancho máximo basado en el contenido de las celdas
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
                Component c = table.prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
                preferredWidth = Math.max(preferredWidth, width);
            }

            // Establecer el ancho preferido de la columna (no debe superar el ancho total disponible)
            tableColumn.setPreferredWidth(Math.min(preferredWidth, totalWidth));
            tableColumn.setResizable(true);
        }
    }

    /* método static para transformar una matriz a un arreglo según la columna requerida */
    public static String[] transformMatrizToArray(Object[][] matriz, int columna) {
        String[] resultados = new String[matriz.length + 1];
        resultados[0] = "Elegir";
        for (int i = 1; i <= matriz.length; i++) {
            resultados[i] = (String) matriz[i - 1][columna];
        }
        return resultados;
    }

    public static boolean validateType(String type, String data) {
        data = data.trim().toLowerCase();
        if (type.contains("identity"))
            type = type.replace(" identity", "");
        if (data.equals("*"))
            return true;
        return switch (type.toUpperCase()) {
            case "VARCHAR", "CHAR", "TEXT" -> data.matches("[a-zA-zñÑ\\d\\s@\\.,_\\-%()\\[\\]\\^]+");
            case "INT", "INTEGER", "FLOAT", "REAL", "DOUBLE" -> data.matches("^-?\\d+(\\.\\d+)?$");
            case "BOOLEAN" -> data.equals("true") || data.equals("false");
            case "DATE" -> data.matches("^\\d{4}(-\\d{2}){2}$");
            case "TIMESTAMP", "DATETIME" -> data.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]) (0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9](\\.\\d{1,9})?$");
            case "TIME" -> data.matches("(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9](\\.\\d{1,9})?$");
            default -> !data.isBlank(); // Default to Object if type is unknown
        };
    }

    /* ajusta la imagen en un JLabel cuando este se redimensiona */
    public static void setImageLabel(JLabel label) {
        Icon image = label.getIcon();
        if (image instanceof ImageIcon imageIcon) {
            Icon icon = new ImageIcon(imageIcon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
            label.setIcon(icon);
            label.repaint();
        } else {
            System.err.println("El icono actual no es una instancia de ImageIcon y no se puede redimensionar. " + label);
        }
    }

    /* ejemplo de try catch CustomException */
    /*
        try {
            DatabaseOperaciones.method(token);
        } catch (CustomException c) {
            System.err.println(c);
            switch (c.getErrorCode()) {
                case 0, 4 -> JOptionPane.showMessageDialog(this, c.getMessage() +
                        "\nRevisar sus credenciales y/o volver a iniciar sesión para generar un nuevo token.");
                case 1, 3, 5 -> {
                    JOptionPane.showMessageDialog(null, c.getMessage() +
                            "\n Por seguridad saliendo del programa...");
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            dispose();
                        }
                    }, 5000);
                }
                case 2 ->
                        JOptionPane.showMessageDialog(this, "Ha ocurrido un error de conexión con la base de datos. \n" +
                                "Revise el detalle: " + c.getMessage());
                case 6 -> JOptionPane.showMessageDialog(this,
                        "Ha ocurrido un error con su token. Token generado: " + token +
                                "\nGenerar un nuevo token soluciona la mayoría de problemas. \n" +
                                "Revisar sus credenciales, revisar los tokens actuales del sistema y/o volver a iniciar sesión para generar un nuevo token.\n" +
                                "Detalle: " + c.getMessage());
            }
            return;
        }
     */
}
