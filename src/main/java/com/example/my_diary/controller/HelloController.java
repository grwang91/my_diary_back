package com.example.my_diary.controller;


import com.example.my_diary.domain.Hello;
import com.example.my_diary.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HelloController {

    private final HelloService helloService;

    @GetMapping("/hello")
    public String hello(){
        return "hello spring";
    }

    @GetMapping("post/{id}")
    public Hello save(@PathVariable Long id) {
        Hello hello = helloService.save(id);

        return hello;
    }
}
