package com.example.test.entities;

import java.util.Objects;

/**
 * RawDataPoint
 * 
 * Defines a field of CSV
 */
public class Field implements IField {
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

    @Override
    public int hashCode() {
        return 32 * this.index.hashCode() * this.name.hashCode() * this.format.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        // self check
    if (this == o)
    return true;
    // null check
    if (o == null)
        return false;
    // type check and cast
    if (getClass() != o.getClass())
        return false;
    Field record = (Field) o;
    // field comparison
    return Objects.equals(this.name, record.getName())
            && Objects.equals(this.format, record.getFormat()) 
            && Objects.equals(this.index, record.getIndex());
    }
}
