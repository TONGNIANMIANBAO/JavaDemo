package com.trick;

import java.util.ArrayList;
import java.util.List;

public class TestCollections {

	public static void main(String[] args) {
		List<String> lists = new ArrayList<>();
		for (String str : lists) {
			System.out.println("--"+str);
		}
		System.out.println("fin");

	}

}
