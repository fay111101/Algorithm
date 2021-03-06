package leetcode.dfsbfsbacktracing;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class _46_Permutations {

    public List<List<Integer>> permute1(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int level = 0;
        backtracking(num, level, num.length - 1, result);
        return result;
    }

    private void backtracking(int[] num, int level, int n, List<List<Integer>> result) {
        if (level == n) {
            List<Integer> res = new ArrayList<>();
            for (int i : num) {
                res.add(i);
            }
            result.add(res);
            return;
        }
        for (int i = level; i <= n; i++) {
            swap(num, level, i);
            backtracking(num, level + 1, n, result);
            swap(num, level, i);
        }

    }

    public void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        dfs(nums, 0, new ArrayList<Integer>());
        return result;
    }

    void dfs(int[] nums, int start, List<Integer> list) {
        if (start == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                dfs(nums, start + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        _46_Permutations test = new _46_Permutations();
        List<List<Integer>> result = new ArrayList<>();
        int[] num = {1, 2, 3};
        /*java.util.Arrays$ArrayList cannot be cast to java.util.ArrayList
            List res=Arrays.asList(num);
            result.add((ArrayList) res);
            List res = Arrays.asList(num);
            result.add(new ArrayList<Integer>(res));*/
       /* ArrayList<ArrayList<String>> stuff = new ArrayList<ArrayList<String>>();
        String[] titles = {"ticker", "grade", "score"};
        stuff.add(new ArrayList<String>(Arrays.asList(titles)));*/
        result = test.permute(num);
        for (List<Integer> res : result) {
            for (Integer i : res) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
