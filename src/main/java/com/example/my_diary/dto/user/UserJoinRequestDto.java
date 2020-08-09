package com.example.my_diary.dto.user;

import com.example.my_diary.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserJoinRequestDto {
    private String loginID;

    private String password;

    public User toEntity() {
        return User.builder()
                .userName(loginID)
                .password(password)
                .build();
    }
}
