package com.example.my_diary.service;


import com.example.my_diary.common.CommonConstant;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Slf4j
@Service
public class JwtService {

    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public <T> String create(T data) {
        String jws = Jwts.builder()
                .claim(CommonConstant.USER_NAME,data)
                .setExpiration(new Date(System.currentTimeMillis() + 1 * (1000 * 60 * 10 * 1)))
                .signWith(key)
                .compact();
        return jws;
    }

}
