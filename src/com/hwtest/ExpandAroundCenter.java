package com.hwtest;

import java.util.Scanner;

public class ExpandAroundCenter {

	static int maxLength = 0;
	static int start = 0;

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String input = sc.nextLine();
			for (int i = 0; i < input.length(); i++) {
				aroundCenter(input, i, 0);
				aroundCenter(input, i, 1);
			}
			System.out.println(maxLength);
		}
	}

	private static int aroundCenter(String input, int i, int j) {
		int left = i;
		int right = i + j;
		while (left >= 0 && right < input.length() && input.charAt(left) == input.charAt(right)) {
			if (right - left + 1 > maxLength) {
				maxLength = right - left + 1;
				start = left;
			}
			left--;
			right++;
		}
		return maxLength;

	}

}
