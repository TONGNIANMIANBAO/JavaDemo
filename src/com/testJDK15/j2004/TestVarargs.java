package com.testJDK15.j2004;

/**
 * 可变参数
 * @author SEN.CHEN
 *
 */
public class TestVarargs {

	public static void main(String[] args) {
		show(false);
		show(0);
		show(1, 2);
		show(true, 1, 2, 3);
		show(true, new int[] { 1, 2, 3 });//可变参数可传入数组
		show(true, 0);
		show();//可变参数方法可传入空参数
		System.out.println("fin");
	}

	public static void show(int a) {
		System.out.println("first:" + a);
	}

	public static void show(int... b) {
		for (int a : b) {
			System.out.println("second:" + a);
		}
	}

	public static void show(boolean a, int... b) {
		System.out.println("third:" + String.valueOf(a) + b.length);
	}
}
