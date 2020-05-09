package com.hwtest;

import java.util.Deque;
import java.util.LinkedList;

public class ShortestSubarray {
	public static void main(String[] args) {

		int[] arr = new int[] { 56, -21, 56, 35, -9 };
		int k = 61;
		System.out.println(shortestSubarray(arr, k));
	}

	public static int shortestSubarray(int[] A, int K) {
		int len = A.length;
		int[] p = new int[len + 1];
		Deque<Integer> dq = new LinkedList<>();
		int ret = len + 1;

		// 前綴和
		for (int i = 0; i < len; i++) {
			p[i + 1] = p[i] + A[i];
		}

		for (int r = 0; r < ret; r++) {
			while (!dq.isEmpty() && p[r] < dq.getLast()) {
				dq.removeLast();
			}
			while (!dq.isEmpty() && p[r] - p[dq.getFirst()] >= K) {
				ret = Math.min(ret, r - dq.removeFirst());
			}
			dq.add(r);
		}

		return ret < len + 1 ? ret : -1;
	}
}
