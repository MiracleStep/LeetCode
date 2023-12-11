package 动态规划;

public class _343_整数拆分 {
    public int integerBreak(int n) {
        //拆分正整数 i，得到的最大乘积是 dp[i]
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i <= n; i++){
            for(int j = 1; j <= i-1; j++){
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }
        return dp[n];
    }
}
