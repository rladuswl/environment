package com.capstone.environment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CampaignDTO {
    private String image;
    private String introduce;
    private String title;
    private String url;
}
