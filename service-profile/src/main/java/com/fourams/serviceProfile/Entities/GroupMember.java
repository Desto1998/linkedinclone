package com.fourams.serviceProfile.Entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "groups_members")
public class GroupMember {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @EmbeddedId
    private GroupMemberID id;
    private String status;

}
