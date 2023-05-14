package com.capstone.environment.domain;

import lombok.*;

import javax.persistence.*;

// 환킴이 기록 Table
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title; // 제목
    private String content; // 내용
    private String image; // 이미지
}
