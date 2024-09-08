package com.f2d.group_builder.repository;

import com.f2d.group_builder.domain.F2DGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface F2dGroupRepository extends JpaRepository<F2DGroup, UUID> {
}
