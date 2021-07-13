package com;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import com.example.test.Manager;
import com.example.test.context.Context;
import com.example.test.context.Data;
import com.example.test.entities.IField;

import org.assertj.core.util.Arrays;
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

    @Test
	void testDataLoaderSample1() throws Exception {
        // Running for sample1
		Context context = new Context();
        Data datafiles = new Data("sample1");
        context.setCsvFormatFile(datafiles.getFormatFilePath());
        context.setCsvDataFile(datafiles.getDataFilePath());
        IField.gList(context);
        Manager.instance.readAllDataAtOnce(context);
        // contractId to customers
        assertEquals(1, context.getMapContractIdToCustId().get("2348").size());
        assertTrue(context.getMapContractIdToCustId().get("2348").contains("3244131"));
        assertEquals(2, context.getMapContractIdToCustId().get("2346").size());
        assertTrue(context.getMapContractIdToCustId().get("2346").contains("3244332"));
        assertTrue(context.getMapContractIdToCustId().get("2346").contains("3244132"));
        // geozones to customers
        assertEquals(3, context.getMapGeozoneToCustId().get("eu_west").size());
        assertTrue(context.getMapGeozoneToCustId().get("eu_west").contains("3244132"));
        assertTrue(context.getMapGeozoneToCustId().get("eu_west").contains("3244131"));
        assertTrue(context.getMapGeozoneToCustId().get("eu_west").contains("3244131"));
        assertEquals(2, context.getMapGeozoneToCustId().get("us_west").size());
        assertTrue(context.getMapGeozoneToCustId().get("us_west").contains("1233456"));
        assertTrue(context.getMapGeozoneToCustId().get("us_west").contains("1223456"));
        // geozones to average build duration
        assertEquals(3, context.getMapGeozoneToBuildTime().get("eu_west").size());
        assertTrue(context.getMapGeozoneToBuildTime().get("eu_west").contains(4322));
        assertTrue(context.getMapGeozoneToBuildTime().get("eu_west").contains(4122));
        assertTrue(context.getMapGeozoneToBuildTime().get("eu_west").contains(4222));
        assertEquals(2, context.getMapGeozoneToBuildTime().get("us_west").size());
        assertTrue(context.getMapGeozoneToBuildTime().get("us_west").contains(2211));
        assertTrue(context.getMapGeozoneToBuildTime().get("us_west").contains(2221));
	}

    @Test
	void testDataLoaderSample2() throws Exception {
        // Running for sample1
		Context context = new Context();
        Data datafiles = new Data("sample2");
        context.setCsvFormatFile(datafiles.getFormatFilePath());
        context.setCsvDataFile(datafiles.getDataFilePath());
        IField.gList(context);
        Manager.instance.readAllDataAtOnce(context);
        // contractId to customers
        assertEquals(1, context.getMapContractIdToCustId().get("2348").size());
        assertTrue(context.getMapContractIdToCustId().get("2348").contains("3244131"));
        assertEquals(2, context.getMapContractIdToCustId().get("2346").size());
        assertTrue(context.getMapContractIdToCustId().get("2346").contains("3244332"));
        assertTrue(context.getMapContractIdToCustId().get("2346").contains("3244132"));
        // geozones to customers
        assertEquals(3, context.getMapGeozoneToCustId().get("eu_west").size());
        assertTrue(context.getMapGeozoneToCustId().get("eu_west").contains("3244132"));
        assertTrue(context.getMapGeozoneToCustId().get("eu_west").contains("3244131"));
        assertTrue(context.getMapGeozoneToCustId().get("eu_west").contains("3244131"));
        assertEquals(2, context.getMapGeozoneToCustId().get("us_west").size());
        assertTrue(context.getMapGeozoneToCustId().get("us_west").contains("1233456"));
        assertTrue(context.getMapGeozoneToCustId().get("us_west").contains("1223456"));
        // geozones to average build duration
        assertEquals(4, context.getMapGeozoneToBuildTime().get("eu_west").size());
        assertTrue(context.getMapGeozoneToBuildTime().get("eu_west").contains(4322));
        assertTrue(context.getMapGeozoneToBuildTime().get("eu_west").contains(4122));
        assertTrue(context.getMapGeozoneToBuildTime().get("eu_west").contains(4222));
        assertEquals(3, context.getMapGeozoneToBuildTime().get("us_west").size());
        assertTrue(context.getMapGeozoneToBuildTime().get("us_west").contains(2211));
        assertTrue(context.getMapGeozoneToBuildTime().get("us_west").contains(2221));
	}
}
