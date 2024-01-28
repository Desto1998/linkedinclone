package com.fourams.serviceProfile.services;

import com.fourams.serviceProfile.Errors.ResourceNotFoundException;
import com.fourams.serviceProfile.Entities.Profile;
import com.fourams.serviceProfile.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
   @Autowired
   private ProfileRepository profileRepository;

   public List<Profile> getProfiles(){
       return profileRepository.findAll();
   }
   public Profile newProfile(Profile profile){
       return profileRepository.save(profile);
   }

   public Profile getProfileById(int profileId){
       return profileRepository.findById(profileId).orElseThrow(()->new ResourceNotFoundException("Profile introuvable avec l'id: " + profileId));
   }

   public Profile updateProfile(int profileId, Profile profileDetail){
       Profile updateProfile = profileRepository.findById(profileId).orElseThrow(()->new ResourceNotFoundException("Profile introuvable avec l'id: " + profileId));
       updateProfile.setHeadline(profileDetail.getHeadline());
       updateProfile.setSummary(profileDetail.getSummary());
       updateProfile.setIndustry(profileDetail.getIndustry());
       updateProfile.setWebsite(profileDetail.getWebsite());
       updateProfile.setCurrentJobTitle(profileDetail.getCurrentJobTitle());
       updateProfile.setUserId(profileDetail.getUserId());
       updateProfile.setOpenForWork(profileDetail.isOpenForWork());
       return profileRepository.save(updateProfile);
   }

   public Profile deleteProfile(int profileId){
       Profile profile = profileRepository.findById(profileId).orElseThrow(()->new ResourceNotFoundException("Profile introuvable avec l'id: " + profileId));
       profileRepository.deleteById(profileId);
       return profile;
   }

}
