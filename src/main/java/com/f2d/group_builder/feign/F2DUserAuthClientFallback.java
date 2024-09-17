package com.f2d.group_builder.feign;

import com.f2d.group_builder.domain.AppConstant;
import com.f2d.group_builder.domain.UserSearchResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class F2DUserAuthClientFallback implements F2DUserAuthClient {

    @Override
    public ResponseEntity<UserSearchResponse> getUserInfoById(long userId) {
        UserSearchResponse response = new UserSearchResponse();
        response.setMessage(AppConstant.AUTH_CLIENT_FALLBACK_MSG);
        response.setSuccess(false);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<UserSearchResponse> getUserInfoByUsername(String username) {
        UserSearchResponse response = new UserSearchResponse();
        response.setMessage(AppConstant.AUTH_CLIENT_FALLBACK_MSG);
        response.setSuccess(false);

        return ResponseEntity.ok(response);
    }
}
