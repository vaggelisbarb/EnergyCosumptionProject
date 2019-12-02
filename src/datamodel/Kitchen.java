package datamodel;

import java.util.ArrayList;
import java.util.HashMap;

public class Kitchen{	
	private ArrayList<MeasurementRecord> kitchenRecords;

	
	public Kitchen() {
		super();
		kitchenRecords = new ArrayList<MeasurementRecord>();
	}

	public Kitchen(ArrayList<MeasurementRecord> kitchenRecords) {
		super();
		this.kitchenRecords = kitchenRecords;
	}

	
	
}
