package com.testJDK18.j2014;

import java.util.Arrays;
import java.util.List;

public class TestMapAndReduce {

	public static void main(String[] args) {
		List<Integer> lists = Arrays.asList(100, 200, 300, 400);
		lists.stream().map(x -> x + 0.16 * x).forEach(System.out::println);
		Integer reduce = lists.stream().reduce(0, Integer::sum);
		System.out.println(reduce);
		Double orElse = lists.stream().map(x -> x + 0.16 * x).reduce((a, b) -> a + b).orElse(99.9);
		System.out.println(orElse);

	}

}
