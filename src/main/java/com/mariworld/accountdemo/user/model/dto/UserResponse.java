package com.mariworld.accountdemo.user.model.dto;

import com.mariworld.accountdemo.user.model.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private String id;
    private String pwd;
    private LocalDateTime createdAt;

    public UserResponse(UserEntity userEntity){
        this.id = userEntity.getId();
        this.pwd = userEntity.getPwd();
        this.createdAt = userEntity.getCreatedAt();
    }
}
