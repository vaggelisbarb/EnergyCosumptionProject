package datamodel;

import java.util.ArrayList;
import java.util.HashMap;

public class AC {
	private ArrayList<MeasurementRecord> AcRecords;


	public AC() {
		super();
		AcRecords = new ArrayList<MeasurementRecord>();
	}

	public AC(ArrayList<MeasurementRecord> acRecords) {
		super();
		AcRecords = acRecords;
	}
	
	
}