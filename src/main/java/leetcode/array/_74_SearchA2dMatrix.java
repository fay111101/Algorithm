package leetcode.array;

/**
 * Created by fay on 2017/12/8.
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.

 For example,
 Consider the following matrix:
 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target =3, returntrue.
 */
public class _74_SearchA2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0]==null||matrix[0].length==0){
            return false;
        }
        int len=matrix.length-1;
        int i=0;
        while((i<matrix[0].length)&&(len>=0)){
            if(matrix[len][i]<target){
                i++;
            }else if(matrix[len][i]>target){
                len--;
            }else{
                return true;
            }
        }
        return false;
    }
}
