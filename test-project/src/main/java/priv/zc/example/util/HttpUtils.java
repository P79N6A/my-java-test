package priv.zc.example.util;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpUtils {

	private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
	private static final Log log = LogFactory.getLog(HttpUtils.class);

	public static String getUrl(String url) {
		CloseableHttpClient hc = HttpClients.createDefault();
		HttpGet get = new HttpGet(url);
		try {
			HttpResponse response = hc.execute(get);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK) {
				return EntityUtils.toString(response.getEntity(), DEFAULT_CHARSET);
			} else {
				log.info("返回状态 " + statusCode);
			}
		} catch (IOException e) {
			log.error(e, e);
			return null;
		} finally {
			try {
				hc.close();
			} catch (IOException e) {
				log.error(e, e);
			}
		}
		return null;
	}

	public static String postUrlWithJson(String url, String data) {
		CloseableHttpClient hc = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		post.addHeader("Content-Type", "application/json; charset=UTF-8");
		try {
			HttpResponse response = hc.execute(post);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK) {
				return EntityUtils.toString(response.getEntity(), DEFAULT_CHARSET);
			} else {
				log.info("返回状态 " + statusCode);
			}
		} catch (IOException e) {
			log.error(e, e);
		} finally {
			try {
				hc.close();
			} catch (IOException e) {
				log.error(e, e);
			}
		}
		return null;
	}
}
