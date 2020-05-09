package com.initClass;

public class Son extends Father {
	private int i = test();
	private static int j = staticMethod();

	static {
		System.out.println(6);
	}

	Son() {
		System.out.println(7);
	}

	{
		System.out.println(8);
	}

	public int test() {
		System.out.println(9);
		return 0;
	}

	public static int staticMethod() {
		System.out.println(10);
		return 0;
	}

	public static void main(String[] args) {
		Father f = new Father();// （父类-》子类，上-》下）静态-》非静态-》构造器
		System.out.println("father1");
		Son son1 = new Son();// 父类-》子类-》构造器
		System.out.println("son1");
		Son son2 = new Son();
		System.out.println("son2");
		Father f2 = new Father();
	}

}
