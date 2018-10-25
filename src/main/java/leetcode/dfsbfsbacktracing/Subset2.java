package leetcode.dfsbfsbacktracing;

import java.util.ArrayList;

/**
 * Created by fay on 2017/12/13.
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain _51_duplicate subsets.
 * <p>
 * For example,
 * If S =[1,2,2], a solution is:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
public class Subset2 {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        backtracking(num, 0, res, result);
        return result;
    }
    private void backtracking(int[] num, int start, ArrayList<Integer> res, ArrayList<ArrayList<Integer>> result) {
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
        Subset2 test = new Subset2();
        int[] nums = {1, 2, 2};
        ArrayList<ArrayList<Integer>> result = test.subsetsWithDup(nums);
        for (ArrayList<Integer> res : result) {
            for (Integer i : res) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
