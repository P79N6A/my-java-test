package priv.zc.rpc.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloServiceHandler implements HelloService.Iface {

	public HelloServiceHandler() {
		System.out.println(new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]").format(new Date()) + " 初始化");
	}

	public String sayHello(String name) {
		return name + " said Hello @" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

}
