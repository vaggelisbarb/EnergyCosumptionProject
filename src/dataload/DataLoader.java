package dataload;

import java.util.ArrayList;


import datamodel.MeasurementRecord;
import datamodel.ResultManager;

public class DataLoader implements ILoader{
	private String filename;
	

	public DataLoader() {
		super();
	}

	public DataLoader(String filename) {
		super();
		this.filename = filename;
	}

	@Override
	public int load(String fileName, String delimeter, boolean hasHeaderLine, int numFields, ArrayList objCollection) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int constructRecordsFromRow(String[] tokens, ResultManager resultmanager) {
		String fullDate;
		String fullTime;
		double kitchenCons;
		double laundryCons;
		double acCons;
		
		fullDate = tokens[0];
		fullTime = tokens[1];
		kitchenCons = Double.parseDouble(tokens[6]);
		laundryCons = Double.parseDouble(tokens[7]);
		acCons = Double.parseDouble(tokens[8]);
		
		MeasurementRecord kiObj = new MeasurementRecord(fullDate, fullTime, kitchenCons, 0, 0);
		MeasurementRecord laObj = new MeasurementRecord(fullDate, fullTime, 0, laundryCons, 0);
		MeasurementRecord acObj = new MeasurementRecord(fullDate, fullTime, 0, 0, acCons);
		
		resultmanager.add()
	}
}
