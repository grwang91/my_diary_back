package com.example.my_diary.dto.marker;

import com.example.my_diary.domain.marker.Marker;
import lombok.Getter;

@Getter
public class MarkerListResponseDto {
    private Long id;

    private String placeName;

    private String placeContent;

    private Double lat;

    private Double lng;

    public MarkerListResponseDto(Marker entity) {
        this.id = entity.getId();
        this.placeName = entity.getPlaceName();
        this.placeContent = entity.getPlaceContent();
        this.lat = entity.getLat();
        this.lng = entity.getLng();
    }
}
