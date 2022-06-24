package com.ebidding.common.auth;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.util.StringUtils;

public class FeignRequestHeaderInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        String userId = AuthContext.getUserId();
        String name = AuthContext.getUsername();
        String role = AuthContext.getUserRole();
        if (!StringUtils.isEmpty(userId) && !StringUtils.isEmpty(role)) {
            requestTemplate.header(AuthConstant.X_JWT_ID_HEADER, userId);
            requestTemplate.header(AuthConstant.X_JWT_NAME_HEADER, name);
            requestTemplate.header(AuthConstant.X_JWT_ROLE_HEADER, role);
        }
    }
}
