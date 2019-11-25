package dataload;

import dataload.DataLoader;
import dataload.DataLoader;

public class DataLoaderFactory {
	public ILoader createDataLoader(String className, String filename){
		if(className.equals("DataLoader"))
			return new DataLoader(filename);
		
		System.out.println("If the code got up to here, you passed a wrong argument to the FullDataLoader Factory");
		return null;
	}
}
