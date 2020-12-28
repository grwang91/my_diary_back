package com.example.my_diary.controller;

import com.example.my_diary.dto.marker.AddMarkerRequestDto;
import com.example.my_diary.dto.response.ResponseListDataDto;
import com.example.my_diary.dto.response.ResponseMessageDto;
import com.example.my_diary.service.JwtService;
import com.example.my_diary.service.MarkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MarkerController {
    private final JwtService jwtService;
    private final MarkerService markerService;

    @PostMapping("api/addMarker")
    public ResponseEntity<ResponseMessageDto> addMarker(@RequestHeader(value="authorization") String jws,
                                                        @RequestBody AddMarkerRequestDto requestDto) {

        markerService.addMarker(requestDto,(long)jwtService.getUserId(jws));
        return ResponseEntity.ok(new ResponseMessageDto(HttpStatus.OK.value()));
    }

    @GetMapping("api/getMarkers")
    public ResponseEntity<ResponseListDataDto> getMarkers() {
        return ResponseEntity.ok(new ResponseListDataDto(HttpStatus.OK.value(),markerService.getMarkers()));
    }
}