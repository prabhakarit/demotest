package com.example.test.entities;

import java.util.HashMap;
import java.util.Map;

/**
 * RawDataRecord
 * 
 * Will help define a data record by handling mapping for value to respective field
 */
public class Record {
    private Map<IField, Value> datamapping;

    public Record() {
        if (datamapping == null ) {
            this.datamapping = new HashMap<>();
        }
    }

    public void add(IField field, Value value){
        datamapping.put(field, value);
    }

    public String getValueByField(String fieldName){
        for (Map.Entry<IField, Value> fields : datamapping.entrySet()) {
            if(fields.getKey().getName().equalsIgnoreCase(fieldName)){
                return fields.getValue().getValue();
            }
        }
        return null;
    }

    public String getValueByFieldIndex(int index){
        for (Map.Entry<IField, Value> fields : datamapping.entrySet()) {
            if(fields.getKey().getIndex().equals(index)){
                return fields.getValue().getValue();
            }
        }
        return null;
    }

    public Map<IField, Value> getAll() {
        return this.datamapping;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for(Map.Entry<IField, Value> fields : datamapping.entrySet()){
            sb.append(fields.getValue().toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}