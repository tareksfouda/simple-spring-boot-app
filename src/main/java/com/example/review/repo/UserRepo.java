package com.example.review.repo;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.review.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	Optional<User> findByName(String username);
	List<User> findByMajor(String major);
}
