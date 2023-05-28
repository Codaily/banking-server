package com.codaily.bankingserver.user.dto;

import com.codaily.bankingserver.user.domain.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Schema(description = "회원가입 Request")
public class JoinRequestDto {
    @NotBlank(message = "이메일을 입력해주세요")
    @Email(message = "이메일 양식 오류")
    @Schema(description = "이메일")
    private String email;

    @NotBlank(message = "이메일을 입력해주세요")
    @Schema(description = "패스워드")
    private String password;

    @NotBlank(message = "이름을 입력해주세요")
    @Schema(description = "이름")
    private String username;

    @NotBlank(message = "전화번호를 입력해주세요")
    @Schema(description = "전화번호")
    private String phoneNumber;


    @Builder
    public JoinRequestDto(String email, String password, String username, String phoneNumber) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public User toEntity(){
        return User.builder()
                .email(email)
                .password(password)
                .phoneNumber(phoneNumber)
                .username(username)
                .build();
    }
}