package test;

public class Main {
	public static void main(String[] args) {
		Thread producer = new Thread(new Producer(), "producer-1");
		producer.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 1; i < 4; i++)
			new Thread(new Customer(), "customer-" + i).start();
	}

	// public static void main(String[] args) {
	// LinkedList list = new LinkedList();
	// System.out.println(list);
	// list.push("1");
	// list.push("2");
	// list.push("3");
	// System.out.println(list);
	// list.push("4");
	// System.out.println(list);
	// System.out.println(list.pop());
	// System.out.println(list.pop());
	// System.out.println(list.pop());
	// System.out.println(list.pop());
	// System.out.println(list.pop());
	// }
}
