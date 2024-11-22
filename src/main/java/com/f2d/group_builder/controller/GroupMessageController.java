package com.f2d.group_builder.controller;

import com.f2d.group_builder.domain.*;
import com.f2d.group_builder.service.GroupMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class GroupMessageController {

    @Autowired
    private GroupMessageService groupMessageService;

    @GetMapping(UriConstants.GET_GROUP_MESSAGE_LIST_URI)
    public GroupMsgListResponse retrieveAllGroupMessages() {
        return groupMessageService.retrieveGroupMessageList();
    }

    @GetMapping(UriConstants.GET_GROUP_MESSAGE_BY_ID_URI)
    public GroupMessageSearchResponse retrieveGroupMessageById(@PathVariable long groupMessageId) {
        return groupMessageService.retrieveGroupMessageById(groupMessageId);
    }

//    @GetMapping(UriConstants.GET_GROUP_MESSAGES_BY_GROUP_URI)
//    public GroupMsgListResponse retrieveGroupMessagesByGroup(@PathVariable long groupId) {
//        return groupMessageService.retrieveGroupMessagesByGroup(groupId);
//    }

    @PostMapping(UriConstants.CREATE_GROUP_MESSAGE_URI)
    public GroupMsgAddUpdateResponse createGroupMessage(@RequestBody GroupMessageAddUpdateRequest request) {
        return groupMessageService.createGroupMessage(request);
    }

    @PutMapping(UriConstants.UPDATE_GROUP_MESSAGE_URI)
    public GroupMsgAddUpdateResponse updateGroupMessage(@RequestBody GroupMessageAddUpdateRequest request, long groupMessageId) {
        return groupMessageService.updateGroupMessage(request, groupMessageId);
    }

    @DeleteMapping(UriConstants.DELETE_GROUP_MESSAGE_URI)
    public GroupMessageSearchResponse deleteGroupMessage(@PathVariable long groupMessageId) {
        return groupMessageService.deleteGroupMessage(groupMessageId);
    }
}
