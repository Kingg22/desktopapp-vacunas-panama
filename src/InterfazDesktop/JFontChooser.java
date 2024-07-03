package InterfazDesktop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFontChooser extends JDialog {

    private Font selectedFont;
    private boolean okPressed;

    public JFontChooser(Frame parent) {
        super(parent, "Elige una fuente", true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Panel para elegir la fuente
        JPanel fontPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        fontPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Familia de la fuente
        JLabel familyLabel = new JLabel("Familia:");
        JComboBox<String> familyComboBox = new JComboBox<>(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
        fontPanel.add(familyLabel);
        fontPanel.add(familyComboBox);

        // Estilo de la fuente
        JLabel styleLabel = new JLabel("Estilo:");
        String[] styles = {"Regular", "Negrita", "Cursiva", "Negrita Cursiva"};
        JComboBox<String> styleComboBox = new JComboBox<>(styles);
        fontPanel.add(styleLabel);
        fontPanel.add(styleComboBox);

        // Tamaño de la fuente
        JLabel sizeLabel = new JLabel("Tamaño:");
        JSpinner sizeSpinner = new JSpinner(new SpinnerNumberModel(12, 1, 100, 1));
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

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String family = (String) familyComboBox.getSelectedItem();
                int style = styleComboBox.getSelectedIndex();
                int size = (int) sizeSpinner.getValue();
                selectedFont = new Font(family, style, size);
                okPressed = true;
                setVisible(false);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        this.pack();
    }

    public boolean showDialog(Component parent) {
        this.setLocationRelativeTo(parent);
        this.setVisible(true);
        return okPressed;
    }

    public Font getSelectedFont() {
        return selectedFont;
    }
}
