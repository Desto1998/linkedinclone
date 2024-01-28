package com.fourams.serviceProfile.Entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "profiles_connections")
public class ProfileConnection {
    @EmbeddedId
    private ProfileConnectionID id;


}
