package com.codaily.bankingserver.user.controller;


import com.codaily.bankingserver.global.response.ErrorResponse;
import com.codaily.bankingserver.user.dto.JoinRequestDto;
import com.codaily.bankingserver.user.vo.JoinResponseVo;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @PostMapping({ "/join" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "회원가입 성공", content = @Content(schema = @Schema(implementation = JoinResponseVo.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근", content = @Content(schema = @Schema(implementation = ErrorResponse.class))) })
    @Operation(summary = "회원 가입", description = "id와 password를 통해 회원가입을 진행합니다.")
    @Parameter(name="str")

    public JoinResponseVo join(@Valid @RequestBody final JoinRequestDto requestDto) {
        return userService.join(requestDto);
    }
}
