package test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EleTest {
    public static void main(String[] args) throws IOException {
        //https://mainsite-restapi.ele.me/shopping/restaurants?offset=0&extras%5B%5D=activities&geohash=wx4expyp0dh&latitude=40.03402&limit=24&longitude=116.33151
        String path = "/Users/baidu/Desktop/ele/";
        File dir = new File(path);
        if (!dir.isDirectory()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("id").append(",");
        sb.append("距离").append(",");
        sb.append("起送价格").append(",");
        sb.append("配送费").append(",");
        sb.append("最近的订单量").append(",");
        sb.append("店名").append(",");
        sb.append("地址").append(",");
        sb.append("满减").append(",");
        sb.append("优惠力度");
        sb.append("\n");
        for (File file : dir.listFiles()) {
            String s = FileUtils.readFileToString(file);
            JSONArray array = JSONArray.parseArray(s);
            for (int i = 0; i < array.size(); i++) {
                JSONObject obj = array.getJSONObject(i);
                sb.append(obj.get("id")).append(",");
                sb.append(obj.get("distance")).append(",");
                sb.append(obj.get("float_minimum_order_amount")).append(",");
                sb.append(obj.get("float_delivery_fee")).append(",");
                sb.append(obj.get("recent_order_num")).append(",");
                sb.append(obj.get("name")).append(",");
                sb.append(obj.get("address")).append(",");

                String jianString = null;
                JSONArray activities = obj.getJSONArray("activities");
                for(int j=0;j<activities.size();j++) {
                    JSONObject act = activities.getJSONObject(j);
                    if("减".equals(act.getString("icon_name"))){
                        jianString=act.getString("tips");
                        sb.append(jianString);
                        break;
                    }
                }
                sb.append(",");
                if(jianString!=null){
                    sb.append(jianMaxPercent(jianString));
                }
                sb.append(",");
                sb.append("\n");
            }
        }
        FileUtils.writeStringToFile(new File("/Users/baidu/Desktop/ele.csv"),sb.toString(),"GBK");

    }

    @Test
    public void testJian(){
        System.out.println(jianMaxPercent("在线支付满20减5，满35减7，满59减11"));
    }

    public static double jianMaxPercent(String ss){
        double maxPercent=0;
        for(String s:ss.split(",")) {
            Pattern pattern = Pattern.compile("满(\\d+)减(\\d+)");
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                int man=Integer.parseInt(matcher.group(1));
                int jian=Integer.parseInt(matcher.group(2));
                double percent=jian*100.0/man;
                if(percent>maxPercent){
                    maxPercent=percent;
                }
                System.out.println(matcher.group()+" "+percent+"%");
            }
        }
        return maxPercent;
    }
}
