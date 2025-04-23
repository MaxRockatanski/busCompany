package com.tsutskov.buscompany.repository;

import com.tsutskov.buscompany.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    boolean existsByLoginIgnoreCase(String login);
}
