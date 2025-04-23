package com.tsutskov.buscompany.service;

import com.tsutskov.buscompany.dto.AdminRegistrationDTO;
import com.tsutskov.buscompany.dto.response.AdminResponse;
import com.tsutskov.buscompany.dto.response.ErrorResponse;
import com.tsutskov.buscompany.dto.response.UserResponse;
import com.tsutskov.buscompany.entity.Admin;
import com.tsutskov.buscompany.entity.UserType;
import com.tsutskov.buscompany.mappers.AdminMapper;
import com.tsutskov.buscompany.repository.AdminRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    private final AdminMapper adminMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AdminService(AdminMapper adminMapper, AdminRepository adminRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.adminMapper = adminMapper;
        this.adminRepository = adminRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public ResponseEntity<Object> createAdmin(AdminRegistrationDTO adminRegistrationDTO) {
        if (adminRepository.existsByLoginIgnoreCase(adminRegistrationDTO.getLogin())) {
            return ResponseEntity.badRequest().body(new ErrorResponse("LOGIN_ALREADY_EXISTS", "login", "User already exists"));
        }
        Admin admin = adminMapper.toAdmin(adminRegistrationDTO);
        admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
        admin.setUserType(UserType.ADMIN);
        Admin savedAdmin = adminRepository.save(admin);

        AdminResponse response = adminMapper.toUserResponse(savedAdmin);
        return ResponseEntity.ok(response);
    }
}
