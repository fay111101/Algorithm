package leetcode.dfsbacktracing;

import java.util.ArrayList;
import java.util.Arrays;

/*

Given a collection of candidate numbers ( C ) and a target number ( T ), find all unique combinations in C where the candidate numbers sums to T .

Each number in C may only be used once in the combination.

Note:

    All numbers (including target) will be positive integers.
    Elements in a combination (a 1, a 2, … , a k) must be in non-descending order. (ie, a 1 ≤ a 2 ≤ … ≤ a k).
    The solution set must not contain duplicate combinations.


For example, given candidate set10,1,2,7,6,1,5and target8,
A solution set is:
[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6] */
public class CombinationSum2 {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        if(num==null||num.length==0){
            return result;
        }
        ArrayList<Integer> res=new ArrayList<>();
        Arrays.sort(num);
        dfs(num,result,res,target,0);
        return result;

    }

    private void dfs(int[] candidates, ArrayList<ArrayList<Integer>> result,
                     ArrayList<Integer> res, int target,int start) {
        if(target<0){
            return;
        }else if(target==0){
            //Bug result.add(res);
            result.add(new ArrayList<>(res));
        }else{
            for(int i=start;i<candidates.length;i++){
                if(i>start&&candidates[i]==candidates[i-1]){
                    continue;
                }
                res.add(candidates[i]);
                dfs(candidates,result,res,target-candidates[i],i+1);
                res.remove(res.size()-1);
            }
        }
    }
    public static void main(String[] args){
        CombinationSum2 test=new CombinationSum2();
        int[] arr={2,3,4,7};
        int[] arr1={1,1};
        //ArrayList<ArrayList<Integer>> result=test.combinationSum2(arr,7);
        ArrayList<ArrayList<Integer>> result=test.combinationSum2(arr1,1);
        for(ArrayList<Integer> res:result){
            for(int i:res){
                System.out.print(i+" ");
            }
            System.out.println("===== ");
        }

    }

}
