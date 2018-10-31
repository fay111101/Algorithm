package leetcode.dfsbfsbacktracing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fay on 2017/12/15.
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class _77_Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        backtracking(1, k, n, res, result);
        return result;

    }

    private void backtracking(int level, int k, int n,List<Integer> res, List<List<Integer>> result) {
        if (res.size() == k) {
            result.add(new ArrayList<Integer>(res));
            return;
        }
        for (int i = level; i <= n; i++) {
            res.add(i);
            backtracking(i + 1, k, n, res, result);
            res.remove(res.size() - 1);
        }
    }
}
