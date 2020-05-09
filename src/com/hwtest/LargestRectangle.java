package com.hwtest;

import java.util.Stack;

public class LargestRectangle {

	public int largestRectangleArea(int[] heights) {
		int max = 0;
		int h = 0;
		for (int i = 0; i < heights.length; i++) {
			h = Integer.MAX_VALUE;
			for (int j = i; j < heights.length; j++) {
				h = Math.min(h, heights[j]);
				max = Math.max(max, h * (j - i + 1));
			}
		}
		return max;
	}

	public int largestRectangleArea2(int[] heights) {
		return caculateArea(heights, 0, heights.length - 1);
	}

	private int caculateArea(int[] heights, int start, int end) {
		if (start > end) {
			return 0;
		}
		int minIndex = start;
		for (int i = start; i <= end; i++) {
			if (heights[minIndex] > heights[i]) {
				minIndex = i;
			}
		}
		return Math.max(heights[minIndex] * (end - start + 1),
				Math.max(caculateArea(heights, start, minIndex - 1), caculateArea(heights, minIndex + 1, end)));
	}

	public int largestRectangleArea3(int[] heights) {
		int max = 0;
		Stack<Integer> s = new Stack<>();
		s.push(-1);
		for (int i = 0; i < heights.length; i++) {
			while (s.peek() != -1 && heights[s.peek()] > heights[i]) {
				max = Math.max(max, heights[s.pop()] * (i - s.peek() - 1));
			}
			s.push(i);
		}
		while (s.peek() != -1) {
			max = Math.max(max, heights[s.pop()] * (heights.length - s.peek() - 1));
		}

		return max;
	}

}
