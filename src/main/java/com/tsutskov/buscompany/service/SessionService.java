package com.tsutskov.buscompany.service;

import com.tsutskov.buscompany.entity.Session;
import com.tsutskov.buscompany.entity.User;
import com.tsutskov.buscompany.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class SessionService {

    @Value("${user_idle_timeout}")
    private int idleTimeout;

    @Autowired
    private SessionRepository sessionRepo;

    public String createSession(User user) {
        Session session = new Session();
        session.setSessionId(UUID.randomUUID().toString());
        session.setUser(user);
        session.setExpirationTime(LocalDateTime.now().plusSeconds(idleTimeout));
        sessionRepo.save(session);
        return session.getSessionId();
    }

    public void invalidateSession(String sessionId) {
        sessionRepo.findBySessionId(sessionId)
                .ifPresent(session -> sessionRepo.delete(session));
    }
}
