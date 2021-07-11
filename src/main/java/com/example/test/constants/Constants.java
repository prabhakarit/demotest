package com.example.test.constants;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URI;

public interface Constants {
    //public static final String csvFormatFile = "./csvFormatFile.json";
    //public static final String csvDataFile = "./csvDataFile.csv";
    public static final String sample = "sample1";
    public static final String csvFormatFileName = "csvFormatFile.json";
    public static final String csvDataFileName = "csvDataFile.csv";
    public static final String rootDirOfSamples = "resources/testdata";
    public static final String basePath = new File("").getAbsolutePath();
    public static final String pathSeparator = "/";
    public static final String csvFormatFile = basePath+pathSeparator+rootDirOfSamples+pathSeparator+sample+pathSeparator+csvFormatFileName;
    public static final String csvDataFile = basePath+pathSeparator+rootDirOfSamples+pathSeparator+sample+pathSeparator+csvDataFileName;
    public static FileReader getFileReader(String filepath) throws FileNotFoundException{
        System.out.println(filepath);
        return new FileReader(filepath);
    }
}