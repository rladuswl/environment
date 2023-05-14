package com.capstone.environment.repository;

import com.capstone.environment.domain.Trash;
import com.capstone.environment.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByNickname(String nickname);


}
