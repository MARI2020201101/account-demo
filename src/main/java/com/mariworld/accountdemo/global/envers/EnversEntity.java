package com.mariworld.accountdemo.global.envers;

import org.hibernate.envers.RevisionTimestamp;

import java.time.LocalDateTime;

public class EnversEntity {
    private Long sequence;

    @RevisionTimestamp
    private LocalDateTime modifiedAt;

}
