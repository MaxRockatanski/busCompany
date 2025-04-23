package com.tsutskov.buscompany.repository;

import com.tsutskov.buscompany.entity.Session;
import com.tsutskov.buscompany.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Long> {
    Optional<Session> findBySessionId(String sessionId);
    void deleteByUser(User user);
}
