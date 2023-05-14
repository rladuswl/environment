package com.capstone.environment.service;

import com.capstone.environment.domain.User;
import com.capstone.environment.dto.LoginJoinReq;
import com.capstone.environment.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final UserRepository userRepository;

    public String login(LoginJoinReq loginJoinReq) {

        User user = userRepository.findByNickname(loginJoinReq.getNickname());

        if (user == null) {
            return "존재하지 않는 사용자입니다.";
        }

        return user.getNickname();
    }

    public String join(LoginJoinReq loginJoinReq) {

        User user = User.builder()
                .nickname(loginJoinReq.getNickname())
                .password(loginJoinReq.getPassword()).build();

        userRepository.save(user);

        return "회원가입이 완료되었습니다.";
    }
}
