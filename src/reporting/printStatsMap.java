package reporting;

import java.io.PrintWriter;
import java.util.HashMap;


/**
 * Interface just to print the Stats on different types of files
 *
 */
public interface printStatsMap {
	
	public void printMap(HashMap<String, Double> map,String type,PrintWriter outputStream);
	
}
