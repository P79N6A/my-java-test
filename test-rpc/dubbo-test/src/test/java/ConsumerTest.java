import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;

import priv.zc.rpc.service.HelloService;

public class ConsumerTest {
	public static void main(String[] args) {
		ReferenceConfig<HelloService> config = new ReferenceConfig<HelloService>();
		config.setInterface(HelloService.class);
		config.setUrl("dubbo://127.0.0.1:20880/priv.zc.rpc.service.HelloService");
		config.setVersion("0.0.1");
		ApplicationConfig application = new ApplicationConfig("test");
		config.setApplication(application);
		HelloService helloService = config.get();
		// for (int i = 0; i < 1; i++) {
		// System.out.println(helloService.sayHello("bb" + i));
		// }
		int i = 0;
		while (true) {
			System.out.println(helloService.sayHello("bb" + i));
			i++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
