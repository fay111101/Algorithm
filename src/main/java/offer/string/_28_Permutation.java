package offer.string;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class _28_Permutation {


    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<String>();
        if (str == null || str.length() == 0) {
            return res;
        }
        Permutation(str.toCharArray(), 0, res);
        Collections.sort(res);
        return res;
    }

    /**
     * 对于字符串的排列问题：
     * 如果能生成n-1个元素的全排列，就能生成n个元素的全排列。对于只有一个元素的集合，可以直接生成全排列。所以全排列的递归终止条件很明确，
     * 只有一个元素时。我们可以分析一下全排列的过程：
     * 首先，我们固定第一个字符a，求后面两个字符bc的排列
     * 当两个字符bc排列求好之后，我们把第一个字符a和后面的b交换，得到bac，接着我们固定第一个字符b，求后面两个字符ac的排列
     * 现在是把c放在第一个位置的时候了，但是记住前面我们已经把原先的第一个字符a和后面的b做了交换，为了保证这次c仍是和原先处在第一个位置的a交换，
     * 我们在拿c和第一个字符交换之前，先要把b和a交换回来。在交换b和a之后，再拿c和处于第一位置的a进行交换，得到cba。我们再次固定第一个字符c，
     * 求后面两个字符b、a的排列既然我们已经知道怎么求三个字符的排列，那么固定第一个字符之后求后面两个字符的排列，就是典型的递归思路了
     *
     * @param arr
     * @param i
     * @param res
     */
    public void Permutation(char[] arr, int i, ArrayList<String> res) {
        if (i == arr.length - 1) {
            res.add(String.valueOf(arr));
        } else {
            for (int j = i; j < arr.length; j++) {
                if ((arr[j] == arr[i]) && (j != i)) {
                    continue;
                } else {
                    swap(arr, i, j);
                    Permutation(arr, i + 1, res);
                    swap(arr, i, j);
                }
            }
        }
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}
