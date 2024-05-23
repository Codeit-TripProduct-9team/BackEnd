package CodeIt.Ytrip.common;

import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JwtUtilsTest {

    @Autowired
    JwtUtils jwtUtils;
    
    @Test
    public void 토큰_생성() throws Exception {
        String s = jwtUtils.generateToken("1");
        Assertions.assertNotNull(s);
        System.out.println("s = " + s);
    }
    
    @Test
    public void 토큰_복호화() {
        String userId = "UTrip";
        String token = jwtUtils.generateToken("jaemin5548");
        System.out.println("token = " + token);
        Claims claims = jwtUtils.getClaims(token);
        System.out.println("claims = " + claims);
    }

}