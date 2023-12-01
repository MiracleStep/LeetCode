package 动态规划;

public class _122_买卖股票的最佳时机II {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //dp表示i天结束后，手上股票的状态为j时的最大利润。
        int[][] dp = new int[n][2];
        //初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < n; i++){
            //今天结束后也没有：1.昨天就没有(昨天没有，今天买了又买了)。2.今天卖了
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            //今天结束后还有股票：1.昨天就有 2.今天刚买了。dp[i-1][0] - prices[i]可以确保买多次(同时约束昨天必须没有股票今天才能买)。
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[n-1][0];
    }
}
