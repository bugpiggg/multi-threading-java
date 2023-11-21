package org.bugpiggg.threadCreation2;

public class ThreadCreation {
    public static void main(String[] args) {
        Thread thread = new NewThread();
        thread.start();
        System.out.println("Hello from main thread " + Thread.currentThread().getName());
    }

    private static class NewThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello from thread " + Thread.currentThread().getName());
        }
    }
}
