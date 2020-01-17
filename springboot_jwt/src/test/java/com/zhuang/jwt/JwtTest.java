package com.zhuang.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: zhuang
 * @Date: 2020/1/17 0017 16:42
 * @Description:
 */
public class JwtTest {

    public static void main(String[] args) {
//        create();

        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiLmtYvor5UiLCJpYXQiOjE1NzkyNTM5MTcsImV4cCI6MTU3OTI1Mzk3Nn0.V82gOUMG_mVtn96Z4wb7o7yiOwhR3OhLX68czP14ShE";
        Claims claims = Jwts.parser().setSigningKey("zhuang").parseClaimsJws(token).getBody();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());
        System.out.println("签发时间:"+sdf.format(claims.getIssuedAt()));
        System.out.println("过期时间:"+sdf.format(claims.getExpiration()));
        System.out.println("当前时间:"+sdf.format(new Date()) );


    }

    public static void create() {

        long now = System.currentTimeMillis();
        long exp = now + 1000 * 60; //过期时间为1分钟



        JwtBuilder builder = Jwts.builder().setId("888")
                .setSubject("测试")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "zhuang")
                .setExpiration(new Date(exp));
        System.out.println(builder.compact());
    }






}
