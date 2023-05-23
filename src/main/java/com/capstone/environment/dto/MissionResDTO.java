package com.capstone.environment.dto;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissionResDTO {
    private String content;
    private String image;
    private String finish; // 완료 여부
}
