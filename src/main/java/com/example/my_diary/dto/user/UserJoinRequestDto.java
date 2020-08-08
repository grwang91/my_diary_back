package com.example.my_diary.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserJoinRequestDto {
    private String loginID;

    private String password;
}
