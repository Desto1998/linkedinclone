package com.fourams.serviceProfile.repositories;

import com.fourams.serviceProfile.Entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
}
