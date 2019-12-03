package dataload;

import dataload.DataLoader;
import datamodel.MeasurementRecord;

public class DataLoaderFactory {
	public ILoader <MeasurementRecord> createDataLoader(String filename){
			if(!filename.equals(""))
					return new DataLoader(filename);
		
		System.out.println("If the code got up to here, you passed a wrong argument to the FullDataLoader Factory");
		return null;
	}
}
