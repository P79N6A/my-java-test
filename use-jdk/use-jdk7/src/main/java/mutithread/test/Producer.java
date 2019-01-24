package mutithread.test;

import java.util.logging.Logger;

public class Producer implements Runnable {
	private static final Logger log = Logger.getLogger(Producer.class.getName());

	public void run() {
		while (true) {
			log.info(Thread.currentThread().getName() + " 开始生产");
			doSomething();
			log.info(Thread.currentThread().getName() + " 结束生产");
		}
	}

	public void doSomething() {
		try {
			long startTime = System.currentTimeMillis();
			Thread.sleep((long) ((2 + 2 * Math.random()) * 1000));
			long endTime = System.currentTimeMillis();
			log.info(Thread.currentThread().getName() + " 花了 " + (endTime - startTime) / 1000.0 + "秒 制作了商品");
			Shop.addItem();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			log.info(Thread.currentThread().getName() + " 开始休息");
			synchronized (Shop.flag) {
				Shop.flag.wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
