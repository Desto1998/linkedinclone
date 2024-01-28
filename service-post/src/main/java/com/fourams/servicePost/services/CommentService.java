package com.fourams.servicePost.services;

import com.fourams.servicePost.Errors.ResourceNotFoundException;
import com.fourams.servicePost.repositories.CommentRepository;
import com.fourams.servicePost.Entities.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment newComment(Comment comment){
        return commentRepository.save(comment);
    }
    public List<Comment> getComments(){
        return commentRepository.findAll();
    }
    public Comment getCommentById(int id){
        return commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment not found."));
    }

    public Comment updateComment(int commentId, Comment commentDetail){
        Comment updateComment = commentRepository.findById(commentId).
                orElseThrow( ()-> new ResourceNotFoundException("Comment not exist with id. " + commentId));
        updateComment.setComment(commentDetail.getComment());
        updateComment.setPost(commentDetail.getPost());
        updateComment.setContent(commentDetail.getContent());
        updateComment.setProfileId(commentDetail.getProfileId());

        return commentRepository.save(updateComment);
    }
    public Comment deleteComment(int commentId) {
        Comment comment= commentRepository.findById(commentId).
                orElseThrow( () -> new ResourceNotFoundException("Comment not found"));
        commentRepository.deleteById(commentId);
        return comment;
    }

}
