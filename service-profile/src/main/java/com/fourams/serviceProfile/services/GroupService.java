package com.fourams.serviceProfile.services;

import com.fourams.serviceProfile.Errors.ResourceNotFoundException;
import com.fourams.serviceProfile.repositories.GroupRepository;
import com.fourams.serviceProfile.Entities.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    public List<Group> getGroups(){
        return groupRepository.findAll();
    }
    public Group newGroup(Group group){
        return groupRepository.save(group);
    }

    public Group getGroup(int groupId){
        return groupRepository.findById(groupId).orElseThrow(()->new ResourceNotFoundException("Group introuvable avec l'id: " + groupId));
    }

    public Group updateGroup(int GroupId, Group GroupDetail){
        Group updateGroup = groupRepository.findById(GroupId).orElseThrow(()->new ResourceNotFoundException("Group introuvable avec l'id: " + GroupId));
        updateGroup.setProfile(GroupDetail.getProfile());
        updateGroup.setName(GroupDetail.getName());
        updateGroup.setProfile(GroupDetail.getProfile());
        updateGroup.setDescription(GroupDetail.getDescription());
        return groupRepository.save(updateGroup);
    }

    public Group deleteGroup(int GroupId){
        Group group = groupRepository.findById(GroupId).orElseThrow(()->new ResourceNotFoundException("Group introuvable avec l'id: " + GroupId));
        groupRepository.deleteById(GroupId);
        return group;
    }
}
