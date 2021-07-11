package com.example.test.context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.example.test.entities.IField;

public class Context {
    private List<IField> rawDataList;
    private Map<String, Set<String>> mapContractIdToCustId = new HashMap<>();
    private Map<String, Set<String>> mapGeozoneToCustId = new HashMap<>(); 
    private Map<String, List<Integer>> mapGeozoneToBuildTime = new HashMap<>();
    private String csvFormatFile;
    private String csvDataFile;
    public List<IField> getRawDataList() {
        return rawDataList;
    }
    public void setRawDataList(List<IField> rawDataList) {
        this.rawDataList = rawDataList;
    }
    public Map<String, Set<String>> getMapContractIdToCustId() {
        return mapContractIdToCustId;
    }
    public void setMapContractIdToCustId(Map<String, Set<String>> mapContractIdToCustId) {
        this.mapContractIdToCustId = mapContractIdToCustId;
    }
    public Map<String, Set<String>> getMapGeozoneToCustId() {
        return mapGeozoneToCustId;
    }
    public void setMapGeozoneToCustId(Map<String, Set<String>> mapGeozoneToCustId) {
        this.mapGeozoneToCustId = mapGeozoneToCustId;
    }
    public Map<String, List<Integer>> getMapGeozoneToBuildTime() {
        return mapGeozoneToBuildTime;
    }
    public void setMapGeozoneToBuildTime(Map<String, List<Integer>> mapGeozoneToBuildTime) {
        this.mapGeozoneToBuildTime = mapGeozoneToBuildTime;
    }
    public String getCsvFormatFile() {
        return csvFormatFile;
    }
    public void setCsvFormatFile(String csvFormatFile) {
        this.csvFormatFile = csvFormatFile;
    }
    public String getCsvDataFile() {
        return csvDataFile;
    }
    public void setCsvDataFile(String csvDataFile) {
        this.csvDataFile = csvDataFile;
    }

    
}
