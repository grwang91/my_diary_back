package com.example.my_diary.service;

import com.example.my_diary.domain.diary.Diary;
import com.example.my_diary.domain.diary.DiaryRepository;
import com.example.my_diary.domain.user.UserRepository;
import com.example.my_diary.dto.diary.CreateDiaryDto;
import com.example.my_diary.dto.diary.DiaryListResponseDto;
import com.example.my_diary.dto.diary.UpdateDiaryRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class DiaryService {

    private final DiaryRepository diaryRepository;
    private final UserRepository userRepository;

    @Transactional
    public void deleteDiary(Long id, Long userId) throws IllegalAccessException {
        Diary diary = diaryRepository.findById(id).get();

        Long diaryUsrId = userRepository.findByUserName(diary.getUsrName()).getId();

        if(diaryUsrId == userId) {
            diaryRepository.delete(diary);
        } else {
            throw new IllegalAccessException();
        }

    }

    @Transactional
    public Long save(CreateDiaryDto createDiaryDto, Long usrId) {

        String usrName = userRepository.findById(usrId).get().getUserName();
        Diary diary = createDiaryDto.toEntity();
        diary.setUsrName(usrName);

        return diaryRepository.save(diary).getId();
    }

    public List<DiaryListResponseDto> findAll() {
        return diaryRepository.findAll().stream().map(DiaryListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public boolean update(UpdateDiaryRequestDto updateRequestDto, Long diaryId, Long usrId) {

        Diary diary = diaryRepository.findById(diaryId).get();
        Long diaryUsrId = userRepository.findByUserName(diary.getUsrName()).getId();

        if(diaryUsrId == usrId) {
            diary.update(updateRequestDto.getTitle(), updateRequestDto.getContent());
            return true;
        }

        return false;


    }
}
