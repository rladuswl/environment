package com.capstone.environment.repository;

import com.capstone.environment.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    @Query(value = "SELECT * FROM brand order by RAND() limit 5",nativeQuery = true)
    List<Brand> findAll();
}
