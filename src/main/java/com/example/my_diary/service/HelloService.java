package com.example.my_diary.service;

import com.example.my_diary.domain.Hello;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public Hello save(Long id) {
        Hello hello = new Hello(id, "title"+id, "caption"+id);
        return hello;
    }

}
