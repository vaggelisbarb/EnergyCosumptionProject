/**
 * 
 */
package datamodel;


public class ResultFactory {
	public IResult constructResult(String des,String aggFuntion) {
		if(aggFuntion.equals("avg"))
			return new ResultManager(des,"avg");
		else if (aggFuntion.equals("sum"))
			return new ResultManager(des,"sum");
		
		System.out.println("If the code get up here, you passed a wrong argument to ResultFactory");
		return null;
	}
}
