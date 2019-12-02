/**
 * 
 */
package datamodel;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author vaggelisbarb
 *
 */
public class ResultManager implements IResult{
	private Kitchen kitchenResult;
  	private Laundry laundryResult;
  	private AC acResult;
  	
	
	public ResultManager() {
		super();
		kitchenResult = new Kitchen();
		laundryResult = new Laundry();
		acResult = new AC();
	}
	
	public ResultManager(Kitchen kitchenResult, Laundry laundryResult, AC acResult) {
		super();
		this.kitchenResult = kitchenResult;
		this.laundryResult = laundryResult;
		this.acResult = acResult;
	}

		
	@Override
	public int add(String timeUnit, MeasurementRecord record) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public HashMap<String, ArrayList<MeasurementRecord>> getDetailedResults() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public HashMap<String, Double> getAggregateMeterKitchen() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Double> getAggregateMeterLaundry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Double> getAggregateMeterAC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getAggregateFunction() {
		// TODO Auto-generated method stub
		return null;
	}


}
