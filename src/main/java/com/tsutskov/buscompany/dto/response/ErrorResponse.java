package com.tsutskov.buscompany.dto.response;

import lombok.Data;

@Data
public class ErrorResponse {

    private String errorCode;
    private String field;
    private String message;

    public ErrorResponse(String errorCode, String field, String message) {
        this.errorCode = errorCode;
        this.field = field;
        this.message = message;
    }
}
