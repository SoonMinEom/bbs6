package com.practice.bbs6.controller;

import com.practice.bbs6.domain.dto.RequestDto;
import com.practice.bbs6.domain.dto.ResponseDto;
import com.practice.bbs6.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getUser(@PathVariable Long id) {
        ResponseDto responseDto = userService.get(id);
        return ResponseEntity.ok().body(responseDto);
    }

    @PostMapping
    public ResponseEntity<ResponseDto> addUser(@RequestBody RequestDto requestDto) {
        ResponseDto responseDto = userService.add(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }
}
