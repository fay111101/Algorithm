package main.java.leetcode.dfsbacktracing;

/**
 * Follow up for N-Queens problem.

 Now, instead outputting board configurations, return the total number of distinct solutions.


 */
public class NQueens2 {
    int total=0;
    public int totalNQueens(int n) {
        backtracking(n, 0, new int[n]);//利用一个数组保存Q的位置信息，数组下标表示行，数组元素表示放置Q的列
        return total;
    }
    private void backtracking(int n, int row, int[]pos) {
        if (row == n) {//row=n表示已经找到了数组，将数组转化为结果即可。
            String[] item = new String[n];
            for (int i = 0; i < n; i++) {
                StringBuilder strRow = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (pos[i] == j)//在数组记录的位置上写入Q
                        strRow.append('Q');
                    else
                        strRow.append('.');//在其他所有位置上写入.
                }
                item[i] = strRow.toString();
            }
            total++;
            return;
        }
        for (int i = 0; i < n; i++) {
            pos[row] = i;
            if (check(row, pos)) {
                //pos[row]=i;
                backtracking(n, row + 1, pos);
                //pos[row]=-1;
            }
        }
    }
    private boolean check(int row, int[] pos) {
        for (int i = 0; i < row; i++) {
            if (pos[row] == pos[i] || Math.abs(pos[row] - pos[i]) == row - i)
                return false;
        }
        return true;
    }

}
