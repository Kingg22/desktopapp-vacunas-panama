package InterfazDesktop;

import javax.swing.*;
import java.awt.*;

public class JFontChooser extends JDialog {

    private Font selectedFont;
    private boolean okPressed;
    private JComboBox<String> familyComboBox;
    private JComboBox<String> styleComboBox;
    private JSpinner sizeSpinner;

    public JFontChooser(Frame parent) {
        super(parent, "Elige una fuente", true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Panel para elegir la fuente
        JPanel fontPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        fontPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Familia de la fuente
        JLabel familyLabel = new JLabel("Familia:");
        familyComboBox = new JComboBox<>(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
        fontPanel.add(familyLabel);
        fontPanel.add(familyComboBox);

        // Estilo de la fuente
        JLabel styleLabel = new JLabel("Estilo:");
        String[] styles = {"Regular", "Negrita", "Cursiva", "Negrita Cursiva"};
        styleComboBox = new JComboBox<>(styles);
        fontPanel.add(styleLabel);
        fontPanel.add(styleComboBox);

        // Tamaño de la fuente
        JLabel sizeLabel = new JLabel("Tamaño:");
        sizeSpinner = new JSpinner(new SpinnerNumberModel(12, 1, 100, 1));
        fontPanel.add(sizeLabel);
        fontPanel.add(sizeSpinner);

        this.add(fontPanel, BorderLayout.CENTER);

        // Botones OK y Cancelar
        JPanel buttonPanel = new JPanel();
        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancelar");
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        this.add(buttonPanel, BorderLayout.SOUTH);

        okButton.addActionListener(e -> {
            String family = (String) familyComboBox.getSelectedItem();
            int style = styleComboBox.getSelectedIndex();
            int size = (int) sizeSpinner.getValue();
            selectedFont = new Font(family, style, size);
            okPressed = true;
            setVisible(false);
        });

        cancelButton.addActionListener(e -> setVisible(false));
        this.pack();
        this.requestFocusInWindow();
    }

    public boolean showDialog(Component parent) {
        this.setLocationRelativeTo(parent);
        this.setVisible(true);
        return okPressed;
    }

    public Font getSelectedFont() {
        return selectedFont;
    }

    public void setPreferences(String font, int style, int size) {
        familyComboBox.setSelectedItem(font);
        styleComboBox.setSelectedIndex(style);
        sizeSpinner.setValue(size);
    }
}
