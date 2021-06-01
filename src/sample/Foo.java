package sample;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Foo {

    CountDownLatch cdl = new CountDownLatch(1);
    CountDownLatch cdl2 = new CountDownLatch(2);

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        cdl.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        cdl.await();
        printSecond.run();
        cdl2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        cdl2.countDown();
        cdl2.await();
        printThird.run();
    }






/*
***********************SEMAPHORE************************************
        Semaphore semaphore = new Semaphore(0);
        Semaphore semaphore2 = new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        semaphore.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphore.acquire();
        printSecond.run();
        semaphore2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        semaphore2.acquire();
        printThird.run();
        semaphore2.release();
    }*/
}
