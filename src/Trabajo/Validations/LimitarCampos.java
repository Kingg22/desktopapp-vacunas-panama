package Trabajo.Validations;

import javax.swing.text.*;

class LimitarTipo extends DocumentFilter {

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (string == null) return;

        if (isNumeric(string)) {
            super.insertString(fb, offset, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (text == null) return;

        if (isNumeric(text)) {
            super.replace(fb, offset, length, text, attrs);
        }
    }

    private boolean isNumeric(String str) {
        return str.matches("\\d*");
    }
}

class LimitarCampos extends PlainDocument {
    private int limit;

    LimitarCampos(int limit) {
        super();
        this.limit = limit;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) return;

        if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);
        }
    }
}
