package com.testJDK15.j2004;

/**
 * 包装类
 * @author SEN.CHEN
 *
 */
public class TestWrapperClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Long l1 = 1000l;
		Long l2 = 1000l;
		int f1 = 100000000;
		Integer f2 = f1;
		System.out.println(l1 == l2);
		System.out.println(l1.equals(l2));
		System.out.println(f1 == f2);// 拆箱
		System.out.println(f2.equals(f1) + "////");

		Integer a = 1;
		Integer b = 1;
		Integer c = 144;
		Integer d = 144;
		Integer a1 = new Integer(1);
		Integer b1 = new Integer(1);
		System.out.println(a == b); // true
		System.out.println(a.equals(b)); // true
		System.out.println(a1 == b1); // false
		System.out.println(a1.equals(b1)); // true
		System.out.println(c == d); // false
		System.out.println(c.equals(d)); // true
	}

}
