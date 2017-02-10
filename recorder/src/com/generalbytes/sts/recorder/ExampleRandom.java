package com.generalbytes.sts.recorder;

import java.util.Random;

/**
 * Created by b00lean on 10.2.17.
 */
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
