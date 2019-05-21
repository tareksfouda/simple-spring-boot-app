package com.example.review.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.review.model.Post;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {

	List<Post> findByCreatorId(long id);

}
