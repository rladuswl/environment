package com.capstone.environment.repository;

import com.capstone.environment.domain.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {
    @Query(value = "SELECT * FROM campaign order by RAND() limit 5",nativeQuery = true)
    List<Campaign> findAll();
}
