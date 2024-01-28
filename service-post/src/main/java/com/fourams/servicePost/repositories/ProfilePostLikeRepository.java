package com.fourams.servicePost.repositories;

import com.fourams.servicePost.Entities.ProfilePostLike;
import com.fourams.servicePost.Entities.ProfilePostLikeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfilePostLikeRepository extends JpaRepository<ProfilePostLike, ProfilePostLikeId> {
}
