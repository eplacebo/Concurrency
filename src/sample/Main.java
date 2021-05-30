
package sample;

public class Main  {
    public static void main(String[] args) throws InterruptedException {

        Thread threadA = new Thread(() -> System.out.println("first"));

        Thread threadB = new Thread(() -> System.out.println("second"));

        Thread threadC = new Thread(() -> System.out.println("third"));


        Foo foo = new Foo();
        foo.third(threadC);
        foo.second(threadB);
        foo.first(threadA);
    }
}