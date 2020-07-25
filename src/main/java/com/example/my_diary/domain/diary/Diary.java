package com.example.my_diary.domain.diary;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor
@Getter
@Entity
public class Diary {

    @Id
    @Column(name = "DIARY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private LocalDateTime date;

    private String weather;

    @Builder
    public Diary(String title, String content, LocalDateTime date, String weather) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.weather = weather;
    }
}
