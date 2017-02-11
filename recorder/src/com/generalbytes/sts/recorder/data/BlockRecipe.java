package com.generalbytes.sts.recorder.data;

public class BlockRecipe implements ISeedRecipe{
    private long maxSeed = 0;
    private long count = 0;
    private long blockSize = 0;
    private long currentSeed = 0;
    private long step = 0;

    public BlockRecipe(long maxSeed, long count, long blockSize) {
        this.maxSeed = maxSeed;
        this.count = count;
        this.blockSize = blockSize;
        step = maxSeed / count; //better generate more data then less
    }

    @Override
    public SeedCountPair nextPair() {
        if (hasMorePairs()) {
            final SeedCountPair seedCountPair = new SeedCountPair(currentSeed, blockSize);
            currentSeed+=step;
            return seedCountPair;
        }
        return null;
    }

    @Override
    public boolean hasMorePairs() {
        return currentSeed <= maxSeed;
    }
}
