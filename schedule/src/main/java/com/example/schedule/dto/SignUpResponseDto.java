package com.example.schedule.dto;

import lombok.Getter;

@Getter
public class SignUpResponseDto {

    private final String username;

    private final String password;

    private final Integer age;

    public SignUpResponseDto(String username, String password, Integer age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }
}
