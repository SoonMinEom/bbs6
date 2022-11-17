package com.practice.bbs6.domain.dto;

import lombok.Data;

@Data
public class ResponseDto {
    private Long id;
    private String username;
    private String password;

    public ResponseDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
