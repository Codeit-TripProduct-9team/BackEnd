package CodeIt.Ytrip.common;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtils {
    @Value("${JWT.SECRET.KEY}")
    private String key;

    public String generateToken(String userId) {
        return Jwts.builder()
                .claims(createClaims(userId))
                .expiration(createExpireDate())
                .signWith(createSigningKey())
                .compact();
    }

    private Map<String, Object> createClaims(String userId) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("key", userId);
        return claims;
    }

    private Date createExpireDate() {
        long expireTimeMils = 1000 * 60 * 60;
        long curTime = System.currentTimeMillis();
        return new Date(curTime + expireTimeMils);
    }

    private SecretKey createSigningKey() {
        byte[] secret = key.getBytes();
        return Keys.hmacShaKeyFor(secret);
    }

    public Claims getClaims(String token) {
        return Jwts.parser()
                .verifyWith(createSigningKey())
                .build()
                .parseSignedClaims(token).getPayload();
    }
}
