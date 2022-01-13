package com.mariworld.accountdemo.user.dto;

import com.mariworld.accountdemo.common.Converter;
import com.mariworld.accountdemo.user.entity.UserEntity;
import lombok.Data;

@Data
public class UserDTO implements Converter {
    
    private final String id;
    private final String pwd;
    
    
    @Override
    public <UserEntity, UserDTO> UserEntity convertTo(UserDTO userDTO) {
        return UserEntity.builder()
                .id(userDTO.getId())
                .pwd(userDTO.getPwd())
                .build();
    }
}
