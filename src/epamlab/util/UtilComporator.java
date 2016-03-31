package epamlab.util;

import java.lang.reflect.Field;

import epamlab.bean.CompareObject;
import epamlab.util.anatation.Equal;
import epamlab.util.anatation.TypeCompare;

public class UtilComporator {

	private static final TypeCompare DEFAULT_COMPARE_TYPE = TypeCompare.VALUE;

	public static boolean compare(Object object1, Object object2) {
		if (object1.getClass() != object2.getClass()) {
			throw new IllegalArgumentException("Arguments is not equal class");
		}
		Class class_1 = object1.getClass();
		Field[] fields_1 = class_1.getDeclaredFields();
		for (Field field : fields_1) {
			field.setAccessible(true);
			TypeCompare typeCompare;
			if (!field.getType().isPrimitive()) {
				if (field.isAnnotationPresent(Equal.class)) {
					typeCompare = field.getAnnotation(Equal.class).getTypeCompare();
				} else {
					typeCompare = DEFAULT_COMPARE_TYPE;
				}
			} else {
				typeCompare = TypeCompare.VALUE;
			}

			Object o1 = null;
			Object o2 = null;
			try {
				o1 = field.get(object1);
				o2 = field.get(object2);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
				IllegalArgumentException ex = new IllegalArgumentException("Problem with access varible");
				ex.initCause(e);
				throw ex;
			}
			if (typeCompare == TypeCompare.REFERENCE) {
				if (!compareWithRefernce(o1, o2)) {
					return false;
				}
			} else {
				if (!compareWithValue(o1, o2)) {
					return false;
				}
			}
		}

		return true;
	}

	private static boolean compareWithRefernce(Object object1, Object object2) {
		boolean result = false;
		if (object1 == object2) {
			result = true;
		}
		return result;
	}

	private static boolean compareWithValue(Object object1, Object object2) {
		if (object1 == null & object2 == null) {
			return true;
		} else if (object1 == null) {
			return false;
		} else {
			return object1.equals(object2);
		}
	}

}
