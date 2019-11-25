/**
 * 
 */
package datamodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
/**
 * @author vaggelisbarb
 * 
 *
 */
public abstract class ConsumptionResult implements IResult{
	private String description;
	private String timeUnit;

	public ConsumptionResult() {
		super();
	}

	@Override
	public abstract int add(String timeUnit, MeasurementRecord record);

	@Override
	public String getDescription() {
		return " Time Period : ";
	}

	@Override
	public HashMap<String, ArrayList<MeasurementRecord>> getDetailedResults() {
		return null;
	}

	@Override
	public HashMap<String, Double> getAggregateMeterKitchen(){
		return null;
	}

	@Override
	public HashMap<String, Double> getAggregateMeterLaundry() {
		return null;
	}

	@Override
	public HashMap<String, Double> getAggregateMeterAC() {
		return null;
	}

	@Override
	public String getAggregateFunction() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
