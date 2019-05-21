package com.example.review.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.review.model.Post;
import com.example.review.model.User;
import com.example.review.service.PostService;
import com.example.review.service.UserService;

@RestController
public class BlogController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value="/test")
	public String index() {
		return "index";
	}
	
	@GetMapping(value="/posts")
	public List<Post> posts() {
		return postService.getAllPosts();
	}
	
	@PostMapping(value="/posts")
	public void posts(@RequestBody Post post) {
		org.springframework.security.core.userdetails.User userDetails = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		post.setCreator(userService.findByUsername(userDetails.getUsername()).get());
		System.out.println("TATA" +userDetails.getUsername());
		post.setDateCreated(new Date());
		postService.insert(post);
	}
	
	@GetMapping(value="/posts/{username}")
	public List<Post> postsByUser(@PathVariable String username) {
		return postService.findByUser(userService.findByUsername(username));
	}
}
