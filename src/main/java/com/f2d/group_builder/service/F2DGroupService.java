package com.f2d.group_builder.service;

import com.f2d.group_builder.domain.*;
import com.f2d.group_builder.feign.F2DUserAuthClient;
import com.f2d.group_builder.repository.F2dGroupRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class F2DGroupService {

    @Autowired
    private F2dGroupRepository f2dGroupRepository;
    @Autowired
    private F2DUserAuthClient f2DUserAuthClient;
    private static final Logger LOGGER = LoggerFactory.getLogger(F2DGroupService.class);

    public F2DGroupListResponse retrieveAllF2dGroups() {
        F2DGroupListResponse response = new F2DGroupListResponse();
        List<F2DGroup> list = f2dGroupRepository.findAll();
        response.setList(list);

        LOGGER.info("Retrieving list of groups...");

        return response;
    }

    public F2DGroupSearchResponse retrieveGroupById(UUID groupId) {
        F2DGroupSearchResponse response = new F2DGroupSearchResponse();
        F2DGroup f2dGroup = f2dGroupRepository.findById(groupId).orElseGet(F2DGroup::new);
        response.setF2dGroup(f2dGroup);

        LOGGER.info("Finding group with ID: " + groupId);

        return response;
    }

    public F2DGroupAddUpdateResponse createF2DGroup(F2DGroupAddUpdateRequest request) throws Exception {
        F2DGroupAddUpdateResponse response = new F2DGroupAddUpdateResponse();
        request.setCreateTime(LocalDate.now());
        request.setLastUpdateTime(LocalDate.now());
        if (checkGroupNameDuplicate(request.getGroupName())) {
            throw new Exception("Duplicate entry");
        }
        F2DGroup group = f2dGroupRepository.save(request);

        try {
            if (Objects.nonNull(group.getGroupId())) {
                response.setSuccess(true);
                response.setMessage(AppConstant.ADD_UPDATE_SUCCESS_MSG);

                LOGGER.info("Adding group: " + group.getGroupName());
            } else {
                response.setSuccess(false);
                response.setMessage(AppConstant.ADD_UPDATE_FAILURE_MSG);
            }
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("An exception occurred while saving the group: " + e.getMessage());
        }

        response.setF2dGroup(group);
        return response;
    }

        public Set<Long> addUsersToGroup(Set<Long> userIdSet, UUID groupId) {
            Set<Long> validUserIdSet = new HashSet<>();

            if (userIdSet != null && !userIdSet.isEmpty()) {
                for (Long userId : userIdSet) {
                    try {
                        ResponseEntity<UserSearchResponse> response = f2DUserAuthClient.getUserInfoById(userId);
                        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                            F2DUser user = response.getBody().getUser();
                            if (user != null && user.getUserId() > 0) {
                                validUserIdSet.add(user.getUserId());
                            }
                        }
                    } catch (Exception e) {
                        // Log the error or handle it as necessary
                        e.printStackTrace();
                    }
                }
            }

            return validUserIdSet;
        }

    public F2DGroupAddUpdateResponse updateF2DGroup(F2DGroupAddUpdateRequest request, UUID groupId) {
        F2DGroupAddUpdateResponse response = new F2DGroupAddUpdateResponse();
        F2DGroup group = retrieveGroupById(groupId).getF2dGroup();

        if (group != null) {
            group.setGroupId(request.getGroupId());
            group.setGroupType(request.getGroupType());

            Set<Long> userIdSet = addUsersToGroup(request.getUserIdSet(), groupId);
            group.setUserIdSet(userIdSet);

            group.setCreateTime(request.getCreateTime());
            group.setLastUpdateTime(LocalDate.now());

            F2DGroup updatedGroupDetails = f2dGroupRepository.save(group); // Save the `group` entity
            if (Objects.nonNull(updatedGroupDetails.getGroupId())) {
                response.setSuccess(true);
                response.setMessage(AppConstant.ADD_UPDATE_SUCCESS_MSG);

                LOGGER.info("Updating group: " + group.getGroupName());
            } else {
                response.setSuccess(false);
                response.setMessage(AppConstant.ADD_UPDATE_FAILURE_MSG);
            }

            response.setF2dGroup(updatedGroupDetails);
        } else {
            response.setSuccess(false);
            response.setMessage("Group not found.");
        }

        return response;
    }

    public F2DGroupSearchResponse deleteF2dGroup(UUID groupId) {
        F2DGroupSearchResponse response = new F2DGroupSearchResponse();
        F2DGroup group = retrieveGroupById(groupId).getF2dGroup();
        if (Objects.nonNull(group)) {
            f2dGroupRepository.deleteById(groupId);

            LOGGER.info("Deleting group with ID: " + groupId);
        }

        response.setF2dGroup(group);
        return response;
    }

    public boolean checkGroupNameDuplicate(String groupName) {
        boolean result = false;
        List<F2DGroup> list = f2dGroupRepository.findAll();
        for (F2DGroup group : list) {
            if (group.getGroupName().equals(groupName)) {
                result = true;
            }
        }

        return result;
    }
}
