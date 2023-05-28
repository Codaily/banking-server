package com.codaily.bankingserver.global.statusCode;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum StatusCode {

    CONFLICT(HttpStatus.CONFLICT, "Duplicated data");

    private final HttpStatus httpStatus;

    private final String message;

}
