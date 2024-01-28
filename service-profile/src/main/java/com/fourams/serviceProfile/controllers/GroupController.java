package com.fourams.serviceProfile.controllers;

import com.fourams.serviceProfile.Entities.Group;
import com.fourams.serviceProfile.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/profiles/groups")
@RestController
public class GroupController {
    @Autowired
    private GroupService groupService;

    @PostMapping
    public Group newGroup(@RequestBody Group group){
        return groupService.newGroup(group);
    }

    @GetMapping
    public List<Group> getGroups(){
        return  groupService.getGroups();
    }

    @GetMapping("/{id}")
    public Group getGroupById(@PathVariable int id){
        return groupService.getGroup(id);
    }

    @PutMapping("/{id}")
    public Group updateGroupById(@PathVariable int id, @RequestBody Group group){
        return groupService.updateGroup(id,group);
    }
    @DeleteMapping("/{id}")
    public Group deleteGroupById(@PathVariable int id){
        return groupService.deleteGroup(id);
    }
}
