package com.testJDK18.j2014;

public class TestLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestLambda lam = new TestLambda();
		MathTest<Integer, Integer, Integer> test = (a, b) -> {
			return a + b;
		};
		MathTest<Integer, Integer, Integer> test2 = (a, b) -> a * b;
		System.out.println("" + lam.operation(2, 3, test));
		System.out.println("" + lam.operation(2, 3, test2));

		System.out.println("" + test.sub(2, 3));
		System.out.println("" + test2.operate(2, 3));
	}

	public int operation(int a, int b, MathTest<Integer, Integer, Integer> testMath) {
		return testMath.operate(a, b);
	}

}
