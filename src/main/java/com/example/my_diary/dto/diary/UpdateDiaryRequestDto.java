package com.example.my_diary.dto.diary;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateDiaryRequestDto {

    private String title;

    private String content;

}
