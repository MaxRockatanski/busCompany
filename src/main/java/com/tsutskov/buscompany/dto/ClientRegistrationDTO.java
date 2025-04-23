package com.tsutskov.buscompany.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ClientRegistrationDTO {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private String patronymic;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "^(\\+7|8)[0-9]{10}$")
    private String phone;

    @NotBlank
    private String password;

}
