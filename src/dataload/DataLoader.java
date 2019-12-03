package dataload;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import datamodel.MeasurementRecord;

public class DataLoader implements ILoader <MeasurementRecord>{
	private String inputFile;
	

	public DataLoader() {
		inputFile = "/home/vaggelisbarb/Eclipse_Projects/2019_2020_<2766>_<2784>_<2821>/Resources/TestInput/household_preview.txt";
		
	}
	

	public DataLoader(String inputFile) {
		this.inputFile = inputFile;
	}


	@Override
	public int load(String fileName, String delimeter, boolean hasHeaderLine, int numFields, ArrayList<MeasurementRecord> objCollection) {
		if (numFields < 1){
			System.out.println("Wrong number of fields, less than 1!");
			System.exit(0);		
		}
		//Opening files for read and write, checking exception
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new FileInputStream(fileName));

		} catch (FileNotFoundException e) {
			System.out.println("Problem opening file: " + fileName);
			System.exit(0);
		}

		int count = 0;

		//process the title of the csv
		if(hasHeaderLine){
			String titleLine = inputStream.nextLine();
			count++;
		}
		String line = "";
		//process the actual rows one by one
		while (inputStream.hasNextLine()) {
			line = inputStream.nextLine();
			count++;

			StringTokenizer tokenizer = new StringTokenizer(line, delimeter);
			if(tokenizer.countTokens() != numFields){
				System.out.println("Wrong Input format in file " + fileName +". I found " + tokenizer.countTokens() + " values, but I expect " + numFields + " values per row!");
				//				System.exit(0);				
			}

			String[] tokens =  new String[numFields];
			for (int i=0; i< numFields;i++){
				tokens[i] = tokenizer.nextToken();
			}

			//ToDo: here add the method that takes the token and forms the object and puts it in the resultList			
			int objConstructionErrorCode;
			objConstructionErrorCode = constructRecordsFromRow(tokens, objCollection);
			if (objConstructionErrorCode !=0){
				System.out.println("ObjParsingError. I found a problem at line " + count + " of file " + fileName);
				System.exit(0);
			}
		}		
		inputStream.close();
		System.out.println("Processed " + count + " rows and loaded " + objCollection.size() + " objects.");
		return count;
	}
	
	public int constructRecordsFromRow(String [] tokens, ArrayList<MeasurementRecord> objCollection) {
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
		
		MeasurementRecord Obj = new MeasurementRecord(fullDate, fullTime, kitchenCons, laundryCons, acCons);
		
		objCollection.add(Obj);
		return objCollection.size();
	}
}
