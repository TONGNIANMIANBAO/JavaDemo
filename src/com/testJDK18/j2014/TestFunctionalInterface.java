package com.testJDK18.j2014;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestFunctionalInterface implements MathTest<Float, Integer, Float> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestFunctionalInterface test = new TestFunctionalInterface();
		System.out.println(test.operate(1.02f, 2));

		MathTest<Integer, Float, Float> math = (a, b) -> a + b;
		System.out.println(math.operate(2, 1.02f));

		Predicate<Integer> pre = a -> (a > 0);
		boolean res = pre.test(-1);
		out.println(res);

		Function<Integer, Integer> fun1 = a -> a * 2;
		Function<Integer, Integer> fun2 = a -> a * a;
		out.println(fun1.compose(fun2).apply(4));// 32
		out.println(fun1.andThen(fun2).apply(4));// 64

		Supplier<TestFunctionalInterface> sup = TestFunctionalInterface::new;
		out.println(sup.get());

		Consumer<Employee> con = Employee -> Employee.setName("Tecmo");
		Employee emp = new Employee(1, "Koei");
		out.println(emp.getId() + emp.getName());
		con.accept(emp);
		out.println(emp.getId() + emp.getName());

		Comparator<Employee> com = (e1, e2) -> e1.age - e2.age;
		Employee emp2 = new Employee(2, "BANDAI", 18, 0.99);
		Employee emp3 = new Employee(3, "NAMCO", 15, 1.02);
		out.println(com.compare(emp2, emp3));
		out.println(com.compare(emp3, emp2));
		List<Employee> list = new ArrayList<>();
		list.add(emp3);
		list.add(emp2);
		list.sort(com);
		list.forEach(out::println);

		Optional<Integer> opt = Optional.of(121);
		Optional<Integer> opt2 = Optional.ofNullable(null);
		out.println(opt.isPresent());
		out.println(opt2.isPresent());
		out.println(opt.get());

		out.println(opt2.orElseGet(() -> fun1.apply(2)));
		out.println(opt2.orElse(1));
		opt.ifPresent(a -> out.print(a - 1));

	}

	@Override
	public Float operate(Float a, Integer b) {
		// TODO Auto-generated method stub
		return a + b;
	}
}
