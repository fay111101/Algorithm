package leetcode.array;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。

 要求算法的时间复杂度为 O(n)。

 示例:

 输入: [100, 4, 200, 1, 3, 2]
 输出: 4
 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */

import java.util.HashSet;

public class _128_LongestConsecutiveSequence {

    public int longestConsecutive(int[] num) {
        HashSet<Integer> set = new HashSet<>();

        int max = Integer.MIN_VALUE;
        for (int i : num) {
            set.add(i);
        }
        for (int i = 0; i < num.length; i++) {
            int temp = num[i];
            int len = 1;
            while (set.contains(--temp)) {
                len++;
                set.remove(temp);
            }
            temp = num[i];
            while (set.contains(++temp)) {
                len++;
                set.remove(temp);
            }
            if (len > max) {
                max = len;
            }

        }
        return max;
    }

    public static void main(String[] args) {
        int[] num = {100, 4, 200, 1, 3, 2, 5, 6, 7, 101, 102, 103, 104, 105, 106, 107, 108, 109,
                110, 8, 9, 10,
                11, 12, 13};
        _128_LongestConsecutiveSequence test = new _128_LongestConsecutiveSequence();
        System.out.println(test.longestConsecutive(num));
    }
}
