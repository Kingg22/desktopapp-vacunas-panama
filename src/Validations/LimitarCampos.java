package Validations;

import javax.swing.text.*;

public class LimitarCampos extends PlainDocument {

    int limit;
    String placeholder;

    public LimitarCampos(int limit, String placeholder) {
        super();
        this.limit = limit;
        this.placeholder = placeholder;
    }
}
