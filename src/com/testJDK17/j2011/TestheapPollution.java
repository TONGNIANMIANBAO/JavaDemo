package com.testJDK17.j2011;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TestheapPollution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set a = new TreeSet();
		a.add(new Integer(1));
		varargs(a);

		List l = new ArrayList<Number>();
		List<String> ls = l; // unchecked warning
		l.add(0, new Integer(42)); // another unchecked warning
		String s = ls.get(0); // ClassCastException is thrown
	}

	public static void varargs(Set<String> set) {
		Iterator<String> iter = set.iterator();
		while (iter.hasNext()) {
			String s = iter.next();
			System.out.print(s);
		}
	}

}
