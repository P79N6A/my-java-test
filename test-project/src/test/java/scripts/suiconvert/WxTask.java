package scripts.suiconvert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;

public class WxTask {

    public static void main(String[] args) {
        String wxJson = "";
        WxTask.pinganJsonToCsv(wxJson);
    }

    public static void pinganJsonToCsv(String jsonString) {
        WxResult json = JSONObject.parseObject(jsonString, WxResult.class);
        List<WxResult.RecordBean> list = json.getRecord();
        renderRow(list);
    }

    public static void renderRow(List<WxResult.RecordBean> list) {
        for (WxResult.RecordBean bean : list) {
            if ("neutral".equals(bean.getFeeAttr())) {
                continue;
            }
            String type = bean.getFeeAttr().equals("positive") ? "收入" : "支出";
            String date = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(bean.getTimestamp() * 1000L));
            String account1 = ConvUtils.accountConv(bean.getPayBankName());
            if (account1 == null) {
//                System.out.println(JSON.toJSONString(bean));
                if (bean.getBillType() == 6) {
                    // 这是群收款
                    account1 = "微信零钱";
                } else if (bean.getBillType() == 4) {
                    // 这是转账收
                    account1 = "微信零钱";
                } else {
//                    account1 = "";
                    continue;
                }
            }
            String account2 = "";
            String money = String.valueOf(bean.getFee() / 100.0);
            String member = "";
            String merchant = "";
            String project = "";
            String remark = bean.getRemark() + " " + bean.getTitle();
            String cate[] = ConvUtils.cateConv(bean.getTitle());

            SuiRow suiRow = new SuiRow();
            suiRow.setType(type);
            suiRow.setDate(date);
            suiRow.setCate(cate[0]);
            suiRow.setSedCate(cate[1]);
            suiRow.setAccount1(account1);
            suiRow.setAccount2(account2);
            suiRow.setMoney(money);
            suiRow.setMember(member);
            suiRow.setMerchant(merchant);
            suiRow.setProject(project);
            suiRow.setRemark(remark);
            System.out.println(suiRow.toConsoleString());
        }
    }

    @Data
    static class WxResult {

        @JSONField(name = "ret_code")
        private int retCode;
        @JSONField(name = "ret_msg")
        private String retMsg;
        @JSONField(name = "total")
        private int total;
        @JSONField(name = "last_bill_id")
        private String lastBillId;
        @JSONField(name = "last_bill_type")
        private int lastBillType;
        @JSONField(name = "last_trans_id")
        private String lastTransId;
        @JSONField(name = "last_create_time")
        private int lastCreateTime;
        @JSONField(name = "is_over")
        private boolean isOver;
        @JSONField(name = "statistic")
        private List<StatisticBean> statistic;
        @JSONField(name = "record")
        private List<RecordBean> record;

        @Data
        public static class StatisticBean {
            @JSONField(name = "year")
            private int year;
            @JSONField(name = "month")
            private int month;
            @JSONField(name = "receive_fee")
            private int receiveFee;
            @JSONField(name = "pay_fee")
            private int payFee;
            @JSONField(name = "fee_unit")
            private String feeUnit;
            @JSONField(name = "userroll_count")
            private int userrollCount;
        }

        @Data
        public static class RecordBean {
            @JSONField(name = "bill_id")
            private String billId;
            @JSONField(name = "trans_id")
            private String transId;
            @JSONField(name = "title")
            private String title;
            @JSONField(name = "timestamp")
            private int timestamp;
            @JSONField(name = "fee")
            private int fee;
            @JSONField(name = "fee_type")
            private String feeType;
            @JSONField(name = "fee_attr")
            private String feeAttr;
            @JSONField(name = "current_state")
            private String currentState;
            @JSONField(name = "current_state_type")
            private String currentStateType;
            @JSONField(name = "bill_type")
            private int billType;
            @JSONField(name = "icon_url")
            private String iconUrl;
            @JSONField(name = "out_trade_no")
            private String outTradeNo;
            @JSONField(name = "total_refund_fee")
            private int totalRefundFee;
            @JSONField(name = "classify_type")
            private int classifyType;
            @JSONField(name = "pay_bank_name")
            private String payBankName;
            @JSONField(name = "remark")
            private String remark;
            @JSONField(name = "business_data")
            private String businessData;
            @JSONField(name = "charge_fee")
            private int chargeFee;
            @JSONField(name = "payer_remark")
            private String payerRemark;
            @JSONField(name = "payer_uin")
            private long payerUin;
            @JSONField(name = "payer_wxid")
            private String payerWxid;
            @JSONField(name = "is_friend")
            private boolean isFriend;
            @JSONField(name = "coupon")
            private CouponBean coupon;

            @Data
            public static class CouponBean {
                @JSONField(name = "trans_fee")
                private int transFee;
                @JSONField(name = "coupon_fee")
                private int couponFee;
                @JSONField(name = "coupon_desc")
                private List<?> couponDesc;
            }
        }
    }
}
