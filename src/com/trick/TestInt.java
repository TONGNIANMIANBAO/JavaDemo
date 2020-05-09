package com.trick;

public class TestInt {

	public static void main(String[] args) {
		int i = 1;
		i = i++;
		System.out.println(i);// 1

		int j = i++;
		System.out.println(j);// 1

		int k = i + ++i * i++;// 2+3*3
		System.out.println(k);// 11
		System.out.println(i);// 4
	}

}
