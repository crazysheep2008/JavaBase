package com.beingmate.learn.algorithm.max_k;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class MaxKClient {
    public static void main(String[] args) {
        String filePath = "D:\\logs\\maxK.log";
        filePath = "D:\\logs\\mass_numbers.log";
        int topK = 10000;
        File file = new File(filePath);

        List<MaxKAlg> maxKAlgs = Lists.newArrayList(new InsertSortMaxK(topK), new HeapMaxK(topK), new SimpleMaxK(topK));

        List<Long> datas = new ArrayList<>(500 * 1000);
        int dataCount = 0;
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (StringUtils.isBlank(line)) {
                    continue;
                }
                try {
                    Long numVal = Long.parseLong(line.trim());
                    datas.add(numVal);
                    dataCount++;

                    if (dataCount == 300 * 10000) {
                        loadDatas(datas, maxKAlgs);
                        dataCount = 0;
                    }
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        } finally {
            if (scanner == null) {
                scanner.close();
            }
        }

        loadDatas(datas, maxKAlgs);

        for (MaxKAlg maxKAlg : maxKAlgs) {
            System.out.println("==============================================================================================================================");
            Long[] maxKNums = maxKAlg.getResult();
            Arrays.sort(maxKNums);
            System.out.println(JSON.toJSON(maxKNums));
            System.out.println(String.format("%s 花费时间: %s 毫秒", maxKAlg.name(), maxKAlg.getSpend()));
        }
    }

    private static void loadDatas(List<Long> datas, List<MaxKAlg> maxKAlgs) {
        if (CollectionUtils.isEmpty(datas)) {
            return;
        }
        for (MaxKAlg maxK : maxKAlgs) {
            maxK.loadData(datas);
        }
        datas.clear();
    }

}