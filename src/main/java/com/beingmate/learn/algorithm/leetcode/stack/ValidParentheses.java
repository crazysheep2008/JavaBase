package com.beingmate.learn.algorithm.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/***
 * @author yfeng
 * @date 2018-06-28 17:45
 */
public class ValidParentheses {
    private static Map<Character, Character> pairMap = new HashMap<>();

    static {
        pairMap.put('[', ']');
        pairMap.put('(', ')');
        pairMap.put('{', '}');
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid("{"));
        System.out.println(vp.isValid("{}"));
        System.out.println(vp.isValid("{()}"));
        System.out.println(vp.isValid("({]}"));
        System.out.println(vp.isValid(""));
    }

    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        int len = s.length();
        if (len == 0) {
            return true;
        }
        if (len % 2 != 0) {
            return false;
        }
        Stack<Character> matchStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character curChar = s.charAt(i);
            if (matchStack.isEmpty()) {
                if (pairMap.containsValue(curChar)) {
                    return false;
                }
                matchStack.push(curChar);
                continue;
            }
            if (pairMap.containsValue(curChar)) {
                Character topChar = matchStack.pop();
                if (!pairMap.get(topChar).equals(curChar)) {
                    return false;
                }
            } else {
                matchStack.push(curChar);
            }
        }
        return matchStack.isEmpty();
    }
}