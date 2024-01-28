package com.fourams.serviceProfile.repositories;

import com.fourams.serviceProfile.Entities.ProfileSkill;
import com.fourams.serviceProfile.Entities.ProfileSkillID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileSkillRepository extends JpaRepository<ProfileSkill, ProfileSkillID> {
}
