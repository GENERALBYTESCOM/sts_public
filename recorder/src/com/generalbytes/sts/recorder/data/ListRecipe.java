package com.generalbytes.sts.recorder.data;

import java.util.ArrayList;
import java.util.List;

public class ListRecipe implements ISeedRecipe {

    private List<SeedCountPair> list = new ArrayList<>();
    private int currentIndex = 0;

    public ListRecipe(List<SeedCountPair> list) {
        this.list = list;
    }

    @Override
    public SeedCountPair nextPair() {
        if (hasMorePairs()) {
            return list.get(currentIndex++);
        }
        return null;
    }

    @Override
    public boolean hasMorePairs() {
        return currentIndex < list.size();
    }
}
