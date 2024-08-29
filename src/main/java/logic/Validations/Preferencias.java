package Logica.Validations;

import java.util.UUID;
import java.util.prefs.Preferences;

public class Preferencias {
    private final Preferences prefs = Preferences.userNodeForPackage(Usuario.class).node(UUID.randomUUID().toString());

    public boolean getPrefInput() {
        return prefs.getBoolean("prefInput", false);
    }

    public String getExportFileType() {
        return prefs.get("exportFileType", "PDF");
    }

    public String getFontName() {
        return prefs.get("fontName", "Roboto");
    }

    public int getSede() {
        return prefs.getInt("sede", 2);
    }

    public int getFontSize() {
        return prefs.getInt("fontSize", 12);
    }

    public int getFontStyle() {
        return prefs.getInt("fontStyle", 0);
    }

    public void setFontSize(int valor) {
        prefs.putInt("fontSize", valor);
    }

    public void setFontName(String valor) {
        prefs.put("fontName", valor);
    }

    public void setSede(int idSede) {
        prefs.putInt("sede", idSede);
    }

    public void setExportFileType(String fileType) {
        prefs.put("exportFileType", fileType);
    }

    public void setFontStyle(int style) {
        prefs.putInt("fontStyle", style);
    }

    public void setPrefs(String font, int style, int size, int sede, String fileType) {
        setFontName(font);
        setFontSize(size);
        setFontStyle(style);
        setSede(sede);
        setExportFileType(fileType);
    }

    public void setPrefInputs(boolean valor) {
        prefs.putBoolean("prefInput", valor);
        // emergente true, en tabla false
    }
}
