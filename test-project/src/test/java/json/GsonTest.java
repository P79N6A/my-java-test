package json;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * 17/1/6.
 */
public class GsonTest {
    @Test
    public void test(){
        Map<String,Object> map = new HashMap<>();
        map.put("f1",123);
        map.put("f2",12312312312312l);
        map.put("f3","你");
        Gson gson = new Gson();
        System.out.println(gson.toJson(map));

        //Gson转long会有一些问题
        String aa="{\"f1\":123,\"f3\":\"你\",\"f2\":12312312312312}";
        System.out.println(gson.fromJson(aa,JsonObject.class));
        JsonParser parser = new JsonParser();
        JsonElement root = parser.parse(aa);
        if(root.isJsonObject()){
            JsonObject jsonObj = root.getAsJsonObject();
            System.out.println(jsonObj);
        }
    }


}
