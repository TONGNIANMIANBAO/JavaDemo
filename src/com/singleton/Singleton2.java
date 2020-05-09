package com.singleton;

import java.io.Serializable;

//懒汉式，线程安全
public class Singleton2 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Singleton2 singleton;

	private Singleton2() {
		super();
	}

	public static synchronized Singleton2 getSingleton() {
		if (singleton == null) {
			singleton = new Singleton2();
		}
		return singleton;
	}
}
