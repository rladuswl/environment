package com.capstone.environment.controller;

import com.capstone.environment.domain.Brand;
import com.capstone.environment.dto.BrandDTO;
import com.capstone.environment.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
public class BrandController {

    private final BrandService brandService;

    @GetMapping("/brand")
    public ArrayList<BrandDTO> brand() {
        return brandService.brand();
    }
}
