package com.mariworld.accountdemo.user.helper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class TokenGenerator {

    private final String SECRET_KEY = "token generator v1";

    public String generateToken(String id){

        Map<String,Object> claims = new HashMap<>();
        claims.put("id" , id);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject("auth token")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 60*60*1000 ))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }


    public boolean validateToken(String token , String id){

        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();

        log.info("claims body --> {}" , claims);

        String idFromToken = claims.get("id", String.class);
        Date expiration = claims.getExpiration();
        return idFromToken.equals(id) && expiration.after(new Date());
    }
}
