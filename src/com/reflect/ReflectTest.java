package com.reflect;

import java.lang.reflect.Field;

public class ReflectTest {
	private String fname;
	public String lname;

	public ReflectTest(String fname, String lname) {
		super();
		this.fname = fname;
		this.lname = lname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public static void main(String[] args) {
		ReflectTest reflect = new ReflectTest("JAVA", "ASPECTJ");
		try {
			fun(reflect);
			fun2(reflect);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void fun2(ReflectTest reflect) throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = reflect.getClass().getFields();
		for (Field f : fields) {
			System.out.println(f.getName() + f.get(reflect));
		}

	}

	private static void fun(Object reflect) throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = reflect.getClass().getDeclaredFields();
		for (Field f : fields) {
			System.out.println(f.getName() + "=" + f.get(reflect));
			if (f.getType().equals(java.lang.String.class)) {
				f.setAccessible(true);
				String val = (String) f.get(reflect);
				f.set(reflect, val.replaceAll("A", "B"));
			}
		}

		for (Field f : fields) {
			System.out.println(f.getName() + "=" + f.get(reflect));
		}
	}

}
