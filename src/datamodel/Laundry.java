/**
 * 
 */
package datamodel;

import java.util.ArrayList;

/**
 * @author vaggelisbarb
 *
 */
public class Laundry extends ConsumptionResult{
	private ArrayList<MeasurementRecord> LaundryRec;
	
	
	
	/**
	 * 
	 */
	public Laundry() {
		super();
	}

	/**
	 * @param laundryRec
	 */
	public Laundry(ArrayList<MeasurementRecord> LaundryRec) {
		super();
		this.LaundryRec = LaundryRec;
	}

	public int add(String timeUnit, MeasurementRecord record) {
		return 0;
	}
}
