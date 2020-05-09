package com.testJDK16.j2006;

public class TestPluggableAnnotionProcessing {
	
	@NameScanner
	String name;
	
	@NameScanner
	int age;
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("finish");
	}

}
