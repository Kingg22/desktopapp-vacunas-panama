package Logica.Validations;

import java.util.prefs.Preferences;

public class Preferencias {
    private final Preferences prefs = Preferences.userNodeForPackage(Usuario.class);

    public void setPrefInputs(boolean valor) {
        prefs.putBoolean("prefInput", valor);
        // emergente true, en tabla false
    }

    public boolean getPrefInput() {
        return prefs.getBoolean("prefInput", false);
    }

    public void setFontSize(int valor) {
        prefs.putInt("fontSize", valor);
    }

    public int getFontSize() {
        return prefs.getInt("fontSize", 12);
    }

    public void setFontName(String valor) {
        prefs.put("fontName", valor);
    }

    public String getFontName() {
        return prefs.get("fontName", "Arial");
    }

    public void setSede(String sede) {
        prefs.put("sede", sede);
    }

    public String getSede() {
        return prefs.get("sede", "Complejo Hospitalario Doctor Arnulfo Arias Madrid");
    }

    public void setExportFileType(String fileType) {
        prefs.put("exportFileType", fileType);
    }

    public String getExportFileType() {
        return prefs.get("exportFileType", "PDF");
    }
}
