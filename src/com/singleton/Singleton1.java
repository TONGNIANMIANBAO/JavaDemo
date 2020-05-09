package com.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

//饿汉式
public class Singleton1 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Singleton1 singleton = new Singleton1();

	private Singleton1() {
		// 防止反射
		if (singleton != null) {
			throw new RuntimeException();
		}
	}

	public static Singleton1 getSingleton() {
		return singleton;
	}

	// 防止反序列化
	private Object readResolve() throws ObjectStreamException {
		return singleton;
	}
}
