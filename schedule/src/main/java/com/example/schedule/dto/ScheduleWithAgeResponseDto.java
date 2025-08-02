package com.example.schedule.dto;

import com.example.schedule.entity.Schedule;
import lombok.Getter;


@Getter
public class ScheduleWithAgeResponseDto {

    private final String title;

    private final String contents;

    private final Integer age;

    public ScheduleWithAgeResponseDto(String title, String contents, Integer age) {
        this.title = title;
        this.contents = contents;
        this.age = age;
    }

}