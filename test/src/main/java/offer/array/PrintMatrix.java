package offer.array;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵：
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer> ();
        if(matrix.length==0)
            return result;
        int rows = matrix.length,cols = matrix[0].length;
        if(cols==0) return result;
        int layers = (Math.min(rows,cols)-1)/2+1;
        for(int i=0;i<layers;i++){
            for(int k = i;k<cols-i;k++) result.add(matrix[i][k]);
            for(int j=i+1;j<rows-i;j++) result.add(matrix[j][cols-i-1]);
            for(int k=cols-i-2;(k>=i)&&(rows-i-1!=i);k--) result.add(matrix[rows-i-1][k]);
            for(int j=rows-i-2;(j>i)&&(cols-i-1!=i);j--) result.add(matrix[j][i]);
        }
        return result;
    }
}
