package leetcode.dfsbfsbacktracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
public class _40_CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        List<Integer> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, result, res, target, 0);
        return result;

    }

    private void dfs(int[] candidates, List<List<Integer>> result,
                     List<Integer> res, int target, int start) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            //Bug result.add(res);
            result.add(new ArrayList<>(res));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                res.add(candidates[i]);
                dfs(candidates, result, res, target - candidates[i], i + 1);
                res.remove(res.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        _40_CombinationSum2 test = new _40_CombinationSum2();
        int[] arr = {2, 3, 4, 7};
        int[] arr1 = {1, 1};
        //ArrayList<ArrayList<Integer>> result=test.combinationSum2(arr,7);
        List<List<Integer>> result = test.combinationSum2(arr1, 1);
        for (List<Integer> res : result) {
            for (int i : res) {
                System.out.print(i + " ");
            }
            System.out.println("===== ");
        }

    }

}
