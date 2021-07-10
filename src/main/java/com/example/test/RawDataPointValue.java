package com.example.test;

public class RawDataPointValue {
    private RawData rawData;
    private String value;
    private String valueForUse;
    public RawDataPointValue( RawData rawData, String value ) {
        this.rawData = rawData;
        this.valueForUse = String.valueOf(value);
        // implement formatter and coverter for storage
        if (rawData.getFormat().equalsIgnoreCase("time-secs")) {
            StringBuffer sb= new StringBuffer(value);
            this.value = sb.deleteCharAt(sb.length()-1).toString();
            return;
        }
        this.value = String.valueOf(value);
    }
    public RawData getRawData() {
        // implement formatter and converted for usage
        return this.rawData;
    }
    public void setRawData(RawData rawData) {
        this.rawData = rawData;
    }
    public String getValue() {
        return this.value;
    }
    public void setValue(String value) {
        // implement formatter and coverter for storage
        this.value = String.valueOf(value);
    }
    // Creating toString
    @Override
    public String toString()
    {
        return valueForUse + " is the "
            + rawData.getName();
    }
}
