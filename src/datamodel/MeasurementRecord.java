package datamodel;


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

	// Concat Date ant Time strings with a "," between them
	public String getDateTime() {
		String comma = ",";
		String fullDateAndComma = this.fulldate.concat(comma);
		return fullDateAndComma.concat(this.fulltime);
	}
	
	public String getFulldate() {
		return fulldate;
	}
	public void setFulldate(String fulldate) {
		this.fulldate = fulldate;
	}

	public String getFulltime() {
		return fulltime;
	}
	public void setFulltime(String fulltime) {
		this.fulltime = fulltime;
	}

	public double getKitchenCons() {
		return kitchenCons;
	}
	public void setKitchenCons(double kitchenCons) {
		this.kitchenCons = kitchenCons;
	}

	public double getLaundryCons() {
		return laundryCons;
	}
	public void setLaundryCons(double laundryCons) {
		this.laundryCons = laundryCons;
	}

	public double getAcCons() {
		return acCons;
	}
	public void setAcCons(double acCons) {

		this.acCons = acCons;
	}
	
}
