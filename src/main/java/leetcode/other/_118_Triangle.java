package leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 *
 * For example, given numRows = 5,
 * Return
 *
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * [题目解析] 帕斯卡三角，又称杨辉三角，给一个行数，输出杨辉三角，
 * 需要结合杨辉三角的性质。我们主要根据这条性质来产生结果：
 * 每个数字等于上一行的左右两个数字之和。可用此性质写出整个杨辉三角。
 * 即第n+1行的第i个数等于第n行的第i-1个数和第i个数之和。
 */
public class _118_Triangle {
    public List<List<Integer>> generate(int numRows) {
        if(numRows < 0) return null;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i < numRows; i++){
            List<Integer> eachRow = new ArrayList<Integer>();
            eachRow.add(0, 1); //每一行的第一个元素为1
            for(int j = 1; j < i; j++){
                if(i-1 >= 0){
                    List<Integer> last = result.get(i-1);
                    int num = last.get(j-1) + last.get(j); //根据性质
                    eachRow.add(j, num);
                }

            }
            if(i > 0) eachRow.add(i, 1); //每一行的最后一个元素为1
            result.add(i,eachRow);
        }
        return result;
    }
}
