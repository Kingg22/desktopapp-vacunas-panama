package logic.validations;

public class LimitarCamposSeguro extends LimitarCampos {

    public LimitarCamposSeguro(int limit, String placeholder) {
        super(limit, placeholder, "^[a-zA-ZáéíóúÁÉÍÓÚñÑ0-9_\\-@\\.]+");
    }
}
