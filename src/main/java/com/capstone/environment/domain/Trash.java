package com.capstone.environment.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// 분리수거 Table
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Trash {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; // 이름
    private String item; // 품목
}
