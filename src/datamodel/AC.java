/**
 * 
 */
package datamodel;

import java.util.ArrayList;

/**
 * @author vaggelisbarb
 *
 */
public class AC extends ConsumptionResult{
	private ArrayList<MeasurementRecord> AcRec;
	
	/**
	 * @param acRec
	 */
	public AC(ArrayList<MeasurementRecord> acRec) {
		super();
		AcRec = acRec;
	}

	
	/**
	 * 
	 */
	public AC() {
		super();
	}


	public int add(String timeUnit, MeasurementRecord record) {
		return 0;
	}
	
}
