/**
 * 
 */
package reporting;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import datamodel.IResult;

/**
 * @author vaggelisbarb
 *
 */
public class ReportOnTxt implements IResultReporter,printStatsMap{
	private String description;
	private String aggFunction;
	private String pathfile;
	
	
	
	@Override
	public void printMap(HashMap<String, Double> map,String type,PrintWriter outputStream) {
		outputStream.println(type + "\n--------------\n"); 
		if(!map.isEmpty()) {
			Iterator<Map.Entry<String, Double>> iterator = map.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<String, Double> obj = (Entry<String, Double>) iterator.next();
				outputStream.println( "* " + obj.getKey() + "\t" + obj.getValue());
			}
		}else
			System.err.println("Error!! Map with stats is empty");
	}
	
	
	@Override
	public int reportResultInFile(IResult result, String filename) {
		PrintWriter outputStream = null;
		
		try {
			outputStream = new PrintWriter(new FileOutputStream(filename));
		} catch (FileNotFoundException e) {
			System.err.println("Problem opening " + filename + " report");
			return -1;
		}
		
		outputStream.println(result.getDescription()+"\n=======================================");
		outputStream.println(result.getAggregateFunction() + " consumption (watt-hours) over (a) Kitchen, (b) Laundry, (c) A/C\n");
		
		printMap(result.getAggregateMeterKitchen(), "Kitchen", outputStream);
		printMap(result.getAggregateMeterLaundry(), "Laundry", outputStream);
		printMap(result.getAggregateMeterAC(), "A/C", outputStream);

		outputStream.close();

		this.description = result.getDescription();
		this.aggFunction = result.getAggregateFunction();
		this.pathfile = filename;
		
		return 0;
	}
	
}
