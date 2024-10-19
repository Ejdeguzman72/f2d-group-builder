package com.f2d.group_builder.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@CrossOrigin
public class GroupMessageAddUpdateRequest {

    long groupMsgId;
    String content;
    LocalDate createDatetime;
    LocalDate lastUpdateTime;
    int reactions;
    UUID f2dGroupId;

    public long getGroupMsgId() {
        return groupMsgId;
    }

    public void setGroupMsgId(long groupMsgId) {
        this.groupMsgId = groupMsgId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(LocalDate createDatetime) {
        this.createDatetime = createDatetime;
    }

    public LocalDate getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(LocalDate lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public int getReactions() {
        return reactions;
    }

    public void setReactions(int reactions) {
        this.reactions = reactions;
    }

    public UUID getF2dGroupId() {
        return f2dGroupId;
    }

    public void setF2dGroupId(UUID f2dGroupId) {
        this.f2dGroupId = f2dGroupId;
    }
}
