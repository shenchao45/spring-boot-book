package com.shenchao.controller;

import com.shenchao.bean.User;
import com.shenchao.boot.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shenchao on 2017/2/21.
 */
@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/index")
    public String hello(){
        return "index";
    }

    @ResponseBody
    @RequestMapping("/testRestful")
    Map<String,Object> testRestful(){
        Map<String, Object> map = new HashMap<>();
        map.put("hello", 23);
        map.put("aa","fdsa");
        return map;
    }
    @RequestMapping(value = "/testxml",produces = "application/xml;charset=UTF-8")
    @ResponseBody
    Map<String,Object> testxml(){
        Map<String, Object> map = new HashMap<>();
        map.put("hello", 23);
        map.put("aa","fdsa");
        return map;
    }

    @RequestMapping(value = "/convert",produces = {"application/x-shenchao"})
    public @ResponseBody
    User convert(@RequestBody User user){
        System.out.println(user);
        return user;
    }

    @RequestMapping("/helloService")
    public @ResponseBody String helloServiceTest(){
        System.out.println(helloService.getMsg());
        return helloService.getMsg();
    }
}

