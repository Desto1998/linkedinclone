package com.fourams.serviceUser.services;

import com.fourams.serviceUser.Entities.User;
import com.fourams.serviceUser.Errors.ResourceNotFoundException;
import com.fourams.serviceUser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public User newUser(User user){
        LocalDate birthDate = Date.valueOf(user.getBirthDate().toLocalDate()).toLocalDate();
        if (userRepository.findUserByEmail(user.getEmail())!=null){
            throw  new ResourceNotFoundException(" adresse email prise");
        }
        if (user.getAge()<18){
            throw  new ResourceNotFoundException("Votre age doit etre supperieur a 18 ans!");
        }

        user.setRegistrationDate(LocalDateTime.now());

        return userRepository.save(user);
    }
    public User getUserById(int id){
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Utilisateur introuvable avec"));
    }

    public User updateUser(int userId, User userDetail){
        User updateUser = userRepository.findById(userId).
                orElseThrow( ()-> new ResourceNotFoundException("Utilisateur introuvable avec "));
        updateUser.setUsername(userDetail.getUsername());
        updateUser.setFirstName(userDetail.getFirstName());
        updateUser.setLastName(userDetail.getLastName());
        updateUser.setPassword(userDetail.getPassword());
        updateUser.setEmail(userDetail.getEmail());
        updateUser.setBirthDate(userDetail.getBirthDate());
        updateUser.setAge(userDetail.getAge());
        updateUser.setLastLoginDate(userDetail.getLastLoginDate());
        return userRepository.save(updateUser);
    }
    public User deleteUser(int userId) {
       User user= userRepository.findById(userId).
                orElseThrow( () -> new ResourceNotFoundException("Utilisateur introuvable avec"));
        userRepository.deleteById(userId);
        return user;
    }

    public void lastLogin(int userId){
        User updateUser = userRepository.findById(userId).
                orElseThrow( ()-> new ResourceNotFoundException("Utilisateur introuvable avec id. "));

        updateUser.setLastLoginDate(Timestamp.valueOf(LocalDateTime.now()));
    }

    public User login(String email, String password){
        User user = userRepository.findUserByEmailAndPassword(email, password).orElseThrow( ()-> new ResourceNotFoundException("User not exist with id. "));
        lastLogin(user.getId());
        return user;
    }
}
