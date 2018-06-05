package com.beingmate.learn.sql;

import java.io.FileWriter;

/***
 * @author yfeng
 * @date 2018-03-06 16:27
 */
public class SQLGenerator {

    public static void main(String[] args) {
        String cardLogTableSql = getCardLogTableSQLs(128);
        String balanceLogTableSql = getBalanceLogTableSQLs(128);
        String pointLogTableSql = getPointsLogTableSQLs(128);

        StringBuffer buffer = new StringBuffer();
        buffer.append(cardLogTableSql);
        buffer.append(balanceLogTableSql);
        buffer.append(pointLogTableSql);

        try {
            FileWriter fileWriter = new FileWriter("D:/data_clone.sql");
            fileWriter.write(buffer.toString());
            fileWriter.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static String getCardLogTableSQLs(int tableCount) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < tableCount; i++) {
            buffer.append("CREATE TABLE `shopnc_balance_log_" + i + "` (\n" +
                    "  `pl_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '余额日志编号',\n" +
                    "  `pppl_memberid` int(11) DEFAULT NULL,\n" +
                    "  `pl_membername` varchar(100) NOT NULL COMMENT '会员名称',\n" +
                    "  `pl_memberMobile` varchar(20) DEFAULT NULL COMMENT '用户手机',\n" +
                    "  `beforeAmount` decimal(18,6) DEFAULT NULL COMMENT '上次余额',\n" +
                    "  `pl_amount` decimal(18,6) DEFAULT NULL COMMENT '变动金额',\n" +
                    "  `pl_remianAmount` decimal(18,6) DEFAULT NULL COMMENT '当前余额',\n" +
                    "  `pl_addtime` int(11) DEFAULT NULL COMMENT '新增时间',\n" +
                    "  `pl_addtime_str` varchar(255) DEFAULT NULL,\n" +
                    "  `pl_reason` varchar(100) DEFAULT NULL COMMENT '原因',\n" +
                    "  `pl_transactionSn` varchar(50) DEFAULT NULL COMMENT '交易单号',\n" +
                    "  PRIMARY KEY (`pl_id`),\n" +
                    "  KEY `pl_member_id` (`pppl_memberid`) USING BTREE,\n" +
                    "  KEY `pl_addtime` (`pl_addtime`) USING BTREE,\n" +
                    "  KEY `pl_reason` (`pl_reason`) USING BTREE,\n" +
                    "  KEY `pl_transactionSn` (`pl_transactionSn`) USING BTREE\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员余额日志表';\n");
        }
        return buffer.toString();
    }

    private static String getPointsLogTableSQLs(int tableCount) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < tableCount; i++) {
            buffer.append("CREATE TABLE `shopnc_points_log_" + i + "` (\n" +
                    "  `pl_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '积分日志编号',\n" +
                    "  `pppl_memberid` int(11) DEFAULT NULL,\n" +
                    "  `pl_membername` varchar(100) NOT NULL COMMENT '会员名称',\n" +
                    "  `pl_memberMobile` varchar(20) DEFAULT NULL COMMENT '用户手机',\n" +
                    "  `pl_adminid` int(11) DEFAULT NULL COMMENT '管理员编号',\n" +
                    "  `pl_adminname` varchar(100) DEFAULT NULL COMMENT '管理员名称',\n" +
                    "  `beforeIntegral` int(11) DEFAULT NULL COMMENT '之前积分',\n" +
                    "  `pl_points` int(11) DEFAULT NULL COMMENT '积分数负数表示扣除',\n" +
                    "  `remainIntegral` int(11) DEFAULT NULL COMMENT '当前剩余积分',\n" +
                    "  `pl_addtime` int(11) DEFAULT NULL COMMENT '添加时间',\n" +
                    "  `pl_desc` varchar(100) DEFAULT NULL COMMENT '操作描述',\n" +
                    "  `pl_stage` varchar(50) DEFAULT NULL COMMENT '操作阶段',\n" +
                    "  `pl_transactionSn` varchar(50) DEFAULT NULL COMMENT '交易单号',\n" +
                    "  `pl_addtime_str` varchar(100) DEFAULT NULL COMMENT '添加时间',\n" +
                    "  PRIMARY KEY (`pl_id`),\n" +
                    "  KEY `pl_member_id` (`pppl_memberid`) USING BTREE,\n" +
                    "  KEY `pl_addtime` (`pl_addtime`) USING BTREE,\n" +
                    "  KEY `pl_desc` (`pl_desc`) USING BTREE,\n" +
                    "  KEY `pl_transactionSn` (`pl_transactionSn`) USING BTREE\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员积分日志表';\n");
        }
        return buffer.toString();
    }

    private static String getBalanceLogTableSQLs(int tableCount) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < tableCount; i++) {
            buffer.append("CREATE TABLE `shopnc_balance_log_" + i + "` (\n" +
                    "  `pl_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '余额日志编号',\n" +
                    "  `pppl_memberid` int(11) DEFAULT NULL,\n" +
                    "  `pl_membername` varchar(100) NOT NULL COMMENT '会员名称',\n" +
                    "  `pl_memberMobile` varchar(20) DEFAULT NULL COMMENT '用户手机',\n" +
                    "  `beforeAmount` decimal(18,6) DEFAULT NULL COMMENT '上次余额',\n" +
                    "  `pl_amount` decimal(18,6) DEFAULT NULL COMMENT '变动金额',\n" +
                    "  `pl_remianAmount` decimal(18,6) DEFAULT NULL COMMENT '当前余额',\n" +
                    "  `pl_addtime` int(11) DEFAULT NULL COMMENT '新增时间',\n" +
                    "  `pl_addtime_str` varchar(255) DEFAULT NULL,\n" +
                    "  `pl_reason` varchar(100) DEFAULT NULL COMMENT '原因',\n" +
                    "  `pl_transactionSn` varchar(50) DEFAULT NULL COMMENT '交易单号',\n" +
                    "  PRIMARY KEY (`pl_id`),\n" +
                    "  KEY `pl_member_id` (`pppl_memberid`) USING BTREE,\n" +
                    "  KEY `pl_addtime` (`pl_addtime`) USING BTREE,\n" +
                    "  KEY `pl_reason` (`pl_reason`) USING BTREE,\n" +
                    "  KEY `pl_transactionSn` (`pl_transactionSn`) USING BTREE\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员余额日志表';\n");
        }
        return buffer.toString();
    }
}