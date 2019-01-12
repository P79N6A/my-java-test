package jdk7.net;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created on 17/8/28.
 */
public class URLTest {
//    @Test
    public void test(){
        URL url = null;
        try {
             url = new URL("http://meeting.baidu.com/index.jsp?q=a");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println(url.getHost());
        System.out.println(url.getDefaultPort());
        System.out.println(url.getFile());
        System.out.println(url.getPath());
        System.out.println(url.getProtocol());
        System.out.println(url.getQuery());
        System.out.println(url.getRef());
    }
}
