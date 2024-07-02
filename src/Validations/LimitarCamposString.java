package Validations;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

public class LimitarCamposString extends LimitarCampos {

    private static final String PATTERN = "^[a-zA-ZñÑáéíóúÁÉÍÓÚ]+";

    public LimitarCamposString(int limit, String placeholder) {
        super(limit, placeholder);
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) {
            return;
        }
        if (getText(0, getLength()).equals(placeholder)) {
            super.remove(0, placeholder.length());
        }
        if ((getLength() + str.length()) <= limit && isAlphabetical(str)) {
            super.insertString(offset, str, attr);
        }
    }

    @Override
    public void replace(int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (text == null) {
            return;
        }
        if (getText(0, getLength()).equals(placeholder)) {
            super.remove(0, placeholder.length());
        }
        if ((getLength() + text.length() - length) <= limit && isAlphabetical(text)) {
            super.replace(offset, length, text, attrs);
        }
    }

    private boolean isAlphabetical(String str) {
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
