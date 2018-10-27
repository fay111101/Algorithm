package leetcode.dfsbfsbacktracing;

/**
 *  Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 For example,
 Given board =

 [
 ["ABCE"],
 ["SFCS"],
 ["ADEE"]
 ]

 word ="ABCCED", -> returnstrue,
 word ="SEE", -> returnstrue,
 word ="ABCB", -> returnsfalse.
 给定一个二维网格和一个单词，找出该单词是否存在于网格中。

 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

 示例:

 board =
 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]

 给定 word = "ABCCED", 返回 true.
 给定 word = "SEE", 返回 true.
 给定 word = "ABCB", 返回 false.

 */
public class _79_WordSearch {

    public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0||board[0].length==0){
            return false;
        }
        int m=board.length;
        int n=board[0].length;
        boolean visited[][]=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(search(board,word,i,j,0,visited)==true){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean search(char[][] board,String word,int i,int j,int index,boolean[][] visited){
        if(index==word.length()){
            return true;
        }
        if(i<0||j<0||i>=board.length||j>=board[0].length||visited[i][j]||board[i][j]!=word.charAt(index)){
            return false;
        }
        visited[i][j]=true;
        boolean res=search(board,word,i-1,j,index+1,visited)||
                search(board,word,i+1,j,index+1,visited)||
                search(board,word,i,j-1,index+1,visited)||
                search(board,word,i,j+1,index+1,visited);
        visited[i][j]=false;
        return res;
    }
}
