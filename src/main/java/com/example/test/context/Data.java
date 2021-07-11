package com.example.test.context;

import com.example.test.constants.Constants;

/**
 * Data
 * 
 * Helps manage data files
 */
public class Data {
    private String sampleName;
    private String formatFileName;
    private String dataFileName;
    private String dataFilePath;
    private String formatFilePath;
    
    public Data(String sampleName, String formatFileName, String dataFileName) {
        this.sampleName = sampleName;
        this.formatFileName = formatFileName;
        this.dataFileName = dataFileName;
        this.dataFilePath = getFilePath(sampleName, dataFileName);
        this.formatFilePath = getFilePath(sampleName, formatFileName);
    }

    public Data(String sampleName) {
        this(sampleName, Constants.csvFormatFileName, Constants.csvDataFileName);
    }

    public static String getFilePath(String sampleName, String fileName) {
        StringBuffer filePathSB = new StringBuffer();
        filePathSB.append(Constants.basePath)
        .append(Constants.pathSeparator)
        .append(Constants.rootDirOfSamples)
        .append(Constants.pathSeparator)
        .append(sampleName)
        .append(Constants.pathSeparator)
        .append(fileName);
        return filePathSB.toString();
    }
    
    public String getDataFilePath() {
        return dataFilePath;
    }

    public String getFormatFilePath() {
        return formatFilePath;
    }

    public String getSampleName() {
        return sampleName;
    }
    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
    }
    public String getFormatFileName() {
        return formatFileName;
    }
    public void setFormatFileName(String formatFileName) {
        this.formatFileName = formatFileName;
    }
    public String getDataFileName() {
        return dataFileName;
    }
    public void setDataFileName(String dataFileName) {
        this.dataFileName = dataFileName;
    }
    
}
