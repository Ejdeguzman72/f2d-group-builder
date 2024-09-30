package com.f2d.group_builder.controller;

import com.f2d.group_builder.domain.*;
import com.f2d.group_builder.service.F2DGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin
public class F2dGroupController {

    @Autowired
    private F2DGroupService f2dGroupService;

    @GetMapping(value = UriConstants.GET_ALL_F2D_GROUPS)
    public F2DGroupListResponse retrieveAllGroupInformation() {
        return f2dGroupService.retrieveAllF2dGroups();
    }

    @GetMapping(value = "/groups/search/id/{groupId}")
    public F2DGroupSearchResponse retrieveGroupById(@PathVariable UUID groupId) {
        return f2dGroupService.retrieveGroupById(groupId);
    }

    @GetMapping(value = "/groups/search/groupName/{groupName}")
    public F2DGroupSearchResponse retrieveGroupByGroupName(@PathVariable String groupName) {
        return f2dGroupService.retrieveGroupByGroupName(groupName);
    }

    @PostMapping(value = UriConstants.ADD_F2D_GROUP)
    public F2DGroupAddUpdateResponse createF2DGroup(@RequestBody F2DGroupAddUpdateRequest request) throws Exception {
        return f2dGroupService.createF2DGroup(request);
    }

    @PutMapping(value = UriConstants.UPDATE_F2D_GROUP)
    public F2DGroupAddUpdateResponse updateF2DGroup(@RequestBody F2DGroupAddUpdateRequest request, @PathVariable UUID groupId) {
        return f2dGroupService.updateF2DGroup(request, groupId);
    }

    @DeleteMapping(value = UriConstants.DELETE_F2D_GROUP)
    public F2DGroupSearchResponse deleteF2DGroup(@PathVariable UUID groupId) {
        return f2dGroupService.deleteF2dGroup(groupId);
    }
}
