package Logica.Validations;

public class LimitarCamposSQL extends LimitarCampos {

    public LimitarCamposSQL(int limit, String placeholder) {
        super(limit, placeholder, "[a-zA-Z0-9_()\\[\\]<>*=\\-.%|&'\" ]+");
    }
}
