package com.mariworld.accountdemo.user.helper;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static java.util.Objects.hash;

@Component
public class PasswordEncoder {

    private MessageDigest messageDigest;

    public PasswordEncoder() throws NoSuchAlgorithmException {
        messageDigest =  MessageDigest.getInstance("SHA-512");
    }

    public String encode(String plainPw){
        int hash = hash(plainPw);
        byte[] salt = BigInteger.valueOf(hash).toByteArray();
        messageDigest.update(salt);
        byte[] bytes = messageDigest.digest(plainPw.getBytes(StandardCharsets.UTF_8));
        String encodedPassword = Base64.encodeBase64URLSafeString(bytes);
        return encodedPassword;
    }

    public boolean matches(String plainPw, String pwd){
        String encodedPassword = encode(plainPw);
        return encodedPassword.equals(pwd);
    }
}
