package com.generalbytes.sts.recorder;

import java.util.Random;

public class ExampleRandom implements IRandom {
    private Random rnd;
    public ExampleRandom(long seed) {
        rnd = new Random(seed);
    }

    @Override
    public int getNumber(int range) {
        return rnd.nextInt(range);
    }

    @Override
    public boolean getBit() {
        return rnd.nextBoolean();
    }
}
