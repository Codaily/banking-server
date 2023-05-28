package com.codaily.bankingserver.global.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ErrorResponse {


    @Schema(description = "errorStatus")
    private final String errorStatus;

    @Schema(description = "errorMessage")
    private final String errorMessage;
}
