/**
 * 
 */
package datamodel;

/**
 * @author vaggelisbarb
 *
 */
public class ResultFactory {
	public IResult constructResult(String concreteClassName) {
		if(concreteClassName.equals("Kitchen"))
			return new Kitchen();
		else if(concreteClassName.equals("Laundry"))
			return new Laundry();
		else if(concreteClassName.equals("AC"))
			return new AC();
		System.out.println("If the code get up here, you passed a wrong argument to ResultFactory");
		return null;
	}
}
