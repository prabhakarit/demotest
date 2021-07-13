package com.example.test;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.example.test.constants.Constants;
import com.example.test.context.Context;
import com.example.test.entities.DataFile;
import com.example.test.entities.IField;
import com.example.test.entities.Value;
import com.example.test.entities.Record;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

/**
 * Manager
 * 
 * Helps manage the calls for generation of the report 
 * 
 */
public enum Manager {
    instance;
    
    public void run(Context context) {
        IField.gList(context);
        readAllDataAtOnce(context);
        report(context);
    }

    public void report(Context context) {
        System.out.println("====== Report ======");
        System.out.println("Number of unique customerId for each contractId");
        for (Map.Entry<String, Set<String>> entry : context.getMapContractIdToCustId().entrySet()) {
            System.out.println("For contractId = " + entry.getKey() + ", No. of unique customerIds = " + entry.getValue().size());
        }
        System.out.println("Number of unique customerId for each geozone");
        for (Map.Entry<String, Set<String>> entry : context.getMapGeozoneToCustId().entrySet()) {
            System.out.println("For geozone = " + entry.getKey() + ", No. of unique customerIds = " + entry.getValue().size());
        }
        System.out.println("Average build duration for each geozone");
        for (Map.Entry<String, List<Integer>> entry : context.getMapGeozoneToBuildTime().entrySet()) {
            int totalbuildDurationCount = entry.getValue().size();
            int sumOfBuildDurations = 0;
            for (int buildDuration : entry.getValue()) {
                sumOfBuildDurations = sumOfBuildDurations + buildDuration;
            }
            System.out.println("For geozone = " + entry.getKey() + ", average build duration = " + (sumOfBuildDurations/totalbuildDurationCount));
        }
        System.out.println("List of unique customerId for each geozone");
        for (Map.Entry<String, Set<String>> entry : context.getMapGeozoneToCustId().entrySet()) {
            System.out.println("For geozone = " + entry.getKey() + ", list of unique customerIds = " + entry.getValue());
        }
    }

    public void readAllDataAtOnce(Context context)
    {
        try {
            // Create an object of filereader class
            // with CSV file as a parameter.
            //FileReader filereader = new FileReader(context.getCsvDataFile());
            FileReader filereader = Constants.getFileReader(context.getCsvDataFile());
            // create csvReader object
            // and skip first Line
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                                    .withSkipLines(1)
                                    .build();
            List<String[]> allData = csvReader.readAll();

            DataFile datafile = new DataFile();

            // print Data
            for (String[] row : allData) {
                int index = 0;
                String geozone = null;
                String customerId = null;
                String contractId = null;
                Integer duration = null;
                Record record = new Record();
                for (String cell : row) {
                    //System.out.print(cell + "\t");
                    Value rawDataPointValue = new Value(context.getRawDataList().get(index), cell);
                    record.add(context.getRawDataList().get(index), rawDataPointValue);
                    switch(context.getRawDataList().get(index).getIndex()){
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
                    //System.out.println(rawDataPointValue);
                    index = index + 1;
                }
                datafile.add(record);
                // collate customer ids by contractId
                Set<String> custIdsByContractId = null;
                if (context.getMapContractIdToCustId().get(contractId) == null) {
                    custIdsByContractId = new HashSet<>();
                } else {
                    custIdsByContractId = context.getMapContractIdToCustId().get(contractId);
                }
                custIdsByContractId.add(customerId);
                context.getMapContractIdToCustId().put(contractId, custIdsByContractId);
                // collate customer ids by geozone
                Set<String> custIdsByGeozone = null;
                if (context.getMapGeozoneToCustId().get(geozone) == null) {
                    custIdsByGeozone = new HashSet<>();
                } else {
                    custIdsByGeozone = context.getMapGeozoneToCustId().get(geozone);
                }
                custIdsByGeozone.add(customerId);
                context.getMapGeozoneToCustId().put(geozone, custIdsByGeozone);
                // collate durations by geozone
                List<Integer> buildDurationsByGeozone = null;
                if (context.getMapGeozoneToBuildTime().get(geozone) == null) {
                    buildDurationsByGeozone = new ArrayList<>();
                } else {
                    buildDurationsByGeozone = context.getMapGeozoneToBuildTime().get(geozone);
                }
                buildDurationsByGeozone.add(duration);
                context.getMapGeozoneToBuildTime().put(geozone, buildDurationsByGeozone);
            }
            System.out.println(datafile);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
