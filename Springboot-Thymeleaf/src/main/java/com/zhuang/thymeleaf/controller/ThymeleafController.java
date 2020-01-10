package com.zhuang.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class ThymeleafController {

    @RequestMapping({"index","/"})
    public String getIndex(Model model){
        model.addAttribute("title", "模板引擎标题");
        model.addAttribute("msg", "这是首页");
        return "index";//页面路径
    }


    @RequestMapping("tow")
    public ModelAndView getIndex2(@RequestParam(required = false,defaultValue = "你传入的是空值") String name){
        ModelAndView view = new ModelAndView();
        view.addObject("name", name);//传递到页面的对象
        view.setViewName("tow");//设置页面路径
        return view;
    }

    @RequestMapping("three")
    public ModelAndView getThree(Model model) {
        List<String> list = new ArrayList<>();
        list.add("小明");
        list.add("小芳");
        list.add("小红");

        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "小凤");
        map.put("age", 25);
        map.put("address", "深圳");

        model.addAttribute("list", list);
        model.addAttribute("map", map);
        //这种其实跟上面第二种是一样，设置路径，设置传递的的对象ket和value
        return new ModelAndView("three", "getThree", "list、map集合输出测试");
    }

}
