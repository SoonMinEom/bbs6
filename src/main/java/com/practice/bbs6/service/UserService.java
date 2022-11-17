package com.practice.bbs6.service;

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
}
