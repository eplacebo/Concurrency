package sample;

public class Main extends Thread {
    public static void main(String[] args) throws InterruptedException {

        Thread threadA = new Thread() {
        @Override
        public void run() {
            System.out.println("first");
        }
    };

    Thread threadB = new Thread() {
        @Override
        public void run() {
            System.out.println("second");
        }
    };

    Thread threadC = new Thread() {
        @Override
        public void run() {
            System.out.println("third");
        }
    };


        Foo foo = new Foo();
        foo.flag=0;
        foo.third(threadC);
        foo.second(threadB);
        foo.first(threadA);
    }
}
