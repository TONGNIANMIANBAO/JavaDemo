package com.hwtest;

import java.util.Scanner;

public class LastStringLength {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nextLine = sc.nextLine();
		sc.close();

		String[] wds = nextLine.split(" ");
		if (wds.length == 0) {
			System.out.println(0);
			return;
		}
		System.out.println(wds[wds.length - 1].length());

	}

}
