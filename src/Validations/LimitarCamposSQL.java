package Validations;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

public class LimitarCamposSQL extends LimitarCampos {

    private static final String PATTERN = "[a-zA-Z0-9_()\\[\\]<>*=\\-.%|&'\" ]+";

    public LimitarCamposSQL(int limit, String placeholder) {
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
        if ((getLength() + str.length()) <= limit && isSecureSQL(str)) {
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
        if ((getLength() + text.length() - length) <= limit && isSecureSQL(text)) {
            super.replace(offset, length, text, attrs);
        }
    }

    private boolean isSecureSQL(String str) {
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
