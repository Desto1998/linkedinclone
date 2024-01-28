package com.fourams.servicePost.Entities;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "profiles_comments_likes")
public class ProfileCommentLike {
    @EmbeddedId
    private ProfileCommentLikeId id;

}
