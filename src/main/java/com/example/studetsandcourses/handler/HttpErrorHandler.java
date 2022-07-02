package com.example.studetsandcourses.handler;


import com.example.studetsandcourses.dto.HttpErrorDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class HttpErrorHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<HttpErrorDTO> handle(ResponseStatusException ex) {
        return ResponseEntity
                .status(ex.getStatus())
                .body(
                        HttpErrorDTO.builder()
                                .status(ex.getStatus())
                                .message(ex.getReason())
                                .build()
                );
    }
}