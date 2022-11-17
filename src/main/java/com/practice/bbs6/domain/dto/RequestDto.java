package com.practice.bbs6.domain.dto;

import com.practice.bbs6.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class RequestDto {
    private String username;
    private String password;

    public User toEntity(){
        return new User(this.username, this.password);
    }
}
