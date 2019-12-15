/**
 * 
 */
package mainengine;

import java.util.ArrayList;
import java.util.HashMap;

import datamodel.IResult;
import datamodel.MeasurementRecord;
import reporting.IResultReporter;
import reporting.TypeReportFactory;
import timeaggregation.AggregatorFactory;
import timeaggregation.IAggregator;
import dataload.DataLoaderFactory;
import dataload.ILoader;

/**
 * @author vaggelisbarb
 *
 */

public class MainEngine implements IMainEngine {
	
	private ILoader<MeasurementRecord> dataloader;
	private DataLoaderFactory dataloaderfactory;
	
	private AggregatorFactory aggregatorfactory;
	private IAggregator aggregator; 
	
	
	public MainEngine() {
		
		dataloaderfactory = new DataLoaderFactory();
		dataloader = dataloaderfactory.createDataLoader();
	
		aggregatorfactory = new AggregatorFactory();
	}

	
	@Override
	public int loadData(String fileName, String delimeter, Boolean hasHeaderLine, int numFields,
			ArrayList<MeasurementRecord> objCollection) {
		return this.dataloader.load(fileName, delimeter, hasHeaderLine, numFields, objCollection);
	}
	
	@Override
	public IResult aggregateByTimeUnit(ArrayList<MeasurementRecord> inputMeasurements, String aggregatorType,
			String aggFunction, String description) {
		
		aggregator = aggregatorfactory.createAggregator(aggregatorType,aggFunction);
		return aggregator.aggregateByTimeUnit(inputMeasurements, aggFunction, description);
	}
	
	@Override
	public int reportResultInFile(IResult result, String reportType, String filename) {
		TypeReportFactory reporterFactory = new TypeReportFactory();
		IResultReporter reporter = reporterFactory.createReporter(reportType);
		
		int isOk = reporter.reportResultInFile(result, filename);
		if(isOk<0)
			return -1;
		return 0;
	}
	
}
