package cn.abel.queue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class HashTypeOpService {
    @Autowired
    private RedisTemplate redisTemplate;


    public void hSet(Object key, Object member, Object value) {
        redisTemplate.opsForHash().put(key, member, value);
    }

    public void hMSet(Object key, Map<Object, Object> map) {
        redisTemplate.opsForHash().putAll(key,map);
    }

    public Object hGet(Object key, Object member) {
        return redisTemplate.opsForHash().get(key, member);
    }

    public List<Object> hMGet(Object key, List<Object> members) {
        return redisTemplate.opsForHash().multiGet(key, members);
    }

    public void hSetNx(Object key, Object member, Object value) {
        redisTemplate.opsForHash().putIfAbsent(key, member, value);
    }

    public Set<Object> hKeys(String key) {
        return redisTemplate.opsForHash().keys(key);
    }

    public Map<Object, Object> hValues(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

}
