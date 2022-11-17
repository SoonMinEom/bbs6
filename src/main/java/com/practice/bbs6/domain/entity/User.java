package com.practice.bbs6.domain.entity;

import com.practice.bbs6.domain.dto.ResponseDto;
import lombok.Getter;

import javax.persistence.Entity;

@Entity
@Getter
public class User {
    private Long id;
    private String username;
    private String password;

    public static ResponseDto toDto(User user) {
        return new ResponseDto(user.getUsername(), user.getPassword());
    }
}
