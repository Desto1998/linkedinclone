package com.fourams.servicePost.controllers;

import com.fourams.servicePost.Entities.Post;
import com.fourams.servicePost.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(value = "/posts")
@RestController
public class PostController {
    @Autowired
    private PostService postService;
    @GetMapping
    public List<Post> getPosts(){
        return  postService.getPosts();
    }
    @PostMapping
    public Post newPost(@RequestBody Post post){
        return postService.newPost(post);
    }
    @GetMapping("/{id}")
    public Post getPostById(@PathVariable int id){
        return postService.getPostById(id);
    }

    @PutMapping("/{id}")
    public Post updatePostById(@PathVariable int id, @RequestBody Post post){
        return postService.updatePost(id,post);
    }

    @DeleteMapping("/{id}")
    public Post deletePostById(@PathVariable int id){
        return postService.deletePost(id);
    }

    @GetMapping("/profile")
    public List<Post> profilePosts(){
        return  postService.getPosts();
    }
}
