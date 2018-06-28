package com.beingmate.learn.algorithm.leetcode.string;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author yfeng
 */
public class TinyUrl {
    private Map<String, String> map = new HashMap<>();
    private Map<String, String> longMap = new HashMap<>();
    private Random random = new Random();
    static String BASE_HOST = "http://tinyurl.com/";
    private static char[] charArray = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public String encode(String longUrl) {
        String shortUrl = longMap.get(longUrl);
        if (shortUrl != null) {
            return shortUrl;
        }
        String encode = randamHash();
        longMap.put(longUrl, encode);
        map.put(encode, longUrl);
        return BASE_HOST + encode;
    }

    private String randamHash() {
        String code = null;
        do {
            StringBuilder builder = new StringBuilder(6);
            for (int i = 0; i < 6; i++) {
                builder.append(charArray[random.nextInt(charArray.length)]);
            }
            code = builder.toString();
        } while (map.containsKey(code));
        return code;
    }

    public String decode(String shortUrl) {
        try {
            URL url = new URL(shortUrl);
            String path = url.getPath();
            if (path.length() == 0) {
                return null;
            }
            String code = path.substring(1);
            return map.get(code);
        } catch (Exception ex) {
            return null;
        }
    }


    public static void main(String[] args) {
        String longUrl = "https://blog.csdn.net/sunno_ya/article/details/70302945";
        TinyUrl tyinUrl = new TinyUrl();
        String shortUrl = tyinUrl.encode(longUrl);
        System.out.println(shortUrl);
        String decodeLongUrl = tyinUrl.decode(shortUrl);
        System.out.println(decodeLongUrl);
    }
}