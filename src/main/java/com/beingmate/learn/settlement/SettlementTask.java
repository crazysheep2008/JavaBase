package com.beingmate.learn.settlement;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SettlementTask {
    private static void init(List<Long> ids, String strangeStoreIdStr) {
        if (StringUtils.isBlank(strangeStoreIdStr)) {
            return;
        }
        String[] datas = strangeStoreIdStr.split(",");
        if (datas.length == 0) {
            return;
        }
        for (String item : datas) {
            Long storeId = Long.parseLong(item);
            if (storeId > 0) {
                ids.add(storeId);
            }
        }
    }

    private static void initRefundStoreIds(List<Long> ids) {
        ids.add(124L);
        ids.add(229L);
        ids.add(414L);
        ids.add(438L);
        ids.add(440L);
        ids.add(507L);
        ids.add(590L);
        ids.add(625L);
        ids.add(703L);
        ids.add(747L);
        ids.add(774L);
        ids.add(787L);
        ids.add(788L);
        ids.add(796L);
        ids.add(978558817424949249L);
        ids.add(797L);
        ids.add(528L);
    }

    /*** 修复订单完成时间为空的店铺
     */
    private static void init(List<Long> ids) {
        ids.add(59L);
        ids.add(230L);
        ids.add(559L);
        ids.add(266L);
        ids.add(726L);
        ids.add(679L);
        ids.add(496L);
        ids.add(581L);
        ids.add(303L);
        ids.add(246L);
        ids.add(439L);
        ids.add(253L);
        ids.add(307L);
        ids.add(721L);
        ids.add(233L);
        ids.add(480L);
        ids.add(710L);
        ids.add(1L);
        ids.add(197L);
        ids.add(187L);
        ids.add(769L);
        ids.add(90L);
        ids.add(640L);
        ids.add(760L);
        ids.add(545L);
        ids.add(47L);
        ids.add(609L);
        ids.add(575L);
        ids.add(460L);
        ids.add(216L);
        ids.add(91L);
        ids.add(211L);
        ids.add(387L);
        ids.add(489L);
        ids.add(583L);
        ids.add(235L);
        ids.add(585L);
        ids.add(132L);
        ids.add(441L);
        ids.add(509L);
        ids.add(218L);
        ids.add(71L);
        ids.add(474L);
        ids.add(550L);
        ids.add(629L);
        ids.add(55L);
        ids.add(720L);
        ids.add(568L);
        ids.add(719L);
        ids.add(228L);
        ids.add(697L);
        ids.add(517L);
        ids.add(758L);
        ids.add(660L);
        ids.add(374L);
        ids.add(164L);
        ids.add(784L);
        ids.add(224L);
        ids.add(79L);
        ids.add(248L);
        ids.add(481L);
        ids.add(27L);
        ids.add(700L);
        ids.add(734L);
        ids.add(64L);
        ids.add(369L);
        ids.add(751L);
        ids.add(22L);
        ids.add(194L);
        ids.add(214L);
        ids.add(530L);
        ids.add(702L);
        ids.add(631L);
        ids.add(379L);
        ids.add(48L);
        ids.add(580L);
        ids.add(748L);
        ids.add(241L);
        ids.add(791L);
        ids.add(689L);
        ids.add(562L);
        ids.add(213L);
        ids.add(613L);
    }

    private static Charset UTF8 = Charset.forName("UTF-8");

    public static void main(String[] args) throws Exception {
        System.out.println("=-----------------------------------------------");
    }

    public static void job20180516() {
        System.out.println("=-=-=-=-=-=-=-=========================");
        List<Long> ids = new ArrayList<Long>();

        //订单完成时间缺失
        init(ids);

        //店铺商品佣金比例缺失
        ids.add(986169482258018306L);

        //店铺冻结
        initLostStoreIds(ids);

        //退款导致佣金计算错误的店铺结算单
        initRefundStoreIds(ids);

        List<Long> targetIds = new ArrayList<Long>(new HashSet<Long>(ids));
        for (Long id : targetIds) {
            submitSettlementTask("" + id, "2018-04-01", "2018-05-01");
        }
        submitSettlementTask("334", "2018-04-01", "2018-04-16");
        submitSettlementTask("334", "2018-04-16", "2018-05-01");
        submitSettlementTask("239", "2018-04-09", "2018-04-16");
        System.out.println("----------------------------------- 任务完成");
    }

    public static void initLostStoreIds(List<Long> ids) {
        ids.add(2L);
        ids.add(3L);
        ids.add(4L);
        ids.add(5L);
        ids.add(6L);
        ids.add(9L);
        ids.add(10L);
        ids.add(12L);
        ids.add(17L);
        ids.add(25L);
        ids.add(29L);
        ids.add(30L);
        ids.add(34L);
        ids.add(37L);
        ids.add(40L);
        ids.add(41L);
        ids.add(42L);
        ids.add(45L);
        ids.add(46L);
        ids.add(49L);
        ids.add(50L);
        ids.add(52L);
        ids.add(53L);
        ids.add(61L);
        ids.add(62L);
        ids.add(63L);
        ids.add(65L);
        ids.add(66L);
        ids.add(67L);
        ids.add(68L);
        ids.add(70L);
        ids.add(72L);
        ids.add(73L);
        ids.add(75L);
        ids.add(77L);
        ids.add(78L);
        ids.add(81L);
        ids.add(83L);
        ids.add(84L);
        ids.add(85L);
        ids.add(87L);
        ids.add(89L);
        ids.add(94L);
        ids.add(95L);
        ids.add(96L);
        ids.add(97L);
        ids.add(99L);
        ids.add(101L);
        ids.add(102L);
        ids.add(103L);
        ids.add(104L);
        ids.add(105L);
        ids.add(106L);
        ids.add(107L);
        ids.add(108L);
        ids.add(109L);
        ids.add(111L);
        ids.add(112L);
        ids.add(114L);
        ids.add(115L);
        ids.add(116L);
        ids.add(117L);
        ids.add(118L);
        ids.add(119L);
        ids.add(121L);
        ids.add(123L);
        ids.add(127L);
        ids.add(130L);
        ids.add(131L);
        ids.add(134L);
        ids.add(137L);
        ids.add(139L);
        ids.add(140L);
        ids.add(141L);
        ids.add(142L);
        ids.add(143L);
        ids.add(145L);
        ids.add(147L);
        ids.add(149L);
        ids.add(153L);
        ids.add(154L);
        ids.add(155L);
        ids.add(156L);
        ids.add(159L);
        ids.add(162L);
        ids.add(163L);
        ids.add(165L);
        ids.add(166L);
        ids.add(170L);
        ids.add(172L);
        ids.add(174L);
        ids.add(175L);
        ids.add(176L);
        ids.add(177L);
        ids.add(178L);
        ids.add(179L);
        ids.add(185L);
        ids.add(186L);
        ids.add(188L);
        ids.add(190L);
        ids.add(191L);
        ids.add(193L);
        ids.add(195L);
        ids.add(201L);
        ids.add(202L);
        ids.add(203L);
        ids.add(204L);
        ids.add(206L);
        ids.add(207L);
        ids.add(208L);
        ids.add(209L);
        ids.add(212L);
        ids.add(215L);
        ids.add(217L);
        ids.add(219L);
        ids.add(221L);
        ids.add(222L);
        ids.add(223L);
        ids.add(225L);
        ids.add(226L);
        ids.add(227L);
        ids.add(234L);
        ids.add(236L);
        ids.add(237L);
        ids.add(242L);
        ids.add(243L);
        ids.add(245L);
        ids.add(249L);
        ids.add(250L);
        ids.add(251L);
        ids.add(252L);
        ids.add(254L);
        ids.add(255L);
        ids.add(256L);
        ids.add(259L);
        ids.add(260L);
        ids.add(261L);
        ids.add(262L);
        ids.add(263L);
        ids.add(264L);
        ids.add(267L);
        ids.add(268L);
        ids.add(269L);
        ids.add(270L);
        ids.add(272L);
        ids.add(273L);
        ids.add(275L);
        ids.add(277L);
        ids.add(278L);
        ids.add(281L);
        ids.add(283L);
        ids.add(289L);
        ids.add(291L);
        ids.add(293L);
        ids.add(295L);
        ids.add(296L);
        ids.add(297L);
        ids.add(299L);
        ids.add(301L);
        ids.add(302L);
        ids.add(304L);
        ids.add(305L);
        ids.add(306L);
        ids.add(308L);
        ids.add(309L);
        ids.add(310L);
        ids.add(311L);
        ids.add(312L);
        ids.add(313L);
        ids.add(315L);
        ids.add(316L);
        ids.add(318L);
        ids.add(319L);
        ids.add(320L);
        ids.add(321L);
        ids.add(322L);
        ids.add(323L);
        ids.add(324L);
        ids.add(325L);
        ids.add(326L);
        ids.add(327L);
        ids.add(328L);
        ids.add(329L);
        ids.add(330L);
        ids.add(331L);
        ids.add(332L);
        ids.add(333L);
        ids.add(337L);
        ids.add(339L);
        ids.add(341L);
        ids.add(343L);
        ids.add(344L);
        ids.add(345L);
        ids.add(347L);
        ids.add(348L);
        ids.add(349L);
        ids.add(350L);
        ids.add(351L);
        ids.add(352L);
        ids.add(353L);
        ids.add(355L);
        ids.add(356L);
        ids.add(357L);
        ids.add(358L);
        ids.add(360L);
        ids.add(363L);
        ids.add(365L);
        ids.add(366L);
        ids.add(367L);
        ids.add(371L);
        ids.add(373L);
        ids.add(375L);
        ids.add(377L);
        ids.add(400L);
        ids.add(402L);
        ids.add(404L);
        ids.add(412L);
        ids.add(415L);
        ids.add(416L);
        ids.add(420L);
        ids.add(424L);
        ids.add(430L);
        ids.add(431L);
        ids.add(432L);
        ids.add(433L);
        ids.add(437L);
        ids.add(442L);
        ids.add(445L);
        ids.add(448L);
        ids.add(451L);
        ids.add(452L);
        ids.add(453L);
        ids.add(456L);
        ids.add(464L);
        ids.add(465L);
        ids.add(466L);
        ids.add(468L);
        ids.add(471L);
        ids.add(477L);
        ids.add(478L);
        ids.add(479L);
        ids.add(482L);
        ids.add(483L);
        ids.add(490L);
        ids.add(491L);
        ids.add(492L);
        ids.add(494L);
        ids.add(499L);
        ids.add(500L);
        ids.add(506L);
        ids.add(508L);
        ids.add(509L);
        ids.add(510L);
        ids.add(511L);
        ids.add(512L);
        ids.add(513L);
        ids.add(520L);
        ids.add(521L);
        ids.add(522L);
        ids.add(523L);
        ids.add(524L);
        ids.add(525L);
        ids.add(527L);
        ids.add(529L);
        ids.add(534L);
        ids.add(536L);
        ids.add(537L);
        ids.add(538L);
        ids.add(539L);
        ids.add(541L);
        ids.add(544L);
        ids.add(547L);
        ids.add(555L);
        ids.add(556L);
        ids.add(557L);
        ids.add(560L);
        ids.add(563L);
        ids.add(570L);
        ids.add(572L);
        ids.add(574L);
        ids.add(576L);
        ids.add(577L);
        ids.add(579L);
        ids.add(582L);
        ids.add(588L);
        ids.add(589L);
        ids.add(593L);
        ids.add(594L);
        ids.add(595L);
        ids.add(597L);
        ids.add(598L);
        ids.add(599L);
        ids.add(601L);
        ids.add(602L);
        ids.add(603L);
        ids.add(604L);
        ids.add(605L);
        ids.add(606L);
        ids.add(607L);
        ids.add(608L);
        ids.add(611L);
        ids.add(612L);
        ids.add(614L);
        ids.add(622L);
        ids.add(623L);
        ids.add(626L);
        ids.add(632L);
        ids.add(638L);
        ids.add(642L);
        ids.add(643L);
        ids.add(644L);
        ids.add(645L);
        ids.add(646L);
        ids.add(647L);
        ids.add(648L);
        ids.add(649L);
        ids.add(650L);
        ids.add(653L);
        ids.add(654L);
        ids.add(655L);
        ids.add(658L);
        ids.add(674L);
        ids.add(676L);
        ids.add(681L);
        ids.add(682L);
        ids.add(684L);
        ids.add(685L);
        ids.add(686L);
        ids.add(687L);
        ids.add(688L);
        ids.add(692L);
        ids.add(696L);
        ids.add(698L);
        ids.add(704L);
        ids.add(715L);
        ids.add(717L);
        ids.add(718L);
        ids.add(723L);
        ids.add(725L);
        ids.add(727L);
        ids.add(736L);
        ids.add(737L);
        ids.add(739L);
        ids.add(754L);
        ids.add(765L);
        ids.add(781L);
        ids.add(795L);
        ids.add(971191594158981122L);
        ids.add(971568873342713858L);
        ids.add(978892063979671553L);
        ids.add(987209715402600450L);
        ids.add(988240972942188545L);

    }

    public static void recove() {
        //  storeHalfMonthSettlement("17");

        submitSettlementTask("20", "2018-03-06", "2018-03-11");
        submitSettlementTask("20", "2018-03-11", "2018-03-16");
        submitSettlementTask("20", "2018-03-16", "2018-03-21");
        submitSettlementTask("20", "2018-03-21", "2018-03-26");
        submitSettlementTask("20", "2018-03-26", "2018-03-31");
        submitSettlementTask("20", "2018-03-31", "2018-04-05");
        submitSettlementTask("20", "2018-04-05", "2018-04-10");
    }

    private static String srcUrl = "http://api.motherbuy.com/settlement/task/action";

    private static void storeHalfMonthSettlement(String stroeId) {
        submitSettlementTask(stroeId, "2018-03-01", "2018-03-16");
        submitSettlementTask(stroeId, "2018-03-16", "2018-04-01");
    }

    private static void submitSettlementTask(String storeId, String startTime, String endTime) {
        try {
            System.out.println(storeId + " - " + startTime + " - " + endTime);
            int timeout = 4000;
            String content = Request.Post(srcUrl).bodyForm(Form.form()
                    .add("storeId", storeId).add("start", startTime).add("end", endTime)
                    .build(), UTF8).connectTimeout(timeout).socketTimeout(timeout).execute().returnContent().asString(UTF8);
            System.out.println(content);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
