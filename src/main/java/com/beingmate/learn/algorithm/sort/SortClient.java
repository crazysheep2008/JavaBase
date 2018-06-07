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
        Class classType = MergeSort.class;
        SortAlgorithm sortAlgorithm = SortAlgorithmFactory.getSortAlgorithmInstance(classType);
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (StringUtils.isBlank(line)) {
            System.out.println("输入为空，请继续输入");
            line = scanner.nextLine();
        }
        List<String> items = Splitter.on(" ").trimResults().omitEmptyStrings().splitToList(line);
        int[] intArray = items.stream().mapToInt(item -> Integer.parseInt(item)).toArray();


        sortAlgorithm.sort(intArray);
    }
}