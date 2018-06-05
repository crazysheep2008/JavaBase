package com.beingmate.learn.algorithm.greedy.carddispatch;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Splitter;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/***
 * @author yfeng
 * @date 2018-06-03 22:04
 */
public class CardDispatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (StringUtils.isBlank(input)) {
            System.out.println("输入不能为空");
            input = scanner.nextLine();
        }
        List<String> inputDatas = Splitter.on(" ").trimResults().omitEmptyStrings().splitToList(input);
        List<Long> longDatas = inputDatas.stream().map(val -> {
            return Long.parseLong(val);
        }).collect(Collectors.toList());

        Long sum = 0L;
        for (Long val : longDatas) {
            sum += val;
        }
        Long avg = sum / longDatas.size();
        int updateCount = 0;
        for (int i = 0; i < longDatas.size() - 1; i++) {
            Long curVal = longDatas.get(i);
            if (curVal.equals(avg)) {
                continue;
            }
            Long diff = curVal - avg;
            Long nextVal = longDatas.get(i + 1);
            longDatas.set(i, curVal - diff);
            longDatas.set(i + 1, nextVal + diff);
            updateCount++;
        }

        System.out.println(String.format("需要%s次", updateCount));
        System.out.println(JSON.toJSONString(longDatas));
    }
}
