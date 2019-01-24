package mutithread.thread;

public class SimpleT implements Runnable {
    String name;

    public SimpleT(String name) {
        this.name = name;
    }

    public void run() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread:" + Thread.currentThread().getName() + " name:" + name + " running!");
    }
}