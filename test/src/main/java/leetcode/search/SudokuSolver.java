package leetcode.search;

/*Write a program to solve a Sudoku puzzle by filling the empty cells.
Empty cells are indicated by the character'.'.
You may assume that there will be only one unique solution.*/
public class SudokuSolver {
    public void solveSudoku1(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        solveSudokuDFS(board, 0, 0);

    }
    //Bug
    private boolean solveSudokuDFS(char[][] board, int i, int j) {
        if (i == 9) {
            return true;
        }
        if (j >= 9) {
            solveSudokuDFS(board, i + 1, 0);
        }

        if (board[i][j] == '.') {
            for (int k = 1; k <= 9; k++) {
                board[i][j] = (char) (k - '0');
                if (isValidSudoku(board, i, j)) {
                    if (solveSudokuDFS(board, i, j + 1)) {
                        return true;
                    }
                }
                board[i][j] = '.';

            }
        } else {
            return solveSudokuDFS(board, i, j + 1);
        }
        return false;
    }

    private boolean isValidSudoku(char[][] board, int i, int j) {
        for (int row = 0; row < 9; row++) {
            if (row != i && board[row][j] == board[i][j]) {
                return false;
            }
        }
        for (int col = 0; col < 9; col++) {
            if (col != j && board[i][col] == board[i][j]) {
                return false;
            }
        }
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) {
            for (int col = j /3 * 3; col < j /3 * 3 + 3; col++) {
                if ((row != i || col != j) && board[i][j] == board[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void solveSudoku(char[][] board) {
        if(board==null ||board.length ==0)
            return;
        else
            solve(board);
    }

    private static boolean solve(char[][] board) {
        for(int i = 0 ; i < 9;i++){
            for(int j = 0 ; j < 9;j++){
                if(board[i][j]=='.'){
                    for(char c = '1'; c<='9';c++){
                        if(isValid(board,i,j,c)){
                            board[i][j]=c;
                            if(solve(board))
                                return true;
                            else
                                board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int column, char c) {
        for(int i = 0 ; i < 9; i ++){
            if(board[row][i]==c) return false;
            if(board[i][column]==c) return false;
            if(board[3 * (row / 3) + i / 3][ 3 * (column / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (column / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }

    public static void main(String[] args) {
        SudokuSolver test = new SudokuSolver();
        String[] str = {"..9748...", "7........", ".2.1.9...", "..7...24.",
                ".64.1.59.", ".98...3..", "...8.3.2.", "........6", "...2759.."};
        char[][] c = new char[9][9];
        for (int i = 0; i < 9; i++) {
            c[i] = str[i].toCharArray();
        }
        test.solveSudoku1(c);
    }
}
