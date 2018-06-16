package com.beingmate.learn.algorithm.dynamic.num_tower;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/***
 * @author yfeng
 * @date 2018-06-13 13:07
 */
@Data
public class ThreeNumberTree {

    private static List<Long> parseInput(String line) {
        List<String> strs = Splitter.on(" ").trimResults().omitEmptyStrings().splitToList(line);
        if (strs.isEmpty()) {
            return Lists.newArrayList();
        }
        return strs.stream().map(item -> {
            return Long.parseLong(item);
        }).collect(Collectors.toList());
    }

    private static long[][] transform(List<List<Long>> inputs) {
        List<Integer> widths = inputs.stream().map(item -> {
            return item.size();
        }).collect(Collectors.toList());
        int maxWidth = Collections.max(widths);
        long[][] array = new long[inputs.size()][maxWidth];
        for (int i = 0; i < inputs.size(); i++) {
            List<Long> curList = inputs.get(i);
            array[i] = curList.stream().mapToLong(item -> {
                return item;
            }).toArray();
        }
        return array;
    }

    public static long findMaxPathSum(long[][] inputNums, int row, int index, Set<String> posLog) {
        long curVal = inputNums[row][index];
        if (row == inputNums.length - 1) {
            return curVal;
        }
        int leftChildIndex = index;
        int rightChildIndex = index + 1;
        long leftChildPathSum = findMaxPathSum(inputNums, row + 1, leftChildIndex, posLog);
        long rightChildPathSum = findMaxPathSum(inputNums, row + 1, rightChildIndex, posLog);
        if (leftChildPathSum > rightChildPathSum) {
            posLog.add(StringUtils.join(row + 1, ",", leftChildIndex));
            return curVal + leftChildPathSum;
        } else {
            posLog.add(StringUtils.join(row + 1, ",", rightChildIndex));
            return curVal + rightChildPathSum;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = null;
        List<List<Long>> inputs = Lists.newArrayList();
        while (scanner.hasNext()) {
            line = scanner.nextLine().trim();
            if (StringUtils.isBlank(line)) {
                System.out.println("当前行为空");
                continue;
            }
            if ("q".equalsIgnoreCase(line)) {
                System.out.println("完成输入!!!");
                break;
            }
            inputs.add(parseInput(line));
        }
        scanner.close();
        long[][] array = transform(inputs);
        System.out.println(JSON.toJSONString(array));

        Set<String> posLog = new LinkedHashSet<>();
        long maxPathSum = findMaxPathSum(array, 0, 0, posLog);
        System.out.println(String.format("结果:%s", maxPathSum));
        System.out.println("路线:" + JSON.toJSONString(posLog));
    }
}