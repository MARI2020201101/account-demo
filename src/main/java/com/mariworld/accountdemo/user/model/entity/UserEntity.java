package com.mariworld.accountdemo.user.model.entity;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
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

    @CreatedDate
    private LocalDateTime createdAt;
//
//    @PrePersist
//    private void setCreatedAt(){
//        createdAt = LocalDateTime.now();
//    }
}
