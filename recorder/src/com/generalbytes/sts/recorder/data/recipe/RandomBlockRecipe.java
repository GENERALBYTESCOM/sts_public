package com.generalbytes.sts.recorder.data.recipe;

import com.generalbytes.sts.recorder.data.ISeedRecipe;
import com.generalbytes.sts.recorder.data.SeedCountPair;

import java.util.Random;

public class RandomBlockRecipe implements ISeedRecipe {
    private long maxSeed = 0;
    private long count = 0;
    private long blockSize = 0;
    private long index = 0;
    private Random rnd = new Random(0);

    public RandomBlockRecipe(long maxSeed, long count, long blockSize) {
        this.maxSeed = maxSeed;
        this.count = count;
        this.blockSize = blockSize;
    }

    @Override
    public SeedCountPair nextPair() {
        if (hasMorePairs()) {
            long randomSeed = rnd.nextLong() % maxSeed;
            index++;
            return new SeedCountPair(randomSeed, blockSize);
        }
        return null;
    }

    @Override
    public boolean hasMorePairs() {
        return index < count;
    }
}
