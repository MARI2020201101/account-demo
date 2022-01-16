package com.mariworld.accountdemo.user.helper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenGenerator {

    private final String SECRET_KEY = "token generator v1";

    public String generateToken(String id){

        Map<String,Object> claims = new HashMap<>();
        claims.put("id" , id);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject("auth token")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY).compact();
    }
}
