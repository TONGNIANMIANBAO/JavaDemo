package com.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestLRU {

	public static void main(String[] args) {
		int size = 5;

		Map<String, String> map = new LinkedHashMap<String, String>(16, 0.75f, true) {
			/**
			 * Parameters:
			 * 	initialCapacity the initial capacity
			 * 	loadFactor the load factor
			 * 	accessOrder the ordering mode - true for access-order, false forinsertion-order
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected boolean removeEldestEntry(java.util.Map.Entry<String, String> eldest) {
				boolean tooBig = size() > size;
				if (tooBig) {
					System.out.println("remove key: " + eldest.getKey());
				}
				return tooBig;
			}
		};

		map.put("1", "one");
		map.put("2", "two");
		map.put("3", "three");
		map.put("4", "four");
		map.put("5", "five");

		System.out.println(map);

		map.put("6", "six");
		System.out.println(map);

		map.get("4");
		System.out.println(map);

		map.get("2");
		map.put("7", "seven");
		System.out.println(map);

	}

}
