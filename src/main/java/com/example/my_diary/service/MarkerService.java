package com.example.my_diary.service;

import com.example.my_diary.domain.marker.Marker;
import com.example.my_diary.domain.marker.MarkerRepository;
import com.example.my_diary.domain.user.User;
import com.example.my_diary.domain.user.UserRepository;
import com.example.my_diary.dto.marker.AddMarkerRequestDto;
import com.example.my_diary.dto.marker.MarkerListResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class MarkerService {

    private final UserRepository userRepository;
    private final MarkerRepository markerRepository;

    @Transactional
    public void addMarker(AddMarkerRequestDto requestDto, Long userId) {

        Marker marker = requestDto.toEntity();
        User user = userRepository.findById(userId).get();
        marker.addToUser(user);

        markerRepository.save(marker);
    }

    public List<MarkerListResponseDto> getMarkers() {
        return markerRepository.findAll().stream().map(MarkerListResponseDto::new)
                .collect(Collectors.toList());
    }
}
