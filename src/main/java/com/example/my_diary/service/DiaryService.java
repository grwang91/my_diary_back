package com.example.my_diary.service;

import com.example.my_diary.domain.diary.Diary;
import com.example.my_diary.domain.diary.DiaryRepository;
import com.example.my_diary.dto.diary.CreateDiaryDto;
import com.example.my_diary.dto.diary.DiaryListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DiaryService {

    private final DiaryRepository diaryRepository;

    @Transactional
    public Long save(CreateDiaryDto createDiaryDto) {
        Diary diary = createDiaryDto.toEntity();
        return diaryRepository.save(diary).getId();
    }

    public List<DiaryListResponseDto> findAll() {
        return diaryRepository.findAll().stream().map(DiaryListResponseDto::new)
                .collect(Collectors.toList());
    }
}
