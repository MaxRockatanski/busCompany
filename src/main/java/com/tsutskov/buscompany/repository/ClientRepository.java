package com.tsutskov.buscompany.repository;

import com.tsutskov.buscompany.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    boolean existsByLoginIgnoreCase(String login);
}
