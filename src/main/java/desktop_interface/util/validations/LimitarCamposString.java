package desktop_interface.util.validations;

public class LimitarCamposString extends LimitarCampos {

    public LimitarCamposString(int limit, String placeholder) {
        super(limit, placeholder, "^[a-zA-ZñÑáéíóúÁÉÍÓÚ]+");
    }
}
