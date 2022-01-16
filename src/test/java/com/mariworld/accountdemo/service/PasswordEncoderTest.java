package com.mariworld.accountdemo.service;

import com.mariworld.accountdemo.user.helper.PasswordEncoder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

@Slf4j
public class PasswordEncoderTest {

    @Test
    public void encodeTest() throws NoSuchAlgorithmException {
        PasswordEncoder passwordEncoder = new PasswordEncoder();
        String encode = passwordEncoder.encode("1111");
        log.warn("encoded password --> {}", encode);

    }
}
