package com.fourams.servicePost.Entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "profiles_posts_likes")
public class ProfilePostLike {
    @EmbeddedId
    private ProfilePostLikeId id;

}
