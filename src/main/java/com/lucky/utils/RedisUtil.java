package com.lucky.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * redis的工具类，通过xml的方式注入一个   bean->redisTemplate
 */
public class RedisUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisUtil.class);

    private RedisTemplate redisTemplate;


    /**
     * 存储string
     * @param key
     * @param value
     */
    public void putString(String key,String value){
        redisTemplate.opsForValue().set(key,value);
    }

    /**
     * 根据key取出value
     * @param key
     */
    public String getString(String key){

        String value =(String) redisTemplate.opsForValue().get(key);
        return value;
    }







    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
