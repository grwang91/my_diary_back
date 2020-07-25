package com.example.my_diary.controller;

import com.example.my_diary.dto.diary.CreateDiaryDto;
import com.example.my_diary.dto.response.ResponseListDataDto;
import com.example.my_diary.dto.response.ResponseMessageDto;
import com.example.my_diary.service.DiaryService;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequiredArgsConstructor
public class DiaryController {
    private final DiaryService diaryService;

    private Logger logger = LoggerFactory.getLogger(DiaryController.class);


    @PostMapping("post/diary")
    public ResponseEntity<ResponseMessageDto> save(@RequestParam("title") String title,
                                                       @RequestParam("content") String content,
                                                       //@RequestParam("selectedFile") MultipartFile[] file
                                                       @RequestParam("weather") String weather
                                                ) {

        diaryService.save(new CreateDiaryDto(title,content, LocalDateTime.now(),weather));

        return ResponseEntity.ok(new ResponseMessageDto(HttpStatus.OK.value()));
    }


    @GetMapping("get/diaries")
    public ResponseEntity<ResponseListDataDto> get() {
        return ResponseEntity.ok(new ResponseListDataDto(HttpStatus.OK.value(),diaryService.findAll()));
    }
}
