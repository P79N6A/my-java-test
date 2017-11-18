package json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;


/**
 * Created by i23 on 17/2/9.
 */
public class JsonExample {
    String jsonString = "{\"subscribe\":1,\"openid\":\"o6_bmjrPTlm6_2sgVt7hMZOPfL2M\",\"nickname\":\"Band\",\"sex\":1,\"language\":\"zh_CN\",\"city\":\"广州\",\"province\":\"广东\",\"country\":\"中国\",\"headimgurl\":\"http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/0\",\"subscribe_time\":1382694957,\"unionid\":\"o6_bmasdasdsad6_2sgVt7hMZOPfL\",\"remark\":\"\",\"groupid\":0}";

    @Test
    public void test1() {
        {
            JSONObject object = JSONObject.parseObject(jsonString);
            System.out.println(object.get("openid"));
        }
        {
            Object obj = JSON.parse(jsonString);
            System.out.println(obj);
        }
        {
            Bean bean = JSON.parseObject(jsonString, Bean.class);
            System.out.println(bean);
        }
    }


}
