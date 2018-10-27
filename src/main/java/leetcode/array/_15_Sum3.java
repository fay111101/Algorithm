package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class _15_Sum3 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int k = 0; k < nums.length; k++) {
            int target = 0 - nums[k];
            int i = k + 1, j = nums.length - 1;
            if (k != 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            while (i < j) {
                if ((nums[i] + nums[j]) == target) {
                    ArrayList<Integer> res = new ArrayList<>();
                    res.add(nums[k]);
                    res.add(nums[i]);
                    res.add(nums[j]);
                    result.add(res);
                    while (i < j && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    while (i < j && nums[j] == nums[j - 1]) {
                        j--;
                    }
                    i++;
                    j--;
                } else if ((nums[i] + nums[j]) < target) {
                    i++;
                } else {
                    j--;
                }

            }

        }
        return result;
    }

    public static void main(String[] args) {
        _15_Sum3 test = new _15_Sum3();
        int[] num = {-1, 0, 1, 2, -1, -4};
        int[] num1 = {0, 0, 0, 0};
        int[] num2 = {-2, 0, 1, 1, 2};
        List<List<Integer>> result = test.threeSum(num);
        /*for(ArrayList<Integer> res:result){
            for(int a:res){
                System.out.print(a);
            }
            System.out.println();
        }*/
        List<List<Integer>> result1 = test.threeSum(num2);
        for (List<Integer> res : result1) {
            for (int a : res) {
                System.out.print(a);
            }
            System.out.println();
        }
    }
}
