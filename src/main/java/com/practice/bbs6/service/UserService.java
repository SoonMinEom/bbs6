package com.practice.bbs6.service;

import com.practice.bbs6.domain.dto.RequestDto;
import com.practice.bbs6.domain.dto.ResponseDto;
import com.practice.bbs6.domain.entity.User;
import com.practice.bbs6.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseDto get(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        ResponseDto responseDto = User.toDto(optionalUser.get());
        return responseDto;
    }

    public ResponseDto add(RequestDto requestDto){

        ResponseDto responseDto;

        if(userRepository.findByUsername(requestDto.getUsername()).isEmpty()) {
            User newUser = userRepository.save(requestDto.toEntity());
            responseDto = User.toDto(newUser);
        } else {
            responseDto = new ResponseDto(requestDto.getUsername(),requestDto.getPassword());
            responseDto.setNameCheckMessage("해당 username은 이미 존재 합니다.");
        }
        return responseDto;
    }
}
