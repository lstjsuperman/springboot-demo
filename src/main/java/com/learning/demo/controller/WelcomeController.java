package com.learning.demo.controller;

import com.learning.demo.controller.model.TimeResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @program: demo1
 * @description: 欢迎信息展示
 * @author: Jarek
 * @create: 2020-06-18 12:11
 **/
@Controller
public class WelcomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String welcome(@RequestParam("name") String userName) {
        System.out.println("UserName:" + userName);
        // 这里返回success，thymeleaf会通过这个字符串，去templates下取同名的文件，进行返回
        return "success";
    }

    @RequestMapping(value = "/time", method = RequestMethod.GET)
    public @ResponseBody
    TimeResponse getTime() {
        TimeResponse response = new TimeResponse();
        response.setCode(200);
        response.setData(new Date().toString());
        return response;
    }
}
