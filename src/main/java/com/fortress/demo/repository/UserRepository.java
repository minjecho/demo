package com.fortress.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fortress.demo.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);
    List<User> findByUserId(String userId);
    List<User> findByUserDept(String userDept);
    List<User> findByUserJob(String userJob);
    List<User> findByUserName(String userName);
    void deleteByUserId(String userId);
}
