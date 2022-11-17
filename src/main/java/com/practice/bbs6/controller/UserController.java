package com.practice.bbs6.controller;

import com.practice.bbs6.domain.dto.ResponseDto;
import com.practice.bbs6.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getUser(@PathVariable Long id) {
        ResponseDto responseDto = userService.get(id);
        return ResponseEntity.ok().body(responseDto);
    }
}
