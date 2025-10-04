
package com.jose.newlibrary.core.util;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

/**
 * JwtUtil
 */
@Component
public class JwtUtil {

    @Value("${jwt.secret.key}")
    private String SECRET_KEY;

    //private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    
    private Key getKey(String secret){
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }


    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

	private String createToken(Map<String, Object> claims, String email) {
        final Key key = getKey(SECRET_KEY);
        return Jwts.builder()
            .setClaims(claims)
            .setSubject(email)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 horas
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();
	}

    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
            .setSigningKey(getKey(SECRET_KEY))
            .build()
            .parseClaimsJws(token)
            .getBody();
    }

    public String extractEmail(String token){
        Claims claims = extractAllClaims(token);
        return claims.getSubject();
    } 

    public Date extractExpiration(String token){
        return extractAllClaims(token).getExpiration();
    }

    public Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    public Boolean isTokenValid(String token, UserDetails userDetails){
        final String email = extractEmail(token);
        return (email.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

}
