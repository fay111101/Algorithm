package offer.array;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 输出描述:
 对应每个测试案例，输出两个数，小的先输出。
 */
public class _41_FindNumbersWithSum {

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res=new ArrayList<>();
        if(array==null){
            return res;
        }
        int i=0;
        int j=array.length-1;
        int currSum=0;
        while(i<j){
            currSum=array[i]+array[j];
            if(currSum==sum){
                res.add(array[i]);
                res.add(array[j]);
            }
            if(currSum<sum){
                i++;
            }else {
                j--;
            }
            if(res.size()==2){
                return res;
            }
        }
        return res;
    }
}
