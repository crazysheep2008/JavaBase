package com.beingmate.learn.map;

import java.util.HashMap;

/***
 * @author yfeng
 * @date 2018-05-08 15:06
 */
public class MapTest {
    public static void main(String[] args) {
        HashMap<Long, Long> map = new HashMap<Long, Long>();
        for (Long i = 0L; i < 10; i++) {
            map.put(i + 1, i + 1 + 20);
        }

        map.values().forEach(item->{
            System.out.println(item);
        });
    }
}
