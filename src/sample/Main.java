package sample;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Runnable printFirst = new Thread(() -> System.out.println("first " + Thread.currentThread()));
        Runnable printSecond = new Thread(() -> System.out.println("second " + Thread.currentThread()));
        Runnable printThird = new Thread(() -> System.out.println("third " + Thread.currentThread()));

        Foo foo = new Foo();

        CompletableFuture.allOf(CompletableFuture.runAsync(() -> {
                    try {
                        foo.third(printThird);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }, Executors.newSingleThreadExecutor()),


                CompletableFuture.runAsync(() -> {
                    try {
                        foo.first(printFirst);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }, Executors.newSingleThreadExecutor()),


                CompletableFuture.runAsync(() -> {
                    try {
                        foo.second(printSecond);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }, Executors.newSingleThreadExecutor()));
    }
}
