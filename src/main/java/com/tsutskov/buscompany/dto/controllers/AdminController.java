package com.tsutskov.buscompany.dto.controllers;

import com.tsutskov.buscompany.dto.AdminRegistrationDTO;
import com.tsutskov.buscompany.dto.response.UserResponse;
import com.tsutskov.buscompany.entity.Admin;
import com.tsutskov.buscompany.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AdminController {

    private final AdminService adminService;


    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/admins")
    public ResponseEntity<Object> registerAdmin(@Valid @RequestBody AdminRegistrationDTO adminRegistrationDTO) {
        return adminService.createAdmin(adminRegistrationDTO);
    }
}
