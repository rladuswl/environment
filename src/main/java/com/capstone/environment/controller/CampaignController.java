package com.capstone.environment.controller;

import com.capstone.environment.dto.CampaignDTO;
import com.capstone.environment.service.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
public class CampaignController {

    private final CampaignService campaignService;

    @GetMapping("/campaign")
    public ArrayList<CampaignDTO> campaign() {
        return campaignService.campaign();
    }
}
