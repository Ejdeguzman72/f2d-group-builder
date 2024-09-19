package com.f2d.group_builder.repository;

import com.f2d.group_builder.domain.GroupMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupMessageRepository extends JpaRepository<GroupMessage,Long> {
}
