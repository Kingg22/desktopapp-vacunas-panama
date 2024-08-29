package logic.connexions;

import java.sql.SQLException;

/*
    ErrorCode esperados:
                        0: No ingresó token
                        1: No está registrado
                        2: Error de conexión
                        3: No tiene rol
                        4: No tiene usuario
                        5: Sin acceso
                        6: Error del token
                        7: Posible unsafe SQL
                        8: El statement fue procesado de forma incorrecta
*/

public class CustomException extends SQLException {
    private int errorCode;

    public CustomException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public CustomException(int errorCode) {
        this.errorCode = errorCode;
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(int errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return super.getMessage();
    }
}
