package scripts.suiconvert;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JdTask {

    public static void renderRow(JSONArray array, String account) {
        String separator = "\t";
        for (int i = 0; i < array.size(); i++) {
            JSONObject obj = array.getJSONObject(i);
            String type = "支出";

            String date = convDate(obj.getString("date"));

            String cate = "其他杂项";
            String sedCate = "其他支出";

            String account1 = account;
            String account2 = "";
            String money = obj.getString("payMoney").replace("-", "");
            String member = "";
            String merchant = "";
            String project = "";
            String remark = obj.getString("showText");
            if (remark.contains("滴滴")) {
                cate = "行车交通";
                sedCate = "打车租车";
            } else if (remark.contains("美团") || remark.contains("饿了么")) {
                cate = "食品酒水";
                sedCate = "早午晚餐";
            }
            String showMoney = obj.getString("showMoney");
            if (StringUtils.isNotBlank(showMoney)) {
                remark += " 优惠" + showMoney;
            }

            List<String> items = new ArrayList<String>();
            items.add(type);
            items.add(date);
            items.add(cate);
            items.add(sedCate);
            items.add(account1);
            items.add(account2);
            items.add(money.replace(",", ""));
            items.add(member);
            items.add(merchant);
            items.add(project);
            items.add(remark);
            items.add(showMoney);
            String line = StringUtils.join(items, separator);
            System.out.println(line);
        }
    }

    public static void jd(String jsonString) {
        JSONObject json = JSONObject.parseObject(jsonString);
        JSONArray array = json.getJSONArray("list");
        renderRow(array, "平安银行淘宝");
    }

    public static void main(String[] args) {
        JdTask.jd("");
    }

    public static String convDate(String date) {
        SimpleDateFormat df = new SimpleDateFormat("MM月dd日 HH:mm");
        Date dd;
        try {
            dd = df.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        SimpleDateFormat df2 = new SimpleDateFormat("2018-MM-dd HH:mm");
        return df2.format(dd);
    }
}
