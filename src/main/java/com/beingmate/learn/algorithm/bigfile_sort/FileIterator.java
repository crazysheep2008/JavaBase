package com.beingmate.learn.algorithm.bigfile_sort;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/***
 * @author yfeng
 * @date 2018-05-28 19:17
 */
public class FileIterator {
    private List<BufferedReader> brList;
    private HashMap<BufferedReader, Long> fileValueMap;

    private int currentBufferReaderIndex = -1;
    private boolean first = true;

    public FileIterator(String dirPath) {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        brList = new ArrayList<>(files.length);
        try {
            for (File file : files) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                brList.add(br);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        init();
    }

    private void init() {
        fileValueMap = new HashMap<>();
        for (BufferedReader br : brList) {
            try {
                String line = br.readLine();
                if (StringUtils.isNotBlank(line)) {
                    Long value = Long.parseLong(line);
                    fileValueMap.put(br, value);
                }
            } catch (Exception ex) {
            }
        }

        //查找当前最小的
        caculateMinFileIndex();
    }

    private boolean caculateMinFileIndex() {
        if (brList.isEmpty()) {
            return false;
        }

        int minIndex = 0;
        BufferedReader minValueBufferReader = brList.get(0);
        Long minVal = fileValueMap.get(minValueBufferReader);

        for (int i = 1; i < brList.size(); i++) {
            BufferedReader compareBr = brList.get(i);
            Long compareVal = fileValueMap.get(compareBr);
            if (compareVal < minVal) {
                minVal = compareVal;
                minIndex = i;
            }
        }
        currentBufferReaderIndex = minIndex;
        return true;
    }


    public boolean next() {
        if (first) {
            first = false;
            return true;
        } else {
            BufferedReader curBufferReader = brList.get(currentBufferReaderIndex);
            try {
                String line = curBufferReader.readLine();
                if (StringUtils.isBlank(line)) {
                    fileValueMap.remove(curBufferReader);
                    brList.remove(currentBufferReaderIndex);
                } else {
                    Long val = Long.parseLong(line);
                    fileValueMap.put(curBufferReader,val);
                }
                return caculateMinFileIndex();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return true;
    }

    public Long value() {
        BufferedReader curBufferReader = brList.get(currentBufferReaderIndex);
        return fileValueMap.get(curBufferReader);
    }
}