package com.lucky.service.impl;

import com.alibaba.fastjson.JSON;
import com.lucky.mapper.IUserMapper;
import com.lucky.pojo.User;
import com.lucky.service.IUserService;
import com.lucky.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class UserServiceImpl implements IUserService{
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    IUserMapper userMapper;

    @Autowired
    RedisUtil redisUtil;

    public User getUserById(int id) {

        String result = redisUtil.getString("user"+id);

        LOGGER.info("redis查询出结果:   {}",result);
        if(result != null && !result.equals("null") ){
            return (User) JSON.parseObject(result,User.class);
        }

        User user = userMapper.getUserById(id);
        LOGGER.info("查询出结果:   {}", JSON.toJSONString(user));
        redisUtil.putString("user"+id,JSON.toJSONString(user));
        return user;

    }

    public static void main(String args[]){
        User user1 = new User();
        user1.setId(1000);
        user1.setUsername("sdfa");
        user1.setPassword("wef");

        String json = JSON.toJSONString(user1);
        User user = JSON.parseObject(json,User.class);
        System.out.println(user);
    }

}
