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
@Entity(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "profile_id", nullable = false)
    private int profileId;
    @NonNull
    private String title;
    @NonNull
    private String content;
    @Column(name = "creation_date", updatable = false, nullable = false)
    @CreationTimestamp
    private LocalDateTime creationDate;
}
