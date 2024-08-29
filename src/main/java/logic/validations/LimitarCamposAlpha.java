package logic.validations;

public class LimitarCamposAlpha extends LimitarCampos {

    public LimitarCamposAlpha(int limit, String placeholder) {
        super(limit, placeholder, "^[a-zA-Z0-9 ,áéíóúÁÉÍÓÚñÑ\\-]*$");
    }
}
