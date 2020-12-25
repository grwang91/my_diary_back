package com.example.my_diary.dto.diary;

import com.example.my_diary.domain.diary.Diary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CreateDiaryDto {

    private String title;

    private String content;

    private LocalDateTime date;

    private MultipartFile file;

    private String weather;

    private String geoData;



    public Diary toEntity(){
        return Diary.builder()
                .title(title)
                .content(content)
                .date(date)
                .weather(weather)
                .geoData(geoData)
                .build();
    }

}
