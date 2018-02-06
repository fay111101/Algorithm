package main.java.leetcode.dfsbacktracing;

import java.util.ArrayList;

/**
 *
 The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



 Given an integer n, return all distinct solutions to the n-queens puzzle.

 Each solution contains a distinct board configuration of the n-queens' placement, where'Q'and'.'both indicate a queen and an empty space respectively.

 For example,
 There exist two distinct solutions to the 4-queens puzzle:

 [
 [".Q..",  // Solution 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // Solution 2
 "Q...",
 "...Q",
 ".Q.."]
 ]

 */
public class NQueens {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> res = new ArrayList<String[]>();
        helper(n, 0, new int[n], res);//利用一个数组保存Q的位置信息，数组下标表示行，数组元素表示放置Q的列
        return res;
    }
    private void helper(int n, int row, int[]pos, ArrayList<String[]> res) {
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
            res.add(item);
            return;
        }
        for (int i = 0; i < n; i++) {
            pos[row] = i;
            if (check(row, pos)) {
                //pos[row]=i;
                helper(n, row + 1, pos, res);
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
