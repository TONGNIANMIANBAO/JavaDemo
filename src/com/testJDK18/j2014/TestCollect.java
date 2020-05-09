package com.testJDK18.j2014;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestCollect {

	public static void main(String[] args) {
		List<Integer> lists = Arrays.asList(11, 2, 3, 4, 5, 1, 2);
		List<Integer> collect = lists.stream().distinct().collect(Collectors.toList());
		System.out.println(collect);
		String collect2 = lists.stream().map(Object::toString).collect(Collectors.joining("--"));
		System.out.println(collect2);
	}

}
