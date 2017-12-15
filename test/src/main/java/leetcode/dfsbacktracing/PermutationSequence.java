package leetcode.dfsbacktracing;

/**
 * Created by fay on 2017/12/15.
 *
 The set[1,2,3,…,n]contains a total of n! unique permutations.
 By listing and labeling all of the permutations in order,
 We get the following sequence (ie, for n = 3):
 "123"
 "132"
 "213"
 "231"
 "312"
 "321"

 Given n and k, return the k th permutation sequence.
 Note: Given n will be between 1 and 9 inclusive.
 */
public class PermutationSequence {
    //TODO
    public String getPermutation(int n, int k) {
        int[] perm = new int[n];
        int total = 1;
        for(int i=1;i<=n;i++){
            perm[i-1] = i;//这里边界出错了
            total *= i;
        }
        k %= total;
        if(k==0) k = total;
        int count = 0;
        while(true){
            count++;
            if(count==k) break;
            int i;
            for(i=n-1;i>0;i--){
                if(perm[i]>perm[i-1]){
                    int temp = perm[i-1];
                    int j;
                    for(j=n-1;j>i&&perm[j]<temp;j--);
                    perm[i-1] = perm[j];
                    perm[j] = temp;
                    break;
                }
            }
            for(int m=i,j=n-1;m<j;m++,j--){
                int temp = perm[j];
                perm[j] = perm[m];
                perm[m] = temp;
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int num:perm) sb.append(num);
        return sb.toString();
    }
}
