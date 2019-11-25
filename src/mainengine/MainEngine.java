/**
 * 
 */
package mainengine;

import java.util.ArrayList;

import datamodel.AC;
import datamodel.IResult;
import datamodel.Kitchen;
import datamodel.Laundry;
import datamodel.MeasurementRecord;
import datamodel.ResultFactory;
import reporting.IResultReporter;
import reporting.TypeReportFactory;
import timeaggregation.AggregatorFactory;
import timeaggregation.IAggregator;
import reporting.IResultReporter;
import reporting.TypeReportFactory;
import client.ApplicationMainGUI;
import dataload.DataLoader;
import dataload.DataLoaderFactory;
import dataload.ILoader;

/**
 * @author vaggelisbarb
 *
 */

public class MainEngine implements IMainEngine {
	
	private IResult kitchenRec;
	private IResult laundryRec;
	private IResult acRec;
	private ResultFactory resultfactory;
	
	private ILoader dataloader;
	private DataLoaderFactory dataloaderfactory;
	
	private AggregatorFactory aggregatorfactory;
	private IAggregator aggregator; 
	
	
	
	public MainEngine() {
		super();
		resultfactory = new ResultFactory();
		kitchenRec = resultfactory.constructResult("Kitchen");
		laundryRec = resultfactory.constructResult("Laundry");
		acRec = resultfactory.constructResult("AC");
		dataloaderfactory = new DataLoaderFactory();
		dataloader = dataloaderfactory.createDataLoader("DataLoader","/home/vaggelisbarb/Eclipse_Projects/2019_2020_<2766>_<2784>_<2821>/Resources/TestInput/household_preview.txt");
		aggregatorfactory = new AggregatorFactory();
		aggregator = aggregatorfactory.createAggregator("Aggregator");
	}

	@Override
	public int loadData(String fileName, String delimeter, Boolean hasHeaderLine, int numFields,
			ArrayList<MeasurementRecord> objCollection) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public IResult aggregateByTimeUnit(ArrayList<MeasurementRecord> inputMeasurements, String aggregatorType,
			String aggFunction, String description) {
			return null;
	}
	
	@Override
	public int reportResultInFile(IResult result, String reportType, String filename) {
		TypeReportFactory reporterFactory = new TypeReportFactory();
		IResultReporter reporter = reporterFactory.createReporter(reportType);
		return 0;
	}
	
	
}
