package com.testJDK15.j2004;

public class TestGeneric {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box<Integer> i = new Box<Integer>(12);
		Box<Number> n = new Box<Number>(123);
		Box<String> s = new Box<String>("koei");
		System.out.println(getData(i));
		System.out.println(getData(n));
		System.out.println(getData(s));

		getData2(i);
		getData2(n);
		// getData2(s);

		// getData3(i);
		getData3(n);
		// getData3(s);

	}

	public static <T> T getData(Box<T> box) {
		return box.getData();
	}

	public static void getData2(Box<? extends Number> box) {
		System.out.println(box.getData());
	}

	public static void getData3(Box<? super Number> box) {
		System.out.println(box.getData());
	}
}
