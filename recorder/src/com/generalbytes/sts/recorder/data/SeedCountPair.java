package com.generalbytes.sts.recorder.data;

public class SeedCountPair {
    private long seed;
    private long count;

    public SeedCountPair(long seed, long count) {
        this.seed = seed;
        this.count = count;
    }

    public long getSeed() {
        return seed;
    }

    public long getCount() {
        return count;
    }
}
