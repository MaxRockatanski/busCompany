package com.tsutskov.buscompany.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Session {

    @Id
    private String sessionId;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(updatable = false)
    private LocalDateTime creationTime;

    private LocalDateTime expirationTime;
}
