package com.codaily.bankingserver.user.dto;

import com.codaily.bankingserver.user.domain.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class JoinRequestDto {
    @NotBlank(message = "이메일을 입력해주세요")
    @Email(message = "이메일 양식 오류")
    private String email;

    @NotBlank(message = "이메일을 입력해주세요")
    private String password;

    @NotBlank(message = "이름을 입력해주세요")
    private String username;

    @NotBlank(message = "전화번호를 입력해주세요")
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