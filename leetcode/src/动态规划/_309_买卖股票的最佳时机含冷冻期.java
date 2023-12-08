package 动态规划;

public class _309_买卖股票的最佳时机含冷冻期 {
    public int maxProfit(int[] prices) {
        if(prices.length == 1){
            return 0;
        }
        int[][] dp = new int[prices.length + 1][2];
        dp[1][0] = 0;
        dp[1][1] = -prices[0];

        for(int i = 2; i <= prices.length; i++){
            dp[i][0] = Math.max(dp[i-1][1] + prices[i-1], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i-2][0] - prices[i-1], dp[i-1][1]);
        }
        return dp[prices.length][0];
    }
}
