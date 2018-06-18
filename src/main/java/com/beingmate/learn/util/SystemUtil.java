package com.beingmate.learn.util;

import com.google.common.base.Splitter;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SystemUtil {
    public static String scanSystemInput() {
        Scanner scanner = new Scanner(System.in);
        String line = null;
        System.out.println("请输入:");
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            if (StringUtils.isBlank(line)) {
                System.out.println("请重新输入:");
            } else {
                line = line.trim();
                break;
            }
        }
        scanner.close();
        return line;
    }

    public static int[] scanInputArray() {
        String line = scanSystemInput();
        List<String> inputs = Splitter.on(" ").trimResults().omitEmptyStrings().splitToList(line);
        List<Integer> intLists = inputs.stream().map(item -> {
            return Integer.parseInt(item);
        }).collect(Collectors.toList());
        return intLists.stream().mapToInt(Integer::intValue).toArray();
    }


}
