package com.example.review.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.review.model.Post;
import com.example.review.model.User;

@Service
public interface PostService {
	public List<Post> getAllPosts();
	public void insert(Post  post);
	public List<Post> findByUser(Optional<User> optional);
}
