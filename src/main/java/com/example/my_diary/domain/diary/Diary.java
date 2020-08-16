package com.example.my_diary.domain.diary;


import com.example.my_diary.common.BaseTimeEntity;
import com.example.my_diary.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


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

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;



    @Builder
    public Diary(String title, String content, LocalDateTime date, String weather, User user) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.weather = weather;
        this.user = user;
    }
}
