package com.example.my_diary.domain.diary;


import com.example.my_diary.common.BaseTimeEntity;
import com.example.my_diary.domain.diaryPicture.DiaryPicture;
import com.example.my_diary.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Getter
@Entity
public class Diary extends BaseTimeEntity {

    @Id
    @Column(name = "DIARY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private LocalDateTime date;

    private String weather;

    private String geoData;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "diary", cascade = CascadeType.REMOVE)
    private List<DiaryPicture> diaryPictures = new ArrayList<>();

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void addToUser(User user) {
        this.user = user;
        if(!user.getDiaries().contains(this)) {
            user.getDiaries().add(this);
        }
    }

    @Builder
    public Diary(String title, String content, LocalDateTime date, String weather, String geoData) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.weather = weather;
        this.geoData = geoData;
    }
}
