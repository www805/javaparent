package com.zhuang.jwt;

import com.zhuang.jwt.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: zhuang
 * @Date: 2020/1/17 0017 17:52
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringJwtTest {

    @Autowired
    private JwtUtil jwtUtil;

    @Test
    public void JwtTest() {

        String jwt = jwtUtil.createJWT("001", "我是内容哈哈", "admin");

        System.out.println(jwt);

        Claims claims = jwtUtil.parseJWT(jwt);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());
        System.out.println("签发时间:"+sdf.format(claims.getIssuedAt()));
        System.out.println("过期时间:"+sdf.format(claims.getExpiration()));
        System.out.println("当前时间:"+sdf.format(new Date()) );

    }

}
