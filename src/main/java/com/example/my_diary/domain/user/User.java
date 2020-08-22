package com.example.my_diary.domain.user;


import com.example.my_diary.domain.diary.Diary;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String userName;

    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Diary> diaries = new ArrayList<>();

    @Builder
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
