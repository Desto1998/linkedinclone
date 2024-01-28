package com.fourams.serviceProfile.controllers;

import com.fourams.serviceProfile.Entities.Profile;
import com.fourams.serviceProfile.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/profiles")
@RestController
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @PostMapping
    public Profile newProfile(@RequestBody Profile profile){
        return profileService.newProfile(profile);
    }

    @GetMapping
    public List<Profile> getProfiles(){
        return  profileService.getProfiles();
    }

    @GetMapping("/{id}")
    public Profile getProfileById(@PathVariable int id){
        return profileService.getProfileById(id);
    }

    @PutMapping("/{id}")
    public Profile updateProfileById(@PathVariable int id, @RequestBody Profile profile){
        return profileService.updateProfile(id,profile);
    }
    @DeleteMapping("/{id}")
    public Profile deleteProfileById(@PathVariable int id){
        return profileService.deleteProfile(id);
    }
}
