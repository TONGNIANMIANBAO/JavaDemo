package com.testJDK18.j2014;

@Worker(role = "WestWood")
@Worker(role = "Falcom")
public class TestRepeatingAnnotation {
	public static void main(String[] args) {
		for (Worker w : TestRepeatingAnnotation.class.getAnnotationsByType(Worker.class)) {
			System.out.println(w.role());
		}

	}
}
