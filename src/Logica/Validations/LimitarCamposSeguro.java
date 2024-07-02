package Logica.Validations;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

public class LimitarCamposSeguro extends LimitarCampos {

    private static final String PATTERN = "^[a-zA-Z0-9_\\-@\\.]+";

    public LimitarCamposSeguro(int limit, String placeholder) {
        super(limit, placeholder);
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) {
            return;
        }
        if (getText(0, getLength()).equals(placeholder)) {
            super.remove(0, getLength());
        }
        String newText = getText(0, getLength()) + str;
        if (newText.length() <= limit && isSafe(str)) {
            super.insertString(offset, str, attr);
        }
    }

    @Override
    public void replace(int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (text == null) {
            return;
        }
        if (getText(0, getLength()).equals(placeholder)) {
            super.remove(0, getLength());
        }
        if ((getLength() + text.length() - length) <= limit && isSafe(text)) {
            super.replace(offset, length, text, attrs);
        }
    }

    private boolean isSafe(String str) {
        return str.matches(PATTERN);
    }

    @Override
    public void remove(int offs, int len) throws BadLocationException {
        if (getLength() == 0) {
            super.insertString(0, placeholder, null);
        } else {
            super.remove(offs, len);
        }
    }
}
