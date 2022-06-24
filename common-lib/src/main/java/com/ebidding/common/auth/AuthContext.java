package com.ebidding.common.auth;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class AuthContext {
    private static String getRequestHeader(String headerName) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
            return request.getHeader(headerName);
        }
        return null;
    }

    public static String getUserId() {
        return getRequestHeader(AuthConstant.X_JWT_ID_HEADER);
    }

    public static String getUsername() {
        return getRequestHeader(AuthConstant.X_JWT_NAME_HEADER);
    }

    public static String getUserRole() {
        return getRequestHeader(AuthConstant.X_JWT_ROLE_HEADER);
    }
}
