package Logica.Validations;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

public class LimitarCamposEmail extends LimitarCampos {
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]*@?[a-zA-Z0-9.-]*\\.?[a-zA-Z]{0,6}$";

    public LimitarCamposEmail(int limit, String placeholder) {
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
        String newText = getText(0, offset) + str + getText(offset, getLength() - offset);
        if (newText.length() <= limit && isValidEmail(newText)) {
            super.insertString(offset, str, attr);
        }
    }

    @Override
    public void replace(int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (text == null) {
            return;
        }
        if (getLength() == 0 && getText(0, getLength()).equals(placeholder)) {
            super.remove(0, getLength());
        }
        String newText = getText(0, offset) + text + getText(offset + length, getLength() - (offset + length));
        if (newText.length() <= limit && isValidEmail(newText)) {
            super.replace(offset, length, text, attrs);
        }
    }

    private boolean isValidEmail(String str) {
        return str.matches(EMAIL_PATTERN);
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
