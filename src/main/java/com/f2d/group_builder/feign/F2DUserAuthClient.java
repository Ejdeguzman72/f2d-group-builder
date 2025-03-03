package com.f2d.group_builder.feign;

import com.f2d.group_builder.config.FeignConfig;
import com.f2d.group_builder.domain.AppConstant;
import com.f2d.group_builder.domain.UriConstants;
import com.f2d.group_builder.domain.UserSearchResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = AppConstant.F2D_USER_AUTHENTICATION,
        url = AppConstant.RASPBERRY_PI_F2D,
        configuration = FeignConfig.class,
        fallback = F2DUserAuthClientFallback.class)
public interface F2DUserAuthClient {

    @GetMapping(UriConstants.F2D_USER_AUTH_RELATIVE_PATH)
    ResponseEntity<UserSearchResponse> getUserInfoById(@PathVariable(AppConstant.PATH_VARIABLE_USER_ID) long userId);

    @GetMapping(UriConstants.F2D_LOAD_USER_BY_USERNAME)
    ResponseEntity<UserSearchResponse> getUserInfoByUsername(@PathVariable(AppConstant.PATH_VARIABLE_USERNAME) String username);
}
