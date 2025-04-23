package com.tsutskov.buscompany.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank
    @Size(max = 50)
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Size(max = 50)
    @Column(name = "patronymic")
    private String patronymic;

    @NotBlank
    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @NotBlank
    @Size(min = 8)
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "user_type", nullable = false)
    private UserType userType;
}
