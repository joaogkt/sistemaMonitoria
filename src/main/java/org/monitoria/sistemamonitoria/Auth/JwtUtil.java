package org.monitoria.sistemamonitoria.Auth;

import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.monitoria.sistemamonitoria.Enums.Role;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

//    @Value("${jwt.secret}")
//    private static String SECRET = "dJ2GyWTT7NcsxyB1AGF+1lLYyX9p3x3G4I2zHKhn8U9kzHqjCrsn6vTXYuZsHgWZxfPU2wHIC2K+9kuKAlXtKA==";

//    @Value("${jwt.expiration}")
//    private static long EXPIRATION_TIME = 86400000;

    private Key key;

    @PostConstruct
    public void init() {
        String SECRET = "dJ2GyWTT7NcsxyB1AGF+1lLYyX9p3x3G4I2zHKhn8U9kzHqjCrsn6vTXYuZsHgWZxfPU2wHIC2K+9kuKAlXtKA==";
        this.key = Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    public String generateToken(String email, Role role, String name) {

        long EXPIRATION_TIME = 86400000;
        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .claim("name", name)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }
    public String extractEmail(String token) {
        return getClaims(token).getSubject();
    }

    public boolean isTokenValid(String token) {
        try {
            Claims claims = getClaims(token);
            return claims.getExpiration().after(new Date());
        } catch (JwtException | IllegalArgumentException e) {
            System.err.println("Erro ao validar o token: " + e.getMessage());
            return false;
        }
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

}
