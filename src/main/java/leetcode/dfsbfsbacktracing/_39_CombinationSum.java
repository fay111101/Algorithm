package leetcode.dfsbfsbacktracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 */
public class _39_CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        ArrayList<Integer> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, result, res, target, 0);
        return result;

    }

    private void dfs(int[] candidates,List<List<Integer>> result,
                     ArrayList<Integer> res, int target, int start) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            //Bug
            //result.add(res);
            result.add(new ArrayList<>(res));
        } else {
            for (int i = start; i < candidates.length; i++) {
                res.add(candidates[i]);
                dfs(candidates, result, res, target - candidates[i], i);
                res.remove(res.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        _39_CombinationSum test = new _39_CombinationSum();
        int[] arr = {2, 3, 4, 7};
        List<List<Integer>> result = test.combinationSum(arr, 7);
        for (List<Integer> res : result) {
            for (int i : res) {
                System.out.print(i + " ");
            }
            System.out.println("===== ");
        }

    }
}
