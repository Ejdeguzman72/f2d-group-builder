package com.f2d.group_builder.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@CrossOrigin
public class F2DGroupListResponse {

    List<F2DGroup> list;

    public List<F2DGroup> getList() {
        return list;
    }

    public void setList(List<F2DGroup> list) {
        this.list = list;
    }
}
