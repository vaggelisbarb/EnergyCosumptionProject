/**
 * 
 */
package mainengine;

import java.util.ArrayList;

import datamodel.IResult;
import datamodel.MeasurementRecord;
import datamodel.ResultFactory;
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
	
	private IResult resultmanager;
	private ResultFactory resultfactory;
	
	private ILoader<MeasurementRecord> dataloader;
	private DataLoaderFactory dataloaderfactory;
	
	private AggregatorFactory aggregatorfactory;
	private IAggregator aggregator; 
	
	private IResultReporter reporter;
	private TypeReportFactory typereportfactory;
	
	private ArrayList<MeasurementRecord> objCollection;
	
	
	
	public MainEngine() {
		objCollection = new ArrayList<MeasurementRecord>();
		resultfactory = new ResultFactory();
		//resultmanager = resultfactory.constructResult("ResultManager");
		
		dataloaderfactory = new DataLoaderFactory();
		dataloader = dataloaderfactory.createDataLoader();
	
		aggregatorfactory = new AggregatorFactory();
	}

	
	@Override
	public int loadData(String fileName, String delimeter, Boolean hasHeaderLine, int numFields,
			ArrayList<MeasurementRecord> objCollection) {
		return this.dataloader.load(fileName, delimeter, hasHeaderLine, numFields, this.objCollection);
	}
	
	@Override
	public IResult aggregateByTimeUnit(ArrayList<MeasurementRecord> inputMeasurements, String aggregatorType,
			String aggFunction, String description) {
		
		aggregator = aggregatorfactory.createAggregator(aggregatorType,aggFunction);
		return aggregator.aggregateByTimeUnit(objCollection, aggFunction, description);
	}
	
	@Override
	public int reportResultInFile(IResult result, String reportType, String filename) {
		TypeReportFactory reporterFactory = new TypeReportFactory();
		IResultReporter reporter = reporterFactory.createReporter(reportType);
		
		reporter.reportResultInFile(result, filename);
		return 0;
	}

}
