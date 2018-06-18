package com.beingmate.learn.algorithm.group_anagrams;

import com.alibaba.fastjson.JSON;

import java.util.*;

/***
 * https://leetcode-cn.com/problems/group-anagrams/description/
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 输出:
   [
    ["ate","eat","tea"],
    ["nat","tan"],
    ["bat"]
   ]
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] inputArray = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groups = groupAnagrams(inputArray);
        System.out.println(JSON.toJSONString(groups));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> maps = new HashMap();
        for (String item : strs) {
            String key = transform(item);
            List<String> list = maps.get(key);
            if (list == null) {
                list = new ArrayList<>();
                maps.put(key, list);
            }
            list.add(item);
        }
        List<List<String>> groupJoins = new ArrayList<List<String>>();
        for (List<String> list : maps.values()) {
            groupJoins.add(list);
        }
        return groupJoins;
    }

    public static String transform(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
