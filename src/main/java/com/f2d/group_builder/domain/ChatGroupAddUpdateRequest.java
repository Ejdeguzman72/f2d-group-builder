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
    String name;
    LocalDate createDate;
    LocalDate lastUpdatetime;
    UUID f2dGroupId;

    public UUID getChatGroupId() {
        return chatGroupId;
    }

    public void setChatGroupId(UUID chatGroupId) {
        this.chatGroupId = chatGroupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public UUID getF2dGroupId() {
        return f2dGroupId;
    }

    public void setF2dGroupId(UUID f2dGroupId) {
        this.f2dGroupId = f2dGroupId;
    }
}
