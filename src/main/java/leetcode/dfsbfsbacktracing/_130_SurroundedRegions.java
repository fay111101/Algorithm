package leetcode.dfsbfsbacktracing;

/**
 *
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。

 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

 示例:

 X X X X
 X O O X
 X X O X
 X O X X
 运行你的函数后，矩阵变为：

 X X X X
 X X X X
 X X X X
 X O X X
 解释:

 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 任何不在边界上，或不与边界上的 'O' 相连的 'O'
 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class _130_SurroundedRegions {

    int rowNum=0;
    int colNum=0;
    public void solve(char[][] board){
        if(board==null||board.length==0||board[0].length==0){
            return;
        }
        rowNum=board.length;
        colNum=board[0].length;
        //处理边界
        for(int i=0;i<colNum;i++){
            dfs(board,0,i);
            dfs(board,rowNum-1,i);
        }
        for(int j=0;j<rowNum;j++){
            dfs(board,j,0);
            dfs(board,j,colNum-1);
        }
        for(int i=0;i<rowNum;i++){
            for(int j=0;j<colNum;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }

            }
        }
        for(int i=0;i<rowNum;i++){
            for(int j=0;j<colNum;j++){
                if(board[i][j]=='*'){
                    board[i][j]='O';
                }
            }
        }

    }

    private void dfs(char[][] board, int row, int col) {
        if(board[row][col]=='O'){
            board[row][col]='*';
            if(row>1){
                dfs(board,row-1,col);
            }
            if(col>1){
                dfs(board,row,col-1);
            }
            if(row<rowNum-1){
                dfs(board,row+1,col);
            }
            if(col<colNum-1){
                dfs(board,row,col+1);
            }
        }
    }
    public static void main(String[] args){
        char[][] board={{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},
                {'X','O','X','X'}};
        _130_SurroundedRegions test=new _130_SurroundedRegions();
        test.solve(board);
    }
}
