package com;

import com.example.test.Manager;
import com.example.test.context.Context;
import com.example.test.context.Data;
/**
 * Application
 * 
 * Runner for reporter
 */
public class Application {
    public static void main(String[] args) {
        Context context = new Context();
        // update sample name below
        Data datafiles = new Data("sample1");
        context.setCsvFormatFile(datafiles.getFormatFilePath());
        context.setCsvDataFile(datafiles.getDataFilePath());
        Manager.instance.run(context);
    }
}
