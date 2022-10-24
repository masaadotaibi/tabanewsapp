package com.tabdaul.tabanewsapp.security;

import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenUtil {

    private final String CLAIMS_SUBJECT = "sub";
    private final String CLAIMS_CREATED = "created";

    private Long value = 604800L;

    private String generateToken(UserDetails userDetails) {

        // to generate the token, pass:
            // claims
            // expiration
            // signing of the token
            // compact the token (make at as a string)

        Map<String, Object> claims = new HashMap<>();


        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(null)
                .compact();
    }

    private Date generateExpirationDate() {

        return null;
    }
}
