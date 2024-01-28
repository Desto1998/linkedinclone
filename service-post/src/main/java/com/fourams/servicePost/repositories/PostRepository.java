package com.fourams.servicePost.repositories;

import com.fourams.servicePost.Entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {
    public List <Post> findPostByProfileId(int profileId);
}
