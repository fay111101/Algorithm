package leetcode.search;

import leetcode.stack.ValidParentheses;

import java.util.HashSet;
import java.util.Set;

/*
https://www.cnblogs.com/ganganloveu/p/4170632.html
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with
 the character'.'. */
public class ValidSudoku {

    /*
     * 题意：让你判断这是否是一个正确的数独，
     * 即确定每一行，每一列以及每一个九宫格是否有相同的数字
     * HashSet的add方法，当添加成功（即set中不含有该元素）返回true
     */
    public boolean isValidSudoku(char[][] board) {
        // 每一个大循环确定一行，一列，一个九宫格
        for (int i = 0; i < 9; i++) {
            Set<Character> row = new HashSet<Character>();
            Set<Character> col = new HashSet<Character>();
            Set<Character> cube = new HashSet<Character>();

            for (int j = 0; j < 9; j++) {
                // 第i行
                if (board[i][j] != '.' && !row.add(board[i][j]))
                    return false;
                // 第i列
                if (board[j][i] != '.' && !col.add(board[j][i]))
                    return false;
                //理解不了
                int cubeRow = 3 * (i / 3) + j / 3, cubeCol = 3 * (i % 3) + j
                        % 3;
                if (board[cubeRow][cubeCol] != '.' && !cube.add
                        (board[cubeRow][cubeCol]))
                    return false;
            }
        }
        return true;
    }
    public boolean isValidSudoku1(char[][] board) {
        HashSet<Character> set = new HashSet<Character>();
        // Check for each row
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                if (set.contains(board[i][j]))
                    return false;
                set.add(board[i][j]);
            }
            set.clear();
        }

        // Check for each column
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                if (board[i][j] == '.')
                    continue;
                if (set.contains(board[i][j]))
                    return false;
                set.add(board[i][j]);
            }
            set.clear();
        }

        // Check for each sub-grid
        for (int k = 0; k < 9; k++) {
            for (int i = k/3*3; i < k/3*3+3; i++) {
                for (int j = (k%3)*3; j < (k%3)*3+3; j++) {
                    if (board[i][j] == '.')
                        continue;
                    if (set.contains(board[i][j]))
                        return false;
                    set.add(board[i][j]);
                }
            }
            set.clear();
        }

        return true;
    }

}
