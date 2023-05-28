package com.codaily.bankingserver.global.handler;

import com.codaily.bankingserver.global.statusCode.StatusCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomException extends RuntimeException {

    private final StatusCode statusCode;

}
