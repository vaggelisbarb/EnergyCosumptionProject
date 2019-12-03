/**
 * 
 */
package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datamodel.ConsumptionResult;
import datamodel.MeasurementRecord;

/**
 * @author vaggelisbarb
 *
 */
public class ConsumptionResultTest {

	private ConsumptionResult result;
	private MeasurementRecord record1;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		record1 = new MeasurementRecord("12/10/1996","10:00:45",124.5,12.3,30.5);
		result = new ConsumptionResult("12/10/1996");
	}

	/**
	 * Test method for {@link datamodel.ConsumptionResult#add(java.lang.String, datamodel.MeasurementRecord)}.
	 */
	@Test
	public void testAdd() {
		int rows = result.add("12/10/1996",record1);
		assertEquals(rows,1);
	}

	/**
	 * Test method for {@link datamodel.ConsumptionResult#getDescription()}.
	 */
	@Test
	public void testGetDescription() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link datamodel.ConsumptionResult#getDetailedResults()}.
	 */
	@Test
	public void testGetDetailedResults() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link datamodel.ConsumptionResult#getAggregateMeterKitchen()}.
	 */
	@Test
	public void testGetAggregateMeterKitchen() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link datamodel.ConsumptionResult#getAggregateMeterLaundry()}.
	 */
	@Test
	public void testGetAggregateMeterLaundry() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link datamodel.ConsumptionResult#getAggregateMeterAC()}.
	 */
	@Test
	public void testGetAggregateMeterAC() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link datamodel.ConsumptionResult#getAggregateFunction()}.
	 */
	@Test
	public void testGetAggregateFunction() {
		fail("Not yet implemented");
	}

}
