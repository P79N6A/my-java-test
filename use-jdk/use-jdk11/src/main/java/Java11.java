import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;

public class Java11 {
    public static void main(String[] args) {
        http();
    }

    public static void var() {
        var a = new Date();
        var b = "Hello";
        System.out.println("a type:" + a.getClass() + " value:" + a);
        System.out.println("b type:" + b.getClass() + " value:" + b);
    }

    public static void http(){
        var url = "http://www.baidu.com";
        var client =HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(response.body());
    }
}
