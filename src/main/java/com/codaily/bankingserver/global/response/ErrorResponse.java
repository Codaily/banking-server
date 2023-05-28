package com.codaily.bankingserver.global.response;

import com.codaily.bankingserver.global.statusCode.StatusCode;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ErrorResponse {


    @Schema(description = "errorStatus")
    private final StatusCode errorStatus;

    @Schema(description = "errorMessage")
    private final String errorMessage;
}
