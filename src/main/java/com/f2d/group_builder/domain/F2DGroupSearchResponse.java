package com.f2d.group_builder.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.web.bind.annotation.CrossOrigin;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@CrossOrigin
public class F2DGroupSearchResponse {

    F2DGroup f2dGroup;

    public F2DGroup getF2dGroup() {
        return f2dGroup;
    }

    public void setF2dGroup(F2DGroup f2dGroup) {
        this.f2dGroup = f2dGroup;
    }
}
