package com.hwtest;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortArray {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int cnt = sc.nextInt();
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i < cnt; i++) {
				list.add(sc.nextInt());
			}
			if (sc.nextInt() == 0) {
				list.sort((a, b) -> a.compareTo(b));
			} else {
				list.sort((a, b) -> b.compareTo(a));
			}
			String sb = list.stream().map(x -> x.toString()).collect(Collectors.joining(" "));
			System.out.println(sb);
		}
	}

}
