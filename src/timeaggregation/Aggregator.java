/**
 * 
 */
package timeaggregation;

import java.util.ArrayList;

import datamodel.IResult;
import datamodel.MeasurementRecord;
import datamodel.ResultFactory;
import datamodel.ResultManager;

/**
 * @author vaggelisbarb
 *
 */
public class Aggregator implements IAggregator{
	private IResult aggregationResult;
	private ResultFactory resultFactory;
	private String timeUnit;
	private String description;
	private String aggFunction;
	
	// Default Constructor
	public Aggregator() {
		resultFactory = new ResultFactory();
		aggregationResult = resultFactory.constructResult(description,timeUnit);
	}

	// Constructor
	public Aggregator(IResult aggregationResult, ResultFactory resultFactory,String timeUnit,String description,String aggFunction) {
		this.aggregationResult = aggregationResult;
		this.resultFactory = resultFactory;
		this.timeUnit = timeUnit;
		this.description = description;
		this.aggFunction = aggFunction;
	}

	
	public Aggregator(String timeUnit,String aggFunction) {
		this.timeUnit = timeUnit;
		this.aggFunction = aggFunction;
		resultFactory = new ResultFactory();
		aggregationResult = resultFactory.constructResult(description,aggFunction);
	}

	@Override
	public IResult aggregateByTimeUnit(ArrayList<MeasurementRecord> inputMeasurements, String aggFunction,
			String description) {
		
		aggregationResult = new ResultManager(description,aggFunction);
		for(MeasurementRecord record : inputMeasurements) {
			aggregationResult.add(this.timeUnit, record);
		}
		/*aggregationResult.getDetailedResults();
		aggregationResult.getAggregateMeterLaundry();
		aggregationResult.getAggregateMeterAC();
		aggregationResult.getAggregateMeterKitchen();
		*/
		return aggregationResult;
	}

	@Override
	public String getTimeUnitType() {
		return this.timeUnit;
	}
	
}
