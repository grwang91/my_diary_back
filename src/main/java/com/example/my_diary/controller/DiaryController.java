package com.example.my_diary.controller;

import com.example.my_diary.dto.diary.CreateDiaryDto;
import com.example.my_diary.dto.response.ResponseListDataDto;
import com.example.my_diary.dto.response.ResponseMessageDto;
import com.example.my_diary.service.DiaryService;

import com.example.my_diary.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;


@RestController
@RequiredArgsConstructor
public class DiaryController {
    private final DiaryService diaryService;
    private final JwtService jwtService;

    @GetMapping("api/deleteDiary/{id}")
    public ResponseEntity<ResponseMessageDto> delete(@PathVariable Long id,
                                                     @RequestHeader(value="authorization") String jws)
        throws Exception{

        diaryService.deleteDiary(id,(long)jwtService.getUserId(jws));
        return ResponseEntity.ok(new ResponseMessageDto(HttpStatus.OK.value()));
    }


    @PostMapping("api/diary")
    public ResponseEntity<ResponseMessageDto> save(@RequestParam("title") String title,
                                                       @RequestParam("content") String content,
                                                       @RequestParam(value="selectedFile", required = false) MultipartFile file,
                                                       @RequestParam("weather") String weather,
                                                   @RequestHeader(value="authorization") String jws
                                                ) {

        diaryService.save(new CreateDiaryDto(title,content, LocalDateTime.now(),file,weather),(long)jwtService.getUserId(jws));

        return ResponseEntity.ok(new ResponseMessageDto(HttpStatus.OK.value()));
    }


    @GetMapping("api/diaries")
    public ResponseEntity<ResponseListDataDto> get() {
        return ResponseEntity.ok(new ResponseListDataDto(HttpStatus.OK.value(),diaryService.findAll()));
    }
}
