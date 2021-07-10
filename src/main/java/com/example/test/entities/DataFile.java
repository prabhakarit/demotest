package com.example.test.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * DataFile
 * 
 * Will help store list of all records from CSV
 * 
 */
public class DataFile {
    private List<Record> records;

    public DataFile() {
        if (this.records == null) {
            this.records = new ArrayList<>();
        }
    }

    public void add(Record record) {
        this.records.add(record);
    }

    public List<Record> getRecords() {
        return this.records;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Record record : this.records) {
            sb.append(record.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
    
}
