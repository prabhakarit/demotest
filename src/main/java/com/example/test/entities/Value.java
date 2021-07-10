package com.example.test.entities;

/**
 * RawDataPointValue
 * 
 * Helps define the value of a csv record against a field
 * 
 */
public class Value {
    private IField field;
    private String value;
    private String valueForUse;
    public Value( IField rawData, String value ) {
        this.field = rawData;
        this.valueForUse = String.valueOf(value);
        // implement formatter and coverter for storage
        if (rawData.getFormat().equalsIgnoreCase("time-secs")) {
            StringBuffer sb= new StringBuffer(value);
            this.value = sb.deleteCharAt(sb.length()-1).toString();
            return;
        }
        this.value = String.valueOf(value);
    }
    public IField getField() {
        // implement formatter and converted for usage
        return this.field;
    }
    public void setField(IField rawData) {
        this.field = rawData;
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
            + field.getName();
    }
}
