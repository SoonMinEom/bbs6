package com.practice.bbs6.domain.dto;

import com.practice.bbs6.domain.entity.User;
import lombok.Data;
import lombok.Getter;

@Data
public class RequestDto {
    private String username;
    private String password;

    public User toEntity(){
        return new User(this.username, this.password);
    }
}
