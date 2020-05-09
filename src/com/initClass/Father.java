package com.initClass;

public class Father {

	private int i = test();
	private static int j = staticMethod();

	static {
		System.out.println(1);
	}

	Father() {
		System.out.println(2);
	}

	{// 构造代码块 在构造方法前执行
		System.out.println(3);
	}

	public int test() {
		System.out.println(4);
		return 0;
	}

	public static int staticMethod() {
		System.out.println(5);
		return 0;
	}

}
