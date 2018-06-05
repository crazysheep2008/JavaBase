package com.beingmate.learn.bigfile_sort;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/***
 * @author yfeng
 * @date 2018-05-28 14:27
 */
public class BigFileSort {
    private static String file = "D://logs//big_numbers.log";
    private static Random random = new Random(Long.MAX_VALUE);
    private static Long numCount = 100000000L;

    private static void generateBigRandamFile() {
        try {
            FileWriter fileWriter = new FileWriter(file);
            for (int i = 1; i < numCount; i++) {
                fileWriter.write(random.nextLong() + "\r\n");
            }
            fileWriter.flush();
            fileWriter.close();
            System.out.println("生成完成");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void splitBigFile(int num) {
        List<FileWriter> writers = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            try {
                FileWriter writer = new FileWriter(StringUtils.join("D://logs//split_files//sub_", i, ".log"));
                writers.add(writer);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        int writerSize = writers.size();

        try {
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String line = br.readLine();
            long i = 0;
            while (line != null) {
                Long index = (i++) % writerSize;
                FileWriter writer = writers.get(index.intValue());
                writer.append(line + "\r\n");
                line = br.readLine();
            }
            for (FileWriter fileWriter : writers) {
                fileWriter.flush();
                fileWriter.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private static void sortFiles(String dirPath, String tag, String targetTag) {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        for (File file : files) {
            String path = file.getAbsolutePath();
            sortSmallFile(path, path.replace(tag, targetTag));
        }
    }

    private static void mergeFiles(String dirPath, String targetPath) {
        FileIterator fileIterator = new FileIterator(dirPath);
        try {
            FileWriter fileWriter = new FileWriter(targetPath);
            while (fileIterator.next()) {
                Long value = fileIterator.value();
                fileWriter.append(value + "\r\n");
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void sortSmallFile(String path, String targetPath) {
        try {
            //读取
            FileReader reader = new FileReader(path);
            BufferedReader br = new BufferedReader(reader);
            String line = br.readLine();
            List<Long> nums = new ArrayList<>();
            while (line != null) {
                nums.add(Long.parseLong(line));
                line = br.readLine();
            }

            //排序
            Collections.sort(nums);

            //写入新文件
            FileWriter fileWriter = new FileWriter(targetPath);
            for (Long num : nums) {
                fileWriter.append(num + "\r\n");
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        generateBigRandamFile();
        splitBigFile(200);
        sortFiles("D://logs//split_files//", "split_files", "sorted_files");

        String dirPath = "D://logs//sorted_files//";
        mergeFiles(dirPath, "D://logs//big_numbers_sorted.log");

        System.out.println("完成");
    }
}