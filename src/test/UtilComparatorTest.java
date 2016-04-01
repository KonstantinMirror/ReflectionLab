package test;

import static org.junit.Assert.*;

import org.junit.Test;

import epamlab.util.UtilComporator;
import epamlab.util.anatation.Equal;
import epamlab.util.anatation.TypeCompare;

public class UtilComparatorTest {

	@Test
	public void simpleTest() {
		assertTrue("compare not annotation object ", UtilComporator.compare(new String("Hello"), new String("Hello")));
		assertFalse("compare not annotation object ", UtilComporator.compare(new String("Hello"), new String("World")));
		CompareObjectValue compareObjectValue = new CompareObjectValue();
		assertTrue("Object with null fields",UtilComporator.compare(compareObjectValue, compareObjectValue));
		CompareObjectReference compareObjectReference  = new CompareObjectReference();
		assertTrue("Object with null fields",UtilComporator.compare(compareObjectReference, compareObjectReference));
		
	}

	@Test
	public void test() {
		CompareObjectValue compareObjectValue_1 = new CompareObjectValue("Hello", 10, 20);
		assertTrue("Test with  some  object", UtilComporator.compare(compareObjectValue_1, compareObjectValue_1));

		CompareObjectValue compareObjectValue_2 = new CompareObjectValue("World", 30, 40);
		assertFalse("Test with  different  object and different value",
				UtilComporator.compare(compareObjectValue_1, compareObjectValue_2));

		CompareObjectReference compareObjectReference_1 = new CompareObjectReference("Hello", 10, 20);
		CompareObjectReference compareObjectReference_2 = new CompareObjectReference("Hello", 500, 1000);
		CompareObjectReference compareObjectReference_3 = new CompareObjectReference("Hello", 500, 1000);
		assertTrue("Test with  some  object",
				UtilComporator.compare(compareObjectReference_1, compareObjectReference_1));
		assertTrue("Test with  some   object and big value",
				UtilComporator.compare(compareObjectReference_2, compareObjectReference_2));
		assertFalse("Test with  different object and big value",
				UtilComporator.compare(compareObjectReference_2, compareObjectReference_3));
	}
	
	

	class CompareObjectValue {

		@Equal(getTypeCompare = TypeCompare.VALUE)
		private String string_1;

		@Equal(getTypeCompare = TypeCompare.VALUE)
		private Integer firstNumber;

		@Equal(getTypeCompare = TypeCompare.VALUE)
		private int intVar;

		public CompareObjectValue(String string_1, Integer firstNumber, int intVar) {
			super();
			this.string_1 = string_1;
			this.firstNumber = firstNumber;
			this.intVar = intVar;
		}
		
		public CompareObjectValue() {
			
		}
		

	}

	class CompareObjectReference {

		@Equal(getTypeCompare = TypeCompare.REFERENCE)
		private String string_1;

		@Equal(getTypeCompare = TypeCompare.REFERENCE)
		private Integer firstNumber;

		@Equal(getTypeCompare = TypeCompare.REFERENCE)
		private int intVar;

		public CompareObjectReference(String string_1, Integer firstNumber, int intVar) {
			super();
			this.string_1 = string_1;
			this.firstNumber = firstNumber;
			this.intVar = intVar;
		}
		
		public CompareObjectReference() {
			
		}

	}

}
