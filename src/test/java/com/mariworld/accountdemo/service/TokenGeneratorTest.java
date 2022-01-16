package com.mariworld.accountdemo.service;

import com.mariworld.accountdemo.user.helper.TokenGenerator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TokenGeneratorTest {

    @Test
    public void tokenValidationTest(){
        TokenGenerator tokenGenerator = new TokenGenerator();

        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhdXRoIHRva2VuIiwiaWQiOiJ1c2VyMDEiLCJleHAiOjE2NDIzMzAyNTQsImlhdCI6MTY0MjMyNjY1NH0.H-w8ju2cZxYGRXe5vcp_heTNMyMVinb7crS2GnK3gz90oYs1LfBAyEcS4PV_1rIZPxHHHA0hCV4YzFdcJwxPLQ";
        String id = "user01";
        boolean isValidateToken = tokenGenerator.validateToken(token, id);
        log.info("isValidateToken ? --> {} ", isValidateToken);
    }
}
