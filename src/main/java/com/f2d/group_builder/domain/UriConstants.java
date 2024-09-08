package com.f2d.group_builder.domain;

public class UriConstants {

    public static final String GET_ALL_F2D_GROUPS = "/groups/all";
    public static final String GET_F2D_GROUP_BY_ID = "/groups/search/id/{groupId}";

    public static final String ADD_F2D_GROUP = "/groups/create";

    public static final String UPDATE_F2D_GROUP = "/groups/update/{groupId}";
    public static final String DELETE_F2D_GROUP = "/groups/delete/{groupId}";
    public static final String F2D_USER_AUTH_RELATIVE_PATH = "/users/search/id/{userId}";
}
