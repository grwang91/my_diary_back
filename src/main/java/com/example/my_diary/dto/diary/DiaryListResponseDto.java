package com.example.my_diary.dto.diary;

import com.example.my_diary.domain.diary.Diary;
import com.google.gson.Gson;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class DiaryListResponseDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime date;
    private WeatherDto weather;
    private String usrName;

    private List<DiaryPictureResponseDto> diaryPictures;




    public DiaryListResponseDto(Diary entity) {
        Gson gson = new Gson();
        WeatherDto weatherDto = gson.fromJson(entity.getWeather(),WeatherDto.class);

        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.date = entity.getDate();
        this.weather = weatherDto;
        this.usrName = entity.getUser().getUserName();
        this.diaryPictures = entity.getDiaryPictures().stream().map(DiaryPictureResponseDto::new)
            .collect(Collectors.toList());
    }
}
