package com.beingmate.learn.sql;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/***
 * @author yfeng
 * @date 2018-06-12 16:20
 */
public class MemberSQL {
    public static void main(String[] args) throws Exception {
        File file = new File("D:\\文档\\异常用户\\禁用id集合.txt");
        Scanner scanner = new Scanner(file);
        String line = null;
        List<String> ids = new ArrayList<>(10 * 10000);
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            if (StringUtils.isBlank(line)) {
                continue;
            }
            ids.add(line);
        }

        BufferedWriter bw = Files.newWriter(new File("D:\\文档\\异常用户\\forbidden-01.txt"), Charset.forName("UTF-8"));
        List<List<String>> idListLists = Lists.partition(ids, 1000);
        for (List<String> idList : idListLists) {
            String idIn = Joiner.on(",").join(idList);
            String sql = Joiner.on(" ").join("UPDATE `t_mem_member` set " +
                    "`accountState` = 1,`lastLoginTime` = now(),`memo` = '疑似垃圾账号' WHERE id IN (", idIn, ");\n");
            bw.append(sql);
        }
        bw.flush();
        bw.close();

    }
}
