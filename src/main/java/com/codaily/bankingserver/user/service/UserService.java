package com.codaily.bankingserver.user.service;

import com.codaily.bankingserver.global.handler.CustomException;
import com.codaily.bankingserver.global.statusCode.StatusCode;
import com.codaily.bankingserver.user.domain.User;
import com.codaily.bankingserver.user.dto.JoinRequestDto;
import com.codaily.bankingserver.user.repository.UserRepository;
import com.codaily.bankingserver.user.vo.JoinResponseVo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Getter
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public JoinResponseVo join(JoinRequestDto joinRequestDto) {
        duplicateEmail(joinRequestDto.getEmail());
        userRepository.save(joinRequestDto.toEntity());
        return new JoinResponseVo();
    }

    private void duplicateEmail(String email) {
        userRepository.findByEmail(email).ifPresent(u -> {
            throw new CustomException(StatusCode.CONFLICT);
        });
    }
}
