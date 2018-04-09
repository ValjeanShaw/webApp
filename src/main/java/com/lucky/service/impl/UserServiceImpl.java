package com.lucky.service.impl;

import com.alibaba.fastjson.JSON;
import com.lucky.mapper.IUserMapper;
import com.lucky.pojo.User;
import com.lucky.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements IUserService{
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    IUserMapper userMapper;


    public User getUserById(int id) {
        User user = userMapper.getUserById(id);
        LOGGER.info("查询出结果:   {}", JSON.toJSONString(user));

        return user;

    }
}
