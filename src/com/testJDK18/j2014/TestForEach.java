package com.testJDK18.j2014;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TestForEach {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Map<Integer, String> map = new HashMap<>();
		map.put(0, "ZERO");
		map.put(1, "ONE");
		map.put(2, "TWO");
		map.forEach((K, V) -> System.out.println(K + "" + V));
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		Iterator<Map.Entry<Integer, String>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<Integer, String> entry = iter.next();
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.forEach(e -> System.out.println(e));
		for (Integer l : list) {
			System.out.println(l);
		}
		Iterator<Integer> iterl = list.iterator();
		while (iterl.hasNext()) {
			int a = iterl.next();
			System.out.println(a);
		}
		list.forEach(System.out::print);
		
	}

}
