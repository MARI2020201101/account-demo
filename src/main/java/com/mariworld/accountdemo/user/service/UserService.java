package com.mariworld.accountdemo.user.service;

import com.mariworld.accountdemo.user.dto.UserDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<UserDTO> signin(UserDTO userDTO);
}
