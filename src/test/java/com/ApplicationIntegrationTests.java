package com;
import static org.junit.Assert.assertEquals;

import java.util.List;

import com.example.test.Manager;
import com.example.test.context.Context;
import com.example.test.context.Data;
import com.example.test.entities.IField;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;

//@SpringBootTest
@ContextConfiguration
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
class ApplicationIntegrationTests {

	@Test
	void testAppRun() throws Exception {
		Application.main(new String[]{});
	}

    @Test
	void testWithDifferentSamples() throws Exception {
        // Running for sample2
		Context context = new Context();
        Data datafiles = new Data("sample2");
        context.setCsvFormatFile(datafiles.getFormatFilePath());
        context.setCsvDataFile(datafiles.getDataFilePath());
        Manager.instance.run(context);
        context = new Context();
        // Running for sample1
        datafiles = new Data("sample1");
        context.setCsvFormatFile(datafiles.getFormatFilePath());
        context.setCsvDataFile(datafiles.getDataFilePath());
        Manager.instance.run(context);
	}

    @Test
	void testFormatGettingList() throws Exception {
        // Running for sample2
		Context context = new Context();
        Data datafiles = new Data("sample2");
        context.setCsvFormatFile(datafiles.getFormatFilePath());
        context.setCsvDataFile(datafiles.getDataFilePath());
        List<IField> listOfFieldDefinitions = IField.gList(context);
        assertEquals(7, listOfFieldDefinitions.size());
        datafiles = new Data("sample1");
        context.setCsvFormatFile(datafiles.getFormatFilePath());
        context.setCsvDataFile(datafiles.getDataFilePath());
        listOfFieldDefinitions = IField.gList(context);
        assertEquals(6, listOfFieldDefinitions.size());
	}
}
