package epamlab.bean;

import epamlab.util.anatation.Equal;
import epamlab.util.anatation.TypeCompare;

public class CompareObject {
	
	@Equal(getTypeCompare = TypeCompare.VALUE)
	private String string_1;
	
	@Equal(getTypeCompare = TypeCompare.REFERENCE)
	private String string_2;
	
	
	public String getObject1() {
		return string_1;
	}

	public void setObject1(String object1) {
		this.string_1 = object1;
	}

	public String getObject2() {
		return string_2;
	}

	public void setObject2(String object2) {
		this.string_2 = object2;
	}
}
