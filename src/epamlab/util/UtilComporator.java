package epamlab.util;

import java.lang.reflect.Field;
import epamlab.util.anatation.Equal;
import epamlab.util.anatation.TypeCompare;

public class UtilComporator {
	public static boolean compare(Object object1, Object object2) {
		if(object1.getClass()!=object2.getClass()){
			throw new IllegalArgumentException("Arguments is  equal class");
		}
		boolean isEquals = true;
		Class class_1 = object1.getClass();
		Field[] fields_1 = class_1.getDeclaredFields();
		for (Field field : fields_1) {
			Equal equalAnatetion = field.getAnnotation(Equal.class);
			if (equalAnatetion != null) {
				field.setAccessible(true);
				TypeCompare typeCompare = equalAnatetion.getTypeCompare();
				Object o1 = null;
				Object o2 = null;
				try {
					o1 = field.get(object1);
					System.out.println(o1.toString());
					o2 = field.get(object2);
					System.out.println(o2.toString());
				} catch (IllegalArgumentException | IllegalAccessException e) {
					IllegalArgumentException ex = new IllegalArgumentException("Problem with access varible");
					ex.initCause(e);
					throw ex;
				}
				if (typeCompare == TypeCompare.VALUE) {
					if (o1 != null) {
						if (!o1.equals(o2)) {
							isEquals = false;
							break;
						}
					}
				} else {
					if (o1 != o2) {
						isEquals = false;
						break;
					}

				}
			}
		}
		return isEquals;
	}

}
