/**
 * 
 */
package reporting;

import reporting.IResultReporter;
import reporting.ReportOnTxt;
import reporting.ReportOnHTML;

/**
 * @author vaggelisbarb
 *
 */
public class TypeReportFactory {
	
	public IResultReporter createReporter(String type){
		if (type.equals("ReportOnHTML"))
			return new ReportOnHTML();
		else if(type.equals("ReportOnTxt"))
			return new ReportOnTxt();
		else if(type.equals("ReportOnMd"))
			return new ReportOnMD();
		System.out.println("If the code got up to here, you passed a wrong argument to the ReporterFactory Factory");
		return null;
	}	
}
