package sample;

import java.util.concurrent.Semaphore;

public class Foo {

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
    }
}
