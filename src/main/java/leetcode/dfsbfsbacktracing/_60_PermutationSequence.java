package leetcode.dfsbfsbacktracing;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。

 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 给定 n 和 k，返回第 k 个排列。

 说明：

 给定 n 的范围是 [1, 9]。
 给定 k 的范围是[1,  n!]。
 示例 1:

 输入: n = 3, k = 3
 输出: "213"
 示例 2:

 输入: n = 4, k = 9
 输出: "2314"
 */
public class _60_PermutationSequence {
    //
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
