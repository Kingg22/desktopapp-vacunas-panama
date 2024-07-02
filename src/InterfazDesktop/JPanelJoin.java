package InterfazDesktop;

public class JPanelJoin extends javax.swing.JPanel {

    public JPanelJoin() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        jComboBox_innerTyp = new javax.swing.JComboBox<>();
        join = new javax.swing.JLabel();
        jComboBox_tabla2 = new javax.swing.JComboBox<>();
        punto2 = new javax.swing.JLabel();
        jComboBox_tabla3 = new javax.swing.JComboBox<>();
        punto = new javax.swing.JLabel();
        jComboBox_columna1 = new javax.swing.JComboBox<>();
        punto4 = new javax.swing.JLabel();
        jComboBox_tabla4 = new javax.swing.JComboBox<>();
        punto3 = new javax.swing.JLabel();
        jComboBox_columna3 = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(227, 218, 201));
        setMinimumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(794, 25));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.X_AXIS));

        jComboBox_innerTyp.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jComboBox_innerTyp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"INNER", "FULL", "LEFT", "RIGHT", "CROSS"}));
        jComboBox_innerTyp.setPreferredSize(new java.awt.Dimension(80, 27));
        add(jComboBox_innerTyp);

        join.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        join.setForeground(new java.awt.Color(0, 0, 0));
        join.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        join.setText("JOIN");
        join.setMaximumSize(new java.awt.Dimension(45, 33));
        join.setPreferredSize(new java.awt.Dimension(45, 33));
        add(join);

        jComboBox_tabla2.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jComboBox_tabla2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Tabla2"}));
        jComboBox_tabla2.setPreferredSize(new java.awt.Dimension(150, 27));
        jComboBox_tabla2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_tabla2ActionPerformed(evt);
            }
        });
        add(jComboBox_tabla2);

        punto2.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        punto2.setForeground(new java.awt.Color(0, 0, 0));
        punto2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        punto2.setText("ON");
        punto2.setMaximumSize(new java.awt.Dimension(45, 33));
        punto2.setPreferredSize(new java.awt.Dimension(25, 33));
        add(punto2);

        jComboBox_tabla3.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jComboBox_tabla3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Tabla1"}));
        jComboBox_tabla3.setPreferredSize(new java.awt.Dimension(150, 27));
        jComboBox_tabla3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_tabla3ActionPerformed(evt);
            }
        });
        add(jComboBox_tabla3);

        punto.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        punto.setForeground(new java.awt.Color(0, 0, 0));
        punto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        punto.setText(".");
        punto.setMaximumSize(new java.awt.Dimension(45, 33));
        punto.setPreferredSize(new java.awt.Dimension(10, 33));
        add(punto);

        jComboBox_columna1.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jComboBox_columna1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"*"}));
        jComboBox_columna1.setPreferredSize(new java.awt.Dimension(150, 27));
        add(jComboBox_columna1);

        punto4.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        punto4.setForeground(new java.awt.Color(0, 0, 0));
        punto4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        punto4.setText("  =  ");
        punto4.setMaximumSize(new java.awt.Dimension(45, 33));
        punto4.setPreferredSize(new java.awt.Dimension(25, 33));
        add(punto4);

        jComboBox_tabla4.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jComboBox_tabla4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Tabla2"}));
        jComboBox_tabla4.setPreferredSize(new java.awt.Dimension(150, 27));
        jComboBox_tabla4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_tabla4ActionPerformed(evt);
            }
        });
        add(jComboBox_tabla4);

        punto3.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        punto3.setForeground(new java.awt.Color(0, 0, 0));
        punto3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        punto3.setText(".");
        punto3.setMaximumSize(new java.awt.Dimension(45, 33));
        punto3.setPreferredSize(new java.awt.Dimension(10, 33));
        add(punto3);

        jComboBox_columna3.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jComboBox_columna3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"*"}));
        jComboBox_columna3.setPreferredSize(new java.awt.Dimension(150, 27));
        add(jComboBox_columna3);
    }// </editor-fold>

    private void jComboBox_tabla2ActionPerformed(java.awt.event.ActionEvent evt) {
        /* TODO buscar y colocar las columnas de dicha tabla */
    }

    private void jComboBox_tabla3ActionPerformed(java.awt.event.ActionEvent evt) {
        /* TODO buscar y colocar las columnas de dicha tabla */
    }

    private void jComboBox_tabla4ActionPerformed(java.awt.event.ActionEvent evt) {
        /* TODO buscar y colocar las columnas de dicha tabla */
    }

    // Variables declaration - do not modify
    private javax.swing.JComboBox<String> jComboBox_columna1;
    private javax.swing.JComboBox<String> jComboBox_columna3;
    private javax.swing.JComboBox<String> jComboBox_innerTyp;
    private javax.swing.JComboBox<String> jComboBox_tabla2;
    private javax.swing.JComboBox<String> jComboBox_tabla3;
    private javax.swing.JComboBox<String> jComboBox_tabla4;
    private javax.swing.JLabel join;
    private javax.swing.JLabel punto;
    private javax.swing.JLabel punto2;
    private javax.swing.JLabel punto3;
    private javax.swing.JLabel punto4;
    // End of variables declaration
}
