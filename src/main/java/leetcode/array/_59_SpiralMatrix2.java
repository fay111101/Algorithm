package leetcode.array;

/**
 * Created by fay on 2017/12/8.
 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

 示例:

 输入: 3
 输出:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]
 * ]
 */
public class _59_SpiralMatrix2 {

    public int[][] generateMatrix(int n) {
        int[][] m = new int[n][n];
        int value = 1;
        for (int round = 0; round < n / 2 + n % 2; round++) {
            for (int i = round; i < n - round; i++) m[round][i] = value++;
            for (int i = round + 1; i < n - round; i++) m[i][n - round - 1] = value++;
            for (int i = n - round - 2; i >= round; i--) m[n - round - 1][i] = value++;
            for (int i = n - round - 2; i >= round + 1; i--) m[i][round] = value++;
        }
        return m;

    }


    public int[][] generateMatrix1(int n) {

        int top = 0;
        int left = 0;
        int bottom = n - 1;
        int right = n - 1;
        int[][] m=new int[n][n];
        int value=1;

        while(true) {
            for(int i = left;i <= right;i++) m[top][i]=value++;
            top++;
            if(top > bottom) break;

            for(int i = top;i <= bottom;i++) m[i][right]=value++;
            right--;
            if(left > right) break;

            for(int i=right;i >= left;i--) m[bottom][i]=value++;
            bottom--;
            if( top > bottom) break;

            for(int i = bottom;i >= top;i--) m[i][left]=value++;
            left++;
            if(left > right ) break;
        }
        return m;
    }
}
