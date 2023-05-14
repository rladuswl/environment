package com.capstone.environment.controller;

import com.capstone.environment.service.TrashService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
public class TrashController {

    private final TrashService trashService;

    // 분리수거
    @PostMapping("/trash")
    public String trash(@RequestParam String word) {
        return trashService.trash(word);
    }
}
