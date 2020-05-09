package com.recursion;

public class TestRecursion {

	public static void main(String[] args) {

		int n = 8;
		int res = recursion(n);
		System.out.println(res);

		int result = foreach(n);
		System.out.println(result);
	}

	private static int foreach(int n) {
		if (n < 1) {
			throw new IllegalArgumentException("不能少于1");
		}

		int two = 0;
		int one = 0;
		int temp = 0;

		for (int i = 1; i < n + 1; i++) {
			if (i == 1) {// f1
				one = 1;
				two = 0;
			}
			if (i == 2) {// f2
				one = 1;
				two = 1;
			}
			temp = two + one;// f1+f2
			two = one;
			one = temp;

		}

		return temp;
	}

	private static int recursion(int n) {
		if (n < 1) {
			throw new IllegalArgumentException("不能少于1");
		}
		if (n == 1 || n == 2)
			return n;
		else
			return recursion(n - 1) + recursion(n - 2);
	}

}
