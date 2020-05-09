package com.hwtest;

import java.util.Arrays;

public class BucketSort {

	public static void main(String[] args) {
		int[] a = new int[] { 1, 3, 2, 4, 5, 6, 2, 1, 3, 6 };
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			max = max > a[i] ? max : a[i];
		}
		int[] bucket = new int[max + 1];

		for (int i = 0; i < a.length; i++) {
			bucket[a[i]]++;
		}
		System.out.println(Arrays.toString(bucket));
		for (int i = 0; i < bucket.length; i++) {
			while (bucket[i]-- > 0) {
				System.out.println(i);
			}
		}
	}

}
