package 动态规划;

public class _121_买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //dp表示第i天结束后手上股票状态为j时能获取的最大利润(手上的现金数(初始为0))
        int[][] dp = new int[n][2];
        //初始化:不持股，显然为0.若持股，则手上的现金数-股票价格。
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < n; i++){
            //今天没有持股：1.昨天也没有持股 2.今天把股票卖了
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            //今天持股了：1.昨天也持股了 2.今天刚买的股票(这里使用-prices[i],而不是dp[i-1][0]-prices，是为了确保只买一次)
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return dp[n-1][0];
    }
}
