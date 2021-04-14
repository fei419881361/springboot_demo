package com.example.demo.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.UUID;

/**
 * @author zhanglf
 * @Date 2021/4/11 下午10:49
 */
public class MyJWT {
    public static void main(String[] args) {
        // We need a signing key, so we'll create one just for this example. Usually
        // the key would be read from your application configuration instead.
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String jws = Jwts.builder().setSubject("Joe").signWith(key).compact();
        System.out.println(jws);

        // 验证
        System.out.println(Jwts.parserBuilder().setSigningKey(key).
                build().parseClaimsJws(jws).getBody().getSubject().equals("Joe2"));
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jws);
            //OK, we can trust this JWT
            System.out.println("parse success");
        } catch (JwtException e) {
            //don't trust the JWT!
            System.out.println("error");
        }

//        String jws = Jwts.builder()
//
//                .setIssuer("me")
//                .setSubject("Bob")
//                .setAudience("you")
//                .setExpiration(expiration) //a java.util.Date
//                .setNotBefore(notBefore) //a java.util.Date
//                .setIssuedAt(new Date()) // for example, now
//                .setId(UUID.randomUUID()) //just an example id
//
//        /// ... etc ...
    }

    private static int ttl = 1000 * 60 * 100 ; //100分钟
    private static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    public static String createJwt(String email, String subject, String role) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        JwtBuilder builder = Jwts.builder().setId(email)
                .setSubject(subject)
                .setIssuedAt(now)
                .signWith(key).claim("role", role);
        if (ttl > 0) {
            builder.setExpiration(new Date(nowMillis + ttl));
        }
        return builder.compact();
    }
    public static Claims parseJWT(String jwtStr) {

        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwtStr).getBody();
            //OK, we can trust this JWT
            System.out.println("parse success");
        } catch (JwtException e) {
            //don't trust the JWT!
            System.out.println("jwt error");
        }
        return null;
    }


}
