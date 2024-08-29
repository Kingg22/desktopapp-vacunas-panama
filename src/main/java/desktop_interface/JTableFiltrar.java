package desktop_interface;

import logic.validations.LimitarCamposSeguro;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class JTableFiltrar extends JPanel {

    public JTableFiltrar(JTable table) {
        jTable_Content = table;

        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        jSeparator1 = new JSeparator();
        jSeparator2 = new JSeparator();
        jLabel2 = new JLabel();
        jComboBox_filterColumn = new JComboBox<>();
        jLabel3 = new JLabel();
        jTextField_buscarColumn = new JTextField();

        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setPreferredSize(new Dimension(306, 98));
        setLayout(new GridLayout(3, 2));
        add(jSeparator1);
        add(jSeparator2);

        jLabel2.setText("Filtro de columnas");
        add(jLabel2);

        jComboBox_filterColumn.setModel(new DefaultComboBoxModel<>(new String[] { "Elegir" }));
        jComboBox_filterColumn.addActionListener(this::jComboBox_filterColumnActionPerformed);
        add(jComboBox_filterColumn);

        jLabel3.setText("Filtro de valor por columna");
        add(jLabel3);

        jTextField_buscarColumn.setDocument(new LimitarCamposSeguro(15, "Buscar en..."));
        jTextField_buscarColumn.setText("Buscar en...");
        RegistrarUser.handleFocusGain(jTextField_buscarColumn, "Buscar en...");
        jTextField_buscarColumn.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                jTextField_buscarColumnFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                jTextField_buscarColumnFocusLost(evt);
            }
        });
        jTextField_buscarColumn.addActionListener(this::jTextField_buscarColumnActionPerformed);
        add(jTextField_buscarColumn);
    }// </editor-fold>

    private void jComboBox_filterColumnActionPerformed(ActionEvent evt) {
        filterActionPerformed();
    }

    private void jTextField_buscarColumnFocusGained(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_buscarColumn, "Buscar en...");
    }

    private void jTextField_buscarColumnFocusLost(FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_buscarColumn, "Buscar en...");
    }

    private void jTextField_buscarColumnActionPerformed(ActionEvent evt) {
        filterActionPerformed();
    }

    /* método propio */
    private void filterActionPerformed() {
        int columnIndex = jComboBox_filterColumn.getSelectedIndex();
        String filterText = jTextField_buscarColumn.getText();

        // Verifica si el índice es válido antes de proceder
        if (columnIndex < 0) {
            return; // Si no es válido, no hacer nada
        }

        TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTable_Content.getModel());
        if (filterText.isEmpty() || filterText.equals("Buscar en...")) {
            sorter.setRowFilter(RowFilter.regexFilter(".*", columnIndex));
        } else {
            sorter.setRowFilter(new RowFilter<TableModel, Object>() {
                public boolean include(RowFilter.Entry<? extends TableModel, ?> entry) {
                    return entry.getStringValue(columnIndex).contains(filterText);
                }
            });
        }
        jTable_Content.setRowSorter(sorter);
    }

    public void setPreferences(String[] columna) {
        jComboBox_filterColumn.removeAllItems();
        for (String s : columna) {
            jComboBox_filterColumn.addItem(s);
        }
    }

    // variables propias
    private final JTable jTable_Content;

    // Variables declaration - do not modify
    private JComboBox<String> jComboBox_filterColumn;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JTextField jTextField_buscarColumn;
    // End of variables declaration
}
