package com.example.test;

import java.util.List;
import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

public interface RawData {
    public abstract Integer getIndex();
    public abstract String getName();
    public abstract String getDescription();
    public abstract String getFormat();
    public static RawData gRawData(String jsonData){
        // Creating a Gson Object
        Gson gson = new Gson();
  
        // Converting json to object
        // first parameter should be prpreocessed json
        // and second should be mapping class
        return gson.fromJson(jsonData,
                            RawDataPoint.class);
    }
    public static List<RawData> gList() {
        List<RawData> rawDataList = new ArrayList<>(10);
        JSONParser parser = new JSONParser();
            try {
                Object obj = parser.parse(new FileReader(Constants.csvFormatFile));
    
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
                    RawData rawData = gRawData(String.valueOf(jsonData));
                    rawDataList.add(rawData);
                    //System.out.println(rawData);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        return rawDataList;
    }
    public static RawData g(List<RawData> rawDatas, int index) {
        return rawDatas.get(index);
    }
}
