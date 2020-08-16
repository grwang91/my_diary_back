package com.example.my_diary.controller;

import com.example.my_diary.common.CommonConstant;
import com.example.my_diary.dto.response.ResponseDataDto;
import com.example.my_diary.dto.response.ResponseMessageDto;
import com.example.my_diary.dto.user.UserJoinRequestDto;
import com.example.my_diary.dto.user.UserLoginRequestDto;
import com.example.my_diary.service.JwtService;
import com.example.my_diary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;

    @PostMapping("post/login")
    public ResponseEntity<ResponseDataDto> login(@RequestBody UserLoginRequestDto requestDto,
                                                    HttpServletResponse response) {

        Long id = userService.login(requestDto);

        response.setHeader(CommonConstant.AUTHORIZATION,
                jwtService.create(id));
        return ResponseEntity.ok(new ResponseDataDto(HttpStatus.OK.value(),id));
    }


    @PostMapping("post/signup")
    public ResponseEntity<ResponseMessageDto> signup(@RequestBody UserJoinRequestDto userJoinRequestDto) {
        userService.join(userJoinRequestDto);

        return ResponseEntity.ok(new ResponseMessageDto(HttpStatus.OK.value()));
    }

}
