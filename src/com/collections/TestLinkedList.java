package com.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestLinkedList {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		Collections.reverse(list);
		list.forEach(System.out::println);
		
	}

}
