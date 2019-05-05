package com.hhandoko.graaldecoding;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class Application {

    private final static String CLAIM_USERNAME = "username";
    private final static String ISSUER = "realworld";
    private final static String SECRET = "S3cret!";
    private final static String NON_EXPIRING_TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJyZWFsd29ybGQiLCJ1c2VybmFtZSI6ImZhbW91cyJ9.c3ghryIJayjtL3wL4j2KSEeLBXUd5U8ALbdSQBau2Qg";

    public static void main(String[] args) {
        try {
            Algorithm algo = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algo).withIssuer(ISSUER).build();
            DecodedJWT payload = verifier.verify(NON_EXPIRING_TOKEN);
            String username = payload.getClaim(CLAIM_USERNAME).asString();
            System.out.println("Username: " + username);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            for (StackTraceElement el : e.getStackTrace()) {
                System.out.println(el.toString());
            }
        }
    }

}
