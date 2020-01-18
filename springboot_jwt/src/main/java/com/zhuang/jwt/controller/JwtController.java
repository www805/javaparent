package com.zhuang.jwt.controller;

import com.zhuang.jwt.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: zhuang
 * @Date: 2020/1/17  18:25
 * @Description:
 */
@RestController
public class JwtController {

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 用户登陆
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login")//, method = RequestMethod.POST
    public Map<String, Object> login(String username, String password) {

        Map map = new HashMap();
        if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)) {
            String token = jwtUtil.createJWT("1", username, "user");

            map.put("token", token);
            map.put("name", "昵称");//昵称
            map.put("avatar", "头像");//头像
            return map;
        } else {
            map.put("msg", "用户名或密码错误");
            return map;
        }
    }

    /**
     * 模拟请求一次数据
     * @param request
     * @return
     */
    @RequestMapping("/getTest")
    public Map<String,Object> getTest(HttpServletRequest request){

        HashMap<String, Object> map = new HashMap<>();

        Claims claims = (Claims) request.getAttribute("admin_claims");
        if(null == claims){
            map.put("msg", "你无权访问");
        }




        return map;
    }

}
