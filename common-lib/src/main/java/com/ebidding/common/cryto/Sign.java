package com.ebidding.common.cryto;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.ebidding.common.auth.AuthConstant;

import java.util.Date;

public class Sign {
    private static final String TOKEN = "123456";
    private static final Algorithm algorithm = Algorithm.HMAC512(TOKEN);

    public static JWTVerifier getVerifier() {
        return JWT.require(algorithm).build();
    }

    public static String generateToken(String id,
                                       String name,
                                       String role,
                                       long duration) {
        return JWT.create()
                .withClaim(AuthConstant.CLAIM_USER_ID, id)
                .withClaim(AuthConstant.CLAIM_USER_NAME, name)
                .withClaim(AuthConstant.CLAIM_ROLE, role)
                .withExpiresAt(new Date(System.currentTimeMillis() + duration))
                .sign(algorithm);
    }
}
