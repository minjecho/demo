package com.fortress.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fortress.demo.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findById(String id);
    List<User> findById2(String id);
    List<User> findByDept(String dept);
    List<User> findByJob(String job);
    List<User> findByName(String name);
    void deleteById(String user_id);
}
