package com.f2d.group_builder.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class FeignRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        String jwtToken = null;
        try {
            jwtToken = getCurrentJwtToken();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (jwtToken != null) {
            template.header("Authorization", "Bearer " + jwtToken);
        }
    }

    private String getCurrentJwtToken() throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication + "dsakljhfalkdfjh");
        if (authentication != null && authentication.getCredentials() instanceof String) {
            return (String) authentication.getCredentials();
        } else {
            throw new Exception("authentication is null");
        }
    }
}
