package com.f2d.group_builder.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserListResponse {

    List<F2DUser> list;

    public List<F2DUser> getList() {
        return list;
    }

    public void setList(List<F2DUser> list) {
        this.list = list;
    }
}
