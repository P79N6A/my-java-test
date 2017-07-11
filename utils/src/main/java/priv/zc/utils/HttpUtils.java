package priv.zc.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;

public class HttpUtils {
    public static String get(String url) {
        try {
            return Request.Get(url).execute().returnContent().asString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String post(String url, NameValuePair[] formParams) {
        try {
            return Request.Post(url).bodyForm(formParams).execute().returnContent().toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static NameValuePair[] mapToNameValuePair(Map<String, String> paramMap) {
        List<NameValuePair> pairs = new ArrayList<>();
        for(Map.Entry<String,String> entry:paramMap.entrySet()){
            pairs.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
        }
        return pairs.toArray(new NameValuePair[paramMap.size()]);
    }
}
