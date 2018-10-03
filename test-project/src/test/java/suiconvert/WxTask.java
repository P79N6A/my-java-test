package suiconvert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
            System.out.println(suiRow);
        }
    }


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

        public int getRetCode() {
            return retCode;
        }

        public void setRetCode(int retCode) {
            this.retCode = retCode;
        }

        public String getRetMsg() {
            return retMsg;
        }

        public void setRetMsg(String retMsg) {
            this.retMsg = retMsg;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public String getLastBillId() {
            return lastBillId;
        }

        public void setLastBillId(String lastBillId) {
            this.lastBillId = lastBillId;
        }

        public int getLastBillType() {
            return lastBillType;
        }

        public void setLastBillType(int lastBillType) {
            this.lastBillType = lastBillType;
        }

        public String getLastTransId() {
            return lastTransId;
        }

        public void setLastTransId(String lastTransId) {
            this.lastTransId = lastTransId;
        }

        public int getLastCreateTime() {
            return lastCreateTime;
        }

        public void setLastCreateTime(int lastCreateTime) {
            this.lastCreateTime = lastCreateTime;
        }

        public boolean isIsOver() {
            return isOver;
        }

        public void setIsOver(boolean isOver) {
            this.isOver = isOver;
        }

        public List<StatisticBean> getStatistic() {
            return statistic;
        }

        public void setStatistic(List<StatisticBean> statistic) {
            this.statistic = statistic;
        }

        public List<RecordBean> getRecord() {
            return record;
        }

        public void setRecord(List<RecordBean> record) {
            this.record = record;
        }

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

            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }

            public int getMonth() {
                return month;
            }

            public void setMonth(int month) {
                this.month = month;
            }

            public int getReceiveFee() {
                return receiveFee;
            }

            public void setReceiveFee(int receiveFee) {
                this.receiveFee = receiveFee;
            }

            public int getPayFee() {
                return payFee;
            }

            public void setPayFee(int payFee) {
                this.payFee = payFee;
            }

            public String getFeeUnit() {
                return feeUnit;
            }

            public void setFeeUnit(String feeUnit) {
                this.feeUnit = feeUnit;
            }

            public int getUserrollCount() {
                return userrollCount;
            }

            public void setUserrollCount(int userrollCount) {
                this.userrollCount = userrollCount;
            }
        }

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
            private int payerUin;
            @JSONField(name = "payer_wxid")
            private String payerWxid;
            @JSONField(name = "is_friend")
            private boolean isFriend;
            @JSONField(name = "coupon")
            private CouponBean coupon;

            public String getBillId() {
                return billId;
            }

            public void setBillId(String billId) {
                this.billId = billId;
            }

            public String getTransId() {
                return transId;
            }

            public void setTransId(String transId) {
                this.transId = transId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(int timestamp) {
                this.timestamp = timestamp;
            }

            public int getFee() {
                return fee;
            }

            public void setFee(int fee) {
                this.fee = fee;
            }

            public String getFeeType() {
                return feeType;
            }

            public void setFeeType(String feeType) {
                this.feeType = feeType;
            }

            public String getFeeAttr() {
                return feeAttr;
            }

            public void setFeeAttr(String feeAttr) {
                this.feeAttr = feeAttr;
            }

            public String getCurrentState() {
                return currentState;
            }

            public void setCurrentState(String currentState) {
                this.currentState = currentState;
            }

            public String getCurrentStateType() {
                return currentStateType;
            }

            public void setCurrentStateType(String currentStateType) {
                this.currentStateType = currentStateType;
            }

            public int getBillType() {
                return billType;
            }

            public void setBillType(int billType) {
                this.billType = billType;
            }

            public String getIconUrl() {
                return iconUrl;
            }

            public void setIconUrl(String iconUrl) {
                this.iconUrl = iconUrl;
            }

            public String getOutTradeNo() {
                return outTradeNo;
            }

            public void setOutTradeNo(String outTradeNo) {
                this.outTradeNo = outTradeNo;
            }

            public int getTotalRefundFee() {
                return totalRefundFee;
            }

            public void setTotalRefundFee(int totalRefundFee) {
                this.totalRefundFee = totalRefundFee;
            }

            public int getClassifyType() {
                return classifyType;
            }

            public void setClassifyType(int classifyType) {
                this.classifyType = classifyType;
            }

            public String getPayBankName() {
                return payBankName;
            }

            public void setPayBankName(String payBankName) {
                this.payBankName = payBankName;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getBusinessData() {
                return businessData;
            }

            public void setBusinessData(String businessData) {
                this.businessData = businessData;
            }

            public int getChargeFee() {
                return chargeFee;
            }

            public void setChargeFee(int chargeFee) {
                this.chargeFee = chargeFee;
            }

            public String getPayerRemark() {
                return payerRemark;
            }

            public void setPayerRemark(String payerRemark) {
                this.payerRemark = payerRemark;
            }

            public int getPayerUin() {
                return payerUin;
            }

            public void setPayerUin(int payerUin) {
                this.payerUin = payerUin;
            }

            public String getPayerWxid() {
                return payerWxid;
            }

            public void setPayerWxid(String payerWxid) {
                this.payerWxid = payerWxid;
            }

            public boolean isIsFriend() {
                return isFriend;
            }

            public void setIsFriend(boolean isFriend) {
                this.isFriend = isFriend;
            }

            public CouponBean getCoupon() {
                return coupon;
            }

            public void setCoupon(CouponBean coupon) {
                this.coupon = coupon;
            }

            public static class CouponBean {
                @JSONField(name = "trans_fee")
                private int transFee;
                @JSONField(name = "coupon_fee")
                private int couponFee;
                @JSONField(name = "coupon_desc")
                private List<?> couponDesc;

                public int getTransFee() {
                    return transFee;
                }

                public void setTransFee(int transFee) {
                    this.transFee = transFee;
                }

                public int getCouponFee() {
                    return couponFee;
                }

                public void setCouponFee(int couponFee) {
                    this.couponFee = couponFee;
                }

                public List<?> getCouponDesc() {
                    return couponDesc;
                }

                public void setCouponDesc(List<?> couponDesc) {
                    this.couponDesc = couponDesc;
                }
            }
        }
    }
}
