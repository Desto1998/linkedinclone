package com.fourams.serviceProfile.services;

import com.fourams.serviceProfile.Errors.ResourceNotFoundException;
import com.fourams.serviceProfile.repositories.SkillRepository;
import com.fourams.serviceProfile.Entities.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;

    public List<Skill> getSkills(){
        return skillRepository.findAll();
    }
    public Skill addSkill(Skill skill){
        return skillRepository.save(skill);
    }

    public Skill getSkillById(int skillId){
        return skillRepository.findById(skillId).orElseThrow(()->new ResourceNotFoundException("Skill introuvable avec l'id: " + skillId));
    }

    public Skill updateSkill(int SkillId, Skill SkillDetail){
        Skill updateSkill = skillRepository.findById(SkillId).orElseThrow(()->new ResourceNotFoundException("Skill introuvable avec l'id: " + SkillId));
        updateSkill.setName(SkillDetail.getName());
        return skillRepository.save(updateSkill);
    }

    public Skill deleteSkill(int SkillId){
        Skill skill = skillRepository.findById(SkillId).orElseThrow(()->new ResourceNotFoundException("Skill introuvable avec l'id: " + SkillId));
        skillRepository.deleteById(SkillId);
        return skill;
    }
}
