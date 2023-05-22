package com.codaily.bankingserver.user.controller;

import com.codaily.bankingserver.user.dto.JoinRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codaily.bankingserver.user.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "회원 API", description = "Swagger 테스트용 API")
@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @Operation(summary = "회원 가입")
    @Parameter(name="str")
    @PostMapping({ "/join" })
//    public SuccessResponse join(@Valid @RequestBody final JoinRequestDto requestDto) {
//        userService.join(requestDto);
//        SuccessResponse res = SuccessResponse.builder()
//                .status(StatusEnum.OK)
//                .message("Success Join")
//                .build();
//        return res;
//    }
    public JoinRequestDto join(@Valid @RequestBody final JoinRequestDto requestDto) {
        userService.join(requestDto);
//        SuccessResponse res = SuccessResponse.builder()
//                .status(StatusEnum.OK)
//                .message("Success Join")
//                .build();
        return requestDto;
    }
}
