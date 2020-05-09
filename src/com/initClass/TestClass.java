package com.initClass;

public class TestClass {

	int i = Integer.parseInt("x");

	public static void main(String[] args) {
		try {
			TestClass clazz = new TestClass();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("catch");
		}
		System.out.println("HELLO");
	}
}
