package scripts.suiconvert;

public class ConvUtils {
    public static String[] cateConv(String keywords) {
        String cate = "其他杂项";
        String secCate = "其他支出";
        return new String[]{cate, secCate};
    }

    public static String accountConv(String bankName) {
        if (bankName.contains("招商银行")) {
            return "招商标准卡";
        } else if (bankName.contains("平安")) {
            return "平安银行淘宝";
        } else if (bankName.contains("零钱")) {
            return "微信零钱";
        } else if (bankName.contains("浦发银行")) {
            return "浦发银行";
        } else if (bankName.contains("光大银行")) {
            return "储蓄卡/借记卡";
        }
        return null;
    }
}
