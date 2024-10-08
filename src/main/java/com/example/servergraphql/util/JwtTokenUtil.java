package com.example.servergraphql.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import java.io.FileInputStream;
import java.security.*;
import java.security.cert.X509Certificate;

@Component
@RequiredArgsConstructor
public class JwtTokenUtil {



    @Value("${application.password}")
    private String password;



    @Value("${application.keystore}")
    private String keystore;

    public boolean validate(String token) {
            Jws<Claims> claimsJws = Jwts.parserBuilder()
                    .setSigningKey(getPublicKey())
                    .build()
                    .parseClaimsJws(token);

            long expirationMillis = claimsJws.getBody().getExpiration().getTime();
            return System.currentTimeMillis() < expirationMillis;

    }

    public String getUsername(String token) {
        Jws<Claims> claimsJws = Jwts.parserBuilder()
                .setSigningKey(getPublicKey())
                .build()
                .parseClaimsJws(token);
        return claimsJws.getBody().getSubject();
    }



    private PublicKey getPublicKey() {
        try {

            char[] keystorePassword = password.toCharArray();
            KeyStore ks = KeyStore.getInstance("PKCS12");
            FileInputStream fis = new FileInputStream(keystore);
            ks.load(fis, keystorePassword);
            fis.close();
            X509Certificate userCertificate = (X509Certificate) ks.getCertificate("server");
          return userCertificate.getPublicKey();


        } catch (Exception ex) {

            return null;
        }
    }


    public String getRole(String token) {
        Jws<Claims> claimsJws = Jwts.parserBuilder()
                .setSigningKey(getPublicKey())
                .build()
                .parseClaimsJws(token);
        return claimsJws.getBody().get("rol", String.class);
    }
}