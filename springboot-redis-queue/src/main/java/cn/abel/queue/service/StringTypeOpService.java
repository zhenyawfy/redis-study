package cn.abel.queue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class StringTypeOpService {
    @Autowired
    private RedisTemplate redisTemplate;

    public void setValue(String key, String value, int second) {
        redisTemplate.opsForValue().set(key, value, second);
    }

    public void setValue(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public Object getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void setIncrValue(String key) {
        redisTemplate.opsForValue().increment(key, 1);
    }

    public Set<Object> getTitles(String key) {
        return redisTemplate.opsForValue().getOperations().keys(key);
    }

    public void deleteKey(String key) {
        redisTemplate.opsForValue().getOperations().delete(key);
    }

    public void expire(String key) {
        redisTemplate.opsForValue().getOperations().expire(key, 1000, TimeUnit.SECONDS);
    }

    public long getExpire(String key) {
        return redisTemplate.opsForValue().getOperations().getExpire(key);
    }
}
