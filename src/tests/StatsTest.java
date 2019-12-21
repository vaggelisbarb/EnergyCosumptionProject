package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import datamodel.MeasurementRecord;
import datamodel.Stats;

public class StatsTest {
	private HashMap<String,ArrayList<MeasurementRecord>> map;
	private ArrayList<MeasurementRecord> list;
	private Stats stats;

	@Before
	public void setUp() throws Exception {
		list = new ArrayList<MeasurementRecord>();
		map = new HashMap<String, ArrayList<MeasurementRecord>>();
		stats = new Stats(map);
	}

	@Test
	public void testComputeAverage() {
		MeasurementRecord myTestRecord1 = new MeasurementRecord("08/12/2019","17:25:00",2.500,1.400,16.000);
		MeasurementRecord myTestRecord2 = new MeasurementRecord("08/12/2019","18:25:00",3.000,5.200,4.000);
		MeasurementRecord myTestRecord3 = new MeasurementRecord("08/12/2019","17:25:00",1.200,1.700,10.000);
		MeasurementRecord myTestRecord4 = new MeasurementRecord("08/12/2019","10:25:00",3.000,5.000,6.000);
	
		list.add(myTestRecord1);	list.add(myTestRecord2);	list.add(myTestRecord3);	list.add(myTestRecord4);
		
		map.put("SUNDAY", list);
		
		HashMap<String, Double> newMap = stats.computeStats("avg");
		Set<Map.Entry<String, Double>> set = newMap.entrySet();
		Iterator<Entry<String, Double>> i = set.iterator();
		
		while (i.hasNext()) {
			Entry<String, Double> entry = i.next();
			System.out.println("String : " + entry.getKey() + "\tValue is : " + entry.getValue());
		}
	}

}
