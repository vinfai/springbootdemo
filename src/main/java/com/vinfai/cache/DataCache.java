package com.vinfai.cache;

import com.google.common.collect.Maps;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 缓存测试
 * @author vinfai
 * @since 2017/5/17
 */
@Component
public class DataCache {

    private Map<Long,String> dataMap = Maps.newHashMap();


    @PostConstruct
    public void init() {
        System.out.println("data cache inited by @postConstruct.");
        dataMap.put(1L, "Mr.1");
        dataMap.put(2L, "Mr.2");
        dataMap.put(3L, "Mrs.3");
    }

    @Cacheable(cacheNames = "cacheDemo", key = "#id+'dataMap'")
    public String query(Long id) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()) + " : query id is " + id);
        return dataMap.get(id);
    }

    @CachePut(cacheNames = "cacheDemo", key = "#id+'dataMap'")
    public String put(Long id, String value) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()) + " : query id is " + id);
        dataMap.put(id, value);
        return value;
    }

    @CacheEvict(cacheNames = "cacheDemo", key = "#id+'dataMap'")
    public void remove(Long id) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()) + " : query id is " + id);
        dataMap.remove(id);
    }
}
