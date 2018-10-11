package offer.array;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵：
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class _20_PrintMatrix {

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

    ArrayList<Integer> result = new ArrayList<Integer> ();
    void PrintMatrixClockwisely(int[][] numbers, int columns, int rows)
    {
        if(numbers == null || columns <= 0 || rows <= 0)
            return;

        int start = 0;

        while(columns > start * 2 && rows > start * 2)
        {
            PrintMatrixInCircle(numbers, columns, rows, start);

            ++start;
        }
    }

    void PrintMatrixInCircle(int[][] numbers, int columns, int rows, int start)
    {
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;

        // 从左到右打印一行
        for(int i = start; i <= endX; ++i)
        {
            int number = numbers[start][i];
            result.add(number);
        }

        // 从上到下打印一列
        if(start < endY)
        {
            for(int i = start + 1; i <= endY; ++i)
            {
                int number = numbers[i][endX];
                result.add(number);
            }
        }

        // 从右到左打印一行
        if(start < endX && start < endY)
        {
            for(int i = endX - 1; i >= start; --i)
            {
                int number = numbers[endY][i];
                result.add(number);
            }
        }

        // 从下到上打印一行
        if(start < endX && start < endY - 1)
        {
            for(int i = endY - 1; i >= start + 1; --i)
            {
                int number = numbers[i][start];
                result.add(number);
            }
        }
    }

}
