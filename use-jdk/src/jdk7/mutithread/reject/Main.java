package jdk7.mutithread.reject;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import jdk7.mutithread.thread.SimpleT;

/**
 * 17/3/31.
 */
public class Main {

    public static void main(String[] args) {
        //        callerRunsPolicy();
        //        abortPolicy();
        //        discardOldestPolicy();
        discardPolicy();
    }

    public static void callerRunsPolicy() {
        ThreadPoolExecutor tp = new ThreadPoolExecutor(10, 10, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>
                (10));
        tp.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 100; i++) {
            tp.execute(new SimpleT(String.valueOf(i)));
        }
        tp.shutdown();
    }

    public static void abortPolicy() {
        ThreadPoolExecutor tp = new ThreadPoolExecutor(10, 10, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>
                (10));
        tp.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 100; i++) {
            try {
                tp.execute(new SimpleT(String.valueOf(i)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        tp.shutdown();
    }

    public static void discardOldestPolicy() {
        ThreadPoolExecutor tp = new ThreadPoolExecutor(10, 10, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>
                (10));
        tp.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i = 0; i < 100; i++) {
            try {
                tp.execute(new SimpleT(String.valueOf(i)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        tp.shutdown();
    }

    public static void discardPolicy() {
        ThreadPoolExecutor tp = new ThreadPoolExecutor(10, 10, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>
                (10));
        tp.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 0; i < 100; i++) {
            try {
                tp.execute(new SimpleT(String.valueOf(i)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        tp.shutdown();
    }
}
