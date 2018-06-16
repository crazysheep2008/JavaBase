package com.beingmate.learn.base.bigfile;

import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class BigFileGenerator {
    private static Random random = new Random();

    private static void generateBigRandamFile(File file, int numCount) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            for (int i = 1; i < numCount; i++) {
                fileWriter.write(random.nextInt(10000) + "\r\n");
            }
            fileWriter.flush();
            fileWriter.close();
            System.out.println("生成完成");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File file = new File("D://logs/mass_numbers_2.log");
        generateBigRandamFile(file,  2000);
    }
}
