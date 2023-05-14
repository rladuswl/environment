package com.capstone.environment.service;

import com.capstone.environment.domain.Campaign;
import com.capstone.environment.dto.CampaignDTO;
import com.capstone.environment.repository.CampaignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CampaignService {

    private final CampaignRepository campaignRepository;

    public ArrayList<CampaignDTO> campaign() {
        List<Campaign> campaignList = campaignRepository.findAll();

        ArrayList<CampaignDTO> campaignDtoList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            CampaignDTO brandDTO = CampaignDTO.builder()
                    .image(campaignList.get(i).getImage())
                    .introduce(campaignList.get(i).getIntroduce())
                    .title(campaignList.get(i).getTitle())
                    .url(campaignList.get(i).getUrl()).build();
            campaignDtoList.add(brandDTO);
        }

        //System.out.println(campaignDtoList);
        return campaignDtoList;
    }
}
