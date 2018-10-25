package leetcode.dfsbfsbacktracing;

import java.util.ArrayList;
import java.util.Arrays;

/* Given a set of candidate numbers ( C ) and a target number ( T ), find all unique combinations in C where the candidate numbers sums to T .

The same repeated number may be chosen from C unlimited number of times.

Note:

    All numbers (including target) will be positive integers.
    Elements in a combination (a 1, a 2, … , a k) must be in non-descending order. (ie, a 1 ≤ a 2 ≤ … ≤ a k).
    The solution set must not contain _51_duplicate combinations.


For example, given candidate set2,3,6,7and target7,
A solution set is:
[7]
[2, 2, 3]

*/
public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        if(candidates==null||candidates.length==0){
            return result;
        }
        ArrayList<Integer> res=new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,result,res,target,0);
        return result;

    }

    private void dfs(int[] candidates, ArrayList<ArrayList<Integer>> result,
                     ArrayList<Integer> res, int target,int start) {
        if(target<0){
            return;
        }else if(target==0){
            //Bug
            //result.add(res);
            result.add(new ArrayList<>(res));
        }else{
            for(int i=start;i<candidates.length;i++){
                res.add(candidates[i]);
                dfs(candidates,result,res,target-candidates[i],i);
                res.remove(res.size()-1);
            }
        }
    }

    public static void main(String[] args){
        CombinationSum test=new CombinationSum();
        int[] arr={2,3,4,7};
        ArrayList<ArrayList<Integer>> result=test.combinationSum(arr,7);
        for(ArrayList<Integer> res:result){
            for(int i:res){
                System.out.print(i+" ");
            }
            System.out.println("===== ");
        }

    }
}
