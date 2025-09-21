package com.localsense.localSense.configSecurity;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private static final String CHAVE_SECRETA = "minha-chave-super-secreta-muito-grande"; // chave usada para assinar o token

    // Retorna a chave de assinatura HMAC a partir da chave secreta
    private Key obterChaveAssinatura() {
        return Keys.hmacShaKeyFor(CHAVE_SECRETA.getBytes());
    }

    // Cria um token JWT com o email como assunto e expiração de 24h
    public String gerarToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(obterChaveAssinatura(), SignatureAlgorithm.HS256)
                .compact();
    }

    // Lê o token e retorna o email que está no "sub"
    public String extrairEmail(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(obterChaveAssinatura())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Valida o token (assinatura e formato)
    public boolean tokenValido(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(obterChaveAssinatura())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
