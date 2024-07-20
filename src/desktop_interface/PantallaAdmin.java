package desktop_interface;

import logic.conexions.DatabaseOperaciones;
import logic.conexions.Resultados;
import logic.scanner_database.DatabaseInfo;
import logic.user_management.InicioSesion;
import logic.user_management.Preferencias;
import logic.user_management.TokenMananger;
import logic.user_management.Usuario;
import logic.validations.*;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Timer;
import java.util.TimerTask;

public class PantallaAdmin extends JFrame {

    public PantallaAdmin(Usuario user) {
        initComponents();
        this.JOIN1 = new JPanelJoin();
        this.JOIN2 = new JPanelJoin();
        this.JOIN3 = new JPanelJoin();
        this.JOIN4 = new JPanelJoin();
        this.JOIN5 = new JPanelJoin();
        this.JPANEL_FILTRAR = new JTableFiltrar(jTable_Content);
        this.LAYOUT = (CardLayout) jPanel_derecho.getLayout();
        DB_ADMIN = new DatabaseOperaciones();
        addListeners();

        JOIN1.setTables(dbO);
        JOIN2.setTables(dbO);
        JOIN3.setTables(dbO);
        JOIN4.setTables(dbO);
        JOIN5.setTables(dbO);

        JButton[] botones = {button_opcion1, button_opcion2, button_opcion5, button_modificarDatos, button_modificarCred, button_preferencias, jButton_savePreferences, button_opcion6, button_opcion7};
        for (JButton boton : botones) {
            boton.setUI(new BasicButtonUI());
            boton.setBackground(new Color(86, 86, 86));
        }
        button_actualizar.setUI(new BasicButtonUI());
        jButton_logOut.setUI(new BasicButtonUI());

        personalizarVentana(user);
        this.requestFocusInWindow();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        jTextField_valorInsert2 = new JTextField();
        jPanel_select = new JPanel();
        jPanel2 = new JPanel();
        titulo_contenido1 = new JLabel();
        jPanel3 = new JPanel();
        select = new JLabel();
        jComboBox_columna_select = new JComboBox<>();
        jTextField_selectComplejo = new JTextField();
        jToggleButton_select = new JToggleButton();
        jPanel4 = new JPanel();
        from = new JLabel();
        jComboBox_tabla_select = new JComboBox<>();
        cantJoin = new JLabel();
        jComboBox_joins = new JComboBox<>();
        jPanel5 = new JPanel();
        where1 = new JLabel();
        jTextField_where_select = new JTextField();
        jPanel6 = new JPanel();
        orderBy = new JLabel();
        jTextField_order = new JTextField();
        jPanel7 = new JPanel();
        groupBy = new JLabel();
        jTextField_group = new JTextField();
        jPanel8 = new JPanel();
        having = new JLabel();
        jTextField_having = new JTextField();
        jButton_select = new JButton();
        jScrollPane_Table = new JScrollPane();
        jTable_Content = new JTable();
        opcionesTabla = new JPanel();
        jTextField_buscarTabla = new JTextField();
        jButton_buscar = new JButton();
        jButton_acercar = new JButton();
        jButton_alejar = new JButton();
        jButton_ordenar = new JButton();
        jButton_filtros = new JButton();
        jButton_fuente = new JButton();
        jButton_exportar = new JButton();
        jPanel_preferencias = new JPanel();
        icon_preferencias = new JLabel();
        titulo3 = new JLabel();
        jPanel_separador1 = new JPanel();
        jLabel4 = new JLabel();
        jPanel_separador2 = new JPanel();
        jPanel_fontChooser = new JPanel();
        jPanel_separador3 = new JPanel();
        jLabel1 = new JLabel();
        jPanel_separador4 = new JPanel();
        jLabel5 = new JLabel();
        jPanel_separador5 = new JPanel();
        jButton_savePreferences = new JButton();
        jPanel_insert_update_delete = new JPanel();
        jPanel9 = new JPanel();
        titulo_contenido2 = new JLabel();
        jPanel10 = new JPanel();
        update = new JLabel();
        jComboBox_tabla_update = new JComboBox<>();
        set1 = new JLabel();
        jComboBox_columna_update = new JComboBox<>();
        punto1 = new JLabel();
        jTextField_valorUpdate = new JTextField();
        cantColumn1 = new JLabel();
        jComboBox_cantColumn_update = new JComboBox<>();
        jTextField_updateComplejo = new JTextField();
        jToggleButton_update = new JToggleButton();
        jPanel11 = new JPanel();
        where2 = new JLabel();
        jTextField_where_update = new JTextField();
        jButton_update = new JButton();
        jPanel12 = new JPanel();
        insert = new JLabel();
        jComboBox_tabla_insert = new JComboBox<>();
        punto2 = new JLabel();
        jComboBox_columna_insert = new JComboBox<>();
        punto3 = new JLabel();
        values = new JLabel();
        punto4 = new JLabel();
        jTextField_valorInsert = new JTextField();
        cantColumn = new JLabel();
        jComboBox_cantColumn_insert = new JComboBox<>();
        jTextField_insertComplejo = new JTextField();
        jToggleButton_insert = new JToggleButton();
        jButton_insert = new JButton();
        jPanel13 = new JPanel();
        delete = new JLabel();
        jComboBox_tabla_delete = new JComboBox<>();
        jTextField_deleteComplejo = new JTextField();
        jToggleButton_delete = new JToggleButton();
        jPanel14 = new JPanel();
        where3 = new JLabel();
        jTextField_where_delete = new JTextField();
        jButton_delete = new JButton();
        separador = new JPanel();
        resultadosActualizar = new JTextArea();
        jPanel_backup = new JPanel();
        jPanel15 = new JPanel();
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
        button_opcion5 = new JButton();
        button_opcion6 = new JButton();
        button_opcion7 = new JButton();
        separador4 = new JPanel();
        button_modificarDatos = new JButton();
        button_modificarCred = new JButton();
        button_preferencias = new JButton();
        button_actualizar = new JButton();
        jButton_logOut = new JButton();
        jPanel_derecho = new JPanel();
        jPanel1 = new JPanel();
        jLabel6 = new JLabel();
        jDialog_modificarCred = new JDialog();
        jDialog_modificarDatos = new JDialog();
        jComboBox_exportarType_preferido = new JComboBox<String>();
        jComboBox_sede_preferida = new JComboBox<String>();
        background_dialog_modificarCred = new JPanel();
        background_dialog_modificarDatos = new JPanel();
        jScrollPane1_modificarDatos = new JScrollPane();
        jScrollPane2_modificarCred = new JScrollPane();
        jTextArea2_indicacionesModificarCred = new JTextArea();
        usuario = new JLabel();
        jTextField_usuarioNuevo = new JTextField();
        jTextField_usuario_Viejo = new JTextField();
        jSeparator4 = new JSeparator();
        jSeparator11 = new JSeparator();
        jSeparator2 = new JSeparator();
        jSeparator10 = new JSeparator();
        jSeparator5 = new JSeparator();
        usuario_nuevo = new JLabel();
        contrasena = new JLabel();
        repetir_contrasena = new JLabel();
        errorMessage2 = new JLabel();
        contrasena_anterior = new JLabel();
        jPasswordField_nueva1 = new JPasswordField();
        jPasswordField_nueva2 = new JPasswordField();
        jPasswordField_vieja = new JPasswordField();
        jButton_modificar2 = new JButton();
        jButton_cancelar2 = new JButton();
        titulo = new JLabel();
        jTextArea3_indicacionesModificarDatos = new JTextArea();
        nombre = new JLabel();
        apellido = new JLabel();
        cedula = new JLabel();
        fecha_nacimiento = new JLabel();
        sexo = new JLabel();
        direccion = new JLabel();
        distrito = new JLabel();
        correo = new JLabel();
        telefono = new JLabel();
        errorMessage = new JLabel();
        jButton_cancelar = new JButton();
        jButton_modificar = new JButton();
        jComboBox_sexo = new JComboBox<>();
        jComboBox_distrito = new JComboBox<>();
        jTextField_nombre = new JTextField();
        jTextField_apellido = new JTextField();
        jTextField_cedula = new JTextField();
        jTextField_fechaNacimiento = new JTextField();
        jTextField_direccion = new JTextField();
        jTextField_correo = new JTextField();
        jTextField_telefono = new JTextField();
        jSeparator6 = new JSeparator();
        jSeparator7 = new JSeparator();
        jSeparator8 = new JSeparator();
        jSeparator12 = new JSeparator();
        jSeparator1 = new JSeparator();
        jSeparator9 = new JSeparator();
        jSeparator3 = new JSeparator();

        jTextField_valorInsert2.setDocument(new LimitarCamposSQL(50, "Valor"));
        jTextField_valorInsert2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jTextField_valorInsert2.setText("Valor");

        jPanel_select.setBackground(new Color(227, 218, 201));
        jPanel_select.setForeground(new Color(227, 218, 201));
        jPanel_select.setPreferredSize(new Dimension(794, 794));
        jPanel_select.setLayout(new BoxLayout(jPanel_select, BoxLayout.Y_AXIS));

        jPanel2.setBackground(new Color(227, 218, 201));
        jPanel2.setMaximumSize(new Dimension(2147483647, 400));
        jPanel2.setPreferredSize(new Dimension(794, 360));
        jPanel2.setLayout(new GridLayout(8, 1));

        titulo_contenido1.setBackground(new Color(255, 255, 255));
        titulo_contenido1.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 14));
        titulo_contenido1.setHorizontalAlignment(SwingConstants.CENTER);
        titulo_contenido1.setText("Resultados Obtenidos");
        titulo_contenido1.setHorizontalTextPosition(SwingConstants.CENTER);
        titulo_contenido1.setMaximumSize(new Dimension(2147483647, 17));
        titulo_contenido1.setOpaque(true);
        titulo_contenido1.setPreferredSize(new Dimension(794, 17));
        jPanel2.add(titulo_contenido1);

        jPanel3.setBackground(new Color(227, 218, 201));
        jPanel3.setPreferredSize(new Dimension(794, 25));
        jPanel3.setLayout(new BoxLayout(jPanel3, BoxLayout.X_AXIS));

        select.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        select.setForeground(new Color(0, 0, 0));
        select.setHorizontalAlignment(SwingConstants.CENTER);
        select.setText("SELECT");
        select.setMaximumSize(new Dimension(60, 33));
        select.setPreferredSize(new Dimension(50, 33));
        jPanel3.add(select);

        jComboBox_columna_select.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jComboBox_columna_select.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir", "*"}));
        jComboBox_columna_select.setPreferredSize(new Dimension(150, 27));
        jPanel3.add(jComboBox_columna_select);

        jTextField_selectComplejo.setDocument(new LimitarCamposSQL(200, "Campos y/o función"));
        jTextField_selectComplejo.setText("Campos y/o función");
        jTextField_selectComplejo.setVisible(false);
        RegistrarUser.handleFocusGain(jTextField_selectComplejo, "Campos y/o función");
        jPanel3.add(jTextField_selectComplejo);

        jToggleButton_select.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jToggleButton_select.setText("¿Complejo?");
        jToggleButton_select.addActionListener(this::jToggleButton_selectActionPerformed);
        jPanel3.add(jToggleButton_select);

        jPanel2.add(jPanel3);

        jPanel4.setBackground(new Color(227, 218, 201));
        jPanel4.setMaximumSize(new Dimension(2147483647, 2147483647));
        jPanel4.setPreferredSize(new Dimension(794, 25));
        jPanel4.setLayout(new BoxLayout(jPanel4, BoxLayout.X_AXIS));

        from.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        from.setForeground(new Color(0, 0, 0));
        from.setHorizontalAlignment(SwingConstants.CENTER);
        from.setText("FROM");
        from.setMaximumSize(new Dimension(50, 33));
        from.setPreferredSize(new Dimension(50, 33));
        jPanel4.add(from);

        jComboBox_tabla_select.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jComboBox_tabla_select.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir Tabla"}));
        jComboBox_tabla_select.setMaximumSize(new Dimension(367, 32767));
        jComboBox_tabla_select.setPreferredSize(new Dimension(150, 27));
        jComboBox_tabla_select.addActionListener(this::jComboBox_tabla_selectActionPerfomed);
        jPanel4.add(jComboBox_tabla_select);

        cantJoin.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        cantJoin.setForeground(new Color(0, 0, 0));
        cantJoin.setHorizontalAlignment(SwingConstants.CENTER);
        cantJoin.setText("Cantidad de joins");
        cantJoin.setMaximumSize(new Dimension(110, 33));
        cantJoin.setPreferredSize(new Dimension(105, 33));
        jPanel4.add(cantJoin);

        jComboBox_joins.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jComboBox_joins.setModel(new DefaultComboBoxModel<>(new String[]{"0", "1", "2", "3", "4", "5"}));
        jComboBox_joins.setMaximumSize(new Dimension(80, 32767));
        jComboBox_joins.setPreferredSize(new Dimension(80, 27));
        jComboBox_joins.addActionListener(this::jComboBox_joinsActionPerformed);
        jPanel4.add(jComboBox_joins);

        jPanel2.add(jPanel4);

        jPanel5.setBackground(new Color(227, 218, 201));
        jPanel5.setPreferredSize(new Dimension(794, 25));
        jPanel5.setLayout(new BoxLayout(jPanel5, BoxLayout.X_AXIS));

        where1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        where1.setForeground(new Color(0, 0, 0));
        where1.setHorizontalAlignment(SwingConstants.CENTER);
        where1.setText("WHERE");
        where1.setMaximumSize(new Dimension(60, 33));
        where1.setPreferredSize(new Dimension(50, 33));
        jPanel5.add(where1);

        jTextField_where_select.setDocument(new LimitarCamposSQL(100, "Condición o condiciones"));
        jTextField_where_select.setText("Condición o condiciones");
        RegistrarUser.handleFocusGain(jTextField_where_select, "Condición o condiciones");
        jPanel5.add(jTextField_where_select);

        jPanel2.add(jPanel5);

        jPanel6.setBackground(new Color(227, 218, 201));
        jPanel6.setPreferredSize(new Dimension(794, 25));
        jPanel6.setLayout(new BoxLayout(jPanel6, BoxLayout.X_AXIS));

        orderBy.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        orderBy.setForeground(new Color(0, 0, 0));
        orderBy.setHorizontalAlignment(SwingConstants.CENTER);
        orderBy.setText("ORDER BY ");
        orderBy.setMaximumSize(new Dimension(90, 33));
        orderBy.setPreferredSize(new Dimension(75, 33));
        jPanel6.add(orderBy);

        jTextField_order.setDocument(new LimitarCamposSQL(50, "Condición o condiciones"));
        jTextField_order.setText("Condición o condiciones");
        RegistrarUser.handleFocusGain(jTextField_order, "Condición o condiciones");
        jPanel6.add(jTextField_order);

        jPanel2.add(jPanel6);

        jPanel7.setBackground(new Color(227, 218, 201));
        jPanel7.setPreferredSize(new Dimension(794, 25));
        jPanel7.setLayout(new BoxLayout(jPanel7, BoxLayout.X_AXIS));

        groupBy.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        groupBy.setForeground(new Color(0, 0, 0));
        groupBy.setHorizontalAlignment(SwingConstants.CENTER);
        groupBy.setText("GROUP BY");
        groupBy.setMaximumSize(new Dimension(90, 33));
        groupBy.setPreferredSize(new Dimension(75, 33));
        jPanel7.add(groupBy);

        jTextField_group.setDocument(new LimitarCamposSQL(50, "Condición o condiciones"));
        jTextField_group.setText("Condición o condiciones");
        RegistrarUser.handleFocusGain(jTextField_group, "Condición o condiciones");
        jPanel7.add(jTextField_group);

        jPanel2.add(jPanel7);

        jPanel8.setBackground(new Color(227, 218, 201));
        jPanel8.setPreferredSize(new Dimension(794, 25));
        jPanel8.setLayout(new BoxLayout(jPanel8, BoxLayout.X_AXIS));

        having.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        having.setForeground(new Color(0, 0, 0));
        having.setHorizontalAlignment(SwingConstants.CENTER);
        having.setText("HAVING");
        having.setMaximumSize(new Dimension(75, 33));
        having.setPreferredSize(new Dimension(65, 33));
        jPanel8.add(having);

        jTextField_having.setDocument(new LimitarCamposSQL(50, "Condición o condiciones"));
        jTextField_having.setText("Condición o condiciones");
        RegistrarUser.handleFocusGain(jTextField_having, "Condición o condiciones");
        jTextField_having.addActionListener(this::jTextField_havingActionPerformed);
        jPanel8.add(jTextField_having);

        jPanel2.add(jPanel8);

        jButton_select.setBackground(new Color(0, 204, 0));
        jButton_select.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
        jButton_select.setForeground(new Color(0, 0, 0));
        jButton_select.setIcon(new ImageIcon(getClass().getResource("/images/lupa_icon.png")));
        jButton_select.setText("Buscar");
        jButton_select.setMaximumSize(new Dimension(2147483647, 30));
        jButton_select.setPreferredSize(new Dimension(794, 30));
        jButton_select.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_selectMouseClicked(evt);
            }
        });
        jPanel2.add(jButton_select);

        jPanel_select.add(jPanel2);

        jScrollPane_Table.setBackground(new Color(227, 218, 201));
        jScrollPane_Table.setForeground(new Color(227, 218, 201));
        jScrollPane_Table.setOpaque(true);
        jScrollPane_Table.setPreferredSize(new Dimension(794, 694));
        jScrollPane_Table.setViewportView(null);

        jTable_Content.setBackground(new Color(227, 218, 201));
        jTable_Content.setFont(new Font("Roboto", Font.PLAIN, 12));
        jTable_Content.setForeground(new Color(0, 0, 0));
        jTable_Content.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        jTable_Content.setMinimumSize(new Dimension(50, 50));
        jTable_Content.setPreferredSize(new Dimension(788, 383));
        jTable_Content.setShowGrid(true);
        jScrollPane_Table.setViewportView(jTable_Content);
        jTable_Content.getAccessibleContext().setAccessibleName("tabla de resultados");

        jPanel_select.add(jScrollPane_Table);

        opcionesTabla.setBackground(new Color(0, 153, 204));
        opcionesTabla.setMaximumSize(new Dimension(32767, 100));
        opcionesTabla.setMinimumSize(new Dimension(780, 44));
        opcionesTabla.setPreferredSize(new Dimension(794, 45));
        opcionesTabla.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        jTextField_buscarTabla.setDocument(new LimitarCamposSeguro(25, "Buscar...")
        );
        jTextField_buscarTabla.setText("Buscar...");
        jTextField_buscarTabla.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jTextField_buscarTabla.setPreferredSize(new Dimension(125, 26));
        jTextField_buscarTabla.addActionListener(this::jTextField_buscarTablaActionPerformed);
        opcionesTabla.add(jTextField_buscarTabla);

        jButton_buscar.setBackground(new Color(204, 204, 204));
        jButton_buscar.setIcon(new ImageIcon(getClass().getResource("/images/lupa_icon.png")));
        jButton_buscar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_buscarMouseClicked(evt);
            }
        });
        opcionesTabla.add(jButton_buscar);

        jButton_acercar.setText("Acercar");
        jButton_acercar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_acercarMouseClicked(evt);
            }
        });
        opcionesTabla.add(jButton_acercar);

        jButton_alejar.setText("Alejar");
        jButton_alejar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_alejarMouseClicked(evt);
            }
        });
        opcionesTabla.add(jButton_alejar);

        jButton_ordenar.setText("Ordenar");
        jButton_ordenar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_ordenarMouseClicked(evt);
            }
        });
        opcionesTabla.add(jButton_ordenar);

        jButton_filtros.setText("Filtros");
        jButton_filtros.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_filtrosMouseClicked(evt);
            }
        });
        opcionesTabla.add(jButton_filtros);

        jButton_fuente.setText("Fuente y tamaño");
        jButton_fuente.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_fuenteMouseClicked(evt);
            }
        });
        opcionesTabla.add(jButton_fuente);

        jButton_exportar.setText("Exportar tabla");
        jButton_exportar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_exportarMouseClicked(evt);
            }
        });
        opcionesTabla.add(jButton_exportar);

        jPanel_select.add(opcionesTabla);

        jPanel_preferencias.setBackground(new Color(227, 218, 201));
        jPanel_preferencias.setPreferredSize(new Dimension(794, 794));
        jPanel_preferencias.setLayout(new BoxLayout(jPanel_preferencias, BoxLayout.Y_AXIS));

        icon_preferencias.setIcon(new ImageIcon(getClass().getResource("/images/ajuetes3.png")));
        icon_preferencias.setHorizontalTextPosition(SwingConstants.CENTER);
        icon_preferencias.setPreferredSize(new Dimension(130, 120));
        jPanel_preferencias.add(icon_preferencias);

        titulo.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));
        titulo.setForeground(new Color(0, 0, 0));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setText("Preferencias");
        titulo.setHorizontalTextPosition(SwingConstants.CENTER);
        jPanel_preferencias.add(titulo);

        jPanel_separador1.setBackground(new Color(227, 218, 201));
        jPanel_separador1.setMaximumSize(new Dimension(32767, 25));

        GroupLayout jPanel_separador1Layout = new GroupLayout(jPanel_separador1);
        jPanel_separador1.setLayout(jPanel_separador1Layout);
        jPanel_separador1Layout.setHorizontalGroup(
                jPanel_separador1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 977, Short.MAX_VALUE)
        );
        jPanel_separador1Layout.setVerticalGroup(
                jPanel_separador1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel_preferencias.add(jPanel_separador1);

        jLabel4.setFont(new Font("Roboto", Font.PLAIN, 14));
        jLabel4.setForeground(new Color(0, 0, 0));
        jLabel4.setText("Tamaño y Fuente preferida");
        jLabel4.setHorizontalTextPosition(SwingConstants.CENTER);
        jPanel_preferencias.add(jLabel4);

        jPanel_separador2.setBackground(new Color(227, 218, 201));
        jPanel_separador2.setMaximumSize(new Dimension(32767, 15));

        GroupLayout jPanel_separador2Layout = new GroupLayout(jPanel_separador2);
        jPanel_separador2.setLayout(jPanel_separador2Layout);
        jPanel_separador2Layout.setHorizontalGroup(
                jPanel_separador2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 977, Short.MAX_VALUE)
        );
        jPanel_separador2Layout.setVerticalGroup(
                jPanel_separador2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 15, Short.MAX_VALUE)
        );

        jPanel_preferencias.add(jPanel_separador2);

        jPanel_fontChooser.setBackground(new Color(227, 218, 201));
        jPanel_fontChooser.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel_fontChooser.setMaximumSize(new Dimension(700, 250));
        jPanel_fontChooser.setPreferredSize(new Dimension(460, 250));
        jPanel_fontChooser.setLayout(new GridLayout(3, 2, 10, 10));
        jPanel_preferencias.add(jPanel_fontChooser);
        // Familia de la fuente
        JLabel familyLabel = new JLabel("Familia:");
        familyLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
        familyComboBox = new JComboBox<>(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
        familyComboBox.setFont(new Font("Roboto", Font.PLAIN, 14));
        jPanel_fontChooser.add(familyLabel);
        jPanel_fontChooser.add(familyComboBox);

        // Estilo de la fuente
        JLabel styleLabel = new JLabel("Estilo:");
        styleLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
        styleComboBox = new JComboBox<>(new String[]{"Regular", "Negrita", "Cursiva", "Negrita Cursiva"});
        styleComboBox.setFont(new Font("Roboto", Font.PLAIN, 14));
        jPanel_fontChooser.add(styleLabel);
        jPanel_fontChooser.add(styleComboBox);

        // Tamaño de la fuente
        JLabel sizeLabel = new JLabel("Tamaño:");
        sizeLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
        fontSizeSpinner = new JSpinner(new SpinnerNumberModel(12, 1, 100, 1));
        fontSizeSpinner.setFont(new Font("Roboto", Font.PLAIN, 14));
        jPanel_fontChooser.add(sizeLabel);
        jPanel_fontChooser.add(fontSizeSpinner);

        jPanel_separador3.setBackground(new Color(227, 218, 201));
        jPanel_separador3.setMaximumSize(new Dimension(32767, 25));

        GroupLayout jPanel_separador3Layout = new GroupLayout(jPanel_separador3);
        jPanel_separador3.setLayout(jPanel_separador3Layout);
        jPanel_separador3Layout.setHorizontalGroup(
                jPanel_separador3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 977, Short.MAX_VALUE)
        );
        jPanel_separador3Layout.setVerticalGroup(
                jPanel_separador3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel_preferencias.add(jPanel_separador3);

        jLabel1.setFont(new Font("Roboto", Font.PLAIN, 14));
        jLabel1.setForeground(new Color(0, 0, 0));
        jLabel1.setText("Tipo de archivo exportar preferido");
        jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
        jPanel_preferencias.add(jLabel1);

        jComboBox_exportarType_preferido.setFont(new Font("Roboto", Font.PLAIN, 14));
        jComboBox_exportarType_preferido.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir...", "CSV", "TXT", "PDF", "Excel"}));
        jComboBox_exportarType_preferido.setMaximumSize(new Dimension(367, 40));
        jComboBox_exportarType_preferido.setPreferredSize(new Dimension(190, 37));
        jPanel_preferencias.add(jComboBox_exportarType_preferido);

        jPanel_separador4.setBackground(new Color(227, 218, 201));
        jPanel_separador4.setMaximumSize(new Dimension(32767, 25));

        GroupLayout jPanel_separador4Layout = new GroupLayout(jPanel_separador4);
        jPanel_separador4.setLayout(jPanel_separador4Layout);
        jPanel_separador4Layout.setHorizontalGroup(
                jPanel_separador4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 977, Short.MAX_VALUE)
        );
        jPanel_separador4Layout.setVerticalGroup(
                jPanel_separador4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel_preferencias.add(jPanel_separador4);

        jLabel5.setFont(new Font("Roboto", Font.PLAIN, 14));
        jLabel5.setForeground(new Color(0, 0, 0));
        jLabel5.setText("Sede de salud preferida");
        jLabel5.setHorizontalTextPosition(SwingConstants.CENTER);
        jPanel_preferencias.add(jLabel5);

        jComboBox_sede_preferida.setFont(new Font("Roboto", Font.PLAIN, 14));
        jComboBox_sede_preferida.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir..."}));
        jComboBox_sede_preferida.setMaximumSize(new Dimension(567, 40));
        jComboBox_sede_preferida.setPreferredSize(new Dimension(450, 37));
        jPanel_preferencias.add(jComboBox_sede_preferida);

        jPanel_separador5.setBackground(new Color(227, 218, 201));
        jPanel_separador5.setMaximumSize(new Dimension(32767, 25));

        GroupLayout jPanel_separador5Layout = new GroupLayout(jPanel_separador5);
        jPanel_separador5.setLayout(jPanel_separador5Layout);
        jPanel_separador5Layout.setHorizontalGroup(
                jPanel_separador5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 977, Short.MAX_VALUE)
        );
        jPanel_separador5Layout.setVerticalGroup(
                jPanel_separador5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel_preferencias.add(jPanel_separador5);

        jButton_savePreferences.setFont(new Font("Roboto", Font.PLAIN, 14));
        jButton_savePreferences.setForeground(new Color(255, 255, 255));
        jButton_savePreferences.setText("Guardar preferencias");
        jButton_savePreferences.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton_savePreferences.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton_savePreferences.setMaximumSize(new Dimension(166, 48));
        jButton_savePreferences.setPreferredSize(new Dimension(166, 48));
        jButton_savePreferences.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_savePreferencesMouseClicked(evt);
            }
        });
        jPanel_preferencias.add(jButton_savePreferences);

        jDialog_modificarDatos.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jDialog_modificarDatos.setTitle("Programa Vacunas Panamá - Modificar datos personales");
        jDialog_modificarDatos.setModal(true);
        jDialog_modificarDatos.setResizable(false);
        jDialog_modificarDatos.setIconImage(new ImageIcon(getClass().getResource("/images/Icon1.png")).getImage());
        jDialog_modificarDatos.setSize(new Dimension(450, 600));

        jScrollPane1_modificarDatos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        background_dialog_modificarDatos.setBackground(new Color(255, 255, 255));
        background_dialog_modificarDatos.setPreferredSize(new Dimension(444, 544));
        background_dialog_modificarDatos.setLayout(new AbsoluteLayout());

        titulo.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
        titulo.setForeground(new Color(0, 0, 0));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setText("Modificar datos personales");
        background_dialog_modificarDatos.add(titulo, new AbsoluteConstraints(90, 20, 269, -1));

        jTextArea3_indicacionesModificarDatos.setEditable(false);
        jTextArea3_indicacionesModificarDatos.setBackground(new Color(255, 255, 255));
        jTextArea3_indicacionesModificarDatos.setFont(new Font("Microsoft YaHei", Font.ITALIC, 11));
        jTextArea3_indicacionesModificarDatos.setForeground(new Color(102, 102, 102));
        jTextArea3_indicacionesModificarDatos.setLineWrap(true);
        jTextArea3_indicacionesModificarDatos.setText("Indicaciones: Si no desea modificar todo, puede dejarlo en blanco o como esta. Si su cédula o fecha de nacimiento esta errónea, solicita ayuda a su doctor.\n\n");
        jTextArea3_indicacionesModificarDatos.setWrapStyleWord(true);
        jTextArea3_indicacionesModificarDatos.setBorder(null);
        jTextArea3_indicacionesModificarDatos.setFocusable(false);
        jTextArea3_indicacionesModificarDatos.setRequestFocusEnabled(false);
        background_dialog_modificarDatos.add(jTextArea3_indicacionesModificarDatos, new AbsoluteConstraints(30, 40, 390, 50));

        nombre.setBackground(new Color(0, 0, 0));
        nombre.setFont(new Font("Roboto", Font.PLAIN, 12));
        nombre.setForeground(new Color(0, 0, 0));
        nombre.setText("Nombre *");
        background_dialog_modificarDatos.add(nombre, new AbsoluteConstraints(30, 90, -1, -1));

        jTextField_nombre.setBackground(new Color(255, 255, 255));
        jTextField_nombre.setDocument(new LimitarCamposString(50, "Ingrese su nombre"));
        jTextField_nombre.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_nombre.setForeground(Color.gray);
        jTextField_nombre.setText("Ingrese su nombre");
        jTextField_nombre.setBorder(null);
        jTextField_nombre.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_nombre, "Ingrese su nombre");
        background_dialog_modificarDatos.add(jTextField_nombre, new AbsoluteConstraints(30, 110, 390, -1));

        jSeparator6.setForeground(new Color(30, 30, 30));
        background_dialog_modificarDatos.add(jSeparator6, new AbsoluteConstraints(30, 130, 390, 21));

        apellido.setBackground(new Color(0, 0, 0));
        apellido.setFont(new Font("Roboto", Font.PLAIN, 12));
        apellido.setForeground(new Color(0, 0, 0));
        apellido.setText("Apellido *");
        background_dialog_modificarDatos.add(apellido, new AbsoluteConstraints(30, 140, -1, -1));

        jTextField_apellido.setBackground(new Color(255, 255, 255));
        jTextField_apellido.setDocument(new LimitarCamposString(50, "Ingrese su apellido"));
        jTextField_apellido.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_apellido.setForeground(Color.gray);
        jTextField_apellido.setText("Ingrese su apellido");
        jTextField_apellido.setBorder(null);
        jTextField_apellido.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_apellido, "Ingrese su apellido");
        background_dialog_modificarDatos.add(jTextField_apellido, new AbsoluteConstraints(30, 160, 390, -1));

        jSeparator7.setForeground(new Color(30, 30, 30));
        background_dialog_modificarDatos.add(jSeparator7, new AbsoluteConstraints(30, 180, 390, 21));

        cedula.setBackground(new Color(0, 0, 0));
        cedula.setFont(new Font("Roboto", Font.PLAIN, 12));
        cedula.setForeground(new Color(0, 0, 0));
        cedula.setText("Cédula *");
        background_dialog_modificarDatos.add(cedula, new AbsoluteConstraints(30, 190, -1, -1));

        jTextField_cedula.setBackground(new Color(255, 255, 255));
        jTextField_cedula.setDocument(new LimitarCamposCedula(15, "Ingrese su cédula"));
        jTextField_cedula.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_cedula.setForeground(Color.gray);
        jTextField_cedula.setText("Ingrese su cédula");
        jTextField_cedula.setBorder(null);
        jTextField_cedula.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_cedula, "Ingrese su cédula");
        background_dialog_modificarDatos.add(jTextField_cedula, new AbsoluteConstraints(30, 210, 390, -1));

        jSeparator8.setForeground(new Color(30, 30, 30));
        background_dialog_modificarDatos.add(jSeparator8, new AbsoluteConstraints(30, 230, 390, 21));

        fecha_nacimiento.setBackground(new Color(0, 0, 0));
        fecha_nacimiento.setFont(new Font("Roboto", Font.PLAIN, 12));
        fecha_nacimiento.setForeground(new Color(0, 0, 0));
        fecha_nacimiento.setText("Fecha de nacimiento *");
        background_dialog_modificarDatos.add(fecha_nacimiento, new AbsoluteConstraints(30, 240, -1, -1));

        jTextField_fechaNacimiento.setBackground(new Color(255, 255, 255));
        jTextField_fechaNacimiento.setDocument(new LimitarCamposFecha(30, "Ingrese su fecha de nacimiento YYYY-MM-DD* hh:mm:ss"));
        jTextField_fechaNacimiento.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_fechaNacimiento.setForeground(Color.gray);
        jTextField_fechaNacimiento.setText("Ingrese su fecha de nacimiento YYYY-MM-DD* hh:mm:ss");
        jTextField_fechaNacimiento.setBorder(null);
        jTextField_fechaNacimiento.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_fechaNacimiento, "Ingrese su fecha de nacimiento YYYY-MM-DD* hh:mm:ss");
        background_dialog_modificarDatos.add(jTextField_fechaNacimiento, new AbsoluteConstraints(30, 260, 390, -1));

        jSeparator12.setForeground(new Color(30, 30, 30));
        background_dialog_modificarDatos.add(jSeparator12, new AbsoluteConstraints(30, 280, 390, 21));

        sexo.setBackground(new Color(0, 0, 0));
        sexo.setFont(new Font("Roboto", Font.PLAIN, 12));
        sexo.setForeground(new Color(0, 0, 0));
        sexo.setText("Sexo *");
        background_dialog_modificarDatos.add(sexo, new AbsoluteConstraints(30, 290, -1, -1));

        jComboBox_sexo.setBackground(Color.gray);
        jComboBox_sexo.setFont(new Font("Roboto", Font.PLAIN, 14));
        jComboBox_sexo.setForeground(Color.black);
        jComboBox_sexo.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir", "Masculino", "Feminino"}));
        background_dialog_modificarDatos.add(jComboBox_sexo, new AbsoluteConstraints(30, 308, 170, -1));

        direccion.setBackground(new Color(0, 0, 0));
        direccion.setFont(new Font("Roboto", Font.PLAIN, 12));
        direccion.setForeground(new Color(0, 0, 0));
        direccion.setText("Dirección");
        background_dialog_modificarDatos.add(direccion, new AbsoluteConstraints(30, 340, -1, -1));

        jTextField_direccion.setBackground(new Color(255, 255, 255));
        jTextField_direccion.setDocument(new LimitarCamposAlpha(100, "Ingrese su dirección"));
        jTextField_direccion.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_direccion.setForeground(Color.gray);
        jTextField_direccion.setText("Ingrese su dirección");
        jTextField_direccion.setBorder(null);
        jTextField_direccion.setMaximumSize(new Dimension(2147483647, 50));
        jTextField_direccion.addActionListener(this::jTextField_direccionActionPerformed);
        background_dialog_modificarDatos.add(jTextField_direccion, new AbsoluteConstraints(30, 360, 190, -1));

        distrito.setBackground(new Color(0, 0, 0));
        distrito.setFont(new Font("Roboto", Font.PLAIN, 12));
        distrito.setForeground(new Color(0, 0, 0));
        distrito.setText("Distrito");
        background_dialog_modificarDatos.add(distrito, new AbsoluteConstraints(230, 340, 50, -1));

        jComboBox_distrito.setBackground(Color.gray);
        jComboBox_distrito.setFont(new Font("Roboto", Font.PLAIN, 14));
        jComboBox_distrito.setForeground(Color.black);
        jComboBox_distrito.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir", "Distrito por registrar"}));
        background_dialog_modificarDatos.add(jComboBox_distrito, new AbsoluteConstraints(230, 356, 190, -1));

        jSeparator1.setForeground(new Color(30, 30, 30));
        background_dialog_modificarDatos.add(jSeparator1, new AbsoluteConstraints(30, 380, 190, 21));

        correo.setBackground(new Color(0, 0, 0));
        correo.setFont(new Font("Roboto", Font.PLAIN, 12));
        correo.setForeground(new Color(0, 0, 0));
        correo.setText("Correo electrónico");
        background_dialog_modificarDatos.add(correo, new AbsoluteConstraints(30, 390, -1, -1));

        jTextField_correo.setBackground(new Color(255, 255, 255));
        jTextField_correo.setDocument(new LimitarCamposEmail(50, "Ingrese su correo electrónico"));
        jTextField_correo.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_correo.setForeground(Color.gray);
        jTextField_correo.setText("Ingrese su correo electrónico");
        jTextField_correo.setBorder(null);
        jTextField_correo.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_correo, "Ingrese su correo electrónico");
        background_dialog_modificarDatos.add(jTextField_correo, new AbsoluteConstraints(30, 410, 390, -1));

        jSeparator9.setForeground(new Color(30, 30, 30));
        background_dialog_modificarDatos.add(jSeparator9, new AbsoluteConstraints(30, 430, 390, 21));

        jTextField_telefono.setBackground(new Color(255, 255, 255));
        jTextField_telefono.setDocument(new LimitarCamposPhone(15, "Ingrese el código de país, el código de ciudad y el número local"));
        jTextField_telefono.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_telefono.setForeground(Color.gray);
        jTextField_telefono.setText("Ingrese el código de país, el código de ciudad y el número local");
        jTextField_telefono.setBorder(null);
        jTextField_telefono.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_telefono, "Ingrese el código de país, el código de ciudad y el número local");
        jTextField_telefono.addActionListener(this::jTextField_telefonoActionPerformed);
        background_dialog_modificarDatos.add(jTextField_telefono, new AbsoluteConstraints(30, 460, 390, -1));

        telefono.setBackground(new Color(0, 0, 0));
        telefono.setFont(new Font("Roboto", Font.PLAIN, 12));
        telefono.setForeground(new Color(0, 0, 0));
        telefono.setText("Teléfono ");
        background_dialog_modificarDatos.add(telefono, new AbsoluteConstraints(30, 440, -1, -1));

        jSeparator3.setForeground(new Color(30, 30, 30));
        background_dialog_modificarDatos.add(jSeparator3, new AbsoluteConstraints(30, 480, 390, 21));

        errorMessage.setFont(new Font("Roboto", Font.BOLD, 14));
        errorMessage.setForeground(Color.red);
        errorMessage.setHorizontalAlignment(SwingConstants.CENTER);
        errorMessage.setText("ERROR.");
        errorMessage.setVisible(false);
        background_dialog_modificarDatos.add(errorMessage, new AbsoluteConstraints(30, 490, 390, -1));

        jButton_cancelar.setBackground(new Color(153, 153, 153));
        jButton_cancelar.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jButton_cancelar.setForeground(new Color(0, 0, 0));
        jButton_cancelar.setText("Cancelar");
        jButton_cancelar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_cancelarMouseClicked(evt);
            }
        });
        background_dialog_modificarDatos.add(jButton_cancelar, new AbsoluteConstraints(240, 510, -1, -1));

        jButton_modificar.setBackground(new Color(0, 204, 0));
        jButton_modificar.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jButton_modificar.setForeground(new Color(0, 0, 0));
        jButton_modificar.setText("Modificar");
        jButton_modificar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_modificarMouseClicked(evt);
            }
        });
        background_dialog_modificarDatos.add(jButton_modificar, new AbsoluteConstraints(330, 510, -1, -1));

        jScrollPane1_modificarDatos.setViewportView(background_dialog_modificarDatos);

        GroupLayout jDialog_modificarDatosLayout = new GroupLayout(jDialog_modificarDatos.getContentPane());
        jDialog_modificarDatos.getContentPane().setLayout(jDialog_modificarDatosLayout);
        jDialog_modificarDatosLayout.setHorizontalGroup(
                jDialog_modificarDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jDialog_modificarDatosLayout.createSequentialGroup()
                                .addComponent(jScrollPane1_modificarDatos)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDialog_modificarDatosLayout.setVerticalGroup(
                jDialog_modificarDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1_modificarDatos)
        );

        jDialog_modificarCred.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jDialog_modificarCred.setTitle("Programa Vacunas Panamá - Modificar credenciales");
        jDialog_modificarCred.setModal(true);
        jDialog_modificarCred.setResizable(false);
        jDialog_modificarCred.setIconImage(new ImageIcon(getClass().getResource("/images/Icon1.png")).getImage());
        jDialog_modificarCred.setSize(new Dimension(450, 550));

        jScrollPane2_modificarCred.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        background_dialog_modificarCred.setBackground(new Color(255, 255, 255));
        background_dialog_modificarCred.setPreferredSize(new Dimension(444, 494));
        background_dialog_modificarCred.setLayout(new AbsoluteLayout());

        titulo3.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
        titulo3.setForeground(new Color(0, 0, 0));
        titulo3.setHorizontalAlignment(SwingConstants.CENTER);
        titulo3.setText("Modificar credenciales de acceso");
        background_dialog_modificarCred.add(titulo3, new AbsoluteConstraints(88, 25, 269, -1));

        jTextArea2_indicacionesModificarCred.setEditable(false);
        jTextArea2_indicacionesModificarCred.setBackground(new Color(255, 255, 255));
        jTextArea2_indicacionesModificarCred.setFont(new Font("Microsoft YaHei", Font.ITALIC, 11));
        jTextArea2_indicacionesModificarCred.setForeground(new Color(102, 102, 102));
        jTextArea2_indicacionesModificarCred.setLineWrap(true);
        jTextArea2_indicacionesModificarCred.setText("Indicaciones: Para modificar las credenciales debe ingresar su usuario y contraseña anterior, si solo desea cambiar el usuario debe dejar en blanco los campos de nueva contraseña.\nDebe repetir la contraseña nueva si desea modificarla, sino no se cambiará la misma.\nSi desea modificar otro dato personal, utilice el otro botón.");
        jTextArea2_indicacionesModificarCred.setWrapStyleWord(true);
        jTextArea2_indicacionesModificarCred.setBorder(null);
        jTextArea2_indicacionesModificarCred.setFocusable(false);
        jTextArea2_indicacionesModificarCred.setRequestFocusEnabled(false);
        background_dialog_modificarCred.add(jTextArea2_indicacionesModificarCred, new AbsoluteConstraints(30, 60, 380, 100));

        usuario.setBackground(new Color(0, 0, 0));
        usuario.setFont(new Font("Roboto", Font.PLAIN, 12));
        usuario.setForeground(new Color(0, 0, 0));
        usuario.setText("Usuario anterior *");
        background_dialog_modificarCred.add(usuario, new AbsoluteConstraints(30, 170, -1, -1));

        jTextField_usuario_Viejo.setBackground(new Color(255, 255, 255));
        jTextField_usuario_Viejo.setDocument(new LimitarCamposSeguro(50, "Ingrese su usuario"));
        jTextField_usuario_Viejo.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_usuario_Viejo.setForeground(Color.gray);
        jTextField_usuario_Viejo.setText("Ingrese su usuario");
        jTextField_usuario_Viejo.setActionCommand("<Not Set>");
        jTextField_usuario_Viejo.setBorder(null);
        jTextField_usuario_Viejo.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_usuario_Viejo, "Ingrese su usuario");
        background_dialog_modificarCred.add(jTextField_usuario_Viejo, new AbsoluteConstraints(30, 190, 380, -1));

        jSeparator11.setForeground(new Color(30, 30, 30));
        background_dialog_modificarCred.add(jSeparator11, new AbsoluteConstraints(30, 210, 380, 21));

        usuario_nuevo.setBackground(new Color(0, 0, 0));
        usuario_nuevo.setFont(new Font("Roboto", Font.PLAIN, 12));
        usuario_nuevo.setForeground(new Color(0, 0, 0));
        usuario_nuevo.setText("Usuario nuevo");
        background_dialog_modificarCred.add(usuario_nuevo, new AbsoluteConstraints(30, 220, -1, -1));

        jTextField_usuarioNuevo.setBackground(new Color(255, 255, 255));
        jTextField_usuarioNuevo.setDocument(new LimitarCamposSeguro(50, "Ingrese un usuario nuevo"));
        jTextField_usuarioNuevo.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_usuarioNuevo.setForeground(Color.gray);
        jTextField_usuarioNuevo.setText("Ingrese un usuario nuevo");
        jTextField_usuarioNuevo.setActionCommand("<Not Set>");
        jTextField_usuarioNuevo.setBorder(null);
        jTextField_usuarioNuevo.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jTextField_usuarioNuevo, "Ingrese un usuario nuevo");
        background_dialog_modificarCred.add(jTextField_usuarioNuevo, new AbsoluteConstraints(30, 240, 380, -1));

        jSeparator4.setForeground(new Color(30, 30, 30));
        background_dialog_modificarCred.add(jSeparator4, new AbsoluteConstraints(30, 260, 380, 21));

        contrasena.setBackground(new Color(0, 0, 0));
        contrasena.setFont(new Font("Roboto", Font.PLAIN, 12));
        contrasena.setForeground(new Color(0, 0, 0));
        contrasena.setText("Contraseña nueva");
        background_dialog_modificarCred.add(contrasena, new AbsoluteConstraints(30, 320, -1, -1));

        jPasswordField_nueva1.setBackground(new Color(255, 255, 255));
        jPasswordField_nueva1.setDocument(new LimitarCamposSeguro(20, "Ingrese una contraseña nueva"));
        jPasswordField_nueva1.setFont(new Font("Roboto", Font.PLAIN, 14));
        jPasswordField_nueva1.setForeground(Color.gray);
        jPasswordField_nueva1.setText("Ingrese una contraseña nueva");
        jPasswordField_nueva1.setBorder(null);
        jPasswordField_nueva1.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jPasswordField_nueva1, "Ingrese una contraseña nueva");
        background_dialog_modificarCred.add(jPasswordField_nueva1, new AbsoluteConstraints(30, 340, 380, -1));

        jSeparator2.setForeground(new Color(30, 30, 30));
        background_dialog_modificarCred.add(jSeparator2, new AbsoluteConstraints(30, 360, 380, 21));

        repetir_contrasena.setBackground(new Color(0, 0, 0));
        repetir_contrasena.setFont(new Font("Roboto", Font.PLAIN, 12));
        repetir_contrasena.setForeground(new Color(0, 0, 0));
        repetir_contrasena.setText("Repetir contraseña nueva *");
        background_dialog_modificarCred.add(repetir_contrasena, new AbsoluteConstraints(30, 370, -1, -1));

        jPasswordField_nueva2.setBackground(new Color(255, 255, 255));
        jPasswordField_nueva2.setDocument(new LimitarCamposSeguro(20, "Repita su contraseña nueva"));
        jPasswordField_nueva2.setFont(new Font("Roboto", Font.PLAIN, 14));
        jPasswordField_nueva2.setForeground(Color.gray);
        jPasswordField_nueva2.setText("Repita su contraseña nueva");
        jPasswordField_nueva2.setBorder(null);
        jPasswordField_nueva2.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jPasswordField_nueva2, "Repita su contraseña nueva");
        jPasswordField_nueva2.addActionListener(this::jPasswordField_nueva2ActionPerformed);
        background_dialog_modificarCred.add(jPasswordField_nueva2, new AbsoluteConstraints(30, 390, 380, -1));

        jSeparator10.setForeground(new Color(30, 30, 30));
        background_dialog_modificarCred.add(jSeparator10, new AbsoluteConstraints(30, 410, 380, 21));

        errorMessage2.setFont(new Font("Roboto", Font.BOLD, 14));
        errorMessage2.setForeground(Color.red);
        errorMessage2.setHorizontalAlignment(SwingConstants.CENTER);
        errorMessage2.setText("Error. ");
        errorMessage2.setHorizontalTextPosition(SwingConstants.CENTER);
        errorMessage2.setVisible(false);
        background_dialog_modificarCred.add(errorMessage2, new AbsoluteConstraints(2, 430, 440, -1));

        jButton_modificar2.setBackground(new Color(0, 204, 0));
        jButton_modificar2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jButton_modificar2.setForeground(new Color(0, 0, 0));
        jButton_modificar2.setText("Modificar");
        jButton_modificar2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_modificar2MouseClicked(evt);
            }
        });
        background_dialog_modificarCred.add(jButton_modificar2, new AbsoluteConstraints(320, 450, -1, -1));

        jButton_cancelar2.setBackground(new Color(153, 153, 153));
        jButton_cancelar2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jButton_cancelar2.setForeground(new Color(0, 0, 0));
        jButton_cancelar2.setText("Cancelar");
        jButton_cancelar2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_cancelar2MouseClicked(evt);
            }
        });
        background_dialog_modificarCred.add(jButton_cancelar2, new AbsoluteConstraints(230, 450, -1, -1));

        contrasena_anterior.setBackground(new Color(0, 0, 0));
        contrasena_anterior.setFont(new Font("Roboto", Font.PLAIN, 12));
        contrasena_anterior.setForeground(new Color(0, 0, 0));
        contrasena_anterior.setText("Contraseña anterior *");
        background_dialog_modificarCred.add(contrasena_anterior, new AbsoluteConstraints(30, 270, -1, -1));

        jPasswordField_vieja.setBackground(new Color(255, 255, 255));
        jPasswordField_vieja.setDocument(new LimitarCamposSeguro(20, "Ingrese su contraseña"));
        jPasswordField_vieja.setFont(new Font("Roboto", Font.PLAIN, 14));
        jPasswordField_vieja.setForeground(Color.gray);
        jPasswordField_vieja.setText("Ingrese su contraseña");
        jPasswordField_vieja.setBorder(null);
        jPasswordField_vieja.setMaximumSize(new Dimension(2147483647, 50));
        RegistrarUser.handleFocusGain(jPasswordField_vieja, "Ingrese su contraseña");
        background_dialog_modificarCred.add(jPasswordField_vieja, new AbsoluteConstraints(30, 290, 380, -1));

        jSeparator5.setForeground(new Color(30, 30, 30));
        background_dialog_modificarCred.add(jSeparator5, new AbsoluteConstraints(30, 310, 380, 21));

        jScrollPane2_modificarCred.setViewportView(background_dialog_modificarCred);

        GroupLayout jDialog_modificarCredLayout = new GroupLayout(jDialog_modificarCred.getContentPane());
        jDialog_modificarCred.getContentPane().setLayout(jDialog_modificarCredLayout);
        jDialog_modificarCredLayout.setHorizontalGroup(
                jDialog_modificarCredLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2_modificarCred)
        );
        jDialog_modificarCredLayout.setVerticalGroup(
                jDialog_modificarCredLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2_modificarCred)
        );

        jPanel_insert_update_delete.setBackground(new Color(227, 218, 201));
        jPanel_insert_update_delete.setPreferredSize(new Dimension(794, 794));
        jPanel_insert_update_delete.setLayout(new BoxLayout(jPanel_insert_update_delete, BoxLayout.Y_AXIS));

        jPanel9.setBackground(new Color(227, 218, 201));
        jPanel9.setMaximumSize(new Dimension(2147483647, 400));
        jPanel9.setPreferredSize(new Dimension(794, 360));
        jPanel9.setLayout(new GridLayout(10, 1));

        titulo_contenido2.setBackground(new Color(255, 255, 255));
        titulo_contenido2.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 14));
        titulo_contenido2.setHorizontalAlignment(SwingConstants.CENTER);
        titulo_contenido2.setText("INSERT - UPDATE -DELETE");
        titulo_contenido2.setHorizontalTextPosition(SwingConstants.CENTER);
        titulo_contenido2.setMaximumSize(new Dimension(2147483647, 17));
        titulo_contenido2.setOpaque(true);
        titulo_contenido2.setPreferredSize(new Dimension(794, 17));
        jPanel9.add(titulo_contenido2);

        jPanel10.setBackground(new Color(227, 218, 201));
        jPanel10.setPreferredSize(new Dimension(794, 25));
        jPanel10.setLayout(new BoxLayout(jPanel10, BoxLayout.X_AXIS));

        update.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        update.setForeground(new Color(0, 0, 0));
        update.setHorizontalAlignment(SwingConstants.CENTER);
        update.setText("UPDATE");
        update.setMaximumSize(new Dimension(60, 33));
        update.setPreferredSize(new Dimension(50, 33));
        jPanel10.add(update);

        jComboBox_tabla_update.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jComboBox_tabla_update.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir Tabla"}));
        jComboBox_tabla_update.setMaximumSize(new Dimension(367, 32767));
        jComboBox_tabla_update.setPreferredSize(new Dimension(150, 27));
        jComboBox_tabla_update.addActionListener(this::jComboBox_tabla_updateActionPerformed);
        jPanel10.add(jComboBox_tabla_update);

        set1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        set1.setForeground(new Color(0, 0, 0));
        set1.setHorizontalAlignment(SwingConstants.CENTER);
        set1.setText("SET");
        set1.setMaximumSize(new Dimension(45, 33));
        set1.setPreferredSize(new Dimension(25, 33));
        jPanel10.add(set1);

        jComboBox_columna_update.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jComboBox_columna_update.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir"}));
        jComboBox_columna_update.setPreferredSize(new Dimension(150, 27));
        jPanel10.add(jComboBox_columna_update);

        punto1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        punto1.setForeground(new Color(0, 0, 0));
        punto1.setHorizontalAlignment(SwingConstants.CENTER);
        punto1.setText("=");
        punto1.setMaximumSize(new Dimension(45, 33));
        punto1.setPreferredSize(new Dimension(25, 33));
        jPanel10.add(punto1);

        jTextField_valorUpdate.setDocument(new LimitarCamposSQL(50, "Valor"));
        jTextField_valorUpdate.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jTextField_valorUpdate.setForeground(Color.gray);
        jTextField_valorUpdate.setHorizontalAlignment(JTextField.LEFT);
        jTextField_valorUpdate.setText("Valor");
        jPanel10.add(jTextField_valorUpdate);

        cantColumn1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        cantColumn1.setForeground(new Color(0, 0, 0));
        cantColumn1.setHorizontalAlignment(SwingConstants.CENTER);
        cantColumn1.setText("Cantidad de columnas");
        cantColumn1.setMaximumSize(new Dimension(160, 33));
        cantColumn1.setPreferredSize(new Dimension(145, 33));
        jPanel10.add(cantColumn1);

        jComboBox_cantColumn_update.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jComboBox_cantColumn_update.setModel(new DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19"}));
        jComboBox_cantColumn_update.setMaximumSize(new Dimension(80, 32767));
        jComboBox_cantColumn_update.setPreferredSize(new Dimension(80, 27));
        jComboBox_cantColumn_update.addActionListener(this::jComboBox_cantColumn_updateActionPerformed);
        jPanel10.add(jComboBox_cantColumn_update);

        jTextField_updateComplejo.setDocument(new LimitarCamposSQL(200, "Campos y/o función"));
        jTextField_updateComplejo.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jTextField_updateComplejo.setHorizontalAlignment(JTextField.LEFT);
        jTextField_updateComplejo.setText("Campos y/o función");
        jTextField_updateComplejo.setVisible(false);
        RegistrarUser.handleFocusGain(jTextField_updateComplejo, "Campos y/o función");
        jTextField_updateComplejo.addActionListener(this::jTextField_updateComplejoActionPerformed);
        jPanel10.add(jTextField_updateComplejo);

        jToggleButton_update.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jToggleButton_update.setText("¿Complejo?");
        jToggleButton_update.addActionListener(this::jToggleButton_updateActionPerformed);
        jPanel10.add(jToggleButton_update);

        jPanel9.add(jPanel10);

        jPanel11.setBackground(new Color(227, 218, 201));
        jPanel11.setPreferredSize(new Dimension(794, 25));
        jPanel11.setLayout(new BoxLayout(jPanel11, BoxLayout.X_AXIS));

        where2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        where2.setForeground(new Color(0, 0, 0));
        where2.setHorizontalAlignment(SwingConstants.CENTER);
        where2.setText("WHERE");
        where2.setMaximumSize(new Dimension(60, 33));
        where2.setPreferredSize(new Dimension(50, 33));
        jPanel11.add(where2);

        jTextField_where_update.setDocument(new LimitarCamposSQL(100, "Condición o condiciones"));
        jTextField_where_update.setText("Condición o condiciones");
        RegistrarUser.handleFocusGain(jTextField_where_update, "Condición o condiciones");
        jTextField_where_update.addActionListener(this::jTextField_where_updateActionPerformed);
        jPanel11.add(jTextField_where_update);

        jPanel9.add(jPanel11);

        jButton_update.setBackground(new Color(0, 204, 0));
        jButton_update.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
        jButton_update.setForeground(new Color(0, 0, 0));
        jButton_update.setIcon(new ImageIcon(getClass().getResource("/images/lupa_icon.png")));
        jButton_update.setText("Actualizar");
        jButton_update.setMaximumSize(new Dimension(2147483647, 30));
        jButton_update.setPreferredSize(new Dimension(794, 30));
        jButton_update.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_updateMouseClicked(evt);
            }
        });
        jPanel9.add(jButton_update);

        jPanel12.setBackground(new Color(227, 218, 201));
        jPanel12.setPreferredSize(new Dimension(794, 25));
        jPanel12.setLayout(new BoxLayout(jPanel12, BoxLayout.X_AXIS));

        insert.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        insert.setForeground(new Color(0, 0, 0));
        insert.setHorizontalAlignment(SwingConstants.CENTER);
        insert.setText("INSERT INTO");
        insert.setMaximumSize(new Dimension(100, 33));
        insert.setPreferredSize(new Dimension(90, 33));
        jPanel12.add(insert);

        jComboBox_tabla_insert.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jComboBox_tabla_insert.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir Tabla"}));
        jComboBox_tabla_insert.setMaximumSize(new Dimension(367, 32767));
        jComboBox_tabla_insert.setPreferredSize(new Dimension(150, 27));
        jComboBox_tabla_insert.addActionListener(this::jComboBox_tabla_insertActionPerformed);
        jPanel12.add(jComboBox_tabla_insert);

        punto2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        punto2.setForeground(new Color(0, 0, 0));
        punto2.setHorizontalAlignment(SwingConstants.CENTER);
        punto2.setText("(");
        punto2.setMaximumSize(new Dimension(45, 33));
        punto2.setPreferredSize(new Dimension(10, 33));
        jPanel12.add(punto2);

        jComboBox_columna_insert.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jComboBox_columna_insert.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir"}));
        jComboBox_columna_insert.setPreferredSize(new Dimension(150, 27));
        jPanel12.add(jComboBox_columna_insert);

        punto3.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        punto3.setForeground(new Color(0, 0, 0));
        punto3.setHorizontalAlignment(SwingConstants.CENTER);
        punto3.setText(")");
        punto3.setMaximumSize(new Dimension(45, 33));
        punto3.setPreferredSize(new Dimension(10, 33));
        jPanel12.add(punto3);

        values.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        values.setForeground(new Color(0, 0, 0));
        values.setHorizontalAlignment(SwingConstants.CENTER);
        values.setText("VALUES");
        values.setMaximumSize(new Dimension(85, 33));
        values.setPreferredSize(new Dimension(75, 33));
        jPanel12.add(values);

        punto4.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        punto4.setForeground(new Color(0, 0, 0));
        punto4.setHorizontalAlignment(SwingConstants.CENTER);
        punto4.setText("=");
        punto4.setMaximumSize(new Dimension(45, 33));
        punto4.setPreferredSize(new Dimension(25, 33));
        jPanel12.add(punto4);

        jTextField_valorInsert.setDocument(new LimitarCamposSQL(50, "Valor"));
        jTextField_valorInsert.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jTextField_valorInsert.setForeground(Color.gray);
        jTextField_valorInsert.setHorizontalAlignment(JTextField.LEFT);
        jTextField_valorInsert.setText("Valor");
        jTextField_valorInsert.addActionListener(this::jTextField_valorInsertActionPerformed);
        jPanel12.add(jTextField_valorInsert);

        cantColumn.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        cantColumn.setForeground(new Color(0, 0, 0));
        cantColumn.setHorizontalAlignment(SwingConstants.CENTER);
        cantColumn.setText("Cantidad de columnas");
        cantColumn.setMaximumSize(new Dimension(160, 33));
        cantColumn.setPreferredSize(new Dimension(145, 33));
        jPanel12.add(cantColumn);

        jComboBox_cantColumn_insert.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jComboBox_cantColumn_insert.setModel(new DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19"}));
        jComboBox_cantColumn_insert.setMaximumSize(new Dimension(80, 32767));
        jComboBox_cantColumn_insert.setPreferredSize(new Dimension(80, 27));
        jComboBox_cantColumn_insert.addActionListener(this::jComboBox_cantColumn_insertActionPerformed);
        jPanel12.add(jComboBox_cantColumn_insert);

        jTextField_insertComplejo.setDocument(new LimitarCamposSQL(200, "Campos y/o función"));
        jTextField_insertComplejo.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jTextField_insertComplejo.setHorizontalAlignment(JTextField.LEFT);
        jTextField_insertComplejo.setText("Campos y/o función");
        jTextField_insertComplejo.setVisible(false);
        RegistrarUser.handleFocusGain(jTextField_insertComplejo, "Campos y/o función");
        jTextField_insertComplejo.addActionListener(this::jTextField_insertComplejoActionPerformed);
        jPanel12.add(jTextField_insertComplejo);

        jToggleButton_insert.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jToggleButton_insert.setText("¿Complejo?");
        jToggleButton_insert.addActionListener(this::jToggleButton_insertActionPerformed);
        jPanel12.add(jToggleButton_insert);

        jPanel9.add(jPanel12);

        jButton_insert.setBackground(new Color(0, 204, 0));
        jButton_insert.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
        jButton_insert.setForeground(new Color(0, 0, 0));
        jButton_insert.setIcon(new ImageIcon(getClass().getResource("/images/lupa_icon.png")));
        jButton_insert.setText("Insertar");
        jButton_insert.setMaximumSize(new Dimension(2147483647, 30));
        jButton_insert.setPreferredSize(new Dimension(794, 30));
        jButton_insert.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_insertMouseClicked(evt);
            }
        });
        jPanel9.add(jButton_insert);

        jPanel13.setBackground(new Color(227, 218, 201));
        jPanel13.setPreferredSize(new Dimension(794, 25));
        jPanel13.setLayout(new BoxLayout(jPanel13, BoxLayout.X_AXIS));

        delete.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        delete.setForeground(new Color(0, 0, 0));
        delete.setHorizontalAlignment(SwingConstants.CENTER);
        delete.setText("DELETE FROM");
        delete.setMaximumSize(new Dimension(100, 33));
        delete.setPreferredSize(new Dimension(90, 33));
        jPanel13.add(delete);

        jComboBox_tabla_delete.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jComboBox_tabla_delete.setModel(new DefaultComboBoxModel<>(new String[]{"Elegir Tabla"}));
        jComboBox_tabla_delete.setPreferredSize(new Dimension(150, 27));
        jPanel13.add(jComboBox_tabla_delete);

        jTextField_deleteComplejo.setDocument(new LimitarCamposSQL(200, "Campos y/o función"));
        jTextField_deleteComplejo.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jTextField_deleteComplejo.setText("Campos y/o función");
        jTextField_deleteComplejo.setVisible(false);
        RegistrarUser.handleFocusGain(jTextField_deleteComplejo, "Campos y/o función");
        jTextField_deleteComplejo.addActionListener(this::jTextField_deleteComplejoActionPerformed);
        jPanel13.add(jTextField_deleteComplejo);

        jToggleButton_delete.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jToggleButton_delete.setText("¿Complejo?");
        jToggleButton_delete.addActionListener(this::jToggleButton_deleteActionPerformed);
        jPanel13.add(jToggleButton_delete);

        jPanel9.add(jPanel13);

        jPanel14.setBackground(new Color(227, 218, 201));
        jPanel14.setPreferredSize(new Dimension(794, 25));
        jPanel14.setLayout(new BoxLayout(jPanel14, BoxLayout.X_AXIS));

        where3.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        where3.setForeground(new Color(0, 0, 0));
        where3.setHorizontalAlignment(SwingConstants.CENTER);
        where3.setText("WHERE");
        where3.setMaximumSize(new Dimension(60, 33));
        where3.setPreferredSize(new Dimension(50, 33));
        jPanel14.add(where3);

        jTextField_where_delete.setDocument(new LimitarCamposSQL(100, "Condición o condiciones"));
        jTextField_where_delete.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        jTextField_where_delete.setText("Condición o condiciones");
        RegistrarUser.handleFocusGain(jTextField_where_delete, "Condición o condiciones");
        jTextField_where_delete.addActionListener(this::jTextField_where_deleteActionPerformed);
        jPanel14.add(jTextField_where_delete);

        jPanel9.add(jPanel14);

        jButton_delete.setBackground(new Color(0, 204, 0));
        jButton_delete.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
        jButton_delete.setForeground(new Color(0, 0, 0));
        jButton_delete.setIcon(new ImageIcon(getClass().getResource("/images/lupa_icon.png")));
        jButton_delete.setText("Eliminar");
        jButton_delete.setMaximumSize(new Dimension(2147483647, 30));
        jButton_delete.setPreferredSize(new Dimension(794, 30));
        jButton_delete.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton_deleteMouseClicked(evt);
            }
        });
        jPanel9.add(jButton_delete);

        jPanel_insert_update_delete.add(jPanel9);

        separador.setBackground(new Color(227, 218, 201));
        separador.setMaximumSize(new Dimension(32767, 30));
        separador.setPreferredSize(new Dimension(794, 30));

        GroupLayout separadorLayout = new GroupLayout(separador);
        separador.setLayout(separadorLayout);
        separadorLayout.setHorizontalGroup(
                separadorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 794, Short.MAX_VALUE)
        );
        separadorLayout.setVerticalGroup(
                separadorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel_insert_update_delete.add(separador);

        resultadosActualizar.setEditable(false);
        resultadosActualizar.setBackground(new Color(227, 218, 201));
        resultadosActualizar.setFont(new Font("Roboto", Font.PLAIN, 14));
        resultadosActualizar.setLineWrap(true);
        resultadosActualizar.setRows(5);
        resultadosActualizar.setText("Resultado");
        resultadosActualizar.setWrapStyleWord(true);
        resultadosActualizar.setPreferredSize(new Dimension(794, 89));
        jPanel_insert_update_delete.add(resultadosActualizar);

        jPanel_backup.setBackground(new Color(227, 218, 201));
        jPanel_backup.setPreferredSize(new Dimension(794, 794));

        GroupLayout jPanel_backupLayout = new GroupLayout(jPanel_backup);
        jPanel_backup.setLayout(jPanel_backupLayout);
        jPanel_backupLayout.setHorizontalGroup(
                jPanel_backupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel_backupLayout.setVerticalGroup(
                jPanel_backupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel15.setBackground(new Color(227, 218, 201));
        jPanel15.setPreferredSize(new Dimension(794, 25));
        jPanel15.setLayout(new BoxLayout(jPanel15, BoxLayout.X_AXIS));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Programa Vacunas Panamá - ADMIN");
        setSize(new Dimension(1000, 800));
        addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent evt) {
                formComponentShown(evt);
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
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        separador1Layout.setVerticalGroup(
                separador1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

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
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        separador3Layout.setVerticalGroup(
                separador3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel_menuOpciones.add(separador3);

        rolName.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        rolName.setForeground(new Color(255, 255, 255));
        rolName.setHorizontalAlignment(SwingConstants.CENTER);
        rolName.setText("¡ Hola Admin !");
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
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        separador2Layout.setVerticalGroup(
                separador2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel_menuOpciones.add(separador2);

        button_opcion1.setForeground(new Color(255, 255, 255));
        button_opcion1.setText("Select");
        button_opcion1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button_opcion1.setPreferredSize(new Dimension(160, 30));
        button_opcion1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                button_opcion1MouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_opcion1);

        button_opcion2.setForeground(new Color(255, 255, 255));
        button_opcion2.setText("Insert - Update - Delete");
        button_opcion2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button_opcion2.setPreferredSize(new Dimension(160, 30));
        button_opcion2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                button_opcion2MouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_opcion2);

        button_opcion5.setForeground(new Color(255, 255, 255));
        button_opcion5.setText("Backups");
        button_opcion5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button_opcion5.setEnabled(false);
        button_opcion5.setFocusPainted(false);
        button_opcion5.setPreferredSize(new Dimension(160, 30));
        button_opcion5.setRequestFocusEnabled(false);
        button_opcion5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                button_opcion5MouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_opcion5);

        button_opcion6.setForeground(new Color(255, 255, 255));
        button_opcion6.setText("Procedimiento o funciones");
        button_opcion6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button_opcion6.setPreferredSize(new Dimension(160, 30));
        jPanel_menuOpciones.add(button_opcion6);

        button_opcion7.setForeground(new Color(255, 255, 255));
        button_opcion7.setText("Manejo de usuarios");
        button_opcion7.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button_opcion7.setEnabled(false);
        button_opcion7.setFocusPainted(false);
        button_opcion7.setFocusable(false);
        button_opcion7.setPreferredSize(new Dimension(160, 30));
        button_opcion7.setRequestFocusEnabled(false);
        jPanel_menuOpciones.add(button_opcion7);

        button_actualizar.setBackground(Color.green);
        button_actualizar.setForeground(Color.black);
        button_actualizar.setText("Actualizar DB Info");
        button_actualizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button_actualizar.setPreferredSize(new Dimension(160, 30));
        button_actualizar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                button_actualizarMouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_actualizar);

        separador4.setBackground(new Color(39, 104, 165));
        separador4.setForeground(new Color(48, 48, 46));
        separador4.setPreferredSize(new Dimension(150, 20));

        GroupLayout separador4Layout = new GroupLayout(separador4);
        separador4.setLayout(separador4Layout);
        separador4Layout.setHorizontalGroup(
                separador4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        separador4Layout.setVerticalGroup(
                separador4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel_menuOpciones.add(separador4);

        button_modificarDatos.setForeground(new Color(255, 255, 255));
        button_modificarDatos.setText("Modificar datos personales");
        button_modificarDatos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button_modificarDatos.setPreferredSize(new Dimension(160, 30));
        button_modificarDatos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                button_modificarDatosMouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_modificarDatos);

        button_modificarCred.setForeground(new Color(255, 255, 255));
        button_modificarCred.setText("Modificar credenciales");
        button_modificarCred.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button_modificarCred.setPreferredSize(new Dimension(160, 30));
        button_modificarCred.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                button_modificarCredMouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_modificarCred);

        button_preferencias.setForeground(new Color(255, 255, 255));
        button_preferencias.setText("Preferencias");
        button_preferencias.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button_preferencias.setPreferredSize(new Dimension(160, 30));
        button_preferencias.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                button_preferenciasMouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(button_preferencias);

        jButton_logOut.setBackground(new Color(255, 85, 73));
        jButton_logOut.setForeground(new Color(255, 255, 255));
        jButton_logOut.setText("Salir");
        jButton_logOut.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton_logOut.setPreferredSize(new Dimension(160, 30));
        jButton_logOut.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                button_logOutMouseClicked(evt);
            }
        });
        jPanel_menuOpciones.add(jButton_logOut);

        background.add(jPanel_menuOpciones, BorderLayout.WEST);

        jPanel_derecho.setBackground(new Color(227, 218, 201));
        jPanel_derecho.setPreferredSize(new Dimension(794, 0));
        jPanel_derecho.setLayout(new CardLayout());

        jPanel1.setBackground(new Color(227, 218, 201));
        jPanel1.setPreferredSize(new Dimension(794, 0));
        mostrando = jPanel1;

        jLabel6.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
        jLabel6.setForeground(new Color(102, 102, 102));
        jLabel6.setText("Bienvenido administrador al Programa Vacunas Panamá");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 595, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(198, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(752, Short.MAX_VALUE))
        );

        jPanel_derecho.add(jPanel1, "vacio");

        background.add(jPanel_derecho, BorderLayout.CENTER);

        jScrollPane3.setViewportView(background);

        getContentPane().add(jScrollPane3, BorderLayout.CENTER);
        setIconImage(new ImageIcon(getClass().getResource("/images/Icon1.png")).getImage());

        pack();
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
    }// </editor-fold>

    private void formComponentShown(ComponentEvent evt) {
        Login.setImageLabel(icon_project, "src/images/operacionVacunas_Logo.png");
    }

    /* eventos del menú lateral */
    private void button_logOutMouseClicked(MouseEvent evt) {
        this.dispose();
    }

    private void button_modificarCredMouseClicked(MouseEvent evt) {
        try {
            Resultados rUser = DB_ADMIN.searchUsuario(token, userActual.getCedula(), "Doctor - Enfermera");
            if (rUser != null && rUser.getDatos().length > 0) {
                datosEncontrados = rUser.getDatos();
                jTextField_usuario_Viejo.setText((String) datosEncontrados[0][1]);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el usuario anterior en la base de datos.");
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Ha ocurrido un problema encontrando su usuario. Reinicie la aplicación o contacte a soporte");
        }
        jDialog_modificarCred.setLocationRelativeTo(this);
        jDialog_modificarCred.setVisible(true);
        jDialog_modificarCred.requestFocusInWindow();
        datosEncontrados = null;
    }

    private void button_modificarDatosMouseClicked(MouseEvent evt) {
        try {
            jComboBox_distrito.setModel(new DefaultComboBoxModel<>(PantallaBase.transformMatrizToArray(DB_ADMIN.getDistritos(token), 0)));
            datosEncontrados = new String[1][];
            datosEncontrados[0] = userActual.toArray();
            jTextField_nombre.setText((String) datosEncontrados[0][0]);
            jTextField_apellido.setText((String) datosEncontrados[0][1]);
            jTextField_cedula.setText((String) datosEncontrados[0][2]);
            jTextField_fechaNacimiento.setText((String) datosEncontrados[0][3]);
            jTextField_correo.setText((String) datosEncontrados[0][4]);
            jTextField_telefono.setText((String) datosEncontrados[0][5]);
            jTextField_direccion.setText((String) datosEncontrados[0][6]);
            jComboBox_distrito.setSelectedItem(datosEncontrados[0][6]);
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Ha ocurrido un problema encontrando su usuario. Reinicie la aplicación o contacte a soporte");
        }
        jDialog_modificarDatos.setLocationRelativeTo(this);
        jDialog_modificarDatos.setVisible(true);
        jDialog_modificarDatos.requestFocusInWindow();
        editar = true;
    }

    private void button_preferenciasMouseClicked(MouseEvent evt) {
        if (!jPanel_derecho.isAncestorOf(jPanel_preferencias)) {
            jPanel_derecho.add(jPanel_preferencias, "preferences");
        }
        if (mostrando == jPanel_preferencias) {
            LAYOUT.show(jPanel_derecho, "vacio");
            mostrando = jPanel1;
        } else {
            LAYOUT.show(jPanel_derecho, "preferences");
            mostrando = jPanel_preferencias;
        }
        jPanel_derecho.revalidate();
        jPanel_derecho.repaint();
    }

    private void button_actualizarMouseClicked(MouseEvent evt) {
        try {
            dbO = DB_ADMIN.getDB(token);
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error al obtener la información de la base de datos.");
        }
        if (mostrando != jPanel1) {
            LAYOUT.show(jPanel_derecho, "vacio");
            mostrando = jPanel1;
            JOIN1.setTables(dbO);
            JOIN2.setTables(dbO);
            JOIN3.setTables(dbO);
            JOIN4.setTables(dbO);
            JOIN5.setTables(dbO);
            jComboBox_columna_select.setSelectedIndex(0);
            jComboBox_columna_insert.setSelectedIndex(0);
            jComboBox_columna_update.setSelectedIndex(0);
            jComboBox_cantColumn_insert.setSelectedIndex(0);
            jComboBox_cantColumn_update.setSelectedIndex(0);
            jComboBox_tabla_select.setSelectedIndex(0);
            jComboBox_tabla_insert.setSelectedIndex(0);
            jComboBox_tabla_update.setSelectedIndex(0);
            jComboBox_tabla_delete.setSelectedIndex(0);
            jComboBox_joins.setSelectedIndex(0);
            jComboBox_joinsActionPerformed(null);
            jComboBox_tabla_selectActionPerfomed(null);
            jComboBox_tabla_updateActionPerformed(null);
            jComboBox_tabla_insertActionPerformed(null);
            jComboBox_cantColumn_updateActionPerformed(null);
            jComboBox_cantColumn_insertActionPerformed(null);
        }
        JOptionPane.showMessageDialog(null, "Se ha actualiza los datos locales desde la base de datos.");
    }

    private void button_opcion1MouseClicked(MouseEvent evt) {
        if (!jPanel_derecho.isAncestorOf(jPanel_select)) {
            jPanel_derecho.add(jPanel_select, "option 1");
        }
        if (mostrando == jPanel_select) {
            LAYOUT.show(jPanel_derecho, "vacio");
            mostrando = jPanel1;
        } else {
            LAYOUT.show(jPanel_derecho, "option 1");
            DefaultComboBoxModel model = new DefaultComboBoxModel<>(new String[]{"Elegir"});
            model.addAll(dbO.getTablasNombres());
            model.addAll(dbO.getVistasNombres());
            jComboBox_tabla_select.setModel(model);
            mostrando = jPanel_select;
        }
        jPanel_derecho.revalidate();
        jPanel_derecho.repaint();
    }

    private void button_opcion2MouseClicked(MouseEvent evt) {
        if (!jPanel_derecho.isAncestorOf(jPanel_insert_update_delete)) {
            jPanel_derecho.add(jPanel_insert_update_delete, "option 2");
        }
        if (mostrando == jPanel_insert_update_delete) {
            LAYOUT.show(jPanel_derecho, "vacio");
            mostrando = jPanel1;
        } else {
            LAYOUT.show(jPanel_derecho, "option 2");
            JComboBox[] tablas = {jComboBox_tabla_insert, jComboBox_tabla_update, jComboBox_tabla_delete};
            for (JComboBox tabla : tablas) {
                DefaultComboBoxModel model = new DefaultComboBoxModel<>(new String[]{"Elegir"});
                model.addAll(dbO.getTablasNombres());
                tabla.setModel(model);
            }
            mostrando = jPanel_insert_update_delete;
        }
        jPanel_derecho.revalidate();
        jPanel_derecho.repaint();
    }

    private void button_opcion5MouseClicked(MouseEvent evt) {
        if (!jPanel_derecho.isAncestorOf(jPanel_backup)) {
            jPanel_derecho.add(jPanel_backup, "option 5");
        }
        if (mostrando == jPanel_backup) {
            LAYOUT.show(jPanel_derecho, "vacio");
            mostrando = jPanel1;
        } else {
            LAYOUT.show(jPanel_derecho, "option 5");
            mostrando = jPanel_backup;
        }
        jPanel_derecho.revalidate();
        jPanel_derecho.repaint();
    }

    /* eventos del jPanel mostrar tabla option 1*/

    private void jButton_acercarMouseClicked(MouseEvent evt) {
        Font currentFont = jTable_Content.getFont();
        jTable_Content.setFont(currentFont.deriveFont(currentFont.getSize() + 2f));
    }

    private void jButton_alejarMouseClicked(MouseEvent evt) {
        Font currentFont = jTable_Content.getFont();
        jTable_Content.setFont(currentFont.deriveFont(currentFont.getSize() - 2f));
    }

    private void jButton_fuenteMouseClicked(MouseEvent evt) {
        JFontChooser fontChooser = new JFontChooser(this);
        boolean result = fontChooser.showDialog(this);
        if (result) {
            Font font = fontChooser.getSelectedFont();
            jTable_Content.setFont(font);
            jTable_Content.repaint();
        }
    }

    private void jButton_exportarMouseClicked(MouseEvent evt) {
        /* TODO llamada al método exportar en csv o excel o pdf de option 1 */
    }

    /* eventos de tabla option 1 */

    private void jButton_buscarMouseClicked(MouseEvent evt) {
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

    private void jTextField_buscarTablaActionPerformed(ActionEvent evt) {
        jButton_buscarMouseClicked(null);
    }

    private void jButton_filtrosMouseClicked(MouseEvent evt) {
        if (!jPanel_select.isAncestorOf(JPANEL_FILTRAR)) {
            jPanel_select.add(JPANEL_FILTRAR, BorderLayout.NORTH);
        } else {
            jPanel_select.remove(JPANEL_FILTRAR);
        }
        jPanel_select.revalidate();
        jPanel_select.repaint();
    }

    private void jButton_ordenarMouseClicked(MouseEvent evt) {
        jTable_Content.setAutoCreateRowSorter(true);
    }

    /* eventos del panel SELECT */

    private void jComboBox_tabla_selectActionPerfomed(ActionEvent evt) {
        if (jComboBox_tabla_select.getSelectedIndex() != 0) {
            DefaultComboBoxModel model = new DefaultComboBoxModel<>(new String[]{"Elegir"});
            model.addAll(dbO.getColumnsNombres((String) jComboBox_tabla_select.getSelectedItem()));
            jComboBox_columna_select.setModel(model);
        }
    }

    private void jButton_selectMouseClicked(MouseEvent evt) {
        if (jComboBox_tabla_select.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "ERROR. Debe seleccionar alguna tabla en el FROM. OPERACIÓN CANCELADA", "ERROR SELECT", JOptionPane.ERROR_MESSAGE);
        } else {
            /* TODO implementar el BUSCAR SELECT según los criterios */
        }
    }

    private void jComboBox_joinsActionPerformed(ActionEvent evt) {
        if (jComboBox_joins.getSelectedIndex() == 0) {
            jToggleButton_select.setSelected(false);
            jToggleButton_selectActionPerformed(null);
        } else {
            jToggleButton_select.setSelected(true);
            jToggleButton_selectActionPerformed(null);
        }

        int cantidad = jComboBox_joins.getSelectedIndex();
        int cantComponentesActual = jPanel2.getComponentCount();
        if (cantComponentesActual > 8) {
            for (int i = cantComponentesActual - 8; i > 0; i--) {
                jPanel2.remove(3);
            }
        }
        switch (cantidad) {
            case 0 -> changeGridLayout(8);
            case 1 -> {
                changeGridLayout(9);
                jPanel2.add(JOIN1, 3);
            }
            case 2 -> {
                changeGridLayout(10);
                jPanel2.add(JOIN1, 3);
                jPanel2.add(JOIN2, 3);
            }
            case 3 -> {
                changeGridLayout(11);
                jPanel2.add(JOIN1, 3);
                jPanel2.add(JOIN2, 3);
                jPanel2.add(JOIN3, 3);
            }
            case 4 -> {
                changeGridLayout(12);
                jPanel2.add(JOIN1, 3);
                jPanel2.add(JOIN2, 3);
                jPanel2.add(JOIN3, 3);
                jPanel2.add(JOIN4, 3);
            }
            case 5 -> {
                changeGridLayout(13);
                jPanel2.add(JOIN1, 3);
                jPanel2.add(JOIN2, 3);
                jPanel2.add(JOIN3, 3);
                jPanel2.add(JOIN4, 3);
                jPanel2.add(JOIN5, 3);
            }
            default -> System.err.println("Caso no esperado en switch de cantidad de joins a crear en el panel Select");
        }
        jPanel2.revalidate();
        jPanel2.repaint();
    }

    private void jToggleButton_selectActionPerformed(ActionEvent evt) {
        if (jToggleButton_select.getSelectedObjects() != null) {
            jComboBox_columna_select.setVisible(false);
            jTextField_selectComplejo.setVisible(true);
        } else {
            jComboBox_columna_select.setVisible(true);
            jTextField_selectComplejo.setVisible(false);
        }
    }

    private void jTextField_havingActionPerformed(ActionEvent evt) {
        jButton_selectMouseClicked(null);
    }

    /* eventos de jPanel insert update delete */

    private void jComboBox_tabla_updateActionPerformed(ActionEvent evt) {
        if (jComboBox_tabla_select.getSelectedIndex() != 0) {
            DefaultComboBoxModel model = new DefaultComboBoxModel<>(new String[]{"Elegir"});
            model.addAll(dbO.getColumnsNombres((String) jComboBox_tabla_update.getSelectedItem()));
            jComboBox_columna_update.setModel(model);
            DefaultComboBoxModel model2 = (DefaultComboBoxModel) jComboBox_cantColumn_update.getModel();
            for (int i = model2.getSize(); i > model.getSize(); i--)
                model2.removeElementAt(i - 1);
        }
    }

    private void jComboBox_tabla_insertActionPerformed(ActionEvent evt) {
        if (jComboBox_tabla_select.getSelectedIndex() != 0) {
            DefaultComboBoxModel model = new DefaultComboBoxModel<>(new String[]{"Elegir"});
            model.addAll(dbO.getColumnsNombres((String) jComboBox_tabla_insert.getSelectedItem()));
            jComboBox_columna_insert.setModel(model);
            DefaultComboBoxModel model2 = (DefaultComboBoxModel) jComboBox_cantColumn_insert.getModel();
            for (int i = model2.getSize(); i > model.getSize(); i--)
                model2.removeElementAt(i - 1);
        }
    }

    private void jTextField_updateComplejoActionPerformed(ActionEvent evt) {
        jButton_updateMouseClicked(null);
    }

    private void jToggleButton_updateActionPerformed(ActionEvent evt) {
        if (jToggleButton_update.getSelectedObjects() != null) {
            jComboBox_tabla_update.setVisible(false);
            set1.setVisible(false);
            jComboBox_columna_update.setVisible(false);
            punto1.setVisible(false);
            jTextField_valorUpdate.setVisible(false);
            cantColumn1.setVisible(false);
            jComboBox_cantColumn_update.setVisible(false);
            jPanel11.setVisible(false);

            jTextField_updateComplejo.setVisible(true);
        } else {
            jComboBox_tabla_update.setVisible(true);
            set1.setVisible(true);
            jComboBox_columna_update.setVisible(true);
            punto1.setVisible(true);
            jTextField_valorUpdate.setVisible(true);
            cantColumn1.setVisible(true);
            jComboBox_cantColumn_update.setVisible(true);
            jPanel11.setVisible(true);

            jTextField_updateComplejo.setVisible(false);
        }
    }

    private void jButton_updateMouseClicked(MouseEvent evt) {
        String condicion = jTextField_where_update.getText();
        if (condicion.isBlank() || condicion.equals("Condición o condiciones")) {
            JOptionPane.showMessageDialog(null, "No puede actualizar toda la data de una tabla. Declare una condición WHERE", "ERROR UPDATE", JOptionPane.ERROR_MESSAGE);
        } else {
            /* TODO implementar lógica de hacer update en la tabla específica y columnas específicas con la condición específica */
        }
    }

    private void jTextField_where_updateActionPerformed(ActionEvent evt) {
        jButton_updateMouseClicked(null);
    }

    private void jTextField_valorInsertActionPerformed(ActionEvent evt) {
        jButton_insertMouseClicked(null);
    }

    private void jTextField_insertComplejoActionPerformed(ActionEvent evt) {
        jButton_insertMouseClicked(null);
    }

    private void jToggleButton_insertActionPerformed(ActionEvent evt) {
        if (jToggleButton_insert.getSelectedObjects() != null) {
            jComboBox_tabla_insert.setVisible(false);
            punto2.setVisible(false);
            jComboBox_columna_insert.setVisible(false);
            punto3.setVisible(false);
            values.setVisible(false);
            punto4.setVisible(false);
            jTextField_valorInsert.setVisible(false);
            cantColumn.setVisible(false);
            jComboBox_cantColumn_insert.setVisible(false);
            jPanel9.add(jPanel15, 5);

            jTextField_insertComplejo.setVisible(true);
        } else {
            jComboBox_tabla_insert.setVisible(true);
            punto2.setVisible(true);
            jComboBox_columna_insert.setVisible(true);
            punto3.setVisible(true);
            values.setVisible(true);
            punto4.setVisible(true);
            jTextField_valorInsert.setVisible(true);
            cantColumn.setVisible(true);
            jComboBox_cantColumn_insert.setVisible(true);
            jPanel9.remove(jPanel15);

            jTextField_insertComplejo.setVisible(false);
        }
    }

    private void jButton_insertMouseClicked(MouseEvent evt) {
        /* TODO insertar dato */
    }

    private void jTextField_deleteComplejoActionPerformed(ActionEvent evt) {
        jButton_deleteMouseClicked(null);
    }

    private void jToggleButton_deleteActionPerformed(ActionEvent evt) {
        if (jToggleButton_delete.getSelectedObjects() != null) {
            jComboBox_tabla_delete.setVisible(false);
            jPanel14.setVisible(false);

            jTextField_deleteComplejo.setVisible(true);
        } else {
            jComboBox_tabla_delete.setVisible(true);
            jPanel14.setVisible(true);

            jTextField_deleteComplejo.setVisible(false);
        }
    }

    private void jTextField_where_deleteActionPerformed(ActionEvent evt) {
        jButton_deleteMouseClicked(null);
    }

    private void jButton_deleteMouseClicked(MouseEvent evt) {
        String condicion = jTextField_where_delete.getText();
        if (condicion.isBlank() || condicion.equals("Condición o condiciones")) {
            JOptionPane.showMessageDialog(null, "No puede eliminar toda la data de una tabla. Declare una condición WHERE", "ERROR DELETE", JOptionPane.ERROR_MESSAGE);
        } else {
            /* TODO implementar lógica de eliminar con la condición específica */
        }
    }

    private void jComboBox_cantColumn_insertActionPerformed(ActionEvent evt) {
        if (jComboBox_tabla_insert.getSelectedIndex() != 0) {
            int cantidad = jComboBox_cantColumn_insert.getSelectedIndex();
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
                    jToggleButton_insert.setSelected(true);
                    jToggleButton_insertActionPerformed(null);
                    return;
                }
                addPanelJoin(jPanel12, cantidad, jComboBox_columna_insert.getModel());
            }
            jPanel12.revalidate();
            jPanel12.repaint();
        } else
            jComboBox_tabla_insert.setSelectedIndex(0);
    }

    private void jComboBox_cantColumn_updateActionPerformed(ActionEvent evt) {
        if (jComboBox_tabla_update.getSelectedIndex() != 0) {
            int cantidad = jComboBox_cantColumn_update.getSelectedIndex();
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
                    jToggleButton_update.setSelected(true);
                    jToggleButton_updateActionPerformed(null);
                    return;
                }
                addPanelJoin(jPanel10, cantidad, jComboBox_columna_update.getModel());
            }
            jPanel10.revalidate();
            jPanel10.repaint();
        } else
            jComboBox_cantColumn_update.setSelectedIndex(0);
    }

    /* evento único de jPanel preferencias */

    private void jButton_savePreferencesMouseClicked(MouseEvent evt) {
        int size = (int) fontSizeSpinner.getValue();
        String font = (String) familyComboBox.getSelectedItem();
        int style = styleComboBox.getSelectedIndex();
        int sede = jComboBox_sede_preferida.getSelectedIndex();
        String filetype = (String) jComboBox_exportarType_preferido.getSelectedItem();
        Preferencias p = userActual.getPrefs();
        p.setPrefs(font, style, size, sede, filetype);
        actualizarPreferencias(p);
        JOptionPane.showMessageDialog(this, "¡Se han guardado sus preferencias!");
    }

    /* eventos de jDialog modificar datos personales del usuario doctor */
    private void jTextField_direccionActionPerformed(ActionEvent evt) {
        if (jComboBox_distrito.getSelectedIndex() == 0) {
            jComboBox_distrito.setSelectedIndex(1);
        }
        jTextField_correo.requestFocus();
    }

    private void jTextField_telefonoActionPerformed(ActionEvent evt) {
        jButton_modificarMouseClicked(null);
    }

    private void jButton_cancelarMouseClicked(MouseEvent evt) {
        jDialog_modificarDatos.dispose();
    }

    private void jButton_modificarMouseClicked(MouseEvent evt) {
        boolean modificado = false;
        String nombreM = jTextField_nombre.getText();
        String apellidoM = jTextField_apellido.getText();
        String cedulaM = jTextField_cedula.getText();
        String fechaNacimientoM = jTextField_fechaNacimiento.getText();
        char sexoM = jComboBox_sexo.getSelectedItem().toString().charAt(0);
        String distritoM = jComboBox_distrito.getSelectedItem().toString();
        String direccionM = jTextField_direccion.getText();
        String correoM = jTextField_correo.getText();
        String telefonoM = jTextField_telefono.getText();

        boolean condicion1 = nombreM.isBlank() || nombreM.equals("Ingrese el nombre");
        boolean condicion2 = apellidoM.isBlank() || apellidoM.equals("Ingrese el apellido");
        boolean condicion3 = cedulaM.isBlank() || cedulaM.equals("Ingrese la cédula");
        boolean condicion4 = fechaNacimientoM.isBlank() || fechaNacimientoM.equals("Ingrese la fecha de nacimiento YYYY-MM-DD* hh:mm:ss");
        boolean condicion5 = sexoM == 'E';
        boolean condicionesObligatorias = !condicion1 && !condicion2 && !condicion3 && !condicion4 && !condicion5;

        boolean condicionOp1 = distritoM.equals("Elegir");
        boolean condicionOp2 = direccionM.isBlank() || direccionM.equals("Ingrese la dirección");
        boolean condicionOp3 = correoM.isBlank() || correoM.equals("Ingrese el correo electrónico");
        boolean condicionOp4 = telefonoM.isBlank() || telefonoM.equals("Ingrese el código de país, el código de ciudad y el número de teléfono local");

        if (editar) {
            boolean campoModificado =
                    !nombreM.equals(datosEncontrados[0][1]) ||
                            !apellidoM.equals(datosEncontrados[0][2]) ||
                            !cedulaM.equals(datosEncontrados[0][0]) ||
                            !fechaNacimientoM.equals(datosEncontrados[0][4]) ||
                            sexoM != datosEncontrados[0][6].toString().charAt(0) ||
                            (distritoM != null && !distritoM.equals(datosEncontrados[0][10])) ||
                            !direccionM.equals(datosEncontrados[0][9]) ||
                            !correoM.equals(datosEncontrados[0][8]) ||
                            !telefonoM.equals(datosEncontrados[0][7]);

            condicionesObligatorias = condicionesObligatorias && campoModificado;
        }

        boolean verificacion1 = !cedulaM.matches("^(PE|E|N|[23456789](?:AV|PI)?|1[0123]?(?:AV|PI)?)-(\\d{1,4})-(\\d{1,6})$");
        boolean verificacion2 = (!fechaNacimientoM.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$") && !fechaNacimientoM.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]) (0[0-9]|1[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$"));
        boolean verificacion3 = !correoM.isBlank() && !correoM.equals("Ingrese el correo electrónico") && !correoM.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
        boolean verificacion4 = (condicionOp1 && !condicionOp2) || (!condicionOp1 && condicionOp2);

        errorMessage.setVisible(false);

        if (!condicionesObligatorias) {
            errorMessage.setText("Error. Algunos campos son obligatorios*. Revisar");
            errorMessage.setVisible(true);
            return;
        } else {
            if (verificacion1) {
                errorMessage.setText("Error. La cédula no tiene el formato correcto.");
                errorMessage.setVisible(true);
                return;
            } else if (verificacion2) {
                errorMessage.setText("Error. La fecha de nacimiento no tiene el formato correcto. La fecha sin hora es obligatorio. YYYY-MM-DD");
                errorMessage.setVisible(true);
                return;
            } else if (verificacion3) {
                errorMessage.setText("Error. El correo electrónico no tiene el formato correcto.");
                errorMessage.setVisible(true);
                return;
            } else if (verificacion4) {
                errorMessage.setText("Error. La dirección o el distrito están incompletos. Debe llenar ambos o ninguno.");
                errorMessage.setVisible(true);
                return;
            } else {
                try {
                    Timestamp fechaNacimientoTimestamp;
                    if (fechaNacimientoM.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$")) {
                        fechaNacimientoTimestamp = Timestamp.valueOf(LocalDate.parse(fechaNacimientoM).atStartOfDay());
                    } else {
                        fechaNacimientoTimestamp = Timestamp.valueOf(fechaNacimientoM);
                    }

                    if (!condicionOp1 && !condicionOp2) {
                        if (!condicionOp3 && !condicionOp4) {
                            if (DB_ADMIN.manipulatePaciente(token, cedulaM, nombreM, apellidoM, fechaNacimientoTimestamp, sexoM, telefonoM, correoM, direccionM, distritoM) > 0) {
                                modificado = true;
                            }
                        } else if (!condicionOp3) {
                            if (DB_ADMIN.manipulatePaciente(token, cedulaM, nombreM, apellidoM, fechaNacimientoTimestamp, sexoM, null, correoM, direccionM, distritoM) > 0) {
                                modificado = true;
                            }
                        } else {
                            if (DB_ADMIN.manipulatePaciente(token, cedulaM, nombreM, apellidoM, fechaNacimientoTimestamp, sexoM, null, null, direccionM, distritoM) > 0) {
                                modificado = true;
                            }
                        }
                    } else if (!condicionOp3) {
                        if (!condicionOp4) {
                            if (DB_ADMIN.manipulatePaciente(token, cedulaM, nombreM, apellidoM, fechaNacimientoTimestamp, sexoM, telefonoM, correoM, null, null) > 0) {
                                modificado = true;
                            }
                        } else {
                            if (DB_ADMIN.manipulatePaciente(token, cedulaM, nombreM, apellidoM, fechaNacimientoTimestamp, sexoM, null, correoM, null, null) > 0) {
                                modificado = true;
                            }
                        }
                    } else if (!condicionOp4) {
                        if (DB_ADMIN.manipulatePaciente(token, cedulaM, nombreM, apellidoM, fechaNacimientoTimestamp, sexoM, telefonoM, null, null, null) > 0) {
                            modificado = true;
                        }
                    } else {
                        if (DB_ADMIN.manipulatePaciente(token, cedulaM, nombreM, apellidoM, fechaNacimientoTimestamp, sexoM, null, null, null, null) > 0) {
                            modificado = true;
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(this,
                            "Ha ocurrido un problema manipulando el paciente. No hay certeza si los datos fueron manipulados. " +
                                    "\nGuarde los datos para futuro registro. Reinicie la aplicación o contacte a soporte");
                }
            }
        }

        if (modificado) {
            JOptionPane.showMessageDialog(this, "Para confirmar los cambios de credenciales se cerrará el programa y debe iniciar sesión nuevamente.",
                    "Modificando datos...", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            jDialog_modificarCred.dispose();
            System.gc();
        } else {
            errorMessage.setText("Error al modificar los datos personales. Intente nuevamente o cierre esta ventana.");
            errorMessage.setVisible(true);
        }
    }

    /* eventos del jDialog modificar credenciales del usuario doctor */

    private void jButton_modificar2MouseClicked(MouseEvent evt) {
        boolean cambiado;
        String usuario = jTextField_usuario_Viejo.getText();
        String usuarioNuevo = jTextField_usuarioNuevo.getText();
        boolean condicion1 = usuario.isBlank() || usuario.equals("Ingrese su usuario");
        boolean condicion2 = usuarioNuevo.isBlank() || usuarioNuevo.equals("Ingrese un usuario nuevo");
        boolean condicion3 = String.valueOf(jPasswordField_vieja.getPassword()).isBlank() || String.valueOf(jPasswordField_vieja.getPassword()).equals("Ingrese su contraseña");
        boolean condicion4 = String.valueOf(jPasswordField_nueva1.getPassword()).isBlank() || String.valueOf(jPasswordField_nueva1.getPassword()).equals("Ingrese una contraseña nueva");
        boolean condicion5 = String.valueOf(jPasswordField_nueva2.getPassword()).isBlank() || String.valueOf(jPasswordField_nueva2.getPassword()).equals("Ingrese una contraseña nueva");

        errorMessage2.setVisible(false);
        repetir_contrasena.setForeground(Color.black);
        jPasswordField_nueva2.setForeground(Color.gray);
        contrasena.setForeground(Color.black);
        jPasswordField_nueva1.setForeground(Color.gray);
        contrasena_anterior.setForeground(Color.black);
        jPasswordField_vieja.setForeground(Color.gray);
        if (condicion1 || condicion3) {
            errorMessage2.setText("Error. Los campos usuario y contraseña anterior son obligatorios.");
            errorMessage2.setVisible(true);
            return;
        } else if (!InicioSesion.autentificar(usuario, String.valueOf(jPasswordField_vieja.getPassword()), "Doctor - Enfermera")) {
            contrasena_anterior.setForeground(Color.red);
            jPasswordField_vieja.setForeground(Color.red);
            errorMessage2.setText("Error. La contraseña anterior no coincide. Cambios cancelado");
            errorMessage2.setVisible(true);
            return;
        } else {
            if (!condicion2) {
                if (!condicion4 && !condicion5) {
                    if (!String.valueOf(jPasswordField_nueva1.getPassword()).equals(String.valueOf(jPasswordField_nueva2.getPassword()))) {
                        repetir_contrasena.setForeground(Color.red);
                        jPasswordField_nueva2.setForeground(Color.red);
                        contrasena.setForeground(Color.red);
                        jPasswordField_nueva1.setForeground(Color.red);
                        errorMessage2.setText("Error. Las contraseñas nuevas no son iguales.");
                        errorMessage2.setVisible(true);
                        return;
                    } else {
                        cambiado = InicioSesion.modificarCredenciales(cedulaUsuarioActual, usuarioNuevo, String.valueOf(jPasswordField_nueva1.getPassword()), "Doctor - Enfermera");
                    }
                } else {
                    cambiado = InicioSesion.modificarCredenciales(cedulaUsuarioActual, usuarioNuevo, String.valueOf(jPasswordField_vieja.getPassword()), "Doctor - Enfermera");
                }
            } else if (!condicion4 && !condicion5) {
                if (!String.valueOf(jPasswordField_nueva1.getPassword()).equals(String.valueOf(jPasswordField_nueva2.getPassword()))) {
                    repetir_contrasena.setForeground(Color.red);
                    jPasswordField_nueva2.setForeground(Color.red);
                    contrasena.setForeground(Color.red);
                    jPasswordField_nueva1.setForeground(Color.red);
                    errorMessage2.setText("Error. Las contraseñas nuevas no son iguales.");
                    errorMessage2.setVisible(true);
                    return;
                } else {
                    cambiado = InicioSesion.modificarCredenciales(cedulaUsuarioActual, usuario, String.valueOf(jPasswordField_nueva1.getPassword()), "Doctor - Enfermera");
                }
            } else {
                errorMessage2.setText("Error: ninguna credencial fue cambiada, debe modificar el usuario o la contraseña");
                errorMessage2.setVisible(true);
                return;
            }
        }

        if (cambiado) {
            JOptionPane.showMessageDialog(this, "Para confirmar los cambios de credenciales se cerrará el programa y debe iniciar sesión nuevamente.",
                    "Modificando datos...", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            jDialog_modificarCred.dispose();
            System.gc();
        } else {
            errorMessage2.setText("Error al modificar los credenciales del usuario. Intente nuevamente o cierre esta ventana.");
            errorMessage2.setVisible(true);
        }
    }

    private void jPasswordField_nueva2ActionPerformed(ActionEvent evt) {
        jButton_modificar2MouseClicked(null);
    }

    private void jButton_cancelar2MouseClicked(MouseEvent evt) {
        jDialog_modificarCred.dispose();
    }

    /* método para colocar el nombre al iniciar sesión */

    private void personalizarVentana(Usuario userActual) {
        this.userActual = userActual;
        cedulaUsuarioActual = this.userActual.getCedula();
        this.nombreBienvenida.setText(this.userActual.getNombre() + " " + this.userActual.getApellido());
        token = TokenMananger.generateToken(this.userActual.getUsuario(), "admin");
        try {
            dbO = DB_ADMIN.getDB(token);
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error al obtener la información de la base de datos.");
        }
        actualizarPreferencias(userActual.getPrefs());
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (JOptionPane.showConfirmDialog(null, "¿Extender la sesión actual?", "Sesión por expirar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    token = TokenMananger.generateToken(userActual.getUsuario(), "admin");
                } else {
                    dispose();
                }
            }
        }, TokenMananger.getExpireTimeFromToken(token));
    }

    /* método para actualizar las preferencias del doctor actual */

    private void actualizarPreferencias(Preferencias pref) {
        String font = pref.getFontName();
        int style = pref.getFontStyle(), size = pref.getFontSize();
        Font f = new Font(font, style, size);
        jTable_Content.setFont(f);
        fontSizeSpinner.setValue(size);
        familyComboBox.setSelectedItem(font);
        styleComboBox.setSelectedIndex(style);
        jComboBox_exportarType_preferido.setSelectedItem(pref.getExportFileType());

        try {
            jComboBox_sede_preferida.setModel(new DefaultComboBoxModel<>(PantallaBase.transformMatrizToArray(DB_ADMIN.getSedes(token), 0)));
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Ha ocurrido un problema encontrando las sedes. Reinicie la aplicación o contacte a soporte");
        }
        jComboBox_sede_preferida.setSelectedIndex(pref.getSede());
    }

    private void addListeners() {
        JTextField[] fieldsCondicion = {jTextField_where_select, jTextField_order, jTextField_having, jTextField_group, jTextField_where_delete, jTextField_where_update};
        JTextField[] fieldsValor = {jTextField_valorUpdate, jTextField_valorInsert2, jTextField_valorInsert};
        JTextField[] fieldsCampos = {jTextField_selectComplejo, jTextField_updateComplejo, jTextField_insertComplejo, jTextField_deleteComplejo};
        for (JTextField jTextField : fieldsCondicion) {
            PantallaBase.addFocusListeners(jTextField, "Condición o condiciones");
        }
        for (JTextField jTextField : fieldsValor) {
            PantallaBase.addFocusListeners(jTextField, "Valor");
        }
        for (JTextField fieldsCampo : fieldsCampos) {
            PantallaBase.addFocusListeners(fieldsCampo, "Campos y/o función");
        }
        PantallaBase.addFocusListeners(jTextField_buscarTabla, "Buscar...");
        // modificar datos usuario doctor
        PantallaBase.addFocusListeners(jTextField_nombre, "Ingrese su nombre");
        PantallaBase.addFocusListeners(jTextField_apellido, "Ingrese su apellido");
        PantallaBase.addFocusListeners(jTextField_direccion, "Ingrese su dirección");
        PantallaBase.addFocusListeners(jTextField_correo, "Ingrese su correo electrónico");
        PantallaBase.addFocusListeners(jTextField_telefono, "Ingrese el código de país, el código de ciudad y el número local");

        // modificar credenciales
        PantallaBase.addFocusListeners(jTextField_usuario_Viejo, "Ingrese su usuario");
        PantallaBase.addFocusListeners(jTextField_usuarioNuevo, "Ingrese un usuario nuevo");
        PantallaBase.addFocusListeners(jPasswordField_vieja, "Ingrese su contraseña");
        PantallaBase.addFocusListeners(jPasswordField_nueva1, "Ingrese una contraseña nueva");
        PantallaBase.addFocusListeners(jPasswordField_nueva2, "Repita su contraseña nueva");

        // Action listener
        PantallaBase.addActionListeners(jTextField_selectComplejo, jComboBox_tabla_select);
        PantallaBase.addActionListeners(jTextField_where_select, jTextField_order);
        PantallaBase.addActionListeners(jTextField_order, jTextField_group);
        PantallaBase.addActionListeners(jTextField_group, jTextField_having);
        PantallaBase.addActionListeners(jTextField_valorUpdate, jTextField_where_update);
        // modificar datos usuario doctor
        PantallaBase.addActionListeners(jTextField_nombre, jTextField_apellido);
        PantallaBase.addActionListeners(jTextField_apellido, jTextField_cedula);
        PantallaBase.addActionListeners(jTextField_cedula, jTextField_fechaNacimiento);
        PantallaBase.addActionListeners(jTextField_fechaNacimiento, jTextField_direccion);
        PantallaBase.addActionListeners(jTextField_correo, jTextField_telefono);

        // modificar credenciales
        PantallaBase.addActionListeners(jTextField_usuario_Viejo, jTextField_usuarioNuevo);
        PantallaBase.addActionListeners(jTextField_usuarioNuevo, jPasswordField_vieja);
        PantallaBase.addActionListeners(jPasswordField_vieja, jPasswordField_nueva1);
        PantallaBase.addActionListeners(jPasswordField_nueva1, jPasswordField_nueva2);
    }

    /* método para cambiar el tamaño del GridLayout en tiempo de ejecución */

    private void changeGridLayout(int rows) {
        GridLayout layout = (GridLayout) jPanel2.getLayout();
        layout.setRows(rows);
        layout.setColumns(1);
    }

    private void addPanelJoin(JPanel panel, int cantidad, ComboBoxModel original) {
        for (int i = 0; i < cantidad; i++) {
            DefaultComboBoxModel nuevoModel = new DefaultComboBoxModel();
            for (int j = 0; j < original.getSize(); j++) {
                nuevoModel.addElement(original.getElementAt(j));
            }

            JComboBox<?> nuevoComboBox = new JComboBox<>(nuevoModel);
            nuevoComboBox.setMinimumSize(new Dimension(76, 27));
            nuevoComboBox.setPreferredSize(new Dimension(100, 27));
            nuevoComboBox.setSelectedIndex(0);
            JTextField nuevoTextField = new JTextField("Valor");
            nuevoTextField.setHorizontalAlignment(2);
            nuevoTextField.setDocument(new LimitarCamposSQL(50, "Valor"));
            RegistrarUser.handleFocusGain(nuevoTextField, "Valor");
            PantallaBase.addFocusListeners(nuevoTextField, "Valor");

            panel.add(nuevoComboBox, 3);
            panel.add(nuevoTextField, (panel.getComponentCount() - 5));
        }
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(() -> new PantallaAdmin(new Usuario("Rey", "AcostaPruebas", "8-1024-1653", Timestamp.valueOf("2000-12-12 00:00:00"), "pruebas", "pruebas")).setVisible(true));
    }

    /* variables propias */
    private final CardLayout LAYOUT;
    private final DatabaseOperaciones DB_ADMIN;
    private final JPanelJoin JOIN1;
    private final JPanelJoin JOIN2;
    private final JPanelJoin JOIN3;
    private final JPanelJoin JOIN4;
    private final JPanelJoin JOIN5;
    private final JTableFiltrar JPANEL_FILTRAR;
    private boolean editar;
    private Component mostrando = null;
    private DatabaseInfo dbO;
    private Object[][] datosEncontrados;
    private String cedulaUsuarioActual;
    private String token;
    private Usuario userActual;

    // Variables declaration - do not modify
    private JButton button_actualizar;
    private JButton button_modificarCred;
    private JButton button_modificarDatos;
    private JButton button_opcion1;
    private JButton button_opcion2;
    private JButton button_opcion5;
    private JButton button_opcion6;
    private JButton button_opcion7;
    private JButton button_preferencias;
    private JButton jButton_acercar;
    private JButton jButton_alejar;
    private JButton jButton_buscar;
    private JButton jButton_cancelar;
    private JButton jButton_cancelar2;
    private JButton jButton_delete;
    private JButton jButton_exportar;
    private JButton jButton_filtros;
    private JButton jButton_fuente;
    private JButton jButton_insert;
    private JButton jButton_logOut;
    private JButton jButton_modificar;
    private JButton jButton_modificar2;
    private JButton jButton_ordenar;
    private JButton jButton_savePreferences;
    private JButton jButton_select;
    private JButton jButton_update;
    private JComboBox<String> familyComboBox;
    private JComboBox<String> jComboBox_cantColumn_insert;
    private JComboBox<String> jComboBox_cantColumn_update;
    private JComboBox<String> jComboBox_columna_insert;
    private JComboBox<String> jComboBox_columna_select;
    private JComboBox<String> jComboBox_columna_update;
    private JComboBox<String> jComboBox_distrito;
    private JComboBox<String> jComboBox_exportarType_preferido;
    private JComboBox<String> jComboBox_joins;
    private JComboBox<String> jComboBox_sede_preferida;
    private JComboBox<String> jComboBox_sexo;
    private JComboBox<String> jComboBox_tabla_delete;
    private JComboBox<String> jComboBox_tabla_insert;
    private JComboBox<String> jComboBox_tabla_select;
    private JComboBox<String> jComboBox_tabla_update;
    private JComboBox<String> styleComboBox;
    private JDialog jDialog_modificarCred;
    private JDialog jDialog_modificarDatos;
    private JLabel apellido;
    private JLabel cantColumn;
    private JLabel cantColumn1;
    private JLabel cantJoin;
    private JLabel cedula;
    private JLabel contrasena;
    private JLabel contrasena_anterior;
    private JLabel correo;
    private JLabel delete;
    private JLabel direccion;
    private JLabel distrito;
    private JLabel errorMessage;
    private JLabel errorMessage2;
    private JLabel fecha_nacimiento;
    private JLabel from;
    private JLabel groupBy;
    private JLabel having;
    private JLabel icon_preferencias;
    private JLabel icon_project;
    private JLabel insert;
    private JLabel jLabel1;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel nombre;
    private JLabel nombreBienvenida;
    private JLabel orderBy;
    private JLabel punto1;
    private JLabel punto2;
    private JLabel punto3;
    private JLabel punto4;
    private JLabel repetir_contrasena;
    private JLabel rolName;
    private JLabel select;
    private JLabel set1;
    private JLabel sexo;
    private JLabel telefono;
    private JLabel titulo;
    private JLabel titulo_contenido1;
    private JLabel titulo_contenido2;
    private JLabel titulo3;
    private JLabel update;
    private JLabel usuario;
    private JLabel usuario_nuevo;
    private JLabel values;
    private JLabel where1;
    private JLabel where2;
    private JLabel where3;
    private JPanel background;
    private JPanel background_dialog_modificarCred;
    private JPanel background_dialog_modificarDatos;
    private JPanel jPanel_backup;
    private JPanel jPanel_derecho;
    private JPanel jPanel_fontChooser;
    private JPanel jPanel_insert_update_delete;
    private JPanel jPanel_menuOpciones;
    private JPanel jPanel_preferencias;
    private JPanel jPanel_select;
    private JPanel jPanel_separador1;
    private JPanel jPanel_separador2;
    private JPanel jPanel_separador3;
    private JPanel jPanel_separador4;
    private JPanel jPanel_separador5;
    private JPanel jPanel1;
    private JPanel jPanel10;
    private JPanel jPanel11;
    private JPanel jPanel12;
    private JPanel jPanel13;
    private JPanel jPanel14;
    private JPanel jPanel15;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JPanel jPanel9;
    private JPanel opcionesTabla;
    private JPanel separador;
    private JPanel separador1;
    private JPanel separador2;
    private JPanel separador3;
    private JPanel separador4;
    private JPasswordField jPasswordField_nueva1;
    private JPasswordField jPasswordField_nueva2;
    private JPasswordField jPasswordField_vieja;
    private JScrollPane jScrollPane_Table;
    private JScrollPane jScrollPane1_modificarDatos;
    private JScrollPane jScrollPane2_modificarCred;
    private JScrollPane jScrollPane3;
    private JSeparator jSeparator1;
    private JSeparator jSeparator10;
    private JSeparator jSeparator11;
    private JSeparator jSeparator12;
    private JSeparator jSeparator2;
    private JSeparator jSeparator3;
    private JSeparator jSeparator4;
    private JSeparator jSeparator5;
    private JSeparator jSeparator6;
    private JSeparator jSeparator7;
    private JSeparator jSeparator8;
    private JSeparator jSeparator9;
    private JSpinner fontSizeSpinner;
    private JTable jTable_Content;
    private JTextArea jTextArea2_indicacionesModificarCred;
    private JTextArea jTextArea3_indicacionesModificarDatos;
    private JTextArea resultadosActualizar;
    private JTextField jTextField_apellido;
    private JTextField jTextField_buscarTabla;
    private JTextField jTextField_cedula;
    private JTextField jTextField_correo;
    private JTextField jTextField_deleteComplejo;
    private JTextField jTextField_direccion;
    private JTextField jTextField_fechaNacimiento;
    private JTextField jTextField_group;
    private JTextField jTextField_having;
    private JTextField jTextField_insertComplejo;
    private JTextField jTextField_nombre;
    private JTextField jTextField_order;
    private JTextField jTextField_selectComplejo;
    private JTextField jTextField_telefono;
    private JTextField jTextField_updateComplejo;
    private JTextField jTextField_usuario_Viejo;
    private JTextField jTextField_usuarioNuevo;
    private JTextField jTextField_valorInsert;
    private JTextField jTextField_valorInsert2;
    private JTextField jTextField_valorUpdate;
    private JTextField jTextField_where_delete;
    private JTextField jTextField_where_select;
    private JTextField jTextField_where_update;
    private JToggleButton jToggleButton_delete;
    private JToggleButton jToggleButton_insert;
    private JToggleButton jToggleButton_select;
    private JToggleButton jToggleButton_update;
    // End of variables declaration
}
