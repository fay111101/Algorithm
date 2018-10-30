package leetcode.array;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。

 将图像顺时针旋转 90 度。

 说明：

 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

 示例 1:

 给定 matrix =
 [
 [1,2,3],
 [4,5,6],
 [7,8,9]
 ],

 原地旋转输入矩阵，使其变为:
 [
 [7,4,1],
 [8,5,2],
 [9,6,3]
 ]
 示例 2:

 给定 matrix =
 [
 [ 5, 1, 9,11],
 [ 2, 4, 8,10],
 [13, 3, 6, 7],
 [15,14,12,16]
 ],

 原地旋转输入矩阵，使其变为:
 [
 [15,13, 2, 5],
 [14, 3, 4, 1],
 [12, 6, 8, 9],
 [16, 7,10,11]
 ]
 */

public class _48_RotateImage {

    public void rotate(int[][] matrix) {
        int n=matrix[0].length,temp;
        // 沿着副对角线反转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n - i; ++j) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
                matrix[n - 1 - j][n - 1 - i] = temp;
            }
        }
        // 沿着水平中线反转
        for (int i = 0; i < n / 2; ++i){
            for (int j = 0; j < n; ++j) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }
    }


    public void rotate1(int[][] matrix) {
        int x = matrix[0].length;
        int y = matrix.length;
        //上下反转
        for(int i = 0 ; i < y/2 ; i++){
            for(int j = 0 ; j < x ; j ++){
                swap(matrix, i, j, y-i-1, j);
            }
        }
        //对角线反转
        for(int i = 0 ; i < x ; i++){
            for(int j = i+1 ; j < y ; j++){
                swap(matrix, i, j, j, i);
            }
        }


    }

    private void swap (int[][] m, int ax, int ay, int bx, int by) {
        int temp = m[ax][ay];
        m[ax][ay] = m[bx][by];
        m[bx][by] = temp;
    }
}
