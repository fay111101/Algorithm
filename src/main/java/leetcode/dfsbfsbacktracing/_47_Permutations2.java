
package leetcode.dfsbfsbacktracing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by fay on 2017/12/12.
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class _47_Permutations2 {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        HashSet<ArrayList<Integer>> res = new HashSet<>();
        int level = 0;
        backtracking(num, level, num.length - 1, res);
        result.addAll(res);
        return result;
    }

    private void backtracking(int[] num, int level, int n, HashSet<ArrayList<Integer>> result) {
        if (level == n) {
            ArrayList<Integer> res = new ArrayList<>();
            for (int i : num) {
                res.add(i);
            }
            result.add(res);
            return;
        }
        for (int i = level; i <= n; i++) {
            if (i != level && num[i] == num[level]) {
                continue;
            }
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

    public static void main(String[] args) {
        _47_Permutations2 test = new _47_Permutations2();
        List<List<Integer>> result = new ArrayList<>();
        int[] num = {1, 1, 2, 2};
        /*java.util.Arrays$ArrayList cannot be cast to java.util.ArrayList
            List res=Arrays.asList(num);
            result.add((ArrayList) res);
            List res = Arrays.asList(num);
            result.add(new ArrayList<Integer>(res));*/
       /* ArrayList<ArrayList<String>> stuff = new ArrayList<ArrayList<String>>();
        String[] titles = {"ticker", "grade", "score"};
        stuff.add(new ArrayList<String>(Arrays.asList(titles)));*/
        result = test.permuteUnique(num);
        for (List<Integer> res : result) {
            for (Integer i : res) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
