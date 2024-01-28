package com.fourams.serviceProfile.Entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity( name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @JoinColumn(name = "profile_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Profile profile;
    @NonNull
    private String name;
    @NonNull
    private String description;

}
