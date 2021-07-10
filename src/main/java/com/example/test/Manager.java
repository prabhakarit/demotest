package com.example.test;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public enum Manager {
    instance;

    private static List<RawData> rawDataList;
    private static Map<String, Set<String>> mapContractIdToCustId = new HashMap<>();
    private static Map<String, Set<String>> mapGeozoneToCustId = new HashMap<>(); 
    private static Map<String, List<Integer>> mapGeozoneToBuildTime = new HashMap<>();
    
    public void run() {
		rawDataList = RawData.gList();
        readAllDataAtOnce(Constants.csvDataFile);
        report();
    }

    public void report() {
        System.out.println("====== Report ======");
        System.out.println("Number of unique customerId for each contractId");
        for (Map.Entry<String, Set<String>> entry : mapContractIdToCustId.entrySet()) {
            System.out.println("For contractId = " + entry.getKey() + ", No. of unique customerIds = " + entry.getValue().size());
        }
        System.out.println("Number of unique customerId for each geozone");
        for (Map.Entry<String, Set<String>> entry : mapGeozoneToCustId.entrySet()) {
            System.out.println("For geozone = " + entry.getKey() + ", No. of unique customerIds = " + entry.getValue().size());
        }
        System.out.println("Average build duration for each geozone");
        for (Map.Entry<String, List<Integer>> entry : mapGeozoneToBuildTime.entrySet()) {
            int totalbuildDurationCount = entry.getValue().size();
            int sumOfBuildDurations = 0;
            for (int buildDuration : entry.getValue()) {
                sumOfBuildDurations = sumOfBuildDurations + buildDuration;
            }
            System.out.println("For geozone = " + entry.getKey() + ", average build duration = " + (sumOfBuildDurations/totalbuildDurationCount));
        }
        System.out.println("List of unique customerId for each geozone");
        for (Map.Entry<String, Set<String>> entry : mapGeozoneToCustId.entrySet()) {
            System.out.println("For geozone = " + entry.getKey() + ", list of unique customerIds = " + entry.getValue());
        }
    }

    public void readAllDataAtOnce(String file)
    {
        try {

            // Create an object of filereader class
            // with CSV file as a parameter.
            FileReader filereader = new FileReader(file);

            // create csvReader object
            // and skip first Line
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                                    .withSkipLines(1)
                                    .build();
            List<String[]> allData = csvReader.readAll();

            // print Data
            for (String[] row : allData) {
                int index = 0;
                String geozone = null;
                String customerId = null;
                String contractId = null;
                Integer duration = null;
                for (String cell : row) {
                    //System.out.print(cell + "\t");
                    RawDataPointValue rawDataPointValue = new RawDataPointValue(rawDataList.get(index), cell);
                    switch(rawDataList.get(index).getIndex()){
                        case 0:
                            customerId = rawDataPointValue.getValue();
                            break;
                        case 1:
                            contractId = rawDataPointValue.getValue();
                            break;
                        case 2:
                            geozone = rawDataPointValue.getValue();
                            break;
                        case 5:
                            duration = Integer.valueOf(rawDataPointValue.getValue());
                            break;
                        default:
                            break;
                    }
                    System.out.println(rawDataPointValue);
                    index = index + 1;
                }
                // collate customer ids by contractId
                Set<String> custIdsByContractId = null;
                if (mapContractIdToCustId.get(contractId) == null) {
                    custIdsByContractId = new HashSet<>();
                } else {
                    custIdsByContractId = mapContractIdToCustId.get(contractId);
                }
                custIdsByContractId.add(customerId);
                mapContractIdToCustId.put(contractId, custIdsByContractId);
                // collate customer ids by geozone
                Set<String> custIdsByGeozone = null;
                if (mapGeozoneToCustId.get(geozone) == null) {
                    custIdsByGeozone = new HashSet<>();
                } else {
                    custIdsByGeozone = mapGeozoneToCustId.get(geozone);
                }
                custIdsByGeozone.add(customerId);
                mapGeozoneToCustId.put(geozone, custIdsByGeozone);
                // collate durations by geozone
                List<Integer> buildDurationsByGeozone = null;
                if (mapGeozoneToBuildTime.get(geozone) == null) {
                    buildDurationsByGeozone = new ArrayList<>();
                } else {
                    buildDurationsByGeozone = mapGeozoneToBuildTime.get(geozone);
                }
                buildDurationsByGeozone.add(duration);
                mapGeozoneToBuildTime.put(geozone, buildDurationsByGeozone);
                System.out.println();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
