package com.example.my_diary.dto.diary;

import com.example.my_diary.domain.diaryPicture.DiaryPicture;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DiaryPictureRequestDto {
    private String pictureUrl;

    public DiaryPicture toEntity() {
        return new DiaryPicture().builder()
                .pictureUrl(pictureUrl)
                .build();
    }
}
