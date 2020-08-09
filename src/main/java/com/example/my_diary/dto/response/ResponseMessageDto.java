package com.example.my_diary.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessageDto {

    private int status;
    private String message;

    public ResponseMessageDto(int status) {
        if (200 == status) {
            this.message = "Success";
        } else {
            this.message = "Fail";
        }
        this.status = status;
    }

}
