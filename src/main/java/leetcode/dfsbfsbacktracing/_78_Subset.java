package leetcode.dfsbfsbacktracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fay on 2017/12/13.
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * https://www.cnblogs.com/zpfbuaa/p/6633986.html
 * https://blog.csdn.net/jarvischu/article/details/16067319
 */
public class _78_Subset {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(nums, 0, result, res);
        return result;
    }

    private void backtracking(int[] s, int start, List<List<Integer>> result, ArrayList<Integer> res) {
        result.add(new ArrayList<>(res));
        System.out.println(result);
        for (int i = start; i < s.length; i++) {
            res.add(s[i]);
            backtracking(s, i + 1, result, res);
            res.remove(res.size() - 1);
        }

    }

    public static void main(String[] args) {
        _78_Subset test = new _78_Subset();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = test.subsets(nums);
        for (List<Integer> res : result) {
            for (Integer i : res) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
