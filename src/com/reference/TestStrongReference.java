package com.reference;

/**
 * OOM不會回收
 * 
 * @author SEN.CHEN
 *
 */
public class TestStrongReference {

	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = obj1;
		obj1 = null;
		System.gc();
		System.out.println(obj1);
		System.out.println(obj2);
	}

}
