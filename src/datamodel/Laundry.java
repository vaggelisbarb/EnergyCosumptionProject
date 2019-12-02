package datamodel;

import java.util.ArrayList;
import java.util.HashMap;

public class Laundry{
	private ArrayList<MeasurementRecord> laundryRecords;
	
	
	public Laundry() {
		super();
		laundryRecords = new ArrayList<MeasurementRecord>(); 
	}

	public Laundry(ArrayList<MeasurementRecord> laundryRecords) {
		super();
		this.laundryRecords = laundryRecords;
	}


	
}