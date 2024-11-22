package com.f2d.group_builder.repository;

import com.f2d.group_builder.domain.GroupMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GroupMessageRepository extends JpaRepository<GroupMessage,Long> {
    List<GroupMessage> findByF2dGroup_GroupId(UUID groupId);

}
