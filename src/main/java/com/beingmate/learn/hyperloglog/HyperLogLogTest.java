package com.beingmate.learn.hyperloglog;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import net.agkn.hll.HLL;

/***
 * @author yfeng
 * @date 2018-05-15 13:50
 */
public class HyperLogLogTest {

    public static void main(String[] args) {
        final int seed = 123456;
        HashFunction hash = Hashing.murmur3_128(seed);

        // data on which to calculate distinct count
        final Integer[] data = new Integer[]{1, 1, 2, 3, 4, 5, 6, 6, 6, 7, 7, 7, 7, 8, 10};

        //number of bucket and bits per bucket
        final HLL hll = new HLL(13, 5);
        for (int item : data) {
            final long value = hash.newHasher().putInt(item).hash().asLong();
            hll.addRaw(value);
        }
        System.out.println("Distinct count=" + hll.cardinality());
    }
}