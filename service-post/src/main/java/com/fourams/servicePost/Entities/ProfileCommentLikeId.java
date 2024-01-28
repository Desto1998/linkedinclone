package com.fourams.servicePost.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class ProfileCommentLikeId implements Serializable {
    @Column(name = "profile_id", nullable = false)
    private int profileId;
    @JoinColumn(name = "comment_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Comment comment;
}
