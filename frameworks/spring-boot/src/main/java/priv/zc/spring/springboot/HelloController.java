package priv.zc.spring.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${config.env}")
    private String env;

    @RequestMapping("/hello")
    public String index() {
        return "Hello World, " + env;
    }

    @RequestMapping("/exception")
    public String exception() {
        throw new RuntimeException("异常测试");
    }

}
