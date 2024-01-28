package com.fourams.serviceProfile.services;

import com.fourams.serviceProfile.Errors.ResourceNotFoundException;
import com.fourams.serviceProfile.repositories.ExperienceRepository;
import com.fourams.serviceProfile.Entities.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService {
    @Autowired
    private ExperienceRepository experienceRepository;

    public List<Experience> getExperiences(){
        return experienceRepository.findAll();
    }
    public Experience newExperience(Experience experience){
        return experienceRepository.save(experience);
    }

    public Experience getExperience(int experienceId){
        return experienceRepository.findById(experienceId).orElseThrow(()->new ResourceNotFoundException("Experience introuvable avec l'id: " + experienceId));
    }

    public Experience updateExperience(int ExperienceId, Experience ExperienceDetail){
        Experience updateExperience = experienceRepository.findById(ExperienceId).orElseThrow(()->new ResourceNotFoundException("Experience introuvable avec l'id: " + ExperienceId));
        updateExperience.setProfile(ExperienceDetail.getProfile());
        updateExperience.setStartDate(ExperienceDetail.getStartDate());
        updateExperience.setEndDate(ExperienceDetail.getEndDate());
        updateExperience.setLocation(ExperienceDetail.getLocation());
        updateExperience.setJobTitle(ExperienceDetail.getJobTitle());
        updateExperience.setCompany_name(ExperienceDetail.getCompany_name());
        return experienceRepository.save(updateExperience);
    }

    public Experience deleteExperience(int ExperienceId){
        Experience experience = experienceRepository.findById(ExperienceId).orElseThrow(()->new ResourceNotFoundException("Experience introuvable avec l'id: " + ExperienceId));
        experienceRepository.deleteById(ExperienceId);
        return experience;
    }
}
