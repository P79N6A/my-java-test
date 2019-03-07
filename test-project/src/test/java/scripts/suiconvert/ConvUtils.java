package scripts.suiconvert;

import org.apache.commons.lang3.StringUtils;

public class ConvUtils {
    public static final String[] trafficWords = {"滴滴", "优步"};
    public static final String[] mealWords = {"美团", "点评", "饿了么", "小度生活", "外卖"};
    public static final String[] mobileWords = {"联合网络通信"};

    public static String[] cateConv(String keywords) {
        String cate = "其他杂项";
        String secCate = "其他支出";

        if (StringUtils.containsAny(keywords, trafficWords)) {
            cate = "行车交通";
            secCate = "打车租车";
        } else if (StringUtils.containsAny(keywords, mealWords)) {
            cate = "食品酒水";
            secCate = "早午晚餐";
        } else if (StringUtils.containsAny(keywords, mobileWords)) {
            cate = "交流通讯";
            secCate = "手机费";
        }
        return new String[] {cate, secCate};
    }

    public static String accountConv(String bankName) {
        if (bankName.contains("招商银行")) {
            return "招商标准卡";
        } else if (bankName.contains("平安")) {
            return "平安银行淘宝";
        } else if (bankName.contains("零钱")) {
            return "微信零钱";
        } else if (bankName.contains("浦发银行")) {
            return "浦发信用卡";
        } else if (bankName.contains("光大银行")) {
            return "储蓄卡/借记卡";
        }
        return null;
    }

    public static String remarkGenerate(String... fields) {
        StringBuilder sb = new StringBuilder();
        for (String f : fields) {
            if (StringUtils.isNotEmpty(f)) {
                sb.append(f).append("_");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
