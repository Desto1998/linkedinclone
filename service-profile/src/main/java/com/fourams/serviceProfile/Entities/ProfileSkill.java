package com.fourams.serviceProfile.Entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "profiles_skills")
public class ProfileSkill {
    @EmbeddedId
    private ProfileSkillID id;


}
