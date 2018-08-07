package com.beingmate.learn.algorithm.leetcode.math;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/***
 *  https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * @author yfeng
 * @date 2018-08-06 21:13
 */
public class PhoneNums {
    String[] hash = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        PhoneNums pn = new PhoneNums();
        List<String> datas = pn.letterCombinations("23");
        System.out.println(JSON.toJSONString(datas));
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            List<String> result = new ArrayList<>();
            return result;
        }
        List<String> lists = new ArrayList<>();
        Character curNumChar = digits.charAt(0);
        int num = Integer.parseInt(curNumChar.toString());
        String chars = hash[num];
        List<String> subStrings = letterCombinations(digits.substring(1));
        for (int i = 0; i < chars.length(); i++) {
            char curChar = chars.charAt(i);
            if (subStrings.isEmpty()) {
                lists.add("" + curChar);
            } else {
                for (String subStr : subStrings) {
                    StringBuffer buf = new StringBuffer();
                    buf.append(curChar).append(subStr);
                    lists.add(buf.toString());
                }
            }
        }
        return lists;
    }
}
