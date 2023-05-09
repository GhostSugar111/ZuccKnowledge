package com.example.teachSystem.Serve;

import com.example.teachSystem.formbean.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {

    private final RedisDao redisDao;

    @Autowired
    public RedisServiceImpl(RedisDao redisDao) {
        this.redisDao = redisDao;
    }

    @Override
    public void set(String key, String value) {
        redisDao.set(key, value);
    }

    @Override
    public String get(String key) {
        return redisDao.get(key);
    }

    @Override
    public void setExpire(String key, String value, long expire, TimeUnit timeUnit) {
        redisDao.setExpire(key, value, expire, timeUnit);
    }

    @Override
    public void delete(String key) {
        redisDao.delete(key);
    }

    @Override
    public List<String> getList(String key, long start, long end) {
        return redisDao.getList(key, start, end);
    }

    @Override
    public void pushToList(String key, String value) {
        redisDao.pushToList(key, value);
    }

    @Override
    public long getListSize(String key) {
        return redisDao.getListSize(key);
    }
}
