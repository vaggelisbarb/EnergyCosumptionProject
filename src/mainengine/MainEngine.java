/**
 * 
 */
package mainengine;

import java.util.ArrayList;

import datamodel.IResult;
import datamodel.MeasurementRecord;
import datamodel.ResultFactory;
import datamodel.ResultManager;
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
	
	private IResult resultmanager;
	private ResultFactory resultfactory;
	
	private ILoader<MeasurementRecord> dataloader;
	private DataLoaderFactory dataloaderfactory;
	
	private AggregatorFactory aggregatorfactory;
	private IAggregator aggregator; 
	
	private IResultReporter reporter;
	private TypeReportFactory typereportfactory;
	
	
	
	public MainEngine() {
		super();
		resultfactory = new ResultFactory();
		resultmanager = resultfactory.constructResult("ResultManager");
		dataloaderfactory = new DataLoaderFactory();
		dataloader = dataloaderfactory.createDataLoader("/home/vaggelisbarb/Eclipse_Projects/2019_2020_<2766>_<2784>_<2821>/Resources/TestInput/household_preview.txt");
		aggregatorfactory = new AggregatorFactory();
		aggregator = aggregatorfactory.createAggregator("Aggregator");
	}

	@Override
	public int loadData(String fileName, String delimeter, Boolean hasHeaderLine, int numFields,
			ArrayList<MeasurementRecord> objCollection) {
		return this.dataloader.load(fileName, delimeter, hasHeaderLine, numFields, objCollection);
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
