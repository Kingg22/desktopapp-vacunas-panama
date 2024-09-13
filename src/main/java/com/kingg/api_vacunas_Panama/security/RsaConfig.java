package com.kingg.api_vacunas_panama.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Configuration
public class RsaConfig {
    @Value("${security.jwt.public}")
    private String rsaPublicKey;
    @Value("${security.jwt.private}")
    private String rsaPrivateKey;

    @Bean
    public RSAPublicKey getPublicKey() throws NoSuchAlgorithmException, InvalidKeySpecException {
        String publicKey = rsaPublicKey
                .replace("\"-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----\"", "")
                .replaceAll("\\s", "");
        byte[] encoded = Base64.getDecoder().decode(publicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encoded);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return (RSAPublicKey) keyFactory.generatePublic(keySpec);
    }

    @Bean
    public RSAPrivateKey getPrivate() throws NoSuchAlgorithmException, InvalidKeySpecException {
        String privateKeyPEM = rsaPrivateKey
                .replace("\"-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----\"", "")
                .replaceAll("\\s", "");

        byte[] encoded = Base64.getDecoder().decode(privateKeyPEM);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
    }
}
