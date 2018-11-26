package priv.zc.utils.apache.beanutils;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

public class BeanUtilsTest {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Class clazz = Class.forName("apache.beanutils.Student");
		System.out.println(clazz.toString());
		Object instance = clazz.newInstance();
		System.out.println(instance);
		BeanUtils.setProperty(instance, "age", 23);
		System.out.println(instance);
		Student st = new Student(23, "王");
		System.out.println(BeanUtils.getProperty(st, "name"));
	}
}
