package com.example.my_diary.service;

import com.example.my_diary.domain.user.User;
import com.example.my_diary.domain.user.UserRepository;
import com.example.my_diary.dto.user.UserJoinRequestDto;
import com.example.my_diary.dto.user.UserLoginRequestDto;
import com.example.my_diary.exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void join (UserJoinRequestDto requestDto) {
        User user = new UserJoinRequestDto(requestDto.getLoginID()
                ,passwordEncoder.encode(requestDto.getPassword())).toEntity();

        User userCheck = userRepository.findByUserName(requestDto.getLoginID());

        if(userCheck != null) {
            throw new UsernameNotFoundException("이미 등록된 아이디입니다.");
        }

        userRepository.save(user);

    }

    public Long login(UserLoginRequestDto requestDto) {
        User user = userRepository.findByUserName(requestDto.getLoginID());

        if(user == null || !passwordEncoder.matches(requestDto.getPassword(),user.getPassword())) {
            throw new UserException("아이디를 확인해주세요");
        }

        return user.getId();

    }
}
