package leetcode.dfsbfsbacktracing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fay on 2017/12/13.
 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

 说明：解集不能包含重复的子集。

 示例:

 输入: [1,2,2]
 输出:
 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 */
public class _90_Subset2 {

    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        backtracking(num, 0, res, result);
        return result;
    }
    private void backtracking(int[] num, int start, List<Integer> res, List<List<Integer>> result) {
        result.add(new ArrayList<>(res));
        for (int i = start; i < num.length; i++) {
            res.add(num[i]);
            backtracking(num, i + 1, res, result);
            res.remove(res.size() - 1);
            while(i+1<num.length&&num[i]==num[i+1]){
                i++;
            }
        }
    }
    public static void main(String[] args) {
        _90_Subset2 test = new _90_Subset2();
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = test.subsetsWithDup(nums);
        for (List<Integer> res : result) {
            for (Integer i : res) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
