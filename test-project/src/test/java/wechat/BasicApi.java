package wechat;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

public class BasicApi {
	public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
	public static final String GET_CALLBACK_IP = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=%s";

	public static String getcallbackip(String accessToken) {
		String url = String.format(GET_CALLBACK_IP, accessToken);
		try {
			return Request.Get(url).execute().returnContent().asString(DEFAULT_CHARSET);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(getcallbackip(
				"AIzDu2_YpyWLkjkgeDITl-qT1YZyIti7gmeXSWkN88Uug_f8P1Kf6HsrvDWjZeCXSjau3W79m1LGFe755XA2BhS3McVfDrEFGRkCehFLI1KusIq3nboQM5ePdNdm7Sz4ZGRcAGAHOZ"));
	}
}
