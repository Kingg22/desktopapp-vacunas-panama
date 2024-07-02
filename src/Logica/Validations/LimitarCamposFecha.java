package Logica.Validations;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

public class LimitarCamposFecha extends LimitarCampos {

    private static final String DATE_PATTERN = "^\\d{0,4}(-\\d{0,2})?(-\\d{0,2})?$";
    private static final String DATETIME_PATTERN = "^\\d{0,4}(-\\d{0,2})?(-\\d{0,2})?( \\d{0,2})?(:\\d{0,2})?(:\\d{0,2})?$";

    public LimitarCamposFecha(int limit, String placeholder) {
        super(limit, placeholder);
    }

    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) {
            return;
        }
        if (getLength() == 0 && getText(0, getLength()).equals(placeholder)) {
            super.remove(0, getLength());
        }
        String newText = getText(0, offset) + str + getText(offset, getLength() - offset);
        if (newText.length() <= limit && match(newText)) {
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
        if (newText.length() <= limit && match(newText)) {
            super.replace(offset, length, text, attrs);
        }
    }

    private boolean match(String str) {
        return str.matches(DATE_PATTERN) || str.matches(DATETIME_PATTERN);
    }
}
