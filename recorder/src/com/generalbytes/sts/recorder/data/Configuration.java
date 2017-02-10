package com.generalbytes.sts.recorder.data;

import java.util.List;

public class Configuration {
    public enum OutputType {
        BINARY,
        NUMERICAL
    }
    private OutputType outputType;
    private int range; //0-range
    private List<SeedCountPair> seedCounts;
    private String filename;

    public Configuration() {
    }

    public OutputType getOutputType() {
        return outputType;
    }

    public void setOutputType(OutputType outputType) {
        this.outputType = outputType;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public List<SeedCountPair> getSeedCounts() {
        return seedCounts;
    }

    public void setSeedCounts(List<SeedCountPair> seedCounts) {
        this.seedCounts = seedCounts;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
