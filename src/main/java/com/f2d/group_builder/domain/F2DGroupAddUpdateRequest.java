package com.f2d.group_builder.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Set;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@CrossOrigin
public class F2DGroupAddUpdateRequest {
    UUID groupId;
    String groupName;
    String groupType;
    Set<Long> userIdSet;

    public UUID getGroupId() {
        return groupId;
    }

    public void setGroupId(UUID groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public Set<Long> getUserIdSet() {
        return userIdSet;
    }

    public void setUserIdSet(Set<Long> userIdSet) {
        this.userIdSet = userIdSet;
    }
}
