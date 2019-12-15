/**
 * 
 */
package reporting;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


import datamodel.IResult;
import datamodel.ResultFactory;

/**
 * @author vaggelisbarb
 *
 */
public class ReportOnHTML implements IResultReporter{

		private IResult resultmanager;
		private ResultFactory resultfactory;
		private String description;
		private String aggFunction;
	
	
	/**
		 * 
		 */
		public ReportOnHTML() {
			
		}



	/**
		 * @param resultmanager
		 * @param description
		 * @param aggFunction
		 */
		public ReportOnHTML(IResult resultmanager, String description, String aggFunction) {
			this.resultmanager = resultmanager;
			this.description = description;
			this.aggFunction = aggFunction;
		}



	/**
 	 * Creates and saves the data in HTML format
 	 * 
 	 */
	public void rasterToHTML(String fileName, String description, String[][] raster1,String[][] raster2,String[][] raster3, int numRows, int numCols,String aggFunction) {
		String header = new String("");
		header.concat("<!doctype html>");
		header.concat("\n");
		header.concat("<html>");
		header.concat("\n");
		header.concat("<head>");
		header.concat("\n");
		header.concat("<meta http-equiv=\"Content-Type\" content\"text/html; charset=windows-1253\">");
		header.concat("\n");
		header.concat(description);
		header.concat("\n");
		header.concat("</head>");
		header.concat("\n");
		header.concat("<body>");
		header.concat("\n");
		// Opening file to write, checking exception
		try {
			PrintWriter outputStream = new PrintWriter(new FileOutputStream(fileName)); // APPEND would be .... (new FileOutputStream(outputFileName, true));
			outputStream.println(header);

			outputStream.println("<h1>" + description +"</h1>");
			// TODO: <p> avg consumption(watt-hours) over a)Kitchen b)Laundry c)A/C </p>
			outputStream.println("<p>" + aggFunction + " consumption (watt-hours) over (a) Kitchen, (b) Laundry, (c) A/C " + "</p>");
			
			outputStream.println("<h2>"+ "Kitchen" + "</h2>");
			outputStream.println("<ul>");
			
			for(int i =0; i < numRows; i++){
				outputStream.println("\t");
				outputStream.println("<li>");
				for(int j =0; j < numCols; j++){
					outputStream.print("\t"+raster1[i][j]);
				}
				outputStream.println("\n");
			}
			outputStream.println("</ul>");
			
			
			outputStream.println("<h2>"+ "Laundry" + "</h2>");
			outputStream.println("<ul>");
			
			for(int i =0; i < numRows; i++){
				outputStream.println("\t");
				outputStream.println("<li>");
				for(int j =0; j < numCols; j++){
					outputStream.print("\t" + raster2[i][j]);
				}
				outputStream.println("\n");
			}
			outputStream.println("</ul>");
			
			
			outputStream.println("<h2>"+ "A/C" + "</h2>");
			outputStream.println("<ul>");
			
			for(int i =0; i < numRows; i++){
				outputStream.println("\t");
				outputStream.println("<li>");
				for(int j =0; j < numCols; j++){
					outputStream.print("\t" + raster3[i][j]);
				}
				outputStream.println("\n");
			}
			outputStream.println("</ul>");
			
			
			outputStream.println("</body>\n</html>");
			outputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Problem opening files.");
			System.exit(0);
		}

	}// end visualize
	
	
	
	@Override
	public int reportResultInFile(IResult result, String filename) {
		DecimalFormat df = new DecimalFormat("###.#################");
		
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator('.');
		df.setDecimalFormatSymbols(dfs);
		
		int numCols = 2;
		
		HashMap<String, Double> kitchenMap = result.getAggregateMeterKitchen();
		int numRowsK = kitchenMap.size();
				
		String[][] rasterKitchen = new String[numRowsK][numCols];
		
		int i=0;
		if(!kitchenMap.isEmpty()) {
			Iterator<Map.Entry<String, Double>> iterator = kitchenMap.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<String, Double> obj = (Entry<String, Double>) iterator.next();
				rasterKitchen[i][0] = obj.getKey();
				rasterKitchen[i][1] = df.format(obj.getValue());
				
				i++;
			}
		}
		
		
		HashMap<String, Double> laundryMap = result.getAggregateMeterKitchen();
		int numRowsL = kitchenMap.size();
				
		String[][] rasterLaundry = new String[numRowsL][numCols];
		
		int j=0;
		if(!laundryMap.isEmpty()) {
			Iterator<Map.Entry<String, Double>> iterator = laundryMap.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<String, Double> obj = (Entry<String, Double>) iterator.next();
				rasterLaundry[j][0] = obj.getKey();
				rasterLaundry[j][1] = df.format(obj.getValue());
		
				j++;
			}
		}
		
		
		HashMap<String, Double> acMap = result.getAggregateMeterKitchen();
		int numRowsA = acMap.size();
				
		String[][] rasterAc= new String[numRowsA][numCols];
		
		int k=0;
		if(!acMap.isEmpty()) {
			Iterator<Map.Entry<String, Double>> iterator = acMap.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<String, Double> obj = (Entry<String, Double>) iterator.next();
				rasterAc[k][0] = obj.getKey();
				rasterAc[k][1] = df.format(obj.getValue());
				
				k++;
			}
		}
		
		
		
		rasterToHTML(filename, result.getDescription(), rasterKitchen, rasterLaundry,rasterAc, numRowsK, numCols, result.getAggregateFunction());
		
		
		return 0;
	}

}
