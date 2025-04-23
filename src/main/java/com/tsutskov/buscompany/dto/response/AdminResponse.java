package com.tsutskov.buscompany.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AdminResponse extends UserResponse{

    private String position;

    public AdminResponse(int id, String firstName, String lastName,
                         String patronymic, String userType, String position) {
        super(id, firstName, lastName, patronymic, userType);
        this.position = position;
    }
}
