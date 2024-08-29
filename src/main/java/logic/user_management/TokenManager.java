package logic.user_management;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.github.cdimascio.dotenv.Dotenv;
import logic.connexions.DatabaseOperaciones;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenManager {
    private static final String SECRET = Dotenv.load().get("SECRET");
    private static final long EXPIRATION_TIME = 3600000;
    private static final Map<String, Date> tokens = new HashMap<>();

    public static String generateToken(String cedula, int role) {
        if (UserManager.buscar(cedula, DatabaseOperaciones.getTipo(role)) == null) {
            return null;
        }
        String token = JWT.create()
                .withSubject(cedula)
                .withClaim("role", role)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC256(SECRET));
        tokens.put(token, getExpireTimeFromToken(token));
        return token;
    }

    public static String generateToken(String cedula, String role) {
        if (UserManager.buscar(cedula, role) == null) {
            return null;
        }
        role = role.toLowerCase().trim();
        String token = JWT.create()
                .withSubject(cedula)
                .withClaim("role", DatabaseOperaciones.getTipo(role))
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC256(SECRET));
        tokens.put(token, getExpireTimeFromToken(token));
        return token;
    }

    public static boolean verifyToken(String token) throws JWTVerificationException {
        JWT.require(Algorithm.HMAC256(SECRET))
                .build()
                .verify(token);
        return true;
    }

    public static int getRoleFromToken(String token) throws JWTVerificationException {
        DecodedJWT jwt = JWT.require(Algorithm.HMAC256(SECRET))
                .build()
                .verify(token);
        return jwt.getClaim("role").asInt();
    }

    public static String getCedulaFromToken(String token) throws JWTVerificationException {
        DecodedJWT jwt = JWT.require(Algorithm.HMAC256(SECRET))
                .build()
                .verify(token);
        return jwt.getSubject();
    }

    public static Date getExpireTimeFromToken(String token) throws JWTVerificationException {
        DecodedJWT jwt = JWT.require(Algorithm.HMAC256(SECRET))
                .build()
                .verify(token);
        return jwt.getExpiresAt();
    }

    public static Map<String, Date> getTokens() {
        return tokens;
    }

    public static boolean isTokenActive(String token) {
        Date expiresAt = tokens.get(token);
        return expiresAt != null && new Date().before(expiresAt);
    }

    public static void removeToken(String token) {
        tokens.remove(token);
    }

    public static int countActiveTokens() {
        int count = 0;
        for (Date expiresAt : tokens.values()) {
            if (new Date().before(expiresAt)) {
                count++;
            }
        }
        return count;
    }
}
