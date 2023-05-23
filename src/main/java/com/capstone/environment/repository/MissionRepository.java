package com.capstone.environment.repository;

import com.capstone.environment.domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {
    @Query(value = "SELECT * FROM brand order by RAND() limit 6",
            nativeQuery = true)
    List<Mission> findAll();
}
