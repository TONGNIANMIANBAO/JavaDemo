package com.variable;

public class TestVar {

	// 成员变量
	static int s;// 类变量 方法区
	int i;// 实例变量 堆
	int j;

	{// 构造代码块 在构造方法前执行
		int i = 1;// 局部变量 栈
		i++;// 局部变量
		j++;// 实例变量
		s++;
	}

	public void test(int j) {
		j++;
		i++;
		s++;
	}

	public static void main(String[] args) {
		TestVar test1 = new TestVar();
		System.out.println(test1.i);
		System.out.println(test1.j);
		TestVar test2 = new TestVar();
		test1.test(10);
		test1.test(20);
		test2.test(10);

		System.out.println(test1.i);// 2
		System.out.println(test1.j);// 1
		System.out.println(test1.s);// 5
		System.out.println();
		System.out.println(test2.i);// 1
		System.out.println(test2.j);// 1
		System.out.println(s);// 5

	}

}
