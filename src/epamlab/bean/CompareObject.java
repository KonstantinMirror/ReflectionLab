package epamlab.bean;

import epamlab.util.anatation.Equal;
import epamlab.util.anatation.TypeCompare;

public class CompareObject {
	
	@Equal(getTypeCompare = TypeCompare.VALUE)
	private String string_1;
	
	@Equal(getTypeCompare = TypeCompare.REFERENCE)
	private String string_2;
	
	@Equal(getTypeCompare = TypeCompare.VALUE)
	private Integer firstNumber;
	
	@Equal(getTypeCompare = TypeCompare.REFERENCE)
	private int intVar;
	

	public int getIntVar() {
		return intVar;
	}

	public void setIntVar(int intVar) {
		this.intVar = intVar;
	}

	public String getString_1() {
		return string_1;
	}

	public void setString_1(String string_1) {
		this.string_1 = string_1;
	}

	public String getString_2() {
		return string_2;
	}

	public void setString_2(String string_2) {
		this.string_2 = string_2;
	}

	public Integer getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(Integer firstNumber) {
		this.firstNumber = firstNumber;
	}
	
	
	
	
}
