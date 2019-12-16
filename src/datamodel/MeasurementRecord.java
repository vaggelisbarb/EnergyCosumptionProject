package datamodel;


/** Class that represents one line of the file,and holds details such as Date,Time,Kitchen consumption,Laundry consumption,A/C consumption
 * 
 *
 */
public class MeasurementRecord {
	private String fulldate;
	private String fulltime;
	private double kitchenCons;
	private double laundryCons;
	private double acCons;
	
	public MeasurementRecord(String fulldate, String fulltime,double kitchenCons) {
		super();
		this.fulldate = fulldate;
		this.fulltime = fulltime;
		this.kitchenCons = kitchenCons;
	}

	public MeasurementRecord(String fulldate, String fulltime, double kitchenCons, double laundryCons, double acCons) {
		super();
		this.fulldate = fulldate;
		this.fulltime = fulltime;
		this.kitchenCons = kitchenCons;
		this.laundryCons = laundryCons;
		this.acCons = acCons;
	}

	// Concat Date and Time strings with a "," between them
	public String getDateTime() {
		String comma = ",";
		String fullDateAndComma = this.fulldate.concat(comma);
		return fullDateAndComma.concat(this.fulltime);
	}
	
	public String getFulldate() {
		return fulldate;
	}

	public String getFulltime() {
		return fulltime;
	}

	public double getKitchenCons() {
		return kitchenCons;
	}
	
	public double getLaundryCons() {
		return laundryCons;
	}
	
	public double getAcCons() {
		return acCons;
	}
	
}
