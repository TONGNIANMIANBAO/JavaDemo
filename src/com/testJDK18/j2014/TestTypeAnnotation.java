package com.testJDK18.j2014;

import com.testJDK15.j2004.AnnotationTest;

/**
 * 類型註解，拓展了註解使用範圍
 * 
 * @author SEN.CHEN
 *
 */
public class TestTypeAnnotation {

	public static void main(String[] args) {

		String str = new @AnnotationTest(id = 0, msg = "CAPCOM") String();
		str = (@AnnotationTest(id = 1, msg = "KONAMI") String) null;
		System.out.println(str);
	}

}
