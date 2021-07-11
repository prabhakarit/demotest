package com.example.test.entities;

import java.util.List;

import com.example.test.constants.Constants;
import com.example.test.context.Context;
import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * RawData
 * 
 * Helps define a field
 * 
 */
public interface IField {
    public abstract Integer getIndex();
    public abstract String getName();
    public abstract String getDescription();
    public abstract String getFormat();
    public static IField gRawData(String jsonData){
        // Creating a Gson Object
        Gson gson = new Gson();
  
        // Converting json to object
        // first parameter should be prpreocessed json
        // and second should be mapping class
        return gson.fromJson(jsonData,
                            Field.class);
    }
    public static List<IField> gList(Context context) {
        List<IField> rawDataList = new ArrayList<>(10);
        JSONParser parser = new JSONParser();
            try {
                Object obj = parser.parse(Constants.getFileReader(context.getCsvFormatFile()));
    
                // A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
                JSONObject jsonObject = (JSONObject) obj;
    
                // A JSON array. JSONObject supports java.util.List interface.
                JSONArray listOfDataTypes = (JSONArray) jsonObject.get("dataTypes");
    
                // An iterator over a collection. Iterator takes the place of Enumeration in the Java Collections Framework.
                // Iterators differ from enumerations in two ways:
                // 1. Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.
                // 2. Method names have been improved.
                Iterator<JSONObject> iterator = listOfDataTypes.iterator();
                while (iterator.hasNext()) {
                    JSONObject jsonData = iterator.next();
                    //System.out.println(jsonData);
                    IField rawData = gRawData(String.valueOf(jsonData));
                    rawDataList.add(rawData);
                    //System.out.println(rawData);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        return rawDataList;
    }
}
