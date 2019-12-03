package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import dataload.DataLoaderFactory;
import dataload.ILoader;
import datamodel.MeasurementRecord;

public class DataLoaderTest {
	private static ArrayList<MeasurementRecord> objCollection;
	
	private static DataLoaderFactory dataloaderfactory;
	private static ILoader<MeasurementRecord> dataloader;
	
	private static String fileName;
	private static String delimeter;
	private static Boolean hasHeaderLine;
	private static int numFields;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		fileName = "/home/vaggelisbarb/Eclipse_Projects/2019_2020_<2766>_<2784>_<2821>/Resources/TestInput/household_preview.txt";
		dataloaderfactory = new DataLoaderFactory();
		dataloader = dataloaderfactory.createDataLoader("/home/vaggelisbarb/Eclipse_Projects/2019_2020_<2766>_<2784>_<2821>/Resources/TestInput/household_preview.txt");
		objCollection = new ArrayList<MeasurementRecord>();
		hasHeaderLine = true;
		delimeter = ";";
		numFields = 100;
		
	}

	@After
	public void tearDown() throws Exception {
		objCollection = new ArrayList<MeasurementRecord>();
	}

	@Test
	public void testLoad() {
		int numRows = dataloader.load(fileName, delimeter, hasHeaderLine, numFields, objCollection);
		assertEquals(numRows,100);
	}

	@Test
	public void testConstructRecordsFromRow() {
		fail("Not yet implemented");
	}

}
