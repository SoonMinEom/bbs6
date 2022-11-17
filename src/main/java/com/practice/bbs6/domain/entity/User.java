package com.practice.bbs6.domain.entity;

import com.practice.bbs6.domain.dto.ResponseDto;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table (name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    public static ResponseDto toDto(User user) {
        return new ResponseDto(user.getUsername(), user.getPassword());
    }
}
