package com.ebidding.gateway.filter;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ebidding.common.auth.AuthConstant;
import com.ebidding.common.cryto.Sign;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("rawtypes")
@Component
public class JWTFilter extends AbstractGatewayFilterFactory {

    private static final String WWW_AUTH_HEADER = "WWW-Authenticate";

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            List<String> values = exchange.getRequest().getHeaders().getOrDefault(HttpHeaders.AUTHORIZATION, new ArrayList<>());
            if (!values.isEmpty()) {
                // "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJyb2xlIjoiVFJBREVSIiwibmFtZSI6InRlc3QtdHJhZGVyIiwiZXhwIjoxNjU2MDU1NzYyLCJ1c2VySWQiOiIxIn0.ZKBkNVDvwdjYrzSzhb1bJy3foka3vdb0YUtpZnmmXA0-MMYcrGZ1iCN9IZFrmc6MwY8J1N1sKoVgncvLUoVZIg"
                String token = values.get(0);
                String[] splits = token.split("\\s");
                if (splits.length == 2) {
                    String jwt = splits[1];
                    try {
                        DecodedJWT decodedJWT = Sign.getVerifier().verify(jwt);
                        String userId = decodedJWT.getClaim(AuthConstant.CLAIM_USER_ID).asString();
                        String userName = decodedJWT.getClaim(AuthConstant.CLAIM_USER_NAME).asString();
                        String role = decodedJWT.getClaim(AuthConstant.CLAIM_ROLE).asString();
                        ServerHttpRequest request = exchange.getRequest().mutate()
                                .header(AuthConstant.X_JWT_ID_HEADER, userId)
                                .header(AuthConstant.X_JWT_NAME_HEADER, userName)
                                .header(AuthConstant.X_JWT_ROLE_HEADER, role)
                                .build();
                        return chain.filter(exchange.mutate().request(request).build());
                    } catch (JWTVerificationException ex) {
                        return OnUnauthorizedResponse(exchange);
                    }
                }
            }
            return OnUnauthorizedResponse(exchange);
        };
    }

    private Mono<Void> OnUnauthorizedResponse(ServerWebExchange exchange) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        response.getHeaders().add(WWW_AUTH_HEADER, "UNAUTHORIZED");
        return response.setComplete();
    }
}
