package sample;

public class Foo {

    public int flag = 0;

    synchronized public void first(Thread threadA) throws InterruptedException {
        while (flag == 0) {
            threadA.start();
            flag++;
            notifyAll();
        }

        wait();

    }

    synchronized public void second(Thread threadB) throws InterruptedException {
        while (flag == 1) {
            threadB.start();
            flag++;
            notifyAll();
        }

        wait();
    }

    synchronized public void third(Thread threadC) throws InterruptedException {
        while (flag == 2) {
            threadC.start();
            flag++;
            notifyAll();
        }

        wait();
    }
}



