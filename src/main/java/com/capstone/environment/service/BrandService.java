package com.capstone.environment.service;

import com.capstone.environment.domain.Brand;
import com.capstone.environment.dto.BrandDTO;
import com.capstone.environment.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;

    public ArrayList<BrandDTO> brand() {
        List<Brand> brandList = brandRepository.findAll();

        ArrayList<BrandDTO> brandDtoList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            BrandDTO brandDTO = BrandDTO.builder()
                    .image(brandList.get(i).getImage())
                    .introduce(brandList.get(i).getIntroduce())
                    .title(brandList.get(i).getTitle())
                    .url(brandList.get(i).getUrl()).build();
            brandDtoList.add(brandDTO);
        }

        //System.out.println(brandDtoList);
        return brandDtoList;
    }
}
