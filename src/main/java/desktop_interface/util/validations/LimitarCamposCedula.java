package desktop_interface.util.validations;

public class LimitarCamposCedula extends LimitarCampos {

    public LimitarCamposCedula(int limit, String placeholder) {
        super(limit, placeholder, "^[PENAVIpenavi\\d]{0,4}-?\\d{0,4}-?\\d{0,6}$");
    }
}
