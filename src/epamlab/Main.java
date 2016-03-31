package epamlab;

import epamlab.bean.CompareObject;
import epamlab.util.UtilComporator;

public class Main {

	public static void main(String[] args) {
		CompareObject obj1 = new CompareObject();
		obj1.setString_1("hello");
		obj1.setString_2("world");
		obj1.setFirstNumber(10);
		CompareObject obj2 = new CompareObject();
		
		obj2.setString_1("hello");
		obj2.setString_2("world");
		obj2.setFirstNumber(5);
		System.out.println(UtilComporator.compare(obj1, obj2));
	}

}
