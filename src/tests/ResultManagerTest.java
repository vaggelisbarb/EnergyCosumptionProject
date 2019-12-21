package tests;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.sound.midi.Receiver;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datamodel.IResult;
import datamodel.MeasurementRecord;
import datamodel.ResultFactory;
import datamodel.ResultManager;

public class ResultManagerTest {
	private ResultFactory resultFactory;
	private IResult resultManager;
	private HashMap<String, ArrayList<MeasurementRecord>> map;
	
	@Before
	public void setUp() throws Exception {
		resultFactory = new ResultFactory();
		//resultManager =resultFactory.constructResult("ResultManager");
		map = new HashMap<String, ArrayList<MeasurementRecord>>();
	}

	@Test
	public void testConvertStringToDate() {
		//LocalDateTime now = LocalDateTime.now();
		//LocalDateTime tesDate = resultManager.
		//assertEquals(now, resultManager.con);
	}

	@Test
	public void testIsSeason() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsWeekDay() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsMonth() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsTimePeriod() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdd() {
		/*MeasurementRecord myTestRecord1 = new MeasurementRecord("08/12/2019","17:25:00",0.000,1.000,16.000);
		MeasurementRecord myTestRecord2 = new MeasurementRecord("21/01/2019","18:25:00",3.000,5.000,6.000);
		int winterTest1 = resultManager.add("EVENING", myTestRecord1);
		int winterTest2 = resultManager.add("EVENING", myTestRecord2);
		
		assertEquals(1, winterTest1);
		assertEquals(2, winterTest2);
		//System.out.println("List size for Winter : " + "\t" + winterTest1 +"\t" + winterTest2 );
		/*String autumn = "AUTUMN";
		String summer = "SUMMER";
		String winter = "WINTER";
		String spring = "SPRING";
		
		int sizeAutumn = resultManager.add(autumn, myTestRecord);
		int sizeSpring = resultManager.add(spring, myTestRecord);
		int sizeWinter = resultManager.add(winter, myTestRecord);
		int sizeSummer = resultManager.add(summer, myTestRecord);
		
		assertEquals(0, sizeAutumn);
		assertEquals(0, sizeSpring);
		assertEquals(1, sizeWinter);
		assertEquals(0, sizeSummer);
		System.out.println("Test Autumn : " + sizeAutumn +
							"\nTest Spring : " + sizeSpring
							+"\nTest Winter : " + sizeWinter+
							"\nTest Summer : " + sizeSummer);
		
		String monthString = "8";
		String decString = "12";
		int decSize = resultManager.add(decString, myTestRecord);
		int augustsize = resultManager.add(monthString, myTestRecord);
		
		assertEquals(0,augustsize);
		System.out.println("August Test : " + augustsize+"\n");
		assertEquals(2, decSize);
		System.out.println("December Test : " + decSize);
		
		String weekDay = "SUNDAY";
		
		int weekTest = resultManager.add(weekDay, myTestRecord);
		assertEquals(3,weekTest);
		System.out.println("SUNDAY Test : " + weekTest);

		String periodTest = "EVENING";
		
		int periodSize = resultManager.add(periodTest, myTestRecord);
		assertEquals(4, periodSize);
		System.out.println("Evening Test : " + periodSize);
	*/
	}
	
	@Test
	public void testGetDetailedResults() {
		MeasurementRecord myTestRecord1 = new MeasurementRecord("08/12/2019","17:25:00",0.000,1.000,16.000);
		MeasurementRecord myTestRecord2 = new MeasurementRecord("21/01/2019","18:25:00",3.000,5.000,6.000);
		MeasurementRecord myTestRecord3 = new MeasurementRecord("02/08/2019","17:25:00",0.000,1.000,16.000);
		MeasurementRecord myTestRecord4 = new MeasurementRecord("15/12/2019","10:25:00",3.000,5.000,6.000);
		
		int Test1 = resultManager.add("SUNDAY", myTestRecord1);
		int Test2 = resultManager.add("TUESDAY", myTestRecord2);
		int Test3 = resultManager.add("THURSDAY", myTestRecord3);
		int Test4 = resultManager.add("SUNDAY", myTestRecord4);
		
		map = resultManager.getDetailedResults();
		int mapSize = map.size();
		assertEquals(1,mapSize);
		assertEquals(1,mapSize);
		assertEquals(1,mapSize);
		assertEquals(1,mapSize);
		System.out.print("Map Size : " + mapSize + "\n");
		for(Map.Entry<String, ArrayList<MeasurementRecord>> rec : map.entrySet())
			System.out.print("Key : " + rec.getKey() + "\tValue : " + rec.getValue().size());
	}

}
