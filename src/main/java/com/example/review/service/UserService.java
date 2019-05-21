package com.example.review.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.review.model.User;

@Service
public interface UserService {
	User findById(long id);
	
	Optional<User> findByUsername(String name);

    List<User> findByMajor(String major);
    
    List<User> findAllUsers();
    
    User store(User user);
    
    User update(User user, long id);
    
    void delete(long id);
}
