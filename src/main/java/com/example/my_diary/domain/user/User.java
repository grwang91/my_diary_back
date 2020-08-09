package com.example.my_diary.domain.user;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @Builder
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
