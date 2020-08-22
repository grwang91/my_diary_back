package com.example.my_diary.domain.diaryPicture;

import com.example.my_diary.domain.diary.Diary;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class DiaryPicture {

    @Id
    @Column(name = "DIARY_PICTURE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pictureUrl;

    @ManyToOne
    @JoinColumn(name = "DIARY_ID")
    private Diary diary;

    public void addToDiary(Diary diary) {
        this.diary = diary;
        if(!diary.getDiaryPictures().contains(this)) {
            diary.getDiaryPictures().add(this);
        }
    }

    @Builder
    public DiaryPicture(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

}
