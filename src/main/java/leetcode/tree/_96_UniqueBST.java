package leetcode.tree;

/**
 * Created by fay on 2017/12/5.
 * 参考解题:http://shmilyaw-hotmail-com.iteye.com/blog/2305097
 Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 For example,
 Given n = 3, there are a total of 5 unique BST's.
 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3

 我设dp[i]表示共有i个节点时，能产生的BST树的个数
 n == 0 时，空树的个数必然为1，因此dp[0] = 1
 n == 1 时，只有1这个根节点，数量也为1，因此dp[1] = 1
 n == 2时，有两种构造方法
 因此，dp[2] = dp[0] * dp[1] + dp[1] * dp[0]
 n == 3时，构造方法如题目给的示例所示，dp[3] = dp[0] * dp[2] + dp[1] * dp[1] + dp[2] * dp[0]
 同时，当根节点元素为 1, 2, 3, 4, 5, ..., i, ..., n时，基于以下原则的BST树具有唯一性：
 以i为根节点时，其左子树构成为[0,...,i-1],其右子树构成为[i+1,...,n]构成
 因此，dp[i] = sigma（dp[0...k] * dp[k+1...i]） 0 <= k < i - 1

 给出的n代表有n个节点，1,2,3,4,5，……n，这些节点组成的不同形态的二叉查找树，是说中序遍历这些树，得到的序列就是 1,2,3,4,5，……n。
 根据二叉查找树可以知道，某根节点x，它的左子树的值全<=x（当然本题不存在等于的情况），它的右子树的值全>=x，所以，
 当它的根节点是 1 的时候，左子树个数为 0 ，右子树的个数为 n-1， 当它的根节点为 2 的时候， 左子树个数为 1， 右子树的个数为 n-2……
 还有一个规律，就是这棵树的不同形态的二叉查找树的个数，就是根节点的  左子树的个数*右子树的个数，想想还是很容易理解的，
 就是左边的所有情况乘以右边的所有情况，知道这个规律就好做啦。
 动态规划，从前到后计算出当有i个节点时,它有多少种不同形态的树。nums[i] += nums[j] * nums[i-1-j] 
 （初始j==0，每做完一步j++）。（这里i-1-j 减掉的 1 代表是根节点占了一个位置）
 */
public class _96_UniqueBST {

    public int numTrees(int n) {
        if(n<0){
            return -1;
        }
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
}
