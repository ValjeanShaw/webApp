package com.lucky.controller;

import com.alibaba.fastjson.JSON;
import com.lucky.pojo.User;
import com.lucky.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    IUserService userService;

    @RequestMapping(value="/getUserById")
    @ResponseBody
    public String getUserById(int id){

        User user = userService.getUserById(id);
        String result = JSON.toJSONString(user);

        LOGGER.info("查询出结果:   {}", result);

        return result;
    }


}
