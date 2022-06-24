package com.ebidding.common.auth;

import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class AuthorizeInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        Authorize authorize = handlerMethod.getMethod().getAnnotation(Authorize.class);
        if (authorize == null) {
            return true;
        }

        String[] allowedHeaders = authorize.value();
        String auth = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StringUtils.isEmpty(auth)) {
            // localhost doesn't need X-jwt-role
            return true;
        }
        String role = request.getHeader(AuthConstant.X_JWT_ROLE_HEADER);
        if (StringUtils.isEmpty(role) || !Arrays.asList(allowedHeaders).contains(role)) {
            throw new PermissionDeniedException("permission denied");
        }

        return true;
    }
}
