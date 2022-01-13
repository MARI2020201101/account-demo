package com.mariworld.accountdemo.user.entity;


import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="users")
@Builder
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sequence;
    private String id;
    private String pwd;
    private LocalDateTime createdAt = LocalDateTime.now();
}
