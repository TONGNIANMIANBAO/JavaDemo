package com.hwtest;

import java.util.Scanner;

public class ReverseWorld {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		sc.close();
		String[] wds = line.split("[^A-Za-z]");
		if (wds.length == 0) {
			System.out.println("");
			return;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = wds.length - 1; i >= 0; i--) {
			if (!"".equals(wds[i].trim())) {
				if (wds[i].length() > 20) {
					sb.append(wds[i].substring(0, 20) + " " + wds[i].substring(20, wds.length));
				} else {
					sb.append(wds[i]);
				}
			}
			if (i > 0) {
				sb.append(" ");
			}
		}
		System.out.println(sb.toString().trim());
	}

}
