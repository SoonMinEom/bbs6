package com.practice.bbs6.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.bbs6.domain.dto.RequestDto;
import com.practice.bbs6.domain.dto.ResponseDto;
import com.practice.bbs6.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserRestController.class)
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    UserService userService;

    @Test
    @DisplayName("유저 정보가 잘 조회 되는지")
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

    @Test
    @DisplayName("유저 정보가 잘 등록 되는지")
    void addUser() throws Exception {
        RequestDto requestDto = new RequestDto("soonmin","1234");
        ResponseDto responseDto = new ResponseDto("soonmin","1234");
        responseDto.setNameCheckMessage("등록 완료");

        given(userService.add(requestDto)).willReturn(responseDto);

        mockMvc.perform(post("/api/v1/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(requestDto))
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").exists())
                .andExpect(jsonPath("$.username").value("soonmin"))
                .andExpect(jsonPath("$.password").exists())
                .andExpect(jsonPath("$.password").value("1234"))
                .andExpect(jsonPath("$.nameCheckMessage").exists())
                .andExpect(jsonPath("$.nameCheckMessage").value("등록 완료"))
                .andDo(print());

        verify(userService).add(requestDto);

    }
}