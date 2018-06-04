
package leetcode.dfsbacktracing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by fay on 2017/12/12.
 * <p>
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * For example,
 * [1,1,2]have the following unique permutations:
 * [1,1,2],[1,2,1], and[2,1,1].
 */
public class Permutations2 {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        HashSet<ArrayList<Integer>> res = new HashSet<>();
        int level = 0;
        backtracking(num, level,num.length-1,res);
        result.addAll(res);
        return result;
    }
    private void backtracking(int[] num, int level, int n,HashSet<ArrayList<Integer>>result) {
        if (level == n) {
            ArrayList<Integer> res=new ArrayList<>();
            for(int i:num){
                res.add(i);
            }
            result.add(res);
            return;
        }
        for (int i = level; i <= n; i++) {
            if(i!=level&&num[i]==num[level]){
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
        Permutations2 test = new Permutations2();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int[] num = {1, 1, 2,2};
        /*java.util.Arrays$ArrayList cannot be cast to java.util.ArrayList
            List res=Arrays.asList(num);
            result.add((ArrayList) res);
            List res = Arrays.asList(num);
            result.add(new ArrayList<Integer>(res));*/
       /* ArrayList<ArrayList<String>> stuff = new ArrayList<ArrayList<String>>();
        String[] titles = {"ticker", "grade", "score"};
        stuff.add(new ArrayList<String>(Arrays.asList(titles)));*/
        result=test.permuteUnique(num);
        for (ArrayList<Integer> res : result) {
            for (Integer i : res) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
