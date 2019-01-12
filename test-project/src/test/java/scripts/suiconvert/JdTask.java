package scripts.suiconvert;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;

public class JdTask {

    public static List<SuiRow> renderRow(JdResult jdResult, String account) {
        List<SuiRow> list = new ArrayList<>();
        for (JdResult.ListBean obj : jdResult.getList()) {
            String date = convDate(obj.getDate(), obj.getMonthDate());
            String remark = obj.getShowText();
            String showMoney = obj.getShowMoney();
            if (StringUtils.isNotBlank(showMoney)) {
                remark += " 优惠" + showMoney;
            }
            String[] category = ConvUtils.cateConv(remark);
            SuiRow suiRow = SuiRow.builder()
                    .type("支出")
                    .date(date)
                    .cate(category[0])
                    .sedCate(category[1])
                    .account1(account)
                    .account2("")
                    .money(obj.getPayMoney().replace("-", "").replace(",", ""))
                    .member("")
                    .merchant("")
                    .project("")
                    .remark(remark)
                    .build();
            list.add(suiRow);
        }
        return list;
    }

    public static void jd(String jsonString) {

        JdResult jdResult = JSONObject.parseObject(jsonString, JdResult.class);
        List<SuiRow> suiRows = renderRow(jdResult, "浦发银行信用卡");
        suiRows.forEach(e -> System.out.println(e.toConsoleString()));
    }

    public static void jdFile(String file) {
        List<SuiRow> suiRows = fileToSuiRow(file);
        suiRows.forEach(e -> System.out.println(e.toConsoleString()));
    }

    public static List<SuiRow> fileToSuiRow(String file) {
        String json = null;
        try {
            json = FileUtils.readFileToString(new File(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JdResult jdResult = JSONObject.parseObject(json, JdResult.class);
        List<SuiRow> suiRows = renderRow(jdResult, "浦发信用卡");
        return suiRows;
    }

    public static void main(String[] args) {
        
    }

    public static String convDate(String date, String monthDate) {
        SimpleDateFormat df = new SimpleDateFormat("MM月dd日 HH:mm");
        Date dd;
        try {
            dd = df.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        SimpleDateFormat df2 = new SimpleDateFormat(monthDate+"-dd HH:mm");
        return df2.format(dd);
    }

    @Data
    public static class JdResult {

        @JSONField(name = "pin")
        private String pin;
        @JSONField(name = "bizType")
        private String bizType;
        @JSONField(name = "success")
        private boolean success;
        @JSONField(name = "responseCode")
        private String responseCode;
        @JSONField(name = "responseMessage")
        private String responseMessage;
        @JSONField(name = "list")
        private List<ListBean> list;

        @Data
        public static class ListBean {
            @JSONField(name = "uuid")
            private String uuid;
            @JSONField(name = "payMoney")
            private String payMoney;
            @JSONField(name = "direction")
            private String direction;
            @JSONField(name = "tradeStatus")
            private String tradeStatus;
            @JSONField(name = "merchantNo")
            private String merchantNo;
            @JSONField(name = "secondType")
            private String secondType;
            @JSONField(name = "busiAction")
            private String busiAction;
            @JSONField(name = "week")
            private String week;
            @JSONField(name = "iconUrl")
            private String iconUrl;
            @JSONField(name = "date")
            private String date;
            @JSONField(name = "showText")
            private String showText;
            @JSONField(name = "monthDate")
            private String monthDate;
            @JSONField(name = "showMonth")
            private String showMonth;
            @JSONField(name = "outTradeNo")
            private String outTradeNo;
            @JSONField(name = "showMoney")
            private String showMoney;
            @JSONField(name = "valueStyle")
            private String valueStyle;
            @JSONField(name = "success")
            private boolean success;
        }
    }
}
