package com.f2d.group_builder.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDateTime;

@Entity
@Table(name = "chat_message")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@CrossOrigin
public class ChatMessage {

    long chatMessageId;
    String sender;
    String content;
    LocalDateTime sentDatetime;
    ChatGroup chatGroup;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_message_id")
    public long getChatMessageId() {
        return chatMessageId;
    }

    public void setChatMessageId(long chatMessageId) {
        this.chatMessageId = chatMessageId;
    }

    @Column(name = "sender")
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "sent_datetime")
    public LocalDateTime getSentDatetime() {
        return sentDatetime;
    }

    public void setSentDatetime(LocalDateTime sentDatetime) {
        this.sentDatetime = sentDatetime;
    }

    @ManyToOne
    @JoinColumn(name = "chat_group_id")
    public ChatGroup getChatGroup() {
        return chatGroup;
    }

    public void setChatGroup(ChatGroup chatGroup) {
        this.chatGroup = chatGroup;
    }
}
