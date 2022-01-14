package com.mariworld.accountdemo.user.service;

import com.mariworld.accountdemo.user.model.dto.UserRequest;
import com.mariworld.accountdemo.user.model.dto.UserResponse;
import com.mariworld.accountdemo.user.model.entity.UserEntity;
import com.mariworld.accountdemo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    @Override
    public UserResponse signin(UserRequest userRequest) {
        String id = userRequest.getId();
        String pwd = userRequest.getPwd();
        Optional<UserEntity> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()) throw new RuntimeException("already exist user id");

        UserEntity userEntity = UserEntity.builder()
                .id(id)
                .pwd(passwordEncoder.encode(pwd))
                .build();
        UserEntity savedUser = userRepository.save(userEntity);

        return new UserResponse(savedUser);
    }

    @Override
    public UserResponse signup(UserRequest userRequest) {
        Optional<UserEntity> findedEntity = userRepository.findById(userRequest.getId());

        if(! findedEntity.isPresent()) throw new RuntimeException("non exist user");

        UserEntity userEntity = findedEntity.get();
        boolean matches = passwordEncoder.matches(userRequest.getPwd(), userEntity.getPwd());

        if(! matches) throw new RuntimeException("non match password");

        return new UserResponse(userEntity);
    }

    @Override
    public UserResponse signinV2(UserRequest userRequest) {
        String id = userRequest.getId();
        String pwd = userRequest.getPwd();
        Optional<UserEntity> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()) throw new RuntimeException("already exist user id");

        UserEntity userEntity = UserEntity.builder()
                .id(id)
                .pwd(passwordEncoder.encode(pwd))
                .build();
        UserEntity savedUser = userRepository.save(userEntity);

        return new UserResponse(savedUser);
    }

    @Override
    public UserResponse signupV2(UserRequest userRequest) {
        return null;
    }
}
