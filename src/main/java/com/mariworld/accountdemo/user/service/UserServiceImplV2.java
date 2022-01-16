package com.mariworld.accountdemo.user.service;

import com.mariworld.accountdemo.common.CustomCode;
import com.mariworld.accountdemo.common.exception.CustomException;
import com.mariworld.accountdemo.user.helper.PasswordEncoder;
import com.mariworld.accountdemo.user.helper.TokenGenerator;
import com.mariworld.accountdemo.user.model.dto.UserRequest;
import com.mariworld.accountdemo.user.model.dto.UserResponse;
import com.mariworld.accountdemo.user.model.entity.UserEntity;
import com.mariworld.accountdemo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UserServiceImplV2 implements UserService{

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final TokenGenerator tokenGenerator;


    @Override
    public UserResponse signin(UserRequest userRequest) {
        String id = userRequest.getId();
        String pwd = userRequest.getPwd();
        Optional<UserEntity> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()) throw new CustomException(CustomCode.ALREADY_EXIST_USER);

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

        if(! findedEntity.isPresent()) throw new CustomException(CustomCode.NON_EXIST_USER);

        UserEntity userEntity = findedEntity.get();
        boolean matches = passwordEncoder.matches(userRequest.getPwd(), userEntity.getPwd());

        if(! matches) throw new CustomException(CustomCode.NON_MATCH_PASSWORD);

        UserResponse userResponse = new UserResponse(userEntity);
        userResponse.setToken(tokenGenerator.generateToken(userRequest.getId()));
        return userResponse;
    }
}
