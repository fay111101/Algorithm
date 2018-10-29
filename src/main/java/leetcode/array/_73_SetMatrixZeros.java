package leetcode.array;

/**
 * Created by fay on 2017/12/11.
 * http://m.blog.csdn.net/lemon_tree12138/article/details/51176153
 * https://segmentfault.com/a/1190000010153571
 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。

 示例 1:

 输入:
 [
 [1,1,1],
 [1,0,1],
 [1,1,1]
 ]
 输出:
 [
 [1,0,1],
 [0,0,0],
 [1,0,1]
 ]
 示例 2:

 输入:
 [
 [0,1,2,0],
 [3,4,5,2],
 [1,3,1,5]
 ]
 输出:
 [
 [0,0,0,0],
 [0,4,5,0],
 [0,3,1,0]
 ]
 进阶:

 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 你能想出一个常数空间的解决方案吗？
 */
public class _73_SetMatrixZeros {

    public void setZeroes(int[][] matrix) {
        int rawLength = matrix.length;
        int colLength = matrix[0].length;
        boolean[] rawFlags = new boolean[rawLength];
        boolean[] colFlags = new boolean[colLength];
        for (int i = 0; i < rawLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (matrix[i][j] == 0) {
                    rawFlags[i] = true;
                    colFlags[j] = true;
                }
            }
        }

        // 调整每一行置0
        for (int i = 0; i < rawLength; i++) {
            if (rawFlags[i]) {
                for (int j = 0; j < colLength; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 调整每一列置0
        for (int i = 0; i < colLength; i++) {
            if (colFlags[i]) {
                for (int j = 0; j < rawLength; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
    public void setZeroes1(int[][] matrix) {
        if(matrix==null||matrix[0]==null){
            return;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        boolean rowZero=false,colZero=false;
        for(int i=0;i<m;i++){
            if(matrix[i][0]==0){
                colZero=true;
            }
        }
        for(int i=0;i<n;i++){
            if(matrix[0][i]==0){
                rowZero=true;
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[0][j]==0||matrix[i][0]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(rowZero){
            for(int i=0;i<n;i++){
                matrix[0][i]=0;
            }
        }
        if(colZero){
            for(int i=0;i<m;i++){
                matrix[i][0]=0;
            }
        }
    }
}
