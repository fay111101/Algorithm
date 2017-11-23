package leetcode.dpandgreedy;

import java.util.Arrays;

/*https://www.cnblogs.com/felixfang/p/3620086.html

There are N children standing in a line. Each child is assigned a
rating value.
You are giving candies to these children subjected to the following
requirements:
Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
注意：当相邻的两个孩子的rating相同时，位于前面的取得的苹果较多
*/
public class Candy {
    public int candy(int[] ratings){
        if(ratings==null||ratings.length==0){
            return 0;
        }
        int total=0;
        int[] nums=new int[ratings.length];
        Arrays.fill(nums,1);
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                nums[i]=nums[i-1]+1;
            }
        }
        for(int i=ratings.length-1;i>0;i--){
            if(ratings[i]<ratings[i-1]&&nums[i]>=nums[i-1]){
                nums[i-1]=nums[i]+1;
            }

        }
        for(int i:nums){
            total+=i;
        }
        return total;
    }
    public static void main(String[] args){
        int[] ratins={1,2,5,5,4,3};
        int[] ratins1={1,2};
        Candy test=new Candy();
        System.out.println(test.candy(ratins));
        System.out.println(test.candy(ratins1));
    }
}
