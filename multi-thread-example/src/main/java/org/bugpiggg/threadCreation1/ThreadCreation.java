package org.bugpiggg.threadCreation1;

public class ThreadCreation {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(
                () -> System.out.println("Hello from thread " + Thread.currentThread().getName())
        );

        System.out.println("Hello from main thread " + Thread.currentThread().getName());
        thread.start();

        Thread.sleep(10000);
    }
}
