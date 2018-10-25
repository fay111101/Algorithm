package leetcode.dfsbfsbacktracing;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by fay on 2017/12/13.
 *Given a set of distinct integers, S, return all possible subsets.
 Note:
 Elements in a subset must be in non-descending order.
 The solution set must not contain _51_duplicate subsets.

 For example,
 If S =[1,2,3], a solution is:
 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 */
public class Subset {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        ArrayList<Integer> res=new ArrayList<>();
        Arrays.sort(S);
        backtracking(S,0,result,res);
        return result;
    }

    private void backtracking(int[] s, int start, ArrayList<ArrayList<Integer>> result,ArrayList<Integer> res) {
        result.add(new ArrayList<>(res));
        for(int i=start;i<s.length;i++ ){
            res.add(s[i]);
            backtracking(s,i+1,result,res);
            res.remove(res.size()-1);
        }

    }
    public static void main(String[] args){
        Subset test=new Subset();
        int[] nums={1,2};
        ArrayList<ArrayList<Integer>> result=test.subsets(nums);
        for (ArrayList<Integer> res : result) {
            for (Integer i : res) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
