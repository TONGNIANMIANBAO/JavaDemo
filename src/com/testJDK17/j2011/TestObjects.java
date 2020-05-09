package com.testJDK17.j2011;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TestObjects {

	public static void main(String[] args) {
		String s1 = new String("qwe");
		String s2 = new String("qwe");
		System.out.println(Objects.equals(s1, s2));
		
		String str = "a,b,c,,";
		String[] ary = str.split(","); // Ԥ�ڴ��� 3������� 3
		System.out.println(ary.length);
		List<String> list = Arrays.asList(ary);
		// list.add("d");����ʹ��ADD REMOVE CLEAR
		list.forEach(System.out::print);
		ary[0] = "d";
		list.forEach(System.out::print);

		List<String> a = new ArrayList<String>();
		a.add("1");
		a.add("2");
		for (String item : a) {
			if ("2".equals(item)) {
				a.remove(item);
			}
		}

		System.out.println(a);
	}

}
