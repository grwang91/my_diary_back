package com.example.my_diary.controller;

import com.example.my_diary.dto.response.ResponseMessageDto;
import com.example.my_diary.dto.user.UserJoinRequestDto;
import com.example.my_diary.dto.user.UserLoginRequestDto;
import com.example.my_diary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("post/login")
    public ResponseEntity<ResponseMessageDto> login(@RequestBody UserLoginRequestDto requestDto,
                                                    HttpServletRequest response) {


        boolean isSuccess = userService.login(requestDto);

        if(!isSuccess) {
            return ResponseEntity.ok(new ResponseMessageDto(HttpStatus.NOT_ACCEPTABLE.value()));
        }
        return ResponseEntity.ok(new ResponseMessageDto(HttpStatus.OK.value()));
    }


    @PostMapping("post/signup")
    public ResponseEntity<ResponseMessageDto> signup(@RequestBody UserJoinRequestDto userJoinRequestDto) {
        userService.join(userJoinRequestDto);

        return ResponseEntity.ok(new ResponseMessageDto(HttpStatus.OK.value()));
    }

}
