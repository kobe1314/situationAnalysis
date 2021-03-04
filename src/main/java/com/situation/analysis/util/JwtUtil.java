package com.situation.analysis.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @description: jwt
 * @author: Kobe
 * @date: 2021/2/28 下午9:55
 * @version: v1.0
 */
@Slf4j
public class JwtUtil {
    private static final Long EXPIRE_TIME = 5 * 60 * 1000L;

    private static final String SECRET = "SHIRO+JWT";


    /**
     * 根据用户名创建token，后续会有token的验证
     *
     * @param username
     * @return
     */
    public static String createToken(String username) {

        String token = null;

        try {
            //过期时间
            Date expireDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(SECRET);

            token = JWT.create()
                    .withClaim("username", username)
                    .withExpiresAt(expireDate)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            log.error("Failed to create token. {}", e.getMessage());
        }
        return token;
    }

    /**
     * 验证token,如果失败则抛出异常
     *
     * @param token
     * @param username
     * @return isSuccess
     */
    public static boolean verify(String token, String username) {
        boolean isSuccess = false;
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm).withClaim("username",username).build();
            //验证token
            verifier.verify(token);
            isSuccess = true;
        } catch (SignatureVerificationException | UnsupportedEncodingException e) {
            e.printStackTrace();
            log.error("Failed to validate token");
        }
        return isSuccess;
    }

    /**
     * 在createToken方法里，把username放进去生成token，所以可以在token中提取username
     *
     * @param token
     * @return username
     */
    public static String getUsernameFromToken(String token) {
        try {
            DecodedJWT decode = JWT.decode(token);
            String username = decode.getClaim("username").asString();
            return username;
        } catch (JWTDecodeException e) {
            log.error("Failed to Decode jwt. {}", e.getMessage());
            return null;
        }
    }
}
