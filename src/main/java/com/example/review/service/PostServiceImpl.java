package com.example.review.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.review.model.Post;
import com.example.review.model.User;
import com.example.review.repo.PostRepo;
import com.example.review.repo.UserRepo;

@Service
public class PostServiceImpl implements PostService{
	@Autowired
    private PostRepo postRepo;
	
	public List<Post> getAllPosts(){
		return postRepo.findAll();
	}
	
	public void insert(Post post){
		postRepo.save(post);
	}
	
	public List<Post> findByUser(User user) {
		return postRepo.findByCreatorId(user.getId());
	}

	@Override
	public List<Post> findByUser(Optional<User> user) {
		return postRepo.findByCreatorId(user.get().getId());
	}
}
