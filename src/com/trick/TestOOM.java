package com.trick;

public class TestOOM {

	static String str = "oom";

	public static void main(String[] args) {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			String s = str + str;
			str = s;
		}
	}

}
