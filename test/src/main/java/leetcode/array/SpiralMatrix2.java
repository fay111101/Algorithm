package leetcode.array;

/**
 * Created by fay on 2017/12/8.
 * <p>
 * Given an integer n, generate a square matrix filled with elements from 1 to n 2 in spiral order.
 * For example,
 * Given n =3,
 * You should return the following matrix:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class SpiralMatrix2 {
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
}
