package com.example.db22.repository;

import com.example.db22.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> getTop10Posts();
}
