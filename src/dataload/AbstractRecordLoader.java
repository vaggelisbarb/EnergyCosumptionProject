package dataload;

import java.util.ArrayList;

public abstract class AbstractRecordLoader <E> {
	
	public abstract int constructObjectFromRow(String [] tokens, ArrayList<E> objCollection);
	
}
