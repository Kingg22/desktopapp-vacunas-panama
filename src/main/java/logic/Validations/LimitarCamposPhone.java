package logic.Validations;

public class LimitarCamposPhone extends LimitarCampos {

    public LimitarCamposPhone(int limit, String placeholder) {
        super(limit, placeholder, "[0-9- ]*");
    }
}
