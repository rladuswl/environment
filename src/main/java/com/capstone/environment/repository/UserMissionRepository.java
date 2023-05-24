package com.capstone.environment.repository;

import com.capstone.environment.domain.Brand;
import com.capstone.environment.domain.UserMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
}
