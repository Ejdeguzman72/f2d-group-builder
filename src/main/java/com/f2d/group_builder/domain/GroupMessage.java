package com.f2d.group_builder.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;

@Entity
@Table(name = "group_message")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@CrossOrigin
public class GroupMessage {

    long groupMsgId;
    String content;
    LocalDate createDatetime;
    LocalDate lastUpdateTime;
    int reactions;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_message_id")
    public long getGroupMsgId() {
        return groupMsgId;
    }

    public void setGroupMsgId(long groupMsgId) {
        this.groupMsgId = groupMsgId;
    }

    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "create_datetime")
    public LocalDate getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(LocalDate createDatetime) {
        this.createDatetime = createDatetime;
    }

    @Column(name = "last_updatetime")
    public LocalDate getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(LocalDate lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Column(name = "reactions")
    public int getReactions() {
        return reactions;
    }

    public void setReactions(int reactions) {
        this.reactions = reactions;
    }
}
