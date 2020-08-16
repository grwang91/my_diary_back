package com.example.my_diary.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{

    User findByUserName(String userName);
    //Optional<User> findById(Long id);
}
