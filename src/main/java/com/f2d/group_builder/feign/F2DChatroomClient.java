package com.f2d.group_builder.feign;

import com.f2d.group_builder.config.FeignConfig;
import com.f2d.group_builder.domain.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = AppConstant.F2D_CHATROOM,
        url = AppConstant.LOCALHOST,
        configuration = FeignConfig.class,
        fallback = F2DChatroomClientFallback.class)
public interface F2DChatroomClient {

    @PostMapping(UriConstants.F2D_CREATE_CHAT_GROUP_RELATIVE_PATH_URI)
    ResponseEntity<ChatGroupAddUpdateResponse> createChatGroup(@RequestBody ChatGroupAddUpdateRequest request);

    @GetMapping(UriConstants.F2D_RETRIEVE_ALL_CHAT_GROUPS_PATH_URI)
    ResponseEntity<ChatGroupListResponse> retrieveAllChatGroups();
}
