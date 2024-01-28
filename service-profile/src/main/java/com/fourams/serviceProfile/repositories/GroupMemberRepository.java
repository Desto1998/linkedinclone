package com.fourams.serviceProfile.repositories;

import com.fourams.serviceProfile.Entities.GroupMember;
import com.fourams.serviceProfile.Entities.GroupMemberID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GroupMemberRepository extends JpaRepository<GroupMember, GroupMemberID> {
//    public List<GroupMember> findByGroupMemberIDProfile(Profile profile);
//    public List<GroupMember> findByGroupMemberIDGroup(Group group);
}
