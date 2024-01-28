package com.fourams.servicePost.services;

import com.fourams.servicePost.Errors.ResourceNotFoundException;
import com.fourams.servicePost.repositories.PostRepository;
import com.fourams.servicePost.Entities.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post newPost(Post post){
        return postRepository.save(post);
    }
    public List<Post> getPosts(){
        return postRepository.findAll();
    }
    public Post getPostById(int id){
        return postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post introuvable."));
    }

    public Post updatePost(int postId, Post postDetail){
        Post updatePost = postRepository.findById(postId).
                orElseThrow( ()-> new ResourceNotFoundException("Post introuvable ave l'id. " + postId));
        updatePost.setContent(postDetail.getContent());
        updatePost.setProfileId(postDetail.getProfileId());
        updatePost.setTitle(postDetail.getTitle());

        return postRepository.save(updatePost);
    }
    public Post deletePost(int postId) {
        Post post= postRepository.findById(postId).
                orElseThrow( () -> new ResourceNotFoundException("Post introuvable"));
        postRepository.deleteById(postId);
        return post;
    }
    public List<Post> profilePosts(int profileId){
        return postRepository.findPostByProfileId(profileId);
    }

}
