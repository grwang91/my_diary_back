package com.example.my_diary.controller;

import com.example.my_diary.dto.response.ResponseMessageDto;
import com.example.my_diary.dto.user.UserJoinRequestDto;
import com.example.my_diary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class UserController {

    UserService userService;

//    @PostMapping("post/login")


    @PostMapping("post/signup")
    public ResponseEntity<ResponseMessageDto> signup(@RequestBody UserJoinRequestDto userJoinRequestDto) {
        userService.join(userJoinRequestDto);
        return ResponseEntity.ok(new ResponseMessageDto(HttpStatus.OK.value()));
    }
}
