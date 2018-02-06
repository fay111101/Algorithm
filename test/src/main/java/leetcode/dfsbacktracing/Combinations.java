package leetcode.dfsbacktracing;

import java.util.ArrayList;

/**
 * Created by fay on 2017/12/15.
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 For example,
 If n = 4 and k = 2, a solution is:
 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 */
public class Combinations {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> res=new ArrayList<>();
        backtracking(1,k,n,res,result);
        return result;

    }
    private void backtracking(int level,int k,int n,ArrayList<Integer> res,ArrayList<ArrayList<Integer>> result){
        if(res.size()==k){
            result.add(new ArrayList<Integer>(res));
            return;
        }
        for(int i=level;i<=n;i++){
            res.add(i);
            backtracking(i+1,k,n,res,result);
            res.remove(res.size()-1);
        }
    }
}
