package leetcode.array;

import java.util.ArrayList;

/**
 * Created by fay on 2017/12/8.
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 For example,
 Given the following matrix:
 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 You should return[1,2,3,6,9,8,7,4,5].
 */
public class SpiralMatrix {

    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer> ();
        if(matrix.length==0)
            return result;
        int rows = matrix.length,cols = matrix[0].length;
        if(cols==0) return result;
        int layers = (Math.min(rows,cols)-1)/2+1;
        for(int i=0;i<layers;i++){
            for(int k = i;k<cols-i;k++) result.add(matrix[i][k]);
            for(int j=i+1;j<rows-i;j++) result.add(matrix[j][cols-i-1]);
            for(int k=cols-i-2;(k>=i);k--) result.add(matrix[rows-i-1][k]);
            for(int j=rows-i-2;(j>i);j--) result.add(matrix[j][i]);
        }
        return result;
    }
}
