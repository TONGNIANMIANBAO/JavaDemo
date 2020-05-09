package com.testJDK17.j2011;

import java.util.ArrayList;
import java.util.List;

public class TestTypeInference {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = gen();
		//list.addAll(new ArrayList<String>());
		System.out.print(list);
		test(gen());
	}

	public static void test(Object... o) {
		System.out.print(o);
	}

	static <T extends List> T gen() {
		List<T> list = new ArrayList<>();
		return (T) list;
	}

}
