package leetcode.dpandgreedy;

/**
 * Created by fay on 2017/12/14.
 *
 Follow up for "Unique Paths":
 Now consider if some obstacles are added to the grids. How many unique paths would there be?
 An obstacle and empty space is marked as1and0respectively in the grid.
 For example,
 There is one obstacle in the middle of a 3x3 grid as illustrated below.
 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 网格中的障碍物和空位置分别用 1 和 0 来表示。
 The total number of unique paths is 2.
 Note: m and n will be at most 100.
 3x3 网格的正中间有一个障碍物。
 从左上角到右下角一共有 2 条不同的路径：
 1. 向右 -> 向右 -> 向下 -> 向下
 2. 向下 -> 向下 -> 向右 -> 向右
 */
public class _63_UniquePaths2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid[0].length;
        int m=obstacleGrid.length;
        int[] dp=new int[n];
        dp[0]=1;
        if(obstacleGrid[0][0]==1){
            return 0;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    dp[j]=0;
                }else if(j>0){
                    dp[j]+=dp[j-1];
                }
            }
        }
        return dp[n-1];
    }

    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        if(obstacleGrid==null || obstacleGrid.length==0)
            return 0;
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n]; //dp[i][j]表示从start到[i,j]位置不同路径条
        // 不需要初始化，默认初始化。
        //for(int i=0;i<m;i++)
        // for(int j=0;j<n;j++)
        //dp[i][j]=0;
        for(int i=0;i<n;i++)   //第一行障碍处理
        {
            if(obstacleGrid[0][i]!=1)
                dp[0][i]=1;
            else
                break;
        }

        for(int j=0;j<m;j++)   //第一列障碍处理
        {
            if(obstacleGrid[j][0]!=1)
                dp[j][0]=1;
            else
                break;
        }
        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++)
            {
                if(obstacleGrid[i][j]==1)   //如果该位置是障碍，则到达该点的路径条数为0
                    dp[i][j]=0;
                else
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        return dp[m-1][n-1];
    }
}
