package desktop_interface.util;

import logic.scanner_database.DatabaseInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JPanelJoin extends JPanel {

    public JPanelJoin() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        jComboBox_innerTyp = new JComboBox<>();
        join = new JLabel();
        jComboBox_tabla2 = new JComboBox<>();
        on = new JLabel();
        jComboBox_tabla3 = new JComboBox<>();
        punto1 = new JLabel();
        jComboBox_columna1 = new JComboBox<>();
        igual = new JLabel();
        jComboBox_tabla4 = new JComboBox<>();
        punto2 = new JLabel();
        jComboBox_columna2 = new JComboBox<>();

        setBackground(new Color(227, 218, 201));
        setMinimumSize(new Dimension(0, 0));
        setPreferredSize(new Dimension(794, 25));
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        jComboBox_innerTyp.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jComboBox_innerTyp.setModel(
                new DefaultComboBoxModel<>(new String[] { "Elegir", "INNER", "FULL", "LEFT", "RIGHT", "CROSS" }));
        jComboBox_innerTyp.setPreferredSize(new Dimension(80, 27));
        add(jComboBox_innerTyp);

        join.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        join.setForeground(new Color(0, 0, 0));
        join.setHorizontalAlignment(SwingConstants.CENTER);
        join.setText("JOIN");
        join.setMaximumSize(new Dimension(45, 33));
        join.setPreferredSize(new Dimension(45, 33));
        add(join);

        jComboBox_tabla2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jComboBox_tabla2.setModel(new DefaultComboBoxModel<>(new String[] { "Elegir Tabla" }));
        jComboBox_tabla2.setPreferredSize(new Dimension(150, 27));
        jComboBox_tabla2.addActionListener(this::jComboBox_tabla2ActionPerformed);
        add(jComboBox_tabla2);

        on.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        on.setForeground(new Color(0, 0, 0));
        on.setHorizontalAlignment(SwingConstants.CENTER);
        on.setText("ON");
        on.setMaximumSize(new Dimension(45, 33));
        on.setPreferredSize(new Dimension(25, 33));
        add(on);

        jComboBox_tabla3.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jComboBox_tabla3.setModel(new DefaultComboBoxModel<>(new String[] { "Elegir Tabla" }));
        jComboBox_tabla3.setPreferredSize(new Dimension(150, 27));
        jComboBox_tabla3.addActionListener(this::jComboBox_tabla3ActionPerformed);
        add(jComboBox_tabla3);

        punto1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        punto1.setForeground(new Color(0, 0, 0));
        punto1.setHorizontalAlignment(SwingConstants.CENTER);
        punto1.setText(".");
        punto1.setMaximumSize(new Dimension(45, 33));
        punto1.setPreferredSize(new Dimension(10, 33));
        add(punto1);

        jComboBox_columna1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jComboBox_columna1.setModel(new DefaultComboBoxModel<>(new String[] { "Elegir" }));
        jComboBox_columna1.setPreferredSize(new Dimension(150, 27));
        add(jComboBox_columna1);

        igual.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        igual.setForeground(new Color(0, 0, 0));
        igual.setHorizontalAlignment(SwingConstants.CENTER);
        igual.setText("  =  ");
        igual.setMaximumSize(new Dimension(45, 33));
        igual.setPreferredSize(new Dimension(25, 33));
        add(igual);

        jComboBox_tabla4.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jComboBox_tabla4.setModel(new DefaultComboBoxModel<>(new String[] { "Elegir Tabla" }));
        jComboBox_tabla4.setPreferredSize(new Dimension(150, 27));
        jComboBox_tabla4.addActionListener(this::jComboBox_tabla4ActionPerformed);
        add(jComboBox_tabla4);

        punto2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        punto2.setForeground(new Color(0, 0, 0));
        punto2.setHorizontalAlignment(SwingConstants.CENTER);
        punto2.setText(".");
        punto2.setMaximumSize(new Dimension(45, 33));
        punto2.setPreferredSize(new Dimension(10, 33));
        add(punto2);

        jComboBox_columna2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jComboBox_columna2.setModel(new DefaultComboBoxModel<>(new String[] { "Elegir" }));
        jComboBox_columna2.setPreferredSize(new Dimension(150, 27));
        add(jComboBox_columna2);
    }// </editor-fold>

    /* eventos de los componentes */
    private void jComboBox_tabla2ActionPerformed(ActionEvent evt) {
        jComboBox_tabla3.setSelectedItem(jComboBox_tabla2.getSelectedItem());
        jComboBox_tabla3ActionPerformed(null);
    }

    private void jComboBox_tabla3ActionPerformed(ActionEvent evt) {
        if (jComboBox_tabla3.getSelectedIndex() == jComboBox_tabla2.getSelectedIndex()) {
            DefaultComboBoxModel model = new DefaultComboBoxModel<>(new String[] { "Elegir" });
            model.addAll(infoDB.getColumnsNombres((String) jComboBox_tabla3.getSelectedItem()));
            jComboBox_columna1.setModel(model);
        } else {
            jComboBox_tabla3.setSelectedItem(jComboBox_tabla2.getSelectedItem());
            JOptionPane.showMessageDialog(null,
                    "La tabla seleccionada debe ser igual a la tabla del combo box anterior.");
        }
    }

    private void jComboBox_tabla4ActionPerformed(ActionEvent evt) {
        if (jComboBox_tabla4.getSelectedIndex() != 0) {
            DefaultComboBoxModel model = new DefaultComboBoxModel<>(new String[] { "Elegir" });
            model.addAll(infoDB.getColumnsNombres((String) jComboBox_tabla4.getSelectedItem()));
            jComboBox_columna2.setModel(model);
        }
    }

    /* métodos públicos propios */
    public void setTables(DatabaseInfo infoDB) {
        this.infoDB = infoDB;
        JComboBox[] tablas = { jComboBox_tabla2, jComboBox_tabla3, jComboBox_tabla4 };
        for (JComboBox tabla : tablas) {
            DefaultComboBoxModel model = new DefaultComboBoxModel(new String[] { "Elegir Tabla" });
            model.addAll(this.infoDB.getTablasNombres());
            model.addAll(this.infoDB.getVistasNombres());
            tabla.setModel(model);
        }
    }

    public String getContent() {
        // <Type> JOIN Tabla2 ON Tabla1.columnaPK = Tabla2.columnaFK
        if (jComboBox_innerTyp.getSelectedIndex() == 0) {
            return null;
        }
        StringBuilder join = new StringBuilder();
        join.append(" ");
        join.append(jComboBox_innerTyp.getSelectedItem());
        join.append(" JOIN ");
        if (jComboBox_tabla2.getSelectedIndex() == 0) {
            return null;
        } else
            join.append("[").append(jComboBox_tabla2.getSelectedItem()).append("]");
        join.append(" ON ");
        join.append("[").append(jComboBox_tabla3.getSelectedItem()).append("]");
        join.append(".");
        if (jComboBox_columna1.getSelectedIndex() == 0) {
            return null;
        } else
            join.append("[").append(jComboBox_columna1.getSelectedItem()).append("]");
        join.append(" = ");
        if (jComboBox_tabla4.getSelectedIndex() == 0) {
            return null;
        } else
            join.append("[").append(jComboBox_tabla4.getSelectedItem()).append("]");
        join.append(".");
        if (jComboBox_columna2.getSelectedIndex() == 0) {
            return null;
        } else
            join.append("[").append(jComboBox_columna2.getSelectedItem()).append("] ");
        return join.toString();
    }

    // variable propia
    private DatabaseInfo infoDB;

    // Variables declaration - do not modify
    private JComboBox<String> jComboBox_columna1;
    private JComboBox<String> jComboBox_columna2;
    private JComboBox<String> jComboBox_innerTyp;
    private JComboBox<String> jComboBox_tabla2;
    private JComboBox<String> jComboBox_tabla3;
    private JComboBox<String> jComboBox_tabla4;
    private JLabel join;
    private JLabel punto1;
    private JLabel on;
    private JLabel punto2;
    private JLabel igual;
    // End of variables declaration
}
