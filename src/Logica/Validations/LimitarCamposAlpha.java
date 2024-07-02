package Logica.Validations;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

public class LimitarCamposAlpha extends LimitarCampos {

    public LimitarCamposAlpha(int limit, String placeholder) {
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
        if ((getLength() + str.length()) <= limit && isAlphanumeric(str)) {
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
        if ((getLength() + text.length() - length) <= limit && isAlphanumeric(text)) {
            super.replace(offset, length, text, attrs);
        }
    }

    private boolean isAlphanumeric(String str) {
        return str.matches("^[a-zA-Z0-9 ,áéíóú]*$");
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
