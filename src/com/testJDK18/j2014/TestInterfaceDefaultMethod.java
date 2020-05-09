package com.testJDK18.j2014;

import static java.lang.System.out;

public class TestInterfaceDefaultMethod {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test test = new Test();
		out.println(test.operate(5, 2));
		out.println(test.sub(5, 2));
		out.println(MathTest.calculate(5, 2));

	}

}

class Test implements MathTest<Integer, Integer, Integer> {

	@Override
	public Integer operate(Integer a, Integer b) {
		// TODO Auto-generated method stub
		return a + b;
	}

	// @Override
	// public int sub(int a, int b) {
	// return b - a;
	// }
}