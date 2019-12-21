package tests;



import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
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
	
	@Before
	public void setUp() throws Exception {
		fileName = "/home/vaggelisbarb/Eclipse_Projects/2019_2020_<2766>_<2784>_<2821>/Resources/TestInput/household_preview.txt";
		dataloaderfactory = new DataLoaderFactory();
		dataloader = dataloaderfactory.createDataLoader();
		objCollection = new ArrayList<MeasurementRecord>();
		hasHeaderLine = true;
		delimeter = ";";
		numFields = 9;
		
	}

	@Test
	public void testLoad() {
		int numRows = dataloader.load(fileName,delimeter,hasHeaderLine, numFields, objCollection);
		assertEquals(FileUtilities.countLinesOfAFile(fileName),numRows);
		System.out.println("Rows of file are : " + FileUtilities.countLinesOfAFile(fileName));
		for(MeasurementRecord rec : objCollection) {
			System.out.println("Date -> " + rec.getFulldate() + "\tTime -> " + rec.getFulltime() + "\tAC Cons ->" + rec.getAcCons());
		}
	}

	@Test
	public void testConstructRecordsFromRow() {
		
	}

}
