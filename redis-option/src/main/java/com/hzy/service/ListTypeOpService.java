package com.hzy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListTypeOpService {
    @Autowired
    private RedisTemplate redisTemplate;

    public void leftPush(Object key, Object value) {
        redisTemplate.opsForList().leftPush(key, value);
    }

    public void rightPush(Object key, Object value) {
        redisTemplate.opsForList().rightPush(key, value);
    }

    public void leftPushAll (Object key, List<Object> list) {
        redisTemplate.opsForList().leftPushAll(key, list);
    }

    public void rightPushAll(Object key, List<Object> list) {
        redisTemplate.opsForList().rightPushAll(key, list);
    }

    public Object leftPop(Object key) {
        return redisTemplate.opsForList().leftPop(key);
    }

    public Object rightPop(Object key) {
        return redisTemplate.opsForList().rightPop(key);
    }

}
