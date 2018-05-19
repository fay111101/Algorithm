package leetcode.array;

import java.util.Arrays;

/* Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3→1,3,2
3,2,1→1,2,3
1,1,5→1,5,1
参考：
http://blog.csdn.net/chilseasai/article/details/48163333

*/
public class NextPermutation {
    public void nextPermutation(int[] num) {
        int n=num.length;
        int i,j;
        for(i=n-2;i>=0;i--){
            if(num[i+1]>num[i]){
                for(j=n-1;j>=i;j--){
                    if(num[j]>num[i]){
                        break;
                    }
                }
                int temp=num[i];
                num[i]=num[j];
                num[j]=temp;
                Arrays.sort(num,i+1,n);
                return;
            }
        }
        Arrays.sort(num);
    }
    public static void main(String[] args){
        NextPermutation test=new NextPermutation();
        int[] num={1,0,2,3,1};
        test.nextPermutation(num);
        for(int i:num){
            System.out.println(i);
        }
    }
}
