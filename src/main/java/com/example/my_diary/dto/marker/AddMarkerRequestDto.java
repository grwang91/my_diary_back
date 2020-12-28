package com.example.my_diary.dto.marker;

import com.example.my_diary.domain.marker.Marker;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddMarkerRequestDto {

    private String placeName;

    private String placeContent;

    private Double lat;

    private Double lng;

    public Marker toEntity() {
        return Marker.builder()
                .placeName(placeName)
                .placeContent(placeContent)
                .lat(lat)
                .lng(lng)
                .build();

    }
}
