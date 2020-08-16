package com.example.my_diary.common;

import com.example.my_diary.service.JwtService;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RequiredArgsConstructor
@Component
public class JwtInterceptor implements HandlerInterceptor {

    private final JwtService jwtService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String token = request.getHeader(CommonConstant.AUTHORIZATION);
        if(StringUtils.equals(request.getMethod(),"OPTIONS")) {
            log.debug("if request options method is options, return true");
            return true;
        }
        if(token != null && jwtService.valid(token)) {
            request.setAttribute(CommonConstant.USER_NAME,jwtService.getUserId(token));
            return true;
        } else {
            throw new JwtException("토큰이 유효하지 않습니다.");
        }
    }
}
