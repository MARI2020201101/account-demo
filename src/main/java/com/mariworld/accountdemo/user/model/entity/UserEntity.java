package com.mariworld.accountdemo.user.model.entity;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="users")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sequence;
    private String id;
    private String pwd;
    private LocalDateTime createdAt = LocalDateTime.now();
}
