package com.beingmate.learn.algorithm.bit;

/***
 * @author yfeng
 * @date 2018-07-31 10:25
 */
public class NumToHex {
    public static void main(String[] args) {
        NumToHex nth = new NumToHex();
        System.out.println(nth.toHex(-1));
    }

    public String toHex(int num) {
        String ls = new String("0123456789abcdef");
        StringBuffer buf = new StringBuffer();
        int rest = num;
        int len = 0;
        do {
            int curVal = rest & 0xf;
            buf.append(ls.charAt(curVal));
            rest = rest >> 4;
            len++;
        } while (rest != 0 && len < 8);
        return buf.toString();
    }

    private char hexChar(int num) {
        int a = 97;
        int zero = 48;
        if (num >= 10) {
            return (char) (a + num - 10);
        }
        return (char) (zero + num);
    }

    public String toHex1(int num) {
        if (num == 0) {
            return "0";
        }
        boolean negtive = num < 0;
        int rest = negtive ? -num : num;
        int size = 8;
        int[] nums = new int[size];

        for (int i = 0; i < 8; i++) {
            int curNum = rest % 16;
            curNum = negtive ? (15 - curNum) : curNum;
            nums[size - 1 - i] = curNum;
            rest = rest / 16;
        }

        //负数取反 + 1
        if (negtive) {
            int extraHighVal = 1;
            int idx = size - 1;
            do {
                int curVal = nums[idx] + extraHighVal;
                if (curVal >= 16) {
                    extraHighVal = 1;
                    nums[idx] = curVal % 16;
                } else {
                    extraHighVal = 0;
                    nums[idx] = curVal;
                }
                idx--;
            } while (extraHighVal > 0 && idx >= 0);
        }

        StringBuffer buf = new StringBuffer();
        int len = 0;
        for (int curNum : nums) {
            if (len == 0 && curNum == 0) {
                continue;
            }
            buf.append(hexChar(curNum));
            len++;
        }
        return buf.toString();
    }
}
