package logic.user_management;

import logic.connexions.DatabaseOperaciones;

import javax.swing.*;
import java.sql.Timestamp;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/*
    ¿Cómo utilizar?

    while (true) {
        try {
            token = SessionManager.extendSession(token, user, "rol").get();
            if (token == null) {
                SessionManager.cancelTimers();
                break;
            }
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Mensaje de error");
        }
    }

    Para eventos de cierre anticipado se debe procurar llamar al
        SessionManager.cancelTimers()
    para que no ocurra errores donde el thread del Timer siga activo y no cierre el programa como se espera.
 */

public class SessionManager {

    private static final Timer mainTimer = new Timer(); // Timer principal para gestionar las tareas programadas

    public static CompletableFuture<String> extendSessionImmediately(String tokenActual, User usuario, String rol) {
        CompletableFuture<String> futureToken = new CompletableFuture<>();
        scheduleSessionExtensionImmediately(tokenActual, usuario, DatabaseOperaciones.getTipo(rol), futureToken);
        return futureToken;
    }

    public static CompletableFuture<String> extendSession(String tokenActual, User usuario, int rol) {
        CompletableFuture<String> futureToken = new CompletableFuture<>();
        scheduleSessionExtension(tokenActual, usuario, rol, futureToken);
        return futureToken;
    }

    public static CompletableFuture<String> extendSession(String tokenActual, User usuario, String rol) {
        CompletableFuture<String> futureToken = new CompletableFuture<>();
        scheduleSessionExtension(tokenActual, usuario, DatabaseOperaciones.getTipo(rol), futureToken);
        return futureToken;
    }

    private static void scheduleSessionExtension(String tokenActual, User usuario, int rol,
            CompletableFuture<String> futureToken) {
        long delay = TokenManager.getExpireTimeFromToken(tokenActual).getTime() - 3000;
        mainTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                SwingUtilities.invokeLater(() -> {
                    JOptionPane pane = new JOptionPane(
                            "¿Extender la sesión actual?",
                            JOptionPane.QUESTION_MESSAGE,
                            JOptionPane.YES_NO_OPTION);

                    JDialog dialog = pane.createDialog("Sesión por expirar");
                    dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                    dialog.setModal(true);

                    Timer closeDialogTimer = new Timer();
                    closeDialogTimer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            if (dialog.isVisible()) {
                                dialog.setVisible(false);
                                dialog.dispose();
                                futureToken.complete(null);
                                cancelTimers();
                            }
                        }
                    }, 30000); // 30 segundos

                    dialog.setVisible(true);
                    dialog.requestFocusInWindow();

                    // Listener para el botón del diálogo

                    int response = (int) pane.getValue();
                    closeDialogTimer.cancel(); // Cancel the timer if user responds
                    dialog.dispose();
                    if (response == JOptionPane.YES_OPTION) {
                        String newToken = TokenManager.generateToken(usuario.getCedula(), rol);
                        futureToken.complete(newToken);
                    } else {
                        futureToken.complete(null);
                        cancelTimers();
                    }
                });
            }
        }, delay);
    }

    private static void scheduleSessionExtensionImmediately(String tokenActual, User usuario, int rol,
            CompletableFuture<String> futureToken) {
        long delay = TokenManager.getExpireTimeFromToken(tokenActual).getTime() - 1000;
        mainTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                String newToken = TokenManager.generateToken(usuario.getCedula(), rol);
                futureToken.complete(newToken);
            }
        }, delay);
    }

    public static void cancelTimers() {
        mainTimer.cancel();
    }

    /* main para pruebas unitarias */
    public static void main(String[] args) {
        try {
            String token = TokenManager.generateToken("prueba", "prueba");
            User usuario = new User("", "prueba", "", Timestamp.valueOf("2000-1-1 00:00:00"));
            System.out.println("Token inicial: " + token);
            String resp = SessionManager.extendSession(token, usuario, 1).get();
            System.out.println(resp);
            if (resp != null) {
                resp = SessionManager.extendSession(resp, usuario, 1).get();
                System.out.println(resp);
            } else
                cancelTimers();
        } catch (InterruptedException | ExecutionException e) {
            System.err.println(e);
        }
    }
}