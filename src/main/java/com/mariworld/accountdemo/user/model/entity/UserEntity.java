package com.mariworld.accountdemo.user.model.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="users")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sequence;
    private String id;
    private String pwd;
    private LocalDateTime createdAt = LocalDateTime.now();
}
