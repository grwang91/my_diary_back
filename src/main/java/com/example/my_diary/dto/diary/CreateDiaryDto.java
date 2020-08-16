package com.example.my_diary.dto.diary;

import com.example.my_diary.domain.diary.Diary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateDiaryDto {

    private String title;

    private String content;

    private LocalDateTime date;

    private String weather;

    private long userId;

    public Diary toEntity(){
        return Diary.builder()
                .title(title)
                .content(content)
                .date(date)
                .weather(weather)
                .userId(userId)
                .build();
    }

}
