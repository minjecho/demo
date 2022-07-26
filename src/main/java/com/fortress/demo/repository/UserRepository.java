package com.fortress.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fortress.demo.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findById(String Id);
    List<User> findByDept(String dept);
    List<User> findByJob(String job);
    List<User> findByName(String name);
}
