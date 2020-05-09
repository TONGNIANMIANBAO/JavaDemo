package com.hwtest;

public class Window {

	public int subarraysWithKDistinct(int[] A, int K) {

		if (A == null || A.length < K) {
			return 0;
		}

		int[] hash = new int[A.length + 1];// 申请一个散列，用于记录窗口中具体元素的个数情况
		int l = 0;
		int results = 0;
		int count = 0;// count 记录当前的条件
		int result = 1;
		for (int r = 0; r < A.length; ++r) {
			hash[A[r]]++;// 更新新元素在散列中的数量

			// 根据窗口的变更结果来改变条件值
			if (hash[A[r]] == 1) {
				count++;
			}

			// 如果当前条件不满足，移动左指针直至条件满足为止
			while (hash[A[l]] > 1 || count > K) {
				if (count > K) {
					result = 1;
					count--;
				} else {
					result++;
				}
				hash[A[l]]--;
				l++;
			}

			// 更新结果
			if (count == K) {
				results += result;
			}
		}
		return results;

	}

}
