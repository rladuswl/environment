package com.capstone.environment.controller;

import com.capstone.environment.dto.LoginJoinReq;
import com.capstone.environment.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    // 홈 화면
    @GetMapping("/home")
    public String home() {
        return null;
    }

    // 로그인
    @PostMapping("/login")
    public String login(@RequestBody LoginJoinReq loginJoinReq) {

        return homeService.login(loginJoinReq);
    }

    // 회원가입
    @PostMapping("/join")
    public String join(@RequestBody LoginJoinReq loginJoinReq) {
        return homeService.join(loginJoinReq);
    }
}
