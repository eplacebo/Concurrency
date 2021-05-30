package sample;

public class Foo {

    public int flag = 0;

    public Foo() {
        flag = 0;
    }

    synchronized void first(Thread threadA) throws InterruptedException {
        while (flag != 0) {
            wait();
        }
        threadA.start();
        flag++;
        notifyAll();


    }

    synchronized void second(Thread threadB) throws InterruptedException {
        while (flag != 1) {
            wait();
        }
        threadB.start();
        flag++;
        notifyAll();
    }

    synchronized void third(Thread threadC) throws InterruptedException {
        while (flag != 2) {
            wait();
        }
        threadC.start();
        flag++;
        notifyAll();
    }
}
