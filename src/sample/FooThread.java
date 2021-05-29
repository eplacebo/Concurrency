package sample;

class FooThread extends Thread {
    Thread t;
    String name;

    FooThread(String threadname) {
        name = threadname;
        t = new Thread(this, name);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        Foo foo = new Foo();
        if (t.getName().equalsIgnoreCase("A")) {
            foo.first();
        } else if (t.getName().equalsIgnoreCase("B")) {
            foo.second();
        } else
            foo.third();
    }


    public static void main(String[] args) {

        new FooThread("A");
        new FooThread("B");
        new FooThread("C");
    }
}


