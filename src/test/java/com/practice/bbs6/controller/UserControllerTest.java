package com.practice.bbs6.controller;

import com.practice.bbs6.domain.dto.ResponseDto;
import com.practice.bbs6.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Test
    @DisplayName("유저 정보가 잘 받아와 지는지")
    void getUser() throws Exception {
        ResponseDto responseDto = new ResponseDto("soonmin","1234");
        given(userService.get(1L)).willReturn(responseDto);

        Long id = 1L;
        String url = String.format("/api/v1/users/%d",id);
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").exists())
                .andExpect(jsonPath("$.username").value("soonmin"))
                .andExpect(jsonPath("$.password").exists())
                .andExpect(jsonPath("$.password").value("1234"))
                .andDo(print());

        verify(userService).get(1L);

    }
}