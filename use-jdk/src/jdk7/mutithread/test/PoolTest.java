package jdk7.mutithread.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import jdk7.mutithread.thread.SimpleT;

/**
 * 17/3/31.
 */
public class PoolTest {

    public static void main(String[] args) {
        new PoolTest().test2();
    }

    //    @Test
    public void test1() {
        ExecutorService tp = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            tp.execute(new SimpleT(String.valueOf(i)));
        }
        tp.shutdown();
    }

    //    @Test
    public void test2() {
        ExecutorService tp = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            tp.execute(new SimpleT(String.valueOf(i)));
        }

        tp.shutdown();
    }

    //    @Test
    public void test3() {
        ExecutorService tp = Executors.newWorkStealingPool();
        for (int i = 0; i < 100; i++) {
            tp.execute(new SimpleT(String.valueOf(i)));
        }
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //    @Test
    public void test4() {
        ExecutorService tp = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 100; i++) {
            tp.execute(new SimpleT(String.valueOf(i)));
        }
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
