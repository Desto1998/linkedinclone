package com.fourams.servicePost.repositories;

import com.fourams.servicePost.Entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
