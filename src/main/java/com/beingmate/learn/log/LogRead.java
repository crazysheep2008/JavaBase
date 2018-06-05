package com.beingmate.learn.log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/***
 * @author yfeng
 * @date 2018-05-02 15:40
 */
public class LogRead {

    public static void main(String[] args) throws Exception {
        FileWriter fileWriter = new FileWriter("D:\\software\\export_sql_1814139\\sqlResult_1814139-new.csv");
        BufferedReader br = new BufferedReader(new FileReader("D:\\software\\export_sql_1814139\\sqlResult_1814139.csv"));
        String line = br.readLine();
        while (line != null) {
            if ("".equals(line.trim())) {

            } else {
                int firIndex = line.indexOf('"');
                int secIndex = line.indexOf('"', 1);
                String id = line.substring(firIndex + 1, secIndex);
             //   System.out.println(id);
                if (!id.endsWith("-")) {
                    line = line.replace(id, id + "-");
                }
                fileWriter.write(line + "\n");
            }
            line = br.readLine();
        }
        fileWriter.flush();
        fileWriter.close();
        br.close();
        System.out.println("----- success");
    }


}
