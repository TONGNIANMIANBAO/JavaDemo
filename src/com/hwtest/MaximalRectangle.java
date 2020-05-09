package com.hwtest;

import java.util.Arrays;
import java.util.Random;

public class MaximalRectangle {

	public static void main(String[] args) {
		Random r = new Random();
		int[][] arr = new int[4][5];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = r.nextInt(2);
			}
		}

		System.out.println(Arrays.deepToString(arr));
		System.out.println("////////////////");

		for (int[] is : arr) {
			System.out.print("[");
			for (int i : is) {
				System.out.print(i + ",");
			}
			System.out.println("]");
		}

		System.out.println(maximalRectangleArea1(arr));
		System.out.println(maximalRectangleArea2(arr));
	}

	public static int maximalRectangleArea1(int[][] arr) {
		int row = arr.length;
		if (row == 0) {
			return 0;
		}
		int col = arr[0].length;
		int[][] dp = new int[row][col];
		int maxArea = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (arr[i][j] == 1) {
					dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;
				}

				int maxWidth = dp[i][j];
				for (int k = i; k >= 0; k--) {
					maxWidth = Math.min(maxWidth, dp[k][j]);
					maxArea = Math.max(maxArea, maxWidth * (i - k + 1));
				}
			}
		}
		return maxArea;
	}

	public static int maximalRectangleArea2(int[][] arr) {
		int row = arr.length;
		if (row == 0) {
			return 0;
		}
		int col = arr[0].length;
		int maxArea = 0;
		int[] heights = new int[col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (arr[i][j] == 1) {
					heights[j] = heights[j] + 1;
				} else {
					heights[j] = 0;
				}
			}
			maxArea = Math.max(maxArea, new LargestRectangle().largestRectangleArea3(heights));
		}

		return maxArea;
	}

}
