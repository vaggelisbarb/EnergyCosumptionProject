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
public class Kitchen extends ConsumptionResult{
	
	private ArrayList<MeasurementRecord> KichenRecords;
	
	
	/**
	 * 
	 */
	public Kitchen() {
		super();
	}

	/**
	 * @param kichenRecords
	 */
	public Kitchen(ArrayList<MeasurementRecord> KichenRecords) {
		super();
		this.KichenRecords = KichenRecords;
	}

	public int add(String timeUnit, MeasurementRecord record) {
		return 0;
	}
}
