package dataload;

import dataload.DataLoader;
import datamodel.MeasurementRecord;

public class DataLoaderFactory {
	public ILoader <MeasurementRecord> createDataLoader(){
					return new DataLoader();
	}
}
