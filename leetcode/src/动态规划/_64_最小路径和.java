package 动态规划;

public class _64_最小路径和 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // if(m == 1 && n == 1){
        //     return grid[0][0];
        // }
        //dp[i][j]表示第i，j数字最小路径总和。
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < m; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int j = 1; j < n; j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }

    public int minPathSum2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        //到达:i,j位置时的路径上数字总和最小的值
        int[] dp = new int[n];
        //初始化
        dp[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i] = grid[0][i] + dp[i-1];
        }

        for (int i = 1; i < m; i++) {
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = grid[i][j] + Math.min(dp[j - 1], dp[j]);
            }
        }
        return dp[n - 1];
    }
}
