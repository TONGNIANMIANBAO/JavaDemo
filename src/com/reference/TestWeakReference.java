package com.reference;

import java.lang.ref.WeakReference;

/**
 * gc就一定會回收
 * 
 * @author SEN.CHEN
 *
 */
public class TestWeakReference {

	public static void main(String[] args) {
		Object obj1 = new Object();
		WeakReference<Object> wr = new WeakReference<>(obj1);
		System.out.println(obj1);
		System.out.println(wr.get());

		obj1 = null;
		System.gc();
		System.out.println(obj1);
		System.out.println(wr.get());

	}
}
