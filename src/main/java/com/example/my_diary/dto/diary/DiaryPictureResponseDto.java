package com.example.my_diary.dto.diary;

import com.example.my_diary.domain.diaryPicture.DiaryPicture;
import lombok.Getter;

@Getter
public class DiaryPictureResponseDto {

    private Long id;

    private String pictureUrl;

    public DiaryPictureResponseDto(DiaryPicture entity) {
        this.id = entity.getId();
        this.pictureUrl = entity.getPictureUrl();
    }

}
