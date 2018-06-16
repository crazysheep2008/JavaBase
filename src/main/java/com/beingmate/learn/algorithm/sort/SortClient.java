package com.beingmate.learn.algorithm.sort;

import com.google.common.base.Splitter;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Scanner;

/***
 * @author yfeng
 * @date 2018-06-07 12:59
 */
public class SortClient {
    public static void main(String[] args) {
        SortAlgorithm sortAlgorithm = SortAlgorithmFactory.getSortAlgorithmInstance(QuickSort.class);
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入待排序数组:");
        String line = scanner.nextLine();
        while (StringUtils.isBlank(line)) {
            System.out.print("\\n输入为空，请继续输入");
            line = scanner.nextLine();
        }
        List<String> items = Splitter.on(" ").trimResults().omitEmptyStrings().splitToList(line);
        int[] intArray = items.stream().mapToInt(item -> Integer.parseInt(item)).toArray();
        sortAlgorithm.sort(intArray);
    }
}