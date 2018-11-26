package priv.zc.autosign.util;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;

public class HttpUtils {
	public static String get(String uri, String cookie) {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(uri);
		if (cookie != null && !cookie.isEmpty()) {
			httpGet.setHeader("Cookie", cookie);
		}
		CloseableHttpResponse response;
		try {
			response = client.execute(httpGet);
		} catch (IOException e) {
			throw new RuntimeException("uri:" + uri + "请求出错", e);
		}
		try {
			return EntityUtils.toString(response.getEntity(),"UTF-8");
		} catch (ParseException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		String result=get("http://live.bilibili.com/sign/doSign", "DedeUserID=1289125; DedeUserID__ckMd5=0fe6de7494e45b3a; SESSDATA=8c363e31%2C1475568386%2C4bb51dd7");
		System.out.println(JSON.parse(result));
	}
}
