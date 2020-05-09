package com.testJDK18.j2014;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestMethodReference {

	public static void main(String[] args) {
		// lambda
		Supplier<Employee> sup = () -> (new Employee());
		Employee emp = sup.get();
		System.out.println(emp);

		// ClassName::new
		Supplier<Employee> supp = Employee::new;
		Employee emp2 = supp.get();
		System.out.println(emp2);

		Function<Integer, Employee> fun = Employee::new;
		Employee emp3 = fun.apply(3);
		System.out.println(emp3.getId());

		BiFunction<Integer, String, Employee> fun2 = Employee::new;
		Employee emp4 = fun2.apply(4, "SEGA");
		System.out.println(emp4.getId() + " " + emp4.getName());

		// ClassName::static method
		Employee[] empArray = new Employee[4];
		emp.setId(1);
		emp.setSalary(10);
		emp2.setId(2);
		emp2.setSalary(1);
		emp3.setSalary(11);
		emp4.setSalary(0.2);
		empArray[0] = emp;
		empArray[1] = emp2;
		empArray[2] = emp3;
		empArray[3] = emp4;
		Arrays.sort(empArray, Employee::compareBySalary);
		for (Employee e : empArray) {
			System.out.println(e.getId() + "/" + e.getSalary());
		}

		// Object:: instance method
		Arrays.sort(empArray, emp::compareById);
		for (Employee e : empArray) {
			System.out.println(e.getId() + "/" + e.getSalary());
		}

		// TYPE:: method
		Integer[] intArr = new Integer[3];
		intArr[0] = 2;
		intArr[1] = 1;
		intArr[2] = 6;
		Arrays.sort(intArr, Integer::compare);
		Arrays.asList(intArr).forEach(System.out::println);

		Function<Integer, Integer[]> funInt = Integer[]::new;
		Integer[] intArr2 = funInt.apply(12);
		System.out.println(intArr2.length);
		intArr2[0] = 2;
		intArr2[1] = 1;
		intArr2[2] = 6;
		// Arrays.sort(intArr2, Integer::compare);
		Arrays.asList(intArr2).forEach(System.out::println);

		Function<Integer, String[]> funStr = String[]::new;
		String[] strArr = funStr.apply(3);
		strArr[0] = "Eletronic Arts";
		strArr[1] = "SEQUARE";
		strArr[2] = "ENIX";
		Arrays.sort(strArr, String::compareToIgnoreCase);
		Arrays.asList(strArr).forEach(System.out::println);

	}

}
