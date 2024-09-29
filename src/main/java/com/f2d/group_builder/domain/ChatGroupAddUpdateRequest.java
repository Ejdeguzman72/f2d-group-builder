package com.f2d.group_builder.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@CrossOrigin
public class ChatGroupAddUpdateRequest  {
    UUID chatGroupId;
    String groupName;
    LocalDate createDate;
    LocalDate lastUpdatetime;
    UUID groupId;

    public UUID getChatGroupId() {
        return chatGroupId;
    }

    public void setChatGroupId(UUID chatGroupId) {
        this.chatGroupId = chatGroupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getLastUpdatetime() {
        return lastUpdatetime;
    }

    public void setLastUpdatetime(LocalDate lastUpdatetime) {
        this.lastUpdatetime = lastUpdatetime;
    }

    public UUID getGroupId() {
        return groupId;
    }

    public void setGroupId(UUID groupId) {
        this.groupId = groupId;
    }
}
