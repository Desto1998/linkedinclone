package com.fourams.servicePost.controllers;

import com.fourams.servicePost.Entities.Comment;
import com.fourams.servicePost.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(value = "/posts/comments")
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<Comment> getComments(){
        return  commentService.getComments();
    }

    @PostMapping
    public Comment newComment(@RequestBody Comment comment){
        return commentService.newComment(comment);
    }

    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable int id){
        return commentService.getCommentById(id);
    }

    @PutMapping("/{id}")
    public Comment updateCommentById(@PathVariable int id, @RequestBody Comment comment){
        return commentService.updateComment(id,comment);
    }

    @DeleteMapping("/{id}")
    public Comment deleteCommentById(@PathVariable int id){
        return commentService.deleteComment(id);
    }
}
