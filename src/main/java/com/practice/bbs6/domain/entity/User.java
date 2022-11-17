package com.practice.bbs6.domain.entity;

import com.practice.bbs6.domain.dto.ResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;

import javax.persistence.*;

@Entity
@Getter
@Table (name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static ResponseDto toDto(User user) {
        return new ResponseDto(user.getUsername(), user.getPassword());
    }


}
