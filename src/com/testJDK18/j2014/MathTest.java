package com.testJDK18.j2014;

@FunctionalInterface
public interface MathTest<T, U, R> {
	abstract R operate(T a, U b);

	default int sub(int a, int b) {
		return a - b;
	}

	static int calculate(int a, int b) {
		return a * b;
	}

}
