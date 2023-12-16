package 动态规划;

public class _188_买卖股票的最佳时机IV {
    public int maxProfit(int k, int[] prices) {
        //定义状态：dp 的i表示截止到表示在[0, i] 区间里（状态具有前缀性质），交易进行了 j 次，并且状态为 k 时我们拥有的现金数。
        int[][][] dp = new int[prices.length][k + 1][2];
        if (prices.length < 2) {
            return 0;
        }
        dp[0][1][1] = -prices[0];
        for (int i = 2; i <= k; i++) {
            dp[0][i][1] = Integer.MIN_VALUE;
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
            }
        }
        int res = 0;
        for (int i = 1; i <= k; i++) {
            res = Math.max(dp[prices.length - 1][i][0], res);
        }
        return res;
    }
}
