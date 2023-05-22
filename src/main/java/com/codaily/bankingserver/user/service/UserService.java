package com.codaily.bankingserver.user.service;

import com.codaily.bankingserver.user.domain.User;
import com.codaily.bankingserver.user.dto.JoinRequestDto;
import com.codaily.bankingserver.user.repository.UserRepository;
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

    public User join(JoinRequestDto joinRequestDto) {
        String email = joinRequestDto.getEmail();
//        userRepository.findByEmail(email).ifPresent(u -> {
//            throw new CustomException(ErrorCode.CONFLICT);
//        });
        // 닉네임 중복 확인
        User user = joinRequestDto.toEntity();
        userRepository.save(user);
        return user;
    }
}
