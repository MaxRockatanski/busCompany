package com.tsutskov.buscompany.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AdminRegistrationDTO {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private String patronymic;

    @NotBlank
    private String position;

    @NotBlank
    private String login;

    @NotBlank
    private String password;

}
