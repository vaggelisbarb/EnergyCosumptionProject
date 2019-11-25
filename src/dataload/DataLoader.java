package dataload;

import java.util.ArrayList;

public class DataLoader implements ILoader{
	private String filename;
	
	private KitchenLoader kitchenloader;
	private LaundryLoader laundryloader;
	private AcLoader acloader;
	
	/**
	 * @param filename
	 * @param kitchenloader
	 * @param laundryloader
	 * @param acloader
	 */
	public DataLoader(String filename, KitchenLoader kitchenloader, LaundryLoader laundryloader, AcLoader acloader) {
		super();
		this.filename = filename;
		this.kitchenloader = kitchenloader;
		this.laundryloader = laundryloader;
		this.acloader = acloader;
	}
	

	/**
	 * @param filename
	 */
	public DataLoader(String filename) {
		super();
		this.filename = filename;
	}

	public DataLoader() {
		filename = "/home/vaggelisbarb/Eclipse_Projects/2019_2020_<2766>_<2784>_<2821>/Resources/TestInput/household_preview.txt";
		kitchenloader = new KitchenLoader();
		laundryloader = new LaundryLoader();
		acloader = new AcLoader();
		
	}


	@Override
	public int load(String fileName, String delimeter, boolean hasHeaderLine, int numFields, ArrayList objCollection) {
		// TODO Auto-generated method stub
		return 0;
	}
}
