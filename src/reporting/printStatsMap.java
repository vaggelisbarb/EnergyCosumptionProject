package reporting;

import java.io.PrintWriter;
import java.util.HashMap;


/**
 * Interface just to print the Stats on different types of files
 *
 */
public interface printStatsMap {
	
	/**
	 * @param map a HashMap that holds the timeUnit as keys and the aggregated result as value
	 * @param type a String which can be Kitchen or Laundry or A/C
	 * @param outputStream an PrintWriter object for writing through 
	 */
	public void printMap(HashMap<String, Double> map,String type,PrintWriter outputStream);
	
}
