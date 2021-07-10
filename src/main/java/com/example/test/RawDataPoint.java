package com.example.test;

public class RawDataPoint implements RawData {
    private String name;
    private String description;
    private String format;
    private Integer index;

    @Override
    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    @Override
    public String getFormat() {
        return this.format;
    }
    public void setFormat(String format) {
        this.format = format;
    }
    @Override
    public Integer getIndex()
    {
        return index;
    }
    public void setIndex(int index)
    {
        this.index = index;
    }
    @Override
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    // Creating toString
    @Override
    public String toString()
    {
        return "RawData [Index="
            + index
            + ", Name="
            + name
            + ", Description="
            + description
            + ", Format="
            + format + "]";
    }
}
