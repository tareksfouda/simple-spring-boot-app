package com.example.review.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.review.model.User;
import com.example.review.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
    private UserRepo userRepo;
	
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public User findById(long id) {
        return userRepo.getOne(id);
    }
    
    @Override
    public Optional<User> findByUsername(String name) {
        return userRepo.findByName(name);
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>)userRepo.findAll();
    }
    
    @Override
    public List<User> findByMajor(String major) {
        return userRepo.findByMajor(major);
    }
    
    @Override
    public User store(User user) {
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }
    
    @Override
    public User update(User user, long id) {
    	User currentUser = userRepo.getOne(id);
    	currentUser.setName(user.getName());
    	currentUser.setMajor(user.getMajor());
    	currentUser.setPassword(user.getPassword());
        return userRepo.save(currentUser);
    }
    
    @Override
    public void delete(long id) {
    	System.out.println("The ID to be deleted" + id);
        userRepo.deleteById(id);
    }
}
