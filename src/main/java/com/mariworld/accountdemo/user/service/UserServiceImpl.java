package com.mariworld.accountdemo.user.service;

import com.mariworld.accountdemo.user.dto.UserDTO;
import com.mariworld.accountdemo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    @Override
    public ResponseEntity<UserDTO> signin(UserDTO userDTO) {

        return null;
    }
}
