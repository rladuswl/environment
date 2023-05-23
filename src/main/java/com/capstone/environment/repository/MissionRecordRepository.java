package com.capstone.environment.repository;

import com.capstone.environment.domain.MissionRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MissionRecordRepository extends JpaRepository<MissionRecord, Long> {
}
