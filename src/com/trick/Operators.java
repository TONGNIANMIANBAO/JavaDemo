package com.trick;

public class Operators {

	public static void main(String[] args) {

		int a = 11;
		String binaryString = Integer.toBinaryString(a);
		System.out.println(binaryString);

		// 左移1位，相当乘以2
		a <<= 1;
		System.out.println(a);
		System.out.println(Integer.toBinaryString(a));

		System.out.println("");
		// 右移1位，相当除以2，结果取整数部分
		// >>：有符号右移，低位移除，高位正数补0，负数补1
		int b = -11;
		System.out.println(Integer.toBinaryString(b));
		b >>= 1;
		System.out.println(b);
		System.out.println(Integer.toBinaryString(b));
		// >>>：无符号右移，低位移除，高位都补0
		b >>>= 2;
		// 结果向下取整
		System.out.println(b);
		System.out.println(Integer.toBinaryString(b));
		// 结果向零取整
		System.out.println(-11 / 2);

		System.out.println("");
		// 取余数与左操作数同符号
		System.out.println((-3) % 2);
		System.out.println(3 % (-2));

		System.out.println("");
		float f;
		int c = 0;
		c = 3 / 2 ;
		System.out.println(c);
		f = 0.3f / 2;
		System.out.println(f);
		f = 3 / 0.2f;
		System.out.println(f);
	}

}
