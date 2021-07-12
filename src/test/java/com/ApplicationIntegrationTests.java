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
        // Running for sample2 -- additional field at end
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
        // Running for sample3 -- swapped field positions
        datafiles = new Data("sample3");
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
        assertEquals("customerId", listOfFieldDefinitions.get(0).getName());
        assertEquals("contractId", listOfFieldDefinitions.get(1).getName());
        assertEquals("geozone", listOfFieldDefinitions.get(2).getName());
        assertEquals("teamcode", listOfFieldDefinitions.get(3).getName());
        assertEquals("projectcode", listOfFieldDefinitions.get(4).getName());
        assertEquals("buildduration", listOfFieldDefinitions.get(5).getName());
        assertEquals("optional", listOfFieldDefinitions.get(6).getName());
        datafiles = new Data("sample1");
        context.setCsvFormatFile(datafiles.getFormatFilePath());
        context.setCsvDataFile(datafiles.getDataFilePath());
        listOfFieldDefinitions = IField.gList(context);
        assertEquals(6, listOfFieldDefinitions.size());
        assertEquals("customerId", listOfFieldDefinitions.get(0).getName());
        assertEquals("contractId", listOfFieldDefinitions.get(1).getName());
        assertEquals("geozone", listOfFieldDefinitions.get(2).getName());
        assertEquals("teamcode", listOfFieldDefinitions.get(3).getName());
        assertEquals("projectcode", listOfFieldDefinitions.get(4).getName());
        assertEquals("buildduration", listOfFieldDefinitions.get(5).getName());
        datafiles = new Data("sample3");
        context.setCsvFormatFile(datafiles.getFormatFilePath());
        context.setCsvDataFile(datafiles.getDataFilePath());
        listOfFieldDefinitions = IField.gList(context);
        assertEquals(6, listOfFieldDefinitions.size());
        assertEquals("customerId", listOfFieldDefinitions.get(0).getName());
        assertEquals("contractId", listOfFieldDefinitions.get(1).getName());
        assertEquals("teamcode", listOfFieldDefinitions.get(2).getName());
        assertEquals("projectcode", listOfFieldDefinitions.get(3).getName());
        assertEquals("buildduration", listOfFieldDefinitions.get(4).getName());
        assertEquals("geozone", listOfFieldDefinitions.get(5).getName());
	}
}
