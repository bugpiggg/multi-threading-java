package org.bugpiggg.threadTermination1;

public class InterruptByMethod {

    public static void main(String[] args) {
        Thread thread = new Thread(
                new BlockingTask()
        );

        thread.start();

        thread.interrupt();
    }

    private static class BlockingTask implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
