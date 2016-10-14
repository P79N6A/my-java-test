package test;

import org.apache.log4j.Logger;

public class Customer implements Runnable {
	private static final Logger log = Logger.getLogger(Customer.class);

	public void run() {
		log.info(Thread.currentThread().getName() + " 开始消费");
		doSomething();
		log.info(Thread.currentThread().getName() + " 结束消费");
	}

	public void doSomething() {
		long startTime = System.currentTimeMillis();
		String item = Shop.getItem();
		while ((item = Shop.getItem()) == null) {
			synchronized (Shop.flag) {
				Shop.flag.notifyAll();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		long endTime = System.currentTimeMillis();
		log.info(Thread.currentThread().getName() + " 等待了 " + (endTime - startTime) / 1000.0 + "秒 带走了 " + item);
	}

}
