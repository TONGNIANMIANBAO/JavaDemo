package com.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TestList {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();

		// list.add(1);
		// list.add(2);
		// list.forEach(System.out::print);
		// System.out.println("\t" + list.size());
		//
		// list.clear();
		// list.forEach(System.out::print);
		// System.out.println("\t" + list.size());
		//
		// list.add(3);
		// list.add(4);
		// list.forEach(System.out::print);
		// System.out.println("\t" + list.size());

		Random r = new Random();
		int[] a = new int[5];
		for (int i = 0; i < a.length; i++) {
			a[i] = r.nextInt(3);
		}

		System.out.println(Arrays.toString(a));

		int cnt = 0;
		int k = 2;
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			list.clear();
			cnt=0;
			for (int j = i; j < a.length; j++) {
				if (cnt < k + 1) {
					if (!list.contains(a[j])) {
						list.add(a[j]);
						cnt++;
					}
					if (cnt == k) {
						max++;
					}
				} else {
					break;
				}
			}
		}

		System.out.println(max);

	}

}
