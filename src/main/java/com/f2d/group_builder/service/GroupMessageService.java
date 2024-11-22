package com.f2d.group_builder.service;

import com.f2d.group_builder.domain.*;
import com.f2d.group_builder.repository.GroupMessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class GroupMessageService {

    @Autowired
    private GroupMessageRepository groupMessageRepository;
    @Autowired
    private F2DGroupService f2dGroupService;
    private static final Logger LOGGER = LoggerFactory.getLogger(GroupMessageService.class);

    public GroupMsgListResponse retrieveGroupMessageList() {
        GroupMsgListResponse response = new GroupMsgListResponse();
        try {
            List<GroupMessage> list = groupMessageRepository.findAll();
            response.setList(list);
            response.setMessage(AppConstant.RETRIEVE_GROUP_MESSAGE_LIST_SUCCESS_MSG);
            response.setSuccess(true);

            LOGGER.info("Fetching group message list...");
        } catch (Exception e) {
            response.setMessage(AppConstant.RETRIEVE_GROUP_MESSAGE_LIST_FAILURE_MSG);
            response.setSuccess(false);

            LOGGER.error("Error fetching group message list...");
        }

        return response;
    }

    public GroupMsgListResponse retrieveGroupMessagesByGroup(UUID groupId) {
        GroupMsgListResponse response = new GroupMsgListResponse();
        List<GroupMessage> list = groupMessageRepository.findByF2dGroup_GroupId(groupId);
        response.setList(list);
        response.setMessage(AppConstant.RETRIEVE_GROUP_MESSAGE_LIST_SUCCESS_MSG);
        response.setSuccess(true);

        return response;
    }

    public GroupMessageSearchResponse retrieveGroupMessageById(long groupMessageId) {
        GroupMessageSearchResponse response = new GroupMessageSearchResponse();
        GroupMessage groupMessage = groupMessageRepository.findById(groupMessageId).orElseGet(GroupMessage::new);
        if (Objects.nonNull(groupMessage)) {
            response.setGroupMessage(groupMessage);
            response.setMessage(AppConstant.RETRIEVE_GROUP_MSG_BY_ID_SUCCESS_MSG);
            response.setSuccess(true);

            LOGGER.info("Retrieved group message by ID: " + groupMessageId);
        } else {
            response.setMessage(AppConstant.RETRIEVE_GROUP_MSG_BY_ID_FAILURE_MSG);
        }

        return response;
    }

    public GroupMsgAddUpdateResponse createGroupMessage(GroupMessageAddUpdateRequest request) {
        GroupMsgAddUpdateResponse response = new GroupMsgAddUpdateResponse();

        GroupMessage groupMessage = new GroupMessage();
        groupMessage.setTitle(request.getTitle());
        groupMessage.setContent(request.getContent());
        groupMessage.setCreateDatetime(LocalDate.now());
        groupMessage.setLastUpdateTime(LocalDate.now());
        groupMessage.setReactions(request.getReactions());
        if (request.getF2dGroupId() != null) {
            F2DGroup f2dGroup = f2dGroupService.retrieveGroupById(request.getF2dGroupId()).getF2dGroup();
            groupMessage.setF2dGroup(f2dGroup);
        }
        groupMessage = groupMessageRepository.save(groupMessage);
        try {
            if (Objects.nonNull(groupMessage.getGroupMsgId())) {
                response.setSuccess(true);
                response.setMessage(AppConstant.ADD_UPDATE_GROUP_MESSAGE_SUCCESS_MSG);

                LOGGER.info("Adding group message: " + request.getContent());
            } else {
                response.setGroupMessage(groupMessage);
                response.setSuccess(false);
                response.setMessage(AppConstant.ADD_UPDATE_GROUP_MESSAGE_FAILURE_MSG);
            }
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("An exception occurred while creating group message: " + e.getMessage());
        }

        return response;
    }

    public GroupMsgAddUpdateResponse updateGroupMessage(GroupMessageAddUpdateRequest request, long groupMessageId) {
        GroupMsgAddUpdateResponse response = new GroupMsgAddUpdateResponse();
        GroupMessage groupMessage = retrieveGroupMessageById(groupMessageId).getGroupMessage();

        if (Objects.nonNull(groupMessage)) {
            groupMessage.setGroupMsgId(request.getGroupMsgId());
            groupMessage.setTitle(request.getTitle());
            groupMessage.setContent(request.getContent());
            groupMessage.setReactions(request.getReactions());
            groupMessage.setCreateDatetime(request.getCreateDatetime());
            groupMessage.setLastUpdateTime(request.getLastUpdateTime());

            GroupMessage updatedGroupMessage = groupMessageRepository.save(groupMessage);
            if (Objects.nonNull(updatedGroupMessage.getGroupMsgId())) {
                response.setSuccess(true);
                response.setMessage(AppConstant.ADD_UPDATE_GROUP_MESSAGE_SUCCESS_MSG);

                LOGGER.info("Updating group message: " + groupMessageId);
            } else {
                response.setMessage(AppConstant.ADD_UPDATE_GROUP_MESSAGE_FAILURE_MSG);
                response.setSuccess(false);
            }

            response.setGroupMessage(updatedGroupMessage);
        }

        return response;
    }

    public GroupMessageSearchResponse deleteGroupMessage(long groupMessageId) {
        GroupMessageSearchResponse response = new GroupMessageSearchResponse();
        GroupMessage groupMessage = retrieveGroupMessageById(groupMessageId).getGroupMessage();
        if (Objects.nonNull(groupMessage)) {
            groupMessageRepository.deleteById(groupMessageId);

            LOGGER.info("Deleting group message with ID: " + groupMessageId);
            response.setGroupMessage(groupMessage);
        }

        return response;
    }
}
