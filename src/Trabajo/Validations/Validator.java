package Trabajo.Validations;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Validator {
    // Expresión regular para los formatos de cédula panameña
    private static final Pattern COMPLETE_CEDULA_PATTERN = Pattern.compile(
            "^(PE|E|N|[23456789](?:AV|PI)?|1[0123]?(?:AV|PI)?)-(\\d{1,4})-(\\d{1,6})$",
            Pattern.CASE_INSENSITIVE
    );


    // Método para validar la cédula
    public static boolean isValidCedula(String cedula) {
        if (cedula == null) {
            return false;
        }
        Matcher matcher = COMPLETE_CEDULA_PATTERN.matcher(cedula);
        return matcher.matches();
    }

    // Método para sanitizar la entrada limitando la longitud
    public static String sanitizeInput(String input, int maxLength) {
        if (input == null) {
            return null;
        }
        if (input.length() > maxLength) {
            input = input.substring(0, maxLength);
        }
        return input.trim(); // Elimina espacios al inicio y al final
    }
}