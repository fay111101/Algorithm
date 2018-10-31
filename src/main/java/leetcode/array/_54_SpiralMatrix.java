package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fay on 2017/12/8.
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7
 */
public class _54_SpiralMatrix {
    /**
     * 输入
     [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     输出
     [1,2,3,4,8,12,11,10,9,5,6,7,6]
     预期结果
     [1,2,3,4,8,12,11,10,9,5,6,7]
     如果不判断边界会出现重复打印的情况！！
     * @param matrix
     * @return
     */

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0)
            return res;
        int rows = matrix.length;
        int cols = matrix[0].length;
        // 此种方法关键点--求圈数
        // 最小值除以2，向上取整
        // int layers = (Math.min(rows, cols) - 1) / 2 + 1;
        int layers = (int) Math.ceil
                ((Math.min(rows, cols)) / 2.0);
        // 要打印的圈数
        for (int i = 0; i < layers; i++) {
            // 打印每圈
            // 左至右
            for (int k = i; k < cols - i; k++)
                res.add(matrix[i][k]);
            // 右上至右下
            for (int j = i + 1; j < rows - i; j++)
                res.add(matrix[j][cols - i - 1]);
            // 注意k,j开始的下标
            // 右至左
            // (rows - i - 1 != i)避免重复打印第i行
            for (int k = cols - i - 2; (k >= i)
                    && (rows - i - 1 != i); k--)
                res.add(matrix[rows - i - 1][k]);
            // 左下至左上
            // (cols - i - 1 != i)避免重复打印第i列
            for (int j = rows - i - 2; (j > i)
                    && (cols - i - 1 != i); j--)
                res.add(matrix[j][i]);
        }
        return res;
    }
    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();

        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;    //2
        int right = matrix[0].length - 1;    //3

        while(true) {
            for(int i = left;i <= right;i++) res.add(matrix[top][i]);
            top++;
            if(top > bottom) break;

            for(int i = top;i <= bottom;i++) res.add(matrix[i][right]);
            right--;
            if(left > right) break;

            for(int i=right;i >= left;i--) res.add(matrix[bottom][i]);
            bottom--;
            if( top > bottom) break;

            for(int i = bottom;i >= top;i--) res.add(matrix[i][left]);
            left++;
            if(left > right ) break;
        }
        return res;
    }


    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix.length == 0)
            return result;
        int rows = matrix.length, cols = matrix[0].length;
        if (cols == 0) return result;
        int layers = (Math.min(rows, cols) - 1) / 2 + 1;
        for (int i = 0; i < layers; i++) {
            for (int k = i; k < cols - i; k++) result.add(matrix[i][k]);
            for (int j = i + 1; j < rows - i; j++) result.add(matrix[j][cols - i - 1]);
            for (int k = cols - i - 2; (k >= i); k--) result.add(matrix[rows - i - 1][k]);
            for (int j = rows - i - 2; (j > i); j--) result.add(matrix[j][i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] matrix1={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] matrix2={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        _54_SpiralMatrix test=new _54_SpiralMatrix();
        List<Integer> res=test.spiralOrder2(matrix);
        List<Integer> res1=test.spiralOrder2(matrix1);
        List<Integer> res2=test.spiralOrder2(matrix2);
        for(int a:res1){
            System.out.println(a);
        }
    }
}
