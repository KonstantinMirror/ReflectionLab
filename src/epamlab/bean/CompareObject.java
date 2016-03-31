package epamlab.bean;

import epamlab.util.anatation.Equal;
import epamlab.util.anatation.TypeCompare;

public class CompareObject {
	
	@Equal(getTypeCompare = TypeCompare.VALUE)
	private String object1;
	
	
	public String getObject1() {
		return object1;
	}

	public void setObject1(String object1) {
		this.object1 = object1;
	}

	public String getObject2() {
		return object2;
	}

	public void setObject2(String object2) {
		this.object2 = object2;
	}
	
	@Equal(getTypeCompare = TypeCompare.REFERENCE)
	private String object2;
	

}
