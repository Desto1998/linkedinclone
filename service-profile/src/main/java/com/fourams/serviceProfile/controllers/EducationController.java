package com.fourams.serviceProfile.controllers;

import com.fourams.serviceProfile.Entities.Education;
import com.fourams.serviceProfile.services.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/profiles/educations")
@RestController
public class EducationController {
    @Autowired
    private EducationService educationService;

    @PostMapping
    public Education newEducation(@RequestBody Education education){
        return educationService.newEducation(education);
    }

    @GetMapping
    public List<Education> getEducations(){
        return  educationService.getEducations();
    }

    @GetMapping("/{id}")
    public Education getEducationById(@PathVariable int id){
        return educationService.getEducation(id);
    }

    @PutMapping("/{id}")
    public Education updateEducationById(@PathVariable int id, @RequestBody Education education){
        return educationService.updateEducation(id,education);
    }
    @DeleteMapping("/{id}")
    public Education deleteEducationById(@PathVariable int id){
        return educationService.deleteEducation(id);
    }
}
