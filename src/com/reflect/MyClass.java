package com.reflect;

public class MyClass extends GenericAbstract<String, Integer> {

	public void printG() {
		System.out.println(super.fetchType());
	}

	public static void main(String[] args) {
		MyClass myClass = new MyClass();
		myClass.printG();
	}
}
