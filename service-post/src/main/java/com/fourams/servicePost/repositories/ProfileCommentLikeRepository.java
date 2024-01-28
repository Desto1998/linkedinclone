package com.fourams.servicePost.repositories;

import com.fourams.servicePost.Entities.ProfileCommentLike;
import com.fourams.servicePost.Entities.ProfileCommentLikeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileCommentLikeRepository extends JpaRepository<ProfileCommentLike, ProfileCommentLikeId> {
}
