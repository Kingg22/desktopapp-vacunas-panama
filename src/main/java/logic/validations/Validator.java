package logic.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    // Expresión regular para los formatos de cédula panameña
    private static final Pattern COMPLETE_CEDULA_PATTERN = Pattern.compile(
            "^(PE|E|N|[23456789](?:AV|PI)?|1[0123]?(?:AV|PI)?)-(\\d{1,4})-(\\d{1,6})$",
            Pattern.CASE_INSENSITIVE);

    // Expresión regular para el formato de correo electrónico
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");

    // Método para validar la cédula
    public static boolean isValidCedula(String cedula) {
        if (cedula == null) {
            return false;
        }
        cedula = cedula.trim();
        Matcher matcher = COMPLETE_CEDULA_PATTERN.matcher(cedula);
        return matcher.matches();
    }

    // Método para validar el correo electrónico
    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        email = email.trim();
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }

    // Método para sanitizar la entrada limitando la longitud
    /*
     * public static String sanitizeInput(String input, int maxLength) {
     * if (input == null) {
     * return null;
     * }
     * if (input.length() > maxLength) {
     * input = input.substring(0, maxLength);
     * }
     * return input.trim(); // Elimina espacios al inicio y al final
     * }
     */
}