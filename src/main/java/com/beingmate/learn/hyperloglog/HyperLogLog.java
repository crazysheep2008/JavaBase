package com.beingmate.learn.hyperloglog;

import java.io.*;

public class HyperLogLog implements ICardinality, Serializable {

    private final RegisterSet registerSet;
    private final int log2m;
    private final double alphaMM;

    public HyperLogLog(double rsd) {
        this(log2m(rsd));
    }

    private static int log2m(double rsd) {
        return (int) (Math.log((1.106 / rsd) * (1.106 / rsd)) / Math.log(2));
    }

    private static double rsd(int log2m) {
        return 1.106 / Math.sqrt(Math.exp(log2m * Math.log(2)));
    }

    private static void validateLog2m(int log2m) {
        if (log2m < 0 || log2m > 30) {
            throw new IllegalArgumentException("log2m argument is "
                    + log2m + " and is outside the range [0, 30]");
        }
    }

    public HyperLogLog(int log2m) {
        this(log2m, new RegisterSet(1 << log2m));
    }

    @Deprecated
    public HyperLogLog(int log2m, RegisterSet registerSet) {
        validateLog2m(log2m);
        this.registerSet = registerSet;
        this.log2m = log2m;
        int m = 1 << this.log2m;

        alphaMM = getAlphaMM(log2m, m);
    }

    @Override
    public boolean offerHashed(long hashedValue) {
        // j becomes the binary address determined by the first b log2m of x
        // j will be between 0 and 2^log2m
        final int j = (int) (hashedValue >>> (Long.SIZE - log2m));
        final int r = Long.numberOfLeadingZeros((hashedValue << this.log2m) | (1 << (this.log2m - 1)) + 1) + 1;
        return registerSet.updateIfGreater(j, r);
    }

    @Override
    public boolean offerHashed(int hashedValue) {
        // j becomes the binary address determined by the first b log2m of x
        // j will be between 0 and 2^log2m
        final int j = hashedValue >>> (Integer.SIZE - log2m);
        final int r = Integer.numberOfLeadingZeros((hashedValue << this.log2m) | (1 << (this.log2m - 1)) + 1) + 1;
        return registerSet.updateIfGreater(j, r);
    }

    @Override
    public boolean offer(Object o) {
        final int x = MurmurHash.hash(o);
        return offerHashed(x);
    }


    @Override
    public long cardinality() {
        double registerSum = 0;
        int count = registerSet.count;
        double zeros = 0.0;
        for (int j = 0; j < registerSet.count; j++) {
            int val = registerSet.get(j);
            registerSum += 1.0 / (1 << val);
            if (val == 0) {
                zeros++;
            }
        }

        double estimate = alphaMM * (1 / registerSum);

        if (estimate <= (5.0 / 2.0) * count) {
            // Small Range Estimate
            return Math.round(linearCounting(count, zeros));
        } else {
            return Math.round(estimate);
        }
    }

    @Override
    public int sizeof() {
        return registerSet.size * 4;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return null;
    }

    public void addAll(HyperLogLog other) throws CardinalityMergeException {
        if (this.sizeof() != other.sizeof()) {
            throw new HyperLogLogMergeException("Cannot merge estimators of different sizes");
        }

        registerSet.merge(other.registerSet);
    }

    @Override
    public ICardinality merge(ICardinality... estimators) throws CardinalityMergeException {
        HyperLogLog merged = new HyperLogLog(log2m, new RegisterSet(this.registerSet.count));
        merged.addAll(this);

        if (estimators == null) {
            return merged;
        }

        for (ICardinality estimator : estimators) {
            if (!(estimator instanceof HyperLogLog)) {
                throw new HyperLogLogMergeException("Cannot merge estimators of different class");
            }
            HyperLogLog hll = (HyperLogLog) estimator;
            merged.addAll(hll);
        }

        return merged;
    }

    public static class Builder implements IBuilder<ICardinality>, Serializable {
        private static final long serialVersionUID = -2567898469253021883L;

        private final double rsd;
        private transient int log2m;

        @Deprecated
        public Builder(double rsd) {
            this.log2m = log2m(rsd);
            validateLog2m(log2m);
            this.rsd = rsd;
        }

        private Builder(int log2m) {
            this.log2m = log2m;
            validateLog2m(log2m);
            this.rsd = rsd(log2m);
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            in.defaultReadObject();
            this.log2m = log2m(rsd);
        }

        @Override
        public HyperLogLog build() {
            return new HyperLogLog(log2m);
        }

        @Override
        public int sizeof() {
            int k = 1 << log2m;
            return RegisterSet.getBits(k) * 4;
        }

        public static Builder withLog2m(int log2m) {
            return new Builder(log2m);
        }

        public static Builder withRsd(double rsd) {
            return new Builder(rsd);
        }

        public static HyperLogLog build(byte[] bytes) throws IOException {
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            return build(new DataInputStream(bais));
        }

        public static HyperLogLog build(DataInput serializedByteStream) throws IOException {
            int log2m = serializedByteStream.readInt();
            int byteArraySize = serializedByteStream.readInt();
            return new HyperLogLog(log2m,
                    new RegisterSet(1 << log2m, Bits.getBits(serializedByteStream, byteArraySize)));
        }
    }

    @SuppressWarnings("serial")
    protected static class HyperLogLogMergeException extends CardinalityMergeException {

        public HyperLogLogMergeException(String message) {
            super(message);
        }
    }

    protected static double getAlphaMM(final int p, final int m) {
        // See the paper.
        switch (p) {
            case 4:
                return 0.673 * m * m;
            case 5:
                return 0.697 * m * m;
            case 6:
                return 0.709 * m * m;
            default:
                return (0.7213 / (1 + 1.079 / m)) * m * m;
        }
    }

    protected static double linearCounting(int m, double V) {
        return m * Math.log(m / V);
    }
}