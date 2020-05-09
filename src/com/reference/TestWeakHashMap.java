package com.reference;

import java.util.WeakHashMap;

public class TestWeakHashMap {
	public static void main(String[] args) {
		WeakHashMap<Integer, String> weakHashMap = new WeakHashMap<>();
		Integer key = new Integer(2);
		String val = "map";
		weakHashMap.put(1, "test");
		weakHashMap.put(key, val);
		System.out.println(weakHashMap);

		key = null;
		weakHashMap.put(null, null);
		System.out.println(weakHashMap);

		System.gc();
		System.out.println(weakHashMap);

		WeakHashMap<Integer, Byte[]> map = new WeakHashMap<Integer, Byte[]>();
		for (int i = 0; i < 10000; i++) {
			Integer integer = new Integer(i);
			map.put(integer, new Byte[i]);
		}
		System.out.println("fin");
	}
}
