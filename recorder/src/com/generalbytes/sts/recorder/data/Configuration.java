package com.generalbytes.sts.recorder.data;

public class Configuration {
    public enum OutputType {
        BINARY,
        NUMERICAL
    }
    private OutputType outputType;
    private int range; //0-range
    private String filename;
    private ISeedRecipe recipe;

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

    public ISeedRecipe getRecipe() {
        return recipe;
    }

    public void setRecipe(ISeedRecipe recipe) {
        this.recipe = recipe;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
