package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class GetInstance_Test {
  public static void main(String args[]) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{

		Class<?> c = Class.forName("server_folder.Pi_Imp");
		Constructor<?> cons = c.getConstructor();
		Object object = cons.newInstance();
		Method method = c.getDeclaredMethod("execute", int.class);
		Object value = method.invoke(object,5);
		BigDecimal result = (BigDecimal)value;
		System.out.println(result);

  }
}
