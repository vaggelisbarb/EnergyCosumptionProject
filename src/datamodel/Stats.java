package datamodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class Stats {
	private String description;
	private String aggFunction;
	private HashMap<String, ArrayList<MeasurementRecord>> aggMap;
	
	/**
	 * @param description of the aggregated result
	 * @param aggFunction by which the measures are computed
	 * @param aggMap the Hashmap containing the measures by timeunit
	 */
	public Stats(String description, String aggFunction, HashMap<String, ArrayList<MeasurementRecord>> aggMap) {
		super();
		this.description = description;
		this.aggFunction = aggFunction;
		this.aggMap = aggMap;
	}
	
	

	public Stats(HashMap<String, ArrayList<MeasurementRecord>> aggMap) {
		super();
		this.aggMap = aggMap;
	}
	
	/**
	 * @param type a String that identify by which room the computation will be made
	 * @return a Hasmap<String,Double> with String a key of timeUnit and Double the computed average of the measurements
	 */
	public HashMap<String, Double> computeStats(String type){
		DescriptiveStatistics stats = new DescriptiveStatistics();
		HashMap<String, Double> newMap;
		
		Set<Map.Entry<String, ArrayList<MeasurementRecord>>> set = aggMap.entrySet();
		Iterator<Entry<String, ArrayList<MeasurementRecord>>> i = set.iterator();
		
		if(aggMap!= null) {
			newMap = new HashMap<String, Double>();
			while (i.hasNext()) {
				Entry<String,ArrayList<MeasurementRecord>> mapentry = i.next();
				ArrayList<MeasurementRecord> list = mapentry.getValue();
				
				for(MeasurementRecord record : list) {
					if(type.equals("Kitchen"))
						stats.addValue(record.getKitchenCons());			
					else if (type.equals("Laundry"))
						stats.addValue(record.getLaundryCons());
					else if (type.equals("AC")) 
						stats.addValue(record.getAcCons());
					else
						return null;
					
					if (this.aggFunction.equals("avg"))
						newMap.put(mapentry.getKey(), stats.getMean());
					else if (this.aggFunction.equals("sum"))
						newMap.put(mapentry.getKey(), stats.getSum());
				}
				stats.clear();
			}
		}else 
				return null;
		return newMap;
	}
	
	
}
