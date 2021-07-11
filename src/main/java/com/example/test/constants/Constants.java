package com.example.test.constants;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public interface Constants {
    // Update following to pick a different sample
    public static final String sample = "sample1";
    public static final String csvFormatFileName = "csvFormatFile.json";
    public static final String csvDataFileName = "csvDataFile.csv";
    public static final String rootDirOfSamples = "resources/testdata";
    public static final String basePath = new File("").getAbsolutePath();
    public static final String pathSeparator = File.separator;
    public static final String csvFormatFile = basePath+pathSeparator+rootDirOfSamples+pathSeparator+sample+pathSeparator+csvFormatFileName;
    public static final String csvDataFile = basePath+pathSeparator+rootDirOfSamples+pathSeparator+sample+pathSeparator+csvDataFileName;
    public static FileReader getFileReader(String filepath) throws FileNotFoundException{
        return new FileReader(filepath);
    }
}