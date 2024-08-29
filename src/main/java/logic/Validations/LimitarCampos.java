package Logica.Validations;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LimitarCampos extends PlainDocument {
    final int limit;
    final String placeholder;
    String pattern;

    public LimitarCampos(int limit, String placeholder, String pattern) {
        super();
        this.limit = limit;
        this.placeholder = placeholder;
        this.pattern = pattern;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) {
            return;
        }
        if (getText(0, getLength()).equals(placeholder)) {
            super.remove(0, getLength());
        }
        int newText = getLength() + str.length();
        if (newText <= limit && match(str)) {
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
        if ((getLength() + text.length() - length) <= limit && match(text)) {
            super.replace(offset, length, text, attrs);
        }
    }

    private boolean match(String str) {
        str = str.toUpperCase();
        return str.matches(pattern);
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