package com.reference;

import java.lang.ref.SoftReference;

/**
 * 內存不足會回收
 * 
 * @author SEN.CHEN
 *
 */
public class TestSoftReference {
	public static void main(String[] args) {
		gc_enought();
		gc_nonenought();
	}

	private static void gc_nonenought() {
		Object obj1 = new Object();
		SoftReference<Object> sr = new SoftReference<>(obj1);
		System.out.println(obj1);
		System.out.println(sr.get());

		obj1 = null;// 一定要有，否則軟引用無效
		try {
			byte[] bytes = new byte[30 * 1024 * 1024];
			System.out.println(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(obj1);
			System.out.println(sr.get());
		}

	}

	private static void gc_enought() {
		Object obj1 = new Object();
		SoftReference<Object> sr = new SoftReference<>(obj1);
		System.out.println(obj1);
		System.out.println(sr.get());

		obj1 = null;
		System.gc();

		System.out.println(obj1);
		System.out.println(sr.get());
	}

}
