package leetcode.array;
/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。

 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。

 示例:

 给定 nums = [2, 7, 11, 15], target = 9

 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]

 */

import java.util.HashMap;

public class _1_TwoNums {

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers == null || numbers.length == 0) {
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 1; i <= numbers.length; i++) {
            map.put(numbers[i - 1], i);
        }
        int num = 0;
        for (int i = 1; i <= numbers.length; i++) {
            num = target - numbers[i - 1];
            if (map.containsKey(num) && i != map.get(num)) {
                if (i < map.get(num)) {
                    res[0] = i;
                    res[1] = map.get(num);
                } else {
                    res[0] = map.get(num);
                    res[1] = i;
                }
            }
        }
        return res;
    }

    public int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        int num2 = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            num2 = target - nums[i];
            if (map.containsKey(num2) && map.get(num2) != i) {
                result[0] = i;
                result[1] = map.get(num2);
            }
        }
        return result;

    }
}
