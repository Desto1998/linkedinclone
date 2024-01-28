package com.fourams.serviceProfile.services;

import com.fourams.serviceProfile.Errors.ResourceNotFoundException;
import com.fourams.serviceProfile.repositories.EducationRepository;
import com.fourams.serviceProfile.Entities.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService {
    @Autowired
    private EducationRepository educationRepository;

    public List<Education> getEducations(){
        return educationRepository.findAll();
    }
    public Education newEducation(Education education){
        return educationRepository.save(education);
    }

    public Education getEducation(int educationId){
        return educationRepository.findById(educationId).orElseThrow(()->new ResourceNotFoundException("Education introuvable avec l'id: " + educationId));
    }

    public Education updateEducation(int EducationId, Education EducationDetail){
        Education updateEducation = educationRepository.findById(EducationId).orElseThrow(()->new ResourceNotFoundException("Education introuvable avec l'id: " + EducationId));
        updateEducation.setDegree(EducationDetail.getDegree());
        updateEducation.setSchool(EducationDetail.getSchool());
        updateEducation.setProfile(EducationDetail.getProfile());
        updateEducation.setEndDate(EducationDetail.getEndDate());
        updateEducation.setStartDate(EducationDetail.getStartDate());
        updateEducation.setFieldOfStudy(EducationDetail.getFieldOfStudy());
        return educationRepository.save(updateEducation);
    }

    public Education deleteEducation(int EducationId){
        Education education = educationRepository.findById(EducationId).orElseThrow(()->new ResourceNotFoundException("Education introuvable avec l'id: " + EducationId));
        educationRepository.deleteById(EducationId);
        return education;
    }

}
