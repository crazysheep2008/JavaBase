package com.beingmate.learn.concurrent.cache;

import com.alibaba.fastjson.JSON;

import java.util.LinkedHashMap;
import java.util.Map;

/***
 * @author yfeng
 * @date 2018-05-14 19:36
 */
public class LRUCache extends LinkedHashMap<String, Long> {
    private int size;

    public LRUCache(int size) {
        super(size, 0.75F, true);
        this.size = size;
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<String, Long> eldest) {
        return size() > size;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(10);
        for (Long i = 1L; i <= 12; i++) {
            cache.put("key-" + i, i);
        }
        System.out.println(JSON.toJSONString(cache, true));
    }
}