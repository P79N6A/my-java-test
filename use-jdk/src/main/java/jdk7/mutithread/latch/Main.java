package jdk7.mutithread.latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Main {
    static Logger logger = Logger.getLogger("Main");
    static int count=50;
    static CountDownLatch latch = new CountDownLatch(4);
    static ThreadPoolExecutor executorService = new ThreadPoolExecutor(3,20, 30,TimeUnit.SECONDS,new
            LinkedBlockingQueue<Runnable>(10));
    public static void main(String[] args) {

        for(int i=0;i<count;i++){
            executorService.execute(new SimpleThread("instance-"+i));
            try {
                Thread.sleep(400l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("当前线程池大小"+executorService.getLargestPoolSize());
        }
        try {
            latch.await();
            logger.info("计数完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }
        logger.info("成功执行完");
        executorService.shutdown();

    }

    static class SimpleThread implements Runnable{
        private String instanceName;
        public SimpleThread(String instanceName){
           this.instanceName=instanceName;
            logger.info(instanceName+ " 初始化");
        }
        public void run() {
            logger.info(Thread.currentThread().getName()+" "+instanceName+" start");
            try {
                Thread.sleep(2000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info(Thread.currentThread().getName()+" "+instanceName+" end");
            latch.countDown();
        }
    }
}
