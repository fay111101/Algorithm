package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;

/* Given an array S of n integers, are there elements a, b, c in S such that a +
 b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

    Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
    The solution set must not contain duplicate triplets.


    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/
public class Sum3 {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        Arrays.sort(num);
        for(int k=0;k<num.length;k++){
            int target=0-num[k];
            int i=k+1,j=num.length-1;
            if (k != 0 && num[k] == num[k - 1]) {
                continue;
            }
            while(i<j){
                if((num[i]+num[j])==target){
                    ArrayList<Integer> res=new ArrayList<>();
                    res.add(num[k]);
                    res.add(num[i]);
                    res.add(num[j]);
                    result.add(res);
                    while(i<j&&num[i]==num[i+1]){
                        i++;
                    }
                    while(i<j&&num[j]==num[j-1]){
                        j--;
                    }
                    i++;
                    j--;
                }else if((num[i]+num[j])<target){
                    i++;
                }else{
                    j--;
                }

            }

        }
        return  result;
    }
    public static void main(String[] args){
        Sum3 test=new Sum3();
        int[] num={-1, 0 ,1 ,2 ,-1 ,-4};
        int[] num1={0,0,0,0};
        int[] num2={-2,0,1,1,2};
        ArrayList<ArrayList<Integer>> result=test.threeSum(num);
        /*for(ArrayList<Integer> res:result){
            for(int a:res){
                System.out.print(a);
            }
            System.out.println();
        }*/
        ArrayList<ArrayList<Integer>> result1=test.threeSum(num2);
        for(ArrayList<Integer> res:result1){
            for(int a:res){
                System.out.print(a);
            }
            System.out.println();
        }
    }
}
