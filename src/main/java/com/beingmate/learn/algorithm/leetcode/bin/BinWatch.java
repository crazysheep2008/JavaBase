package com.beingmate.learn.algorithm.leetcode.bin;

import java.util.ArrayList;
import java.util.List;

/***
 * @author yfeng
 * @date 2018-08-06 20:04
 */
public class BinWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> results = new ArrayList();
        if (num < 0 || num > 10) {
            return results;
        }

        List<Integer> hours = new ArrayList();
        for (int i = 0; i <= num; i++) {
            hours.add(i);
        }

        for (int hour : hours) {
            List<String> times = getTimes(hour, num - hour);
            if (times.size() > 0) {
                results.addAll(times);
            }
        }
        return results;
    }

    public List<String> getTimes(int hourNum, int secNum) {
        List<String> resutls = new ArrayList<>();
        List<String> hours = getHours(hourNum);
        List<String> secs = getSecs(secNum);
        for (String hour : hours) {
            for (String sec : secs) {
                resutls.add(hour + ":" + sec);
            }
        }
        return resutls;
    }

    private List<String> getHours(int oneNum) {
        List<String> results = new ArrayList<>();
        for (int i = 0; i <= 11; i++) {
            if (oneCount(i) == oneNum) {
                results.add("" + i);
            }
        }
        return results;
    }

    private List<String> getSecs(int secNum) {
        List<String> results = new ArrayList<>();
        for (int i = 0; i <= 59; i++) {
            if (oneCount(i) == secNum) {
                if (i < 10) {
                    results.add("0" + i);
                } else {
                    results.add("" + i);
                }
            }
        }
        return results;
    }

    public int oneCount(int num) {
        int rest = num;
        int count = 0;
        while (rest > 0) {
            if ((rest & 1) == 1) {
                count++;
            }
            rest = rest >> 1;
        }
        return count;
    }
}