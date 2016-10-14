package priv.zc.rpc.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@com.alibaba.dubbo.config.annotation.Service(version = "0.0.1")
@Service("helloService")
public class HelloServiceImpl implements HelloService {

	public HelloServiceImpl() {
		System.out.println(new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]").format(new Date()) + " 初始化");
	}

	public String sayHello(String name) {
		return name + " said Hello @" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

}
