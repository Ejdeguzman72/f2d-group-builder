package com.f2d.group_builder.domain;

public class UriConstants {

    public static final String GET_ALL_F2D_GROUPS = "/groups/all";
    public static final String GET_F2D_GROUP_BY_ID = "/groups/search/id/{groupId}";

    public static final String ADD_F2D_GROUP = "/groups/create";

    public static final String UPDATE_F2D_GROUP = "/groups/update/{groupId}";
    public static final String DELETE_F2D_GROUP = "/groups/delete/{groupId}";
    public static final String F2D_USER_AUTH_RELATIVE_PATH = "/users/search/id/{userId}";
    public static final String F2D_LOAD_USER_BY_USERNAME = "/users/search/id/{username}";
    public static final String F2D_GET_ALL_USERS = "/users/all";
    public static final String GET_GROUP_MESSAGE_LIST_URI = "/group-message/all";
    public static final String GET_GROUP_MESSAGE_BY_ID_URI = "/group-message/search/id/{groupMessageId}";
    public static final String CREATE_GROUP_MESSAGE_URI = "/group-message/create";
    public static final String UPDATE_GROUP_MESSAGE_URI = "/group-message/update/{groupMessageId}";
    public static final String DELETE_GROUP_MESSAGE_URI = "/group-message/delete/{groupMessageId}";
    public static final String F2D_CREATE_CHAT_GROUP_RELATIVE_PATH_URI = "/chat-groups/create";
    public static final String F2D_RETRIEVE_ALL_CHAT_GROUPS_PATH_URI = "/chat-groups/all";
    public static final String GET_GROUP_MESSAGES_BY_GROUP_URI = "/group-message/all/search/group/${groupId}";
}
