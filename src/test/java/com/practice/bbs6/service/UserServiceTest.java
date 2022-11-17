package com.practice.bbs6.service;

import com.practice.bbs6.domain.dto.RequestDto;
import com.practice.bbs6.domain.dto.ResponseDto;
import com.practice.bbs6.domain.entity.User;
import com.practice.bbs6.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class UserServiceTest {

    // 스프링을 통해 DI 되는게 아니라 Mockito를 통해서 DI됨
    private UserRepository userRepository = Mockito.mock(UserRepository.class);

    private UserService userService;

    @BeforeEach
    void setUp() {
        // 스프링을 사용하지 않고 수동 DI하기
        userService = new UserService(userRepository);
    }

    @Test
    @DisplayName("등록 완료 메시지가 잘 출력되는지")
    void addTest() {
        Mockito.when(userRepository.save(any()))
                .thenReturn(new User(1L,"soonmin","1234"));

        ResponseDto responseDto = userService.add(new RequestDto("soonmint","1234"));
        assertEquals("등록 완료", responseDto.getNameCheckMessage());
        assertEquals("soonmin",responseDto.getUsername());
    }
}