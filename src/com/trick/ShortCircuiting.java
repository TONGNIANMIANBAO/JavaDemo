package com.trick;

/**
 * ��·����
 * 
 * @author SEN.CHEN
 *
 */
public class ShortCircuiting {
	public static void main(String[] args) {
		int a = 1;
		int b = 0;
		int c = 0;
		int d = 0;
		int i = 0;
		if (a != 1 && i++ == 1) {
			// short-circuiting
			System.out.println(i);
		}
		System.out.println("--" + i);
		
		if (a != 1 & b++ == 1) {
			System.out.println(b);
		}
		System.out.println("++" + b);

		if (a == 1 || c++ == 1) {
			// short-circuiting
			System.out.println("//" + c);
		}
		
		if (a == 1 | d++ == 1) {
			System.out.println("/" + d);
		}
	}
}
