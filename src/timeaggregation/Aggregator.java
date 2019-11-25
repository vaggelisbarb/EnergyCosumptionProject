/**
 * 
 */
package timeaggregation;

import java.util.ArrayList;

import datamodel.IResult;
import datamodel.MeasurementRecord;

/**
 * @author vaggelisbarb
 *
 */
public class Aggregator implements IAggregator{
	private IResult aggregationResult;
	
	public Aggregator() {
		super();
	}

	
	/**
	 * @param aggregationResult
	 */
	public Aggregator(IResult aggregationResult) {
		super();
		this.aggregationResult = aggregationResult;
	}


	@Override
	public IResult aggregateByTimeUnit(ArrayList<MeasurementRecord> inputMeasurements, String aggFunction,
			String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTimeUnitType() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
