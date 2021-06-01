package sample;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Foo {
    static AtomicInteger flag = new AtomicInteger(0);

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        System.out.println(flag.get());
        flag.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (flag.get() != 1) ;
        printSecond.run();
        System.out.println(flag.get());
        flag.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (flag.get() != 2) ;
        printThird.run();
        System.out.println(flag.get());
    }
}



/*
*******************REENTRANLOCK()**********************
    int flag = 0;

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();


    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        printFirst.run();
        flag++;
        condition.signalAll();
        lock.unlock();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        while (flag != 1) {
            condition.await();
        }
        printSecond.run();
        flag++;
        condition.signalAll();
        lock.unlock();
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        while (flag != 2) {
            condition.await();
        }
        printThird.run();
        lock.unlock();
    }
}
*/





/*
******************synchronized************************
    int flag = 0;

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        while (flag != 0) {
            wait();
        }
        printFirst.run();
        flag++;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while (flag != 1) {
            wait();
        }
        printSecond.run();
        flag++;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while (flag != 2) {
            wait();
        }
        printThird.run();
        flag++;
    }

 */


/*
**********************CDL***********************

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
*/


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
    }
*/

