package com.example.my_diary.service;

import com.example.my_diary.common.S3Uploader;
import com.example.my_diary.domain.diary.Diary;
import com.example.my_diary.domain.diary.DiaryRepository;
import com.example.my_diary.domain.diaryPicture.DiaryPicture;
import com.example.my_diary.domain.diaryPicture.DiaryPictureRepository;
import com.example.my_diary.domain.user.User;
import com.example.my_diary.domain.user.UserRepository;
import com.example.my_diary.dto.diary.CreateDiaryDto;
import com.example.my_diary.dto.diary.DiaryListResponseDto;
import com.example.my_diary.dto.diary.DiaryPictureRequestDto;
import com.example.my_diary.dto.diary.UpdateDiaryRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class DiaryService {

    private final DiaryRepository diaryRepository;
    private final UserRepository userRepository;
    private final DiaryPictureRepository diaryPictureRepository;
    private final S3Uploader s3Uploader;

    @Transactional
    public void deleteDiary(Long id, Long userId) throws IllegalAccessException {
        Diary diary = diaryRepository.findById(id).get();

        Long diaryUsrId = diary.getUser().getId();

        if(diaryUsrId == userId) {
            diaryRepository.delete(diary);
        } else {
            throw new IllegalAccessException();
        }

    }

    @Transactional
    public Long save(CreateDiaryDto createDiaryDto, Long usrId) throws IOException {

        User user = userRepository.findById(usrId).get();
        Diary diary = createDiaryDto.toEntity();
        diary.addToUser(user);
        //saveDiaryPicture(createDiaryDto, diary);

        return diaryRepository.save(diary).getId();
    }

//    private void saveDiaryPicture(CreateDiaryDto createDiaryDto, Diary diary) throws IOException {
//        if(createDiaryDto.getFile() == null) {
//            return;
//        }
//        String pictureUrl = s3Uploader.upload(createDiaryDto.getFile(),"pictures");
//        DiaryPictureRequestDto request = new DiaryPictureRequestDto(pictureUrl);
//        DiaryPicture diaryPicture = request.toEntity();
//        diaryPicture.addToDiary(diary);
//        diaryPictureRepository.save(diaryPicture);
//    }

    public List<DiaryListResponseDto> findAll() {
        return diaryRepository.findAll().stream().map(DiaryListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public boolean update(UpdateDiaryRequestDto updateRequestDto, Long diaryId, Long usrId) {

        Diary diary = diaryRepository.findById(diaryId).get();
        Long diaryUsrId = diary.getUser().getId();

        if(diaryUsrId == usrId) {
            diary.update(updateRequestDto.getTitle(), updateRequestDto.getContent());
            return true;
        }

        return false;


    }
}
