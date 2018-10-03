package suiconvert;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AlipayTask {
    //资产明细json转随手记csv
    public static void pinganJsonToCsv(String jsonString) {
        JSONObject json = JSONObject.parseObject(jsonString);
        JSONArray array = json.getJSONObject("data").getJSONArray("recordList");
        renderRow(array,"平安银行淘宝");
    }
    public static void renderRow(JSONArray array,String account){
        String separator = "\t";
        for (int i = 0; i < array.size(); i++) {
            JSONObject obj = array.getJSONObject(i);
            String type = "支出";

            JSONObject jdate = obj.getJSONObject("c_time");
            String date = jdate.getString("date") + " " + jdate.getString("time");

            String cate = "其他杂项";
            String sedCate = "其他支出";

            String account1 = account;
            String account2 = "";
            String money = obj.getString("c_amount").replace(",","");
            String member = "";
            String merchant = "";
            String project = "";
            String remark = obj.getString("c_detail");

            if(remark.contains("滴滴")){
                cate = "行车交通";
                sedCate = "打车租车";
            }else if(remark.contains("美团") || remark.contains("饿了么")){
                cate = "食品酒水";
                sedCate = "早午晚餐";
            }
            String showMoney = obj.getString("showMoney");
            if(StringUtils.isNotBlank(showMoney)) {
                remark += " 优惠"+showMoney;
            }

            List<String> items = new ArrayList<String>();
            items.add(type);
            items.add(date);
            items.add(cate);
            items.add(sedCate);
            items.add(account1);
            items.add(account2);
            items.add(money);
            items.add(member);
            items.add(merchant);
            items.add(project);
            items.add(remark);
            String line = StringUtils.join(items,separator);
            System.out.println(line);
        }
    }
    public static void huabei(String jsonString){
        JSONObject json = JSONObject.parseObject(jsonString);
        JSONArray array = json.getJSONObject("recordInfo").getJSONArray("recordList");
        renderRow(array,"花呗");
    }

    public static void main(String[] args) {
        String a ="{\"stat\"";
        AlipayTask.pinganJsonToCsv(a);
//        String b = "{\"recordInfo\":";
//        AlipayTask.huabei(b);
    }
}
