package com.testJDK18.j2014;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class TestPredicate {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("java", "objectc", "php", "python", "delphi", "kotlin", "scala");
		filter(names, x -> x.startsWith("p"));
		System.out.println("-------------->all :");
		filter(names, x -> true);
		System.out.println("-------------->5 :");
		filter(names, x -> x.length() > 5);
		System.out.println("-------------->and :");
		Predicate<String> p1 = x -> x.startsWith("p");
		Predicate<String> p2 = x -> x.length() > 5;
		filter(names, p1.and(p2));
		System.out.println("-------------->or :");
		filter(names, p1.or(p2));
	}

	public static <T> void filter(List<T> names, Predicate<T> condition) {
		names.stream().filter(name -> condition.test(name)).forEach(System.out::println);
	}

}
