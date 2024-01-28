package com.fourams.servicePost.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "profile_id", nullable = false)
    private int profileId;
    @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Post post;
    @NonNull
    private String content;
    @Column(name = "creation_date", updatable = false)
    @CreationTimestamp
    private LocalDateTime creationDate;
    @JoinColumn(name = "comment_id", referencedColumnName = "id", nullable = true)
    @ManyToOne(optional = true)
    private Comment comment;
}
