package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datamodel.IResult;
import datamodel.ResultFactory;
import reporting.IResultReporter;
import reporting.TypeReportFactory;

public class ReportOnHtmlTEST {
	ResultFactory resultfactory;
	IResult resultmanager;
	
	TypeReportFactory reportfactory;
	IResultReporter reporter;
	
	String filename;
	String des;
	
	@Before
	public void setUp() throws Exception {
		resultfactory = new ResultFactory();
		resultmanager = resultfactory.constructResult("TEST DESCRIPTIONS", "avg");
		
		reportfactory = new TypeReportFactory();
		reporter = reportfactory.createReporter("ReportOnHTML");
	}

	@Test
	public void testRasterToHTML() {
		fail("Not yet implemented");
	}

	@Test
	public void testReportResultInFile() {
		fail("Not yet implemented");
	}

}
