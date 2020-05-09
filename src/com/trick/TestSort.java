package com.trick;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestSort {

	public static void main(String[] args) {
		int[] array = { 4, 1, 2 };
		Arrays.sort(array);
		for (int i : array) {
			System.out.println(i);
		}
		Arrays.asList(array).stream().forEach(System.out::println);

		List<Integer> list = new ArrayList<>();
		list.sort(Collections.reverseOrder());
	}

}
