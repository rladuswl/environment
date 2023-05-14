package com.capstone.environment.repository;

import com.capstone.environment.domain.Brand;
import com.capstone.environment.domain.Trash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrashRepository extends JpaRepository<Trash, Long> {
    @Query(value = "SELECT * FROM trash WHERE name LIKE %:word%",nativeQuery = true)
    List<Trash> findAll(@Param("word") String word);
}
