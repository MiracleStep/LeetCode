package 动态规划;

public class _123_买卖股票的最佳时机III {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len < 2){
            return 0;
        }
        //定义状态：dp的i表示截止到表示在[0, i] 区间里（状态具有前缀性质），交易进行了 j 次，并且状态为 k 时我们拥有的现金数。
        int[][][] dp = new int[len][3][2];
        //确定初始状态：
        //初始时买了股票，交易进行了一次
        dp[0][1][1] = -prices[0];
        //还没有发生交易，持股的时候应该初始化为负无穷。
        dp[0][2][1] = Integer.MIN_VALUE;
        //确定状态转移方程：状态的转移过程隐含着题目的限制条件。
        for(int i = 1; i < len; i++){
            //第一次交易，持股：之前持股、今天刚买入。
            dp[i][1][1] = Math.max(dp[i-1][1][1], dp[i-1][0][0] - prices[i]);
            //第一次交易，没有持股：之前没持股、今天刚卖出。
            dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i-1][1][1] + prices[i]);
            //第二次交易，持股：之前持股、今天刚买入(第一次交易卖出后)。
            dp[i][2][1] = Math.max(dp[i-1][2][1], dp[i-1][1][0] - prices[i]);//一开始有个初始化为负无穷避免该步出错
            //第二次交易，没有持股：之前没持股、今天刚卖出。
            dp[i][2][0] = Math.max(dp[i-1][2][0], dp[i-1][2][1] + prices[i]);
        }
        return Math.max(dp[len - 1][1][0], dp[len - 1][2][0]);
    }
}
