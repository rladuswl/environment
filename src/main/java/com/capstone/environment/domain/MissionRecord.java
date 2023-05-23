package com.capstone.environment.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// 미션 인증글 Table
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MissionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content; // 내용
    private String image; // 이미지
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
