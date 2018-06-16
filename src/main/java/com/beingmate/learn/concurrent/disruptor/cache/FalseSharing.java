package com.beingmate.learn.concurrent.disruptor.cache;

public final class FalseSharing
        implements Runnable {
    // change
    public final static int NUM_THREADS = 4;
    public final static long ITERATIONS = 500L * 1000L * 1000L;
    private final int arrayIndex;

    private static RfsPadding[] longs = new RfsPadding[NUM_THREADS];

    static {
        for (int i = 0; i < longs.length; i++) {
            longs[i] = new RfsPadding();
        }
    }

    public FalseSharing(final int arrayIndex) {
        this.arrayIndex = arrayIndex;
    }

    public static void main(final String[] args) throws Exception {
        final long start = System.nanoTime();
        runTest();
        System.out.println("duration = " + (System.nanoTime() - start));

        //4 threads no padding 15012305478
        //4 threads no padding 38353658001

        //4 threads    padding 10367262250
        //8 threads    padding 19377722397
    }

    private static void runTest() throws InterruptedException {
        Thread[] threads = new Thread[NUM_THREADS];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new FalseSharing(i));
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }
    }

    @Override
    public void run() {
        long i = ITERATIONS + 1;
        while (0 != --i) {
            longs[arrayIndex].value = i;
        }
    }

    private static class LfsPading {
        public long p1, p2, p3, p4, p5, p6;
    }


    public static class VolatileLong extends LfsPading {
        public volatile long value = 0L;
    }

    public static class RfsPadding{
        public long p1, p2, p3, p4, p5, p6, p7, p8;
        public volatile long value = 0L;
        public long  p9, p10, p11, p12, p13, p14, p15;
    }

    public static class SimpleVolatileLong {
        public volatile long value = 0L;
    }
}