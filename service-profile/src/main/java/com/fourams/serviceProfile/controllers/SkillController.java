package com.fourams.serviceProfile.controllers;

import com.fourams.serviceProfile.Entities.Skill;
import com.fourams.serviceProfile.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/profiles/skills")
@RestController
public class SkillController {
    @Autowired
    private SkillService skillService;

    @PostMapping
    public Skill newSkill(@RequestBody Skill skill){
        return skillService.addSkill(skill);
    }

    @GetMapping
    public List<Skill> getSkills(){
        return  skillService.getSkills();
    }

    @GetMapping("/{id}")
    public Skill getSkillById(@PathVariable int id){
        return skillService.getSkillById(id);
    }

    @PutMapping("/{id}")
    public Skill updateSkillById(@PathVariable int id, @RequestBody Skill skill){
        return skillService.updateSkill(id,skill);
    }
    @DeleteMapping("/{id}")
    public Skill deleteSkillById(@PathVariable int id){
        return skillService.deleteSkill(id);
    }
}
