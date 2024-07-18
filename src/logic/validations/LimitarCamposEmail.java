package logic.validations;

public class LimitarCamposEmail extends LimitarCampos {

    public LimitarCamposEmail(int limit, String placeholder) {
        super(limit, placeholder, "^[a-zA-Z0-9._%+-]*@?[a-zA-Z0-9.-]*\\.?[a-zA-Z]{0,6}$");
    }
}
