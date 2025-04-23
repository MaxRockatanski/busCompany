package com.tsutskov.buscompany.exception;

import com.tsutskov.buscompany.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("errors", ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ErrorResponse(error.getCode(), error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList()));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, Object>> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("errors", Collections.singletonList(new ErrorResponse("INVALID_JSON", "request", "Invalid JSON format")));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
