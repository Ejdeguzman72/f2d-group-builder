package com.f2d.group_builder.feign;

import com.f2d.group_builder.config.FeignConfig;
import com.f2d.group_builder.domain.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "F2D-CHATROOM",
        url = "http://localhost:8083",
        configuration = FeignConfig.class,
        fallback = F2DChatroomClientFallback.class)
public interface F2DChatroomClient {

    @PostMapping(UriConstants.F2D_CREATE_CHAT_GROUP_RELATIVE_PATH_URI)
    ResponseEntity<ChatGroupAddUpdateResponse> createChatGroup(@RequestBody ChatGroupAddUpdateRequest request);
}
