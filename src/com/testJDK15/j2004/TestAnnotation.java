package com.testJDK15.j2004;

@AnnotationTest(id = 1, msg = "Ubisoft")
public class TestAnnotation {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean hasAnnotation = TestAnnotation.class
				.isAnnotationPresent(AnnotationTest.class);
		if (hasAnnotation) {
			AnnotationTest an = TestAnnotation.class
					.getAnnotation(AnnotationTest.class);
			System.out.println("id=" + an.id());
			System.out.println("msg=" + an.msg());
		}
	}

}
