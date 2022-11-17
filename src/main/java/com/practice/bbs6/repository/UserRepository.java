package com.practice.bbs6.repository;
import com.practice.bbs6.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
}
