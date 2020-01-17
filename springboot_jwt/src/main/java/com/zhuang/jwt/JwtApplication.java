package com.zhuang.jwt;


import com.zhuang.jwt.util.JwtUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @Auther: zhuang
 * @Date: 2020/1/17 16:35
 * @Description:
 */
@SpringBootApplication
public class JwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtApplication.class, args);
    }


    //在测试类里面有详细用法

}
