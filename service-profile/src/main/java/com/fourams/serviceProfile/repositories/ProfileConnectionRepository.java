package com.fourams.serviceProfile.repositories;

import com.fourams.serviceProfile.Entities.ProfileConnection;
import com.fourams.serviceProfile.Entities.ProfileConnectionID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileConnectionRepository extends JpaRepository<ProfileConnection, ProfileConnectionID> {
}
