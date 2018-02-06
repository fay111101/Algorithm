package main.java.leetcode.stack;

import java.util.Stack;

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length < 1 || matrix[0].length < 1)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = 0;
        int[] height = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1')
                    height[j] += 1;
                else
                    height[j] = 0;
            }
            maxArea = Math.max(largestRectangleArea(height), maxArea);
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] height) {
        Stack<Integer> s = new Stack<Integer>();
        int max = 0;
        int i = 0;
        while (i <= height.length) {
            int h = (i == height.length ? 0 : height[i]);
            if (s.isEmpty() || height[s.peek()] <= h) {
                s.push(i);
                i++;
            } else {
                int curHeight = height[s.pop()];
                max = Math.max(max, curHeight * (s.isEmpty() ? i : (i - s.peek() - 1)));
            }
        }
        return max;
    }
}
