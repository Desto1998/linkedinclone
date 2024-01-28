package com.fourams.serviceProfile.repositories;

import com.fourams.serviceProfile.Entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
}
