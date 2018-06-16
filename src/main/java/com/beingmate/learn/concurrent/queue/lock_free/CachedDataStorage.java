package com.beingmate.learn.concurrent.queue.lock_free;

import java.io.IOException;

public class CachedDataStorage {

    private static final int CACHED_SIZE = 5000;

    private final Object[] data = new Object[CACHED_SIZE];

    private volatile long nextWriteIndex = 0;

    public void append(Object dataValue) {
        data[(int) (nextWriteIndex % CACHED_SIZE)] = dataValue;
        nextWriteIndex++;
    }

    public Reader createReader() {
        return new Reader();
    }

    public class Reader {

        private Reader() {
        }

        private volatile long nextReadIndex = 0;

        public Object next() throws IOException {
            if (nextReadIndex >= nextWriteIndex) {
                return null;
            }

            if (nextReadIndex <= nextWriteIndex - CACHED_SIZE) {
                throw new IOException("data outdated");
            }

            Object dataValue = data[(int) (nextReadIndex % CACHED_SIZE)];

            if (nextReadIndex <= nextWriteIndex - CACHED_SIZE) {
                throw new IOException("data outdated");
            } else {
                nextReadIndex++;
                return dataValue;
            }
        }
    }
}