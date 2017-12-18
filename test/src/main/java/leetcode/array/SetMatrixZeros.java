package leetcode.array;

/**
 * Created by fay on 2017/12/11.
 * http://m.blog.csdn.net/lemon_tree12138/article/details/51176153
 * https://segmentfault.com/a/1190000010153571
 Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 click to show follow up.
 Follow up:
 Did you use extra space?
 A straight forward solution using O(m n) space is probably a bad idea.
 A simple improvement uses O(m + n) space, but still not the best solution.
 Could you devise a constant space solution?
 */
public class SetMatrixZeros {
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
