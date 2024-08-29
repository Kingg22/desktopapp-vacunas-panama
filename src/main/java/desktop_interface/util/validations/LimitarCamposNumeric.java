package desktop_interface.util.validations;

public class LimitarCamposNumeric extends LimitarCampos {

    public LimitarCamposNumeric(int limit, String placeholder) {
        super(limit, placeholder, "\\d*");
    }
}
