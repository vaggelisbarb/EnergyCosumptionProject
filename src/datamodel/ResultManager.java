/**
 * 
 */
package datamodel;

import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.swing.text.DateFormatter;



/**
 * @author vaggelisbarb
 *
 */
public class ResultManager implements IResult{
	private ArrayList<MeasurementRecord> RecordsList;
	
  	
	public ResultManager() {
		RecordsList = new ArrayList<MeasurementRecord>();
	}
	
	// Convert date from input String to Date object	
	public LocalDateTime convertStringToDate(String timeUnit) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy,HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(timeUnit, formatter);
		return dateTime;
	}

	public String checkTimeUnit(String timeUnit) {
		if(timeUnit.equals("WINTER") || timeUnit.equals("SUMMER") || timeUnit.equals("AUTUMN") || timeUnit.equals("SPRING"))
			return "Season";
		else if(timeUnit.equals("MONDAY") || timeUnit.equals("TUESDAY") || timeUnit.equals("WEDNESDAY") || timeUnit.equals("THURSDAY") || timeUnit.equals("FRIDAY") || timeUnit.equals("SATURDAY") || timeUnit.equals("SUNDAY"))
			return "Day Of Week";
		else if(timeUnit.equals("JAN") || timeUnit.equals("FEB") || timeUnit.equals("MAR") || timeUnit.equals("APR") || timeUnit.equals("MAY") || timeUnit.equals("JUN") || timeUnit.equals("JUL") || timeUnit.equals("AUG") || timeUnit.equals("SEP") || timeUnit.equals("OCT") || timeUnit.equals("NOV") || timeUnit.equals("DEC"))
			return "Month";
		else if(timeUnit.equals("NIGHT")||timeUnit.equals("EARLY_MORNING")||timeUnit.equals("AFTERNOON")||timeUnit.equals("MORNING")||timeUnit.equals("EVENING"))
			return "DayPeriod";
		return null;
	}
	
	// Checks if timUnit is season
	public int isSeason(String timeUnit,LocalDateTime fullDate) {
		int monthInt = fullDate.getMonthValue();
	  	
		switch (timeUnit) {
		case "WINTER":
			if(monthInt==12 |monthInt==1 || monthInt==2)
				return 1;
			return 0;
		case "SPRING" :
			if(monthInt==3 |monthInt==4 || monthInt==5)
				return 1;
			return 0;
		case "SUMMER" :
			if(monthInt==6 |monthInt==7 || monthInt==8)
				return 1;
			return 0;
		case "AUTUMN" :
			if(monthInt==9 |monthInt==10 || monthInt==11)
				return 1;
			return 0;
		}
		return 0;
	}
	
	// Ckeck if timeUnit is day of week
	public int isWeekDay(String timeUnit,LocalDateTime fullDate) {
		int timeUnitToDayOfweekInt = DayOfWeek.valueOf(timeUnit).getValue();
		int dayWeek = fullDate.get(ChronoField.DAY_OF_WEEK);
		
		if(timeUnitToDayOfweekInt == dayWeek)
			return 1;
		return 0;
	}
	
	// Converts the month of fullDate to String (Mon,Tue....) and compares it with timeUnit
	public int isMonth (String timeUnit,Month month) {
		String newMonth = month.getDisplayName(TextStyle.SHORT, Locale.US);
		
		if (timeUnit.equals(newMonth))
			return 1;
		return 0;
	}
	
	
	// Hours of fullDate is compared to hours-range
	public int isTimePeriod(String timeUnit,LocalDateTime fullDate) {
		int hour = fullDate.get(ChronoField.HOUR_OF_DAY);
		switch (timeUnit) {
		case "NIGHT" :
			if(hour>=21 && hour<5)
				return 1;
			return 0;
		case "EARLY_MORNING" :
			if(hour>=5 && hour<9)
				return 1;
			return 0;
		case "MORNING" :
			if(hour>=9 && hour<13)
				return 1;
			return 0;
		case "AFTERNOON" :
			if(hour>=13 && hour<17)
				return 1;
			return 0;	
		case "EVENING" :
			if(hour>=17 && hour<21)
				return 1;
			return 0;
		}
		return 0;
	}
	
	@Override
	public int add(String timeUnit, MeasurementRecord record) {
		LocalDateTime fullDate = convertStringToDate(record.getDateTime());
		if(fullDate!=null) {
			String timeUnitSringCheck = checkTimeUnit(timeUnit);
			
				
				switch (timeUnitSringCheck) {
				case "Season":
					int checkIfSeason = isSeason(timeUnit, fullDate);
					if(checkIfSeason == 1) {
						RecordsList.add(record);
						return RecordsList.size();
					}
					
				case "Month" :
					Month month = fullDate.getMonth();
					int checkIfMonth = isMonth(timeUnit, month);
					if (checkIfMonth == 1) {
						RecordsList.add(record);
						return RecordsList.size();
					}
			
				case "Day of Week" :
					int checkIfWeekDay = isWeekDay(timeUnit, fullDate); 
					if(checkIfWeekDay == 1) {
						RecordsList.add(record);
						return RecordsList.size();
					}
				
				case "DayPeriod" :
					int checkIfTimePeriod = isTimePeriod(timeUnit, fullDate);
					if(checkIfTimePeriod==1) {
						RecordsList.add(record);	
						return RecordsList.size();
					}
				}
		}
		return 0;
	}


	@Override
	public HashMap<String, ArrayList<MeasurementRecord>> getDetailedResults() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public HashMap<String, Double> getAggregateMeterKitchen() {
		// TODO Auto-generated method stub
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
