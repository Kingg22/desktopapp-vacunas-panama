package InterfazDesktop;

import Logica.Validations.LimitarCamposSeguro;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class JTableFiltrar extends javax.swing.JPanel {

    public JTableFiltrar(JTable table) {
        jTable_Content = table;

        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jComboBox_filterColumn = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextField_buscarColumn = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setPreferredSize(new java.awt.Dimension(306, 98));
        setLayout(new java.awt.GridLayout(3, 2));
        add(jSeparator1);
        add(jSeparator2);

        jLabel2.setText("Filtro de columnas");
        add(jLabel2);

        jComboBox_filterColumn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_filterColumnActionPerformed(evt);
            }
        });
        add(jComboBox_filterColumn);

        jLabel3.setText("Filtro de valor por columna");
        add(jLabel3);

        jTextField_buscarColumn.setDocument(new LimitarCamposSeguro(15, "Buscar en..."));
        jTextField_buscarColumn.setText("Buscar en...");
        RegistrarUser.handleFocusGain(jTextField_buscarColumn, "Buscar en...");
        jTextField_buscarColumn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_buscarColumnFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_buscarColumnFocusLost(evt);
            }
        });
        jTextField_buscarColumn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_buscarColumnActionPerformed(evt);
            }
        });
        add(jTextField_buscarColumn);
    }// </editor-fold>

    private void jComboBox_filterColumnActionPerformed(java.awt.event.ActionEvent evt) {
        filterActionPerformed();
    }

    private void jTextField_buscarColumnFocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_buscarColumn, "Buscar en...");
    }

    private void jTextField_buscarColumnFocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_buscarColumn, "Buscar en...");
    }

    private void jTextField_buscarColumnActionPerformed(java.awt.event.ActionEvent evt) {
        filterActionPerformed();
    }

    /* método propio */
    private void filterActionPerformed() {
        /* TODO editar según el panel que llama y limpiar en cada llamada */
        int columnIndex = jComboBox_filterColumn.getSelectedIndex();
        String filterText = jTextField_buscarColumn.getText();

        TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTable_Content.getModel());
        if (filterText.isEmpty() || filterText.equals("Buscar en...")) {
            sorter.setRowFilter(RowFilter.regexFilter(".*", columnIndex));
        } else {
            sorter.setRowFilter(new RowFilter<TableModel, Object>() {
                public boolean include(RowFilter.Entry<? extends TableModel, ? extends Object> entry) {
                    return entry.getStringValue(columnIndex).contains(filterText);
                }
            });
        }
        jTable_Content.setRowSorter(sorter);
    }

    // variables propias
    private JTable jTable_Content = null;

    // Variables declaration - do not modify
    private javax.swing.JComboBox<String> jComboBox_filterColumn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField_buscarColumn;
    // End of variables declaration
}
