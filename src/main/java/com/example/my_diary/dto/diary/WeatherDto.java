package com.example.my_diary.dto.diary;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WeatherDto {
    private String sky;

    private double temperature;
}
