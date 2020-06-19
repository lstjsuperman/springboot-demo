package com.learning.demo.controller;

import com.learning.demo.controller.model.TimeResponse;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @program: demo1
 * @description: 欢迎信息展示
 * @author: Jarek
 * @create: 2020-06-18 12:11
 **/
@Controller
public class WelcomeController {
    public static final String HOME_PATH = "//Users/momo/Desktop/file/";

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home() {
        // 这里返回success，thymeleaf会通过这个字符串，去templates下取同名的文件，进行返回
        return "success";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String welcome(@RequestParam("name") String userName) {
        System.out.println("UserName:" + userName);
        // 这里返回success，thymeleaf会通过这个字符串，去templates下取同名的文件，进行返回
        return "success";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload() {
        return "upload_file";
    }

    @RequestMapping(value = "/time", method = RequestMethod.GET)
    public @ResponseBody
    TimeResponse getTime() {
        TimeResponse response = new TimeResponse();
        response.setCode(200);
        response.setData(new Date().toString());
        return response;
    }

    @RequestMapping(value = "/upload-file", method = RequestMethod.POST)
    public @ResponseBody
    String uploadFile(@RequestParam(value = "fileName") String fileName, @RequestParam(value = "file") MultipartFile file) {
        if (StringUtils.isEmpty(fileName) || file == null) {
            return "failed";
        }
        File saveFile = new File(HOME_PATH + fileName);

        if (!saveFile.getParentFile().exists()) {
            saveFile.getParentFile().mkdirs();
        }
        if (saveFile.exists()) {
            saveFile.delete();
        }
        try {
            saveFile.createNewFile();
            file.transferTo(saveFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
