package org.bugpiggg.threadTermination1;

import java.math.BigInteger;

public class InterruptByCode {
    public static void main(String[] args) {
        Thread thread = new Thread( new LongComputationTask(
                new BigInteger("200"), new BigInteger("20")
        ));

        thread.start();

        thread.interrupt();
    }

    private static class LongComputationTask implements Runnable {
        private BigInteger base;
        private BigInteger power;

        public LongComputationTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(base + "^" + power + "=" + pow(base, power) );
        }

        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;
            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i.add(BigInteger.ONE)) {
                if(Thread.interrupted()) {
                    return BigInteger.ZERO;
                }
                result = result.multiply(base);
            }
            return result;
        }
    }
}
