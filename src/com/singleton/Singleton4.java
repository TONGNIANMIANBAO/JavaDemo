package com.singleton;

//静态内部类
public class Singleton4 {

	private Singleton4() {
		super();
	}

	public static Singleton4 getSingleton() {
		return InnerSingleton.inner;
	}

	private static class InnerSingleton {
		private static Singleton4 inner = new Singleton4();
	}
}
