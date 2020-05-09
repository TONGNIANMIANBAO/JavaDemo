package com.testJDK18.j2014;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestStream {

	public static void main(String[] args) {
		Employee emp1 = new Employee(1, "Banpresto", 111, 789);
		Employee emp2 = new Employee(2, "TAKARA", 111, 456);
		Employee emp3 = new Employee(3, "TOMY", 333, 123);
		Stream<Employee> stream1 = Stream.of(emp1, emp2, emp3);
		Stream<Employee> stream2 = Stream.of(emp1, emp2, emp3);
		Stream<Employee> stream3 = Stream.of(emp1, emp2, emp3);
		Stream<Employee> stream4 = Stream.of(emp1, emp2, emp3);
		stream1.forEach((e) -> System.out.println(e.getSalary() * 2));
		stream2.filter(e -> e.getName().startsWith("T")).forEach(System.out::println);
		Map<Integer, List<Employee>> map = stream3.collect(Collectors.groupingBy(Employee::getAge));// groupingby�ֽM
		System.out.println(map);
		stream4.map(e -> e.getId()).map(e -> e * 3).forEach(System.out::println);// map�ɟo���B��

		List<Employee> list = new ArrayList<>();
		list.add(new Employee(4, "TAMIYA", 444, 234));
		list.add(new Employee(5, "KOTOBUKIYA", 555, 345));
		list.add(new Employee(6, "HASBRO", 666, 456));
		OptionalDouble maxSalary = list.stream().mapToDouble(Employee::getSalary).max();
		System.out.println(maxSalary.getAsDouble());
		Optional<Employee> opt = list.stream()
				.reduce((e1, e2) -> new Employee(e1.getId() + e2.getId(), e1.getName() + e2.getName(), 666, 678));// reduce������Ԫ��Ҏ�s����һ��Ԫ��
		opt.ifPresent(System.out::println);

		int sumAge = list.stream().mapToInt(Employee::getAge).sum();
		System.out.println(sumAge);

		int[] intArr = { 8, 2, 13 };
		IntStream intStr = Arrays.stream(intArr);
		intStr.sorted().map(e -> e * 2).forEach(System.out::println);// mapӳ��Ԫ��

		IntStream intStr2 = IntStream.range(2, 8);
		// intStr2.forEach(System.out::println);
		// boolean any=intStr2.anyMatch((e)->e==7);
		// boolean all=intStr2.allMatch((e)->e==6);
		// boolean non=intStr2.noneMatch((e)->e==7);
		long cnt = intStr2.count();
		System.out.println(cnt);

		List<Integer> intList = Arrays.asList(1, 2, 4, 4, 4, 1);
		intList.stream().forEach(System.out::print);
		System.out.println();
		intList.parallelStream().forEach(System.out::print);
		System.out.println();
		intList.parallelStream().forEachOrdered(System.out::print);
		System.out.println();
		intList.stream().map(e -> e * 2).limit(3).forEachOrdered(System.out::print);
		System.out.println();
		intList.stream().map(e -> e * 2).skip(3).forEachOrdered(System.out::print);

		int sum = intList.stream().filter(e -> e > 2).mapToInt(e -> e).sum();
		System.out.println();
		System.out.println(sum);
		List<Integer> clist = intList.stream().map(e -> e * 2).collect(Collectors.toList());
		System.out.println(clist);

		Stream<String> stream = Stream.of("ANIPLEX.SONY", "FLYING.DOG");
		stream.flatMap(e -> Stream.of(e.split("[.]"))).forEach(System.out::println);

		List<List<Integer>> myList = new ArrayList<List<Integer>>();
		List<Integer> intList2 = Arrays.asList(7, 8, 9);
		myList.add(intList2);
		myList.add(intList);
		// List<Integer> res = myList.stream()
		// .flatMap(l -> l.stream().map(e -> e + 1))
		// .collect(Collectors.toList());
		Stream<Integer> si = myList.stream().flatMap(l -> l.stream().map(e -> e + 1));
		List<Integer> res1 = si.distinct().collect(Collectors.toList());
		System.out.println(res1);

		Stream.iterate(2.0, e -> e * e).limit(10).forEach(System.out::println);
		Stream.iterate(6, e -> (e + 10)).limit(10).filter(e -> (e % 3 == 0)).forEach(System.out::println);
		Stream.generate(() -> Math.random() * 5).limit(5).filter(e -> e > 1).peek(e -> System.out.println(e + ">1"))
				.filter(e -> e > 3).forEach(e -> System.out.println(e + ">3"));

		List<Integer> listInt = Arrays.asList(6, 7, 2, 3, 5, 6, 8);
		listInt.stream().filter(e -> e > 2).peek(e -> System.out.println("++" + e)).filter(e -> e > 4)
				.peek(e -> System.out.println("--" + e)).forEach(System.out::println);

	}

}
