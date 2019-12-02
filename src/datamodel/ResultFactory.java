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
		if(concreteClassName.equals("ResultManager"))
			return new ResultManager();
		System.out.println("If the code get up here, you passed a wrong argument to ResultFactory");
		return null;
	}
}
