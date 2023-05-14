package com.capstone.environment.controller;

import com.capstone.environment.service.MissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
public class MissionController {

    private final MissionService missionService;

    @GetMapping("/mission")
    public String mission() {
        return missionService.mission();
    }
}
