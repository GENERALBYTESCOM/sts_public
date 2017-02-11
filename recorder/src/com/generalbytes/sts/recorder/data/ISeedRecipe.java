package com.generalbytes.sts.recorder.data;

public interface ISeedRecipe {
    SeedCountPair nextPair();
    boolean hasMorePairs();
}
