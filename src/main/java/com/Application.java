package com;

import com.example.test.Manager;
import com.example.test.constants.Constants;
import com.example.test.context.Context;

public class Application {
    public static void main(String[] args) {
        Context context = new Context();
        context.setCsvFormatFile(Constants.csvFormatFile);
        context.setCsvDataFile(Constants.csvDataFile);
        Manager.instance.run(context);
    }
}
