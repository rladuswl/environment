package com.capstone.environment.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// 미션 Table
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content; // 내용
    private String image; // 이미지

    //@OneToMany(mappedBy = "mission", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "mission")
    private List<UserMission> missionFinishList = new ArrayList<>();
}
