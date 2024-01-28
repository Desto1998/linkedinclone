package com.fourams.serviceProfile.controllers;

import com.fourams.serviceProfile.Entities.Experience;
import com.fourams.serviceProfile.services.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/profiles/experiences")
@RestController
public class ExperienceController {
    @Autowired
    private ExperienceService experienceService;

    @PostMapping
    public Experience newExperience(@RequestBody Experience experience){
        return experienceService.newExperience(experience);
    }

    @GetMapping
    public List<Experience> getExperiences(){
        return  experienceService.getExperiences();
    }

    @GetMapping("/{id}")
    public Experience getExperienceById(@PathVariable int id){
        return experienceService.getExperience(id);
    }

    @PutMapping("/{id}")
    public Experience updateExperienceById(@PathVariable int id, @RequestBody Experience experience){
        return experienceService.updateExperience(id,experience);
    }
    @DeleteMapping("/{id}")
    public Experience deleteExperienceById(@PathVariable int id){
        return experienceService.deleteExperience(id);
    }
}
