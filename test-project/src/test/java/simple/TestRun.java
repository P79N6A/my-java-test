package simple;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class TestRun {

    public static void main(String[] args) {
        String s="{\"msg\":\"msg\",\"errno\":\"7018301101\"}";
        Gson gson=new Gson();
        Map<String,Object> map=gson.fromJson(s,HashMap.class);
        System.out.println(map);
    }
}
