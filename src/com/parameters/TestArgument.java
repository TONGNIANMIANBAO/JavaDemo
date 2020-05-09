package com.parameters;

import java.util.Arrays;

/**
 * java是值调用
 * 
 * @author SEN.CHEN
 *
 */

public class TestArgument {

	public static void main(String[] args) {
		// 局部变量
		int i = 1;// 基本数据类型
		String s = "hello";// 引用类型 string不可变
		Integer num = 1;// 引用类型 包装类不可变
		int[] arr = new int[] { 1, 2, 3, 4, 5 };// 引用类型 传递堆地址
		MyData data = new MyData();// 引用类型
		change(i, s, num, arr, data);

		System.out.println(i);
		System.out.println(s);
		System.out.println(num);
		System.out.println(Arrays.toString(arr));
		System.out.println(data.a);
	}

	private static void change(int i, String s, Integer num, int[] arr, MyData data) {
		i += 1;
		s += "world";
		num += 1;
		arr[0] += 1;
		data.a += 1;
	}

	public static class MyData {
		int a = 10;
	}

}
