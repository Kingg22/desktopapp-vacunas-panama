package InterfazDesktop;

import Validations.LimitarCamposSQL;
import Validations.LimitarCamposSeguro;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SpinnerNumberModel;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class PantallaAdmin extends javax.swing.JFrame {

    public PantallaAdmin() {
        initComponents();

        addFocusListeners();
        this.jPanel_filtrar = new JTableFiltrar(jTable_Content);

        JButton[] botones = {button_opcion1, button_opcion2,
            button_opcion5, button_modificarDatos,
            button_modificarCred, button_preferencias, jButton_savePreferences,
            button_soporte, button_opcion6, button_opcion7};
        for (JButton boton : botones) {
            boton.setUI(new BasicButtonUI());
            boton.setBackground(new Color(86, 86, 86));
        }
        button_logOut.setUI(new BasicButtonUI());
        layout = (CardLayout) jPanel_derecho.getLayout();

        this.setExtendedState(MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jComboBox_columna3 = new javax.swing.JComboBox<>();
        jTextField_valorInsert2 = new javax.swing.JTextField();
        jPanel_select = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        titulo_contenido1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        select = new javax.swing.JLabel();
        jComboBox_columna = new javax.swing.JComboBox<>();
        jTextField_selectComplejo = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel4 = new javax.swing.JPanel();
        from = new javax.swing.JLabel();
        jComboBox_tabla = new javax.swing.JComboBox<>();
        cantJoin = new javax.swing.JLabel();
        jComboBox_joins = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        where1 = new javax.swing.JLabel();
        jTextField_where = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        orderBy = new javax.swing.JLabel();
        jTextField_order = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        groupBy = new javax.swing.JLabel();
        jTextField_group = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        having = new javax.swing.JLabel();
        jTextField_having = new javax.swing.JTextField();
        jButton_select = new javax.swing.JButton();
        jScrollPane_Table = new javax.swing.JScrollPane();
        jTable_Content = new javax.swing.JTable();
        opcionesTabla = new javax.swing.JPanel();
        jTextField_buscarTabla = new javax.swing.JTextField();
        jButton_buscar = new javax.swing.JButton();
        jButton_acercar = new javax.swing.JButton();
        jButton_alejar = new javax.swing.JButton();
        jButton_ordenar = new javax.swing.JButton();
        jButton_filtros = new javax.swing.JButton();
        jButton_fuente = new javax.swing.JButton();
        jButton_exportar = new javax.swing.JButton();
        jPanel_preferencias = new javax.swing.JPanel();
        icon_preferencias = new javax.swing.JLabel();
        titulo3 = new javax.swing.JLabel();
        jPanel_separador1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel_separador2 = new javax.swing.JPanel();
        jPanel_fontChooser = new javax.swing.JPanel();
        jPanel_separador3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox_exportarType = new javax.swing.JComboBox<>();
        jPanel_separador4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox_exportarType1 = new javax.swing.JComboBox<>();
        jPanel_separador5 = new javax.swing.JPanel();
        jButton_savePreferences = new javax.swing.JButton();
        jPanel_insert_update_delete = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        titulo_contenido2 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        update = new javax.swing.JLabel();
        jComboBox_tabla1 = new javax.swing.JComboBox<>();
        set1 = new javax.swing.JLabel();
        jComboBox_columna2 = new javax.swing.JComboBox<>();
        punto1 = new javax.swing.JLabel();
        jTextField_valorUpdate = new javax.swing.JTextField();
        cantColumn1 = new javax.swing.JLabel();
        jComboBox_cantColumn1 = new javax.swing.JComboBox<>();
        jTextField_updateComplejo = new javax.swing.JTextField();
        jToggleButton2 = new javax.swing.JToggleButton();
        jPanel11 = new javax.swing.JPanel();
        where2 = new javax.swing.JLabel();
        jTextField_where1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        insert = new javax.swing.JLabel();
        jComboBox_tabla2 = new javax.swing.JComboBox<>();
        punto2 = new javax.swing.JLabel();
        jComboBox_columna1 = new javax.swing.JComboBox<>();
        punto3 = new javax.swing.JLabel();
        values = new javax.swing.JLabel();
        punto4 = new javax.swing.JLabel();
        jTextField_valorInsert = new javax.swing.JTextField();
        cantColumn = new javax.swing.JLabel();
        jComboBox_cantColumn2 = new javax.swing.JComboBox<>();
        jTextField_insertComplejo = new javax.swing.JTextField();
        jToggleButton3 = new javax.swing.JToggleButton();
        jButton3 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        delete = new javax.swing.JLabel();
        jComboBox_tabla3 = new javax.swing.JComboBox<>();
        jTextField_deleteComplejo = new javax.swing.JTextField();
        jToggleButton4 = new javax.swing.JToggleButton();
        jPanel14 = new javax.swing.JPanel();
        where3 = new javax.swing.JLabel();
        jTextField_where2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        separador = new javax.swing.JPanel();
        resultadosActualizar = new javax.swing.JTextArea();
        jPanel_backup = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        background = new javax.swing.JPanel();
        jPanel_menuOpciones = new javax.swing.JPanel();
        separador1 = new javax.swing.JPanel();
        icon_project = new javax.swing.JLabel();
        separador3 = new javax.swing.JPanel();
        rolName = new javax.swing.JLabel();
        nombreBienvenida = new javax.swing.JLabel();
        separador2 = new javax.swing.JPanel();
        button_opcion1 = new javax.swing.JButton();
        button_opcion2 = new javax.swing.JButton();
        button_opcion5 = new javax.swing.JButton();
        button_opcion6 = new javax.swing.JButton();
        button_opcion7 = new javax.swing.JButton();
        separador4 = new javax.swing.JPanel();
        button_modificarDatos = new javax.swing.JButton();
        button_modificarCred = new javax.swing.JButton();
        button_preferencias = new javax.swing.JButton();
        button_soporte = new javax.swing.JButton();
        button_logOut = new javax.swing.JButton();
        jPanel_derecho = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        jComboBox_columna3.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jComboBox_columna3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "*" }));
        jComboBox_columna3.setPreferredSize(new java.awt.Dimension(150, 27));

        jTextField_valorInsert2.setDocument(new LimitarCamposSQL(50, "Valor"));
        jTextField_valorInsert2.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jTextField_valorInsert2.setText("Valor");
        jTextField_valorInsert2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_valorInsert2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_valorInsert2FocusLost(evt);
            }
        });

        jPanel_select.setBackground(new java.awt.Color(227, 218, 201));
        jPanel_select.setForeground(new java.awt.Color(227, 218, 201));
        jPanel_select.setPreferredSize(new java.awt.Dimension(794, 794));
        jPanel_select.setLayout(new javax.swing.BoxLayout(jPanel_select, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setBackground(new java.awt.Color(227, 218, 201));
        jPanel2.setMaximumSize(new java.awt.Dimension(2147483647, 400));
        jPanel2.setPreferredSize(new java.awt.Dimension(794, 360));
        jPanel2.setLayout(new java.awt.GridLayout(8, 1));

        titulo_contenido1.setBackground(new java.awt.Color(255, 255, 255));
        titulo_contenido1.setFont(new java.awt.Font("Roboto", 3, 14));
        titulo_contenido1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo_contenido1.setText("Resultados Obtenidos");
        titulo_contenido1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titulo_contenido1.setMaximumSize(new java.awt.Dimension(2147483647, 17));
        titulo_contenido1.setOpaque(true);
        titulo_contenido1.setPreferredSize(new java.awt.Dimension(794, 17));
        jPanel2.add(titulo_contenido1);

        jPanel3.setBackground(new java.awt.Color(227, 218, 201));
        jPanel3.setPreferredSize(new java.awt.Dimension(794, 25));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.X_AXIS));

        select.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        select.setForeground(new java.awt.Color(0, 0, 0));
        select.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        select.setText("SELECT");
        select.setMaximumSize(new java.awt.Dimension(60, 33));
        select.setPreferredSize(new java.awt.Dimension(50, 33));
        jPanel3.add(select);

        jComboBox_columna.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jComboBox_columna.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "*" }));
        jComboBox_columna.setPreferredSize(new java.awt.Dimension(150, 27));
        jPanel3.add(jComboBox_columna);

        jTextField_selectComplejo.setDocument(new LimitarCamposSQL(200, "Campos y/o función"));
        jTextField_selectComplejo.setText("Campos y/o función");
        jTextField_selectComplejo.setVisible(false);
        RegistrarUser.handleFocusGain(jTextField_selectComplejo, "Campos y/o función");
        jTextField_selectComplejo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_selectComplejoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_selectComplejoFocusLost(evt);
            }
        });
        jTextField_selectComplejo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_selectComplejoActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField_selectComplejo);

        jToggleButton1.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jToggleButton1.setText("¿Complejo?");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jToggleButton1);

        jPanel2.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(227, 218, 201));
        jPanel4.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanel4.setPreferredSize(new java.awt.Dimension(794, 25));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.X_AXIS));

        from.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        from.setForeground(new java.awt.Color(0, 0, 0));
        from.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        from.setText("FROM");
        from.setMaximumSize(new java.awt.Dimension(50, 33));
        from.setPreferredSize(new java.awt.Dimension(50, 33));
        jPanel4.add(from);

        jComboBox_tabla.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jComboBox_tabla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tabla1" }));
        jComboBox_tabla.setMaximumSize(new java.awt.Dimension(367, 32767));
        jComboBox_tabla.setPreferredSize(new java.awt.Dimension(150, 27));
        jPanel4.add(jComboBox_tabla);

        cantJoin.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        cantJoin.setForeground(new java.awt.Color(0, 0, 0));
        cantJoin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cantJoin.setText("Cantidad de joins");
        cantJoin.setMaximumSize(new java.awt.Dimension(110, 33));
        cantJoin.setPreferredSize(new java.awt.Dimension(105, 33));
        jPanel4.add(cantJoin);

        jComboBox_joins.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jComboBox_joins.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));
        jComboBox_joins.setMaximumSize(new java.awt.Dimension(80, 32767));
        jComboBox_joins.setPreferredSize(new java.awt.Dimension(80, 27));
        jComboBox_joins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_joinsActionPerformed(evt);
            }
        });
        jPanel4.add(jComboBox_joins);

        jPanel2.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(227, 218, 201));
        jPanel5.setPreferredSize(new java.awt.Dimension(794, 25));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.X_AXIS));

        where1.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        where1.setForeground(new java.awt.Color(0, 0, 0));
        where1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        where1.setText("WHERE");
        where1.setMaximumSize(new java.awt.Dimension(60, 33));
        where1.setPreferredSize(new java.awt.Dimension(50, 33));
        jPanel5.add(where1);

        jTextField_where.setDocument(new LimitarCamposSQL(100, "Condición o condiciones"));
        jTextField_where.setText("Condición o condiciones");
        RegistrarUser.handleFocusGain(jTextField_where, "Condición o condiciones");
        jTextField_where.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_whereActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField_where);

        jPanel2.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(227, 218, 201));
        jPanel6.setPreferredSize(new java.awt.Dimension(794, 25));
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.X_AXIS));

        orderBy.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        orderBy.setForeground(new java.awt.Color(0, 0, 0));
        orderBy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orderBy.setText("ORDER BY ");
        orderBy.setMaximumSize(new java.awt.Dimension(90, 33));
        orderBy.setPreferredSize(new java.awt.Dimension(75, 33));
        jPanel6.add(orderBy);

        jTextField_order.setDocument(new LimitarCamposSQL(50, "Condición o condiciones"));
        jTextField_order.setText("Condición o condiciones");
        RegistrarUser.handleFocusGain(jTextField_order, "Condición o condiciones");
        jTextField_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_orderActionPerformed(evt);
            }
        });
        jPanel6.add(jTextField_order);

        jPanel2.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(227, 218, 201));
        jPanel7.setPreferredSize(new java.awt.Dimension(794, 25));
        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.X_AXIS));

        groupBy.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        groupBy.setForeground(new java.awt.Color(0, 0, 0));
        groupBy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        groupBy.setText("GROUP BY");
        groupBy.setMaximumSize(new java.awt.Dimension(90, 33));
        groupBy.setPreferredSize(new java.awt.Dimension(75, 33));
        jPanel7.add(groupBy);

        jTextField_group.setDocument(new LimitarCamposSQL(50, "Condición o condiciones"));
        jTextField_group.setText("Condición o condiciones");
        RegistrarUser.handleFocusGain(jTextField_group, "Condición o condiciones");
        jTextField_group.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_groupActionPerformed(evt);
            }
        });
        jPanel7.add(jTextField_group);

        jPanel2.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(227, 218, 201));
        jPanel8.setPreferredSize(new java.awt.Dimension(794, 25));
        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.X_AXIS));

        having.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        having.setForeground(new java.awt.Color(0, 0, 0));
        having.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        having.setText("HAVING");
        having.setMaximumSize(new java.awt.Dimension(75, 33));
        having.setPreferredSize(new java.awt.Dimension(65, 33));
        jPanel8.add(having);

        jTextField_having.setDocument(new LimitarCamposSQL(50, "Condición o condiciones"));
        jTextField_having.setText("Condición o condiciones");
        RegistrarUser.handleFocusGain(jTextField_having, "Condición o condiciones");
        jTextField_having.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_havingActionPerformed(evt);
            }
        });
        jPanel8.add(jTextField_having);

        jPanel2.add(jPanel8);

        jButton_select.setBackground(new java.awt.Color(0, 204, 0));
        jButton_select.setFont(new java.awt.Font("Microsoft YaHei", 1, 12));
        jButton_select.setForeground(new java.awt.Color(0, 0, 0));
        jButton_select.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa_icon.png")));
        jButton_select.setText("Buscar");
        jButton_select.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        jButton_select.setPreferredSize(new java.awt.Dimension(794, 30));
        jButton_select.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_selectMouseClicked(evt);
            }
        });
        jPanel2.add(jButton_select);

        jPanel_select.add(jPanel2);

        jScrollPane_Table.setBackground(new java.awt.Color(227, 218, 201));
        jScrollPane_Table.setForeground(new java.awt.Color(227, 218, 201));
        jScrollPane_Table.setOpaque(true);
        jScrollPane_Table.setPreferredSize(new java.awt.Dimension(794, 694));
        jScrollPane_Table.setViewportView(null);

        jTable_Content.setBackground(new java.awt.Color(227, 218, 201));
        jTable_Content.setFont(new java.awt.Font("Roboto", 0, 12));
        jTable_Content.setForeground(new java.awt.Color(0, 0, 0));
        jTable_Content.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable_Content.setMinimumSize(new java.awt.Dimension(50, 50));
        jTable_Content.setPreferredSize(new java.awt.Dimension(788, 383));
        jTable_Content.setShowGrid(true);
        jScrollPane_Table.setViewportView(jTable_Content);
        jTable_Content.getAccessibleContext().setAccessibleName("tabla de resultados");

        jPanel_select.add(jScrollPane_Table);

        opcionesTabla.setBackground(new java.awt.Color(0, 153, 204));
        opcionesTabla.setMaximumSize(new java.awt.Dimension(32767, 100));
        opcionesTabla.setMinimumSize(new java.awt.Dimension(780, 44));
        opcionesTabla.setPreferredSize(new java.awt.Dimension(794, 45));
        opcionesTabla.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 10));

        jTextField_buscarTabla.setDocument(new LimitarCamposSeguro(25, "Buscar...")
        );
        jTextField_buscarTabla.setText("Buscar...");
        jTextField_buscarTabla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField_buscarTabla.setPreferredSize(new java.awt.Dimension(125, 26));
        jTextField_buscarTabla.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_buscarTablaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_buscarTablaFocusLost(evt);
            }
        });
        jTextField_buscarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_buscarTablaActionPerformed(evt);
            }
        });
        opcionesTabla.add(jTextField_buscarTabla);

        jButton_buscar.setBackground(new java.awt.Color(204, 204, 204));
        jButton_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa_icon.png")));
        jButton_buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_buscarMouseClicked(evt);
            }
        });
        opcionesTabla.add(jButton_buscar);

        jButton_acercar.setText("Acercar");
        jButton_acercar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_acercarMouseClicked(evt);
            }
        });
        opcionesTabla.add(jButton_acercar);

        jButton_alejar.setText("Alejar");
        jButton_alejar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_alejarMouseClicked(evt);
            }
        });
        opcionesTabla.add(jButton_alejar);

        jButton_ordenar.setText("Ordenar");
        jButton_ordenar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_ordenarMouseClicked(evt);
            }
        });
        opcionesTabla.add(jButton_ordenar);

        jButton_filtros.setText("Filtros");
        jButton_filtros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_filtrosMouseClicked(evt);
            }
        });
        opcionesTabla.add(jButton_filtros);

        jButton_fuente.setText("Fuente y tamaño");
        jButton_fuente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_fuenteMouseClicked(evt);
            }
        });
        opcionesTabla.add(jButton_fuente);

        jButton_exportar.setText("Exportar tabla");
        jButton_exportar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_exportarMouseClicked(evt);
            }
        });
        opcionesTabla.add(jButton_exportar);

        jPanel_select.add(opcionesTabla);

        jPanel_preferencias.setBackground(new java.awt.Color(227, 218, 201));
        jPanel_preferencias.setPreferredSize(new java.awt.Dimension(794, 794));
        jPanel_preferencias.setLayout(new javax.swing.BoxLayout(jPanel_preferencias, javax.swing.BoxLayout.Y_AXIS));

        icon_preferencias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ajuetes3.png")));
        icon_preferencias.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        icon_preferencias.setPreferredSize(new java.awt.Dimension(130, 120));
        jPanel_preferencias.add(icon_preferencias);

        titulo3.setFont(new java.awt.Font("Microsoft YaHei", 1, 24));
        titulo3.setForeground(new java.awt.Color(0, 0, 0));
        titulo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo3.setText("Preferencias");
        titulo3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel_preferencias.add(titulo3);

        jPanel_separador1.setBackground(new java.awt.Color(227, 218, 201));
        jPanel_separador1.setMaximumSize(new java.awt.Dimension(32767, 25));

        javax.swing.GroupLayout jPanel_separador1Layout = new javax.swing.GroupLayout(jPanel_separador1);
        jPanel_separador1.setLayout(jPanel_separador1Layout);
        jPanel_separador1Layout.setHorizontalGroup(
            jPanel_separador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 977, Short.MAX_VALUE)
        );
        jPanel_separador1Layout.setVerticalGroup(
            jPanel_separador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel_preferencias.add(jPanel_separador1);

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 14));
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Tamaño y Fuente preferida");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel_preferencias.add(jLabel4);

        jPanel_separador2.setBackground(new java.awt.Color(227, 218, 201));
        jPanel_separador2.setMaximumSize(new java.awt.Dimension(32767, 15));

        javax.swing.GroupLayout jPanel_separador2Layout = new javax.swing.GroupLayout(jPanel_separador2);
        jPanel_separador2.setLayout(jPanel_separador2Layout);
        jPanel_separador2Layout.setHorizontalGroup(
            jPanel_separador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 977, Short.MAX_VALUE)
        );
        jPanel_separador2Layout.setVerticalGroup(
            jPanel_separador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        jPanel_preferencias.add(jPanel_separador2);

        jPanel_fontChooser.setBackground(new java.awt.Color(227, 218, 201));
        jPanel_fontChooser.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel_fontChooser.setMaximumSize(new java.awt.Dimension(700, 250));
        jPanel_fontChooser.setPreferredSize(new java.awt.Dimension(460, 250));
        jPanel_fontChooser.setLayout(new java.awt.GridLayout(3, 2, 10, 10));
        jPanel_preferencias.add(jPanel_fontChooser);
        // Familia de la fuente
        JLabel familyLabel = new JLabel("Familia:");
        familyLabel.setFont(new Font("Roboto", 0, 14));
        JComboBox<String> familyComboBox = new JComboBox<>(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
        familyComboBox.setFont(new Font("Roboto", 0, 14));
        jPanel_fontChooser.add(familyLabel);
        jPanel_fontChooser.add(familyComboBox);

        // Estilo de la fuente
        JLabel styleLabel = new JLabel("Estilo:");
        styleLabel.setFont(new Font("Roboto", 0, 14));
        String[] styles = {"Regular", "Negrita", "Cursiva", "Negrita Cursiva"};
        JComboBox<String> styleComboBox = new JComboBox<>(styles);
        styleComboBox.setFont(new Font("Roboto", 0, 14));
        jPanel_fontChooser.add(styleLabel);
        jPanel_fontChooser.add(styleComboBox);

        // Tamaño de la fuente
        JLabel sizeLabel = new JLabel("Tamaño:");
        sizeLabel.setFont(new Font("Roboto", 0, 14));
        JSpinner sizeSpinner = new JSpinner(new SpinnerNumberModel(12, 1, 100, 1));
        sizeSpinner.setFont(new Font("Roboto", 0, 14));
        jPanel_fontChooser.add(sizeLabel);
        jPanel_fontChooser.add(sizeSpinner);

        jPanel_separador3.setBackground(new java.awt.Color(227, 218, 201));
        jPanel_separador3.setMaximumSize(new java.awt.Dimension(32767, 25));

        javax.swing.GroupLayout jPanel_separador3Layout = new javax.swing.GroupLayout(jPanel_separador3);
        jPanel_separador3.setLayout(jPanel_separador3Layout);
        jPanel_separador3Layout.setHorizontalGroup(
            jPanel_separador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 977, Short.MAX_VALUE)
        );
        jPanel_separador3Layout.setVerticalGroup(
            jPanel_separador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel_preferencias.add(jPanel_separador3);

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 14));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Tipo de archivo exportar preferido");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel_preferencias.add(jLabel1);

        jComboBox_exportarType.setFont(new java.awt.Font("Roboto", 0, 14));
        jComboBox_exportarType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir...", "CSV", "TXT", "PDF", "Excel" }));
        jComboBox_exportarType.setMaximumSize(new java.awt.Dimension(367, 40));
        jComboBox_exportarType.setPreferredSize(new java.awt.Dimension(190, 37));
        jPanel_preferencias.add(jComboBox_exportarType);

        jPanel_separador4.setBackground(new java.awt.Color(227, 218, 201));
        jPanel_separador4.setMaximumSize(new java.awt.Dimension(32767, 25));

        javax.swing.GroupLayout jPanel_separador4Layout = new javax.swing.GroupLayout(jPanel_separador4);
        jPanel_separador4.setLayout(jPanel_separador4Layout);
        jPanel_separador4Layout.setHorizontalGroup(
            jPanel_separador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 977, Short.MAX_VALUE)
        );
        jPanel_separador4Layout.setVerticalGroup(
            jPanel_separador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel_preferencias.add(jPanel_separador4);

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 14));
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Sede de salud preferida");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel_preferencias.add(jLabel5);

        jComboBox_exportarType1.setFont(new java.awt.Font("Roboto", 0, 14));
        jComboBox_exportarType1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir..." }));
        jComboBox_exportarType1.setMaximumSize(new java.awt.Dimension(567, 40));
        jComboBox_exportarType1.setPreferredSize(new java.awt.Dimension(450, 37));
        jPanel_preferencias.add(jComboBox_exportarType1);

        jPanel_separador5.setBackground(new java.awt.Color(227, 218, 201));
        jPanel_separador5.setMaximumSize(new java.awt.Dimension(32767, 25));

        javax.swing.GroupLayout jPanel_separador5Layout = new javax.swing.GroupLayout(jPanel_separador5);
        jPanel_separador5.setLayout(jPanel_separador5Layout);
        jPanel_separador5Layout.setHorizontalGroup(
            jPanel_separador5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 977, Short.MAX_VALUE)
        );
        jPanel_separador5Layout.setVerticalGroup(
            jPanel_separador5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel_preferencias.add(jPanel_separador5);

        jButton_savePreferences.setFont(new java.awt.Font("Roboto", 0, 14));
        jButton_savePreferences.setForeground(new java.awt.Color(255, 255, 255));
        jButton_savePreferences.setText("Guardar preferencias");
        jButton_savePreferences.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_savePreferences.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_savePreferences.setMaximumSize(new java.awt.Dimension(166, 48));
        jButton_savePreferences.setPreferredSize(new java.awt.Dimension(166, 48));
        jButton_savePreferences.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_savePreferencesMouseClicked(evt);
            }
        });
        jPanel_preferencias.add(jButton_savePreferences);

        jPanel_insert_update_delete.setBackground(new java.awt.Color(227, 218, 201));
        jPanel_insert_update_delete.setPreferredSize(new java.awt.Dimension(794, 794));
        jPanel_insert_update_delete.setLayout(new javax.swing.BoxLayout(jPanel_insert_update_delete, javax.swing.BoxLayout.Y_AXIS));

        jPanel9.setBackground(new java.awt.Color(227, 218, 201));
        jPanel9.setMaximumSize(new java.awt.Dimension(2147483647, 400));
        jPanel9.setPreferredSize(new java.awt.Dimension(794, 360));
        jPanel9.setLayout(new java.awt.GridLayout(10, 1));

        titulo_contenido2.setBackground(new java.awt.Color(255, 255, 255));
        titulo_contenido2.setFont(new java.awt.Font("Roboto", 3, 14));
        titulo_contenido2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo_contenido2.setText("INSERT - UPDATE -DELETE");
        titulo_contenido2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titulo_contenido2.setMaximumSize(new java.awt.Dimension(2147483647, 17));
        titulo_contenido2.setOpaque(true);
        titulo_contenido2.setPreferredSize(new java.awt.Dimension(794, 17));
        jPanel9.add(titulo_contenido2);

        jPanel10.setBackground(new java.awt.Color(227, 218, 201));
        jPanel10.setPreferredSize(new java.awt.Dimension(794, 25));
        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.X_AXIS));

        update.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        update.setForeground(new java.awt.Color(0, 0, 0));
        update.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        update.setText("UPDATE");
        update.setMaximumSize(new java.awt.Dimension(60, 33));
        update.setPreferredSize(new java.awt.Dimension(50, 33));
        jPanel10.add(update);

        jComboBox_tabla1.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jComboBox_tabla1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tabla1" }));
        jComboBox_tabla1.setMaximumSize(new java.awt.Dimension(367, 32767));
        jComboBox_tabla1.setPreferredSize(new java.awt.Dimension(150, 27));
        jComboBox_tabla1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_tabla1ActionPerformed(evt);
            }
        });
        jPanel10.add(jComboBox_tabla1);

        set1.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        set1.setForeground(new java.awt.Color(0, 0, 0));
        set1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        set1.setText("SET");
        set1.setMaximumSize(new java.awt.Dimension(45, 33));
        set1.setPreferredSize(new java.awt.Dimension(25, 33));
        jPanel10.add(set1);

        jComboBox_columna2.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jComboBox_columna2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "*" }));
        jComboBox_columna2.setPreferredSize(new java.awt.Dimension(150, 27));
        jPanel10.add(jComboBox_columna2);

        punto1.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        punto1.setForeground(new java.awt.Color(0, 0, 0));
        punto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        punto1.setText("=");
        punto1.setMaximumSize(new java.awt.Dimension(45, 33));
        punto1.setPreferredSize(new java.awt.Dimension(25, 33));
        jPanel10.add(punto1);

        jTextField_valorUpdate.setDocument(new LimitarCamposSQL(50, "Valor"));
        jTextField_valorUpdate.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jTextField_valorUpdate.setForeground(java.awt.Color.gray);
        jTextField_valorUpdate.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField_valorUpdate.setText("Valor");
        jTextField_valorUpdate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_valorUpdateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_valorUpdateFocusLost(evt);
            }
        });
        jTextField_valorUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_valorUpdateActionPerformed(evt);
            }
        });
        jPanel10.add(jTextField_valorUpdate);

        cantColumn1.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        cantColumn1.setForeground(new java.awt.Color(0, 0, 0));
        cantColumn1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cantColumn1.setText("Cantidad de columnas");
        cantColumn1.setMaximumSize(new java.awt.Dimension(160, 33));
        cantColumn1.setPreferredSize(new java.awt.Dimension(145, 33));
        jPanel10.add(cantColumn1);

        jComboBox_cantColumn1.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jComboBox_cantColumn1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19" }));
        jComboBox_cantColumn1.setMaximumSize(new java.awt.Dimension(80, 32767));
        jComboBox_cantColumn1.setPreferredSize(new java.awt.Dimension(80, 27));
        jComboBox_cantColumn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_cantColumn1ActionPerformed(evt);
            }
        });
        jPanel10.add(jComboBox_cantColumn1);

        jTextField_updateComplejo.setDocument(new LimitarCamposSQL(200, "Campos y/o función"));
        jTextField_updateComplejo.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jTextField_updateComplejo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField_updateComplejo.setText("Campos y/o función");
        jTextField_updateComplejo.setVisible(false);
        RegistrarUser.handleFocusGain(jTextField_updateComplejo, "Campos y/o función");
        jTextField_updateComplejo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_updateComplejoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_updateComplejoFocusLost(evt);
            }
        });
        jTextField_updateComplejo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_updateComplejoActionPerformed(evt);
            }
        });
        jPanel10.add(jTextField_updateComplejo);

        jToggleButton2.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jToggleButton2.setText("¿Complejo?");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        jPanel10.add(jToggleButton2);

        jPanel9.add(jPanel10);

        jPanel11.setBackground(new java.awt.Color(227, 218, 201));
        jPanel11.setPreferredSize(new java.awt.Dimension(794, 25));
        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.X_AXIS));

        where2.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        where2.setForeground(new java.awt.Color(0, 0, 0));
        where2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        where2.setText("WHERE");
        where2.setMaximumSize(new java.awt.Dimension(60, 33));
        where2.setPreferredSize(new java.awt.Dimension(50, 33));
        jPanel11.add(where2);

        jTextField_where1.setDocument(new LimitarCamposSQL(100, "Condición o condiciones"));
        jTextField_where1.setText("Condición o condiciones");
        RegistrarUser.handleFocusGain(jTextField_where1, "Condición o condiciones");
        jTextField_where1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_where1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_where1FocusLost(evt);
            }
        });
        jTextField_where1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_where1ActionPerformed(evt);
            }
        });
        jPanel11.add(jTextField_where1);

        jPanel9.add(jPanel11);

        jButton2.setBackground(new java.awt.Color(0, 204, 0));
        jButton2.setFont(new java.awt.Font("Microsoft YaHei", 1, 12));
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa_icon.png")));
        jButton2.setText("Actualizar");
        jButton2.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        jButton2.setPreferredSize(new java.awt.Dimension(794, 30));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel9.add(jButton2);

        jPanel12.setBackground(new java.awt.Color(227, 218, 201));
        jPanel12.setPreferredSize(new java.awt.Dimension(794, 25));
        jPanel12.setLayout(new javax.swing.BoxLayout(jPanel12, javax.swing.BoxLayout.X_AXIS));

        insert.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        insert.setForeground(new java.awt.Color(0, 0, 0));
        insert.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        insert.setText("INSERT INTO");
        insert.setMaximumSize(new java.awt.Dimension(100, 33));
        insert.setPreferredSize(new java.awt.Dimension(90, 33));
        jPanel12.add(insert);

        jComboBox_tabla2.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jComboBox_tabla2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tabla1" }));
        jComboBox_tabla2.setMaximumSize(new java.awt.Dimension(367, 32767));
        jComboBox_tabla2.setPreferredSize(new java.awt.Dimension(150, 27));
        jComboBox_tabla2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_tabla2ActionPerformed(evt);
            }
        });
        jPanel12.add(jComboBox_tabla2);

        punto2.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        punto2.setForeground(new java.awt.Color(0, 0, 0));
        punto2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        punto2.setText("(");
        punto2.setMaximumSize(new java.awt.Dimension(45, 33));
        punto2.setPreferredSize(new java.awt.Dimension(10, 33));
        jPanel12.add(punto2);

        jComboBox_columna1.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jComboBox_columna1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "*" }));
        jComboBox_columna1.setPreferredSize(new java.awt.Dimension(150, 27));
        jPanel12.add(jComboBox_columna1);

        punto3.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        punto3.setForeground(new java.awt.Color(0, 0, 0));
        punto3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        punto3.setText(")");
        punto3.setMaximumSize(new java.awt.Dimension(45, 33));
        punto3.setPreferredSize(new java.awt.Dimension(10, 33));
        jPanel12.add(punto3);

        values.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        values.setForeground(new java.awt.Color(0, 0, 0));
        values.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        values.setText("VALUES");
        values.setMaximumSize(new java.awt.Dimension(85, 33));
        values.setPreferredSize(new java.awt.Dimension(75, 33));
        jPanel12.add(values);

        punto4.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        punto4.setForeground(new java.awt.Color(0, 0, 0));
        punto4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        punto4.setText("=");
        punto4.setMaximumSize(new java.awt.Dimension(45, 33));
        punto4.setPreferredSize(new java.awt.Dimension(25, 33));
        jPanel12.add(punto4);

        jTextField_valorInsert.setDocument(new LimitarCamposSQL(50, "Valor"));
        jTextField_valorInsert.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jTextField_valorInsert.setForeground(java.awt.Color.gray);
        jTextField_valorInsert.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField_valorInsert.setText("Valor");
        jTextField_valorInsert.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_valorInsertFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_valorInsertFocusLost(evt);
            }
        });
        jTextField_valorInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_valorInsertActionPerformed(evt);
            }
        });
        jPanel12.add(jTextField_valorInsert);

        cantColumn.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        cantColumn.setForeground(new java.awt.Color(0, 0, 0));
        cantColumn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cantColumn.setText("Cantidad de columnas");
        cantColumn.setMaximumSize(new java.awt.Dimension(160, 33));
        cantColumn.setPreferredSize(new java.awt.Dimension(145, 33));
        jPanel12.add(cantColumn);

        jComboBox_cantColumn2.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jComboBox_cantColumn2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19" }));
        jComboBox_cantColumn2.setMaximumSize(new java.awt.Dimension(80, 32767));
        jComboBox_cantColumn2.setPreferredSize(new java.awt.Dimension(80, 27));
        jComboBox_cantColumn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_cantColumn2ActionPerformed(evt);
            }
        });
        jPanel12.add(jComboBox_cantColumn2);

        jTextField_insertComplejo.setDocument(new LimitarCamposSQL(200, "Campos y/o función"));
        jTextField_insertComplejo.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jTextField_insertComplejo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField_insertComplejo.setText("Campos y/o función");
        jTextField_insertComplejo.setVisible(false);
        RegistrarUser.handleFocusGain(jTextField_insertComplejo, "Campos y/o función");
        jTextField_insertComplejo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_insertComplejoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_insertComplejoFocusLost(evt);
            }
        });
        jTextField_insertComplejo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_insertComplejoActionPerformed(evt);
            }
        });
        jPanel12.add(jTextField_insertComplejo);

        jToggleButton3.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jToggleButton3.setText("¿Complejo?");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });
        jPanel12.add(jToggleButton3);

        jPanel9.add(jPanel12);

        jButton3.setBackground(new java.awt.Color(0, 204, 0));
        jButton3.setFont(new java.awt.Font("Microsoft YaHei", 1, 12));
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa_icon.png")));
        jButton3.setText("Insertar");
        jButton3.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        jButton3.setPreferredSize(new java.awt.Dimension(794, 30));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel9.add(jButton3);

        jPanel13.setBackground(new java.awt.Color(227, 218, 201));
        jPanel13.setPreferredSize(new java.awt.Dimension(794, 25));
        jPanel13.setLayout(new javax.swing.BoxLayout(jPanel13, javax.swing.BoxLayout.X_AXIS));

        delete.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        delete.setForeground(new java.awt.Color(0, 0, 0));
        delete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        delete.setText("DELETE FROM");
        delete.setMaximumSize(new java.awt.Dimension(100, 33));
        delete.setPreferredSize(new java.awt.Dimension(90, 33));
        jPanel13.add(delete);

        jComboBox_tabla3.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jComboBox_tabla3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tabla1" }));
        jComboBox_tabla3.setPreferredSize(new java.awt.Dimension(150, 27));
        jPanel13.add(jComboBox_tabla3);

        jTextField_deleteComplejo.setDocument(new LimitarCamposSQL(200, "Campos y/o función"));
        jTextField_deleteComplejo.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jTextField_deleteComplejo.setText("Campos y/o función");
        jTextField_deleteComplejo.setVisible(false);
        RegistrarUser.handleFocusGain(jTextField_deleteComplejo, "Campos y/o función");
        jTextField_deleteComplejo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_deleteComplejoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_deleteComplejoFocusLost(evt);
            }
        });
        jTextField_deleteComplejo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_deleteComplejoActionPerformed(evt);
            }
        });
        jPanel13.add(jTextField_deleteComplejo);

        jToggleButton4.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jToggleButton4.setText("¿Complejo?");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });
        jPanel13.add(jToggleButton4);

        jPanel9.add(jPanel13);

        jPanel14.setBackground(new java.awt.Color(227, 218, 201));
        jPanel14.setPreferredSize(new java.awt.Dimension(794, 25));
        jPanel14.setLayout(new javax.swing.BoxLayout(jPanel14, javax.swing.BoxLayout.X_AXIS));

        where3.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        where3.setForeground(new java.awt.Color(0, 0, 0));
        where3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        where3.setText("WHERE");
        where3.setMaximumSize(new java.awt.Dimension(60, 33));
        where3.setPreferredSize(new java.awt.Dimension(50, 33));
        jPanel14.add(where3);

        jTextField_where2.setDocument(new LimitarCamposSQL(100, "Condición o condiciones"));
        jTextField_where2.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        jTextField_where2.setText("Condición o condiciones");
        RegistrarUser.handleFocusGain(jTextField_where2, "Condición o condiciones");
        jTextField_where2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_where2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_where2FocusLost(evt);
            }
        });
        jTextField_where2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_where2ActionPerformed(evt);
            }
        });
        jPanel14.add(jTextField_where2);

        jPanel9.add(jPanel14);

        jButton4.setBackground(new java.awt.Color(0, 204, 0));
        jButton4.setFont(new java.awt.Font("Microsoft YaHei", 1, 12));
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa_icon.png")));
        jButton4.setText("Eliminar");
        jButton4.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        jButton4.setPreferredSize(new java.awt.Dimension(794, 30));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jPanel9.add(jButton4);

        jPanel_insert_update_delete.add(jPanel9);

        separador.setBackground(new java.awt.Color(227, 218, 201));
        separador.setMaximumSize(new java.awt.Dimension(32767, 30));
        separador.setPreferredSize(new java.awt.Dimension(794, 30));

        javax.swing.GroupLayout separadorLayout = new javax.swing.GroupLayout(separador);
        separador.setLayout(separadorLayout);
        separadorLayout.setHorizontalGroup(
            separadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 794, Short.MAX_VALUE)
        );
        separadorLayout.setVerticalGroup(
            separadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel_insert_update_delete.add(separador);

        resultadosActualizar.setEditable(false);
        resultadosActualizar.setBackground(new java.awt.Color(227, 218, 201));
        resultadosActualizar.setFont(new java.awt.Font("Roboto", 0, 14));
        resultadosActualizar.setLineWrap(true);
        resultadosActualizar.setRows(5);
        resultadosActualizar.setText("Resultado");
        resultadosActualizar.setWrapStyleWord(true);
        resultadosActualizar.setPreferredSize(new java.awt.Dimension(794, 89));
        jPanel_insert_update_delete.add(resultadosActualizar);

        jPanel_backup.setBackground(new java.awt.Color(227, 218, 201));
        jPanel_backup.setPreferredSize(new java.awt.Dimension(794, 794));

        javax.swing.GroupLayout jPanel_backupLayout = new javax.swing.GroupLayout(jPanel_backup);
        jPanel_backup.setLayout(jPanel_backupLayout);
        jPanel_backupLayout.setHorizontalGroup(
            jPanel_backupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel_backupLayout.setVerticalGroup(
            jPanel_backupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel15.setBackground(new java.awt.Color(227, 218, 201));
        jPanel15.setPreferredSize(new java.awt.Dimension(794, 25));
        jPanel15.setLayout(new javax.swing.BoxLayout(jPanel15, javax.swing.BoxLayout.X_AXIS));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Programa Vacunas Panamá - ADMIN");
        setSize(new java.awt.Dimension(1000, 800));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jScrollPane3.setPreferredSize(getSize());

        background.setBackground(new java.awt.Color(227, 218, 201));
        background.setForeground(new java.awt.Color(227, 218, 201));
        background.setMinimumSize(new java.awt.Dimension(994, 794));
        background.setPreferredSize(new java.awt.Dimension(994, 794));
        background.setLayout(new java.awt.BorderLayout());

        jPanel_menuOpciones.setBackground(new java.awt.Color(39, 104, 165));
        jPanel_menuOpciones.setForeground(new java.awt.Color(48, 48, 46));
        jPanel_menuOpciones.setAutoscrolls(true);
        jPanel_menuOpciones.setMaximumSize(getSize());
        jPanel_menuOpciones.setPreferredSize(new java.awt.Dimension(200, 0));
        jPanel_menuOpciones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 10));

        separador1.setBackground(new java.awt.Color(39, 104, 165));
        separador1.setForeground(new java.awt.Color(48, 48, 46));
        separador1.setPreferredSize(new java.awt.Dimension(150, 35));

        javax.swing.GroupLayout separador1Layout = new javax.swing.GroupLayout(separador1);
        separador1.setLayout(separador1Layout);
        separador1Layout.setHorizontalGroup(
            separador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        separador1Layout.setVerticalGroup(
            separador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel_menuOpciones.add(separador1);

        icon_project.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon_project.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/operacionVacunas_logo.png")));
        icon_project.setAlignmentX(0.5F);
        icon_project.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        icon_project.setMaximumSize(new java.awt.Dimension(200, 200));
        icon_project.setMinimumSize(new java.awt.Dimension(50, 50));
        icon_project.setName("");
        icon_project.setPreferredSize(new java.awt.Dimension(135, 135));
        jPanel_menuOpciones.add(icon_project);
        icon_project.getAccessibleContext().setAccessibleName("logo");

        separador3.setBackground(new java.awt.Color(39, 104, 165));
        separador3.setForeground(new java.awt.Color(48, 48, 46));
        separador3.setPreferredSize(new java.awt.Dimension(150, 20));

        javax.swing.GroupLayout separador3Layout = new javax.swing.GroupLayout(separador3);
        separador3.setLayout(separador3Layout);
        separador3Layout.setHorizontalGroup(
            separador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        separador3Layout.setVerticalGroup(
            separador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel_menuOpciones.add(separador3);

        rolName.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        rolName.setForeground(new java.awt.Color(255, 255, 255));
        rolName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rolName.setText("¡ Hola Admin !");
        rolName.setAlignmentX(1.0F);
        rolName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rolName.setPreferredSize(new java.awt.Dimension(170, 30));
        jPanel_menuOpciones.add(rolName);

        nombreBienvenida.setFont(new java.awt.Font("Microsoft YaHei", 0, 12));
        nombreBienvenida.setForeground(new java.awt.Color(255, 255, 255));
        nombreBienvenida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreBienvenida.setText("Nombre");
        nombreBienvenida.setAlignmentX(1.0F);
        nombreBienvenida.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nombreBienvenida.setPreferredSize(new java.awt.Dimension(150, 30));
        jPanel_menuOpciones.add(nombreBienvenida);

        separador2.setBackground(new java.awt.Color(39, 104, 165));
        separador2.setForeground(new java.awt.Color(48, 48, 46));
        separador2.setPreferredSize(new java.awt.Dimension(150, 20));

        javax.swing.GroupLayout separador2Layout = new javax.swing.GroupLayout(separador2);
        separador2.setLayout(separador2Layout);
        separador2Layout.setHorizontalGroup(
            separador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        separador2Layout.setVerticalGroup(
            separador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel_menuOpciones.add(separador2);

        button_opcion1.setForeground(new java.awt.Color(255, 255, 255));
        button_opcion1.setText("Select");
        button_opcion1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_opcion1.setPreferredSize(new java.awt.Dimension(160, 30));
        button_opcion1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_opcion1MouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_opcion1);

        button_opcion2.setForeground(new java.awt.Color(255, 255, 255));
        button_opcion2.setText("Insert - Update - Delete");
        button_opcion2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_opcion2.setPreferredSize(new java.awt.Dimension(160, 30));
        button_opcion2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_opcion2MouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_opcion2);

        button_opcion5.setForeground(new java.awt.Color(255, 255, 255));
        button_opcion5.setText("Backups");
        button_opcion5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_opcion5.setEnabled(false);
        button_opcion5.setFocusPainted(false);
        button_opcion5.setPreferredSize(new java.awt.Dimension(160, 30));
        button_opcion5.setRequestFocusEnabled(false);
        button_opcion5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_opcion5MouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_opcion5);

        button_opcion6.setForeground(new java.awt.Color(255, 255, 255));
        button_opcion6.setText("Procedimiento o funciones");
        button_opcion6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_opcion6.setPreferredSize(new java.awt.Dimension(160, 30));
        jPanel_menuOpciones.add(button_opcion6);

        button_opcion7.setForeground(new java.awt.Color(255, 255, 255));
        button_opcion7.setText("Manejo de usuarios");
        button_opcion7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_opcion7.setEnabled(false);
        button_opcion7.setFocusPainted(false);
        button_opcion7.setFocusable(false);
        button_opcion7.setPreferredSize(new java.awt.Dimension(160, 30));
        button_opcion7.setRequestFocusEnabled(false);
        jPanel_menuOpciones.add(button_opcion7);

        separador4.setBackground(new java.awt.Color(39, 104, 165));
        separador4.setForeground(new java.awt.Color(48, 48, 46));
        separador4.setPreferredSize(new java.awt.Dimension(150, 20));

        javax.swing.GroupLayout separador4Layout = new javax.swing.GroupLayout(separador4);
        separador4.setLayout(separador4Layout);
        separador4Layout.setHorizontalGroup(
            separador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        separador4Layout.setVerticalGroup(
            separador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel_menuOpciones.add(separador4);

        button_modificarDatos.setForeground(new java.awt.Color(255, 255, 255));
        button_modificarDatos.setText("Modificar datos personales");
        button_modificarDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_modificarDatos.setEnabled(false);
        button_modificarDatos.setFocusPainted(false);
        button_modificarDatos.setFocusable(false);
        button_modificarDatos.setPreferredSize(new java.awt.Dimension(160, 30));
        button_modificarDatos.setRequestFocusEnabled(false);
        jPanel_menuOpciones.add(button_modificarDatos);

        button_modificarCred.setForeground(new java.awt.Color(255, 255, 255));
        button_modificarCred.setText("Modificar credenciales");
        button_modificarCred.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_modificarCred.setEnabled(false);
        button_modificarCred.setFocusPainted(false);
        button_modificarCred.setFocusable(false);
        button_modificarCred.setPreferredSize(new java.awt.Dimension(160, 30));
        button_modificarCred.setRequestFocusEnabled(false);
        jPanel_menuOpciones.add(button_modificarCred);

        button_preferencias.setForeground(new java.awt.Color(255, 255, 255));
        button_preferencias.setText("Preferencias");
        button_preferencias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_preferencias.setPreferredSize(new java.awt.Dimension(160, 30));
        button_preferencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_preferenciasMouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_preferencias);

        button_soporte.setForeground(new java.awt.Color(255, 255, 255));
        button_soporte.setText("Soporte");
        button_soporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_soporte.setEnabled(false);
        button_soporte.setFocusPainted(false);
        button_soporte.setFocusable(false);
        button_soporte.setPreferredSize(new java.awt.Dimension(160, 30));
        button_soporte.setRequestFocusEnabled(false);
        jPanel_menuOpciones.add(button_soporte);

        button_logOut.setBackground(new java.awt.Color(255, 85, 73));
        button_logOut.setForeground(new java.awt.Color(255, 255, 255));
        button_logOut.setText("Salir");
        button_logOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_logOut.setPreferredSize(new java.awt.Dimension(160, 30));
        button_logOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_logOutMouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_logOut);

        background.add(jPanel_menuOpciones, java.awt.BorderLayout.WEST);

        jPanel_derecho.setBackground(new java.awt.Color(227, 218, 201));
        jPanel_derecho.setPreferredSize(new java.awt.Dimension(794, 0));
        jPanel_derecho.setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(227, 218, 201));
        jPanel1.setPreferredSize(new java.awt.Dimension(794, 0));
        mostrando = jPanel1;

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei", 1, 20));
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Bienvenido administrador al Programa Vacunas Panamá");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(198, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(752, Short.MAX_VALUE))
        );

        jPanel_derecho.add(jPanel1, "vacio");

        background.add(jPanel_derecho, java.awt.BorderLayout.CENTER);

        jScrollPane3.setViewportView(background);

        getContentPane().add(jScrollPane3, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    /* eventos del jPanel mostrar tabla option 1*/
    private void jButton_acercarMouseClicked(java.awt.event.MouseEvent evt) {
        Font currentFont = jTable_Content.getFont();
        jTable_Content.setFont(currentFont.deriveFont(currentFont.getSize() + 2f));
    }

    private void jButton_alejarMouseClicked(java.awt.event.MouseEvent evt) {
        Font currentFont = jTable_Content.getFont();
        jTable_Content.setFont(currentFont.deriveFont(currentFont.getSize() - 2f));
    }

    private void jButton_fuenteMouseClicked(java.awt.event.MouseEvent evt) {
        JFontChooser fontChooser = new JFontChooser(this);
        boolean result = fontChooser.showDialog(this);
        if (result) {
            Font font = fontChooser.getSelectedFont();
            jTable_Content.setFont(font);
            jTable_Content.repaint();
        }
    }

    private void jButton_exportarMouseClicked(java.awt.event.MouseEvent evt) {
        /* TODO llamada al método exportar en csv o excel o pdf de option 1 */
    }

    private void formComponentShown(java.awt.event.ComponentEvent evt) {
        Login.setImageLabal(icon_project, "src/images/operacionVacunas_Logo.png");
        /* TODO por mover */
    }

    /* eventos de tabla option 1 */
    private void jButton_buscarMouseClicked(java.awt.event.MouseEvent evt) {
        jTextField_buscarTabla.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jTextField_buscarTabla.setForeground(Color.BLACK);

        String patronBuscado = jTextField_buscarTabla.getText();
        if (!patronBuscado.isBlank() || !patronBuscado.equals("Buscar...")) {
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTable_Content.getModel());
            jTable_Content.setRowSorter(sorter);
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + patronBuscado));
        } else {
            jTextField_buscarTabla.setBorder(BorderFactory.createLineBorder(Color.red));
            jTextField_buscarTabla.setForeground(Color.red);
        }
    }

    private void jTextField_buscarTablaActionPerformed(java.awt.event.ActionEvent evt) {
        jButton_buscarMouseClicked(null);
    }

    private void jTextField_buscarTablaFocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_buscarTabla, "Buscar...");
    }

    private void jTextField_buscarTablaFocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_buscarTabla, "Buscar...");
    }

    private void jButton_filtrosMouseClicked(java.awt.event.MouseEvent evt) {
        if (!jPanel_select.isAncestorOf(jPanel_filtrar)) {
            jPanel_select.add(jPanel_filtrar, BorderLayout.NORTH);
        } else {
            jPanel_select.remove(jPanel_filtrar);
        }
        jPanel_select.revalidate();
        jPanel_select.repaint();
    }

    private void jButton_ordenarMouseClicked(java.awt.event.MouseEvent evt) {
        jTable_Content.setAutoCreateRowSorter(true);
    }

    private void jButton_savePreferencesMouseClicked(java.awt.event.MouseEvent evt) {
        /* TODO implementar lógica de guardar preferencias del usuario*/
    }

    /* eventos del menú lateral */
    private void button_logOutMouseClicked(java.awt.event.MouseEvent evt) {
        this.dispose();
    }

    private void button_preferenciasMouseClicked(java.awt.event.MouseEvent evt) {
        if (!jPanel_derecho.isAncestorOf(jPanel_preferencias)) {
            jPanel_derecho.add(jPanel_preferencias, "preferences");
        }
        if (mostrando == jPanel_preferencias) {
            layout.show(jPanel_derecho, "vacio");
            mostrando = jPanel1;
        } else {
            layout.show(jPanel_derecho, "preferences");
            mostrando = jPanel_preferencias;
        }
        jPanel_derecho.revalidate();
        jPanel_derecho.repaint();
    }

    private void button_opcion1MouseClicked(java.awt.event.MouseEvent evt) {
        if (!jPanel_derecho.isAncestorOf(jPanel_select)) {
            jPanel_derecho.add(jPanel_select, "option 1");
        }
        if (mostrando == jPanel_select) {
            layout.show(jPanel_derecho, "vacio");
            mostrando = jPanel1;
        } else {
            layout.show(jPanel_derecho, "option 1");
            mostrando = jPanel_select;
        }
        jPanel_derecho.revalidate();
        jPanel_derecho.repaint();
    }

    private void button_opcion2MouseClicked(java.awt.event.MouseEvent evt) {
        if (!jPanel_derecho.isAncestorOf(jPanel_insert_update_delete)) {
            jPanel_derecho.add(jPanel_insert_update_delete, "option 2");
        }
        if (mostrando == jPanel_insert_update_delete) {
            layout.show(jPanel_derecho, "vacio");
            mostrando = jPanel1;
        } else {
            layout.show(jPanel_derecho, "option 2");
            mostrando = jPanel_insert_update_delete;
        }
        jPanel_derecho.revalidate();
        jPanel_derecho.repaint();
    }

    private void button_opcion5MouseClicked(java.awt.event.MouseEvent evt) {
        if (!jPanel_derecho.isAncestorOf(jPanel_backup)) {
            jPanel_derecho.add(jPanel_backup, "option 5");
        }
        if (mostrando == jPanel_backup) {
            layout.show(jPanel_derecho, "vacio");
            mostrando = jPanel1;
        } else {
            layout.show(jPanel_derecho, "option 5");
            mostrando = jPanel_backup;
        }
        jPanel_derecho.revalidate();
        jPanel_derecho.repaint();
    }

    /* eventos del panel SELECT */
    private void jButton_selectMouseClicked(java.awt.event.MouseEvent evt) {
        if (jComboBox_tabla.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "ERROR. Debe seleccionar alguna tabla en el FROM. OPERACIÓN CANCELADA", "ERROR SELECT", JOptionPane.ERROR_MESSAGE);
        } else {
            /* TODO implementar el BUSCAR SELECT según los criterios */
        }
    }

    private void jComboBox_joinsActionPerformed(java.awt.event.ActionEvent evt) {
        if (jComboBox_joins.getSelectedIndex() == 0) {
            jToggleButton1.setSelected(false);
            jToggleButton1ActionPerformed(null);
        } else {
            jToggleButton1.setSelected(true);
            jToggleButton1ActionPerformed(null);
        }

        int cantidad = jComboBox_joins.getSelectedIndex();
        int cantComponentesActual = jPanel2.getComponentCount();
        if (cantComponentesActual > 8) {
            for (int i = cantComponentesActual - 8; i > 0; i--) {
                jPanel2.remove(3);
            }
        }
        switch (cantidad) {
            case 0 -> {
                changeGridLayout(8, 1);
            }
            case 1 -> {
                changeGridLayout(9, 1);
                jPanel2.add(join1, 3);
            }
            case 2 -> {
                changeGridLayout(10, 1);
                jPanel2.add(join1, 3);
                jPanel2.add(join2, 3);
            }
            case 3 -> {
                changeGridLayout(11, 1);
                jPanel2.add(join1, 3);
                jPanel2.add(join2, 3);
                jPanel2.add(join3, 3);
            }
            case 4 -> {
                changeGridLayout(12, 1);
                jPanel2.add(join1, 3);
                jPanel2.add(join2, 3);
                jPanel2.add(join3, 3);
                jPanel2.add(join4, 3);
            }
            case 5 -> {
                changeGridLayout(13, 1);
                jPanel2.add(join1, 3);
                jPanel2.add(join2, 3);
                jPanel2.add(join3, 3);
                jPanel2.add(join4, 3);
                jPanel2.add(join5, 3);
            }
            default ->
                System.err.println("Caso no esperado en switch de cantidad de joins a crear en el panel Select");
        }
        jPanel2.revalidate();
        jPanel2.repaint();
    }

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jToggleButton1.getSelectedObjects() != null) {
            jComboBox_columna.setVisible(false);
            jTextField_selectComplejo.setVisible(true);
        } else {
            jComboBox_columna.setVisible(true);
            jTextField_selectComplejo.setVisible(false);
        }
    }

    private void jTextField_selectComplejoFocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_selectComplejo, "Campos y/o función");
    }

    private void jTextField_selectComplejoFocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_selectComplejo, "Campos y/o función");
    }

    private void jTextField_selectComplejoActionPerformed(java.awt.event.ActionEvent evt) {
        jComboBox_tabla.requestFocus();
    }

    private void jTextField_whereActionPerformed(java.awt.event.ActionEvent evt) {
        jTextField_order.requestFocus();
    }

    private void jTextField_orderActionPerformed(java.awt.event.ActionEvent evt) {
        jTextField_group.requestFocus();
    }

    private void jTextField_groupActionPerformed(java.awt.event.ActionEvent evt) {
        jTextField_having.requestFocus();
    }

    private void jTextField_havingActionPerformed(java.awt.event.ActionEvent evt) {
        jButton_selectMouseClicked(null);
    }

    private void jTextField_updateComplejoFocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_updateComplejo, "Campos y/o función");
    }

    private void jTextField_updateComplejoFocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_updateComplejo, "Campos y/o función");
    }

    private void jTextField_updateComplejoActionPerformed(java.awt.event.ActionEvent evt) {
        jButton2MouseClicked(null);
    }

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jToggleButton2.getSelectedObjects() != null) {
            jComboBox_tabla1.setVisible(false);
            set1.setVisible(false);
            jComboBox_columna2.setVisible(false);
            punto1.setVisible(false);
            jTextField_valorUpdate.setVisible(false);
            cantColumn1.setVisible(false);
            jComboBox_cantColumn1.setVisible(false);
            jPanel11.setVisible(false);

            jTextField_updateComplejo.setVisible(true);
        } else {
            jComboBox_tabla1.setVisible(true);
            set1.setVisible(true);
            jComboBox_columna2.setVisible(true);
            punto1.setVisible(true);
            jTextField_valorUpdate.setVisible(true);
            cantColumn1.setVisible(true);
            jComboBox_cantColumn1.setVisible(true);
            jPanel11.setVisible(true);

            jTextField_updateComplejo.setVisible(false);
        }
    }

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {
        String condicion = jTextField_where1.getText();
        if (condicion.isBlank() || condicion.equals("Condición o condiciones")) {
            JOptionPane.showMessageDialog(null, "No puede actualizar toda la data de una tabla. Declare una condición WHERE", "ERROR UPDATE", JOptionPane.ERROR_MESSAGE);
        } else {
            /* TODO implementar lógica de hacer update en la tabla específica y columnas específicas con la condición específica */
        }
    }

    private void jTextField_valorUpdateFocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_valorUpdate, "Valor");
    }

    private void jTextField_valorUpdateFocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_valorUpdate, "Valor");
    }

    private void jTextField_where1ActionPerformed(java.awt.event.ActionEvent evt) {
        jButton2MouseClicked(null);
    }

    private void jTextField_valorInsertFocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_valorInsert, "Valor");
    }

    private void jTextField_valorInsertFocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_valorInsert, "Valor");
    }

    private void jTextField_valorInsertActionPerformed(java.awt.event.ActionEvent evt) {
        jButton3MouseClicked(null);
    }

    private void jTextField_insertComplejoFocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_insertComplejo, "Campos y/o función");
    }

    private void jTextField_insertComplejoFocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_insertComplejo, "Campos y/o función");
    }

    private void jTextField_insertComplejoActionPerformed(java.awt.event.ActionEvent evt) {
        jButton3MouseClicked(null);
    }

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jToggleButton3.getSelectedObjects() != null) {
            jComboBox_tabla2.setVisible(false);
            punto2.setVisible(false);
            jComboBox_columna1.setVisible(false);
            punto3.setVisible(false);
            values.setVisible(false);
            punto4.setVisible(false);
            jTextField_valorInsert.setVisible(false);
            cantColumn.setVisible(false);
            jComboBox_cantColumn2.setVisible(false);
            jPanel9.add(jPanel15, 5);

            jTextField_insertComplejo.setVisible(true);
        } else {
            jComboBox_tabla2.setVisible(true);
            punto2.setVisible(true);
            jComboBox_columna1.setVisible(true);
            punto3.setVisible(true);
            values.setVisible(true);
            punto4.setVisible(true);
            jTextField_valorInsert.setVisible(true);
            cantColumn.setVisible(true);
            jComboBox_cantColumn2.setVisible(true);
            jPanel9.remove(jPanel15);

            jTextField_insertComplejo.setVisible(false);
        }
    }

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {
        /* TODO insertar dato */
    }

    private void jTextField_deleteComplejoFocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_deleteComplejo, "Campos y/o función");
    }

    private void jTextField_deleteComplejoFocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_deleteComplejo, "Campos y/o función");
    }

    private void jTextField_deleteComplejoActionPerformed(java.awt.event.ActionEvent evt) {
        jButton4MouseClicked(null);
    }

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jToggleButton4.getSelectedObjects() != null) {
            jComboBox_tabla3.setVisible(false);
            jPanel14.setVisible(false);

            jTextField_deleteComplejo.setVisible(true);
        } else {
            jComboBox_tabla3.setVisible(true);
            jPanel14.setVisible(true);

            jTextField_deleteComplejo.setVisible(false);
        }
    }

    private void jTextField_where2ActionPerformed(java.awt.event.ActionEvent evt) {
        jButton4MouseClicked(null);
    }

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {
        String condicion = jTextField_where2.getText();
        if (condicion.isBlank() || condicion.equals("Condición o condiciones")) {
            JOptionPane.showMessageDialog(null, "No puede eliminar toda la data de una tabla. Declare una condición WHERE", "ERROR DELETE", JOptionPane.ERROR_MESSAGE);
        } else {
            /* TODO implementar lógica de eliminar con la condición específica */
        }
    }

    private void jComboBox_cantColumn2ActionPerformed(java.awt.event.ActionEvent evt) {
        int cantidad = jComboBox_cantColumn2.getSelectedIndex();
        int cantComponentesActual = jPanel12.getComponentCount();
        int cantCu = (cantComponentesActual - 12) / 2;

        if (cantComponentesActual > 12) {
            for (int i = cantCu; i > 0; i--) {
                jPanel12.remove(3);
            }
            for (int i = cantCu; i > 0; i--) {
                jPanel12.remove(jPanel12.getComponentCount() - 5);
            }
        }
        if (cantidad >= 1) {
            if (cantidad > 15) {
                jToggleButton3.setSelected(true);
                jToggleButton3ActionPerformed(null);
                return;
            }
            for (int i = 0; i < cantidad; i++) {
                JComboBox<?> nuevoComboBox = new JComboBox<>(jComboBox_columna3.getModel());
                nuevoComboBox.setMinimumSize(new Dimension(76, 27));
                nuevoComboBox.setPreferredSize(new Dimension(100, 27));
                JTextField nuevoTextField = new JTextField(jTextField_valorInsert2.getText());
                nuevoTextField.setHorizontalAlignment(2);
                nuevoTextField.setDocument(new LimitarCamposSQL(50, "Valor"));
                RegistrarUser.handleFocusGain(nuevoTextField, "Valor");
                addFocusListenersValor(nuevoTextField);

                jPanel12.add(nuevoComboBox, 3);
                jPanel12.add(nuevoTextField, (jPanel12.getComponentCount() - 5));
            }
        }
        jPanel12.revalidate();
        jPanel12.repaint();
    }

    private void jTextField_where2FocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_where2, "Condición o condiciones");
    }

    private void jTextField_where2FocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_where2, "Condición o condiciones");
    }

    private void jTextField_where1FocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_where1, "Condición o condiciones");
    }

    private void jTextField_where1FocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_where1, "Condición o condiciones");
    }

    private void jComboBox_cantColumn1ActionPerformed(java.awt.event.ActionEvent evt) {
        int cantidad = jComboBox_cantColumn1.getSelectedIndex();
        int cantComponentesActual = jPanel10.getComponentCount();
        int cantCu = (cantComponentesActual - 10) / 2;

        if (cantComponentesActual > 10) {
            for (int i = cantCu; i > 0; i--) {
                jPanel10.remove(3);
            }
            for (int i = cantCu; i > 0; i--) {
                jPanel10.remove(jPanel10.getComponentCount() - 5);
            }
        }
        if (cantidad >= 1) {
            if (cantidad > 16) {
                jToggleButton2.setSelected(true);
                jToggleButton2ActionPerformed(null);
                return;
            }
            for (int i = 0; i < cantidad; i++) {
                JComboBox<?> nuevoComboBox = new JComboBox<>(jComboBox_columna3.getModel());
                nuevoComboBox.setMinimumSize(new Dimension(76, 27));
                nuevoComboBox.setPreferredSize(new Dimension(100, 27));
                JTextField nuevoTextField = new JTextField(jTextField_valorInsert2.getText());
                nuevoTextField.setHorizontalAlignment(2);
                nuevoTextField.setDocument(new LimitarCamposSQL(50, "Valor"));
                RegistrarUser.handleFocusGain(nuevoTextField, "Valor");
                addFocusListenersValor(nuevoTextField);

                jPanel10.add(nuevoComboBox, 3);
                jPanel10.add(nuevoTextField, (jPanel10.getComponentCount() - 5));
            }
        }
        jPanel10.revalidate();
        jPanel10.repaint();
    }

    private void jTextField_valorInsert2FocusGained(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_valorInsert2, "Valor");
    }

    private void jTextField_valorInsert2FocusLost(java.awt.event.FocusEvent evt) {
        RegistrarUser.handleFocusGain(jTextField_valorInsert2, "Valor");
    }

    private void jTextField_valorUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        jTextField_where1.requestFocus();
    }

    private void jComboBox_tabla1ActionPerformed(java.awt.event.ActionEvent evt) {
        /* TODO buscar columnas de esta tabla */
    }

    private void jComboBox_tabla2ActionPerformed(java.awt.event.ActionEvent evt) {
        /* TODO buscar columnas de esta tabla */
    }

    /* métodos propios */
    public void setNombreBienvenida(String nombre) {
        this.nombreBienvenida.setText(nombre);
    }

    private void addFocusListenerCondicion(JTextField field) {
        field.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                RegistrarUser.handleFocusGain(field, "Condición o condiciones");
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                RegistrarUser.handleFocusGain(field, "Condición o condiciones");
            }
        });
    }

    private void addFocusListenerValor(JTextField field) {
        field.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                RegistrarUser.handleFocusGain(field, "Valor");
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                RegistrarUser.handleFocusGain(field, "Valor");
            }
        });
    }

    private void addFocusListeners() {
        addFocusListenerCondicion(jTextField_where);
        addFocusListenerCondicion(jTextField_order);
        addFocusListenerCondicion(jTextField_having);
        addFocusListenerCondicion(jTextField_group);
    }

    private void addFocusListenersValor(JTextField field) {
        addFocusListenerValor(field);
    }

    /* método para cambiar el tamaño del GridLayout en tiempo de ejecución */
    private void changeGridLayout(int rows, int cols) {
        GridLayout layout = (GridLayout) jPanel2.getLayout();
        layout.setRows(rows);
        layout.setColumns(cols);
    }

    /* método main para pruebas unitarias */
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PantallaAdmin().setVisible(true);
            }
        });
    }

    /* variables propias */
    private static CardLayout layout = null;
    private Component mostrando = null;
    private final JTableFiltrar jPanel_filtrar;
    private JPanelJoin join1;
    private JPanelJoin join2;
    private JPanelJoin join3;
    private JPanelJoin join4;
    private JPanelJoin join5;

    // Variables declaration - do not modify
    private javax.swing.JPanel background;
    private javax.swing.JButton button_logOut;
    private javax.swing.JButton button_modificarCred;
    private javax.swing.JButton button_modificarDatos;
    private javax.swing.JButton button_opcion1;
    private javax.swing.JButton button_opcion2;
    private javax.swing.JButton button_opcion5;
    private javax.swing.JButton button_opcion6;
    private javax.swing.JButton button_opcion7;
    private javax.swing.JButton button_preferencias;
    private javax.swing.JButton button_soporte;
    private javax.swing.JLabel cantColumn;
    private javax.swing.JLabel cantColumn1;
    private javax.swing.JLabel cantJoin;
    private javax.swing.JLabel delete;
    private javax.swing.JLabel from;
    private javax.swing.JLabel groupBy;
    private javax.swing.JLabel having;
    private javax.swing.JLabel icon_preferencias;
    private javax.swing.JLabel icon_project;
    private javax.swing.JLabel insert;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton_acercar;
    private javax.swing.JButton jButton_alejar;
    private javax.swing.JButton jButton_buscar;
    private javax.swing.JButton jButton_exportar;
    private javax.swing.JButton jButton_filtros;
    private javax.swing.JButton jButton_fuente;
    private javax.swing.JButton jButton_ordenar;
    private javax.swing.JButton jButton_savePreferences;
    private javax.swing.JButton jButton_select;
    private javax.swing.JComboBox<String> jComboBox_cantColumn1;
    private javax.swing.JComboBox<String> jComboBox_cantColumn2;
    private javax.swing.JComboBox<String> jComboBox_columna;
    private javax.swing.JComboBox<String> jComboBox_columna1;
    private javax.swing.JComboBox<String> jComboBox_columna2;
    private javax.swing.JComboBox<String> jComboBox_columna3;
    private javax.swing.JComboBox<String> jComboBox_exportarType;
    private javax.swing.JComboBox<String> jComboBox_exportarType1;
    private javax.swing.JComboBox<String> jComboBox_joins;
    private javax.swing.JComboBox<String> jComboBox_tabla;
    private javax.swing.JComboBox<String> jComboBox_tabla1;
    private javax.swing.JComboBox<String> jComboBox_tabla2;
    private javax.swing.JComboBox<String> jComboBox_tabla3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel_backup;
    private javax.swing.JPanel jPanel_derecho;
    private javax.swing.JPanel jPanel_fontChooser;
    private javax.swing.JPanel jPanel_insert_update_delete;
    private javax.swing.JPanel jPanel_menuOpciones;
    private javax.swing.JPanel jPanel_preferencias;
    private javax.swing.JPanel jPanel_select;
    private javax.swing.JPanel jPanel_separador1;
    private javax.swing.JPanel jPanel_separador2;
    private javax.swing.JPanel jPanel_separador3;
    private javax.swing.JPanel jPanel_separador4;
    private javax.swing.JPanel jPanel_separador5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane_Table;
    private javax.swing.JTable jTable_Content;
    private javax.swing.JTextField jTextField_buscarTabla;
    private javax.swing.JTextField jTextField_deleteComplejo;
    private javax.swing.JTextField jTextField_group;
    private javax.swing.JTextField jTextField_having;
    private javax.swing.JTextField jTextField_insertComplejo;
    private javax.swing.JTextField jTextField_order;
    private javax.swing.JTextField jTextField_selectComplejo;
    private javax.swing.JTextField jTextField_updateComplejo;
    private javax.swing.JTextField jTextField_valorInsert;
    private javax.swing.JTextField jTextField_valorInsert2;
    private javax.swing.JTextField jTextField_valorUpdate;
    private javax.swing.JTextField jTextField_where;
    private javax.swing.JTextField jTextField_where1;
    private javax.swing.JTextField jTextField_where2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JLabel nombreBienvenida;
    private javax.swing.JPanel opcionesTabla;
    private javax.swing.JLabel orderBy;
    private javax.swing.JLabel punto1;
    private javax.swing.JLabel punto2;
    private javax.swing.JLabel punto3;
    private javax.swing.JLabel punto4;
    private javax.swing.JTextArea resultadosActualizar;
    private javax.swing.JLabel rolName;
    private javax.swing.JLabel select;
    private javax.swing.JPanel separador;
    private javax.swing.JPanel separador1;
    private javax.swing.JPanel separador2;
    private javax.swing.JPanel separador3;
    private javax.swing.JPanel separador4;
    private javax.swing.JLabel set1;
    private javax.swing.JLabel titulo3;
    private javax.swing.JLabel titulo_contenido1;
    private javax.swing.JLabel titulo_contenido2;
    private javax.swing.JLabel update;
    private javax.swing.JLabel values;
    private javax.swing.JLabel where1;
    private javax.swing.JLabel where2;
    private javax.swing.JLabel where3;
    // End of variables declaration
}
