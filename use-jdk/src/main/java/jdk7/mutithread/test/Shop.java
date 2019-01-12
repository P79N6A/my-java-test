package jdk7.mutithread.test;

import java.util.concurrent.LinkedBlockingQueue;

public class Shop {
	private Shop() {
	}

	private static int seq = 1;

	public static Object flag = new Object();

	private static LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>();

	public static void addItem() {
		queue.offer("item-" + seq++);
	}

	public static String getItemAndWait() {
		try {
			return queue.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static int getItemCount() {
		return queue.size();
	}

	public static String getItem() {
		return queue.poll();
	}

}
