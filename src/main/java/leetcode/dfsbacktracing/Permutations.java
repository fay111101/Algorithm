package leetcode.dfsbacktracing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fay on 2017/12/12.
 * Given a collection of numbers, return all possible permutations.
 * For example,
 * [1,2,3]have the following permutations:
 * [1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2], and[3,2,1].
 * http://blog.csdn.net/feliciafay/article/details/41349783
 * http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 */
public class Permutations {
    public ArrayList<ArrayList<Integer>> permute1(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        int level = 0;
        backtracking(num, level,num.length-1,result);
        return result;
    }

    private void backtracking(int[] num, int level, int n,ArrayList<ArrayList<Integer>> result) {
        if (level == n) {
            ArrayList<Integer> res=new ArrayList<>();
            for(int i:num){
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
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0){
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
        Permutations test = new Permutations();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int[] num = {1, 2, 3};
        /*java.util.Arrays$ArrayList cannot be cast to java.util.ArrayList
            List res=Arrays.asList(num);
            result.add((ArrayList) res);
            List res = Arrays.asList(num);
            result.add(new ArrayList<Integer>(res));*/
       /* ArrayList<ArrayList<String>> stuff = new ArrayList<ArrayList<String>>();
        String[] titles = {"ticker", "grade", "score"};
        stuff.add(new ArrayList<String>(Arrays.asList(titles)));*/
        result=test.permute1(num);
        for (ArrayList<Integer> res : result) {
            for (Integer i : res) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
