package leetcode.dfsbfsbacktracing;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * <p>
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 * <p>
 * 输入: n = 4, k = 9
 * 输出: "2314"
 */
public class _60_PermutationSequence {
    /**
     * n个数的permutation总共有n阶乘个，基于这个性质我们可以得到某一位对应的数字是哪一个。
     * 思路是这样的，比如当前长度是n，我们知道每个相同的起始元素对应(n-1)!个permutation，
     * 也就是(n-1)!个permutation后会换一个起始元素。因此，只要当前的k进行(n-1)!取余，
     * 得到的数字就是当前剩余数组的index，如此就可以得到对应的元素。如此递推直到数组中没有元素结束。
     * 实现中我们要维护一个数组来记录当前的元素，每次得到一个元素加入结果数组，然后从剩余数组中移除，
     * 因此空间复杂度是O(n)。时间上总共需要n个回合，而每次删除元素如果是用数组需要O(n),所以总共是O(n^2)。
     *
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        k--; // to translate index from 0 rather than 1
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int factorial = 1;
        for (int i = 2; i < n; i++) {
            factorial *= i;
        }
        int round = n - 1;
        StringBuilder sb = new StringBuilder();
        while (round >= 0) {
            sb.append(list.remove(k / factorial));//new list
            k %= factorial;//new k
            if (round != 0) factorial /= round;//new factorial
            round--;// new round
        }
        return sb.toString();
    }

}
