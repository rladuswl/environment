package com.capstone.environment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hi")
    public String test() {
        return "<h1> 캡스톤1 <환킴이>팀 - 테스트 입니다! <h1>";
    }
}
