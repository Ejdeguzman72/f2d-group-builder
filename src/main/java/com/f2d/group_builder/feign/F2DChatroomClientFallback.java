package com.f2d.group_builder.feign;

import com.f2d.group_builder.config.FeignConfig;
import com.f2d.group_builder.domain.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class F2DChatroomClientFallback implements F2DChatroomClient {
    @Override
    public ResponseEntity<ChatGroupAddUpdateResponse> createChatGroup(ChatGroupAddUpdateRequest request) {
        ChatGroupAddUpdateResponse response = new ChatGroupAddUpdateResponse();
        response.setMessage("Error calling F2D-CHATROOM CREATE-CHAT-GROUP API: " + response.getMessage());
        response.setSuccess(false);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ChatGroupListResponse> retrieveAllChatGroups() {
        ChatGroupListResponse response = new ChatGroupListResponse();
        response.setMessage("Error calling F2D-CHATROOM GET_ALL_CHAT-GROUPS API: " + response.getMessage());
        response.setSuccess(false);

        return ResponseEntity.ok(response);
    }
}
