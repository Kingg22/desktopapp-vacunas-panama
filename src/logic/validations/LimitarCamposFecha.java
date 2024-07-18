package logic.validations;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LimitarCamposFecha extends PlainDocument {
    private final int limit;
    private final String placeholder;
    private static final String DATE_PATTERN = "^\\d{0,4}(-\\d{0,2}){0,2}$";
    private static final String DATETIME_PATTERN = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]) (0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9](\\.\\d{1,9})?$";

    public LimitarCamposFecha(int limit, String placeholder) {
        super();
        this.limit = limit;
        this.placeholder = placeholder;
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
        return str.matches(DATE_PATTERN) || str.matches(DATETIME_PATTERN);
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
