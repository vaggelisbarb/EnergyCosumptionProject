/**
 * 
 */
package datamodel;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.HashMap;




/**
 * @author vaggelisbarb
 *
 */
public class ResultManager implements IResult{
	private HashMap<String, ArrayList<MeasurementRecord>> recordsHashMap;
	private String description;
	private String aggFunction;
	private String timeUnit;
  	
	public ResultManager() {
		recordsHashMap = new HashMap<String, ArrayList<MeasurementRecord>>(); 
	}

	// Convert date from input String to Date object	
	public LocalDateTime convertStringToDate(String timeUnit) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy,HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(timeUnit, formatter);
		return dateTime;
	}
	public String[] isSeason(String timeUnit) {
		
		switch (timeUnit) {
		case "WINTER":
			String[] winterArr = {"12","1","2"};
			return winterArr;
		case "SUMMER" :
			String[] summerArr = {"6","7","8"};
			return summerArr;
		case "SPRING":
			String[] springArr = {"3","4","5"};
			return springArr;
		case "AUTUMN":
			String[] autumnArr = {"9","10","11"};
			return autumnArr;
		case "SEASON":
			String[] seasonArr = {"1","2","3","4","5","6","7","8","9","10","11","12"};
			return seasonArr;
		}
		return null;
		
	}
	
	public String[] isWeek(String timeUnit) {
		switch (timeUnit) {
		case "MONDAY":
			String[] monArr= {"1"}; 
			return monArr;
		case "TUESDAY":
			String[] tueArr= {"2"}; 
			return tueArr;
		case "WEDNESDAY":
			String[] wedArr= {"3"}; 
			return wedArr;
		case "THURSDAY":
			String[] thuArr= {"4"}; 
			return thuArr;
		case "FRIDAY":
			String[] friArr= {"5"}; 
			return friArr;
		case "SATURDAY":
			String[] satArr= {"6"}; 
			return satArr;	
		case "SUNDAY":
			String[] sunArr= {"7"}; 
			return sunArr;
		case "WEEK" :
			String[] weekArr= {"1","2","3","4","5","6","7"};
			return weekArr;
		}
		return null;
	}
	
	public String[] isMonth(String timeUnit) {
		switch (timeUnit) {
		case "JAN":
			String[] janArr= {"1"}; 
			return janArr;
		case "FEB":
			String[] febArr= {"2"}; 
			return febArr;
		case "MAR":
			String[] marArr= {"3"}; 
			return marArr;
		case "APR":
			String[] aprArr= {"4"}; 
			return aprArr;
		case "MAY":
			String[] mayArr= {"5"}; 
			return mayArr;
		case "JUN":
			String[] junArr= {"6"}; 
			return junArr;	
		case "JUL":
			String[] julArr= {"7"}; 
			return julArr;
		case "AUG" :
			String[] augArr= {"8"};
			return augArr;
		case "SEP":
			String[] sepArr= {"9"}; 
			return sepArr;
		case "OCT":
			String[] octArr= {"10"}; 
			return octArr;
		case "NOV":
			String[] novArr= {"11"}; 
			return novArr;
		case "DEC":
			String[] decArr= {"12"}; 
			return decArr;		
		}
		return null;
	}
	
	public String[] isPeriodOfDay(String timeUnit) {
		switch (timeUnit) {
		case "NIGHT" :
			String[] nightarr = {"21","22","23","00","01","02","03","04"};
				return nightarr;
		case "EARLY_MORNING" :
			String[] earlytarr = {"05","06","07","08"};
			return earlytarr;
		case "MORNING" :
			String[] morarr = {"09","10","11","12"};
			return morarr;
		case "AFTERNOON" :
			String[] aftarr = {"13","14","15","16"};
			return aftarr;
		case "EVENING" :
			String[] evearr = {"17","18","19","20"};
			return evearr;
		}
		return null;
	}

	public int mappingRecords(HashMap<String, ArrayList<MeasurementRecord>> map,MeasurementRecord record,String unit) {
		if(!map.containsKey(unit)) {
			ArrayList<MeasurementRecord> list = new ArrayList<MeasurementRecord>();
			list.add(record);
			map.put(unit, list);
			System.out.println("List with key "+unit +" is 1st time found.Size of new List = " + list.size() );
			return list.size();
		}else {
			ArrayList<MeasurementRecord> listFromMap = map.get(unit);
			listFromMap.add(record);
			System.out.println("List with key "+unit +" is found with size = " + listFromMap.size() );
			return listFromMap.size();
		}
	}
	
	// Returns the size of Arraylist that record has been added
	@Override
	public int add(String timeUnit, MeasurementRecord record) {
		LocalDateTime fullDate = convertStringToDate(record.getDateTime());
		int collecionSize=0;
		
		if(fullDate!=null) {
			
			if(isSeason(timeUnit)!=null) {
				String[] array = isSeason(timeUnit);
				for (int i = 0; i < array.length; i++) {
					int arrayToInt = Integer.parseInt(array[i]);
					if(fullDate.getMonthValue() == arrayToInt)
							collecionSize = mappingRecords(recordsHashMap, record, array[i]);
				}
				return collecionSize;
			}else if (isWeek(timeUnit)!=null) {
				String[] array = isWeek(timeUnit);
				int dayWeek = fullDate.get(ChronoField.DAY_OF_WEEK);
				for (int i = 0; i < array.length; i++) {
					int arrayToInt = Integer.parseInt(array[i]);
					if(dayWeek== arrayToInt)
						collecionSize = mappingRecords(recordsHashMap, record, array[i]);
				}
				return collecionSize;
			}else if (isMonth(timeUnit)!=null) {
				String[] array = isMonth(timeUnit);
				int monthInt = fullDate.get(ChronoField.MONTH_OF_YEAR);
				for (int i = 0; i < array.length; i++) {
					int arrayToInt = Integer.parseInt(array[i]);
					if(monthInt== arrayToInt)
						collecionSize = mappingRecords(recordsHashMap, record, array[i]);
				}
				return collecionSize;
			}else if (isPeriodOfDay(timeUnit)!=null) {
				String[] array = isPeriodOfDay(timeUnit);;
				int hour = fullDate.get(ChronoField.HOUR_OF_DAY);
					int arrayToIntStart = Integer.parseInt(array[0]);
					int arrayToIntStop = Integer.parseInt(array[array.length-1]);
					if(hour>=arrayToIntStart || hour<=arrayToIntStop) {
						collecionSize = mappingRecords(recordsHashMap, record, array[0]);
					}
			}
			return collecionSize;
		}
		return 0;
	}

	// From the Arraylist that have been created with add() to each measurement , i want to make it a Hashmap with keys : timeunit
	@Override
	public HashMap<String, ArrayList<MeasurementRecord>> getDetailedResults() {
		return this.recordsHashMap;
	}


	@Override
	public HashMap<String, Double> getAggregateMeterKitchen() {
		
		return null;
	}

	@Override
	public HashMap<String, Double> getAggregateMeterLaundry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Double> getAggregateMeterAC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getAggregateFunction() {
		// TODO Auto-generated method stub
		return null;
	}


}
