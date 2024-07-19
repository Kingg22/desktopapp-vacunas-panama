package desktop_interface;

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
        punto2 = new JLabel();
        jComboBox_tabla3 = new JComboBox<>();
        punto = new JLabel();
        jComboBox_columna1 = new JComboBox<>();
        punto4 = new JLabel();
        jComboBox_tabla4 = new JComboBox<>();
        punto3 = new JLabel();
        jComboBox_columna2 = new JComboBox<>();

        setBackground(new Color(227, 218, 201));
        setMinimumSize(new Dimension(0, 0));
        setPreferredSize(new Dimension(794, 25));
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        jComboBox_innerTyp.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jComboBox_innerTyp.setModel(new DefaultComboBoxModel<>(new String[]{"INNER", "FULL", "LEFT", "RIGHT", "CROSS"}));
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
        jComboBox_tabla2.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir Tabla"}));
        jComboBox_tabla2.setPreferredSize(new Dimension(150, 27));
        jComboBox_tabla2.addActionListener(this::jComboBox_tabla2ActionPerformed);
        add(jComboBox_tabla2);

        punto2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        punto2.setForeground(new Color(0, 0, 0));
        punto2.setHorizontalAlignment(SwingConstants.CENTER);
        punto2.setText("ON");
        punto2.setMaximumSize(new Dimension(45, 33));
        punto2.setPreferredSize(new Dimension(25, 33));
        add(punto2);

        jComboBox_tabla3.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jComboBox_tabla3.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir Tabla"}));
        jComboBox_tabla3.setPreferredSize(new Dimension(150, 27));
        jComboBox_tabla3.addActionListener(this::jComboBox_tabla3ActionPerformed);
        add(jComboBox_tabla3);

        punto.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        punto.setForeground(new Color(0, 0, 0));
        punto.setHorizontalAlignment(SwingConstants.CENTER);
        punto.setText(".");
        punto.setMaximumSize(new Dimension(45, 33));
        punto.setPreferredSize(new Dimension(10, 33));
        add(punto);

        jComboBox_columna1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jComboBox_columna1.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir"}));
        jComboBox_columna1.setPreferredSize(new Dimension(150, 27));
        add(jComboBox_columna1);

        punto4.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        punto4.setForeground(new Color(0, 0, 0));
        punto4.setHorizontalAlignment(SwingConstants.CENTER);
        punto4.setText("  =  ");
        punto4.setMaximumSize(new Dimension(45, 33));
        punto4.setPreferredSize(new Dimension(25, 33));
        add(punto4);

        jComboBox_tabla4.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jComboBox_tabla4.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir Tabla"}));
        jComboBox_tabla4.setPreferredSize(new Dimension(150, 27));
        jComboBox_tabla4.addActionListener(this::jComboBox_tabla4ActionPerformed);
        add(jComboBox_tabla4);

        punto3.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        punto3.setForeground(new Color(0, 0, 0));
        punto3.setHorizontalAlignment(SwingConstants.CENTER);
        punto3.setText(".");
        punto3.setMaximumSize(new Dimension(45, 33));
        punto3.setPreferredSize(new Dimension(10, 33));
        add(punto3);

        jComboBox_columna2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jComboBox_columna2.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir"}));
        jComboBox_columna2.setPreferredSize(new Dimension(150, 27));
        add(jComboBox_columna2);
    }// </editor-fold>

    private void jComboBox_tabla2ActionPerformed(ActionEvent evt) {
        jComboBox_tabla3.setSelectedItem(jComboBox_tabla2.getSelectedItem());
        jComboBox_tabla3ActionPerformed(null);
    }

    private void jComboBox_tabla3ActionPerformed(ActionEvent evt) {
        if (jComboBox_tabla3.getSelectedIndex() == jComboBox_tabla2.getSelectedIndex()) {
            DefaultComboBoxModel model = new DefaultComboBoxModel<>(new String[]{"Elegir"});
            model.addAll(infoDB.getColumnsNombres((String) jComboBox_tabla3.getSelectedItem()));
            jComboBox_columna1.setModel(model);
        } else {
            jComboBox_tabla3.setSelectedItem(jComboBox_tabla2.getSelectedItem());
            JOptionPane.showMessageDialog(null, "La tabla seleccionada debe ser igual a la tabla del combo box anterior.");
        }
    }

    private void jComboBox_tabla4ActionPerformed(ActionEvent evt) {
        if (jComboBox_tabla4.getSelectedIndex() != 0) {
            DefaultComboBoxModel model = new DefaultComboBoxModel<>(new String[]{"Elegir"});
            model.addAll(infoDB.getColumnsNombres((String) jComboBox_tabla4.getSelectedItem()));
            jComboBox_columna2.setModel(model);
        }
    }

    public void setTables(DatabaseInfo infoDB) {
        this.infoDB = infoDB;
        JComboBox[] tablas = {jComboBox_tabla2, jComboBox_tabla3, jComboBox_tabla4};
        for (JComboBox tabla : tablas) {
            DefaultComboBoxModel model = new DefaultComboBoxModel(new String[]{"Elegir Tabla"});
            model.addAll(this.infoDB.getTablasNombres());
            model.addAll(this.infoDB.getVistasNombres());
            tabla.setModel(model);
        }
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
    private JLabel punto;
    private JLabel punto2;
    private JLabel punto3;
    private JLabel punto4;
    // End of variables declaration
}
