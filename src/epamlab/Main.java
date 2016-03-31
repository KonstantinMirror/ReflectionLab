package epamlab;

import epamlab.bean.CompareObject;
import epamlab.util.UtilComporator;

public class Main {

	public static void main(String[] args) {
		CompareObject obj1 = new CompareObject();
		obj1.setObject1("123");
		obj1.setObject2("5");
		CompareObject obj2 = new CompareObject();
		obj2.setObject1("123");
		obj2.setObject2("0");
		System.out.println(UtilComporator.compare(obj1, obj2));
	}

}
