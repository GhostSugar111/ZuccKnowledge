package com.example.teachSystem.formbean;

import java.util.List;
import java.util.concurrent.TimeUnit;

public interface RedisDao {
    void set(String key, String value);

    String get(String key);

    void setExpire(String key, String value, long expire, TimeUnit timeUnit);

    void delete(String key);

    List<String> getList(String key, long start, long end);

    void pushToList(String key, String value);

    long getListSize(String key);
}
